package com.example.demo.domain.user;

import com.example.demo.domain.user.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void userInitializationTest() {
        // Arrange
        String email = "test@example.com";

        // Act
        User user = new User();
        user.setEmail(email);

        // Assert
        assertEquals(email, user.getEmail());
    }
}
