package de.angelcode.jirabutler.webserver;

import de.angelcode.jirabutler.hook.JiraServiceHook;
import de.angelcode.jirabutler.soap.JiraClient;
import de.angelcode.jirabutler.util.FileOperations;
import de.angelcode.jirabutler.util.SystemVariables;
import java.io.File;

/**
 * Implements the web servers special functionality. Specifies on which actions
 * (HTTP-GET, HTTP-POST) the server should react.
 * 
 * @author Benny Neugebauer (www.bennyn.de)
 */
<<<<<<< HEAD
public class ServerFunctionality
{

  private static String serverResponse = null;

  /**
   * Handles the request (HTTP-GET, HTTP-POST) of a client.
   * @param clientRequest Complete request of a client
   */
  public static void handleRequest(String clientRequest)
  {
    if (clientRequest != null)
    {
      // Handle HTTP-GET
      if (clientRequest.startsWith("GET"))
      {
        // HTTP/1.1 GET-request
        if (clientRequest.contains("HTTP/1.1"))
        {
          doHttpRequest(clientRequest);
        }
      }
      else // Handle HTTP-POST
      if (clientRequest.startsWith("POST"))
      {
        // Recognize github's payload
        if (clientRequest.contains("payload="))
        {
          JiraServiceHook hook = new JiraServiceHook(clientRequest);
          JiraClient client = new JiraClient();

          hook.convertGithubRequestToJson();
          hook.parseGithubJson();

          // Get every information from the hook
          String version = hook.getJiraProjectVersion();
          String username = hook.getUsername();
          String key = hook.getJiraIssueKey();
          String message = hook.getGitCommitMessage();

          // Pass the information to the JIRA client, so that it can be inserted into JIRA
          if (version != null)
          {
            client.setJiraProjectVersion(version);
          }
          if (username != null)
          {
            client.setUsername(username);
          }
          if (key != null)
          {
            client.setJiraIssueKey(key);
          }
          if (message != null)
          {
            client.setGitCommitMessage(message);
          }

          // Let the client work!
          client.loadConfigFile();
          boolean isConnected = client.login();
          System.out.println("Login: "+isConnected);
          if (isConnected)
          {
            boolean addedVersion = client.addVersion();
            boolean addedComment = client.addComment();
            boolean logout = client.logout();

            System.out.println("Added version: " + addedVersion);
            System.out.println("Added comment: " + addedComment);
            System.out.println("Logout: " + logout);
          }
        }
        else
        {
          System.out.println("No payload received.");
        }
      }
    }
  }

  /**
   * Initiates the server's response in case of a valid HTTP/1.1 request.
   * @param clientInput Input from the client
   */
  private static void doHttpRequest(String clientInput)
  {
    int cutPosition = 0;
    String fileName = null;
    // Removing GET and trailing "/" from the request
    String lineCache = clientInput.substring(5, clientInput.length());
    // Look if it is a valid HTTP/1.1 request
    if (lineCache.contains("HTTP/1.1"))
    {
      cutPosition = lineCache.indexOf("HTTP/1.1");
      fileName = lineCache.substring(0, cutPosition);
      fileName = fileName.trim();
      if (fileName.equals("") || fileName == null)
      {
        fileName = "index.html";
      }
      doHttpResponse(fileName);
    }
    else
    {
      serverResponse = "Invalid request from client.";
    }
  }

  /**
   * Returns the server-repsonse.
   * @return Server-Response
   */
  public static String getServerResponse()
  {
    return serverResponse;
  }

  /**
   * Generates the HTTP-GET/1.1-Response.
   * @param fileName File that is requested by the client
   */
  private static void doHttpResponse(String fileName)
  {
    String lineSeperator = System.getProperty("line.separator");
    String fileSeperator = System.getProperty("file.separator");
    String htmlPagesDirectory = SystemVariables.getJarExecutionDirectory() + "html" + fileSeperator;

    String http200 = "HTTP/1.1 200 OK" + lineSeperator;
    String http404 = "HTTP/1.1 404 Not Found" + lineSeperator;

    File requestedFile = new File(htmlPagesDirectory + fileName);
    boolean isFile = requestedFile.exists();

    // Set the response header
    if (isFile)
    {
      serverResponse = http200;
    }
    else
    {
      serverResponse = http404;
      requestedFile = new File(htmlPagesDirectory + "404.html");
    }

    // Complete the response
    String responseData = "Server: JiraButler" + lineSeperator
            + "Content-Length: " + requestedFile.length() + lineSeperator
            + "Content-Language: de" + lineSeperator
            + "Content-Type: text/html" + lineSeperator
            + "Connection: close" + lineSeperator
            + lineSeperator
            + FileOperations.getFileContent(requestedFile.getAbsolutePath());

    serverResponse += responseData;
  }
=======
public class ServerFunctionality {

	private static String serverResponse = null;

