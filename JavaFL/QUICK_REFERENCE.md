# 🚀 Quick Reference - JavaFL API

## Base URL
```
http://localhost:8080/api/products
```

---

## 📌 API Endpoints

### 1. CREATE PRODUCT
```http
POST /api/products
Content-Type: application/json

{
  "name": "Product Name",
  "description": "Product Description",
  "price": 99.99,
  "quantity": 10,
  "category": "Category Name"
}

✅ Success: 201 Created
❌ Error: 400 Bad Request (validation failed)
```

---

### 2. GET PRODUCT BY ID
```http
GET /api/products/{id}

Example: GET /api/products/1

✅ Success: 200 OK
❌ Error: 404 Not Found
```

---

### 3. GET ALL PRODUCTS
```http
GET /api/products

✅ Success: 200 OK (returns array)
```

---

### 4. UPDATE PRODUCT
```http
PUT /api/products/{id}
Content-Type: application/json

{
  "name": "Updated Name",
  "description": "Updated Description",
  "price": 149.99,
  "quantity": 5,
  "category": "Updated Category"
}

✅ Success: 200 OK
❌ Error: 400 Bad Request (validation failed)
❌ Error: 404 Not Found
```

---

### 5. DELETE PRODUCT
```http
DELETE /api/products/{id}

Example: DELETE /api/products/1

✅ Success: 204 No Content
❌ Error: 404 Not Found
```

---

## 🔒 Validation Rules

| Field | Required | Rules |
|-------|----------|-------|
| name | ✅ Yes | Not empty, max 100 chars |
| description | ✅ Yes | Not empty |
| price | ✅ Yes | Must be > 0 |
| quantity | ✅ Yes | Must be >= 0 |
| category | ✅ Yes | Not empty |

---

## 🎯 HTTP Status Codes

| Code | Meaning | When |
|------|---------|------|
| 200 | OK | Successful GET/PUT |
| 201 | Created | Successful POST |
| 204 | No Content | Successful DELETE |
| 400 | Bad Request | Validation failed |
| 404 | Not Found | Product not found |
| 500 | Internal Server Error | Unexpected error |

---

## 📝 Example Requests (PowerShell)

### Create Product
```powershell
curl -X POST http://localhost:8080/api/products `
  -H "Content-Type: application/json" `
  -d '{\"name\":\"iPhone 15\",\"description\":\"Apple smartphone\",\"price\":79999,\"quantity\":50,\"category\":\"Electronics\"}'
```

### Get Product
```powershell
curl http://localhost:8080/api/products/1
```

### Get All Products
```powershell
curl http://localhost:8080/api/products
```

### Update Product
```powershell
curl -X PUT http://localhost:8080/api/products/1 `
  -H "Content-Type: application/json" `
  -d '{\"name\":\"iPhone 15 Pro\",\"description\":\"Apple flagship\",\"price\":99999,\"quantity\":30,\"category\":\"Electronics\"}'
```

### Delete Product
```powershell
curl -X DELETE http://localhost:8080/api/products/1
```

---

## 🧪 Quick Test

### 1. Start Application
```powershell
cd D:\DOWNLOAD\JavaFL\JavaFL
.\mvnw.cmd spring-boot:run
```

### 2. Run Tests
```powershell
# Option 1: Automated script
.\test-api.ps1

# Option 2: Manual test
curl http://localhost:8080/api/products
```

---

## ❌ Error Response Format

```json
{
  "timestamp": "2026-02-09T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Product name is required and cannot be empty",
  "path": "/api/products"
}
```

---

## 📋 Sample Products

### Electronics
```json
{
  "name": "Samsung Galaxy S24",
  "description": "Latest flagship smartphone",
  "price": 79999.99,
  "quantity": 50,
  "category": "Electronics"
}
```

### Books
```json
{
  "name": "Clean Code",
  "description": "Programming best practices",
  "price": 450.00,
  "quantity": 100,
  "category": "Books"
}
```

### Footwear
```json
{
  "name": "Nike Air Max",
  "description": "Running shoes",
  "price": 8999.00,
  "quantity": 75,
  "category": "Footwear"
}
```

---

## 🔍 Testing Checklist

- ✅ Create product with valid data
- ✅ Create product with invalid data (should fail)
- ✅ Get product by ID
- ✅ Get product with invalid ID (should return 404)
- ✅ Get all products
- ✅ Update product
- ✅ Update with invalid data (should fail)
- ✅ Delete product
- ✅ Delete non-existent product (should return 404)

---

## 🛠️ Troubleshooting

### Application not starting?
- Check Java is installed: `java -version`
- Verify JAVA_HOME is set: `echo $env:JAVA_HOME`
- Check port 8080 is free

### API not responding?
- Verify app is running: Check console output
- Check URL: `http://localhost:8080/api/products`
- Test with: `curl http://localhost:8080/api/products`

### Validation errors?
- Check all required fields are present
- Verify price > 0
- Verify quantity >= 0
- Check name length <= 100

---

## 📚 Full Documentation

For complete documentation, see:
- **README.md** - Full API documentation
- **SETUP_GUIDE.md** - Installation guide
- **PROJECT_SUMMARY.md** - Implementation details

---

## 🎯 Quick Commands

```powershell
# Build
.\mvnw.cmd clean install

# Run
.\mvnw.cmd spring-boot:run

# Test
.\test-api.ps1

# Create product
curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d '{\"name\":\"Test\",\"description\":\"Test\",\"price\":100,\"quantity\":10,\"category\":\"Test\"}'

# Get all
curl http://localhost:8080/api/products

# Get by ID
curl http://localhost:8080/api/products/1
```

---

**Need Help?** See the full documentation files in the project root!
