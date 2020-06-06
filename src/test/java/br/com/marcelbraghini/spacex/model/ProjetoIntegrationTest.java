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

import static br.com.marcelbraghini.spacex.model.Risco.BAIXO_RISCO;
import static br.com.marcelbraghini.spacex.model.Status.INICIADO;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjetoIntegrationTest {

	@Autowired
	private RepositoryProjeto repositoryProjeto;

	@Test
	public void testPossivelExcluirFalse(){
		final Projeto projeto = repositoryProjeto.findAllById(1l);
		assertFalse(projeto.possivelExcluir());
	}

	@Test
	public void testPossivelExcluirTrue(){
		final Projeto projeto = new Projeto(2l, "X", LocalDate.now(), LocalDate.now(), null, "descricao", Status.ANALISE_APROVADA,
											new BigDecimal("10000"), Risco.ALTO_RISCO, 1, null);
		assertTrue(projeto.possivelExcluir());
	}

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
		assertEquals(INICIADO, projeto.getStatus());
		assertEquals(new BigDecimal("10000000"), projeto.getOrcamento());
		assertEquals(BAIXO_RISCO, projeto.getRisco());
		assertEquals(3, projeto.getIdgerente());
		assertEquals("Judith Miranda", projeto.getMembros().iterator().next().getNome());
	}

}