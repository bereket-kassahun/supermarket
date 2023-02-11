FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY build/libs/application-name-1.0.0.jar app.jar
CMD ["java","-jar","app.jar"]
