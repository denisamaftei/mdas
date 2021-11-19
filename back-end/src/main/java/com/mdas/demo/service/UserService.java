package com.mdas.demo.service;

import com.mdas.demo.exception.ValidateUserException;
import com.mdas.demo.model.UserModel;
import com.mdas.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.mdas.demo.service.dto.UserDTO;

import javax.xml.stream.events.DTD;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO addUser(UserModel userModel) {
        userModel.validate();
        userRepository.save(userModel);
        return new UserDTO(userModel);
    }


    public UserDTO login(String email, String password) {
        Optional<UserModel> userModel = userRepository.findByEmailAndPassword(email,password);
        return userModel.isPresent() ? new UserDTO(userModel.get()) : null;
    }
}
