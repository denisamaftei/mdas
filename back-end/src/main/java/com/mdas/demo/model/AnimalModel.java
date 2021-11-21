package com.mdas.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class AnimalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nume;
    private String tip;
    private String rasa;
    private int varsta;
    private boolean adoptionStatus;


    //NEEDED FOR JPA
    protected AnimalModel() {
    }

    public AnimalModel(Long id, String nume, String tip, String rasa, int varsta) {
        this.id = id;
        this.nume = nume;
        this.tip = tip;
        this.rasa = rasa;
        this.varsta = varsta;
        this.adoptionStatus = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AnimalModel that = (AnimalModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public boolean getAdoptionStatus() {
        return this.adoptionStatus;
    }
}
