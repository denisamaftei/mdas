package com.mdas.demo.repository;

import com.mdas.demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    public Optional<UserModel> findByEmailAndPassword(String email, String password);

}
