package com.example.springbootregistrationlogin.repositry;

import com.example.springbootregistrationlogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends JpaRepository<User,Long> {


}
