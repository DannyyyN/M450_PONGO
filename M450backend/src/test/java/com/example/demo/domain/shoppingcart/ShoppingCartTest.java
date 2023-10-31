package com.example.demo.domain.shoppingcart;

import com.example.demo.domain.shoppingcart.ShoppingCart;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShoppingCartTest {

    @Test
    public void shoppingCartInitializationTest() {
        // Arrange & Act
        ShoppingCart shoppingCart = new ShoppingCart();

        // Assert
        assertNotNull(shoppingCart.getCartItems());
    }
}
