package de.angelcode.jirabutler.soap.service;

import com.atlassian.jira.rpc.exception.RemoteAuthenticationException;
import com.atlassian.jira.rpc.exception.RemotePermissionException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import com.atlassian.jira.rpc.soap.beans.RemoteVersion;
import de.angelcode.jirabutler.exceptions.JIRAException;
import de.angelcode.jirabutler.exceptions.VoidParameterException;
import java.util.ArrayList;

public class JiraClient
{

  private JiraSoapServiceService service;
  private JiraSoapService api;
  private String token = null;

  public JiraClient() throws ServiceException
  {
    service = (JiraSoapServiceService) new JiraSoapServiceServiceLocator();
    api = service.getJirasoapserviceV2();
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

  public boolean login(String user, String password) throws JIRAException, RemoteException, VoidParameterException, RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (user == null || user.equals(""))
    {
      throw new VoidParameterException("Void value for paramter user");
    }
    else
    {
      token = api.login(user, password);
    }
    return token == null ? false : true;
  }

  public boolean logout() throws RemoteException
  {
    return api.logout(token);
  }

  public boolean addVersion(String jiraProjectKey, RemoteVersion version) throws RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    boolean success = false;

    api.addVersion(token, jiraProjectKey, version);
    success = true;

    return success;
  }

  /**
   * Experimental
   * @param jiraProjectKey
   * @return
   * @throws RemoteException
   * @throws RemotePermissionException
   * @throws RemoteAuthenticationException
   * @throws com.atlassian.jira.rpc.exception.RemoteException
   */
  public ArrayList<String> getVersions(String jiraProjectKey) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    ArrayList<String> versionList = new ArrayList<String>();
    RemoteVersion[] versions = api.getVersions(token, jiraProjectKey);

    for (RemoteVersion version:versions)
    {
      versionList.add(version.getName());
    }

    return versionList;
  }
//	try {
//		String token = api.login("robertb", "test");
//		System.out.println("Eingeloggt als: " + api.getUser(token, "robertb").getEmail());
//		RemoteProject project = api.getProjectById(token, 10000);
//		System.out.println("Alte Versionen:");
//		RemoteVersion[] versions = api.getVersions(token, project.getKey());
//		for (RemoteVersion v : versions) {
//			System.out.println(v.getName());
//		}
//		RemoteVersion newVersion = new RemoteVersion();
//		newVersion.setName(args[0]);
//		api.addVersion(token, project.getKey(), newVersion);
//		System.out.println("Neue Versionen:");
//		versions = api.getVersions(token, project.getKey());
//		for (RemoteVersion v : versions) {
//			System.out.println(v.getName());
//		}
//		boolean logout = api.logout(token);
//		System.out.println("Logout erfogreich: " + logout);
//	} catch (ServiceException e) {
//		e.printStackTrace();
//	} catch (RemoteException e) {
//		e.printStackTrace();
//	}
}
