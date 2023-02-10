FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY build/libs/application-name-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]