package com.vacinacerta.domain.adapters;

import com.entities.db.UsersVaccines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsersVaccinesRepositoryAdapter extends JpaRepository<UsersVaccines, String> {

    @Query("SELECT uv FROM UsersVaccines uv WHERE uv.user.id = :usuario_id")
    List<UsersVaccines> findByUsersId(@Param("usuario_id") String userId);
}
