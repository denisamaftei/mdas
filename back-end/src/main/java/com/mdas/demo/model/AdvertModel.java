package com.mdas.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AdvertModel {

    private Long id;
    private String title;
    private String type;
    private String description;

}
