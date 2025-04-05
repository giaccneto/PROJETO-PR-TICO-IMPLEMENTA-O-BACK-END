package com.servidor.api.controllers;

import com.servidor.api.entities.Pessoa;
import com.servidor.api.entities.dtos.PessoaDTO;
import com.servidor.api.entities.mappers.PessoaMapper;
import com.servidor.api.minio.service.MinioService;
import com.servidor.api.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

  @Autowired
  private PessoaRepository pessoaRepository;

  @Autowired
  private MinioService minioService;

  @Autowired
  private PessoaMapper pessoaMapper;

  @Transactional
  @PostMapping
  public ResponseEntity<?> createPessoa(@RequestBody PessoaDTO pessoaDTO) {
    try {
      Pessoa pessoa = pessoaMapper.toEntity(pessoaDTO);
      Pessoa savedPessoa = pessoaRepository.save(pessoa);
      return new ResponseEntity<>(savedPessoa, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping
  public ResponseEntity<Page<Pessoa>> getAllPessoas(Pageable pageable) {
    try {
      Page<Pessoa> pagePessoas = pessoaRepository.findAll(pageable);

      if (pagePessoas.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(pagePessoas, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pessoa> getPessoaById(@PathVariable("id") Long id) {
    Optional<Pessoa> pessoaData = pessoaRepository.findById(id);

    return pessoaData.map(pessoa -> new ResponseEntity<>(pessoa, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @Transactional
  @PutMapping("/{id}")
  public ResponseEntity<Pessoa> updatePessoa(@PathVariable("id") Long id, @RequestBody PessoaDTO pessoa) {
    Optional<Pessoa> pessoaData = pessoaRepository.findById(id);

    if (pessoaData.isPresent()) {
      Pessoa existingPessoa = pessoaData.get();
      pessoaMapper.toEntity(existingPessoa, pessoa);

      return new ResponseEntity<>(pessoaRepository.save(existingPessoa), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @Transactional
  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deletePessoa(@PathVariable("id") Long id) {
    try {
      pessoaRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}