FROM openjdk:17-jdk-slim-buster
LABEL org.opencontainers.image.author="marco.celis@gmail.com"

COPY target/accounts-0.0.1-SNAPSHOT.jar  accounts-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]