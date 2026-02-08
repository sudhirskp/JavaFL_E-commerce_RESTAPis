package JavaFreeLance.JavaFL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Product entity representing an item in the e-commerce system.
 * This class uses Lombok annotations to reduce boilerplate code.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String category;

}
