# Utiliser une image de base avec OpenJDK 17
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR de l'application
COPY target/*.jar app.jar

# Définir le point d'entrée pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/app.jar"]


