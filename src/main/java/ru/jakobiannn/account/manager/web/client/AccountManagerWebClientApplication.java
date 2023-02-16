package ru.jakobiannn.account.manager.web.client;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountManagerWebClientApplication {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        SpringApplication.run(AccountManagerWebClientApplication.class, args);
    }

}
