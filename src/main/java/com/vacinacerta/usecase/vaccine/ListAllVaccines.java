package com.vacinacerta.usecase.vaccine;

import com.entities.db.Vaccine;
import com.vacinacerta.repository.IVaccineRepository;
import com.vacinacerta.usecase.IUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@AllArgsConstructor
@Qualifier("ListAllVaccines")
public class ListAllVaccines implements IUseCase<Void, List<Vaccine>> {

    @Autowired
    private final IVaccineRepository vaccineRepository;

    @Override
    public List<Vaccine> execute(Void unused) {
        List<Vaccine> vaccines = vaccineRepository.findAll();

        if (CollectionUtils.isEmpty(vaccines)) {
            return null;
        }

        return vaccines;
    }
}
