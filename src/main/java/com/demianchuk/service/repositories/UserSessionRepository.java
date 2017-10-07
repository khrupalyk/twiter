package com.demianchuk.service.repositories;

import com.demianchuk.models.UserSession;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserSessionRepository extends CrudRepository<UserSession, UUID> {
}
