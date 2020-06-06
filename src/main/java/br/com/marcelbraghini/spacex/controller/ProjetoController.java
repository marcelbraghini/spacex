package br.com.marcelbraghini.spacex.controller;

import br.com.marcelbraghini.spacex.model.Projeto;
import br.com.marcelbraghini.spacex.repository.RepositoryProjeto;
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
@RequestMapping(value = "projetos", produces = "application/json;charset=UTF-8")
public class ProjetoController {

    private final RepositoryProjeto repositoryProjeto;

    public ProjetoController(RepositoryProjeto repositoryProjeto) {
        this.repositoryProjeto = repositoryProjeto;
    }

    @GetMapping
    public ResponseEntity<Object> index() {
        try {
            List<Projeto> projetos = repositoryProjeto.findAll();
            return status(OK).body(new ObjectMapper().writeValueAsString(projetos));
        } catch (final Exception e) {
            return status(NOT_FOUND).body("Houve um erro ao recuperar os projetos...");
        }
    }

    @GetMapping(value = "/{id}")
    public Projeto show(@PathVariable final Long id) {
        return repositoryProjeto.findAllById(id);
    }

}
