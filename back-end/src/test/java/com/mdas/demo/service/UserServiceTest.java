package com.mdas.demo.service;

import com.mdas.demo.exception.ValidateUserException;
import com.mdas.demo.model.UserModel;
import com.mdas.demo.repository.UserRepository;
import com.mdas.demo.service.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    private UserModel userModel;

    @BeforeEach
    public void init() {
        userModel = new UserModel(1L, "Iarina Cristea", "cristeaiarina03@gmail.com", "0756039030", "IarinaCriste@10", new ArrayList<>());
    }

    @Test
    void addUser() {
        Mockito.when(userRepository.save(userModel)).thenReturn(userModel);
        Assertions.assertEquals(userService.addUser(userModel), new UserDTO(userModel));
    }

    @Test
    void addUser_validateException_phoneNumber() {
        userModel.setPhone("invalid_phone");
        Exception exception = Assertions.assertThrows(ValidateUserException.class, () -> {
            userService.addUser(userModel);
        });
        String expectedMessage = "Invalid user format.";
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }

    @Test
    void addUser_validateException_email() {
        userModel.setEmail("invalid_email");
        Exception exception = Assertions.assertThrows(ValidateUserException.class, () -> {
            userService.addUser(userModel);
        });
        String expectedMessage = "Invalid user format.";
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }

    @Test
    void addUser_validateException_password() {
        userModel.setEmail("invalid_password");
        Exception exception = Assertions.assertThrows(ValidateUserException.class, () -> {
            userService.addUser(userModel);
        });
        String expectedMessage = "Invalid user format.";
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }

    @Test
    void addUser_validateException_name() {
        userModel.setEmail("invalid_name1");
        Exception exception = Assertions.assertThrows(ValidateUserException.class, () -> {
            userService.addUser(userModel);
        });
        String expectedMessage = "Invalid user format.";
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }

    @Test
    void should_login_if_correct() {
        Mockito.when(userRepository.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword())).thenReturn(Optional.of(userModel));
        UserDTO userDTO = userService.login(userModel.getEmail(), userModel.getPassword());
        Assertions.assertEquals(userDTO, new UserDTO(userModel));
    }

    @Test
    void should_not_find_user_if_wrong() {
        Mockito.when(userRepository.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword())).thenReturn(Optional.empty());
        Assertions.assertNull(userService.login(userModel.getEmail(), userModel.getPassword()));
    }



}