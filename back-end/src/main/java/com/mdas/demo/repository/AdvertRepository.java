package com.mdas.demo.repository;

import com.mdas.demo.model.AdvertModel;
import org.springframework.data.repository.CrudRepository;

public interface AdvertRepository extends CrudRepository<AdvertModel, Long> {
}
