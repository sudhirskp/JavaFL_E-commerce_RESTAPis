# JavaFL - E-Commerce Product Management REST API

A simple Java Spring Boot application that implements a RESTful API for managing a collection of products (similar to Flipkart's product catalog).

> 📚 **New to this project?** Start with [DOCUMENTATION_INDEX.md](DOCUMENTATION_INDEX.md) for a complete guide to all documentation!

## 📚 Documentation

- **[QUICK_REFERENCE.md](QUICK_REFERENCE.md)** - Quick API reference card ⚡
- **[SETUP_GUIDE.md](SETUP_GUIDE.md)** - Installation and setup instructions
- **[PROJECT_SUMMARY.md](PROJECT_SUMMARY.md)** - Complete implementation overview
- **[PROJECT_STRUCTURE.md](PROJECT_STRUCTURE.md)** - Visual project structure and diagrams

[//]: # (- **[CHECKLIST.md]&#40;CHECKLIST.md&#41;** - Requirements checklist and feature list)
- **[Postman_Collection.json](Postman_Collection.json)** - Postman collection for testing

[//]: # (- **[test-api.ps1]&#40;test-api.ps1&#41;** - PowerShell automated test script)

## Features

- ✅ RESTful API endpoints for CRUD operations
- ✅ In-memory data storage using ArrayList
- ✅ Input validation with detailed error messages
- ✅ Global exception handling
- ✅ Clean architecture with layers (Controller, Service, Repository)
- ✅ Comprehensive documentation

## Technology Stack

- **Java 21**
- **Spring Boot 4.0.2**
- **Spring Web MVC** - For REST API
- **Lombok** - To reduce boilerplate code
- **Maven** - Build and dependency management

## Project Structure

```
src/main/java/JavaFreeLance/JavaFL/
├── JavaFlApplication.java          # Main application class
├── controller/
│   └── ProductController.java      # REST API endpoints
├── service/
│   └── ProductService.java         # Business logic and validation
├── repository/
│   └── ProductRepository.java      # In-memory data storage
├── model/
│   └── Product.java                # Product entity
├── dto/
│   └── ProductDTO.java             # Data Transfer Object
└── exception/
    ├── ErrorResponse.java          # Error response structure
    ├── GlobalExceptionHandler.java # Global exception handler
    ├── ProductNotFoundException.java
    └── ValidationException.java
```

## Product Model

The Product entity has the following properties:

- **id** (Long) - Auto-generated unique identifier
- **name** (String) - Product name (required, max 100 characters)
- **description** (String) - Product description (required)
- **price** (BigDecimal) - Product price (required, must be > 0)
- **quantity** (Integer) - Available quantity (required, must be >= 0)
- **category** (String) - Product category (required)

## API Endpoints

### Base URL
```
http://localhost:8080/api/products
```

### 1. Create a New Product

**POST** `/api/products`

**Request Body:**
```json
{
  "name": "Samsung Galaxy S24",
  "description": "Latest flagship smartphone with advanced features",
  "price": 79999.99,
  "quantity": 50,
  "category": "Electronics"
}
```

**Response:** `201 Created`
```json
{
  "id": 1,
  "name": "Samsung Galaxy S24",
  "description": "Latest flagship smartphone with advanced features",
  "price": 79999.99,
  "quantity": 50,
  "category": "Electronics"
}
```

### 2. Get a Single Product by ID

**GET** `/api/products/{id}`

**Example:** `GET /api/products/1`

**Response:** `200 OK`
```json
{
  "id": 1,
  "name": "Samsung Galaxy S24",
  "description": "Latest flagship smartphone with advanced features",
  "price": 79999.99,
  "quantity": 50,
  "category": "Electronics"
}
```

**Error Response:** `404 Not Found`
```json
{
  "timestamp": "2026-02-09T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Product not found with id: 999",
  "path": "/api/products/999"
}
```

### 3. Get All Products

**GET** `/api/products`

**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "name": "Samsung Galaxy S24",
    "description": "Latest flagship smartphone with advanced features",
    "price": 79999.99,
    "quantity": 50,
    "category": "Electronics"
  },
  {
    "id": 2,
    "name": "Nike Air Max",
    "description": "Comfortable running shoes",
    "price": 8999.00,
    "quantity": 100,
    "category": "Footwear"
  }
]
```

### 4. Update a Product

**PUT** `/api/products/{id}`

**Request Body:**
```json
{
  "name": "Samsung Galaxy S24 Ultra",
  "description": "Premium flagship smartphone",
  "price": 99999.99,
  "quantity": 30,
  "category": "Electronics"
}
```

**Response:** `200 OK`
```json
{
  "id": 1,
  "name": "Samsung Galaxy S24 Ultra",
  "description": "Premium flagship smartphone",
  "price": 99999.99,
  "quantity": 30,
  "category": "Electronics"
}
```

### 5. Delete a Product

**DELETE** `/api/products/{id}`

**Response:** `204 No Content`

## Input Validation

The API validates all input data:

- **Name**: Required, cannot be empty, max 100 characters
- **Description**: Required, cannot be empty
- **Price**: Required, must be greater than 0
- **Quantity**: Required, cannot be negative
- **Category**: Required, cannot be empty

**Validation Error Example:** `400 Bad Request`
```json
{
  "timestamp": "2026-02-09T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Product price must be greater than 0",
  "path": "/api/products"
}
```

## How to Run the Application

### Prerequisites
- Java 21 or higher
- Maven 3.6+ (or use the included Maven wrapper)

### Steps

1. **Navigate to the project directory:**
   ```powershell
   cd D:\DOWNLOAD\JavaFL\JavaFL
   ```

2. **Build the project:**
   ```powershell
   .\mvnw.cmd clean install
   ```

3. **Run the application:**
   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

4. **The application will start on port 8080:**
   ```
   http://localhost:8080
   ```

## Testing the API

### Automated Testing with PowerShell Script

The easiest way to test all endpoints is using the included test script:

```powershell
.\test-api.ps1
```

This script will:
- Create multiple products
- Retrieve products (single and all)
- Update a product
- Test input validation
- Test error handling (404)
- Delete a product
- Verify deletion

### Using cURL (PowerShell)

**Create a Product:**
```powershell
curl -X POST http://localhost:8080/api/products `
  -H "Content-Type: application/json" `
  -d '{\"name\":\"iPhone 15 Pro\",\"description\":\"Apple flagship smartphone\",\"price\":129999.00,\"quantity\":25,\"category\":\"Electronics\"}'
```

**Get Product by ID:**
```powershell
curl http://localhost:8080/api/products/1
```

**Get All Products:**
```powershell
curl http://localhost:8080/api/products
```

**Update a Product:**
```powershell
curl -X PUT http://localhost:8080/api/products/1 `
  -H "Content-Type: application/json" `
  -d '{\"name\":\"iPhone 15 Pro Max\",\"description\":\"Apple flagship smartphone\",\"price\":149999.00,\"quantity\":20,\"category\":\"Electronics\"}'
```

**Delete a Product:**
```powershell
curl -X DELETE http://localhost:8080/api/products/1
```

### Using Postman

1. Open Postman
2. Click "Import" → "Upload Files"
3. Select `Postman_Collection.json` from the project root
4. The collection includes:
   - All CRUD operations
   - Validation test cases
   - Error handling test cases
   - Sample product creation requests
5. Set base URL: `http://localhost:8080/api/products`
6. Test each endpoint with appropriate request bodies

## Implementation Details

### In-Memory Data Storage

- **ProductRepository** uses an `ArrayList<Product>` to store products
- **Thread-safe ID generation** using `AtomicLong`
- Data is stored in memory and will be lost when the application stops
- Perfect for development, testing, and demonstration purposes

### Layered Architecture

1. **Controller Layer** - Handles HTTP requests/responses
2. **Service Layer** - Contains business logic and validation
3. **Repository Layer** - Manages data storage and retrieval
4. **Exception Handling** - Global exception handler for consistent error responses

### Validation Rules

All validation is performed in the `ProductService` class:
- Required field checks
- Length constraints
- Numeric value constraints (positive prices, non-negative quantities)
- Detailed error messages for each validation failure

### Error Handling

The application uses a global exception handler that catches:
- `ProductNotFoundException` → 404 Not Found
- `ValidationException` → 400 Bad Request
- Generic exceptions → 500 Internal Server Error

All errors return a consistent `ErrorResponse` structure with:
- Timestamp
- HTTP status code
- Error type
- Error message
- Request path

## Sample Test Scenarios

### Scenario 1: Create and Retrieve Products

```powershell
# Create Product 1
curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d '{\"name\":\"Laptop\",\"description\":\"Gaming Laptop\",\"price\":85000.00,\"quantity\":10,\"category\":\"Electronics\"}'

# Create Product 2
curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d '{\"name\":\"Book\",\"description\":\"Programming Book\",\"price\":500.00,\"quantity\":50,\"category\":\"Books\"}'

# Get all products
curl http://localhost:8080/api/products

# Get specific product
curl http://localhost:8080/api/products/1
```

### Scenario 2: Test Validation

```powershell
# Try to create product with empty name (will fail)
curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d '{\"name\":\"\",\"description\":\"Test\",\"price\":100.00,\"quantity\":10,\"category\":\"Test\"}'

# Try to create product with negative price (will fail)
curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d '{\"name\":\"Test\",\"description\":\"Test\",\"price\":-100.00,\"quantity\":10,\"category\":\"Test\"}'
```

## Future Enhancements

- Add database persistence (H2, MySQL, PostgreSQL)
- Implement search and filtering by category, price range
- Add pagination for large product lists
- Implement authentication and authorization
- Add product images/media support
- Implement inventory management features
- Add unit and integration tests

## Author

JavaFL Team

## License

This project is open source and available for educational purposes.
