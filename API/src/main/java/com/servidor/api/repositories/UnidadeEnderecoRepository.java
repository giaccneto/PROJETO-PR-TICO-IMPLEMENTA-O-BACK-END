package com.servidor.api.repositories;

import com.servidor.api.entities.UnidadeEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeEnderecoRepository extends JpaRepository<UnidadeEndereco, Long> {
}
