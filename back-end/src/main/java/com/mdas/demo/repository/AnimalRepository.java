package com.mdas.demo.repository;

import com.mdas.demo.model.AnimalModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<AnimalModel, Long> {

    List<AnimalModel> findAll();

    List<AnimalModel> findAllToAdopt();
}
