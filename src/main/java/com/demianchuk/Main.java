package com.demianchuk;

import com.demianchuk.models.User;
import com.demianchuk.models.UserSession;
import com.demianchuk.service.post.CreatePostService;
import com.demianchuk.service.repositories.UserSessionRepository;
import com.demianchuk.service.user.CreateUserService;
import com.demianchuk.service.user.SignInService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(CreateUserService repository, CreatePostService postService, UserSessionRepository signInService) {
        return (args) -> {
            User u = repository.create("Jack", "pass","Bauer");
            repository.create("Chloe","pass", "O'Brian");
            repository.create("Kim", "pass","Bauer");

            signInService.save(new UserSession(UUID.fromString("f6e848e7-abde-4115-8149-b84279ceb257"), u, new Date()));

            postService.create("message1", u);
        };
    }
}
