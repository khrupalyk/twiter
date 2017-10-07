package com.demianchuk.presenters;

import com.demianchuk.models.Post;

public class PostPresenter {
    private long id;
    private String message;
    private long likesCount;
    private UserPresenter createdBy;

    public PostPresenter(Post post) {
        id = post.getId();
        message = post.getMessage();
        likesCount = post.getLikesCount();
        createdBy = new UserPresenter(post.getCreatedBy());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserPresenter getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserPresenter createdBy) {
        this.createdBy = createdBy;
    }

    public long getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(long likesCount) {
        this.likesCount = likesCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
