package br.com.marcelbraghini.springbootpostgres.repository;

import br.com.marcelbraghini.springbootpostgres.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProjeto extends JpaRepository<Projeto, Long> {
    Projeto findAllById(final Long id);
}
