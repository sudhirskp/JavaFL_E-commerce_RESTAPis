package JavaFreeLance.JavaFL.controller;

import JavaFreeLance.JavaFL.dto.ProductDTO;
import JavaFreeLance.JavaFL.model.Product;
import JavaFreeLance.JavaFL.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Product management.
 * Provides endpoints for CRUD operations on products.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Create a new product.
     *
     * POST /api/products
     *
     * Request Body:
     * {
     *   "name": "Product Name",
     *   "description": "Product Description",
     *   "price": 99.99,
     *   "quantity": 10,
     *   "category": "Electronics"
     * }
     *
     * @param productDTO The product data
     * @return ResponseEntity with created product and 201 status
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        Product createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    /**
     * Get a single product by ID.
     *
     * GET /api/products/{id}
     *
     * @param id The product ID
     * @return ResponseEntity with product and 200 status
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    /**
     * Get all products.
     *
     * GET /api/products
     *
     * @return ResponseEntity with list of all products and 200 status
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * Update an existing product.
     *
     * PUT /api/products/{id}
     *
     * Request Body:
     * {
     *   "name": "Updated Product Name",
     *   "description": "Updated Description",
     *   "price": 149.99,
     *   "quantity": 5,
     *   "category": "Electronics"
     * }
     *
     * @param id The product ID to update
     * @param productDTO The updated product data
     * @return ResponseEntity with updated product and 200 status
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDTO productDTO) {
        Product updatedProduct = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * Delete a product by ID.
     *
     * DELETE /api/products/{id}
     *
     * @param id The product ID to delete
     * @return ResponseEntity with 204 No Content status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
