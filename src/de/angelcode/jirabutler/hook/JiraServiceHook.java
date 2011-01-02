package de.angelcode.jirabutler.hook;

import com.atlassian.jira.rpc.exception.RemoteAuthenticationException;
import de.angelcode.jirabutler.exceptions.JIRAException;
import de.angelcode.jirabutler.exceptions.JiraButlerException;
import de.angelcode.jirabutler.soap.JiraController;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.rmi.RemoteException;
import java.text.ParseException;
import javax.xml.rpc.ServiceException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author bennyn
 */
public final class JiraServiceHook
{
  private String username;
  private String version;
  private String message;
  private String jiraKey;

  public JiraServiceHook()
  {
    super();
    this.username = null;
    this.version = null;
    this.message = null;
    this.jiraKey = null;
  }

  public JiraServiceHook(String githubRequest) throws UnsupportedEncodingException, ParseException, IOException, ServiceException, JIRAException, RemoteException, RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException, JiraButlerException
  {
    this();
    // Convert github request into a valid payload json object
    int payloadStart = githubRequest.indexOf("payload=");
    String payloadAscii = githubRequest.substring(payloadStart + 8, githubRequest.length());
    String payloadUnicode = URLDecoder.decode(payloadAscii, "UTF-8");
    JSONObject payloadJson = new JSONObject(payloadUnicode);
    // Get pusher information
    JSONObject pusher = payloadJson.getJSONObject("pusher");
    this.username = pusher.getString("name");
    // Get commit information
    this.version = payloadJson.getString("ref");
    processVersion(this.version);
    // Get commit information
    JSONArray commitsArray = payloadJson.getJSONArray("commits");
    JSONObject commitsObject = (JSONObject) commitsArray.get(0);
    this.message = commitsObject.getString("message");
    processMessage(this.message);
    // Pass everything to the JIRA communicator
    JiraController controller = new JiraController(version, jiraKey, username, message);
    // Insert things in JIRA
    controller.loadConfigFile();
    controller.connect();
    controller.addVersion();
    controller.addComment();
  }

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

  private void processVersion(String version)
  {
    while (version.contains("/"))
    {
      int positionSlash = version.indexOf("/");
      version = version.substring(positionSlash + 1, version.length());
    }
    this.version = version;
  }

  private void processMessage(String message)
  {
    if (message.contains("@"))
    {
      int positionAt = message.indexOf('@');
      this.jiraKey = message.substring(0, positionAt);
      this.message = message.substring(positionAt + 1, message.length());
    }
  }
}
