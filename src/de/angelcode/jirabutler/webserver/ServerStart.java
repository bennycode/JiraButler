package de.angelcode.jirabutler.webserver;

import de.angelcode.jirabutler.exceptions.JiraButlerException;
import de.angelcode.jirabutler.util.SystemVariables;
import gnu.getopt.Getopt;
import gnu.getopt.LongOpt;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Provides the main-mathod to start the server.
 * 
 * @author Benny Neugebauer (www.bennyn.de)
 */
public class ServerStart {

	/**
	 * Main entry point for the server. Accepts options and is able to start the
	 * server.
	 **/
	public static void main(String[] argv) throws UnsupportedEncodingException {
		// Control variables
    
    String payloadUnicode = URLDecoder.decode("payload=%7b%22ref%22%3a%22refs%5c%2fheads%5c%2fmaster%22%2c%22repository%22%3a%7b%22forks%22%3a1%2c%22created_at%22%3a%222010%2f12%2f30%2020%3a28%3a05%20-0800%22%2c%22has_wiki%22%3atrue%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%22%2c%22open_issues%22%3a0%2c%22description%22%3a%22Test%22%2c%22fork%22%3afalse%2c%22pushed_at%22%3a%222011%2f01%2f03%2020%3a43%3a07%20-0800%22%2c%22has_issues%22%3atrue%2c%22private%22%3afalse%2c%22has_downloads%22%3atrue%2c%22owner%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22bennyn%22%7d%2c%22watchers%22%3a4%2c%22name%22%3a%22JiraButler%22%2c%22homepage%22%3a%22%22%7d%2c%22commits%22%3a%5b%7b%22author%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22username%22%3a%22bennyn%22%2c%22name%22%3a%22Benny%20Neugebauer%22%7d%2c%22timestamp%22%3a%222011-01-03T20%3a42%3a35-08%3a00%22%2c%22removed%22%3a%5b%22build%5c%2fjar%5c%2fhtml%5c%2ffavicon.ico%22%2c%22build2.xml%22%5d%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%5c%2fcommit%5c%2fb2f42f15cf91de9fa6702f70a3412c15438e91f3%22%2c%22message%22%3a%22SWQ-11%40Cobertura%20inside%21%22%2c%22added%22%3a%5b%5d%2c%22modified%22%3a%5b%22build.properties%22%2c%22build.xml%22%2c%22cobertura.ser%22%2c%22test%5c%2fde%5c%2fangelcode%5c%2fjirabutler%5c%2fhook%5c%2fJiraServiceHookTest.java%22%5d%2c%22id%22%3a%22b2f42f15cf91de9fa6702f70a3412c15438e91f3%22%7d%5d%2c%22forced%22%3afalse%2c%22before%22%3a%223e55fd24b662a02498be1f6a0c334f712012290d%22%2c%22pusher%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22bennyn%22%7d%2c%22after%22%3a%22b2f42f15cf91de9fa6702f70a3412c15438e91f3%22%2c%22compare%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%5c%2fcompare%5c%2f3e55fd2...b2f42f1%22%7d", "UTF-8");
		int option = -1;
    System.out.println(payloadUnicode);
		String command = null;
		Server server = null;

		// Program information
		String programExecutable = "Server.jar";
		String programName = "JiraButler";
		String programVersion = "v0.1";

		// Presets
		String serverPort = "7070";
		StringBuffer logFilePath = new StringBuffer(
				SystemVariables.getJarExecutionDirectory() + "jira-butler.log");

		// Long option names
		LongOpt[] optionsLong = new LongOpt[4];
		optionsLong[0] = new LongOpt("port", LongOpt.OPTIONAL_ARGUMENT, null,
				'p');
		optionsLong[1] = new LongOpt("log", LongOpt.OPTIONAL_ARGUMENT,
				logFilePath, 'l');
		optionsLong[2] = new LongOpt("help", LongOpt.NO_ARGUMENT, null, 'h');
		optionsLong[3] = new LongOpt("version", LongOpt.NO_ARGUMENT, null, 'v');

		// GetOpt
		Getopt g = new Getopt(programExecutable, argv, "-:p:l:hv", optionsLong);
		g.setOpterr(false);

		while ((option = g.getopt()) != -1) {
			switch (option) {
			case 1:
				command = g.getOptarg();
				if (command.equals("start")) {
					System.out.println("Starting server...");
					try {
						server = new Server(serverPort, logFilePath.toString());
					} catch (JiraButlerException ex) {
						System.out.println(ex.getLocalizedMessage());
					}
				} else {
					System.out
							.println("Wrong parameters. Please read the manual.");
				}
				break;
			case 'h':
				System.out.println("I see you asked for help.\n");
				System.out
						.println("To get the program running you have to say 'start' to it in that way:");
				System.out.println("java -jar " + programExecutable
						+ " start\n");
				System.out.println("You can also use some options. Like:");
				System.out
						.println("java -jar "
								+ programExecutable
								+ " -p 7777 -l /var/log/the_servers_logfile.log start\n");
				System.out.println("The following command is equivalent:");
				System.out
						.println("java -jar "
								+ programExecutable
								+ " --port 7777 --log /var/log/the_servers_logfile.log start\n");
				System.out
						.println("\nLet me explain all options available to you:\n");
				System.out.println("Listening port (optional):");
				System.out
						.println("-p\t--port\t\tDefines the port on which the server should listen.");
				System.out
						.println("\t\t\t(I recommend ports between 49152 and 65535.)");
				System.out.println("");
				System.out.println("Log file path (optional):");
				System.out
						.println("-l\t--log\t\tThe place where the server's log file should be stored.");
				System.out.println("\t\t\t(e.g. /var/log/jira-butler.log)");
				System.out.println("");
				System.out.println("Help texts:");
				System.out
						.println("-h\t--help\t\tHelp texts to get the program running.");
				System.out.println("");
				System.out.println("Version number:");
				System.out.println("-v\t--version\tPrints the version number.");
				System.out.println("");
				System.out.println("Note:");
				System.out
						.println("If you do not set a port, then this application will take port \""
								+ serverPort + "\".");
				System.out
						.println("If you do not set a path for the log file, then this application will take \""
								+ logFilePath + "\".");
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
				System.out.println("Please use 'java -jar " + programExecutable
						+ " -h' to get help.");
				break;
			}
		}
	}
}
