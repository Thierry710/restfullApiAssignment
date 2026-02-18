# RESTful API for E-Commerce – Assignment

Kamanzi Thierry  
Student ID: 27215  
Course: Web Services / RESTful API  
Instructor: __________________  

---

## Overview

This assignment demonstrates the development of a RESTful API for an e-commerce product management system using Spring Boot and JPA. The project implements full CRUD functionality, allowing products to be created, retrieved, updated, and deleted through HTTP requests.

The application follows a layered architecture consisting of Controller, Service, Repository, and Model components. All endpoints were tested using Postman to ensure correct functionality and proper HTTP status responses.

---

## Project Architecture

The system is structured using a layered design pattern:

- **Controller Layer** – Handles HTTP requests and responses.
- **Service Layer** – Contains business logic.
- **Repository Layer** – Manages database interactions using JPA.
- **Model Layer** – Defines the Product entity.

This structure ensures clean code organization and maintainability.

---

## Product Creation

New products can be added using the following endpoint:

**POST**  
`/api/products/addProduct`

Before saving a product, the system checks whether a product with the same ID already exists in the database.

- If the product exists → A conflict response is returned.
- If the product does not exist → The product is successfully saved.

This validation ensures data consistency and prevents duplicate entries.

---

## View Operations

The API supports two viewing operations:

### View All Products

**GET**  
`/api/products/viewAll`

Retrieves all products stored in the database.

### View Product by ID

**GET**  
`/api/products/view/{id}`

Retrieves a specific product based on its ID.

- If the product exists → The product details are returned.
- If the product does not exist → A NOT FOUND response is returned.

---

## Update Operation

Products can be updated using:

**PUT**  
`/api/products/update/{id}`

The system first verifies that the product exists.

- If found → The product details (name, description, price, category, and stock quantity) are updated successfully.
- If not found → An appropriate error response is returned.

---

## Delete Operation

Products can be deleted using:

**DELETE**  
`/api/products/delete/{id}`

The system confirms whether the product exists before deletion.

- If it exists → The product is removed from the database.
- If it does not exist → A NOT FOUND response is returned.

---

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- MySQL / H2 Database
- Postman (for API testing)

---

## Challenges Encountered

During development, minor import issues occurred when adding additional REST mapping annotations. This was resolved by correctly importing Spring Web annotations and ensuring all required dependencies were properly configured in the project.

After resolving the issue, all CRUD operations functioned correctly.

---

## Conclusion

This assignment demonstrates the successful implementation of a fully functional RESTful API for an e-commerce product management system. The project applies Spring Boot architecture, layered design principles, proper HTTP status handling, and full CRUD functionality.

The experience strengthened practical knowledge of RESTful services, backend development, and structured application design.
