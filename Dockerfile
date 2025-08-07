# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/server-sent-event-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8087

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]