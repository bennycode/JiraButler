package de.angelcode.jirabutler.soap.service;

import com.atlassian.jira.rpc.exception.RemoteAuthenticationException;
import com.atlassian.jira.rpc.exception.RemotePermissionException;
import com.atlassian.jira.rpc.soap.beans.RemoteComment;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import com.atlassian.jira.rpc.soap.beans.RemoteVersion;
import de.angelcode.jirabutler.exceptions.JIRAException;
import de.angelcode.jirabutler.exceptions.JiraButlerException;
import de.angelcode.jirabutler.exceptions.VoidParameterException;
import java.util.ArrayList;

/**
 *
 * @author jens, robert, danielp
 */
public class JiraClient
{

  private JiraSoapServiceService service;
  private JiraSoapService api;
  private String token = null;

  public JiraClient() throws JiraButlerException
  {
    service = (JiraSoapServiceService) new JiraSoapServiceServiceLocator();
    try
    {
      api = service.getJirasoapserviceV2();
    }
    catch (ServiceException ex)
    {
      throw new JiraButlerException("Cannot get the JIRA SOAP service: "+ex.getLocalizedMessage());
    }
    catch (Exception ex)
    {
      throw new JiraButlerException("Unknown exception: "+ex.getLocalizedMessage());
    }
  }

  public void setService(JiraSoapServiceService service)
  {
    this.service = service;
  }

  public JiraSoapServiceService getService()
  {
    return service;
  }

  public JiraSoapService getApi()
  {
    return api;
  }

  public void setApi(JiraSoapService api)
  {
    this.api = api;
  }

  public String getToken()
  {
    return token;
  }

  public void setToken(String token)
  {
    this.token = token;
  }

  /**
   * Authenticates a user with JIRA.
   * @param user
   * @param password
   * @return true if login was successful and false if it was not
   * @throws JIRAException
   * @throws RemoteException
   * @throws VoidParameterException
   * @throws RemoteAuthenticationException
   * @throws com.atlassian.jira.rpc.exception.RemoteException
   */
  public boolean login(String user, String password) throws JiraButlerException
  {
    try
    {
      token = api.login(user, password);
    }
    catch (RemoteException ex)
    {
      throw new JiraButlerException("Cannot connect to JIRA: " + ex.getLocalizedMessage());
    }
    catch (RemoteAuthenticationException ex)
    {
      throw new JiraButlerException("The authentication credentials are wrong: " + ex.getLocalizedMessage());
    }
    catch (com.atlassian.jira.rpc.exception.RemoteException ex)
    {
      throw new JiraButlerException("Connect to JIRA: " + ex.getLocalizedMessage());
    }
    catch (Exception ex)
    {
      throw new JiraButlerException("Unknown exception: " + ex.getLocalizedMessage());
    }

    return token == null ? false : true;
  }

  /**
   * Signs the currently logged-in user out.
   * @return true if logout was successful and false if it was not
   * @throws RemoteException
   */
  public boolean logout() throws JiraButlerException
  {
    boolean success = false;

    try
    {
      success = api.logout(token);
    }
    catch (RemoteException ex)
    {
      throw new JiraButlerException("Logout was not successful: " + ex.getLocalizedMessage());
    }
    catch (Exception ex)
    {
      throw new JiraButlerException("Unknown exception: " + ex.getLocalizedMessage());
    }

    return success;
  }

  /**
   * This method adds a new version for a JIRA proejct.
   * @param jiraProjectKey
   * @param version
   * @return true when the version was added and false if the version could not be added
   * @throws RemoteException
   * @throws com.atlassian.jira.rpc.exception.RemoteException
   */
  public boolean addVersion(String jiraProjectKey, RemoteVersion version) throws JiraButlerException
  {
    boolean success = false;

    try
    {
      api.addVersion(token, jiraProjectKey, version);
      success = true;
    }
    catch (RemoteException ex)
    {
      System.out.println("No permission to set the version.");
      //throw new JiraButlerException("You don't have permission to set the version: " + ex.getLocalizedMessage());
    }
    catch (com.atlassian.jira.rpc.exception.RemoteException ex)
    {
      System.out.println("Version already exists.");
      //throw new JiraButlerException("You don't have permission to set the version: " + ex.getLocalizedMessage());
    }
    catch (Exception ex)
    {
      //throw new JiraButlerException("Unknown exception: " + ex.getLocalizedMessage());
    }
    finally
    {
      return success;
    }
  }

  /**
   * This method adds a comment to an existing JIRA issue.
   * @param jiraProjectKey
   * @param comment
   * @return true if the comment was added, false when the comment could not be added
   * @throws RemoteException
   * @throws RemotePermissionException
   * @throws RemoteAuthenticationException
   * @throws com.atlassian.jira.rpc.exception.RemoteException
   */
  public boolean addComment(String jiraProjectKey, RemoteComment comment) throws JiraButlerException
  {
    boolean success = false;

    try
    {
      this.api.addComment(token, jiraProjectKey, comment);
      success = true;
    }
    catch (RemoteException ex)
    {
      throw new JiraButlerException("Cannot connect to JIRA: " + ex.getLocalizedMessage());
    }
    catch (RemotePermissionException ex)
    {
      throw new JiraButlerException("You don't have permission to write a comment: " + ex.getLocalizedMessage());
    }
    catch (RemoteAuthenticationException ex)
    {
      throw new JiraButlerException("Comment could not be written. Please check your authentication credentials: " + ex.getLocalizedMessage());
    }
    catch (com.atlassian.jira.rpc.exception.RemoteException ex)
    {
      throw new JiraButlerException("Cannot connect to JIRA: " + ex.getLocalizedMessage());
    }
    catch (Exception ex)
    {
      throw new JiraButlerException("Unknown exception: " + ex.getLocalizedMessage());
    }

    return success;
  }

  /**
   * Experimental. Not used yet.
   * @param jiraProjectKey
   * @return A list of all version available
   * @throws RemoteException
   * @throws RemotePermissionException
   * @throws RemoteAuthenticationException
   * @throws com.atlassian.jira.rpc.exception.RemoteException
   */
  public ArrayList<String> getVersions(String jiraProjectKey) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    ArrayList<String> versionList = new ArrayList<String>();
    RemoteVersion[] versions = api.getVersions(token, jiraProjectKey);

    for (RemoteVersion version : versions)
    {
      versionList.add(version.getName());
    }

    return versionList;
  }
}
