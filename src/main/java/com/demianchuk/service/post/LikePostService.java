package com.demianchuk.service.post;

import com.demianchuk.models.Post;
import com.demianchuk.models.User;
import com.demianchuk.service.records.UserPostLike;
import com.demianchuk.service.repositories.PostRepository;
import com.demianchuk.service.repositories.UserPostLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface LikePostService {
    Optional<Post> like(User u, long postId);
}

@Service
class LikePostServiceImpl implements LikePostService {

    @Autowired
    private UserPostLikeRepository userPostLikeRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Optional<Post> like(User u, long postId) {
        UserPostLike byUserAndPostId = userPostLikeRepository.getByUserAndPostId(u.getEmail(), postId);
        if(byUserAndPostId == null) {
            userPostLikeRepository.save(new UserPostLike(u.getEmail(), postId));
        }

        return Optional.ofNullable(postRepository.findOne(postId));
    }
}


