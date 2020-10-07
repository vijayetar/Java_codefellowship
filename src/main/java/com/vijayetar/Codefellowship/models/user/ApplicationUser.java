package com.vijayetar.Codefellowship.models.user;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class ApplicationUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    //An ApplicationUser should have a username, password (will be hashed using BCrypt), firstName, lastName, dateOfBirth, bio, and any other fields you think are useful.
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public String bio;
    public String email;

//// this is to connect the posts to each user
//    @OneToMany(mappedBy = "applicationUser", cascade = CascadeType.ALL)
//    public List<BlogPost> blogPosts = new ArrayList<BlogPost>();


    public ApplicationUser(){};
    public ApplicationUser(
            String username,
            String password,
            String firstName,
            String lastName,
            Date dateOfBirth,
            String bio,
            String email
    ){
        this.username = username;
        this.password =  password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password; // TODO: make this return the password
    }

    @Override
    public String getUsername() {
        return username; // TODO: get username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
