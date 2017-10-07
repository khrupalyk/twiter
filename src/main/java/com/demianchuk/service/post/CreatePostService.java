package com.demianchuk.service.post;

import com.demianchuk.models.Post;
import com.demianchuk.models.User;
import com.demianchuk.service.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreatePostService {

    @Autowired
    private PostRepository postRepository;

    public Post create(String message, User u) {
        Post p = new Post(message, u, new Date());
        postRepository.save(p);
        return p;
    }
}
