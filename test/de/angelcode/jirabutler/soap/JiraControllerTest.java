/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.angelcode.jirabutler.soap;

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
public class JiraControllerTest {

    public JiraControllerTest() {
    }

  @BeforeClass
  public static void setUpClass() throws Exception
  {
  }

  @AfterClass
  public static void tearDownClass() throws Exception
  {
  }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

  /**
   * Test of loadConfigFile method, of class JiraController.
   */
  @Test
  public void testLoadConfigFile() throws Exception
  {
    System.out.println("loadConfigFile");
    JiraController instance = new JiraController();
    instance.loadConfigFile();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of connect method, of class JiraController.
   */
  @Test
  public void testConnect() throws Exception
  {
    System.out.println("connect");
    JiraController instance = new JiraController();
    boolean expResult = false;
    boolean result = instance.connect();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of addVersion method, of class JiraController.
   */
  @Test
  public void testAddVersion() throws Exception
  {
    System.out.println("addVersion");
    JiraController instance = new JiraController();
    instance.addVersion();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of addComment method, of class JiraController.
   */
  @Test
  public void testAddComment() throws Exception
  {
    System.out.println("addComment");
    JiraController instance = new JiraController();
    boolean expResult = false;
    boolean result = instance.addComment();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

}