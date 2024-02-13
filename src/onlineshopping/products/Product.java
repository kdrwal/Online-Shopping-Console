package onlineshopping.products;

import java.math.BigDecimal;

public class Product {

    //Attributes
    protected String name;
    protected BigDecimal price;
    protected int id;

    //Constructor
    public Product(String name, BigDecimal price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }


    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
