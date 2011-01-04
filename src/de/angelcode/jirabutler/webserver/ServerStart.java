package de.angelcode.jirabutler.webserver;

import de.angelcode.jirabutler.exceptions.JiraButlerException;
import de.angelcode.jirabutler.util.SystemVariables;
import gnu.getopt.Getopt;
import gnu.getopt.LongOpt;

/**
 * Provides the main-mathod to start the server.
 * @author Benny Neugebauer (www.bennyn.de)
 */
public class ServerStart
{

  /**
   * Main entry point for the server. Accepts options and is able to start the server.
   **/
  public static void main(String[] argv)
  {
    // Control variables
    int option = -1;
    String command = null;
    Server server = null;

    // Program information        
    String programExecutable = "Server.jar";
    String programName = "JiraButler";
    String programVersion = "v0.1";

    // Presets
    String serverPort = "7070";
    StringBuffer logFilePath = new StringBuffer(SystemVariables.getJarExecutionDirectory()
            + "jira-butler.log");

    // Long option names
    LongOpt[] optionsLong = new LongOpt[4];
    optionsLong[0] = new LongOpt("port", LongOpt.OPTIONAL_ARGUMENT, null, 'p');
    optionsLong[1] = new LongOpt("log", LongOpt.OPTIONAL_ARGUMENT, logFilePath, 'l');
    optionsLong[2] = new LongOpt("help", LongOpt.NO_ARGUMENT, null, 'h');
    optionsLong[3] = new LongOpt("version", LongOpt.NO_ARGUMENT, null, 'v');

    // GetOpt
    Getopt g = new Getopt(programExecutable, argv, "-:p:l:hv", optionsLong);
    g.setOpterr(false);

    while ((option = g.getopt()) != -1)
    {
      switch (option)
      {
        case 1:
          command = g.getOptarg();
          if (command.equals("start"))
          {
            System.out.println("Starting server...");
            server = new Server(serverPort, logFilePath.toString());
          }
          else
          {
            System.out.println("Wrong parameters. Please read the manual.");
          }
          break;
        case 'h':
          System.out.println("I see you asked for help.\n");
          System.out.println("To get the program running you have to say 'start' to it in that way:");
          System.out.println("java -jar " + programExecutable + " start\n");
          System.out.println("You can also use some options. Like:");
          System.out.println("java -jar " + programExecutable + " -p 7777 -l /var/log/the_servers_logfile.log start\n");
          System.out.println("The following command is equivalent:");
          System.out.println("java -jar " + programExecutable + " --port 7777 --log /var/log/the_servers_logfile.log start\n");
          System.out.println("\nLet me explain all options available to you:\n");
          System.out.println("Listening port (optional):");
          System.out.println("-p\t--port\t\tDefines the port on which the server should listen.");
          System.out.println("\t\t\t(I recommend ports between 49152 and 65535.)");
          System.out.println("");
          System.out.println("Log file path (optional):");
          System.out.println("-l\t--log\t\tThe place where the server's log file should be stored.");
          System.out.println("\t\t\t(e.g. /var/log/jira-butler.log)");
          System.out.println("");
          System.out.println("Help texts:");
          System.out.println("-h\t--help\t\tHelp texts to get the program running.");
          System.out.println("");
          System.out.println("Version number:");
          System.out.println("-v\t--version\tPrints the version number.");
          System.out.println("");
          System.out.println("Note:");
          System.out.println("If you do not set a port, then this application will take port \"" + serverPort + "\".");
          System.out.println("If you do not set a path for the log file, then this application will take \"" + logFilePath + "\".");
          break;
        case 'l':
          logFilePath = new StringBuffer(g.getOptarg());
          break;
        case 'p':
          serverPort = new StringBuffer(g.getOptarg()).toString();
          break;
        case 'v':
          System.out.println(programName + " " + programVersion);
          break;
        case ':':
        case '?':
        default:
          System.out.println("Wrong parameters.");
          System.out.println("Please use 'java -jar " + programExecutable + " -h' to get help.");
          break;
      }
    }
  }
}
