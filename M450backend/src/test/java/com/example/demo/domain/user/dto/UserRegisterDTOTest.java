package com.example.demo.domain.user.dto;

import com.example.demo.domain.user.dto.UserRegisterDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRegisterDTOTest {

    @Test
    public void userRegisterDTOInitializationTest() {
        // Arrange
        String email = "test@example.com";

        // Act
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setEmail(email);

        // Assert
        assertEquals(email, userRegisterDTO.getEmail());
    }
}
