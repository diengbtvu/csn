# Building & Apartment Management System

A Spring Boot application for managing buildings and apartments with REST APIs.

## 🚀 Features
- Building management (CRUD operations)
- Apartment management
- Contract tracking
- Equipment inventory
- Building analytics
- District-based organization

## 🛠 Tech Stack
- Java 8
- Spring Boot 2.0.9
- Spring Data JPA
- MySQL Database
- ModelMapper
- Maven
- HTML/CSS/JavaScript (Frontend)

## 🔧 Setup
Configure your MySQL database in `application.properties`:

Build the project:
```bash
mvn clean install
```

Run the application:
```bash
mvn spring-boot:run
```

## 🌐 API Endpoints

### Buildings
- `GET /buildings` - Get all buildings
- `GET /buildings/{id}` - Get building by ID
- `POST /buildings` - Create new building
- `PUT /buildings/{id}` - Update building
- `DELETE /buildings/{id}` - Delete building
- `GET /buildings/analytics` - Get building analytics
- `GET /buildings/apartments/{districtId}` - Get apartments by district

### Apartments
- `GET /apartments` - Get all apartments
- `GET /apartments/{id}` - Get apartment by ID
- `POST /apartments` - Create new apartment
- `PUT /apartments/{id}` - Update apartment
- `DELETE /apartments/{id}` - Delete apartment

## Updating...

## 🏗 Data Models

### Building Entity
- ID
- Name
- Address
- Number of floors
- Total area
- Type
- Contact number
- District reference
- List of apartments

### Apartment Entity
- ID
- Name
- Minimum rate
- Floor area
- Number of bedrooms/bathrooms
- Rental status
- Move in/out dates
- Building reference

### Updating...

## 🔑 Key Classes
- `BuildingAPI` - REST controller for building operations
- `ApartmentAPI` - REST controller for apartment operations
- Updating...