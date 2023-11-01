package com.example.demo.domain.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void userInitializationTest() {
        String email = "test@example.com";
        User user = new User();
        user.setEmail(email);

        assertEquals(email, user.getEmail());
    }
}
