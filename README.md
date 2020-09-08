# Template Spring Boot App

This project is a starter template to create a Spring Boot REST API. It consists of a basic CRUD application for Customers, Orders and Products entities.

## Database

This project uses H2 Database. H2 is an in memory relational database built in Java.

More information: https://www.h2database.com/html/main.html

## Entities

### Customer

| Column                     | Type        | Nullable |
|----------------------------|-------------|----------|
| id                         | Long        | false    |
| name                       | String      | false    |
| individualTaxpayerRegistry | String      | false    |
| orders                     | Set\<Order> | false    |


### Order


| Column                     | Type     | Nullable |
|----------------------------|----------|----------|
| id                         | Long     | false    |
| description                | String   | true     |
| customer                   | Customer | true     |



### Product


| Column      | Type       | Nullable |
|-------------|------------|----------|
| id          | Long       | false    |
| name        | String     | true     |
| description | String     | true     |
| price       | BigDecimal | false    |


### Running with Docker

1. Run the command `docker build -t <image_tag> .`

    > Or `docker build -t <image_tag> -f Dockerfile.windows .` for Windows.

    > The Windows specific Dockerfile was created because of a problem with DOS line endings in the ``mvnw`` file so it uses the ``dos2unix`` dependency inside the image.

2. Run the command `docker run -p 8080:8080 <name_of_the_image>`. By default the application will start at port 8080.

    > The port can be changed in the ``application.properties`` file, in the ``server.port`` property.

    > The `application.properties` file is placed inside the Docker image, so the container will start with these configs as default.

### Running Locally (without Docker)

1. Install Java (JDK 11).

2. Download H2 Database at http://www.h2database.com/html/download.html.


3. Run `.\mvnw spring-boot:run` in the root of the project.

    > `.\mvnw` is a wrapper for the correct Maven version.
    > You can learn more about ir here: https://www.baeldung.com/maven-wrapper

### Running unit tests

1. Run `.\mvnw test` in the root of the project.

## Swagger

The API is documented using Swagger. To access the generated documentation first run the app and then go to `http://localhost:8080/swagger-ui.html#/` where you will be presented with the Swagger UI (it also allows you to test the endpoints).

More on Swagger: https://swagger.io/