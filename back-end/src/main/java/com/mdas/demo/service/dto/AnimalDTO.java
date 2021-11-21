package com.mdas.demo.service.dto;

import com.mdas.demo.model.AnimalModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AnimalDTO {

    private String nume;
    private String tip;
    private String rasa;
    private int varsta;
    private boolean adoptionStatus;

    public AnimalDTO(AnimalModel model){
        this.nume = model.getNume();
        this.tip = model.getTip();
        this.rasa = model.getRasa();
        this.varsta = model.getVarsta();
        this.adoptionStatus = model.getAdoptionStatus();
    }

}
