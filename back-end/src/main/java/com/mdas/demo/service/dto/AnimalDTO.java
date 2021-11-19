package com.mdas.demo.service.dto;

import com.mdas.demo.model.AnimalModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class AnimalDTO {

    private String nume;
    private String tip;
    private String rasa;
    private int varsta;

    public AnimalDTO(AnimalModel model){
        this.nume = model.getNume();
        this.tip = model.getTip();
        this.rasa = model.getRasa();
        this.varsta = model.getVarsta();
    }

}
