package com.giaccneto.Seletivo_SEPLAG.infraestructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pes_id;
    @Column(name = "db_pes_nome", nullable = false)
    private String pes_nome;
    @Column(name = "db_pes_data_nascimento", nullable = false)
    private LocalDate pes_data_nascimento;
    @Column(name = "db_pes_sexo")
    private String sexo;
    @Column(name ="db_pes_mae")
    private String pes_mae;
    @Column(name ="db_pes_pai")
    private String pes_pai;
}
