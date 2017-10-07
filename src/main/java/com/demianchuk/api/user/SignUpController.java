package com.demianchuk.api.user;

import com.demianchuk.service.user.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SignUpController {

    @Autowired
    private CreateUserService createUserService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/sign_up", method = RequestMethod.POST, consumes = "application/json")
    void signUp(@RequestBody SignUpRequest body) {
        createUserService.create(body.getEmail(), body.getPassword(), body.getFirstName());
    }

    static class SignUpRequest {
        private String email;
        private String password;
        private String firstName;

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

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }

}
