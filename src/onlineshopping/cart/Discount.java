package onlineshopping.cart;

import java.math.BigDecimal;

public class Discount {

    //Attributes
    private String discountCode;

    //Methods

    //Applies a discount to the given shopping cart based on the provided discount code
    public void applyDiscount(ShoppingCart cart, String discountCode) {
        if ("DISCOUNT10".equals(discountCode)) {
            //Calculate discount amount (10% of the cart's sum)
            BigDecimal discountPercentage = new BigDecimal("0.10");
            BigDecimal discountAmount = cart.getSum().multiply(discountPercentage);

            //Subtract the discount amount from the cart's total sum
            cart.setSum(cart.getSum().subtract(discountAmount));

            System.out.println("10% Discount. ");
        } else {
            System.out.println("Wrong discount code!");
        }
    }
}
