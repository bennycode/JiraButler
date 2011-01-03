package de.angelcode.rpc.soap.service;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.angelcode.jirabutler.exceptions.VoidParameterException;
import de.angelcode.jirabutler.soap.service.JiraClient;
import de.angelcode.jirabutler.soap.service.JiraSoapService;

public class JiraClientImplTest
{

  private JiraClient jiraClient;
  private JiraSoapService apiMock;

  @Before
  public void setUp() throws Exception
  {
    jiraClient = new JiraClient();
    apiMock = createStrictMock(JiraSoapService.class);
    jiraClient.setApi(apiMock);
  }

  @Test
  public final void testValidLogin() throws Exception
  {
    String token = new String();
    String user = "testUser";
    String password = "testPassword";

    expect(apiMock.login(user, password)).andReturn(token).times(1);
    replay(apiMock);
    assertTrue(jiraClient.login(user, password));
    verify(apiMock);
  }

  @Test
  public final void testInvalidLogin() throws Exception
  {
    String user = "testUser";
    String password = "testPassword";

    expect(apiMock.login(user, password)).andReturn(null).times(1);
    replay(apiMock);
    assertFalse(jiraClient.login(user, password));
    verify(apiMock);
  }

  @Test(expected = VoidParameterException.class)
  public final void testVoidLogin() throws Exception
  {
    String user = "";
    String password = "";
    boolean login = jiraClient.login(user, password);
  }
}
