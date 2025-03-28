package com.giaccneto.Seletivo_SEPLAG.infraestructure.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServidorTemporario extends Pessoa{

    @Column(name = "db_st_data_admissao")
    private LocalDate st_data_admissao;
    @Column(name = "db_st_data_demissao")
    private LocalDate st_data_demissao;
}
