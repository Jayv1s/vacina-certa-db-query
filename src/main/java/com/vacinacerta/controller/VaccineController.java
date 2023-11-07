package com.vacinacerta.controller;

import com.entities.db.Vaccine;
import com.vacinacerta.usecase.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/vaccine")
public class VaccineController {

    private final IUseCase<Void, List<Vaccine>> listAllVaccines;

    @Autowired
    private VaccineController(
            @Qualifier("ListAllVaccines")
            IUseCase<Void, List<Vaccine>> listAllVaccines
    ) {
        this.listAllVaccines = listAllVaccines;
    }

    @GetMapping("/list-all")
    private ResponseEntity<List<Vaccine>> getAllVaccines() {
        var vaccines = listAllVaccines.execute(null);

        if(CollectionUtils.isEmpty(vaccines)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(vaccines, HttpStatus.OK);
        }
    }
}
