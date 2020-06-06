package br.com.marcelbraghini.spacex.model;

import br.com.marcelbraghini.spacex.repository.RepositoryProjeto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjetoIntegrationTest {

	@Autowired
	private RepositoryProjeto repositoryProjeto;

	@Test
	public void testFindAllProjetos(){
		final List<Projeto> projetos = repositoryProjeto.findAll();
		assertEquals(1, projetos.size());
	}

	@Test
	public void testFindByIdProjeto(){
		final Projeto projeto = repositoryProjeto.findAllById(1l);
		assertEquals("Projeto X", projeto.getNome());
		assertEquals(LocalDate.of(2020, 6, 6), projeto.getDataInicio());
		assertEquals(LocalDate.of(2021, 6, 6), projeto.getDataPrevisaoFim());
		assertNull(projeto.getDataFim());
		assertEquals("Projeto destinado ao entendimento do universo", projeto.getDescricao());
		assertEquals("INICIADO", projeto.getStatus());
		assertEquals(new BigDecimal("10000000"), projeto.getOrcamento());
		assertEquals("BAIXO_RISCO", projeto.getRisco());
		assertEquals(3, projeto.getIdgerente());
		assertEquals("Judith Miranda", projeto.getMembros().iterator().next().getNome());
	}

}