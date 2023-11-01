package com.example.demo.domain.user;

import com.example.demo.domain.user.*;
import com.example.demo.domain.user.dto.UserDTO;
import com.example.demo.domain.user.dto.UserMapper;
import com.example.demo.domain.user.dto.UserRegisterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserController userController;

    private List<User> users;

    @BeforeEach
    public void setUp() {
        users = new ArrayList<>();

        User user1 = new User();
        user1.setId(UUID.randomUUID());
        user1.setFirstName("Bomber");
        user1.setLastName("Bamber");
        user1.setEmail("bimbo@bumbo.com");
        user1.setPassword("bembo");

        User user2 = new User();
        user2.setId(UUID.randomUUID());
        user2.setFirstName("Brimba");
        user2.setLastName("Bromba");
        user2.setEmail("bromba@brimba.com");
        user2.setPassword("bimbo");

        users.add(user1);
        users.add(user2);
    }

    @Test
     void testRetrieveById() {
        UUID userId = users.get(0).getId();
        Mockito.when(userService.findById(userId)).thenReturn(users.get(0));

        UserDTO userDTO = new UserDTO();
        Mockito.when(userMapper.toDTO(users.get(0))).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.retrieveById(userId);

        assert(response.getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    void testRetrieveAll() {
        Mockito.when(userService.findAll()).thenReturn(users);

        List<UserDTO> userDTOs = new ArrayList<>();
        Mockito.when(userMapper.toDTOs(users)).thenReturn(userDTOs);

        ResponseEntity<List<UserDTO> > response = userController.retrieveAll();

        assert(response.getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    void testRegister() {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        User user = new User();

        Mockito.when(userMapper.fromUserRegisterDTO(userRegisterDTO)).thenReturn(user);
        Mockito.when(userService.register(user)).thenReturn(user);

        UserDTO userDTO = new UserDTO();
        Mockito.when(userMapper.toDTO(user)).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.register(userRegisterDTO);

        assert(response.getStatusCode().equals(HttpStatus.CREATED));
    }

    @Test
    void testRegisterWithoutPassword() {
        UserDTO userDTO = new UserDTO();
        User user = new User();

        Mockito.when(userMapper.fromDTO(userDTO)).thenReturn(user);
        Mockito.when(userService.registerUser(user)).thenReturn(user);

        UserDTO newUserDTO = new UserDTO();
        Mockito.when(userMapper.toDTO(user)).thenReturn(newUserDTO);

        ResponseEntity<UserDTO> response = userController.registerWithoutPassword(userDTO);

        assert(response.getStatusCode().equals(HttpStatus.CREATED));
    }

    @Test
    void testUpdateById() {
        UUID userId = users.get(0).getId();
        UserDTO updatedUserDTO = new UserDTO();
        User updatedUser = new User();

        Mockito.when(userMapper.fromDTO(updatedUserDTO)).thenReturn(updatedUser);
        Mockito.when(userService.updateById(userId, updatedUser)).thenReturn(updatedUser);

        UserDTO newUserDTO = new UserDTO();
        Mockito.when(userMapper.toDTO(updatedUser)).thenReturn(newUserDTO);

        ResponseEntity<UserDTO> response = userController.updateById(userId, updatedUserDTO);

        assert(response.getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    void testDeleteById() {
        UUID userId = users.get(0).getId();
        ResponseEntity<Void> response = userController.deleteById(userId);

        assert(response.getStatusCode().equals(HttpStatus.NO_CONTENT));

        Mockito.verify(userService).deleteById(userId);
    }
}
