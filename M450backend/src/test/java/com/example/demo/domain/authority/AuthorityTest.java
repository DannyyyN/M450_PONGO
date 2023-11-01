package com.example.demo.domain.authority;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorityTest {

    @Test
    void authorityInitializationTest() {
        String name = "TestAuthority";

        Authority authority = new Authority();
        authority.setName(name);

        assertEquals(name, authority.getName());
    }
}
