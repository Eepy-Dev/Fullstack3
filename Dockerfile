
FROM maven:3.9.6-eclipse-temurin-22-alpine AS build
WORKDIR /app
COPY GestionDeVehiculos/pom.xml .
RUN mvn dependency:go-offline
COPY GestionDeVehiculos/src ./src
RUN mvn clean package -DskipTests


FROM eclipse-temurin:22-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
