package com.vacinacerta.application.controller;

import com.entities.db.UsersVaccines;
import com.vacinacerta.domain.usecase.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class UsersVaccinesController {

    private final IUseCase<String, List<UsersVaccines>> listAllVaccinesByUser;

    @Autowired
    private UsersVaccinesController(
            @Qualifier("ListVaccinesByUserId")
            IUseCase<String, List<UsersVaccines>> listAllVaccinesByUser
    ) {
        this.listAllVaccinesByUser = listAllVaccinesByUser;
    }

    @GetMapping("/users/{id}/vaccines")
    private ResponseEntity<List<UsersVaccines>> listAllVaccinesFromUser(@PathVariable String id) {
        var usersVaccines = listAllVaccinesByUser.execute(id);

        if(CollectionUtils.isEmpty(usersVaccines)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(usersVaccines, HttpStatus.OK);
        }
    }
}
