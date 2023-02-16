package ru.jakobiannn.account.manager.web.client.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.jakobiannn.account.manager.web.client.model.User;

import java.util.List;
import java.util.Optional;

public interface UserLoader {
    Optional<List<User>> getAllUsers() throws JsonProcessingException;
}
