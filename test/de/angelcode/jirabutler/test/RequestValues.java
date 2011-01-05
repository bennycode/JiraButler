package de.angelcode.jirabutler.test;

/**
 * Delivers some values for testing purpose.
 * @author bennyn
 */
public class RequestValues
{

  /**
   * Returns a valid POST request from github with commit message: SWQ-11@Cobertura inside!
   * @return request
   */
  public static String getRequest1()
  {
    String request = "POST / HTTP/1.1\n"
            + "Accept: */*\n"
            + "Content-Type: application/x-www-form-urlencoded\n"
            + "Content-Length: 21561\n"
            + "Host: angelcode.de:7070\n"
            + "\n"
            + "payload=%7b%22ref%22%3a%22refs%5c%2fheads%5c%2fmaster%22%2c%22repository%22%3a%7b%22forks%22%3a1%2c%22created_at%22%3a%222010%2f12%2f30%2020%3a28%3a05%20-0800%22%2c%22has_wiki%22%3atrue%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%22%2c%22open_issues%22%3a0%2c%22description%22%3a%22Test%22%2c%22fork%22%3afalse%2c%22pushed_at%22%3a%222011%2f01%2f03%2020%3a43%3a07%20-0800%22%2c%22has_issues%22%3atrue%2c%22private%22%3afalse%2c%22has_downloads%22%3atrue%2c%22owner%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22bennyn%22%7d%2c%22watchers%22%3a4%2c%22name%22%3a%22JiraButler%22%2c%22homepage%22%3a%22%22%7d%2c%22commits%22%3a%5b%7b%22author%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22username%22%3a%22bennyn%22%2c%22name%22%3a%22Benny%20Neugebauer%22%7d%2c%22timestamp%22%3a%222011-01-03T20%3a42%3a35-08%3a00%22%2c%22removed%22%3a%5b%22build%5c%2fjar%5c%2fhtml%5c%2ffavicon.ico%22%2c%22build2.xml%22%5d%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%5c%2fcommit%5c%2fb2f42f15cf91de9fa6702f70a3412c15438e91f3%22%2c%22message%22%3a%22SWQ-11%40Cobertura%20inside%21%22%2c%22added%22%3a%5b%5d%2c%22modified%22%3a%5b%22build.properties%22%2c%22build.xml%22%2c%22cobertura.ser%22%2c%22test%5c%2fde%5c%2fangelcode%5c%2fjirabutler%5c%2fhook%5c%2fJiraServiceHookTest.java%22%5d%2c%22id%22%3a%22b2f42f15cf91de9fa6702f70a3412c15438e91f3%22%7d%5d%2c%22forced%22%3afalse%2c%22before%22%3a%223e55fd24b662a02498be1f6a0c334f712012290d%22%2c%22pusher%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22bennyn%22%7d%2c%22after%22%3a%22b2f42f15cf91de9fa6702f70a3412c15438e91f3%22%2c%22compare%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%5c%2fcompare%5c%2f3e55fd2...b2f42f1%22%7d";
    return request;
  }

  /**
   * Returns a valid GET request from Mozilla Firefox which requests the index-page (/).
   * @return request
   */
  public static String getRequest2()
  {
    String request = "GET / HTTP/1.1\n"
            + "Host: angelcode.de:7070\n"
            + "User-Agent: Mozilla/5.0 (Windows; U; Windows NT 6.1; de; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13\n"
            + "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n"
            + "Accept-Language: de-de,de;q=0.8,en-us;q=0.5,en;q=0.3\n"
            + "Accept-Encoding: gzip,deflate\n"
            + "Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7\n"
            + "Keep-Alive: 115\n"
            + "Connection: keep-alive\n"
            + "";
    return request;
  }

  /**
   * Returns a valid GET request from Mozilla Firefox which requests 'sample.html'.
   * @return request
   */
  public static String getRequest3()
  {
    String request = "GET /sample.html HTTP/1.1\n"
            + "Host: localhost:7070\n"
            + "User-Agent: Mozilla/5.0 (Windows; U; Windows NT 6.1; de; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13\n"
            + "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n"
            + "Accept-Language: de-de,de;q=0.8,en-us;q=0.5,en;q=0.3\n"
            + "Accept-Encoding: gzip,deflate\n"
            + "Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7\n"
            + "Keep-Alive: 115\n"
            + "Connection: keep-alive\n"
            + "";
    return request;
  }

