package de.angelcode.jirabutler.webserver;

import de.angelcode.jirabutler.exceptions.JiraButlerException;
import java.io.IOException;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * Server logger with Singleton pattern.
 * 
 * @author bennyn (Benny Neugebauer)
 */
<<<<<<< HEAD
public class ServerLogger
{

  private static Logger logger;

  protected ServerLogger()
  {
    logger = null;
  }

  /**
   * Initializes the logger.
   * @param logFilePath Path to the log file
   */  
  static public Logger getServerLogger(String logFilePath)
  {
    if (null == logger)
    {
      FileAppender appender = null;
      PatternLayout appenderLayout = null;

      try
      {
        logger = Logger.getLogger(Server.class);
        logger.setLevel(org.apache.log4j.Level.ALL);

        appenderLayout = new PatternLayout();
        appenderLayout.setConversionPattern("%d %p - %m%n");

        appender = new FileAppender(appenderLayout, logFilePath);
        logger.addAppender(appender);

      }
      catch (IOException ex)
      {
        System.out.println("Cannot access log file:" + "\n" + ex.getLocalizedMessage());
      }
      catch (Exception ex)
      {
        System.out.println("Unknown exception in server logger:"
                + "\n" + ex.getLocalizedMessage());
      }
    }
    return logger;
  }
=======
public class ServerLogger {

	private static Logger logger;

	protected ServerLogger() {
		logger = null;
	}

	/**
	 * Initializes the logger.
	 * 
	 * @param logFilePath
	 *            Path to the log file
	 */
	static public Logger getServerLogger(String logFilePath)
			throws JiraButlerException {
		if (null == logger) {
			FileAppender appender = null;
			PatternLayout appenderLayout = null;

			try {
				logger = Logger.getLogger(Server.class);
				logger.setLevel(org.apache.log4j.Level.ALL);

				appenderLayout = new PatternLayout();
				appenderLayout.setConversionPattern("%d %p - %m%n");

				appender = new FileAppender(appenderLayout, logFilePath);
				logger.addAppender(appender);

			} catch (IOException ex) {
				throw new JiraButlerException("Cannot access log file:" + "\n"
						+ ex.getLocalizedMessage());
			} catch (Exception ex) {
				System.out.println("Unknown exception in server logger:" + "\n"
						+ ex.getLocalizedMessage());
				throw new JiraButlerException(
						"Unknown exception in server logger:" + "\n"
								+ ex.getLocalizedMessage());
			}
		}
		return logger;
	}
>>>>>>> origin/master
}
