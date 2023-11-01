package com.example.demo.domain.user.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDTOTest {

    @Test
    void userDTOInitializationTest() {
        String email = "test@example.com";

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);

        assertEquals(email, userDTO.getEmail());
    }
}
