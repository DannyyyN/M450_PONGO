package com.example.demo.domain.role.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleDTOTest {

    @Test
    void roleDTOInitializationTest() {
        String name = "TestRole";

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(name);

        assertEquals(name, roleDTO.getName());
    }
}
