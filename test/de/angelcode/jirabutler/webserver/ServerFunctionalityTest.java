package de.angelcode.jirabutler.webserver;

import static org.easymock.EasyMock.createStrictMock;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import de.angelcode.jirabutler.exceptions.JiraButlerException;
import de.angelcode.jirabutler.test.RequestValues;

public class ServerFunctionalityTest {

	private ServerFunctionality serverFunctionality;
	private String clientRequest;

	@Before
	public void setUp() {
		serverFunctionality = new ServerFunctionality();
	}

	@Test
	public void testValidHandleRequest() throws JiraButlerException {
		serverFunctionality.handleRequest(clientRequest);
	}

	@Test(expected = JiraButlerException.class)
	public void testJiraButlerExceptionHandleRequest()
			throws JiraButlerException {
		clientRequest = RequestValues.getRequest1();
		serverFunctionality.handleRequest(clientRequest);
	}

}
