package JavaFreeLance.JavaFL.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Data Transfer Object for creating/updating Product.
 * Used for input validation and API requests.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String category;

}
