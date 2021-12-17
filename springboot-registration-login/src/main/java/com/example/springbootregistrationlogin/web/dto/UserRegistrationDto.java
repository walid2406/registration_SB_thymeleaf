package com.example.springbootregistrationlogin.web.dto;

import javax.persistence.Column;

public class UserRegistrationDto {



    private String firstname;
    private String lastName;
    private String email;
    private String password;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String firstname, String lastName, String email, String password) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
