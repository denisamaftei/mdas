package com.mdas.demo.service;

import com.mdas.demo.model.UserModel;
import com.mdas.demo.repository.AdvertRepository;
import com.mdas.demo.repository.UserRepository;
import com.mdas.demo.service.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;

    public UserService(UserRepository userRepository, AdvertRepository advertRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
    }

    public UserDTO addUser(UserModel userModel) {
        userModel.validate();
        userRepository.save(userModel);
        return new UserDTO(userModel);
    }


    public UserDTO login(String email, String password) {
        Optional<UserModel> userModel = userRepository.findByEmailAndPassword(email, password);
        return userModel.map(UserDTO::new).orElse(null);
    }


}
