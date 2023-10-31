package com.example.demo.domain.user.dto;

import com.example.demo.domain.user.dto.UserDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDTOTest {

    @Test
    public void userDTOInitializationTest() {
        // Arrange
        String email = "test@example.com";

        // Act
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);

        // Assert
        assertEquals(email, userDTO.getEmail());
    }
}
