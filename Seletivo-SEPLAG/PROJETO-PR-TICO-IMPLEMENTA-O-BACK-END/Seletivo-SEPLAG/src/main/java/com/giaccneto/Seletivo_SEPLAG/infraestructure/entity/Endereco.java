package com.giaccneto.Seletivo_SEPLAG.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long end_id;
    @Column(name = "db_end_tipo_logradouro")
    private String end_tipo_logradouro;
    @Column(name = "db_end_logradouro", nullable = false)
    private String end_logradouro;
    @Column(name = "db_end_numero", nullable = false)
    private Long end_numero;
    @Column(name = "db_end_bairro", nullable = false)
    private String end_bairro;
}
