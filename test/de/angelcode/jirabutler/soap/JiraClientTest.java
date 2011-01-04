package de.angelcode.jirabutler.soap;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import com.atlassian.jira.rpc.exception.RemoteAuthenticationException;

import de.angelcode.jirabutler.exceptions.JiraButlerException;
import de.angelcode.jirabutler.soap.service.JiraSoapService;

/**
 * 
 * @author BoatoonAdmin
 */
public class JiraClientTest
{

  private JiraClient jiraClient;
  private JiraSoapService apiMock;

  @Before
  public void setUp() throws Exception
  {
//    jiraClient = new JiraClient("http://angelcode.de:8080/rpc/soap/jirasoapservice-v2");
//    apiMock = createStrictMock(JiraSoapService.class);
//    jiraClient.setApi(apiMock);
  }

  /**
   * Test of valid login method, of class JiraClient.
   * @throws RemoteException
   * @throws com.atlassian.jira.rpc.exception.RemoteException
   * @throws JiraButlerException
   * @throws com.atlassian.jira.rpc.exception.RemoteException
   * @throws RemoteAuthenticationException
   */
  @Test
  public void testValidLogin() throws JiraButlerException, RemoteException, RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    String token = new String();
    String user = "testUser";
    String password = "testPassword";

    try
    {
      expect(apiMock.login(user, password)).andReturn(token).times(1);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    catch (RemoteAuthenticationException e)
    {
      e.printStackTrace();
    }
    catch (com.atlassian.jira.rpc.exception.RemoteException e)
    {
      e.printStackTrace();
    }
//    replay(apiMock);
//    assertTrue(jiraClient.login(user, password));
//    verify(apiMock);
  }

  /**
   * Test of invalid login method, of class JiraClient.
   * @throws com.atlassian.jira.rpc.exception.RemoteException
   * @throws RemoteAuthenticationException
   * @throws RemoteException
   * @throws JiraButlerException
   */
  @Test
  public final void testInvalidLogin() throws RemoteException, RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException, JiraButlerException
  {
    String user = "testUser";
    String password = "testPassword";

//    expect(apiMock.login(user, password)).andReturn(null).times(1);
//    replay(apiMock);
//    assertFalse(jiraClient.login(user, password));
//    verify(apiMock);
  }

  @Test(expected = JiraButlerException.class)
  public final void testVoidLogin() throws JiraButlerException
  {
    String user = "";
    String password = "";

//    jiraClient.login(user, password);
  }
//	/**
//	 * Test of logout method, of class JiraClient.
//	 */
//	@Test
//	public void testLogout() throws Exception {
//		System.out.println("logout");
//		JiraClient instance = new JiraClient();
//		boolean expResult = false;
//		boolean result = instance.logout();
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to
//		// fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of addVersion method, of class JiraClient.
//	 */
//	@Test
//	public void testAddVersion() throws Exception {
//		System.out.println("addVersion");
//		String jiraProjectKey = "";
//		RemoteVersion version = null;
//		JiraClient instance = new JiraClient();
//		boolean expResult = false;
//		boolean result = instance.addVersion(jiraProjectKey, version);
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to
//		// fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of addComment method, of class JiraClient.
//	 */
//	@Test
//	public void testAddComment() throws Exception {
//		System.out.println("addComment");
//		String jiraProjectKey = "";
//		RemoteComment comment = null;
//		JiraClient instance = new JiraClient();
//		boolean expResult = false;
//		boolean result = instance.addComment(jiraProjectKey, comment);
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to
//		// fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of getVersions method, of class JiraClient.
//	 */
//	@Test
//	public void testGetVersions() throws Exception {
//		System.out.println("getVersions");
//		String jiraProjectKey = "";
//		JiraClient instance = new JiraClient();
//		ArrayList expResult = null;
//		ArrayList result = instance.getVersions(jiraProjectKey);
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to
//		// fail.
//		fail("The test case is a prototype.");
//	}
}
