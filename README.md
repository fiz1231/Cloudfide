![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.5-green)
![Spring Web](https://img.shields.io/badge/Spring-Web%20REST-brightgreen)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data-JPA-success)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Liquibase](https://img.shields.io/badge/Liquibase-DB%20Migration-red)
![Bean Validation](https://img.shields.io/badge/Validation-Jakarta%20Bean%20Validation-yellow)
![Lombok](https://img.shields.io/badge/Lombok-Code%20Generation-pink)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Tomcat](https://img.shields.io/badge/Tomcat-WAR%20Deployment-lightgrey)
![JUnit 5](https://img.shields.io/badge/JUnit-5-red)
![Testcontainers](https://img.shields.io/badge/Testcontainers-Integration%20Testing-2496ED)

# Product Catalog REST API

A simple REST API for managing a product catalog, built with **Spring Boot** and **Liquibase**. This project demonstrates clean architecture, database migrations, and RESTful design patterns.  

## Objective

Build a simple REST API for a **product catalog management system** using **Spring Boot** and **Liquibase**.  

The API should allow managing products and their producers with basic CRUD operations and support flexible product attributes. While some requirements are provided, creativity is encouraged—design the system in a way that is efficient, maintainable, and follows best practices for RESTful APIs and database design.
# Business Context

This project is the backend API for an **e-commerce platform** that sells products from multiple producers.  

The system needs to handle products of varying complexity:  

- Some products have just a few attributes, such as **description** and **price**.  
- Other products may have **50-200 attributes**, including dimensions, specifications, certifications, and more.  

Currently, the platform works with approximately **100 different producers**.  

For example, a producer like **Samsung** may sell TVs, phones, and laptops, each with a different set of product attributes. The API must be flexible enough to handle this variety efficiently.

# Business Requirements

The system must handle:

1. **Producers**  
   - The platform works with approximately 100 different producers/manufacturers.

2. **Products**  
   - Each product belongs to one producer, but producers can have multiple products.

3. **Product Attributes**  
   - Products have varying numbers of attributes depending on their type and complexity:  
     - Some products may have just a few attributes (**name, description, price**).  
     - Others may have **50–200 attributes** (**dimensions, specifications, technical details, certifications**, etc.).  
   - Example attributes: description, width, height, depth, weight, color, material, production_country, brand, warranty_period, energy_rating, certifications, and more.

---

# Required API Functionality

Implement REST endpoints that support the following operations:

1. **List Products**  
   - Retrieve all products in the system.  
   - Include relevant product information and producer details.

2. **Create Product**  
   - Add new products to the system.  
   - Associate products with producers.

3. **Update Product**  
   - Modify existing product information.  
   - Update product attributes.

4. **Delete Product**  
   - Remove products from the system.
# Cloudfide - Setup and Configuration

This guide explains how to configure and run the Cloudfide Spring Boot project with PostgreSQL and Liquibase.

---

## 1. Prerequisites

Make sure you have installed:

- **Java 21**
- **Maven 3.x**
- **PostgreSQL**
- (Optional) **Git** to clone the repository

---

## 2. Configure PostgreSQL

1. Start PostgreSQL on your machine (default port 5432).  
2. Create the database (if it doesn’t exist):

```sql
CREATE DATABASE postgres;
```
## 3. application.properties configuration

Ensure your `src/main/resources/application.properties` contains:

```properties
spring.application.name=Cloudfide

spring.datasource.url=jdbc:postgresql://localhost:<port>/<database_name>
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

spring.liquibase.change-log=classpath:db/changelog/db.changelog-master.yaml
```
## 4. Build and Run the Application

Build the project using Maven (stay in project folder):

```cmd
mvn clean install
```
Run the application (stay in project folder):
```cmd
mvn spring-boot:run
```
**Liquibase will execute migrations automatically.
**Application connects to PostgreSQL using the configured credentials.

## 5. Verify Database Migration

Check the database by running the following SQL commands:

```sql
SELECT * FROM databasechangelog;
SELECT * FROM products;
```
# Shop API Example

This demonstrates how to use the API to fetch all available products.

## API Endpoint
GET ; http://localhost:8080/v1/shop/findAll


### Response Example

The API returns a JSON array of shop objects. Each object contains the following fields:

- `id` – Shop ID
- `name` – Shop name
- `producentName` – Name of the producer/brand
- `atrubutes` – Optional attributes object (may be `null`)

Example response:

```json
[
  {
    "id": 2,
    "name": "test",
    "producentName": "Sony",
    "atrubutes": {
      "size": "3"
    }
  },
  {
    "id": 1,
    "name": "testtest",
    "producentName": "Apple",
    "atrubutes": null
  }
]
```
# Shop API - Create Product

This example demonstrates how to create a new product using the API.

## API Endpoint
POST ; http://localhost:8080/v1/shop/createProduct

### Request Body

The API expects a JSON object with the following structure:

- `name` – Name of the product (string)
- `producentid` – ID of the producer (integer)
- `attributes` – Optional object containing product attributes (may include fields like `size`)

Example request body:

```json
{
  "name": "test",
  "producentid": 1,
  "attributes": {
    "size": "3"
  }
}
```
# Shop API - Update Product

This example demonstrates how to update an existing product using the API.

## API Endpoint
PUT ; http://localhost:8080/v1/shop/updateProduct/{productid}

Replace `{productid}` with the ID of the product you want to update.

### Request Body

The API expects a JSON object with the following fields:

- `name` – Updated name of the product (string)  
- `producentid` – Updated producer ID (integer)  
- `atrubutes` – Optional object containing updated product attributes  

Example request body:

```json
{
    "name": "testtest",
    "producentid": 3,
    "atrubutes": {
        "size": 3
    }
}
```
# Shop API - Delete Product

This example demonstrates how to delete an existing product using the API.

## API Endpoint
DELETE ; http://localhost:8080/v1/shop/deleteProduct/{productid}
Replace `{productid}` with the ID of the product you want to delete.
