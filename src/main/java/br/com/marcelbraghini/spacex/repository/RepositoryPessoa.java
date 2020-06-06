package br.com.marcelbraghini.spacex.repository;

import br.com.marcelbraghini.spacex.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPessoa extends JpaRepository<Pessoa, Long> {
    Pessoa findAllById(final Long id);
}
