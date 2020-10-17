# CodeFellowship App

## Purpose
This is a Spring app that allows multiple codefellow users to view blog posts by other users, follow users and add posts

## How to start the app
1. Clone the [repo](https://github.com/vijayetar/Java_codefellowship.git) to a location in your directory
2. cd into the repo
```
cd Java_codefellowship
``` 
3. Check the application.properties and alter the name of the database and password to local server.  If database does not exist then create datebase in the psql.
```
spring.datasource.url=jdbc:postgresql://localhost:5432/codefellowship
spring.datasource.username=vijayetar
spring.datasource.password=password
#spring.jpa.hibernate.ddl-auto=create
spring.jpa.hibernate.ddl-auto=update
```
4. And then type the command to build the app and run it
```
 ./gradlew bootRun
 ```
5. Open the web app on localhost:8080 on your browser

 ## Routes 
 1. Home routes "/", "/login" for returning user and "/newUser" for registration 
 2. When a user logs in or newUser registers, they are directed to the "/myprofile" page
 3. Once logged in, user can access profile and posts of other using "/user/{id}"
 4. User can logout any time.