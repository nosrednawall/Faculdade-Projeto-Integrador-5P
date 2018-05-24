package br.org.iel.recrutaif.model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import org.junit.jupiter.api.DisplayName;
import br.org.iel.recrutaif.model.entity.Vaga;
import junit.framework.*;


public class VagaTest<TestaVaga> {

	// Autor: Everton Sausen
	// 1-Não deve ficar em branco - OK
	
	// @Nested

	@Test
	@DisplayName("Retorna OK se o campo estiver vazio")
	public void RetornarOKSeOCampoEstiverVazio() throws ParseException {

		String conteudo = "";
		Vaga vagaTeste = new Vaga();
		vagaTeste.setTitulo(conteudo);
		assertTrue("O campo está vazio", vagaTeste.getTitulo().isEmpty());
	}

	@Test
	@DisplayName("Retorna Erro se o campo estiver preenchido")
	public void RetornarErroSeOCampoEstiverPreenchido() throws ParseException {

		String conteudo = "dasdasd";
		Vaga vagaTeste = new Vaga();
		vagaTeste.setTitulo(conteudo);
		assertTrue("O campo está preenchido", vagaTeste.getTitulo().isEmpty());
	}

	// @ParameterizedTest
	
	// Autor: Everton Sausen
	// 2-Não ultrapassar 50 caracteres - OK
	
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

	// Autor: Everton Sausen
	// 3-Não deve conter números

	@Test
	@DisplayName("Foi inserido caracter")
	public void validaSeFoiInseridoCaracter() throws ParseException {

		String conteudo = "MumRáá";
		Vaga vagaTeste = new Vaga();
		vagaTeste.setTitulo(conteudo);
		if (Character.isAlphabetic((((String) conteudo).charAt(0)))
				&& Character.isAlphabetic((((String) conteudo).charAt(conteudo.length() - 1))))
			assertTrue("Campo contem caracteres", vagaTeste.getTitulo().isEmpty());
		{
			return;
		}
	}

	@Test
	@DisplayName("Foi inserido número")
	public void validaSeFoiInseridoNumero() throws ParseException {

		String conteudo = "141425";
		Vaga vagaTeste = new Vaga();
		vagaTeste.setTitulo(conteudo);
		if (Character.isAlphabetic((((String) conteudo).charAt(0)))
				&& Character.isAlphabetic((((String) conteudo).charAt(conteudo.length() - 1))))

			assertTrue("Campo contem números", vagaTeste.getTitulo().isEmpty());
		{
			return;
		}
	}
}



//
//package br.org.iel.recrutaif.entity;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//import java.text.ParseException;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import br.org.iel.recrutaif.model.entity.Vaga;
//
//
//public class VagaTest<Titulo> {
//
//	// Autor: Everton Sausen
//	// 1-Não deve ficar em branco - OK
//	
//	// @Nested
//
//	@Test
//	//(expected=RuntimeException.class)
//	@DisplayName("Retorna OK se o campo estiver vazio")
//	public void RetornarOKSeOCampoEstiverVazio() throws ParseException {
//
//		String conteudo = "";
//		Vaga vagaTeste = new Vaga();
//		vagaTeste.setTitulo(conteudo);
//		assertTrue("O campo está vazio", vagaTeste.getTitulo().isEmpty());
//	}
//
//	@Test
//	@DisplayName("Retorna Erro se o campo estiver preenchido")
//	public void RetornarErroSeOCampoEstiverPreenchido() throws ParseException {
//
//		String conteudo = "dasdasd";
//		Vaga vagaTeste = new Vaga();
//		vagaTeste.setTitulo(conteudo);
//		assertTrue("O campo está preenchido", vagaTeste.getTitulo().isEmpty());
//	}
//
//	// @ParameterizedTest
//	
//	// Autor: Everton Sausen
//	// 2-Não ultrapassar 50 caracteres - OK
//	
//	@Test
//	@DisplayName("Limite de 50 caracteres respeitado")
//	public void LimiteDeCaracteresOK() throws ParseException {
//		String Cinquenta = "NaMinhaMaquinaFuncionaRá";
//
//		Vaga vagaTeste = new Vaga();
//		vagaTeste.setTitulo(Cinquenta);
//		// System.out.println(Cinquenta.length());
//		assertFalse("O campo está dentro de cinquenta caracteres", vagaTeste.getTitulo().isEmpty());
//	}
//
//	@Test
//	@DisplayName("Limite de caracteres excedido")
//	public void LimiteDeCaracteresExcedido() throws ParseException {
//		String Cinquenta = "AntigosEspiritosDoMalTransformemEsteCodigoDecadenteEmJavaEterno";
//
//		Vaga vagaTeste = new Vaga();
//		vagaTeste.setTitulo(Cinquenta);
//		// System.out.println(Cinquenta.length());
//		assertTrue("O campo está fora de cinquenta caracteres", vagaTeste.getTitulo().isEmpty());
//	}
//
//	// Autor: Everton Sausen
//	// 3-Não deve conter números
//
//	@Test
//	@DisplayName("Foi inserido caracter")
//	public void validaSeFoiInseridoCaracter() throws ParseException {
//
//		String conteudo = "MumRáá";
//		Vaga vagaTeste = new Vaga();
//		vagaTeste.setTitulo(conteudo);
//		if (Character.isAlphabetic((((String) conteudo).charAt(0)))
//				&& Character.isAlphabetic((((String) conteudo).charAt(conteudo.length() - 1))))
//			assertTrue("Campo contem caracteres", vagaTeste.getTitulo().isEmpty());
//		{
//			return;
//		}
//	}
//
//	@Test
//	@DisplayName("Foi inserido número")
//	public void validaSeFoiInseridoNumero() throws ParseException {
//
//		String conteudo = "141425";
//		Vaga vagaTeste = new Vaga();
//		vagaTeste.setTitulo(conteudo);
//		if (Character.isAlphabetic((((String) conteudo).charAt(0)))
//				&& Character.isAlphabetic((((String) conteudo).charAt(conteudo.length() - 1))))
//
//			assertTrue("Campo contem números", vagaTeste.getTitulo().isEmpty());
//		{
//			return;
//		}
//	}
//}