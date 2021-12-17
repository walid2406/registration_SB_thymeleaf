package com.example.springbootregistrationlogin.service;

import com.example.springbootregistrationlogin.model.Role;
import com.example.springbootregistrationlogin.model.User;
import com.example.springbootregistrationlogin.repositry.UserRepositry;
import com.example.springbootregistrationlogin.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepositry userRepositry;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserRepositry userRepositry) {
        super();
        this.userRepositry = userRepositry;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user= new User(registrationDto.getFirstname(),registrationDto.getLastName(),
                registrationDto.getEmail(),registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
        return userRepositry.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Todo auto-generated method stub
        return null;
    }
}
