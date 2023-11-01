package com.example.demo.domain.cartitem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CartItemTest {

    @Test
    void cartItemInitializationTest() {
        Integer quantity = 5;

        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);

        assertEquals(quantity, cartItem.getQuantity());
    }
}
