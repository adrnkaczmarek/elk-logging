FROM tomcat:8.0.20-jre8

COPY restelklogger.war /usr/local/tomcat/webapps/ 

WORKDIR /usr/src/app

ADD filebeat.tar.gz /usr/src/app

ADD filebeat.yml /usr/src/app

EXPOSE 8080
