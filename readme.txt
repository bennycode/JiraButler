Benny's branch with working build.xml and NetBeans support.

Possible statements:
java -jar /srv/www/jb/JiraButler-0.1.jar start

java -jar /srv/www/jb/JiraButler-0.1.jar --h
java -jar /srv/www/jb/JiraButler-0.1.jar --help

java -jar /srv/www/jb/JiraButler-0.1.jar -v
java -jar /srv/www/jb/JiraButler-0.1.jar --version

java -jar /srv/www/jb/JiraButler-0.1.jar -p 7071 start
java -jar /srv/www/jb/JiraButler-0.1.jar --port 7071 start (TODO!)

java -jar /srv/www/jb/JiraButler-0.1.jar -l /srv/www/jb/logfile.txt start
java -jar /srv/www/jb/JiraButler-0.1.jar --log /srv/www/jb/logfile.txt start (TODO!)

java -jar /srv/www/jb/JiraButler-0.1.jar -p 7071 -l /srv/www/jb/log1.txt start


TODO:
java -jar /srv/www/jb/JiraButler-0.1.jar --port 7071 --log /srv/www/jb/log1.txt start
java -jar /srv/www/jb/JiraButler-0.1.jar --port 7071 -l /srv/www/jb/log1.txt start
java -jar /srv/www/jb/JiraButler-0.1.jar -p 7071 --log /srv/www/jb/log1.txt start
