#FROM openjdk:8-jdk-alpine

FROM alpine:3.14

RUN  apk update \
  && apk upgrade \
  && apk add --update openjdk8 tzdata curl unzip bash \
  && rm -rf /var/cache/apk/*


EXPOSE 8081
COPY build/libs/games-service-1.0.jar .
HEALTHCHECK --interval=30s --timeout=6s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8081/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "games-service-1.0.jar"]