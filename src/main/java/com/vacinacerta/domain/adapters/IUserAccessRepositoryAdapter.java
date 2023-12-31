package com.vacinacerta.domain.adapters;

import com.entities.db.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAccessRepositoryAdapter extends JpaRepository<UserAccess, String> {
}
