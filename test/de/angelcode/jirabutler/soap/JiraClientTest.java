package de.angelcode.jirabutler.soap;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.atlassian.jira.rpc.exception.RemoteException;
import com.atlassian.jira.rpc.soap.beans.RemoteComment;
import com.atlassian.jira.rpc.soap.beans.RemoteVersion;

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
	
	@Test(expected = JiraButlerException.class)
	public void testInvalidLoadConfigFile() throws JiraButlerException {
		jiraClient.loadConfigFile();
	}
	
	/**
	 * Test of valid login.
	 * 
	 * @throws JiraButlerException
	 * @throws RemoteException
	 * @throws java.rmi.RemoteException
	 */
	@Test
	public void testValidLogin() throws JiraButlerException, RemoteException, java.rmi.RemoteException {
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
	 * Test of invalid login.
	 * 
	 * @throws JiraButlerException
	 * @throws RemoteException
	 * @throws java.rmi.RemoteException
	 */
	@Test
	public final void testInvalidLogin() throws JiraButlerException, RemoteException, java.rmi.RemoteException {
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
	 * Test of JiraButlerException for login, if username is null.
	 * 
	 * @throws JiraButlerException
	 * @throws RemoteException
	 * @throws java.rmi.RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testNullUsernameLogin() throws JiraButlerException, RemoteException, java.rmi.RemoteException {
		String connectionUsername = null;
		String connectionPassword = "password";

		jiraClient.setConnectionUsername(connectionUsername);
		jiraClient.setConnectionPassword(connectionPassword);
		
		jiraClient.login();
	}
	
	/**
	 * Test of JiraButlerException for login, if password is null.
	 * 
	 * @throws JiraButlerException
	 * @throws RemoteException
	 * @throws java.rmi.RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testNullPasswordLogin() throws JiraButlerException, RemoteException, java.rmi.RemoteException {
		String connectionUsername = "username";
		String connectionPassword = null;

		jiraClient.setConnectionUsername(connectionUsername);
		jiraClient.setConnectionPassword(connectionPassword);

		jiraClient.login();
	}
	
	/**
	* Test of JiraButlerException for login, if url is null.
	 * 
	 * @throws JiraButlerException
	 * @throws RemoteException
	 * @throws java.rmi.RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testNullUrlLogin() throws JiraButlerException, RemoteException, java.rmi.RemoteException {
		String connectionUsername = "username";
		String connectionPassword = "password";

		jiraClient.setConnectionUsername(connectionUsername);
		jiraClient.setConnectionPassword(connectionPassword);
		jiraClient.setConnectionUrl(null);
		
		jiraClient.login();
	}
	
	/**
	 * Test of com.atlassian.jira.rpc.exception.RemoteException for login.
	 * 
	 * @throws JiraButlerException
	 * @throws RemoteException
	 * @throws java.rmi.RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testJIRARemoteExceptionLogin() throws JiraButlerException, RemoteException, java.rmi.RemoteException {
		String connectionUsername = "username";
		String connectionPassword = "password";

		jiraClient.setConnectionUsername(connectionUsername);
		jiraClient.setConnectionPassword(connectionPassword);

		expect(apiMock.login(connectionUsername, connectionPassword)).andThrow(
				new RemoteException())
				.times(1);
		replay(apiMock);
		jiraClient.login();
		verify(apiMock);
	}
	
	/**
	 * Test of java.rmi.RemoteException for login method.
	 * 
	 * @throws JiraButlerException
	 * @throws RemoteException
	 * @throws java.rmi.RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testRMIRemoteExceptionLogin() throws JiraButlerException, RemoteException, java.rmi.RemoteException {
		String connectionUsername = "username";
		String connectionPassword = "password";

		jiraClient.setConnectionUsername(connectionUsername);
		jiraClient.setConnectionPassword(connectionPassword);
		
		expect(apiMock.login(connectionUsername, connectionPassword)).andThrow(
				new java.rmi.RemoteException()).times(1);
		replay(apiMock);
		jiraClient.login();
		verify(apiMock);
	}

	/**
	 * Test of valid logout.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 */
	@Test
	public final void testValidLogout() throws JiraButlerException, java.rmi.RemoteException {
		String token = "token";
		
		jiraClient.setToken(token);
		
		expect(apiMock.logout(token)).andReturn(true).times(1);
		replay(apiMock);
		assertTrue(jiraClient.logout());
		verify(apiMock);
		
	}
	
	/**
	 * Test of invalid logout.
	 * 
	 * @throws JiraButlerException
	 * @throws RemoteException
	 */
	@Test
	public final void testInvalidLogout() throws JiraButlerException, java.rmi.RemoteException {
		String token = "token";
		
		jiraClient.setToken(token);
		
		expect(apiMock.logout(token)).andReturn(false).times(1);
		replay(apiMock);
		assertFalse(jiraClient.logout());
		verify(apiMock);
		
	}
	
	/**
	 * Test of java.rmi.RemoteException for logout.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testRMIRemoteExceptionLogout() throws JiraButlerException, java.rmi.RemoteException {
		String token = "token";
		
		jiraClient.setToken(token);
		
		expect(apiMock.logout(token)).andThrow(new java.rmi.RemoteException()).times(1);
		replay(apiMock);		
		jiraClient.logout();
		verify(apiMock);		
	}
	
	/**
	 * Test of valid addVersion.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 * @throws RemoteException
	 */
	@Test
	public final void testValidAddVersion() throws JiraButlerException, java.rmi.RemoteException, RemoteException {
		String token = "token";
		String jiraProjectKey = "SWQ";
		String jiraProjectVersion = "v1.1";
		RemoteVersion newVersion = new RemoteVersion();
		newVersion.setName(jiraProjectVersion);
		
		jiraClient.setToken(token);
		jiraClient.setJiraProjectKey(jiraProjectKey);
		jiraClient.setJiraProjectVersion(jiraProjectVersion);
		
		expect(apiMock.addVersion(token, jiraProjectKey, newVersion)).andReturn(new RemoteVersion()).times(1);
		replay(apiMock);
		assertTrue(jiraClient.addVersion());
		verify(apiMock);		
	}
	
	/**
	 * Test of invalid addVersion.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 * @throws RemoteException
	 */
	@Test
	public final void testInvalidAddVersion() throws JiraButlerException, java.rmi.RemoteException, RemoteException {
		String token = "token";
		String jiraProjectKey = "SWQ";
		String jiraProjectVersion = "v1.1";
		RemoteVersion newVersion = new RemoteVersion();
		newVersion.setName(jiraProjectVersion);
		
		jiraClient.setToken(token);
		jiraClient.setJiraProjectKey(jiraProjectKey);
		jiraClient.setJiraProjectVersion(jiraProjectVersion);
		
		expect(apiMock.addVersion(token, jiraProjectKey, newVersion)).andReturn(null).times(1);
		replay(apiMock);
		assertFalse(jiraClient.addVersion());
		verify(apiMock);		
	}
	
	/**
	 * Test of JiraButlerException for addVersion, if project key is null.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 * @throws RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testNullProjectKeyAddVersion() throws JiraButlerException, java.rmi.RemoteException, RemoteException {
		String jiraProjectVersion = "v1.1";
		
		jiraClient.setJiraProjectKey(null);
		jiraClient.setJiraProjectVersion(jiraProjectVersion);
		
		jiraClient.addVersion();
	}
	
	/**
	 * Test of JiraButlerException for addVersion, if project version is null.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 * @throws RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testNullProjectVersionAddVersion() throws JiraButlerException, java.rmi.RemoteException, RemoteException {
		String jiraProjectKey = "SWQ";
		
		jiraClient.setJiraProjectKey(jiraProjectKey);
		jiraClient.setJiraProjectVersion(null);
		
		jiraClient.addVersion();
	}
		
	/**
	 * Test of java.rmi.RemoteException for addVersion.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 * @throws RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testRMIRemoteExceptionAddVersion() throws JiraButlerException, java.rmi.RemoteException, RemoteException {
		String token = "token";
		String jiraProjectKey = "SWQ";
		String jiraProjectVersion = "v1.1";
		RemoteVersion newVersion = new RemoteVersion();
		newVersion.setName(jiraProjectVersion);
		
		jiraClient.setToken(token);
		jiraClient.setJiraProjectKey(jiraProjectKey);
		jiraClient.setJiraProjectVersion(jiraProjectVersion);
		
		expect(apiMock.addVersion(token, jiraProjectKey, newVersion)).andThrow(new java.rmi.RemoteException()).times(1);
		replay(apiMock);
		jiraClient.addVersion();
		verify(apiMock);		
	}
	
	/**
	 * Test of RemoteException for addVersion.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 * @throws RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testJIRARemoteExceptionAddVersion() throws JiraButlerException, java.rmi.RemoteException, RemoteException {
		String token = "token";
		String jiraProjectKey = "SWQ";
		String jiraProjectVersion = "v1.1";
		RemoteVersion newVersion = new RemoteVersion();
		newVersion.setName(jiraProjectVersion);
		
		jiraClient.setToken(token);
		jiraClient.setJiraProjectKey(jiraProjectKey);
		jiraClient.setJiraProjectVersion(jiraProjectVersion);
		
		expect(apiMock.addVersion(token, jiraProjectKey, newVersion)).andThrow(new RemoteException()).times(1);
		replay(apiMock);
		jiraClient.addVersion();
		verify(apiMock);		
	}
	
	/**
	 * Test of valid addComent.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 * @throws RemoteException
	 */
	@Test
	public final void testValidAddComment() throws JiraButlerException, java.rmi.RemoteException, RemoteException {
		String token = "token";
		String jiraIssueKey = "SWQ-11";
		String gitCommitMessage = "SWQ-11@Unser Test...";
		String username = "username";
		RemoteComment newComment = new RemoteComment();
		newComment.setBody(username + ": " + gitCommitMessage);
		
		jiraClient.setToken(token);
		jiraClient.setJiraIssueKey(jiraIssueKey);
		jiraClient.setGitCommitMessage(gitCommitMessage);
		jiraClient.setUsername(username);
				
		apiMock.addComment(token, jiraIssueKey, newComment);
		EasyMock.expectLastCall().atLeastOnce();
		replay(apiMock);
		assertTrue(jiraClient.addComment());
		verify(apiMock);		
	}
	
	/**
	 * Test of JiraButlerException for addComent, if invalid issue key.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 * @throws RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testInvalidIssueKeyAddComment() throws JiraButlerException, java.rmi.RemoteException, RemoteException {
		String token = "token";
		String jiraIssueKey = null;
		String gitCommitMessage = "SWQ-11@Unser Test...";
		String username = "username";
		RemoteComment newComment = new RemoteComment();
		newComment.setBody(username + ": " + gitCommitMessage);
		
		jiraClient.setToken(token);
		jiraClient.setJiraIssueKey(jiraIssueKey);
		jiraClient.setGitCommitMessage(gitCommitMessage);
		jiraClient.setUsername(username);
				
		jiraClient.addComment();		
	}
	
	/**
	 * Test of JiraButlerException for addComent, if invalid commit message.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 * @throws RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testInvalidCommitMessageAddComment() throws JiraButlerException, java.rmi.RemoteException, RemoteException {
		String token = "token";
		String jiraIssueKey = "SWQ-11";
		String gitCommitMessage = null;
		String username = "username";
		RemoteComment newComment = new RemoteComment();
		newComment.setBody(username + ": " + gitCommitMessage);
		
		jiraClient.setToken(token);
		jiraClient.setJiraIssueKey(jiraIssueKey);
		jiraClient.setGitCommitMessage(gitCommitMessage);
		jiraClient.setUsername(username);
				
		jiraClient.addComment();		
	}
	
	/**
	 * Test of JiraButlerException for addComent, if invalid username.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 * @throws RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testInvalidUsernameAddComment() throws JiraButlerException, java.rmi.RemoteException, RemoteException {
		String token = "token";
		String jiraIssueKey = "SWQ-11";
		String gitCommitMessage = "SWQ-11@Unser Test...";
		String username = null;
		RemoteComment newComment = new RemoteComment();
		newComment.setBody(username + ": " + gitCommitMessage);
		
		jiraClient.setToken(token);
		jiraClient.setJiraIssueKey(jiraIssueKey);
		jiraClient.setGitCommitMessage(gitCommitMessage);
		jiraClient.setUsername(username);
				
		jiraClient.addComment();		
	}
	
	/**
	 * Test of java.rmi.RemoteException for addComment.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 * @throws RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testRMIRemoteExceptionAddComment() throws JiraButlerException, java.rmi.RemoteException, RemoteException {
		String token = "token";
		String jiraIssueKey = "SWQ-11";
		String gitCommitMessage = "SWQ-11@Unser Test...";
		String username = "username";
		RemoteComment newComment = new RemoteComment();
		newComment.setBody(username + ": " + gitCommitMessage);
		
		jiraClient.setToken(token);
		jiraClient.setJiraIssueKey(jiraIssueKey);
		jiraClient.setGitCommitMessage(gitCommitMessage);
		jiraClient.setUsername(username);
		
		apiMock.addComment(token, jiraIssueKey, newComment);
		EasyMock.expectLastCall().andThrow(new java.rmi.RemoteException()).atLeastOnce();
		replay(apiMock);
		jiraClient.addVersion();
		verify(apiMock);		
	}
	
	/**
	 * Test of RemoteException for addComment.
	 * 
	 * @throws JiraButlerException
	 * @throws java.rmi.RemoteException
	 * @throws RemoteException
	 */
	@Test(expected = JiraButlerException.class)
	public final void testJIRARemoteExceptionAddComment() throws JiraButlerException, java.rmi.RemoteException, RemoteException {
		String token = "token";
		String jiraIssueKey = "SWQ-11";
		String gitCommitMessage = "SWQ-11@Unser Test...";
		String username = "username";
		RemoteComment newComment = new RemoteComment();
		newComment.setBody(username + ": " + gitCommitMessage);
		
		jiraClient.setToken(token);
		jiraClient.setJiraIssueKey(jiraIssueKey);
		jiraClient.setGitCommitMessage(gitCommitMessage);
		jiraClient.setUsername(username);
		
		apiMock.addComment(token, jiraIssueKey, newComment);
		EasyMock.expectLastCall().andThrow(new RemoteException()).atLeastOnce();
		replay(apiMock);
		jiraClient.addVersion();
		verify(apiMock);		
	}
	
}
