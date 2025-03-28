package com.giaccneto.Seletivo_SEPLAG.infraestructure.repository;

import com.giaccneto.Seletivo_SEPLAG.infraestructure.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
