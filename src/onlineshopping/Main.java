package onlineshopping;

import onlineshopping.administration.Account;
import onlineshopping.administration.UserData;
import onlineshopping.cart.Discount;
import onlineshopping.cart.ShoppingCart;
import onlineshopping.products.DigitalProduct;
import onlineshopping.products.Product;

import java.math.BigDecimal;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Pen", new BigDecimal("2.20"), 1);
        Product product2 = new Product("Ball", new BigDecimal("10"), 3);
        Product product3 = new Product("Pants", new BigDecimal("50"), 0);
        Product product4 = new Product("Watch", new BigDecimal("300"), 4);
        DigitalProduct product5 = new DigitalProduct("E-Book", new BigDecimal("10"), 5, "https:///download.e-book.com");

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addProduct(product5);
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product1);

        shoppingCart.showCart(shoppingCart);

        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product3);
        shoppingCart.addProduct(product2);

        shoppingCart.showCart(shoppingCart);

        shoppingCart.removeProduct(product1);

        shoppingCart.showCart(shoppingCart);

        Discount discount = new Discount();
        discount.applyDiscount(shoppingCart, "DISCOUNT10");
        shoppingCart.showCart(shoppingCart);


        Scanner scanner = new Scanner(System.in);
        UserData userData = new UserData();
        Account account = new Account(userData);
        account.registerUser(scanner);
        account.loginUser(scanner);

        account.registerUser(scanner);
        account.loginUser(scanner);

        scanner.close();


    }
}
