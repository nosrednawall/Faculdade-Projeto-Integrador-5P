package br.org.iel.recrutaif.controllers.validators;

import static org.junit.Assert.assertTrue;

import org.jboss.security.auth.login.ParseException;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.org.iel.recrutaif.model.entity.Usuario;


public class UsuarioValidatorTest<TestNew> {

	// Autor: Everton Sausen
	// 1-Não deve ficar em branco - OK
	
	// @Nested

	@Test
//	@DisplayName("Retorna OK se o campo estiver vazio")
	public void RetornarOKSeOCampoEstiverVazio() throws ParseException {

		String conteudo = "";
		Usuario vagaTeste = new Usuario();
		vagaTeste.setNome(conteudo);
		assertTrue("O campo está vazio", vagaTeste.getNome().isEmpty());
	}
}
