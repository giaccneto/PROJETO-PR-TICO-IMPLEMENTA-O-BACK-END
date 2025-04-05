package com.servidor.api.entities.dtos;

import lombok.Data;

import java.util.List;

@Data
public class UnidadeServidorEfetivoDTO {

  private String nomePessoa;

  private Integer idade;

  private String nomeUnidade;

  private List<String> url;
}
