FROM gradle:jdk8 AS APPLICATION_BUILD_STAGE
COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle
RUN gradle build || return 1


FROM alpine:3.14 AS IMAGE_BUILD_STAGE
RUN  apk update \
  && apk upgrade \
  && apk add --update openjdk8 tzdata curl unzip bash \
  && rm -rf /var/cache/apk/* \
EXPOSE 8081
COPY --from=APPLICATION_BUILD_STAGE /home/gradle/build/libs/*.jar games-service-1.0.jar
HEALTHCHECK --interval=30s --timeout=6s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8081/games/actuator/health || exit 1
ENTRYPOINT ["java", "-jar", "games-service-1.0.jar"]

#Separate gradle build

#FROM alpine:3.14
#
#RUN  apk update \
#  && apk upgrade \
#  && apk add --update openjdk8 tzdata curl unzip bash \
#  && rm -rf /var/cache/apk/*
#
#
#EXPOSE 8081
#COPY build/libs/games-service-1.0.jar .
#HEALTHCHECK --interval=30s --timeout=6s --retries=3 \
#  CMD wget --no-verbose --tries=1 --spider http://localhost:8081/games/actuator/health || exit 1
#
#ENTRYPOINT ["java", "-jar", "games-service-1.0.jar"]