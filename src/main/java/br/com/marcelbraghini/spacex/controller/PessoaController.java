package br.com.marcelbraghini.spacex.controller;

import br.com.marcelbraghini.spacex.model.Pessoa;
import br.com.marcelbraghini.spacex.repository.RepositoryPessoa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(value = "pessoas", produces = "application/json;charset=UTF-8")
public class PessoaController {

    private final RepositoryPessoa repositoryPessoa;

    public PessoaController(RepositoryPessoa repositoryPessoa) {
        this.repositoryPessoa = repositoryPessoa;
    }

    @GetMapping
    public ResponseEntity<Object> index() {
        try {
            List<Pessoa> pessoas = repositoryPessoa.findAll();
            return status(OK).body(new ObjectMapper().writeValueAsString(pessoas));
        } catch (final Exception e) {
            return status(NOT_FOUND).body("Houve um erro ao recuperar as pessoas...");
        }
    }

    @GetMapping(value = "/{id}")
    public Pessoa show(@PathVariable final Long id) {
        return repositoryPessoa.findAllById(id);
    }

}
