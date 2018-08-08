package br.org.iel.recrutaif.controllers.validators;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.org.iel.recrutaif.model.entity.Usuario;
import br.org.iel.recrutaif.model.util.ValidacoesUtil;

class UsuarioValidatorTest {

	@Test
	void testValidaUsuario() {

		Usuario usuario = new Usuario();
		UsuarioValidator validador = new UsuarioValidator();

		usuario.setNome("Alucard Nosferatu");
		usuario.setDataAdmissao(ValidacoesUtil.getDataInDate("16/11/1992"));
		usuario.setEmail("alucard@nosferatu.com");
		usuario.setMatricula("666");
		usuario.setSenha("MinhaSenha123");

		assertTrue(validador.validaUsuario(usuario));

		// assertTrue(ValidacoesUtil.validaNome(usuario.getNome()));
		// assertTrue(ValidacoesUtil.validaDataAdmissao(usuario.getDataAdmissao()));
		// assertTrue(ValidacoesUtil.validaEmail(usuario.getEmail()));
		// assertTrue(ValidacoesUtil.validaMatricula(usuario.getMatricula()));
		// assertTrue(ValidacoesUtil.validaSenha(usuario.getSenha()));
	}

}
