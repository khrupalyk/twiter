package com.demianchuk.models;

import com.demianchuk.service.records.UserPostLike;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;

    private String message;

    @ManyToOne(optional = false)
    private User createdBy;

    private Date createdAt;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "postId")
    private Set<UserPostLike> likes;

    public Post(String message, User createdBy, Date createdAt) {
        this.message = message;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Post() {
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Post { message: " + message + "}";
    }

    public long getLikesCount() {
        return likes != null ? likes.size() : 0;
    }
}
