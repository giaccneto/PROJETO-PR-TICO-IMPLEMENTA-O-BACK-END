package com.servidor.api.repositories;

import com.servidor.api.entities.PessoaEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long> {
}
