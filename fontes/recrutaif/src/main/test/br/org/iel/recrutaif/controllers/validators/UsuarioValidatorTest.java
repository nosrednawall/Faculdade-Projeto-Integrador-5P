package br.org.iel.recrutaif.controllers.validators;

import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.org.iel.recrutaif.model.entity.Usuario;

public class UsuarioValidatorTest<TestNew> {

	// Autor: Everton Sausen
	// 1-Não deve ficar em branco - OK
	
	// @Nested

	@Test
	@DisplayName("Retorna OK se o campo estiver vazio")
	public void RetornarOKSeOCampoEstiverVazio() throws ParseException {

		String conteudo = "";
		Usuario nomeTeste = new Usuario();
		nomeTeste.setNome(conteudo);
		assertTrue("O campo está vazio", nomeTeste.getNome().isEmpty());
	}
}


//package br.org.iel.recrutaif.controllers.validators;
//
////import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import br.org.iel.recrutaif.model.entity.Usuario;
//
//class UsuarioValidatorTest {
////to copiando desse site
////	https://howtoprogram.xyz/2016/09/09/junit-5-maven-example/
//	
////	@BeforeEach
////	void init() {
////		Usuario testaNome = new Usuario();
////	}
////	
//	@Test
//	boolean testValidaUsuarioNomeNotNull() {
//		
//		boolean resultado = false;
//		
//		Usuario testaNome = new Usuario();
//		testaNome.setNome("");
//		resultado = new UsuarioValidator().validaUsuario(testaNome);
//
//		
//		return resultado;
//	}
//
//}