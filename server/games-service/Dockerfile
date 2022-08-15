FROM --platform=linux/arm64/v8 openjdk:8-jdk-alpine
EXPOSE 8080
COPY build/libs/games-service-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "games-service-0.0.1-SNAPSHOT.jar"]
