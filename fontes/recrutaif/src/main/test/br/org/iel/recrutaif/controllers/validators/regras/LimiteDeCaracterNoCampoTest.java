package br.org.iel.recrutaif.controllers.validators.regras;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.org.iel.recrutaif.model.entity.Vaga;

class LimiteDeCaracterNoCampoTest {

	@Test
	@DisplayName("Limite de 50 caracteres respeitado")
	public void LimiteDeCaracteresOK() throws ParseException {
		String Cinquenta = "NaMinhaMaquinaFuncionaRá";

		Vaga vagaTeste = new Vaga();
		vagaTeste.setTitulo(Cinquenta);
		// System.out.println(Cinquenta.length());
		assertFalse("O campo está dentro de cinquenta caracteres", vagaTeste.getTitulo().isEmpty());
	}

	@Test
	@DisplayName("Limite de caracteres excedido")
	public void LimiteDeCaracteresExcedido() throws ParseException {
		String Cinquenta = "AntigosEspiritosDoMalTransformemEsteCodigoDecadenteEmJavaEterno";

		Vaga vagaTeste = new Vaga();
		vagaTeste.setTitulo(Cinquenta);
		// System.out.println(Cinquenta.length());
		assertTrue("O campo está fora de cinquenta caracteres", vagaTeste.getTitulo().isEmpty());
	
	}

}
