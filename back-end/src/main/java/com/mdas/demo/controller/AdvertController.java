package com.mdas.demo.controller;

import com.mdas.demo.model.AdvertModel;
import com.mdas.demo.service.AdvertService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdvertController {
    private final AdvertService advertService;

    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @PostMapping
    public void addAdvertByUser(@RequestParam Long idUser, @RequestBody AdvertModel advertModel) {
        advertService.addAdvertByUser(idUser, advertModel);
    }

    @GetMapping
    public List<AdvertModel> getAllAdverts() {
        return advertService.getAllAdverts();
    }

    @GetMapping
    public List<AdvertModel> getAllAdvertsByUser(@RequestParam Long userId) {
        return advertService.getAllAdvertsByUserId(userId);
    }

}
