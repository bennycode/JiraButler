package de.angelcode.jirabutler.webserver;

import de.angelcode.jirabutler.exceptions.JiraButlerException;

/**
 * Provides the main-mathod to start the server.
 * @author Benny Neugebauer (www.bennyn.de)
 */
public class Main
{

  /**
   * Main entry point for the server. Accepts options and is able to start the server.
   **/
  public static void main(String[] argv)
  {
    ServerStart start = new ServerStart(argv);
    try
    {
      start.handleParameters();
    }
    catch (JiraButlerException ex)
    {
      System.out.println("Server could not be started: "+ex.getLocalizedMessage());
    }
  }
}
