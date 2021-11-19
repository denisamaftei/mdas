package com.mdas.demo.service;

import com.mdas.demo.model.UserModel;
import com.mdas.demo.repository.UserRepository;
import com.mdas.demo.service.dto.UserDTO;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import java.nio.file.AccessDeniedException;
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


    @SneakyThrows
    public UserDTO login(String email, String password) {
        Optional<UserModel> userModel = userRepository.findByEmailAndPassword(email, password);
        return userModel.map(UserDTO::new).orElseThrow(() -> new AccessDeniedException("Access denied"));
    }


}
