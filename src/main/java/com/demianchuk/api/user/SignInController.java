package com.demianchuk.api.user;

import com.demianchuk.models.UserSession;
import com.demianchuk.service.user.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class SignInController {

    @Autowired
    private SignInService signInService;

    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public @ResponseBody Response signIn(@RequestBody Request request) {
        Optional<UserSession> userSession = signInService.signIn(request.email, request.password);
        Response response;
        if(userSession.isPresent()) {
            response = new Response(userSession.get());
        } else {
            response = new Response("User not found");
        }
        return response;
    }

    static class Response {
        private UUID session;
        private String error;

        public Response(String error) {
            this.error = error;
        }

        public Response(UserSession session) {
            this.session = session.getId();
        }

        public UUID getSession() {
            return session;
        }

        public void setSession(UUID session) {
            this.session = session;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    static class Request {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
