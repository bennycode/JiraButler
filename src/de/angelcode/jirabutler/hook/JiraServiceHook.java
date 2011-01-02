package de.angelcode.jirabutler.hook;

import de.angelcode.jirabutler.soap.JiraController;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This class parses the github HTTP-POST request for relevant payload information like the username of the pusher, the commit message and so on...
 * @author bennyn
 */
public final class JiraServiceHook
{

  private String username;
  private String version;
  private String message;
  private String jiraKey;
  private JSONObject payloadJson;

  public JiraServiceHook()
  {
    super();
    this.username = null;
    this.version = null;
    this.message = null;
    this.jiraKey = null;
    this.payloadJson = null;
  }


  public JiraServiceHook(String githubRequest) throws Exception

  /**
   * Init-constructor which awaits the complete HTTP request from github.
   * @param githubRequest
   * @throws UnsupportedEncodingException
   * @throws ParseException
   * @throws IOException
   * @throws Exception
   */
  {
    this();
    // Convert the payload from the github request into a JSON object
    int payloadStart = githubRequest.indexOf("payload=");
    String payloadAscii = githubRequest.substring(payloadStart + 8, githubRequest.length());
    String payloadUnicode = URLDecoder.decode(payloadAscii, "UTF-8");
    payloadJson = new JSONObject(payloadUnicode);

    // Parse all relevant information from the JSON object
    parseUsername();
    parseVersion();
    parseMessage();

    // Pass everything to the JIRA controller, so that it can be inserted into JIRA
    JiraController controller = new JiraController(version, jiraKey, username, message);
    controller.loadConfigFile();
    controller.connect();
    controller.addVersion();
    controller.addComment();
  }

  private void parseUsername()
  {
    JSONObject pusher = this.payloadJson.getJSONObject("pusher");
    this.username = pusher.getString("name");
  }

  /**
   * Prints out every information which could be found in github's payload sequence.
   * @return
   */
  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("Project version: ").append(this.version).append("\n");
    sb.append("JIRA Key: ").append(this.jiraKey).append("\n");
    sb.append("User: ").append(this.username).append("\n");
    sb.append("Commit message: ").append(this.message).append("\n");

    return sb.toString();
  }

  /**
   * Parses the name of the current Git branch (in which the changes are pushed) and uses it as JIRA project version.
   * @param version
   */
  private void parseVersion()
  {
    this.version = payloadJson.getString("ref");

    while (this.version.contains("/"))
    {
      int positionSlash = this.version.indexOf("/");
      this.version = this.version.substring(positionSlash + 1, this.version.length());
    }
  }

  /**
   * Parses the Git commit message for the JIRA issue key. It expects an '@' as delimtter.
   * For example: If the commit message is: 'SWQ-11@My commit message', then this method
   * extracts the character sequence in front of the '@' and takes it for the JIRA issue key.
   * The character sequence which follows the '@' is the commit message. In our example this
   * would be 'My commit message' and the key will be 'SWQ-11'.
   *
   * = Short example =
   * Git-Commit message: SWQ-11@My commit message
   * JIRA issue key: SWQ-11
   * Message for the JIRA comment: My commit message
   * @param message
   */
  private void parseMessage()
  {
    JSONArray commitsArray = this.payloadJson.getJSONArray("commits");
    JSONObject commitsObject = (JSONObject) commitsArray.get(0);
    this.message = commitsObject.getString("message");

    if (this.message.contains("@"))
    {
      int positionAt = message.indexOf('@');
      this.jiraKey = message.substring(0, positionAt);
      this.message = message.substring(positionAt + 1, message.length());
    }
  }
}
