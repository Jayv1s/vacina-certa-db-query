package com.vacinacerta.usecase.user;

import com.entities.db.User;
import com.vacinacerta.repository.IUserRepository;
import com.vacinacerta.usecase.IUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Qualifier("GetUserById")
public class GetUserById implements IUseCase<String, User> {

    @Autowired
    private final IUserRepository userRepository;

    @Override
    public User execute(String userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
