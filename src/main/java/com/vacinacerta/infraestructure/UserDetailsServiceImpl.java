package com.vacinacerta.infraestructure;

import com.vacinacerta.domain.adapters.IUserAccessRepositoryAdapter;
import com.vacinacerta.domain.entities.db.UserAccess;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserAccessRepositoryAdapter userAccessRepositoryImpl;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        UserAccess userAccess = userAccessRepositoryImpl.findById(login).orElseThrow(() -> new UsernameNotFoundException("login não encontrado"));

        String[] roles = userAccess.getRoles().split(",");

        return User.builder()
                .username(userAccess.getLogin())
                .password(userAccess.getPassword())
                .roles(roles)
                .build();
    }
}