  /**
   * Returns a valid GET request from Mozilla Firefox which requests 'favicon.ico'.
   * TODO: The server should deliver this 'favicon.ico' as Content-Type: image/vnd.microsoft.icon or image/x-icon.
   */
  public static String getRequest4()
  {
    String request = "GET /favicon.ico HTTP/1.1\n"
            + "Host: angelcode.de:7070\n"
            + "User-Agent: Mozilla/5.0 (Windows; U; Windows NT 6.1; de; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13\n"
            + "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n"
            + "Accept-Language: de-de,de;q=0.8,en-us;q=0.5,en;q=0.3\n"
            + "Accept-Encoding: gzip,deflate\n"
            + "Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7\n"
            + "Keep-Alive: 115\n"
            + "Connection: keep-alive\n"
            + "\n";
    return request;
  }

  /**
   * Returns a valid POST request from github with an unsufficient commit message (does not contain an JIRA issue key).
   * @return request
   */
  public static String getRequest5()
  {
    String request = "POST / HTTP/1.1\n"
            + "Accept: */*\n"
            + "Content-Type: application/x-www-form-urlencoded\n"
            + "Content-Length: 21561\n"
            + "Host: angelcode.de:7070\n"
            + "\n"
            + "payload=%7b%22ref%22%3a%22refs%5c%2fheads%5c%2fmaster%22%2c%22repository%22%3a%7b%22forks%22%3a1%2c%22created_at%22%3a%222010%2f12%2f30%2020%3a28%3a05%20-0800%22%2c%22has_wiki%22%3atrue%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%22%2c%22open_issues%22%3a0%2c%22description%22%3a%22Test%22%2c%22fork%22%3afalse%2c%22pushed_at%22%3a%222011%2f01%2f03%2020%3a43%3a07%20-0800%22%2c%22has_issues%22%3atrue%2c%22private%22%3afalse%2c%22has_downloads%22%3atrue%2c%22owner%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22bennyn%22%7d%2c%22watchers%22%3a4%2c%22name%22%3a%22JiraButler%22%2c%22homepage%22%3a%22%22%7d%2c%22commits%22%3a%5b%7b%22author%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22username%22%3a%22bennyn%22%2c%22name%22%3a%22Benny%20Neugebauer%22%7d%2c%22timestamp%22%3a%222011-01-03T20%3a42%3a35-08%3a00%22%2c%22removed%22%3a%5b%22build%5c%2fjar%5c%2fhtml%5c%2ffavicon.ico%22%2c%22build2.xml%22%5d%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%5c%2fcommit%5c%2fb2f42f15cf91de9fa6702f70a3412c15438e91f3%22%2c%22message%22%3a%22Cobertura%20inside%21%22%2c%22added%22%3a%5b%5d%2c%22modified%22%3a%5b%22build.properties%22%2c%22build.xml%22%2c%22cobertura.ser%22%2c%22test%5c%2fde%5c%2fangelcode%5c%2fjirabutler%5c%2fhook%5c%2fJiraServiceHookTest.java%22%5d%2c%22id%22%3a%22b2f42f15cf91de9fa6702f70a3412c15438e91f3%22%7d%5d%2c%22forced%22%3afalse%2c%22before%22%3a%223e55fd24b662a02498be1f6a0c334f712012290d%22%2c%22pusher%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22bennyn%22%7d%2c%22after%22%3a%22b2f42f15cf91de9fa6702f70a3412c15438e91f3%22%2c%22compare%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%5c%2fcompare%5c%2f3e55fd2...b2f42f1%22%7d";
    return request;
  }

    /**
   * Returns an empty POST Request
   * @return request
   */
  public static String getRequest6()
  {
    String request = "";
    return request;
  }

