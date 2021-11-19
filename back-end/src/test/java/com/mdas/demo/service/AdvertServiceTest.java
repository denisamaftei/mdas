package com.mdas.demo.service;

import com.mdas.demo.exception.UserNotFoundException;
import com.mdas.demo.model.AdvertModel;
import com.mdas.demo.model.UserModel;
import com.mdas.demo.repository.AdvertRepository;
import com.mdas.demo.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AdvertServiceTest {
    @Mock
    private AdvertRepository advertRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private AdvertService advertService;

    @BeforeEach
    private void init() {

    }

    @Test
    void getAllAdverts() {
        Mockito.when(advertRepository.findAll()).thenReturn(mockedAdvertList());
        assertThat(advertService.getAllAdverts()).hasSize(3);
    }

    @Test
    void getAllAdvertsByUser() {
        Mockito.when(userRepository.findById(any())).thenReturn(mockedUser());
        assertThat(advertService.getAllAdvertsByUserId(1L)).hasSize(3);
    }

    @Test
    void addAdvertByUser() {
        Mockito.when(userRepository.findById(any())).thenReturn(mockedUser());
        advertService.addAdvertByUser(1L, getMockedAdvert());
        verify(userRepository, atLeastOnce()).findById(mockedUser().get().getId());
        verify(userRepository, atLeastOnce()).save(Mockito.any());
    }

    @Test
    void addAdvertByUser_exception() {
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.empty());
        Exception exception = Assertions.assertThrows(UserNotFoundException.class, () -> {
            advertService.addAdvertByUser(1L, getMockedAdvert());
        });

        assertEquals(exception.getClass(), UserNotFoundException.class);
    }

    private Optional<UserModel> mockedUser() {
        UserModel userModel = new UserModel(1L, "Iarina Cristea", "cristeaiarina03@gmail.com", "0756039030", "IarinaCriste@10", (List<AdvertModel>) mockedAdvertList());
        return Optional.of(userModel);
    }

    private Iterable<AdvertModel> mockedAdvertList() {
        return new ArrayList<>(Arrays.asList(getMockedAdvert(), getMockedAdvert(), getMockedAdvert()));
    }

    private AdvertModel getMockedAdvert() {
        return new AdvertModel(1L, "title", AdvertModel.AdvertType.ADOPT, "description","location", LocalDateTime.now());
    }

}