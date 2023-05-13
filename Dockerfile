FROM amazoncorretto:18-alpine-jdk
MAINTAINER Alita
COPY target/backend-0.0.1-SNAPSHOT.jar  backend-app.jar
ENTRYPOINT ["java","-jar","/backend-app.jar"]
EXPOSE 8080