package com.example.demo.domain.cartitem;

import com.example.demo.domain.cartitem.CartItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartItemTest {

    @Test
    public void cartItemInitializationTest() {
        // Arrange
        Integer quantity = 5;

        // Act
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);

        // Assert
        assertEquals(quantity, cartItem.getQuantity());
    }
}
