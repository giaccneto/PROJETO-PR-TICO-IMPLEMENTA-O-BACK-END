package com.giaccneto.Seletivo_SEPLAG.infraestructure.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServidorEfetivo extends Pessoa{

    @Column(name = "db_se_matricula")
    private String se_matricula;
}