	/**
	 * Handles the request (HTTP-GET, HTTP-POST) of a client.
	 * 
	 * @param clientRequest
	 *            Complete request of a client
	 */
	public static void handleRequest(String clientRequest) throws JiraButlerException {
		if (clientRequest != null) {
			// Handle HTTP-GET
			if (clientRequest.startsWith("GET")) {
				// HTTP/1.1 GET-request
				if (clientRequest.contains("HTTP/1.1")) {
					doHttpRequest(clientRequest);
				}
			} else // Handle HTTP-POST
			if (clientRequest.startsWith("POST")) {
				// Recognize github's payload
				if (clientRequest.contains("payload=")) {
					JiraServiceHook hook = new JiraServiceHook(clientRequest);
					JiraClient client = new JiraClient();

					hook.convertGithubRequestToJson();
					hook.parseGithubJson();

					// Get every information from the hook
					String version = hook.getJiraProjectVersion();
					String username = hook.getUsername();
					String key = hook.getJiraIssueKey();
					String message = hook.getGitCommitMessage();

					// Pass the information to the JIRA client, so that it can
					// be inserted into JIRA
					if (version != null) {
						client.setJiraProjectVersion(version);
					}
					if (username != null) {
						client.setUsername(username);
					}
					if (key != null) {
						client.setJiraIssueKey(key);
					}
					if (message != null) {
						client.setGitCommitMessage(message);
					}

					// Let the client work!
					client.loadConfigFile();
					boolean isConnected = client.login();
					System.out.println("Login: " + isConnected);
					if (isConnected) {
						boolean addedVersion = client.addVersion();
						boolean addedComment = client.addComment();
						boolean logout = client.logout();

						System.out.println("Added version: " + addedVersion);
						System.out.println("Added comment: " + addedComment);
						System.out.println("Logout: " + logout);
					}
				} else {
					System.out.println("No payload received.");
				}
			}
		}
	}

	/**
	 * Initiates the server's response in case of a valid HTTP/1.1 request.
	 * 
	 * @param clientInput
	 *            Input from the client
	 */
	private static void doHttpRequest(String clientInput)
			throws JiraButlerException {
		int cutPosition = 0;
		String fileName = null;
		// Removing GET and trailing "/" from the request
		String lineCache = clientInput.substring(5, clientInput.length());
		// Look if it is a valid HTTP/1.1 request
		if (lineCache.contains("HTTP/1.1")) {
			cutPosition = lineCache.indexOf("HTTP/1.1");
			fileName = lineCache.substring(0, cutPosition);
			fileName = fileName.trim();
			if (fileName.equals("") || fileName == null) {
				fileName = "index.html";
			}
			doHttpResponse(fileName);
		} else {
			serverResponse = "Invalid request from client.";
		}
	}

	/**
	 * Returns the server-repsonse.
	 * 
	 * @return Server-Response
	 */
	public static String getServerResponse() {
		return serverResponse;
	}

	/**
	 * Returns the content of a file.
	 * 
	 * @param fileName
	 *            Absolute path to the file
	 * @return file-content
	 */
	private static String getFileContent(String fileName)
			throws JiraButlerException {
		StringBuilder sb = new StringBuilder();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			char[] readerContent = new char[1];
			while (reader.read(readerContent) != -1) {
				sb.append(readerContent[0]);
			}
			reader.close();
		} catch (Exception ex) {
			throw new JiraButlerException("Requested file could not be read: "
					+ ex.getLocalizedMessage());
		}

		return sb.toString();
	}

	/**
	 * Generates the HTTP-GET/1.1-Response.
	 * 
	 * @param fileName
	 *            File that is requested by the client
	 */
	private static void doHttpResponse(String fileName)
			throws JiraButlerException {
		String lineSeperator = System.getProperty("line.separator");
		String fileSeperator = System.getProperty("file.separator");
		String htmlPagesDirectory = SystemVariables.getJarExecutionDirectory()
				+ "html" + fileSeperator;

		String http200 = "HTTP/1.1 200 OK" + lineSeperator;
		String http404 = "HTTP/1.1 404 Not Found" + lineSeperator;

		File requestedFile = new File(htmlPagesDirectory + fileName);
		boolean isFile = requestedFile.exists();

		// Set the response header
		if (isFile) {
			serverResponse = http200;
		} else {
			serverResponse = http404;
			requestedFile = new File(htmlPagesDirectory + "404.html");
		}

		// Complete the response
		String responseData = "Server: JiraButler" + lineSeperator
				+ "Content-Length: " + requestedFile.length() + lineSeperator
				+ "Content-Language: de" + lineSeperator
				+ "Content-Type: text/html" + lineSeperator
				+ "Connection: close" + lineSeperator + lineSeperator
				+ getFileContent(requestedFile.getAbsolutePath());

		serverResponse += responseData;
	}
>>>>>>> origin/master
}
