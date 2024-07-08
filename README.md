# DriveAndDeliver API

API for a delivery service allowing customers to choose delivery methods and book time slots.

## Endpoints:

- **Get all delivery methods**

  Retrieve a list of available delivery methods.

  - **URL**

    `/delivery-methods`

  - **Method**

    `GET`

  - **Responses**

    - `200 OK`

      Successful response with an array of delivery methods.

      ```json
      [
        {
          "id": 1,
          "methodName": "Express Delivery"
        },
        {
          "id": 2,
          "methodName": "Standard Delivery"
        }
      ]
      ```

    - `500 Server Error`

      Internal server error occurred.

- **Get available time slots for a delivery method**

  Retrieve available time slots for a specific delivery method.

  - **URL**

    `/bookings/time-slots`

  - **Method**

    `GET`

  - **Parameters**

    - `deliveryMethodId` (required)

      Integer: The ID of the delivery method.

  - **Responses**

    - `200 OK`

      Successful response with an array of available time slots.

      ```json
      [
        {
          "id": 1,
          "startTime": "2024-07-08T10:00:00Z",
          "endTime": "2024-07-08T12:00:00Z",
          "deliveryMethodId": 1,
          "isBooked": false
        },
        {
          "id": 2,
          "startTime": "2024-07-08T14:00:00Z",
          "endTime": "2024-07-08T16:00:00Z",
          "deliveryMethodId": 1,
          "isBooked": true
        }
      ]
      ```

    - `400 Bad Request`

      Invalid delivery method ID provided.

    - `500 Server Error`

      Internal server error occurred.

- **Book a time slot**

  Book a time slot for a customer.

  - **URL**

    `/bookings`

  - **Method**

    `POST`

  - **Request Body**

    ```json
    {
      "customerId": 123,
      "timeSlotId": 1
    }
    ```

  - **Responses**

    - `200 OK`

      Booking successful.

      ```json
      {
        "bookingId": 456,
        "customer": {
          "id": 123,
          "name": "John Doe"
        },
        "timeSlot": {
          "id": 1,
          "startTime": "2024-07-08T10:00:00Z",
          "endTime": "2024-07-08T12:00:00Z",
          "deliveryMethodId": 1,
          "isBooked": true
        }
      }
      ```

    - `400 Bad Request`

      Invalid request.

    - `500 Server Error`

      Internal server error occurred.

- **Authenticate user and return JWT**

  Authenticate a user and receive a JWT token.

  - **URL**

    `/auth/login`

  - **Method**

    `POST`

  - **Request Body**

    ```json
    {
      "username": "johndoe",
      "password": "password123"
    }
    ```

  - **Responses**

    - `200 OK`

      Authentication successful.

      ```json
      {
        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
      }
      ```

    - `401 Unauthorized`

      Authentication failed.

- **Register user**

  Register a new user.

  - **URL**

    `/auth/signup`

  - **Method**

    `POST`

  - **Request Body**

    ```json
    {
      "username": "johndoe",
      "password": "password123"
    }
    ```

  - **Responses**

    - `200 OK`

      Signup successful.

      ```json
      {
        "id": 123,
        "name": "John Doe"
      }
      ```

## Security:

- **Authentication**

  The API uses JWT (JSON Web Token) for authentication. Include the token in the Authorization header using the Bearer scheme.

  ```http
  Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
  ```

## Technology Stack:

- Java: Backend logic
- Spring Boot: Framework for building APIs
- OpenAPI: API documentation
- JWT: Authentication mechanism


## Build Process and Deployment Using Jib and Kubernetes

#### Build Process

The build process for the DriveAndDeliver application involves using Gradle and Jib for building Docker images. Here’s how it works:

1. **Gradle Configuration**: The project uses Gradle as the build automation tool. The `build.gradle` file includes configuration for Jib plugin to build Docker images directly from the Gradle build.

   ```groovy
   plugins {
       id 'com.google.cloud.tools.jib' version '3.4.3'
   }

   jib {
       to {
           image = 'bbahaida/driveanddeliver:latest'
       }
   }
   ```

2. **Jib Plugin**: The Jib plugin simplifies Docker image creation by allowing configuration directly in the Gradle build script. It builds the image using `openjdk:21-alpine` as the base image and configures the application’s main class, JVM options, ports, and labels.

3. **Building the Docker Image**: Run the Gradle task to build and push the Docker image to a container registry (e.g., Docker Hub, Google Container Registry, etc.).

   ```bash
   ./gradlew jib
   ```

#### Deployment Using Kubernetes

For deployment, Kubernetes manifests are used to orchestrate the application and its dependencies. Here’s how you can deploy DriveAndDeliver using Kubernetes:


   ```bash
   kubectl apply -f ./k8s
   ```

#### Summary

The DriveAndDeliver MVP utilizes API-first development practices, ensuring a well-defined API interface. With Jib, Docker images are efficiently built and deployed to Kubernetes, providing a streamlined development and deployment workflow.

