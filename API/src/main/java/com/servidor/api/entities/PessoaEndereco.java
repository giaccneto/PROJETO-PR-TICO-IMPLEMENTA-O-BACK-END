package com.servidor.api.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.servidor.api.controllers.PessoaEnderecoKey;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoa_endereco")
public class PessoaEndereco {

  @EmbeddedId
  private PessoaEnderecoKey id;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("pessoaId")
  @JoinColumn(name = "pes_id", foreignKey = @ForeignKey(name = "fk_pessoa_endereco_pessoa"))
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  private Pessoa pessoa;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("enderecoId")
  @JoinColumn(name = "end_id", foreignKey = @ForeignKey(name = "fk_pessoa_endereco_endereco"))
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  private Endereco endereco;
}
