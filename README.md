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

 ## 🛠 Setup
1. Configure database in `application.properties`
2. Build: `mvn clean install`
3. Run: `mvn spring-boot:run`


# API Documentation
`http://localhost:8081/swagger-ui.html`


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

