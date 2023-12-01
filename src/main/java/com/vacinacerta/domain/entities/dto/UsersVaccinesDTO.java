package com.vacinacerta.domain.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersVaccinesDTO {
    public String id;
    private UsersDTO usersDTO;
    private VaccineDTO vaccineDTO;
    private Date appliedAt;
}
