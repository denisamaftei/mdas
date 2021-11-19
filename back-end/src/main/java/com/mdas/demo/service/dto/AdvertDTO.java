package com.mdas.demo.service.dto;

import com.mdas.demo.model.AdvertModel;
import com.mdas.demo.model.AnimalModel;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdvertDTO {

    private String title;
    private String type;
    private String description;
    private String location;
    private LocalDateTime postTime;

    public AdvertDTO(AdvertModel model){
        this.title = model.getTitle();
        this.type = model.getTitle();
        this.description = model.getDescription();
        this.location = model.getLocation();
        this.postTime = model.getPostTime();
    }


}
