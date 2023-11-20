package com.vacinacerta.domain.usecase.usersvaccines;

import com.entities.db.UsersVaccines;
import com.vacinacerta.domain.adapters.IUsersVaccinesRepositoryAdapter;
import com.vacinacerta.domain.usecase.IUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@AllArgsConstructor
@Qualifier("ListVaccinesByUserId")
public class ListVaccinesByUserId implements IUseCase<String, List<UsersVaccines>> {

    @Autowired
    private final IUsersVaccinesRepositoryAdapter usersVaccinesRepository;

    @Override
    public List<UsersVaccines> execute(String userId) {
        List<UsersVaccines> usersVaccines = usersVaccinesRepository.findByUsersId(userId);


        if (CollectionUtils.isEmpty(usersVaccines)) {
            return null;
        }

        return usersVaccines;
    }
}
