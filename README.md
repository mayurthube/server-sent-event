```markdown
# Server-Sent Event Application

This is a Spring Boot application that demonstrates the use of Server-Sent Events (SSE) to stream data to clients in real-time.

## Features
- Streams data from a file (`data.txt`) to clients using SSE.
- Configurable context path and server port.
- Delays each event by 1 second for demonstration purposes.

## Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- IntelliJ IDEA or any preferred IDE

## Configuration
The application can be configured using the `application.properties` file located in `src/main/resources`.

### Default Configuration:
```properties
spring.application.name=server-sent-event
server.servlet.context-path=/ServerSentEvent
server.port=8087
```

## How to Run
1. Clone the repository and navigate to the project directory.
2. Ensure the file `src/main/resources/data.txt` exists and contains the data to be streamed.
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
5. Access the endpoint in your browser or API client (e.g., Postman):
   ```
   http://localhost:8087/ServerSentEvent/server-events
   ```

## Endpoints
- **GET `/ServerSentEvent/server-events`**: Streams data from the `data.txt` file as Server-Sent Events.

## Troubleshooting
- Ensure the port (`8087` by default) is not in use.
- Verify the file `data.txt` exists and is readable.
- Check the application logs for errors during startup or runtime.

## License
This project is licensed under the MIT License.
```
