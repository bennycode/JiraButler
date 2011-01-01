package de.angelcode.jirabutler.soap.service;

import com.atlassian.jira.rpc.exception.RemoteAuthenticationException;
import de.angelcode.jirabutler.exceptions.JIRAException;
import de.angelcode.jirabutler.exceptions.VoidParameterException;

public class JiraClient
{

  /**
   * @param args
   */
  public static void main(String[] args) throws JIRAException, VoidParameterException, RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {


    try
    {

      JiraClientImpl jiraClient = new JiraClientImpl();

      System.out.println("Login: " + jiraClient.login("testuser", "5YR1ZL5oyXH2eB6C4sN7"));
      System.out.println("Logout: " + jiraClient.logout());
    }
    catch (Exception ex)
    {
      System.out.println(ex.getLocalizedMessage());
    }

//		JiraSoapServiceService service = new JiraSoapServiceServiceLocator();
//		
//		try {
//			JiraSoapService api = service.getJirasoapserviceV2();
//			
//			String token = api.login("robertb", "test");
//			System.out.println("Eingeloggt als: " + api.getUser(token, "robertb").getEmail());
//			RemoteProject project = api.getProjectById(token, 10000);
//			System.out.println("Alte Versionen:");
//			RemoteVersion[] versions = api.getVersions(token, project.getKey());
//			for (RemoteVersion v : versions) {
//				System.out.println(v.getName());
//			}
//			RemoteVersion newVersion = new RemoteVersion();
//			newVersion.setName(args[0]);
//			api.addVersion(token, project.getKey(), newVersion);
//			System.out.println("Neue Versionen:");
//			versions = api.getVersions(token, project.getKey());
//			for (RemoteVersion v : versions) {
//				System.out.println(v.getName());
//			}
//			boolean logout = api.logout(token);
//			System.out.println("Logout erfogreich: " + logout);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}

  }
}
