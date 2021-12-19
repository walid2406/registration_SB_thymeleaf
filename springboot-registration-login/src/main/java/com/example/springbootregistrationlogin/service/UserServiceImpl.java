package com.example.springbootregistrationlogin.service;

import com.example.springbootregistrationlogin.model.Role;
import com.example.springbootregistrationlogin.model.User;
import com.example.springbootregistrationlogin.repositry.UserRepositry;
import com.example.springbootregistrationlogin.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


   @Autowired
    private UserRepositry userRepositry;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserRepositry userRepositry) {
        super();
        this.userRepositry = userRepositry;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user= new User(registrationDto.getFirstname(),registrationDto.getLastName(),
                registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
        return userRepositry.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //retourne un user from DB
        User user = userRepositry.findByEmail(username);
        if (user == null)
        {
            throw new UsernameNotFoundException("Invalid user name or password");
        }

        //Todo auto-generated method stub
        //les details sont collecte du couche securite
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }
//a cortiquer pour bien comprendre ici g fait que traitement de texte
    //ici pour collecter les identificateur de la couche securite et la passer au userDetail repositry
    //la methode nommee mapRolesToAuthorities
    private Collection <? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){

       return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }
}
