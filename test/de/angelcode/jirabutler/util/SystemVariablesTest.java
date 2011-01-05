package de.angelcode.jirabutler.util;

import org.junit.Test;

/**
<<<<<<< HEAD
 *
 * @author danielp
 */
public class SystemVariablesTest
{

  /**
   * Test of getJarExecutionDirectory method, of class SystemVariables.
   */
  @Test
  public void testGetJarExecutionDirectory()
  {
    String result = SystemVariables.getJarExecutionDirectory();
    assertNotNull("Test if the directory, from which the JAR file is executed, can be found.", result);
  }
=======
 * 
 * @author danielp
 */
public class SystemVariablesTest {

	private String path;

	public SystemVariablesTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of getJarExecutionDirectory method, of class SystemVariables.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetJarExecutionDirectoryIfTheKeyIsEmpty() {
		SystemVariables.setJavaClassPath("");
		SystemVariables.setFileSeperator("");
		this.path = SystemVariables.getJarExecutionDirectory();
	}

	/**
	 * Test of getJarExecutionDirectory method, of class SystemVariables.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetJarExecutionDirectoryIfTheKeyIsNull() {
		SystemVariables.setJavaClassPath(null);
		SystemVariables.setFileSeperator(null);
		this.path = SystemVariables.getJarExecutionDirectory();
	}
>>>>>>> origin/master
}
