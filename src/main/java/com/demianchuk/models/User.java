package com.demianchuk.models;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class User {
    @Id
    private String email;
    private String password;
    private String firstName;

//    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Post> posts;

    public User(String email, String password, String firstName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//    @Override
//    public String toString() {
//        return "User { email: " + email + ", posts: { " +
//                posts.stream().map(e -> e.toString()).collect(Collectors.joining(", "))
//                + "} }";
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(Set<Post> posts) {
//        this.posts = posts;
//    }
}
