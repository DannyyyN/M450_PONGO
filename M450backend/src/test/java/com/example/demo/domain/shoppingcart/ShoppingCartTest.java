package com.example.demo.domain.shoppingcart;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ShoppingCartTest {

    @Test
    void shoppingCartInitializationTest() {
        ShoppingCart shoppingCart = new ShoppingCart();

        assertNotNull(shoppingCart.getCartItems());
    }
}
