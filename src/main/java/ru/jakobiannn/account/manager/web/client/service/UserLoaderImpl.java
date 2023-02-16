package ru.jakobiannn.account.manager.web.client.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.jakobiannn.account.manager.web.client.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Component
public class UserLoaderImpl implements UserLoader {
    private static final Logger LOGGER = Logger.getLogger(UserLoaderImpl.class);

    public Optional<List<User>> getAllUsers() {
        try {
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
            Optional<List<User>> users = Optional.ofNullable(
                    mapper.readValue(content.toString(), new TypeReference<>() {})
            );
            return users;
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Some exception was thrown: ", e);
            return Optional.empty();
        }
    }
}
