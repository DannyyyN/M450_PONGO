package com.example.demo.domain.item;

import com.example.demo.domain.item.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ItemServiceImplTest {

    @Test
    public void findAllItemsTest() {
        // Arrange
        ItemServiceImpl itemService = mock(ItemServiceImpl.class);

        // Act
        itemService.findAll(0, 10, "name", true);

        // Assert
        verify(itemService).findAll(0, 10, "name", true);
    }
}
