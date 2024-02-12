# Use the official OpenJDK base image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/springboot-0.0.1-SNAPSHOT.jar /app/springboot-0.0.1-SNAPSHOT.jar

# Expose the port that your Spring Boot application is running on
EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "springboot-0.0.1-SNAPSHOT.jar"]
