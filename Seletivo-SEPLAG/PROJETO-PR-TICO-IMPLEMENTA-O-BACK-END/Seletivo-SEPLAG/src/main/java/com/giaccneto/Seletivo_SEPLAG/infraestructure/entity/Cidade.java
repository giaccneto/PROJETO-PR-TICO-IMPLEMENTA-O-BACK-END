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
public abstract class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid_id;
    @Column(name = "db_cid_nome")
    private String cid_nome;
    @Column(name = "db_cid_uf")
    private String cid_uf;
}
