package br.org.iel.recrutaif.controllers.validators;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.org.iel.recrutaif.model.entity.Vaga;
import br.org.iel.recrutaif.model.util.ValidacoesUtil;

class VagaValidatorTest {

	@Test
	void testValidaVaga() {
		Vaga vaga = new Vaga();

		vaga.setDescricao("Essa vaga contem poucos caracteres");
		vaga.setTitulo("Olá mundo Vaga");
		vaga.setDataExpiracao((ValidacoesUtil.getDataInDate("16/11/2018")));

		VagaValidator validador = new VagaValidator();
		assertTrue(validador.validaVaga(vaga));
	}

}
