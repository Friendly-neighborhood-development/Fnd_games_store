FROM openjdk:8-jdk-alpine
EXPOSE 8761
COPY build/libs/registry-service-1.0.jar .
ENTRYPOINT ["java", "-jar", "registry-service-1.0.jar"]