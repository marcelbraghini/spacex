package br.com.marcelbraghini.spacex.repository;

import br.com.marcelbraghini.spacex.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProjeto extends JpaRepository<Projeto, Long> {
    Projeto findAllById(final Long id);
}
