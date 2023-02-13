package ru.jakobiannn.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jakobiannn.model.User;
import ru.jakobiannn.model.Users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {
    @GetMapping("/show_users")
    public String displayUsers() throws IOException {
        URL url = new URL("http://localhost:8050/users/show");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        ObjectMapper mapper = new ObjectMapper();
        Users users = mapper.readValue(content.toString(), Users.class);
        return users.toString();
    }
}
