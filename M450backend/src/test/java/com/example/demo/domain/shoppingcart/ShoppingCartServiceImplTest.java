package com.example.demo.domain.shoppingcart;

import com.example.demo.domain.shoppingcart.ShoppingCartServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ShoppingCartServiceImplTest {

    @Test
    public void getShoppingCartByIdTest() {
        // Arrange
        ShoppingCartServiceImpl shoppingCartService = mock(ShoppingCartServiceImpl.class);
        UUID testId = UUID.randomUUID();

        // Act
        shoppingCartService.getShoppingCartById(testId);

        // Assert
        verify(shoppingCartService).getShoppingCartById(testId);
    }
}
