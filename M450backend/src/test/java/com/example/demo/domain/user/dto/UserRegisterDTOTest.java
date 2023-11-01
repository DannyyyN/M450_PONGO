package com.example.demo.domain.user.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRegisterDTOTest {

    @Test
    void userRegisterDTOInitializationTest() {
        String email = "test@example.com";

        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setEmail(email);

        assertEquals(email, userRegisterDTO.getEmail());
    }
}
