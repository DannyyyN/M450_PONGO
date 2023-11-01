package com.example.demo.domain.user;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UserServiceImplTest {

    @Test
    void loadUserByUsernameTest() {
        UserServiceImpl userService = mock(UserServiceImpl.class);

        userService.loadUserByUsername("test@example.com");

        verify(userService).loadUserByUsername("test@example.com");
    }
}
