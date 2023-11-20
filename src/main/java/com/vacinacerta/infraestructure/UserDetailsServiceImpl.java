package com.vacinacerta.domain.usecase.UserAcess;

import com.entities.db.UserAccess;
import com.vacinacerta.domain.repository.UserAccessRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@AllArgsConstructor
public class LoadUserAccess implements UserDetailsService {

    @Autowired
    private UserAccessRepository userAccessRepositoryImpl;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        UserAccess userAccess = userAccessRepositoryImpl.findById(login).orElseThrow(() -> new UsernameNotFoundException("login não encontrado"));

        String[] roles = new ArrayList<>(Arrays.asList(userAccess.getRoles().split(","))).toArray(new String[0]);

        return User.builder()
                .username(userAccess.getLogin())
                .password(userAccess.getPassword())
                .roles(roles)
                .build();
    }
}
