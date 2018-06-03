package br.org.iel.recrutaif.controllers.validators.regras;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.org.iel.recrutaif.model.entity.Vaga;

class CaracterInvalidoValidaTest {

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
