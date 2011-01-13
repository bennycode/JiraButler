package de.angelcode.jirabutler.webserver;

import de.angelcode.jirabutler.exceptions.JiraButlerException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.Logger;

/**
 * A Socket-based web server.
 * @author Benny Neugebauer (www.bennyn.de)
 * @author Daniel Paepke
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
    this.logFilePath = logFilePath;
    this.port = port;
  }

  public void startServer() throws JiraButlerException
  {
    boolean isRunning = createServerSocket();
    boolean isLogging = createServerLogger();

    if (isRunning && isLogging)
    {
      System.out.println("Server successfully launched on Port: " + this.port);
      System.out.println("Log file will be saved to: " + this.logFilePath);
      Server.logger.info("Server successfully launched on Port: " + this.port);
      Server.logger.info("Log file will be saved to: " + this.logFilePath);
      handleConnection();
    }
    else if(isRunning && !isLogging)
    {
      throw new JiraButlerException("Logger could not be started.");
    }
    else if (!isRunning && isLogging)
    {
      logger.fatal("Server could not be started.");
      throw new JiraButlerException("Server could not be started.");
    }
    else
    {
      throw new JiraButlerException("Server and Logger could not be started.");
    }
  }

  protected boolean createServerLogger()
  {
    boolean success = false;
    Server.logger = ServerLogger.getServerLogger(this.logFilePath);

    if (Server.logger != null)
    {
      success = true;
    }

    return success;
  }

  protected boolean createServerSocket()
  {
    boolean success = false;

    try
    {
      int portNumber = Integer.parseInt(this.port);

      if (portNumber < 0 || portNumber > 65535)
      {
        throw new PortRangeException();
      }

      this.server = new ServerSocket(portNumber);           
      success = true;
    }
    catch (IOException ex)
    {
      logger.error("Server cannot get the desired port. Is it available?"
              + "\n" + ex.getLocalizedMessage());
      System.out.println("Server cannot get the desired port. Is it available?"
              + "\n" + ex.getLocalizedMessage());
    }
    catch (NumberFormatException ex)
    {
      System.out.println("Thie given port is not a number. " + ex.getLocalizedMessage());
    }
    catch (PortRangeException ex)
    {
      System.out.println("The given port is not within the range. " + ex.getLocalizedMessage());
    }
    catch (Exception ex)
    {
      logger.fatal("Unknown exception."
              + "\n" + ex.getLocalizedMessage());
      System.out.println("Unknown exception: " + ex.getLocalizedMessage());
    }
    finally
    {
      return success;
    }
  }

  /**
   * Gets the request of a client and forwards it to a specified handler.
   */
  protected void handleConnection()
  {
    logger.info("Waiting for connection...");

    while (true)
    {
      try
      {
        Socket socket = server.accept();
        logger.info("Client connected.");
        ConnectionHandler handler = new ConnectionHandler(socket);
        handler.startThread();
      }
      catch (IOException ex)
      {
        logger.error("Error when client connected: " + ex.getLocalizedMessage());
        System.out.println("Error when client connected: " + ex.getLocalizedMessage());
      }
      catch (Exception ex)
      {
        logger.fatal("Unknown exception: " + ex.getLocalizedMessage());
        System.out.println("Unknown exception: " + ex.getLocalizedMessage());
      }
    }
  }
}
