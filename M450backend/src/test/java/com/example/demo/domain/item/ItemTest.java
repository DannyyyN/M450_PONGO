package com.example.demo.domain.item;

import com.example.demo.domain.item.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void itemInitializationTest() {
        // Arrange
        String name = "TestItem";
        Float price = 10.0f;

        // Act
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);

        // Assert
        assertEquals(name, item.getName());
        assertEquals(price, item.getPrice());
    }
}
