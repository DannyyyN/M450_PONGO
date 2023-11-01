package com.example.demo.domain.shoppingcart;

import com.example.demo.domain.cartitem.CartItem;
import com.example.demo.domain.item.Item;
import com.example.demo.domain.shoppingcart.*;
import com.example.demo.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class ShoppingCartControllerTest {

    @Mock
    private ShoppingCartService shoppingCartService;

    @InjectMocks
    private ShoppingCartController shoppingCartController;

    private ShoppingCart shoppingCart;
    private List<CartItem> cartItems;

    @BeforeEach
    public void setUp() {
        shoppingCart = new ShoppingCart();
        shoppingCart.setId(UUID.randomUUID());
        shoppingCart.setUser(new User());

        cartItems = new ArrayList<>();
        Item item1 = new Item();
        item1.setId(UUID.randomUUID());
        item1.setName("Item 1");
        item1.setPictureURL("picture_url_1");
        item1.setDescription("Description 1");
        item1.setPrice(100.0F);
        item1.setUser(new User());

        cartItems.add(new CartItem(shoppingCart, item1, 2));

        shoppingCart.setCartItems(cartItems);
    }

    @Test
    void testGetShoppingCartById() {
        UUID cartId = shoppingCart.getId();
        Mockito.when(shoppingCartService.getShoppingCartById(cartId)).thenReturn(shoppingCart);
        ResponseEntity<ShoppingCart> response = shoppingCartController.getShoppingCartById(cartId);

        assert(response.getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    void testCreateShoppingCart() {
        ShoppingCart newShoppingCart = new ShoppingCart();
        newShoppingCart.setUser(new User());

        Mockito.when(shoppingCartService.save(newShoppingCart)).thenReturn(newShoppingCart);
        ResponseEntity<ShoppingCart> response = shoppingCartController.createShoppingCart(newShoppingCart);

        assert(response.getStatusCode().equals(HttpStatus.CREATED));
    }

    @Test
    void testAddItemToCart() {
        UUID cartId = shoppingCart.getId();
        UUID itemId = cartItems.get(0).getItem().getId();
        int quantity = 5;

        ResponseEntity<Void> response = shoppingCartController.addItemToCart(cartId, itemId, quantity);

        assert(response.getStatusCode().equals(HttpStatus.OK));

        Mockito.verify(shoppingCartService).addItemToCart(cartId, itemId, quantity);
    }

    @Test
    void testRemoveItemFromCart() {
        UUID cartId = shoppingCart.getId();
        UUID cartItemId = cartItems.get(0).getId();

        ResponseEntity<Void> response = shoppingCartController.removeItemFromCart(cartId, cartItemId);

        assert(response.getStatusCode().equals(HttpStatus.OK));

        Mockito.verify(shoppingCartService).removeItemFromCart(cartId, cartItemId);
    }
}
