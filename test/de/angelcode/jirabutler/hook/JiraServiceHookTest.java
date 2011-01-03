/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.angelcode.jirabutler.hook;

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
public class JiraServiceHookTest {

    public JiraServiceHookTest() {
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
   * Test of toString method, of class JiraServiceHook.
   */
  @Test
  public void testToString()
  {
    System.out.println("toString");
    JiraServiceHook instance = new JiraServiceHook();
    String expResult = "";
    String result = instance.toString();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

}