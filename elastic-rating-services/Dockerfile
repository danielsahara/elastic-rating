FROM openjdk:8-jdk-alpine
MAINTAINER Daniel Sahara <d.otasahara@gmail.com>
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]