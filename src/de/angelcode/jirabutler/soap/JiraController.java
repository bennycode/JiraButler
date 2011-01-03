package de.angelcode.jirabutler.soap;

import com.atlassian.jira.rpc.soap.beans.RemoteComment;
import com.atlassian.jira.rpc.soap.beans.RemoteVersion;
import de.angelcode.jirabutler.exceptions.JiraButlerException;
import de.angelcode.jirabutler.soap.service.JiraClient;
import de.angelcode.jirabutler.util.SystemVariables;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
   * Reads the connection URL and JIRA authentication credentials (username and password) from the default "jira.properties" configuration file.
   */
  public void loadConfigFile() throws JiraButlerException
  {
    Properties properties = new Properties();
    BufferedInputStream stream;
    String file = "jira.properties";
    try
    {
      stream = new BufferedInputStream(new FileInputStream(SystemVariables.getJarExecutionDirectory() + file));
      properties.load(stream);
      stream.close();
    }
    catch (FileNotFoundException ex)
    {
      throw new JiraButlerException("The file " + file + "could not be found.");
    }
    catch (IOException ex)
    {
      throw new JiraButlerException("Error while reading/writing the file " + file + ".");
    }

    this.connectionUrl = properties.getProperty("url");
    this.connectionUsername = properties.getProperty("username");
    this.connectionPassword = properties.getProperty("password");

    if (this.issueKey != null)
    {
      this.projectKey = this.issueKey.substring(0, this.issueKey.indexOf("-"));
    }
  }

  public boolean connect() throws JiraButlerException
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

  public void addVersion() throws JiraButlerException
  {
    if (this.projectKey != null && this.version != null)
    {
      RemoteVersion newVersion = new RemoteVersion();
      newVersion.setName(this.version);

      client.addVersion(this.projectKey, newVersion);
    }
  }

  public boolean addComment() throws JiraButlerException
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
