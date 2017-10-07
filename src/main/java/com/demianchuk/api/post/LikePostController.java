package com.demianchuk.api.post;

import com.demianchuk.api.Response;
import com.demianchuk.models.Post;
import com.demianchuk.presenters.PostPresenter;
import com.demianchuk.service.AuthenticationService;
import com.demianchuk.service.post.LikePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class LikePostController {

    @Autowired
    private LikePostService likePostService;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/posts/{postId}/like", method = RequestMethod.PATCH)
    public Response<PostPresenter> likePost(@RequestParam("session") UUID session, @PathVariable("postId") long postId) {
        return authenticationService.authenticate(session).map(userSession -> {
            Optional<Post> postOpt = likePostService.like(userSession.getUser(), postId);
            if(postOpt.isPresent()) {
                return new Response<>(new PostPresenter(postOpt.get()));
            }
            return new Response<PostPresenter>("Post not found");
        }).orElseGet(new Response<PostPresenter>()::withUserNotAuthorized);

    }
}
