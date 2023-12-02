FROM gradle:jdk8 AS APPLICATION_BUILD_STAGE
COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle
RUN gradle build || return 1


FROM alpine:latest AS IMAGE_BUILD_STAGE
RUN  apk update \
  && apk upgrade \
  && apk add --update openjdk8 tzdata curl unzip bash \
  && rm -rf /var/cache/apk/* \
EXPOSE 8083
COPY --from=APPLICATION_BUILD_STAGE /home/gradle/build/libs/*.jar cart-service-1.0.jar
HEALTHCHECK --interval=30s --timeout=6s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8083/cart/actuator/health || exit 1
ENTRYPOINT ["java", "-jar", "cart-service-1.0.jar"]

#Separate gradle build

#FROM alpine:3.14
#
#RUN  apk update \
#  && apk upgrade \
#  && apk add --update openjdk8 tzdata curl unzip bash \
#  && rm -rf /var/cache/apk/*
#
#
#EXPOSE 8083
#COPY build/libs/cart-service-1.0.jar .
#HEALTHCHECK --interval=30s --timeout=6s --retries=5 \
#  CMD wget --no-verbose --tries=1 --spider http://localhost:8083/cart/actuator/health || exit 1
#
#ENTRYPOINT ["java", "-jar", "cart-service-1.0.jar"]