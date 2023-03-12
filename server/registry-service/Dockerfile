#FROM openjdk:8-jdk-alpine

FROM alpine:3.14

RUN  apk update \
  && apk upgrade \
  && apk add --update openjdk8 tzdata curl unzip bash \
  && rm -rf /var/cache/apk/*


EXPOSE 8761
COPY build/libs/registry-service-1.0.jar .
ENTRYPOINT ["java", "-jar", "registry-service-1.0.jar"]