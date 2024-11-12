FROM maven:3.8.7-openjdk-18-slim
WORKDIR /app/chili
COPY ./chili .
RUN mvn clean package -DskipTests
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/chili/target/chili-0.0.1-SNAPSHOT.jar"]