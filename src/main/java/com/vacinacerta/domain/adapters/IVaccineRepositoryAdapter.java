package com.vacinacerta.domain.adapters;

import com.vacinacerta.domain.entities.db.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVaccineRepositoryAdapter extends JpaRepository<Vaccine, String> {
}
