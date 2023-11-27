package com.vacinacerta.application.controller;

import com.vacinacerta.domain.entities.db.Vaccine;
import com.vacinacerta.domain.entities.dto.VaccineDTO;
import com.vacinacerta.domain.usecase.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController()
@RequestMapping("/vaccine")
public class VaccineController {

    private final IUseCase<Void, List<Vaccine>> listAllVaccines;
    private final IUseCase<String, VaccineDTO> getVaccineById;

    @Autowired
    private VaccineController(
            @Qualifier("ListAllVaccines")
            IUseCase<Void, List<Vaccine>> listAllVaccines,
            @Qualifier("GetVaccineById")
            IUseCase<String, VaccineDTO>getVaccineById
    ) {
        this.listAllVaccines = listAllVaccines;
        this.getVaccineById = getVaccineById;
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

    @GetMapping("/{vaccineId}")
    private ResponseEntity<VaccineDTO> getVaccineById(@PathVariable String vaccineId) {
        var vaccine = getVaccineById.execute(vaccineId);

        if(Objects.nonNull(vaccine)) {
            return new ResponseEntity<>(vaccine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
