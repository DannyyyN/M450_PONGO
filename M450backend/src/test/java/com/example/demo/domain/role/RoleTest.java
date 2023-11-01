package com.example.demo.domain.role;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleTest {

    @Test
    void roleInitializationTest() {
        String name = "TestRole";

        Role role = new Role();
        role.setName(name);

        assertEquals(name, role.getName());
    }
}
