package com.mdas.demo.controller;

import com.mdas.demo.model.UserModel;
import com.mdas.demo.service.UserService;
import com.mdas.demo.service.dto.UserDTO;
import com.mdas.demo.service.dto.AuthDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create")
    public HttpStatus createUser(@RequestBody UserModel userBody) {
        userService.addUser(userBody);
        return HttpStatus.CREATED;
    }

    @PostMapping(value = "/login")
    public UserDTO login(@RequestBody AuthDTO auth) {
         UserDTO userDTO = userService.login(auth.getEmail(), auth.getPassword());
         return userDTO;
    }

}
