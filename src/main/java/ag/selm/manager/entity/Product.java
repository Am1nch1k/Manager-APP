package ag.selm.manager.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private int id;
    private String title;
    private String description;

    public Product(String title, String description) {
        this.title = title;
        this.description = description;
    }
}