package com.example.demo.domain.authority;

import com.example.demo.domain.authority.Authority;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorityTest {

    @Test
    public void authorityInitializationTest() {
        // Arrange
        String name = "TestAuthority";

        // Act
        Authority authority = new Authority();
        authority.setName(name);

        // Assert
        assertEquals(name, authority.getName());
    }
}
