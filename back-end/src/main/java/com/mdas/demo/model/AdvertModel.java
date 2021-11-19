package com.mdas.demo.model;


import lombok.*;
import org.apache.tomcat.jni.Local;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;


@Getter
@Setter
@ToString
@Entity
@Table(name = "adverts")
public class AdvertModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private AdvertType type;
    private String description;
    @OneToOne
    private AnimalModel animal;
    private String location;
    private LocalDateTime postTime;
    private float price;

    public AdvertModel(Long id, String title, AdvertType adopt, String description, String location, LocalDateTime postTime) {
        this.id = id;
        this.title = title;
        this.type = adopt;
        this.description = description;
        this.location = location;
        this.postTime = postTime;
    }

    protected AdvertModel() {

    }

    public enum AdvertType {
        ADOPT,
        CARE;

        public static Optional<AdvertType> fromString(String type){
            return Arrays.stream(AdvertType.values())
                    .sequential()
                    .filter(value -> value.name().equals(type))
                    .findAny();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AdvertModel that = (AdvertModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
