# Building & Apartment Management API Guide

## Buildings API

### Get All Buildings
```http
GET /api/buildings
```
Returns a list of all buildings.

### Get Building by ID 
```http
GET /api/buildings/{id}
```
Returns details for a specific building.

### Create Building
```http
POST /api/buildings
Content-Type: application/json

{
  "name": "Building Name",
  "address": "Building Address",
  "numberOfFloors": 10,
  "totalArea": 1000.0,
  "type": "Residential",
  "contactNumber": "123-456-7890",
  "districtId": 1
}
```

### Update Building
```http
PUT /api/buildings/{id}
Content-Type: application/json

{
  "name": "Updated Name",
  "address": "Updated Address",
  "numberOfFloors": 12
}
```

### Delete Building
```http
DELETE /api/buildings/{id}
```

### Get Building Analytics
```http
GET /api/buildings/analytics
```
Returns analytics data for all buildings.

## Apartments API

### Get All Apartments
```http
GET /api/apartments
```
Returns a list of all apartments.

### Get Apartment by ID
```http
GET /api/apartments/{id}
```

### Create Apartment 
```http
POST /api/apartments
Content-Type: application/json

{
  "name": "Apartment Name",
  "floorArea": 100.0,
  "numberOfBedrooms": 2,
  "numberOfBathrooms": 1,
  "rented": false,
  "buildingId": 1
}
```

### Update Apartment
```http
PUT /api/apartments/{id}
Content-Type: application/json

{
  "name": "Updated Name",
  "floorArea": 120.0,
  "rented": true
}
```

### Delete Apartment
```http
DELETE /api/apartments/{id}
```

## Contracts API

### Get All Contracts
```http
GET /api/contracts
```

### Get Contract by ID
```http
GET /api/contracts/{id}
```

### Create Contract
```http
POST /api/contracts
Content-Type: application/json

{
  "apartmentId": 1,
  "customerId": 1,
  "startDate": "2024-01-01",
  "endDate": "2024-12-31", 
  "monthlyRent": 1000.0,
  "deposit": 2000.0,
  "paymentStatus": "PAID"
}
```

### Update Contract
```http
PUT /api/contracts/{id}
Content-Type: application/json

{
  "monthlyRent": 1200.0,
  "paymentStatus": "PENDING"
}
```

### Delete Contract
```http
DELETE /api/contracts/{id}
```

## Users API

### Get All Users
```http
GET /api/users
```

### Get User by ID
```http
GET /api/users/{id}
```

### Get User by Username
```http
GET /api/users/username/{username}
```

### Create User
```http
POST /api/users
Content-Type: application/json

{
  "userName": "username",
  "password": "password",
  "role": "USER"
}
```

### Update User
```http
PUT /api/users/{id}
Content-Type: application/json

{
  "userName": "newUsername",
  "password": "newPassword" 
}
```

### Delete User
```http
DELETE /api/users/{id}
```

All endpoints return appropriate HTTP status codes:
- 200 OK for successful operations
- 404 Not Found if resource doesn't exist
- 400 Bad Request for invalid input