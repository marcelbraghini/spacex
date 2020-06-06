package br.com.marcelbraghini.spacex.model;

import br.com.marcelbraghini.spacex.repository.RepositoryPessoa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PessoaIntegrationTest {

	@Autowired
	private RepositoryPessoa repositoryPessoa;

	@Test
	public void testFindAllPessoas(){
		final List<Pessoa> pessoas = repositoryPessoa.findAll();
		assertEquals(3, pessoas.size());
	}

	@Test
	public void testFindByIdPessoa(){
		final Pessoa pessoas = repositoryPessoa.findAllById(1l);
		assertEquals("Judith Miranda", pessoas.getNome());
		assertEquals("111.111.111-11", pessoas.getCpf());
		assertEquals(LocalDate.of(1990, 9, 28), pessoas.getDatanascimento());
		assertEquals(TRUE, pessoas.getFuncionario());
	}

}