package com.example.demo.domain.shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ShoppingCartServiceImplTest {

    @Test
    void getShoppingCartByIdTest() {
        ShoppingCartServiceImpl shoppingCartService = mock(ShoppingCartServiceImpl.class);
        UUID testId = UUID.randomUUID();

        shoppingCartService.getShoppingCartById(testId);

        verify(shoppingCartService).getShoppingCartById(testId);
    }
}
