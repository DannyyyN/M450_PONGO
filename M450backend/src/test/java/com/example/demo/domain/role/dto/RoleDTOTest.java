package com.example.demo.domain.role.dto;

import com.example.demo.domain.role.dto.RoleDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleDTOTest {

    @Test
    public void roleDTOInitializationTest() {
        // Arrange
        String name = "TestRole";

        // Act
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(name);

        // Assert
        assertEquals(name, roleDTO.getName());
    }
}
