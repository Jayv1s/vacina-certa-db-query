package com.vacinacerta.domain.usecase.user;

import com.entities.db.User;
import com.vacinacerta.domain.adapters.IUserRepositoryAdapter;
import com.vacinacerta.domain.usecase.IUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Qualifier("GetUserById")
public class GetUserById implements IUseCase<String, User> {

    @Autowired
    private final IUserRepositoryAdapter userRepository;

    @Override
    public User execute(String userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
