package onlineshopping.products;

import java.math.BigDecimal;

public class DigitalProduct extends Product {

    //Attribute
    private String downloadLink;

    //Constructor
    public DigitalProduct(String name, BigDecimal price, int id, String downloadLink) {
        super(name, price, id);
        this.downloadLink = downloadLink;
    }

    //Getters and Setters
    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }
}
