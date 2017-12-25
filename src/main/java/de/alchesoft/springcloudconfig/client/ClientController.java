package de.alchesoft.springcloudconfig.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Value("${user.role}")
    private String role;

    @Value("${user.password}")
    private String password;

    @GetMapping(value = "/whoami/{username}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String whoami(@PathVariable("username") String username) {
        return String.format("Hello! You're %s and you'll become a(n) %s, but only if your password is %s...\n", username, role, password);
    }
}
