FROM openjdk:8-jdk-alpine
EXPOSE 8082
COPY build/libs/login-service-1.0.jar .
ENTRYPOINT ["java", "-jar", "login-service-1.0.jar"]