package com.example.demo.domain.authority.dto;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorityDTOTest {

    @Test
    void authorityDTOInitializationTest() {
        String name = "TestAuthority";
        UUID id = UUID.randomUUID();

        AuthorityDTO authorityDTO = new AuthorityDTO(id, name);

        assertEquals(name, authorityDTO.getName());
        assertEquals(id, authorityDTO.getId());
    }
}
