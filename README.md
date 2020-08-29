# Template Spring Boot App

This project is a starter template to create a Spring Boot REST API. It consists of a basic CRUD application for Customers, Orders and Products entities.

## Database

This project uses H2 Database. H2 is an in memory relational database built in Java.

More information: https://www.h2database.com/html/main.html

## Entities

### Customer

    | Column                     | Type   | Nullable |
    |----------------------------|--------|----------|
    | id                         | Long   | false    |
    | name                       | String | false    |
    | individualTaxpayerRegistry | String | false    |



### Order

    | Column                     | Type   | Nullable |
    |----------------------------|--------|----------|
    | id                         | Long   | false    |
    | description                | String | true     |



### Product


    | Column      | Type       | Nullable |
    |-------------|------------|----------|
    | id          | Long       | false    |
    | name        | String     | true     |
    | description | String     | true     |
    | price       | BigDecimal | false    |


### Running with Docker

1. Run the command `docker build -t <name_of_the_image> .`

    > Or `docker build -t <name_of_the_image> -f Dockerfile.windows .` for Windows.

    > The Windows specific Dockerfile was created because of a problem with DOS line endings in the ``mvnw`` file so it uses the ``dos2unix`` dependency inside the image.

2. Run the command `docker run -p 8080:8080 <name_of_the_image>`. By default the application will start at port 8080.

    > The port can be changed in the ``application.properties`` file, in the ``server.port`` property.

### Running Locally

1. Install Maven and Java (JDK 11).

2. Download and run H2 Database and set the config in the `application.properties` file.

3. Run `mvn spring-boot:run` in the root of the project.

### Running unit tests

1. Run `mvn test` in the root of the project.