package com.mdas.demo.repository;

import com.mdas.demo.model.AdvertModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertRepository extends CrudRepository<AdvertModel, Long> {

    List<AdvertModel> findAllByType(AdvertModel.AdvertType type);

}
