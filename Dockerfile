# Use the official OpenJDK image as the base image
FROM openjdk:17

# Set the working directory within the container
WORKDIR /zoo-store-storage

# Copy the packaged JAR file from the target directory into the container
COPY rest/target/ZooStoreStorage.jar zoo-store-storage.jar
# Expose the port that your application runs on
EXPOSE 8082

# Define the command to run your application
CMD ["java", "-jar", "zoo-store-storage.jar"]