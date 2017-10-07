package com.demianchuk.api.post;

import com.demianchuk.api.Response;
import com.demianchuk.models.Post;
import com.demianchuk.presenters.PostPresenter;
import com.demianchuk.service.AuthenticationService;
import com.demianchuk.service.post.FilterPostService;
import org.h2.server.web.PageParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class FilterPostController {

    @Autowired
    private FilterPostService filterPostService;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public Response<List<PostPresenter>> filterPosts(Request request, @RequestParam("session") UUID session){

        return authenticationService.authenticate(session).map(userSession -> {
            List<Post> posts = filterPostService.filter(request.page, request.size);
            List<PostPresenter> postsPresenters = new ArrayList<>();
            for (Post post : posts) {
                postsPresenters.add(new PostPresenter(post));
            }

            return new Response<>(postsPresenters);
        }).orElseGet(new Response<List<PostPresenter>>()::withUserNotAuthorized);

    }

    static class Request {
        private int page;
        private int size;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

    }
}
