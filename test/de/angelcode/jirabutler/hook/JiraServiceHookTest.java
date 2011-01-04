package de.angelcode.jirabutler.hook;

import de.angelcode.jirabutler.exceptions.JiraButlerException;
import de.angelcode.jirabutler.test.RequestValues;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test-class for the JiraServiceHook.
 * @author bennyn
 */
public class JiraServiceHookTest
{
  private JiraServiceHook hook;
  private String githubRequest;

  public JiraServiceHookTest()
  {
    this.hook = null;
    this.githubRequest = null;
  }

  @Test
  public void testUsernameParsing() throws JiraButlerException
  {
    String expected = "bennyn";
    String result = null;

    githubRequest = RequestValues.getRequest1();
    hook = new JiraServiceHook();
    hook.setGithubRequest(githubRequest);
    hook.convertGithubRequestToJson();
    hook.parseGithubJson();
    result = hook.getUsername();

    assertEquals("Test if a username can be parsed from a github request.", expected, result);
  }

  @Test
  public void testInitConstructor() throws JiraButlerException
  {
    String expected = "bennyn";
    String result = null;

    githubRequest = RequestValues.getRequest1();
    hook = new JiraServiceHook(githubRequest);
    hook.convertGithubRequestToJson();
    hook.parseGithubJson();
    result = hook.getUsername();

    assertEquals("Test if a username can be parsed from a github request.", expected, result);
  }
}
