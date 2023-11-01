package com.example.demo.domain.item;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ItemServiceImplTest {

    @Test
    void findAllItemsTest() {
        ItemServiceImpl itemService = mock(ItemServiceImpl.class);

        itemService.findAll(0, 10, "name", true);

        verify(itemService).findAll(0, 10, "name", true);
    }
}
