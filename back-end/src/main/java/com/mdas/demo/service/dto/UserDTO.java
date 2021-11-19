package com.mdas.demo.service.dto;

import com.mdas.demo.model.AdvertModel;
import com.mdas.demo.model.UserModel;

import java.util.List;
import java.util.Objects;

public class UserDTO {
    private String name;
    private String email;
    private String phone;
    private List<AdvertModel> advertList;

    public UserDTO(UserModel model){
        this.name = model.getName();
        this.email = model.getEmail();
        this.phone = model.getPhone();
        this.advertList = model.getAdvertList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(name, userDTO.name) && Objects.equals(email, userDTO.email) && Objects.equals(phone, userDTO.phone) && Objects.equals(advertList, userDTO.advertList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phone, advertList);
    }
}
