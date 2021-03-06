package com.vijayetar.Codefellowship.models.posts;

import com.vijayetar.Codefellowship.models.user.ApplicationUser;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    public
    ApplicationUser applicationUser;


    String body;
    Date createdAt;

    public Post() {
    }

    public Post(String body) {
        this.body = body;
        this.createdAt = new Date(Calendar.getInstance().getTime().getTime());

    }
    public Post(ApplicationUser applicationUser, String body){
        this.body = body;
        this.createdAt = new Date(Calendar.getInstance().getTime().getTime());
    }

    public String getBody() {
        return body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
