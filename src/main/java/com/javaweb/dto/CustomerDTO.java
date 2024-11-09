package com.javaweb.dto;

import com.javaweb.repository.entity.UserAccountEntity;

import javax.persistence.*;

public class CustomerDTO {

    private Long id;
    private UserAccountEntity userAccount;
    private String name;
    private String phoneNumber;
    private String email;

    public Long getId() {
        return id;
    }

    public UserAccountEntity getUserAccount() {
        return userAccount;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserAccount(UserAccountEntity userAccount) {
        this.userAccount = userAccount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
