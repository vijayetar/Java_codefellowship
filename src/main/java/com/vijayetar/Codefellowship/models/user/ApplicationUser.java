package com.vijayetar.Codefellowship.models.user;

import com.vijayetar.Codefellowship.models.posts.Post;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
public class ApplicationUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public String bio;
    public String email;

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

    // ------------this is to connect the posts to each user ------------
    @OneToMany(mappedBy = "applicationUser", cascade = CascadeType.ALL)
    public List<Post> posts = new ArrayList<Post>();

    // --------- this is to connect users to other user they can follow and be followed ---------------

    @ManyToMany(cascade = CascadeType.REMOVE)
    // we want this not to delete the other user if one gets deleted
    @JoinTable(
            name="UsersFollowingEachOther",
            joinColumns = { @JoinColumn(name="userFollowsWhom")},
            inverseJoinColumns = {@JoinColumn(name="userFollowedByWhom")}
    )

    public Set<ApplicationUser> usersIFollow = new HashSet<>();
    @ManyToMany(mappedBy = "usersIFollow")
    public Set<ApplicationUser> usersWhoFollowMe = new HashSet<>();


// -------------   getters and setters   --------------------
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

    public List<Post> getPosts() {
        return posts;
    }
//----------------- setting authentication -------------------------
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
