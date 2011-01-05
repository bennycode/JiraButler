package de.angelcode.jirabutler.hook;

import com.atlassian.jira.exception.ParseException;
import java.io.UnsupportedEncodingException;
import org.easymock.EasyMock;
import de.angelcode.jirabutler.exceptions.JiraButlerException;
import de.angelcode.jirabutler.test.RequestValues;
import java.net.URLDecoder;
import org.easymock.IExpectationSetters;
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

  @Test(expected = StringIndexOutOfBoundsException.class)
  public void testconvertGithubRequestToJsonWithAnEmptyRequest() throws JiraButlerException
  {
    this.githubRequest = RequestValues.getRequest6();
    this.hook = new JiraServiceHook(this.githubRequest);
    this.hook.convertGithubRequestToJson();
  }

  @Test(expected = UnsupportedEncodingException.class)
  public void testconvertGithubRequestToJsonWithANotValidPayload() throws JiraButlerException
  {
    this.githubRequest = RequestValues.getRequest6();
    this.hook = new JiraServiceHook(this.githubRequest);
    this.hook.convertGithubRequestToJson();
  }

  @Test
  public void testParseUsername() throws JiraButlerException
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

//  @Test
//  public void testInitConstructor() throws JiraButlerException
//  {
//    String expected = "bennyn";
//    String result = null;
//
//    githubRequest = RequestValues.getRequest1();
//    hook = new JiraServiceHook(githubRequest);
//    hook.convertGithubRequestToJson();
//    hook.parseGithubJson();
//    result = hook.getUsername();
//
//    assertEquals("Test if a username can be parsed from a github request.", expected, result);
//  }

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

  @Test(expected = ParseException.class)
  public void testParseGithubRequestWithoutPayloadInformation() throws JiraButlerException
  {
    String expected = null;
    String result = null;

    githubRequest = "payload=";
    hook = new JiraServiceHook();
    hook.setGithubRequest(githubRequest);
    hook.convertGithubRequestToJson();
  }

//  @Test(expected = UnsupportedEncodingException.class)
//  public void testEncodingException() throws UnsupportedEncodingException, JiraButlerException
//  {
//    String payloadAscii = RequestValues.getRequest1();
//    String encoding = "UnsupportedEncoding";
//
//    URLDecoder decoderMock = EasyMock.createStrictMock(URLDecoder.class);
//    IExpectationSetters<String> andThrow = EasyMock.expect(URLDecoder.decode(payloadAscii, encoding)).andThrow(new UnsupportedEncodingException());
//    EasyMock.replay(decoderMock);

//    JiraServiceHook mock = EasyMock.createStrictMock(JiraServiceHook.class);
//    EasyMock.expect(mock.convertGithubRequestToJson(githubRequest)).andThrow(new UnsupportedEncodingException());
//    EasyMock.replay(mock);

//    hook = new JiraServiceHook();
//    hook.setGithubRequest(githubRequest);
//    assertFalse(hook.convertGithubRequestToJson());
//
//    EasyMock.verify(decoderMock);

//    hook = new JiraServiceHook();
//    assertFalse(hook.convertGithubRequestToJson(githubRequest));
//
//    EasyMock.verify(decoderMock);
//  }
}
