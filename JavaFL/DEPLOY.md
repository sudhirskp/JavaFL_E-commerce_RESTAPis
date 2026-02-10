# Deploy to Render

## Required Files (Already Configured)
- ✅ `render.yaml` - Deployment configuration
- ✅ `system.properties` - Java version (23)
- ✅ `application.properties` - PORT environment variable
- ✅ `.gitattributes` - Correct line endings
- ✅ `mvnw` - Executable permissions set

## Deploy Steps

1. **Before first push, set mvnw executable permission:**
   ```bash
   git update-index --chmod=+x mvnw
   git add .
   git commit -m "Fix mvnw permissions for Render"
   ```

2. Push code to GitHub/GitLab/Bitbucket
3. Go to https://dashboard.render.com
4. Click "New +" → "Web Service"
5. Connect your repository
6. Render auto-detects `render.yaml`
7. Click "Create Web Service"

Your API will be live at: `https://your-service-name.onrender.com`

Test: `https://your-service-name.onrender.com/api/products`
