== INTRO ==
I see you asked for help. To start the JiraButler project you just have to copy everything from /build/jar/ on your server, check the file permissions and run the JiraButler JAR file with the 'start' parameter.


== START ==
A valid start command looks like: 
java -jar /srv/www/jb/JiraButler-0.1.jar start

== PARAMETERS ===
You can also use some extra parameters. The following parameters are available:
-p sets the port for the JiraButler Web server (default is 7070)
-l sets the path to the JiraButler logfile (default is jira-butler.log, which is in the same directory as the JAR file)
-h shows the help
-v show the program version

Example inputs:
java -jar /srv/www/jb/JiraButler-0.1.jar -p 6060 start
java -jar /srv/www/jb/JiraButler-0.1.jar -l /var/log/jb.log start
java -jar /srv/www/jb/JiraButler-0.1.jar -p 6060 -l /var/log/jb.log start 
java -jar /srv/www/jb/JiraButler-0.1.jar -v
java -jar /srv/www/jb/JiraButler-0.1.jar -h

Please note that the 'start' command has to be the last one in the parameter list.

== jira.properties ==
To connect the JiraButler Web server with the Atlassian JIRA system you have to provide a file called 'jira.properties' in the same directory like the JAR file.

The following must be set in this file:
url=http://my-website.de:8080/rpc/soap/jirasoapservice-v2?wsdl

username=jira-admin
password=my-secret-password

=======
== INTRO ==
I see you asked for help. To start the JiraButler project you just have to copy everything from /build/jar/ on your server, check the file permissions and run the JiraButler JAR file with the 'start' parameter.


== START ==
A valid start command looks like: 
java -jar /srv/www/jb/JiraButler-0.1.jar start

== PARAMETERS ===
You can also use some extra parameters. The following parameters are available:
-p sets the port for the JiraButler Web server (default is 7070)
-l sets the path to the JiraButler logfile (default is jira-butler.log, which is in the same directory as the JAR file)
-h shows the help
-v show the program version

Example inputs:
java -jar /srv/www/jb/JiraButler-0.1.jar -p 6060 start
java -jar /srv/www/jb/JiraButler-0.1.jar -l /var/log/jb.log start
java -jar /srv/www/jb/JiraButler-0.1.jar -p 6060 -l /var/log/jb.log start 
java -jar /srv/www/jb/JiraButler-0.1.jar -v
java -jar /srv/www/jb/JiraButler-0.1.jar -h

Please note that the 'start' command has to be the last one in the parameter list.

== jira.properties ==
To connect the JiraButler Web server with the Atlassian JIRA system you have to provide a file called 'jira.properties' in the same directory like the JAR file.

The following must be set in this file:
url=http://my-website.de:8080/rpc/soap/jirasoapservice-v2?wsdl

username=jira-admin
password=my-secret-password


Have Fun and take care because we cannot guarantee for anything! :)