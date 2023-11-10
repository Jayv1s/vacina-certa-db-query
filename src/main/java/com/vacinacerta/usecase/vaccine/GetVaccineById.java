package com.vacinacerta.usecase.vaccine;

import com.entities.db.Vaccine;
import com.entities.dto.VaccineDTO;
import com.entities.mapper.VaccineMapper;
import com.vacinacerta.repository.IVaccineRepository;
import com.vacinacerta.usecase.IUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
@Qualifier("GetVaccineById")
public class GetVaccineById implements IUseCase<String, VaccineDTO> {

    @Autowired
    private final IVaccineRepository vaccineRepositoryImpl;

    @Override
    public VaccineDTO execute(String vaccineId) {

        Vaccine vaccine = vaccineRepositoryImpl.findById(vaccineId).orElse(null);

        if(Objects.isNull(vaccine)) {
            return null;
        }

        return VaccineMapper.convertToVaccineDTO(vaccine);
    }
}
