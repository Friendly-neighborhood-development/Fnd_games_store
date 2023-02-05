FROM openjdk:8-jdk-alpine
EXPOSE 8001
COPY build/libs/config-service-1.0.jar .
ENTRYPOINT ["java", "-jar", "config-service-1.0.jar"]