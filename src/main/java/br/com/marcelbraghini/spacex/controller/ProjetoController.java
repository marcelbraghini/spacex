package br.com.marcelbraghini.spacex.controller;

import br.com.marcelbraghini.spacex.model.Projeto;
import br.com.marcelbraghini.spacex.repository.RepositoryProjeto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Object> show(@PathVariable final Long id) {
        try {
            final Projeto projeto = repositoryProjeto.findAllById(id);
            return status(OK).body(new ObjectMapper().writeValueAsString(projeto));
        } catch (final Exception e) {
            return status(NOT_FOUND).body("Houve um erro ao recuperar o projeto de ID: "+id);
        }
    }

    //TODO Falta testar
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody final Projeto projeto) {
        try {
            final Projeto projetoSalvo = repositoryProjeto.save(projeto);
            return status(OK).body(new ObjectMapper().writeValueAsString(projetoSalvo));
        } catch (final Exception e) {
            return status(NOT_FOUND).body("Houve um erro ao salvar o projeto...");
        }
    }

    //TODO Falta testar
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable final Long id) {
        final Projeto projeto = repositoryProjeto.findAllById(id);
        if (projeto.possivelExcluir()){
            repositoryProjeto.deleteById(id);
            return status(OK).body("Projeto removido com sucesso");
        } else {
            return status(HttpStatus.LOCKED).body("Não é possível remover este projeto, seu status não permite!");
        }
    }

    //TODO Falta testar
    //TODO Problema com a serialização
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@RequestBody final Projeto projeto, @PathVariable final Long id){
        try {
            final Projeto projetoNovo = repositoryProjeto.save(projeto);
            return status(OK).body(new ObjectMapper().writeValueAsString(projetoNovo));
        } catch (final Exception e) {
            return status(NOT_FOUND).body("Houve um erro ao editar o projeto de ID: "+id);
        }
    }

}
