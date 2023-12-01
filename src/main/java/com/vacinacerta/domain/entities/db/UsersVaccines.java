package com.vacinacerta.domain.entities.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuarios_vacinas")
public class UsersVaccines {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(length=32)
    public String id;

    //@Column(name = "usuario_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id", nullable=false)
    private User user;

    //@Column(name = "vacina_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vacina_id", nullable=false)
    private Vaccine vaccine;

    @Column(name = "aplicado_em")
    private Date appliedAt;
}
