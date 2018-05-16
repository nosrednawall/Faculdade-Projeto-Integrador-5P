package br.org.iel.recrutaif.entity;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayInputStream;
import java.text.ParseException;
import org.junit.jupiter.api.Test;
import junit.framework.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.stream.Stream;
import junit.extensions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class VagaTest<Titulo> {

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

	// 2-Não ultrapassar 50 caracteres - OK

	@Test
	@DisplayName("Limite de 50 caracteres respeitado")
	public void LimiteDeCaracteresOK() throws ParseException {
		String Cinquenta = "Antigos";

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

			assertTrue("Campo contem numeros", vagaTeste.getTitulo().isEmpty());
		{
			return;
		}
	}

}
