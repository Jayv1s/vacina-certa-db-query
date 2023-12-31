package com.vacinacerta.domain.adapters;

import com.entities.db.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepositoryAdapter extends JpaRepository<User, String> {
}
