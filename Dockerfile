FROM eclipse-temurin:17-jdk-alpine
COPY build/libs/application-name-1.0.0.jar app.jar
ENTRYPOINT ["java","-Dserver.port=9090","-jar","/app.jar"]
