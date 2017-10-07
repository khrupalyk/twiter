package com.demianchuk.api.post;

import com.demianchuk.api.Response;
import com.demianchuk.models.Post;
import com.demianchuk.presenters.PostPresenter;
import com.demianchuk.service.AuthenticationService;
import com.demianchuk.service.post.CreatePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CreatePostController {

    @Autowired
    public CreatePostService createPostService;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public @ResponseBody Response<PostPresenter> createPost(@RequestBody Request request, @RequestParam("session") UUID session){
        return authenticationService.authenticate(session).map(userSession -> {
            Post p = createPostService.create(request.message, userSession.getUser());
            return new Response<>(new PostPresenter(p));
        }).orElseGet(new Response<PostPresenter>()::withUserNotAuthorized);
    }

    static class Request {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
