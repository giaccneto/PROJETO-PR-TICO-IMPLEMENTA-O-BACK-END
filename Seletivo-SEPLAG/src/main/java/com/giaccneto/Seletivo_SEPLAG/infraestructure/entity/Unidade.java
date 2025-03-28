package com.giaccneto.Seletivo_SEPLAG.infraestructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unid_id;
    @Column(name = "db_unid_nome")
    private String unid_nome;
    @Column(name = "db_unid_sigla")
    private String unid_sigla;
}
