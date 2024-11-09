# Project Information
|------------------------------|-------------------------------------------|
| **Supervisor**               | Dr. Nguyễn Bảo Ân                         |
| **Student**                  | Trần Minh Điền (Student ID: 110122050, DA22TTA) |


# Building & Apartment Management System

A comprehensive Spring Boot application for managing buildings, apartments, users, contracts and customers.

## 🚀 Features
- Building & Apartment management (CRUD operations)
- User account management
- Customer management
- Contract tracking
- Building analytics
- District-based organization
- Exception handling with custom responses

## 🛠 Tech Stack
- Java 8
- Spring Boot 2.0.9
- Spring Data JPA
- MySQL Database
- ModelMapper
- Maven
- RESTful APIs

## 🌐 API Endpoints

### Buildings (`/api/buildings`)
- `GET /api/buildings` - Get all buildings
- `GET /api/buildings/{id}` - Get building by ID
- `POST /api/buildings` - Create new building
- `PUT /api/buildings/{id}` - Update building
- `DELETE /api/buildings/{id}` - Delete building
- `GET /api/buildings/analytics` - Get building analytics
- `GET /api/buildings/apartments/{districtId}` - Get apartments by district

### Apartments (`/api/apartments`)
- `GET /api/apartments` - Get all apartments
- `GET /api/apartments/{id}` - Get apartment by ID
- `POST /api/apartments` - Create new apartment
- `PUT /api/apartments/{id}` - Update apartment
- `DELETE /api/apartments/{id}` - Delete apartment

### Users (`/api/users`)
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create new user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user
- `GET /api/users/username/{username}` - Get user by username

### Customers (`/api/customers`)
- `GET /api/customers` - Get all customers
- `GET /api/customers/{id}` - Get customer by ID
- `POST /api/customers` - Create new customer
- `PUT /api/customers/{id}` - Update customer
- `DELETE /api/customers/{id}` - Delete customer

### Contracts (`/api/contracts`)
- `GET /api/contracts` - Get all contracts
- `GET /api/contracts/{id}` - Get contract by ID
- `POST /api/contracts` - Create new contract
- `PUT /api/contracts/{id}` - Update contract
- `DELETE /api/contracts/{id}` - Delete contract

## 🏗 Key Controllers
- `BuildingAPI` - Building management endpoints
- `ApartmentAPI` - Apartment management endpoints
- `UserAPI` - User account management endpoints
- `CustomerAPI` - Customer management endpoints
- `ContractAPI` - Contract management endpoints

## 🔧 Error Handling
Global exception handling via `ControllerAdvisor` for:
- ArithmeticException
- FieldRequiredException
- Custom error responses

## 📝 Response Formats
- Success responses: HTTP 200 OK with data/empty body
- Create/Update responses: HTTP 200 OK
- Delete responses: HTTP 200 OK or 204 No Content
- Error responses: HTTP 404 Not Found or 500 Internal Server Error with error details

## 🛠 Setup
1. Configure database in `application.properties`
2. Build: `mvn clean install`
3. Run: `mvn spring-boot:run`