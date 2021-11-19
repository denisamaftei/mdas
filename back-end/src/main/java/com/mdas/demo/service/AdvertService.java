package com.mdas.demo.service;

import com.mdas.demo.exception.UserNotFoundException;
import com.mdas.demo.model.AdvertModel;
import com.mdas.demo.model.UserModel;
import com.mdas.demo.repository.AdvertRepository;
import com.mdas.demo.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AdvertService {
    private final AdvertRepository advertRepository;
    private final UserRepository userRepository;


    public AdvertService(AdvertRepository advertRepository, UserRepository userRepository) {
        this.advertRepository = advertRepository;
        this.userRepository = userRepository;
    }

    public List<AdvertModel> getAllAdverts() {
        List<AdvertModel> advertModelList = new ArrayList<>();
        advertRepository.findAll().forEach(advertModelList::add);
        return advertModelList;
    }

    @SneakyThrows
    public List<AdvertModel> getAllAdvertsByUserId(Long userId) {
        UserModel userModel = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return userModel.getAdvertList();
    }

    @SneakyThrows
    public void addAdvertByUser(Long idUser, AdvertModel advertModel) {
        UserModel userModel = userRepository.findById(idUser).orElseThrow(UserNotFoundException::new);
        userModel.getAdvertList().add(advertModel);
        userRepository.save(userModel);
    }
}