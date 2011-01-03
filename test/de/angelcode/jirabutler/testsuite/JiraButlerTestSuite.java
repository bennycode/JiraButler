/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.angelcode.jirabutler.testsuite;

import de.angelcode.jirabutler.hook.JiraServiceHookTest;
import de.angelcode.jirabutler.soap.JiraControllerTest;
import de.angelcode.jirabutler.soap.service.JiraClientTest;
import de.angelcode.jirabutler.util.SystemVariablesTest;
import de.angelcode.jirabutler.webserver.*;
import de.angelcode.jirabutler.webserver.ServerTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author BoatoonAdmin
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({JiraServiceHookTest.class, JiraControllerTest.class, JiraClientTest.class, SystemVariablesTest.class, ConnectionHandlerTest.class, ServerFunctionalityTest.class, ServerLoggerTest.class, ServerStartTest.class})
public class JiraButlerTestSuite {

  @BeforeClass
  public static void setUpClass() throws Exception
  {
  }

  @AfterClass
  public static void tearDownClass() throws Exception
  {
  }

  @Before
  public void setUp() throws Exception
  {
  }

  @After
  public void tearDown() throws Exception
  {
  }

}