   /**
   * Returns an empty POST Request
   * @return request
   */
  public static String getRequest7()
  {
    String request = "POST / HTTP/1.1\n"
            + "Accept: */*\n"
            + "Content-Type: application/x-www-form-urlencoded\n"
            + "Content-Length: 21561\n"
            + "Host: angelcode.de:7070\n"
            + "\n"
            + "payload=%7bref%22%3a%22refs%5c%2fheads%5c%2fmaster%22%2c%22repository%22%3a%7b%22forks%22%3a1%2c%22created_at%22%3a%222010%2f12%2f30%2020%3a28%3a05%20-0800%22%2c%22has_wiki%22%3atrue%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%22%2c%22open_issues%22%3a0%2c%22description%22%3a%22Test%22%2c%22fork%22%3afalse%2c%22pushed_at%22%3a%222011%2f01%2f03%2020%3a43%3a07%20-0800%22%2c%22has_issues%22%3atrue%2c%22private%22%3afalse%2c%22has_downloads%22%3atrue%2c%22owner%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22bennyn%22%7d%2c%22watchers%22%3a4%2c%22name%22%3a%22JiraButler%22%2c%22homepage%22%3a%22%22%7d%2c%22commits%22%3a%5b%7b%22author%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22username%22%3a%22bennyn%22%2c%22name%22%3a%22Benny%20Neugebauer%22%7d%2c%22timestamp%22%3a%222011-01-03T20%3a42%3a35-08%3a00%22%2c%22removed%22%3a%5b%22build%5c%2fjar%5c%2fhtml%5c%2ffavicon.ico%22%2c%22build2.xml%22%5d%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%5c%2fcommit%5c%2fb2f42f15cf91de9fa6702f70a3412c15438e91f3%22%2c%22message%22%3a%22SWQ-11%40Cobertura%20inside%21%22%2c%22added%22%3a%5b%5d%2c%22modified%22%3a%5b%22build.properties%22%2c%22build.xml%22%2c%22cobertura.ser%22%2c%22test%5c%2fde%5c%2fangelcode%5c%2fjirabutler%5c%2fhook%5c%2fJiraServiceHookTest.java%22%5d%2c%22id%22%3a%22b2f42f15cf91de9fa6702f70a3412c15438e91f3%22%7d%5d%2c%22forced%22%3afalse%2c%22before%22%3a%223e55fd24b662a02498be1f6a0c334f712012290d%22%2c%22pusher%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22bennyn%22%7d%2c%22after%22%3a%22b2f42f15cf91de9fa6702f70a3412c15438e91f3%22%2c%22compare%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%5c%2fcompare%5c%2f3e55fd2...b2f42f1%22%7d";
    return request;
  }

  public static String getPayloadAscii()
  {
    return "payload=%7b%22before%22%3a%222defbf56e1de2b1807118cd013bf8980471fabd5%22%2c%22commits%22%3a%5b%7b%22author%22%3a%7b%22username%22%3a%22bennyn%22%2c%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22Benny%20Neugebauer%22%7d%2c%22timestamp%22%3a%222011-01-01T10%3a04%3a10-08%3a00%22%2c%22added%22%3a%5b%5d%2c%22message%22%3a%22SWQ-8@Updated%20JAR%22%2c%22modified%22%3a%5b%22build%5c%2fjar%5c%2fJiraButler-0.1.jar%22%5d%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%5c%2fcommit%5c%2f04c18485d4a6394eaf7afa7c4aa36f28d95eb9e9%22%2c%22removed%22%3a%5b%5d%2c%22id%22%3a%2204c18485d4a6394eaf7afa7c4aa36f28d95eb9e9%22%7d%5d%2c%22after%22%3a%2204c18485d4a6394eaf7afa7c4aa36f28d95eb9e9%22%2c%22pusher%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22bennyn%22%7d%2c%22repository%22%3a%7b%22has_downloads%22%3atrue%2c%22has_wiki%22%3atrue%2c%22watchers%22%3a1%2c%22description%22%3a%22Test%22%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%22%2c%22fork%22%3afalse%2c%22open_issues%22%3a0%2c%22private%22%3afalse%2c%22forks%22%3a1%2c%22pushed_at%22%3a%222011%2f01%2f01%2010%3a04%3a17%20-0800%22%2c%22created_at%22%3a%222010%2f12%2f30%2020%3a28%3a05%20-0800%22%2c%22owner%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22bennyn%22%7d%2c%22name%22%3a%22JiraButler%22%2c%22has_issues%22%3atrue%2c%22homepage%22%3a%22%22%7d%2c%22compare%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%5c%2fcompare%5c%2f2defbf5...04c1848%22%2c%22ref%22%3a%22refs%5c%2fheads%5c%2fmaster%22%2c%22forced%22%3afalse%7d";
  }
}
