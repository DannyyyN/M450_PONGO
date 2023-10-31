package com.example.demo.domain.user;

import com.example.demo.domain.user.UserServiceImpl;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserServiceImplTest {

    @Test
    public void loadUserByUsernameTest() {
        // Arrange
        UserServiceImpl userService = mock(UserServiceImpl.class);

        // Act
        userService.loadUserByUsername("test@example.com");

        // Assert
        verify(userService).loadUserByUsername("test@example.com");
    }
}
