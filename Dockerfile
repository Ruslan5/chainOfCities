FROM maven:3.8.1-adoptopenjdk-11 as builder

COPY ./ ./

RUN mvn clean package

FROM openjdk:11-ea-11-jdk-slim

COPY --from=builder /target/CityChain-1.0-SNAPSHOT.jar /app.jar

COPY --from=builder /src/main/resources/city.txt /city.txt

CMD ["java", "-jar", "/app.jar"]
