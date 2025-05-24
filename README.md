# Inventory Management API

RESTful API to manage product inventory.

## Features
- Product registration
- Stock in/out logging
- Inventory movement history
- Minimum stock alerts

## Technologies
- Java
- Spring Boot
- PostgreSQL

## How to run
1. Clone the repository
2. Configure `application.properties` with your PostgreSQL credentials
3. Run with `mvn spring-boot:run`

## Endpoints
- `POST /products`
- `GET /products`
- `PUT /products/{id}`
- `DELETE /products/{id}`
