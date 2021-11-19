package com.mdas.demo.controller;

import com.mdas.demo.model.AdvertModel;
import com.mdas.demo.service.AdvertService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "advert")
public class AdvertController {
    private final AdvertService advertService;

    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @PostMapping(value = "/create/{userId}")
    public void addAdvertByUser(@PathVariable Long userId, @RequestBody AdvertModel advertModel) {
        advertService.addAdvertByUser(userId, advertModel);
    }

    @GetMapping(value = "/all")
    public List<AdvertModel> getAllAdverts() {
        return advertService.getAllAdverts();
    }

    @GetMapping(value = "/{userId}")
    public List<AdvertModel> getAllAdvertsByUser(@PathVariable Long userId) {
        return advertService.getAllAdvertsByUserId(userId);
    }

    //getByType
    @GetMapping(value = "/{type}")
    public List<AdvertModel> getAdvertsByType(@PathVariable String type){
        Optional<AdvertModel.AdvertType> advertTypeOptional = AdvertModel.AdvertType.fromString(type);
        return advertTypeOptional.isPresent() ? advertService.getByType(advertTypeOptional.get()) : Collections.emptyList();
    }

    //add/remove to/from favorite
    @PostMapping(value = "/addToFavorites/{userId}/{advertId}")
    public HttpStatus addToFavorites(@PathVariable Long userId, @PathVariable  Long advertId) {
        advertService.addOrRemoveFromFavoriteAdverts(true ,userId, advertId);
        return HttpStatus.OK;
    }

    @PostMapping(value = "/removeFromFavorites/{userId}/{advertId}")
    public HttpStatus removeFromFavorites(@PathVariable Long userId, @PathVariable Long advertId) {
        advertService.addOrRemoveFromFavoriteAdverts(false ,userId, advertId);
        return HttpStatus.OK;
    }

}
