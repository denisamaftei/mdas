package com.mdas.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class AnimalModel {

    private Long id;
    private String nume;
    private String tip;
    private String rasa;
    private int varsta;
    private String location;
    private LocalDateTime postTime;

}
