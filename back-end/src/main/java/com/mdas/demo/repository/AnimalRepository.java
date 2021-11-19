package com.mdas.demo.repository;

import com.mdas.demo.model.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<AnimalModel, Long> {
}
