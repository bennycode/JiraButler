package de.angelcode.jirabutler.soap;

import com.atlassian.jira.rpc.soap.beans.RemoteComment;
import com.atlassian.jira.rpc.soap.beans.RemoteVersion;
import de.angelcode.jirabutler.exceptions.JiraButlerException;
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

  private String jiraProjectVersion;
  private String jiraIssueKey;
  private String username;
  private String gitCommitMessage;
  private String connectionUrl;
  private String connectionUsername;
  private String connectionPassword;
  private String projectKey;
  private JiraClient client;

  public JiraController()
  {
    super();
    this.jiraProjectVersion = null;
    this.jiraIssueKey = null;
    this.username = null;
    this.gitCommitMessage = null;
    this.connectionUrl = null;
    this.connectionUsername = null;
    this.connectionPassword = null;
  }

  public JiraController(String version, String key, String username, String message)
  {
    this.jiraProjectVersion = version;
    this.jiraIssueKey = key;
    this.username = username;
    this.gitCommitMessage = message;
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

    if (this.jiraIssueKey != null)
    {
      this.projectKey = this.jiraIssueKey.substring(0, this.jiraIssueKey.indexOf("-"));
    }
  }

  public boolean connect() throws JiraButlerException
  {
    boolean isLoggedIn = false;
    if (this.connectionUsername != null
            && this.connectionPassword != null
            && this.connectionUrl != null)
    {
      this.client = new JiraClient(this.connectionUrl);
      isLoggedIn = client.login(this.connectionUsername, this.connectionPassword);
    }
    return isLoggedIn;
  }

  public boolean addVersion() throws JiraButlerException
  {
    boolean success = false;

    if (this.projectKey != null && this.jiraProjectVersion != null)
    {
      RemoteVersion newVersion = new RemoteVersion();
      newVersion.setName(this.jiraProjectVersion);

      try
      {
        client.addVersion(this.projectKey, newVersion);
        success = true;
      }
      catch (NoClassDefFoundError ex)
      {
        System.out.println("Version added successfully.");
      }
      catch (Exception ex)
      {
        System.out.println("Unknown exception: " + ex.getLocalizedMessage());
      }
      finally
      {
        return success;
      }
    }
    else
    {
      return success;
    }
  }

  public boolean addComment() throws JiraButlerException
  {
    boolean success = false;

    if (this.jiraIssueKey != null && this.gitCommitMessage != null && this.username != null)
    {
      try
      {
        RemoteComment comment = new RemoteComment();
        comment.setBody(this.username + ": " + this.gitCommitMessage);
        System.out.println("This comment is going to be written into the JIRA issue: " + this.username + ": " + this.gitCommitMessage);
        client.addComment(this.jiraIssueKey, comment);
        success = true;
      }
      catch(Exception ex)
      {
        System.out.println("Unknown exception: "+ex.getLocalizedMessage());
      }
      finally
      {
        return success;
      }
    }
    else
    {
      return success;
    }
  }

  public void setGitCommitMessage(String gitCommitMessage)
  {
    this.gitCommitMessage = gitCommitMessage;
  }

  public void setJiraIssueKey(String jiraIssueKey)
  {
    this.jiraIssueKey = jiraIssueKey;
  }

  public void setJiraProjectVersion(String jiraProjectVersion)
  {
    this.jiraProjectVersion = jiraProjectVersion;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getConnectionUrl()
  {
    return this.connectionUrl;
  }
}
