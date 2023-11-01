package com.example.demo.domain.item;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    @Test
    void itemInitializationTest() {
        String name = "TestItem";
        Float price = 10.0f;

        Item item = new Item();
        item.setName(name);
        item.setPrice(price);

        assertEquals(name, item.getName());
        assertEquals(price, item.getPrice());
    }
}
