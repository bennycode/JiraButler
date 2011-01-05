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

import de.angelcode.jirabutler.exceptions.JiraButlerException;
import de.angelcode.jirabutler.soap.service.JiraSoapService;
import de.angelcode.jirabutler.soap.service.JiraSoapServiceService;
import de.angelcode.jirabutler.soap.service.JiraSoapServiceServiceLocator;

/**
 * 
 * @author BoatoonAdmin
 */
public class JiraClientTest {

	private JiraClient jiraClient;
	private JiraSoapServiceService service;
	private JiraSoapService apiMock;

	@Before
	public void setUp() throws Exception {
		jiraClient = new JiraClient();
		this.service = new JiraSoapServiceServiceLocator();
		jiraClient.setConnectionUrl("http://www.angelcode.de:8080/rpc/soap/jirasoapservice-v2");
		jiraClient.setService(service);
		apiMock = createStrictMock(JiraSoapService.class);
		jiraClient.setApi(apiMock);
	}

	/**
	 * Test of valid login method.
	 * 
	 * @throws JiraButlerException
	 * @throws RemoteException
	 * @throws com.atlassian.jira.rpc.exception.RemoteException
	 */
	@Test
	public void testValidLogin() throws JiraButlerException, RemoteException,
			com.atlassian.jira.rpc.exception.RemoteException {
		String token = new String();
		String connectionUsername = "username";
		String connectionPassword = "password";

		jiraClient.setConnectionUsername(connectionUsername);
		jiraClient.setConnectionPassword(connectionPassword);

		expect(apiMock.login(connectionUsername, connectionPassword)).andReturn(token).times(1);
		replay(apiMock);
		assertTrue(jiraClient.login());
		verify(apiMock);
	}

	/**
	 * Test of invalid login method.
	 * 
	 * @throws JiraButlerException
	 * @throws RemoteException
	 * @throws com.atlassian.jira.rpc.exception.RemoteException
	 */
	@Test
	public final void testInvalidLogin() throws RemoteException,
			com.atlassian.jira.rpc.exception.RemoteException,
			JiraButlerException {
		String connectionUsername = "username";
		String connectionPassword = "password";

		jiraClient.setConnectionUsername(connectionUsername);
		jiraClient.setConnectionPassword(connectionPassword);

		expect(apiMock.login(connectionUsername, connectionPassword)).andReturn(null).times(1);
		replay(apiMock);
		assertFalse(jiraClient.login());
		verify(apiMock);
	}

	/**
	 * Test of java.rmi.RemoteException for login method.
	 * 
	 * @throws JiraButlerException
	 * @throws RemoteException
	 * @throws com.atlassian.jira.rpc.exception.RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testRMIRemoteExceptionLogin() throws JiraButlerException,
			RemoteException, com.atlassian.jira.rpc.exception.RemoteException {
		String connectionUsername = "username";
		String connectionPassword = "password";

		jiraClient.setConnectionUsername(connectionUsername);
		jiraClient.setConnectionPassword(connectionPassword);
		
		expect(apiMock.login(connectionUsername, connectionPassword)).andThrow(
				new RemoteException()).times(1);
		replay(apiMock);
		jiraClient.login();
	}

	/**
	 * Test of com.atlassian.jira.rpc.exception.RemoteException for login
	 * method.
	 * 
	 * @throws JiraButlerException
	 * @throws RemoteException
	 * @throws com.atlassian.jira.rpc.exception.RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testJIRARemoteExceptionLogin()
			throws JiraButlerException, RemoteException,
			com.atlassian.jira.rpc.exception.RemoteException {
		String connectionUsername = "username";
		String connectionPassword = "password";

		jiraClient.setConnectionUsername(connectionUsername);
		jiraClient.setConnectionPassword(connectionPassword);

		expect(apiMock.login(connectionUsername, connectionPassword)).andThrow(
				new com.atlassian.jira.rpc.exception.RemoteException())
				.times(1);
		replay(apiMock);
		jiraClient.login();
	}

	// /**
	// * Test of logout method, of class JiraClient.
	// */
	// @Test
	// public void testLogout() throws Exception {
	// System.out.println("logout");
	// JiraClient instance = new JiraClient();
	// boolean expResult = false;
	// boolean result = instance.logout();
	// assertEquals(expResult, result);
	// // TODO review the generated test code and remove the default call to
	// // fail.
	// fail("The test case is a prototype.");
	// }
	//
	// /**
	// * Test of addVersion method, of class JiraClient.
	// */
	// @Test
	// public void testAddVersion() throws Exception {
	// System.out.println("addVersion");
	// String jiraProjectKey = "";
	// RemoteVersion version = null;
	// JiraClient instance = new JiraClient();
	// boolean expResult = false;
	// boolean result = instance.addVersion(jiraProjectKey, version);
	// assertEquals(expResult, result);
	// // TODO review the generated test code and remove the default call to
	// // fail.
	// fail("The test case is a prototype.");
	// }
	//
	// /**
	// * Test of addComment method, of class JiraClient.
	// */
	// @Test
	// public void testAddComment() throws Exception {
	// System.out.println("addComment");
	// String jiraProjectKey = "";
	// RemoteComment comment = null;
	// JiraClient instance = new JiraClient();
	// boolean expResult = false;
	// boolean result = instance.addComment(jiraProjectKey, comment);
	// assertEquals(expResult, result);
	// // TODO review the generated test code and remove the default call to
	// // fail.
	// fail("The test case is a prototype.");
	// }
	//
	// /**
	// * Test of getVersions method, of class JiraClient.
	// */
	// @Test
	// public void testGetVersions() throws Exception {
	// System.out.println("getVersions");
	// String jiraProjectKey = "";
	// JiraClient instance = new JiraClient();
	// ArrayList expResult = null;
	// ArrayList result = instance.getVersions(jiraProjectKey);
	// assertEquals(expResult, result);
	// // TODO review the generated test code and remove the default call to
	// // fail.
	// fail("The test case is a prototype.");
	// }
}
