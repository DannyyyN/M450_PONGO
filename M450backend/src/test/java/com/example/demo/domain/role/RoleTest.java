package com.example.demo.domain.role;

import com.example.demo.domain.role.Role;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleTest {

    @Test
    public void roleInitializationTest() {
        // Arrange
        String name = "TestRole";

        // Act
        Role role = new Role();
        role.setName(name);

        // Assert
        assertEquals(name, role.getName());
    }
}
