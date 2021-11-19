package com.mdas.demo.model;

import com.mdas.demo.exception.ValidateUserException;
import com.mdas.demo.util.Constants;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    @OneToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<AdvertModel> advertList;
    @ManyToMany
    private List<AdvertModel> favoriteAdvertList;

    public UserModel(Long id, String name, String email, String phone, String password, List<AdvertModel> advertList) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.advertList = advertList;
    }


    @SneakyThrows
    public void validate() {
        if(!checkValidName() || !checkValidEmail() || !checkValidPhone() || !checkValidPassword())
            throw new ValidateUserException("Invalid user format.");
    }

    private boolean checkValidPassword() {
        return this.password.matches(Constants.PASSWORD_REGEX);
    }

    private boolean checkValidPhone() {
        return this.phone.matches(Constants.CONTAINS_NUMBER_REGEX);
    }

    private boolean checkValidEmail() {
        return this.email.matches(Constants.EMAIL_REGEX);
    }

    private boolean checkValidName() {
        return !this.name.matches(Constants.CONTAINS_NUMBER_REGEX);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserModel userModel = (UserModel) o;
        return id != null && Objects.equals(id, userModel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    protected UserModel(){

    }
}
