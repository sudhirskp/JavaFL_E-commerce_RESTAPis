package JavaFreeLance.JavaFL.exception;

/**
 * Custom exception thrown when a product is not found.
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Product not found with id: " + id);
    }

}
