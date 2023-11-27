package com.vacinacerta.domain.usecase.vaccine;


import com.vacinacerta.domain.adapters.IVaccineRepositoryAdapter;
import com.vacinacerta.domain.entities.db.Vaccine;
import com.vacinacerta.domain.entities.dto.VaccineDTO;
import com.vacinacerta.domain.entities.mapper.VaccineMapper;
import com.vacinacerta.domain.usecase.IUseCase;
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
    private final IVaccineRepositoryAdapter vaccineRepositoryImpl;

    @Override
    public VaccineDTO execute(String vaccineId) {

        Vaccine vaccine = vaccineRepositoryImpl.findById(vaccineId).orElse(null);

        if(Objects.isNull(vaccine)) {
            return null;
        }

        return VaccineMapper.convertToVaccineDTO(vaccine);
    }
}
