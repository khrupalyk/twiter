package com.demianchuk.service.user;

import com.demianchuk.models.User;
import com.demianchuk.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface CreateUserService {
    User create(String email, String password, String firstName);
}

@Service
class CreateUserServiceImpl implements CreateUserService {

    @Autowired
    private UserRepository userRepository;

    public User create(String email, String password, String firstName) {
        User newUser = new User(email, password, firstName);
        userRepository.save(newUser);
        return newUser;
    }
}
