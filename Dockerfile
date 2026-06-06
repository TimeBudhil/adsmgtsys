# Build stage
FROM maven:3.9-eclipse-temurin-25 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:25-jre

WORKDIR /app

# Copy the executable shaded JAR created by Maven
COPY --from=builder /app/target/adsmgtsys.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]