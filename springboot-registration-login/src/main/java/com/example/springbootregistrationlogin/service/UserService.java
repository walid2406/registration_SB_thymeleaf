package com.example.springbootregistrationlogin.service;

import com.example.springbootregistrationlogin.model.User;
import com.example.springbootregistrationlogin.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {


    User save(UserRegistrationDto registrationDto);
}
