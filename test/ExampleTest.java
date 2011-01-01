import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleTest
{
	public ExampleTest()
	{
		super();
	}

	@BeforeClass
	public static void setUpClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownClass() throws Exception
	{
	}

  @Test
  public void testWillAlwaysFail()
  {
    fail("An error message");
  }
}