package ru.jakobiannn.account.manager.web.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.jakobiannn.account.manager.web.client.model.User;
import ru.jakobiannn.account.manager.web.client.service.UserLoader;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {
    private final UserLoader usersLoader;

    @Autowired
    public UsersController(UserLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @RequestMapping("/show_users")
    public String helloPage(Model model) throws IOException {
        Optional<List<User>> users = usersLoader.getAllUsers();
        if (users.isPresent()) {
            model.addAttribute("list", users.get());
            return "users";
        }
        return "error";
    }
}
