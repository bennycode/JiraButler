package de.angelcode.jirabutler.soap;

import com.atlassian.jira.rpc.exception.RemoteAuthenticationException;
import com.atlassian.jira.rpc.exception.RemotePermissionException;
import com.atlassian.jira.rpc.soap.JiraSoapService;
import com.atlassian.jira.rpc.soap.beans.RemoteComment;
import com.atlassian.jira.rpc.soap.beans.RemoteIssue;
import com.atlassian.jira.rpc.soap.beans.RemoteVersion;
import de.angelcode.jirabutler.exceptions.JIRAException;
import de.angelcode.jirabutler.exceptions.JiraButlerException;
import de.angelcode.jirabutler.soap.service.JiraClient;
import de.angelcode.jirabutler.util.SystemVariables;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;
import javax.xml.rpc.ServiceException;

/**
 *
 * @author danielp
 */
public class JiraController
{

  private String version;
  private String issueKey;
  private String username;
  private String message;
  private String connectionUrl;
  private String connectionUsername;
  private String connectionPassword;
  private String projectKey;
  private JiraClient client;

  public JiraController()
  {
    super();
    this.version = null;
    this.issueKey = null;
    this.username = null;
    this.message = null;
    this.connectionUrl = null;
    this.connectionUsername = null;
    this.connectionPassword = null;
  }

  public JiraController(String version, String key, String username, String message)
  {
    this.version = version;
    this.issueKey = key;
    this.username = username;
    this.message = message;
  }

  /**
   * Reads the connection connectionUrl and JIRA authentication credentials (username and password) from the default "jira.properties" configuration file.
   */
  public void loadConfigFile() throws IOException
  {
    Properties properties = new Properties();
    BufferedInputStream stream = new BufferedInputStream(new FileInputStream(SystemVariables.getJarExecutionDirectory() + "jira.properties"));
    properties.load(stream);
    stream.close();
    this.connectionUrl = properties.getProperty("url");
    this.connectionUsername = properties.getProperty("username");
    this.connectionPassword = properties.getProperty("password");

    if (this.issueKey != null)
      this.projectKey = this.issueKey.substring(0, this.issueKey.indexOf("-"));

      System.out.println(this.projectKey);
  }

  public boolean connect() throws ServiceException, JIRAException, RemoteException, RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    boolean isLoggedIn = false;
    if (this.connectionUsername != null
            && this.connectionPassword != null
            && this.connectionUrl != null)
    {
      this.client = new JiraClient();
      isLoggedIn = client.login(this.connectionUsername, this.connectionPassword);
    }
    return isLoggedIn;
  }

  public void addVersion() throws RemoteException, com.atlassian.jira.rpc.exception.RemoteException, JiraButlerException
  {
    if (this.projectKey != null && this.version != null)
    {
      RemoteVersion newVersion = new RemoteVersion();
      newVersion.setName(this.version);
//      try
//      {
        client.addVersion(this.projectKey, newVersion);
//      }
//      catch (NoClassDefFoundError ex)
//      {
//        throw new JiraButlerException("Version successfully set.");
//      }
//      catch (com.atlassian.jira.rpc.exception.RemoteException ex)
//      {
//        throw new JiraButlerException("Version already set.");
//      }
//      catch (Exception ex)
//      {
//        throw new JiraButlerException("Version cannot be set.");
//      }
    }
  }

  public boolean addComment() throws RemoteException, RemotePermissionException, RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (this.issueKey != null && this.message != null && this.username != null)
    {
      RemoteComment comment = new RemoteComment();
      comment.setBody(this.username + ": " + this.message);
      System.out.println(this.username + ": " + this.message);

      client.addComment(this.issueKey, comment);
    }

    return true;
  }
}
