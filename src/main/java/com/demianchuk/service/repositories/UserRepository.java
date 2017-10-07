package com.demianchuk.service.repositories;

import com.demianchuk.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findByEmailAndPassword(String email, String password);
}
