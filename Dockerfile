FROM ubuntu:latest
LABEL authors="elizaveta"

FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY . /app/.
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/*.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/*.jar"]
#CMD ["java", "-jar", "-Dspring.datasource.url=jdbc:postgresql://service-db:5432/cars_db", "/app.jar"]
