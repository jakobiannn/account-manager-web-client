package ru.jakobiannn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @GetMapping("/show_users")
    public String displayUsers() {
        return
    }
}
