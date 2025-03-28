package com.giaccneto.Seletivo_SEPLAG.infraestructure.repository;

import com.giaccneto.Seletivo_SEPLAG.infraestructure.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
