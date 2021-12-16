package com.example.springbootregistrationlogin.service;

import com.example.springbootregistrationlogin.model.User;
import com.example.springbootregistrationlogin.web.dto.UserRegistrationDto;

public interface UserService {


    User save(UserRegistrationDto registrationDto);
}
