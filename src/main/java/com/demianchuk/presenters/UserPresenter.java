package com.demianchuk.presenters;

import com.demianchuk.models.User;

public class UserPresenter {
    private String email;
    private String firstName;

    public UserPresenter(User user) {
        email = user.getEmail();
        firstName = user.getFirstName();
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
}
