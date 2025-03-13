#La imagen base
FROM openjdk:17-ea-4-jdk-slim

#Author
LABEL authors="Darwin F"

#carpeta base del proyecto imagen
WORKDIR /app
RUN mkdir ./logs
#copiar el jar en la imagen
COPY ./target/*.jar .

#Ejecuta comandos
ENTRYPOINT ["java", "-jar", "movie-0.0.1-SNAPSHOT.jar"]