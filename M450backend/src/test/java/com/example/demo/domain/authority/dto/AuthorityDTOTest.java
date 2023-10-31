package com.example.demo.domain.authority.dto;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AuthorityDTOTest {
    @Test
    public void authorityDTOInitializationTest() {
        // Arrange
        String name = "TestAuthority";
        UUID id = UUID.randomUUID();

        // Act
        AuthorityDTO authorityDTO = new AuthorityDTO(id, name);

        // Assert
        assertEquals(name, authorityDTO.getName());
        assertEquals(id, authorityDTO.getId());
    }
}
