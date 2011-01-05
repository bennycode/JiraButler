package de.angelcode.jirabutler.webserver;


import org.junit.Before;
import org.junit.Test;

import de.angelcode.jirabutler.exceptions.JiraButlerException;

public class ServerFunctionalityTest
{

  private ServerFunctionality serverFunctionality;
  private String clientRequest;

  @Before
  public void setUp()
  {
    serverFunctionality = new ServerFunctionality();
  }

  @Test
  public void testValidHandleRequest() throws JiraButlerException
  {
    serverFunctionality.handleRequest(clientRequest);
  }
}
