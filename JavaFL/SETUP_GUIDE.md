# Quick Start Guide

## Prerequisites

Before running this application, you need to have:

1. **Java Development Kit (JDK) 21 or higher**
   - Download from: https://www.oracle.com/java/technologies/downloads/
   - Or use OpenJDK: https://adoptium.net/
   
2. **Set JAVA_HOME environment variable**
   - Windows: `setx JAVA_HOME "C:\Program Files\Java\jdk-21"` (adjust path as needed)
   - Add `%JAVA_HOME%\bin` to your PATH

## Installation Steps

### Step 1: Install Java

1. Download JDK 21 from the official website
2. Install it to your system
3. Verify installation:
   ```powershell
   java -version
   ```
   Should output something like: `java version "21.0.x"`

### Step 2: Set Environment Variables

Open PowerShell as Administrator and run:

```powershell
# Set JAVA_HOME (adjust path to where you installed Java)
[System.Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Java\jdk-21", "Machine")

# Add Java to PATH
$currentPath = [System.Environment]::GetEnvironmentVariable("Path", "Machine")
[System.Environment]::SetEnvironmentVariable("Path", $currentPath + ";%JAVA_HOME%\bin", "Machine")
```

**Note:** You'll need to restart your terminal/PowerShell after setting these variables.

### Step 3: Verify Maven Wrapper

The project includes Maven wrapper, so you don't need to install Maven separately. Test it:

```powershell
cd D:\DOWNLOAD\JavaFL\JavaFL
.\mvnw.cmd --version
```

### Step 4: Build the Project

```powershell
cd D:\DOWNLOAD\JavaFL\JavaFL
.\mvnw.cmd clean install
```

This will:
- Download all required dependencies
- Compile the code
- Run tests (if any)
- Package the application

### Step 5: Run the Application

```powershell
.\mvnw.cmd spring-boot:run
```

The application will start on port 8080. You should see output like:
```
Started JavaFlApplication in X.XXX seconds
```

### Step 6: Test the API

Open a new PowerShell window and test the endpoints:

```powershell
# Create a product
curl -X POST http://localhost:8080/api/products `
  -H "Content-Type: application/json" `
  -d '{\"name\":\"Test Product\",\"description\":\"Test Description\",\"price\":99.99,\"quantity\":10,\"category\":\"Test\"}'

# Get all products
curl http://localhost:8080/api/products

# Get product by ID
curl http://localhost:8080/api/products/1
```

## Troubleshooting

### Issue: "Cannot find Java"
- Ensure JDK 21 is installed
- Verify JAVA_HOME is set correctly: `echo $env:JAVA_HOME`
- Restart your terminal after setting environment variables

### Issue: "Port 8080 already in use"
- Change the port in `src/main/resources/application.properties`:
  ```properties
  server.port=8081
  ```

### Issue: Maven build fails
- Check your internet connection (Maven needs to download dependencies)
- Delete the `.m2` cache folder if corrupted: `C:\Users\YourUsername\.m2\repository`
- Try running: `.\mvnw.cmd clean install -U` (forces update of dependencies)

### Issue: IDE shows errors
- The IntelliJ IDEA needs to index the project first
- Right-click on `pom.xml` → "Maven" → "Reload Project"
- "File" → "Invalidate Caches" → "Invalidate and Restart"

## Alternative: Using Pre-built JAR

After building with `mvnw.cmd clean install`, you can run the JAR directly:

```powershell
java -jar target\JavaFL-0.0.1-SNAPSHOT.jar
```

## Next Steps

Once the application is running:

1. Read the main README.md for API documentation
2. Test all endpoints using cURL, Postman, or your browser
3. Check the console logs for debugging information
4. Modify the code to add new features

## Support

If you encounter issues:
1. Check the error messages in the console
2. Verify all prerequisites are installed correctly
3. Ensure no other application is using port 8080
4. Review the main README.md for detailed API documentation
