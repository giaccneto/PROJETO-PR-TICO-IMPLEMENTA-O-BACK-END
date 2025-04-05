package com.servidor.api.entities.mappers;

import com.servidor.api.entities.FotoPessoa;
import com.servidor.api.entities.Unidade;
import com.servidor.api.repositories.FotoPessoaRepository;
import com.servidor.api.minio.service.MinioService;
import com.servidor.api.entities.ServidorEfetivo;
import com.servidor.api.entities.dtos.UnidadeServidorEfetivoDTO;
import com.servidor.api.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Component
public class UnidadeServidorEfetivoMapper {

  @Autowired
  private UnidadeRepository unidadeRepository;

  @Autowired
  private FotoPessoaRepository fotoPessoaRepository;

  @Autowired
  private MinioService minioService;

  public List<UnidadeServidorEfetivoDTO> toDTO(List<ServidorEfetivo> servidorEfetivos, Long unidadeId) {
    Unidade unidade = unidadeRepository.findById(unidadeId).orElseThrow(() -> new RuntimeException("Unidade não encontrada"));
    List<UnidadeServidorEfetivoDTO> dtos = new ArrayList<>();
    for(ServidorEfetivo servidorEfetivo : servidorEfetivos) {
      UnidadeServidorEfetivoDTO dto = new UnidadeServidorEfetivoDTO();
      dto.setNomePessoa(servidorEfetivo.getPessoa().getNome());
      dto.setNomeUnidade(unidade.getNome());

      LocalDate currentDate = LocalDate.now();
      int idade = Period.between(servidorEfetivo.getPessoa().getDataNascimento(), currentDate).getYears();
      dto.setIdade(idade);

      List<FotoPessoa> fotoPessoas = fotoPessoaRepository.findAllByPessoaId(servidorEfetivo.getPessoa().getId().longValue());
      List<String> fotoPessoasUrl = fotoPessoas.stream().map(fotoPessoa -> {
        String url = minioService.getFileUrl(fotoPessoa.getHash());
        return url;
      }).toList();
      dto.setUrl(fotoPessoasUrl);
      dtos.add(dto);
    }
    return dtos;
  }
}
