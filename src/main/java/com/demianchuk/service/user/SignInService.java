package com.demianchuk.service.user;

import com.demianchuk.models.User;
import com.demianchuk.models.UserSession;
import com.demianchuk.service.repositories.UserRepository;
import com.demianchuk.service.repositories.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class SignInService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSessionRepository userSessionRepository;

    public Optional<UserSession> signIn(String email, String password) {

        User user = userRepository.findByEmailAndPassword(email, password);
        if(user != null) {
            UserSession us = new UserSession(UUID.randomUUID(), user, new Date());
            userSessionRepository.save(us);
            return Optional.of(us);
        }

        return Optional.empty();
    }
}
