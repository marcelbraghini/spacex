package br.com.marcelbraghini.springbootpostgres.repository;

import br.com.marcelbraghini.springbootpostgres.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPessoa extends JpaRepository<Pessoa, Long> {
    Pessoa findAllById(final Long id);
}
