package com.demianchuk.service.records;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserPostLike  {

    @Id
    @GeneratedValue
    private long id;

    private String user;
    private long postId;

    public UserPostLike(String user, long postId) {
        this.user = user;
        this.postId = postId;
    }

    public UserPostLike(){}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }
}
