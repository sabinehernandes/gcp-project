FROM maven:3.8.7-openjdk-18-slim

WORKDIR /client
COPY ./lib .
RUN mvn install

#RUN mvn dependency:resolve

WORKDIR /app/chili
COPY . .
RUN mvn clean package -DskipTests
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/chili/target/chili-0.0.1-SNAPSHOT.jar"]