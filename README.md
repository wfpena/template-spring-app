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


### Running Locally

1. Install Maven and Java (JDK 11).

2. Download and run H2 Database and set the config in the `application.properties` file.

3. Run `mvn spring-boot:run` in the root of the project.

### Running unit tests

1. Run `mvn test` in the root of the project.