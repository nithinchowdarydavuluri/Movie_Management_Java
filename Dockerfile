#FROM tomcat:9.0.121-jdk17-temurin
#
#COPY target/Movie_Ticket_Management-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/Movie_Ticket_Management.war

FROM tomcat:9.0.121-jdk17-temurin

COPY Movie_Ticket_Management/movie-web/target/Movie_Ticket_Management.war \
     /usr/local/tomcat/webapps/Movie_Ticket_Management.war

COPY hello-world/target/hello-world.war \
     /usr/local/tomcat/webapps/hello-world.war