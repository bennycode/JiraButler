package de.angelcode.jirabutler.hook;

import java.util.NoSuchElementException;
import com.atlassian.jira.exception.ParseException;
import de.angelcode.jirabutler.exceptions.JiraButlerException;
import de.angelcode.jirabutler.test.RequestValues;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test-class for the JiraServiceHook.
 * 
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

  @Test(expected = StringIndexOutOfBoundsException.class)
  public void testconvertGithubRequestToJsonWithAnEmptyRequest()
  {
    this.githubRequest = RequestValues.getRequest6();
    this.hook = new JiraServiceHook(this.githubRequest);
    this.hook.convertGithubRequestToJson();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testconvertGithubRequestToJsonWithANotValidPayload()
  {
    this.githubRequest = RequestValues.getRequest7();
    this.hook = new JiraServiceHook(this.githubRequest);
    this.hook.convertGithubRequestToJson();
  }

  @Test
  public void testconvertGithubRequestToJsonWithAValidRequest()
  {
    String expect = "{\"ref\":\"refs/heads/master\",\"repository\":{\"forks\":1,\"created_at\":\"2010/12/30 20:28:05 -0800\",\"has_wiki\":true,\"url\":\"https://github.com/bennyn/JiraButler\",\"open_issues\":0,\"description\":\"Test\",\"fork\":false,\"pushed_at\":\"2011/01/03 20:43:07 -0800\",\"has_issues\":true,\"private\":false,\"has_downloads\":true,\"owner\":{\"email\":\"bn@bennyn.de\",\"name\":\"bennyn\"},\"watchers\":4,\"name\":\"JiraButler\",\"homepage\":\"\"},\"commits\":[{\"author\":{\"email\":\"bn@bennyn.de\",\"username\":\"bennyn\",\"name\":\"Benny Neugebauer\"},\"timestamp\":\"2011-01-03T20:42:35-08:00\",\"removed\":[\"build/jar/html/favicon.ico\",\"build2.xml\"],\"url\":\"https://github.com/bennyn/JiraButler/commit/b2f42f15cf91de9fa6702f70a3412c15438e91f3\",\"message\":\"SWQ-11@Cobertura inside!\",\"added\":[],\"modified\":[\"build.properties\",\"build.xml\",\"cobertura.ser\",\"test/de/angelcode/jirabutler/hook/JiraServiceHookTest.java\"],\"id\":\"b2f42f15cf91de9fa6702f70a3412c15438e91f3\"}],\"forced\":false,\"before\":\"3e55fd24b662a02498be1f6a0c334f712012290d\",\"pusher\":{\"email\":\"bn@bennyn.de\",\"name\":\"bennyn\"},\"after\":\"b2f42f15cf91de9fa6702f70a3412c15438e91f3\",\"compare\":\"https://github.com/bennyn/JiraButler/compare/3e55fd2...b2f42f1\"}";

    this.githubRequest = RequestValues.getRequest8();
    this.hook = new JiraServiceHook(this.githubRequest);
    this.hook.convertGithubRequestToJson();

    String result = this.hook.getPayloadUnicode();

    assertEquals("Returns a valid JSON string", expect, result);
  }

  @Test
  public void testParseUsernameWithAValidUsername()
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

  @Test(expected=NoSuchElementException.class)
  public void testParseUsernameWithoutTheKeyMessageInTheJSON()
  {
    githubRequest = RequestValues.getRequest9();
    hook = new JiraServiceHook();
    hook.setGithubRequest(githubRequest);
    hook.convertGithubRequestToJson();
    hook.parseGithubJson();
  }

  @Test(expected=NullPointerException.class)
  public void testParseUsernameWithoutTheKeyUsernameInTheJSON()
  {
    githubRequest = RequestValues.getRequest10();
    hook = new JiraServiceHook();
    hook.setGithubRequest(githubRequest);
    hook.convertGithubRequestToJson();
    hook.parseGithubJson();
  }

  @Test
  public void testParseValidMessage() throws JiraButlerException
  {
    String expected = "Cobertura inside!";
    String result = null;

    githubRequest = RequestValues.getRequest1();
    hook = new JiraServiceHook(githubRequest);
    hook.convertGithubRequestToJson();
    hook.parseGithubJson();
    result = hook.getGitCommitMessage();

    assertEquals("Test if a message with a valid JIRA issue key can be parsed from a github request.", expected, result);
  }

  @Test
  public void testParseInvalidMessageWithoutIssueKey() throws JiraButlerException
  {
    String expected = null;
    String result = null;

    githubRequest = RequestValues.getRequest5();
    hook = new JiraServiceHook(githubRequest);
    hook.convertGithubRequestToJson();
    hook.parseGithubJson();
    result = hook.getJiraIssueKey();

    assertEquals("Test if a message without a JIRA issue key can be parsed from a github request.", expected, result);
  }

  @Test
  public void testToString() throws JiraButlerException
  {
    String expected = "Project version: master\nJIRA Key: SWQ-11\nUser: bennyn\nCommit message: Cobertura inside!\n";
    String result = null;

    githubRequest = RequestValues.getRequest1();
    hook = new JiraServiceHook(githubRequest);
    hook.convertGithubRequestToJson();
    hook.parseGithubJson();
    result = hook.toString();

    assertEquals("Test if toString() method works correctly.", expected, result);
  }

  @Test
  public void testParseProjectVersion() throws JiraButlerException
  {
    String expected = "master";
    String result = null;

    githubRequest = RequestValues.getRequest1();
    hook = new JiraServiceHook(githubRequest);
    hook.convertGithubRequestToJson();
    hook.parseGithubJson();
    result = hook.getJiraProjectVersion();

    assertEquals("Test if a JIRA project version can be parsed from a github request.", expected, result);
  }
}