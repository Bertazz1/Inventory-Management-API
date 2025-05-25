
# Inventory Management API

A RESTful API for managing product inventory, with support for **email notifications**, **pagination**, **sorting**, **unit tests**, and **Dockerized deployment**.

## 🚀 Features
- ✅ Product CRUD (Create, Read, Update, Delete)
- ✅ Low stock **email notifications**
- ✅ **Pagination** and **sorting** for product listings
- ✅ **Unit tests** with Spring Boot Test
- ✅ **Docker** and **docker-compose** for easy deployment

## 🛠️ Technologies
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Spring Mail
- Docker & docker-compose
- JUnit 5

## ⚙️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/inventory-api.git
cd inventory-api
```

### 2. Configure Database and Email

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://postgres:5432/inventory_db
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
```

### 3. Build the project

```bash
mvn clean package
```

### 4. Run with Docker Compose

```bash
docker-compose up --build
```

## 📝 API Endpoints

| Method | Endpoint         | Description                  |
|-------- |---------------- |----------------------------- |
| GET     | /products       | List all products (with pagination) |
| GET     | /products/{id}  | Get product by ID            |
| POST    | /products       | Create a new product         |
| PUT     | /products/{id}  | Update product               |
| DELETE  | /products/{id}  | Delete product               |

## 📧 Email Notification

When a product's quantity is **less than or equal** to `minStock`, an **email alert** is sent automatically.

## ✅ Example Request

```json
{
  "name": "Printer Paper",
  "quantity": 10,
  "minStock": 15
}
```

## 🧪 Running Tests

```bash
mvn test
```

## 🐳 Running in Docker

```bash
docker build -t inventory-api .
docker run -p 8080:8080 inventory-api
```

or

```bash
docker-compose up --build
```

## 🗂️ Project Structure

```
src/
 └── main/
     ├── java/com/gustavo/inventory/
     │    ├── controller/
     │    ├── model/
     │    ├── repository/
     │    └── service/
     └── resources/
```

## ✍️ Author

**Gustavo Bertuzzi**  
[LinkedIn](https://www.linkedin.com/in/gustavo-bertuzzi)

## ⭐ Contributions

Pull requests are welcome!  
Please open an issue to discuss your ideas or report bugs.
