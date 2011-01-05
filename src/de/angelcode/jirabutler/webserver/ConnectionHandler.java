package de.angelcode.jirabutler.webserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Processes server requests and responses.
 * @author Benny Neugebauer (www.bennyn.de)
 */
class ConnectionHandler implements Runnable
{

  private Socket socket;

  public ConnectionHandler(Socket socket)
  {
    this.socket = socket;
  }

  public void startThread()
  {
    Thread thread = new Thread(this);
    thread.start();
  }

  public void run()
  {
    // TODO add to every thrown exception an userfriendly message
    try
    {
      // Process the request of the client
      InputStream input = socket.getInputStream();
      InputStreamReader isr = new InputStreamReader(input);
      BufferedReader br = new BufferedReader(isr);
      String message = null;

      // Read every single line which the client has sent
      StringBuilder sb = new StringBuilder();
      sb.append(br.readLine());
      sb.append("\n");
      while (br.ready())
      {
        sb.append(br.readLine());
        sb.append("\n");
      }
      message = sb.toString();

      System.out.println("Request from client:");
      System.out.println(message);
      ServerFunctionality.handleRequest(message);
      String serverResponse = ServerFunctionality.getServerResponse();
      System.out.println("Response to client:");
      if (serverResponse != null)
      {
        // Sending the response...
        System.out.println(serverResponse);
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.write(serverResponse.getBytes());
        outputStream.close();
      }
      socket.close();
      System.out.println("Waiting for connection...");
    }
    catch (IOException ex)
    {
      System.out.println("Error while setting-up the stream.");
      System.out.println(ex.getLocalizedMessage());
    }
    catch(Exception ex)
    {
      System.out.println("Unknown exception.");
    }
  }
}
