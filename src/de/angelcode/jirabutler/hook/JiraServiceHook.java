package de.angelcode.jirabutler.hook;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;

import org.json.JSONArray;
import org.json.JSONObject;

import de.angelcode.jirabutler.exceptions.JiraButlerException;

/**
 * This class parses the github HTTP-POST githubRequest for relevant payload
 * information like the username of the pusher, the commit gitCommitMessage and
 * so on...
 * 
 * @author bennyn
 */
public final class JiraServiceHook
{

  private String username;
  private String jiraProjectVersion;
  private String gitCommitMessage;
  private String jiraIssueKey;
  private String githubRequest;
  private JSONObject payloadJson;

  public JiraServiceHook()
  {
    super();
    this.username = null;
    this.jiraProjectVersion = null;
    this.gitCommitMessage = null;
    this.jiraIssueKey = null;
    this.githubRequest = null;
    this.payloadJson = null;
  }

  /**
   * Init-constructor which awaits the complete HTTP githubRequest from
   * github.
   *
   * @param githubRequest
   *            Complete githubRequest from github
   * @throws UnsupportedEncodingException
   * @throws ParseException
   * @throws IOException
   * @throws Exception
   */
  public JiraServiceHook(String githubRequest) throws JiraButlerException
  {
    this();
    this.githubRequest = githubRequest;
  }

  public void convertGithubRequestToJson() throws JiraButlerException
  {
    convertGithubRequestToJson(this.githubRequest);
  }

  /**
   * Converts the given github githubRequest into a JSON object.
   *
   * @param githubRequest
   *            Complete githubRequest from github
   * @throws JiraButlerException
   */
  public void convertGithubRequestToJson(String githubRequest)
          throws JiraButlerException
  {
    this.githubRequest = githubRequest;

    // Convert the payload from the github githubRequest into a JSON object
    int payloadStart = this.githubRequest.indexOf("payload=");
    String payloadAscii = this.githubRequest.substring(payloadStart + 8,
                                                       this.githubRequest.length());
    String payloadUnicode = null;

    try
    {
      payloadUnicode = URLDecoder.decode(payloadAscii, "UTF-8");
      this.payloadJson = new JSONObject(payloadUnicode);
    }
    catch (ParseException ex)
    {
      throw new JiraButlerException(
              "The JSON string could not be converted to a JSON object: "
              + ex.getLocalizedMessage());
    }
    catch (UnsupportedEncodingException ex)
    {
      throw new JiraButlerException(
              "The JSON object could not be converted from ASCII to UTF-8: "
              + ex.getLocalizedMessage());
    }
  }

  /**
   * Parse all relevant information from the JSON object.
   */
  public void parseGithubJson()
  {
    parseUsername();
    parseVersion();
    parseMessage();
  }

  private void parseUsername()
  {
    JSONObject pusher = this.payloadJson.getJSONObject("pusher");
    this.username = pusher.getString("name");
  }

  /**
   * Prints out every information which could be found in github's payload
   * sequence.
   *
   * @return payload information
   */
  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("Project version: ").append(this.jiraProjectVersion).append("\n");
    sb.append("JIRA Key: ").append(this.jiraIssueKey).append("\n");
    sb.append("User: ").append(this.username).append("\n");
    sb.append("Commit message: ").append(this.gitCommitMessage).append("\n");

    return sb.toString();
  }

  /**
   * Parses the name of the current Git branch (in which the changes are
   * pushed) and uses it as JIRA project jiraProjectVersion.
   *
   * @param jiraProjectVersion
   */
  private void parseVersion()
  {
    this.jiraProjectVersion = payloadJson.getString("ref");

    while (this.jiraProjectVersion.contains("/"))
    {
      int positionSlash = this.jiraProjectVersion.indexOf("/");
      this.jiraProjectVersion = this.jiraProjectVersion.substring(
              positionSlash + 1, this.jiraProjectVersion.length());
    }
  }

  /**
   * Parses the Git commit message for the JIRA issue key.
   *
   * @param gitCommitMessage
   */
  private void parseMessage()
  {
    JSONArray commitsArray = this.payloadJson.getJSONArray("commits");
    JSONObject commitsObject = (JSONObject) commitsArray.get(0);
    this.gitCommitMessage = commitsObject.getString("message");

    if (this.gitCommitMessage.contains("@"))
    {
      int positionAt = gitCommitMessage.indexOf('@');
      this.jiraIssueKey = gitCommitMessage.substring(0, positionAt);
      this.gitCommitMessage = gitCommitMessage.substring(positionAt + 1,
                                                         gitCommitMessage.length());
    }
  }

  public void setGithubRequest(String githubRequest)
  {
    this.githubRequest = githubRequest;
  }

  public String getGitCommitMessage()
  {
    return gitCommitMessage;
  }

  public String getJiraIssueKey()
  {
    return jiraIssueKey;
  }

  public String getJiraProjectVersion()
  {
    return jiraProjectVersion;
  }

  public String getUsername()
  {
    return username;
  }
}
