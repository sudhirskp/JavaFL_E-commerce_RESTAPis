package JavaFreeLance.JavaFL.service;

import JavaFreeLance.JavaFL.dto.ProductDTO;
import JavaFreeLance.JavaFL.exception.ProductNotFoundException;
import JavaFreeLance.JavaFL.exception.ValidationException;
import JavaFreeLance.JavaFL.model.Product;
import JavaFreeLance.JavaFL.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service layer for Product business logic.
 * Contains validation and business rules.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Create a new product with validation.
     *
     * @param productDTO The product data to create
     * @return The created product
     * @throws ValidationException if validation fails
     */
    public Product createProduct(ProductDTO productDTO) {
        validateProductDTO(productDTO);

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setCategory(productDTO.getCategory());

        return productRepository.save(product);
    }

    /**
     * Get a product by ID.
     *
     * @param id The product ID
     * @return The product
     * @throws ProductNotFoundException if product not found
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    /**
     * Get all products.
     *
     * @return List of all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Update an existing product.
     *
     * @param id The product ID to update
     * @param productDTO The updated product data
     * @return The updated product
     * @throws ProductNotFoundException if product not found
     * @throws ValidationException if validation fails
     */
    public Product updateProduct(Long id, ProductDTO productDTO) {
        validateProductDTO(productDTO);

        Product updatedProduct = new Product();
        updatedProduct.setName(productDTO.getName());
        updatedProduct.setDescription(productDTO.getDescription());
        updatedProduct.setPrice(productDTO.getPrice());
        updatedProduct.setQuantity(productDTO.getQuantity());
        updatedProduct.setCategory(productDTO.getCategory());

        return productRepository.update(id, updatedProduct)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    /**
     * Delete a product by ID.
     *
     * @param id The product ID to delete
     * @throws ProductNotFoundException if product not found
     */
    public void deleteProduct(Long id) {
        boolean deleted = productRepository.deleteById(id);
        if (!deleted) {
            throw new ProductNotFoundException(id);
        }
    }

    /**
     * Validate ProductDTO input.
     *
     * @param productDTO The product data to validate
     * @throws ValidationException if validation fails
     */
    private void validateProductDTO(ProductDTO productDTO) {
        if (productDTO.getName() == null || productDTO.getName().trim().isEmpty()) {
            throw new ValidationException("Product name is required and cannot be empty");
        }

        if (productDTO.getName().length() > 100) {
            throw new ValidationException("Product name cannot exceed 100 characters");
        }

        if (productDTO.getDescription() == null || productDTO.getDescription().trim().isEmpty()) {
            throw new ValidationException("Product description is required and cannot be empty");
        }

        if (productDTO.getPrice() == null) {
            throw new ValidationException("Product price is required");
        }

        if (productDTO.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Product price must be greater than 0");
        }

        if (productDTO.getQuantity() == null) {
            throw new ValidationException("Product quantity is required");
        }

        if (productDTO.getQuantity() < 0) {
            throw new ValidationException("Product quantity cannot be negative");
        }

        if (productDTO.getCategory() == null || productDTO.getCategory().trim().isEmpty()) {
            throw new ValidationException("Product category is required and cannot be empty");
        }
    }

}
