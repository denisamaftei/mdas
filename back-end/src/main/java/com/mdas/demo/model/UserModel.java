package com.mdas.demo.model;

import com.mdas.demo.exception.ValidateUserException;
import com.mdas.demo.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    @OneToMany
    private List<AdvertModel> advertList;


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
}
