package com.mdas.demo.repository;

import com.mdas.demo.model.AnimalModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<AnimalModel, Long> {

    List<AnimalModel> findAll();

    List<AnimalModel> findAllToAdopt();
}
