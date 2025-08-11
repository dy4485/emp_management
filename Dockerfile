# Use OpenJDK as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the jar file to the container
COPY target/emp-management-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (optional for documentation)
EXPOSE 9090

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
