package de.angelcode.jirabutler.soap;

import com.atlassian.jira.rpc.exception.RemoteException;
import com.atlassian.jira.rpc.soap.beans.RemoteComment;
import com.atlassian.jira.rpc.soap.beans.RemoteVersion;
import de.angelcode.jirabutler.soap.service.JiraSoapService;
import de.angelcode.jirabutler.soap.service.JiraSoapServiceService;
import de.angelcode.jirabutler.soap.service.JiraSoapServiceServiceLocator;
import de.angelcode.jirabutler.util.SystemVariables;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.xml.rpc.ServiceException;

/**
 *
 * @author danielp
 */
public class JiraClient
{

  private String jiraProjectVersion;
  private String jiraIssueKey;
  private String username;
  private String gitCommitMessage;
  private String connectionUrl;
  private String connectionUsername;
  private String connectionPassword;
  private String jiraProjectKey;
  // JIRA connection stuff
  private JiraSoapServiceService service;
  private JiraSoapService api;
  private String token;

  public JiraClient()
  {
    super();
    this.jiraProjectVersion = null;
    this.jiraIssueKey = null;
    this.username = null;
    this.gitCommitMessage = null;
    this.connectionUrl = null;
    this.connectionUsername = null;
    this.connectionPassword = null;
    this.service = null;
    this.api = null;
    this.token = null;
  }

  public JiraClient(String version, String key, String username, String message)
  {
    this();
    this.jiraProjectVersion = version;
    this.jiraIssueKey = key;
    this.username = username;
    this.gitCommitMessage = message;
  }

  /**
   * Reads the connection URL and JIRA authentication credentials (username and password) from the default "jira.properties" configuration file.
   */
  public void loadConfigFile()
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
      System.out.println("The file " + file + "could not be found.");
    }
    catch (IOException ex)
    {
      System.out.println("Error while reading/writing the file " + file + ".");
    }

    this.connectionUrl = properties.getProperty("url");
    this.connectionUsername = properties.getProperty("username");
    this.connectionPassword = properties.getProperty("password");

    if (this.jiraIssueKey != null)
    {
      this.jiraProjectKey = this.jiraIssueKey.substring(0, this.jiraIssueKey.indexOf("-"));
    }
  }

  public boolean login()
  {
    boolean success = false;

    // If connection information is available
    if (this.connectionUsername != null
            && this.connectionPassword != null
            && this.connectionUrl != null)
    {
      try
      {
        // Init JIRA services
        this.service = (JiraSoapServiceService) new JiraSoapServiceServiceLocator(this.connectionUrl);
        this.api = this.service.getJirasoapserviceV2();
        this.token = api.login(this.connectionUsername, this.connectionPassword);
        success = true;
      }
      catch (RemoteException ex)
      {
        System.out.println("The authentication credentials are wrong: "
                + ex.getLocalizedMessage());
      }
      catch (ServiceException ex)
      {
        System.out.println("Cannot get the JIRA SOAP service: "
                + ex.getLocalizedMessage());
      }
      catch (Exception ex)
      {
        System.out.println("Unknown exception: "
                + ex.getLocalizedMessage());
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

  public boolean logout()
  {
    boolean success = false;
    try
    {
      success = this.api.logout(this.token);
    }
    catch (java.rmi.RemoteException ex)
    {
      System.out.println("Logout was not successfully: "
              + ex.getLocalizedMessage());
    }
    finally
    {
      return success;
    }
  }

  public boolean addVersion()
  {
    boolean success = false;

    if (this.jiraProjectKey != null && this.jiraProjectVersion != null)
    {
      RemoteVersion newVersion = new RemoteVersion();
      newVersion.setName(this.jiraProjectVersion);

      try
      {
        this.api.addVersion(this.token, this.jiraProjectKey, newVersion);
      }
      catch (RemoteException ex)
      {
        System.out.println("Version already exists or no permission to set the version: " + ex.getLocalizedMessage());
      }
      catch (NoClassDefFoundError ex)
      {
        System.out.println("Version added successfully.");
        success = true;
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

  public boolean addComment()
  {
    boolean success = false;

    if (this.jiraIssueKey != null && this.gitCommitMessage != null && this.username != null)
    {
      try
      {
        RemoteComment comment = new RemoteComment();
        comment.setBody(this.username + ": " + this.gitCommitMessage);
        System.out.println("This comment is going to be written into the JIRA issue: " + this.username + ": " + this.gitCommitMessage);
        this.api.addComment(this.token, this.jiraIssueKey, comment);
        success = true;
      }
      catch (RemoteException ex)
      {
        System.out.println("Comment could not be written. Please check your authentication credentials and user permissions: "
                + ex.getLocalizedMessage());
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

  public void setGitCommitMessage(String gitCommitMessage)
  {
    this.gitCommitMessage = gitCommitMessage;
  }

  public void setJiraProjectKey(String jiraProjectKey)
  {
    this.jiraProjectKey = jiraProjectKey;
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

  public void setConnectionUsername(String connectionUsername)
  {
    this.connectionUsername = connectionUsername;
  }

  public void setConnectionPassword(String connectionPassword)
  {
    this.connectionPassword = connectionPassword;
  }

  public void setConnectionUrl(String connectionUrl)
  {
    this.connectionUrl = connectionUrl;
  }

  public void setService(JiraSoapServiceService service)
  {
    this.service = service;
  }

  public void setToken(String token)
  {
    this.token = token;
  }

  public void setApi(JiraSoapService api)
  {
    this.api = api;
  }
}
