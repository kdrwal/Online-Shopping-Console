package onlineshopping.cart;

import onlineshopping.products.DigitalProduct;
import onlineshopping.products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    //Attributes
    private List<Inventory> inventoryList = new ArrayList<>();
    private int counter = 0;
    private BigDecimal sum = BigDecimal.ZERO;

    //Getters
    public List<Inventory> getInventoryList() {
        return inventoryList;
    }


    public int getCounter() {
        return counter;
    }

    public BigDecimal getSum() {
        return sum;
    }

    //Setters
    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    //Methods

    //Adds a product to the shopping cart
    public void addProduct(Product product) {
        boolean notFound = true;

        //Searching for the product in the cart
        for (Inventory eq : inventoryList) {
            if (eq.getProduct().getId() == (product.getId())) {
                notFound = false;
                eq.increaseCounter();
                recalculatePriceAndCounter();
                break;
            }
        }

        //If the product is not found in the cart add new inventory entry
        if (notFound) {
            inventoryList.add(new Inventory(product));
            recalculatePriceAndCounter();
        }
    }

    //Removes a product from the shopping cart
    public void removeProduct(Product product) {
        for (Inventory eq : inventoryList) {
            if (eq.getProduct().getId() == product.getId()) {
                eq.decreaseCounter();
                if (eq.hasZeroProducts()) {
                    inventoryList.remove(eq);
                }
                recalculatePriceAndCounter();
                break;
            }
        }
    }

    //Recalculates the total price and quantity of products
    public void recalculatePriceAndCounter() {
        //Creating temporary variables to calculate tempCounter and tempPrice
        int tempCounter = 0;
        BigDecimal tempPrice = BigDecimal.ZERO;

        //Suming the price and quantity in the loop
        for (Inventory eq : inventoryList) {
            tempCounter += eq.getCounter();
            tempPrice = tempPrice.add(eq.getPrice());
        }

        //Updating the counter and sum
        this.counter = tempCounter;
        this.sum = tempPrice;

    }

    //Displays the contents of the shopping cart
    public void showCart(ShoppingCart cart) {
        //Method that showing what we have in cart
        System.out.println("Quantity of products in shopping cart: " + cart.getCounter());
        System.out.println("Price: " + cart.getSum());
        for (Inventory eq : cart.getInventoryList()) {
            System.out.println("Product: " + eq.getProduct().getName() + ", Quantity: " + eq.getCounter() + ", Price: " + eq.getPrice());
        }
    }
}