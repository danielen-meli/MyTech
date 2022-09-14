package Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TechItem {
    private Long id;
    private String title;
    private String description;
    private Double unit_price;
    private String pricture_url;
    private String category;
    private Long quantity;
    private String currency_id;



    public TechItem(Long id, String title, String category, Double price, Long quantity) {
        this.id = id;
        this.title = title;
        this.unit_price = price;
        this.quantity = quantity;
        this.category = category;
    }


}


