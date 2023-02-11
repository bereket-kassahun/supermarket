FROM eclipse-temurin:17-jdk-alpine
COPY build/libs/application-name-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
