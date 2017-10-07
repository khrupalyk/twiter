package com.demianchuk.service;

import com.demianchuk.models.UserSession;
import com.demianchuk.service.repositories.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationService {

    @Autowired
    private UserSessionRepository userSessionRepository;

    public Optional<UserSession> authenticate(UUID session) {
        return Optional.ofNullable(userSessionRepository.findOne(session));
    }
}
