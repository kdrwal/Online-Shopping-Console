package onlineshopping.cart;

import onlineshopping.products.Product;

import java.math.BigDecimal;

public class Inventory {

    //Attributes
    private Product product;
    private int counter;
    private BigDecimal price;

    //Constructor
    public Inventory(Product product) {
        this.product = product;
        this.counter = 1;
        this.price = product.getPrice();
    }

    //Getters
    public Product getProduct() {
        return product;
    }

    public int getCounter() {
        return counter;
    }

    public BigDecimal getPrice() {
        return price;
    }

    //Methods

    //Increase the quantity of the product in the cart
    public void increaseCounter() {
        counter++;
        recalculate();
    }

    //Decrease the quantity of the product in the cart
    public void decreaseCounter() {
        if (counter > 0) {
            counter--;
            recalculate();
        }
    }

    //Recalculate the total price based on the current quantity
    public void recalculate() {
        price = product.getPrice().multiply(new BigDecimal(counter));
    }

    //Checks if the quantity of the product in the cart is zero
    public boolean hasZeroProducts() {
        return counter == 0;
    }
}
