package com.example.springbootregistrationlogin.model;

import org.hibernate.engine.profile.Fetch;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Table(name="user",uniqueConstraints =@UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name ="user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(

                    name = "role_id",referencedColumnName = "id"
            )
    )
    private Collection<Role> roles;

    public User() {
    }

    public User(String firstname, String lastName, String email, String password, Collection < Role > roles) {
        super();
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
