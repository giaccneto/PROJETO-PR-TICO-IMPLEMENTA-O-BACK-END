package com.servidor.api.repositories;

import com.servidor.api.entities.Lotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotacaoRepository extends JpaRepository<Lotacao, Long> {
}
