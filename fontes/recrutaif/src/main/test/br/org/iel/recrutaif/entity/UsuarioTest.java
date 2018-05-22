package br.org.iel.recrutaif.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UsuarioTest {

	@Test
	@DisplayName("Campo senha deve estar preenchido")
	void test() {
		//assertFalse(new Aluno().validarAg("1234"));
		fail("Not yet implemented");
	}

}

//@Test
//
//public void RetornarOKSeOCampoEstiverVazio() throws ParseException {
//
//	String conteudo = "";
//	Vaga vagaTeste = new Vaga();
//	vagaTeste.setTitulo(conteudo);
//	assertTrue("O campo está vazio", vagaTeste.getTitulo().isEmpty());
//}
//
//@Test
//@DisplayName("Retorna Erro se o campo estiver preenchido")
//public void RetornarErroSeOCampoEstiverPreenchido() throws ParseException {
//
//	String conteudo = "dasdasd";
//	Vaga vagaTeste = new Vaga();
//	vagaTeste.setTitulo(conteudo);
//	assertTrue("O campo está preenchido", vagaTeste.getTitulo().isEmpty());
//}
