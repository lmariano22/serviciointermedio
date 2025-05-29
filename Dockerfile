# Usa una imagen oficial con Java 17 y Maven
FROM maven:3.8.6-openjdk-17 AS build

WORKDIR /app
COPY . /app

# Construye el proyecto
RUN ./mvnw clean package -DskipTests

# Usa una imagen más ligera para correr la app
FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=build /app/target/serviciointermedio-0.0.1-SNAPSHOT.jar app.jar

# Puerto (ajústalo si tu app corre en otro)
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
