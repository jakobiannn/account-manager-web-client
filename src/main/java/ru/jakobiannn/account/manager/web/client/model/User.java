package ru.jakobiannn.account.manager.web.client.model;

import lombok.Data;

@Data
public class User {
    private String login;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String adress;
}
