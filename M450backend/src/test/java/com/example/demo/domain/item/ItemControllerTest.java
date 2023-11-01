package com.example.demo.domain.item;

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
class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    private List<Item> items;

    @BeforeEach
    public void setUp() {
        items = new ArrayList<>();

        Item item1 = new Item();
        item1.setId(UUID.randomUUID());
        item1.setName("Item 1");
        item1.setPictureURL("picture_url_1");
        item1.setDescription("Description 1");
        item1.setPrice(100.0F);
        item1.setUser(new User());

        Item item2 = new Item();
        item2.setId(UUID.randomUUID());
        item2.setName("Item 2");
        item2.setPictureURL("picture_url_2");
        item2.setDescription("Description 2");
        item2.setPrice(200.0F);
        item2.setUser(new User());

        items.add(item1);
        items.add(item2);
    }

    @Test
    void testGetAllItems() {
        Mockito.when(itemService.findAll(1, 10, "name", true)).thenReturn(items);
        ResponseEntity<List<Item>> response = itemController.getAllItems(10, 1, "name", true);

        assert(response.getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    void testGetItemById() {
        UUID itemId = items.get(0).getId();
        Mockito.when(itemService.findById(itemId)).thenReturn(items.get(0));
        ResponseEntity<Item> response = itemController.getItemById(itemId);

        assert(response.getStatusCode().equals(HttpStatus.OK));

    }

    @Test
    void testCreateItem() {
        Item newItem = new Item();
        newItem.setName("New Item");
        newItem.setPictureURL("new_picture_url");
        newItem.setDescription("New item description");
        newItem.setPrice(150.0F);

        Mockito.when(itemService.save(newItem)).thenReturn(newItem);
        ResponseEntity<Item> response = itemController.createItem(newItem);

        assert(response.getStatusCode().equals(HttpStatus.CREATED));
    }

    @Test
    void testUpdateItem() {
        UUID itemId = items.get(0).getId();
        Item updatedItem = new Item();
        updatedItem.setName("Updated Item");
        updatedItem.setPictureURL("updated_picture_url");
        updatedItem.setDescription("Updated item description");
        updatedItem.setPrice(250.0F);

        Mockito.when(itemService.updateById(itemId, updatedItem)).thenReturn(updatedItem);
        ResponseEntity<Item> response = itemController.updateItem(itemId, updatedItem);

        assert(response.getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    void testDeleteItem() {
        UUID itemId = items.get(0).getId();
        ResponseEntity<Void> response = itemController.deleteItem(itemId);

        assert(response.getStatusCode().equals(HttpStatus.NO_CONTENT));

        Mockito.verify(itemService).deleteById(itemId);
    }
}
