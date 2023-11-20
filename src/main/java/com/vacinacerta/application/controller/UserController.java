package com.vacinacerta.application.controller;

import com.entities.db.User;
import com.vacinacerta.domain.usecase.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController()
@RequestMapping("/user")
public class UserController {

    private final IUseCase<String, User> getUserById;

    @Autowired
    private UserController(
            @Qualifier("GetUserById")
            IUseCase<String, User> getUserById
    ) {
        this.getUserById = getUserById;
    }

    @GetMapping("/{id}")
    private ResponseEntity<User> getUserById(@PathVariable String id) {
        var user = getUserById.execute(id);

        if(Objects.nonNull(user)) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
