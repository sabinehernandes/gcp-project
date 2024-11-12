FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app/chili
COPY pom.xml
COPY src ./src
RUN mvn clean package
FROM openjdk:17-jre-slim
WORKDIR /app/chili
COPY - from=build /app/chili/target/HelloServiceApplication.jar
CMD ["java", "-jar", "HelloServiceApplication.jar"]