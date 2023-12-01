package com.vacinacerta.domain.usecase.usersvaccines;

import com.vacinacerta.domain.adapters.IUsersVaccinesRepositoryAdapter;
import com.vacinacerta.domain.entities.db.UsersVaccines;
import com.vacinacerta.domain.entities.dto.UsersVaccinesDTO;
import com.vacinacerta.domain.entities.mapper.UsersVaccinesMapper;
import com.vacinacerta.domain.usecase.IUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Qualifier("ListVaccinesByUserId")
public class ListVaccinesByUserId implements IUseCase<String, List<UsersVaccinesDTO>> {

    @Autowired
    private final IUsersVaccinesRepositoryAdapter usersVaccinesRepository;

    @Override
    public List<UsersVaccinesDTO> execute(String userId) {
        List<UsersVaccines> usersVaccinesList = usersVaccinesRepository.findByUsersId(userId);
        List<UsersVaccinesDTO> response = new ArrayList<>();

        if (CollectionUtils.isEmpty(usersVaccinesList)) {
            return null;
        }

        for (UsersVaccines usersVaccines: usersVaccinesList) {
            response.add(UsersVaccinesMapper.convertToUsersVaccinesDTO(usersVaccines));
        }

        return response;
    }
}
