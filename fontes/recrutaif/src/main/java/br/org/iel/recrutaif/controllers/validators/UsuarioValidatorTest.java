package br.org.iel.recrutaif.controllers.validators;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.org.iel.recrutaif.model.entity.Usuario;

class UsuarioValidatorTest {
// to copiando desse site
//	https://howtoprogram.xyz/2016/09/09/junit-5-maven-example/
	
//	@BeforeEach
//	void init() {
//		Usuario testaNome = new Usuario();
//	}
//	
	@Test
	boolean testValidaUsuarioNomeNotNull() {
		
		boolean resultado = false;
		
		Usuario testaNome = new Usuario();
		testaNome.setNome("");
		resultado = new UsuarioValidator().validaUsuario(testaNome);

		
		return resultado;
	}

}
