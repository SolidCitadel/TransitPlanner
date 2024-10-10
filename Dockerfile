FROM amazoncorretto:21-alpine-jdk

ARG VERSION=0.0.1-SNAPSHOT
COPY ./build/libs/transit-planner-${VERSION}.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]