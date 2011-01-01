package de.angelcode.jirabutler.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.Logger;

/**
 * Socket-based web server application.
 * @author bennyn (Benny Neugebauer)
 */
public class Server
{

  private ServerSocket server;
  private String port;
  private String logFilePath;
  private static Logger logger;

  private Server()
  {
    this.server = null;
    this.port = null;
    this.logFilePath = null;
  }

  /**
   * Runs the server on a given port. Default port is 7070.
   * @param port A port-number (it is recommended to use ports between 49152 and 65535)
   * @param logFilePath The path of the log file (e.g. /var/log/server_log_file.log)
   */
  public Server(String port, String logFilePath)
  {
    this();
    logger = ServerLogger.getServerLogger(logFilePath);
    this.logFilePath = logFilePath;
    this.port = port;

    try
    {
      int portNumber = Integer.parseInt(this.port);

      if (portNumber < 0 || portNumber > 65535)
      {
        throw new PortRangeException();
      }

      this.server = new ServerSocket(portNumber);
      handleConnection();
    }
    catch (IOException ex)
    {
      logger.error("Server cannot get the desired port. Is it available?"
              + "\n" + ex.getLocalizedMessage());
    }
    catch (NumberFormatException ex)
    {
      System.out.println("ERROR: Thie given port is not a number.");
    }
    catch (PortRangeException ex)
    {
      System.out.println(ex.getLocalizedMessage());
    }
    catch (Exception ex)
    {
      System.out.println("Unknown exception. Please check the log-file if it exists.");
      logger.fatal("Unknown exception."
              + "\n" + ex.getLocalizedMessage());
    }
    // TODO: Exception fangen, wenn Port besetzt
  }

  /**
   * Gets the request of a client and forwards it to a specified handler.
   */
  private void handleConnection()
  {
    logger.info("Waiting for connection...");
    System.out.println("Server successfully launched on Port: " + this.port);
    System.out.println("Log-file will be saved to: " + this.logFilePath);

    while (true)
    {
      try
      {
        Socket socket = server.accept();
        logger.info("Client connected");
        ConnectionHandler handler = new ConnectionHandler(socket);
        handler.startThread();
      }
      catch (IOException ex)
      {
        logger.error("Error when client connected."
                + "\n" + ex.getLocalizedMessage());
      }
      catch (Exception ex)
      {
        logger.fatal("Unknown exception."
                + "\n" + ex.getLocalizedMessage());
      }
    }
  }
}