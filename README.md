# Project Information
| **Supervisor** | Dr. Nguyễn Bảo Ân |
|----------------|--------------------|
| **Student**    | Trần Minh Điền (Student ID: 110122050, DA22TTA) |


## Building & Apartment Management System

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



# API Documentation

## 🏢 Buildings API

### Get All Buildings
```http
GET /api/buildings

Response: 200 OK
[
  {
    "id": 1,
    "name": "Central Tower",
    "address": "123 Main St",
    "numberOfFloors": 20,
    "totalArea": 5000.0,
    "type": "Commercial"
  }
]
```

### Get Building by ID
```http
GET /api/buildings/{id}

Response: 200 OK
{
  "id": 1,
  "name": "Central Tower",
  "address": "123 Main St",
  "numberOfFloors": 20,
  "totalArea": 5000.0
}
```

### Create Building
```http
POST /api/buildings
Content-Type: application/json

Request:
{
  "name": "New Building",
  "address": "456 Park Ave",
  "numberOfFloors": 15,
  "totalArea": 3000.0,
  "type": "Residential"
}

Response: 201 Created
```

### Update Building
```http
PUT /api/buildings/{id}
Content-Type: application/json

Request:
{
  "name": "Updated Name",
  "address": "789 Oak St",
  "numberOfFloors": 12
}

Response: 200 OK
```

### Delete Building
```http
DELETE /api/buildings/{id}

Response: 204 No Content
```

### Get Building Analytics
```http
GET /api/buildings/analytics

Response: 200 OK
{
  "totalBuildings": 10,
  "totalArea": 50000.0,
  "averageFloors": 15
}
```

## 🏠 Apartments API 

### Get All Apartments
```http
GET /api/apartments

Response: 200 OK
[
  {
    "id": 1,
    "name": "Apt 101",
    "floorArea": 120.5,
    "buildingId": 1,
    "numberOfRooms": 3
  }
]
```

### Get Apartment by ID
```http
GET /api/apartments/{id}

Response: 200 OK
{
  "id": 1,
  "name": "Apt 101",
  "floorArea": 120.5,
  "buildingId": 1
}
```

### Create Apartment
```http
POST /api/apartments
Content-Type: application/json

Request:
{
  "name": "New Apartment",
  "floorArea": 150.0,
  "buildingId": 1,
  "numberOfRooms": 2
}

Response: 201 Created
```

### Update Apartment
```http
PUT /api/apartments/{id}
Content-Type: application/json

Request:
{
  "name": "Updated Apt",
  "floorArea": 160.0
}

Response: 200 OK
```

### Delete Apartment
```http
DELETE /api/apartments/{id}

Response: 204 No Content
```

## 📋 Contracts API

### Get All Contracts
```http
GET /api/contracts

Response: 200 OK
[
  {
    "id": 1,
    "apartmentId": 1,
    "customerId": 1,
    "startDate": "2024-01-01",
    "endDate": "2024-12-31",
    "monthlyRent": 1500.0
  }
]
```

### Get Contract by ID
```http
GET /api/contracts/{id}

Response: 200 OK
{
  "id": 1,
  "apartmentId": 1,
  "customerId": 1,
  "startDate": "2024-01-01",
  "endDate": "2024-12-31"
}
```

### Create Contract
```http
POST /api/contracts
Content-Type: application/json

Request:
{
  "apartmentId": 1,
  "customerId": 1,
  "startDate": "2024-01-01",
  "endDate": "2024-12-31",
  "monthlyRent": 1500.0
}

Response: 201 Created
```

### Update Contract
```http
PUT /api/contracts/{id}
Content-Type: application/json

Request:
{
  "monthlyRent": 1600.0,
  "endDate": "2024-12-31"
}

Response: 200 OK
```

### Delete Contract
```http
DELETE /api/contracts/{id}

Response: 204 No Content
```

## 👥 Customers API

### Get All Customers
```http
GET /api/customers

Response: 200 OK
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "phone": "+1234567890"
  }
]
```

### Get Customer by ID
```http
GET /api/customers/{id}

Response: 200 OK
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com"
}
```

### Create Customer
```http
POST /api/customers
Content-Type: application/json

Request:
{
  "name": "Jane Smith",
  "email": "jane@example.com",
  "phone": "+0987654321"
}

Response: 201 Created
```

### Update Customer
```http
PUT /api/customers/{id}
Content-Type: application/json

Request:
{
  "name": "Jane Smith Updated",
  "phone": "+1111111111"
}

Response: 200 OK
```

### Delete Customer
```http
DELETE /api/customers/{id}

Response: 204 No Content
```

## 👤 Users API

### Get All Users
```http
GET /api/users

Response: 200 OK
[
  {
    "id": 1,
    "username": "johndoe",
    "role": "USER"
  }
]
```

### Get User by ID
```http
GET /api/users/{id}

Response: 200 OK
{
  "id": 1,
  "username": "johndoe",
  "role": "USER"
}
```

### Get User by Username
```http
GET /api/users/username/{username}

Response: 200 OK
{
  "id": 1,
  "username": "johndoe",
  "role": "USER"
}
```

### Create User
```http
POST /api/users
Content-Type: application/json

Request:
{
  "username": "newuser",
  "password": "password123",
  "role": "USER"
}

Response: 201 Created
```

### Update User
```http
PUT /api/users/{id}
Content-Type: application/json

Request:
{
  "username": "updateduser",
  "password": "newpassword"
}

Response: 200 OK
```

### Delete User
```http
DELETE /api/users/{id}

Response: 204 No Content
```

## Status Codes

| Code | Description |
|------|-------------|
| 200 | Success |
| 201 | Created |
| 204 | No Content |
| 400 | Bad Request |
| 401 | Unauthorized |
| 404 | Not Found |
| 500 | Server Error |



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
