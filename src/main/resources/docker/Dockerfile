FROM openjdk:17-ea-11-jdk-slim-buster
EXPOSE 8080
ENV POSTGRES_URL ''
ARG JAR_FILE=desafio-sincredi-0.1.0-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
