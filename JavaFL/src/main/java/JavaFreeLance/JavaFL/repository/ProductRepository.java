package JavaFreeLance.JavaFL.repository;

import JavaFreeLance.JavaFL.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * In-memory repository for managing Product data.
 * Uses ArrayList for data storage and AtomicLong for ID generation.
 */
@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    /**
     * Save a new product to the in-memory store.
     * Automatically generates an ID for the product.
     *
     * @param product The product to save
     * @return The saved product with generated ID
     */
    public Product save(Product product) {
        product.setId(idGenerator.getAndIncrement());
        products.add(product);
        return product;
    }

    /**
     * Find a product by its ID.
     *
     * @param id The product ID
     * @return Optional containing the product if found, empty otherwise
     */
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    /**
     * Get all products from the store.
     *
     * @return List of all products
     */
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    /**
     * Delete a product by its ID.
     *
     * @param id The product ID
     * @return true if product was deleted, false if not found
     */
    public boolean deleteById(Long id) {
        return products.removeIf(product -> product.getId().equals(id));
    }

    /**
     * Update an existing product.
     *
     * @param id The product ID to update
     * @param updatedProduct The updated product data
     * @return Optional containing the updated product if found, empty otherwise
     */
    public Optional<Product> update(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            product.setCategory(updatedProduct.getCategory());
            return Optional.of(product);
        }
        return Optional.empty();
    }

}
