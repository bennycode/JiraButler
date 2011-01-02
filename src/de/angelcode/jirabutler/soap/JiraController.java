package de.angelcode.jirabutler.soap;

import com.atlassian.jira.rpc.soap.beans.RemoteVersion;
import de.angelcode.jirabutler.soap.service.JiraClientImpl;
import de.angelcode.jirabutler.util.SystemVariables;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

/**
 *
 * @author danielp
 */
public class JiraController
{

  private String version;
  private String key;
  private String username;
  private String message;
  private String connectionUrl;
  private String connectionUsername;
  private String connectionPassword;

  public JiraController()
  {
    super();
    this.version = null;
    this.key = null;
    this.username = null;
    this.message = null;
    this.connectionUrl = null;
    this.connectionUsername = null;
    this.connectionPassword = null;
  }

  public JiraController(String version, String key, String username, String message)
  {
    this.version = version;
    this.key = key;
    this.username = username;
    this.message = message;
    // Get JIRA connection details

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
  }

  public boolean connect() throws Exception
  {
    boolean isLoggedIn = false;
    if (this.connectionUsername != null && this.connectionPassword != null && this.connectionUrl != null)
    {
      JiraClientImpl client = new JiraClientImpl();
      isLoggedIn = client.login(this.connectionUsername, this.connectionPassword);
      RemoteVersion newVersion = new RemoteVersion();
      newVersion.setName(this.version);
      try
      {
        client.addVersion(newVersion);
      }
      catch(NoClassDefFoundError ex)
      {
        System.out.println("Version successfully set.");
      }
      catch(com.atlassian.jira.rpc.exception.RemoteException ex)
      {
        System.out.println("Version already set.");
      }
      catch(Exception ex)
      {
        System.out.println("Version cannot be set.");
      }
    }
    return isLoggedIn;
  }

  public void addVersion() throws Exception
  {
  }
}
