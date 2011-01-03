/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.angelcode.jirabutler.soap.service;

import com.atlassian.jira.rpc.soap.beans.RemoteComment;
import com.atlassian.jira.rpc.soap.beans.RemoteVersion;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BoatoonAdmin
 */
public class JiraClientTest
{

  public JiraClientTest()
  {
  }

  @BeforeClass
  public static void setUpClass() throws Exception
  {
  }

  @AfterClass
  public static void tearDownClass() throws Exception
  {
  }

  /**
   * Test of login method, of class JiraClient.
   */
  @Test
  public void testLogin() throws Exception
  {
    System.out.println("login");
    String user = "";
    String password = "";
    JiraClient instance = new JiraClient();
    boolean expResult = false;
    boolean result = instance.login(user, password);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of logout method, of class JiraClient.
   */
  @Test
  public void testLogout() throws Exception
  {
    System.out.println("logout");
    JiraClient instance = new JiraClient();
    boolean expResult = false;
    boolean result = instance.logout();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of addVersion method, of class JiraClient.
   */
  @Test
  public void testAddVersion() throws Exception
  {
    System.out.println("addVersion");
    String jiraProjectKey = "";
    RemoteVersion version = null;
    JiraClient instance = new JiraClient();
    boolean expResult = false;
    boolean result = instance.addVersion(jiraProjectKey, version);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of addComment method, of class JiraClient.
   */
  @Test
  public void testAddComment() throws Exception
  {
    System.out.println("addComment");
    String jiraProjectKey = "";
    RemoteComment comment = null;
    JiraClient instance = new JiraClient();
    boolean expResult = false;
    boolean result = instance.addComment(jiraProjectKey, comment);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getVersions method, of class JiraClient.
   */
  @Test
  public void testGetVersions() throws Exception
  {
    System.out.println("getVersions");
    String jiraProjectKey = "";
    JiraClient instance = new JiraClient();
    ArrayList expResult = null;
    ArrayList result = instance.getVersions(jiraProjectKey);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
}
