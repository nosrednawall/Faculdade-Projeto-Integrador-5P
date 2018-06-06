package br.org.iel.recrutaif.controllers.validators.regras;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;

import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.org.iel.recrutaif.controllers.validators.VagaValidator;
import br.org.iel.recrutaif.model.entity.Vaga;

class CampoNaoPodeEstarVazioTest {
	
	// Autor: Everton Sausen

		@Ignore
		@Test
		@DisplayName("Retorna OK se o campo estiver vazio")
		public void RetornarOKSeOCampoEstiverVazio() throws ParseException {

			String conteudo = "";
			Vaga vagaTeste = new Vaga();
			vagaTeste.setTitulo(conteudo);
			
/*			VagaValidator.validar(vagaTeste);*/
		}

		@Test
		@DisplayName("Retorna Erro se o campo estiver preenchido")
		public void RetornarErroSeOCampoEstiverPreenchido() throws ParseException {

			String conteudo = "dasdasd";
			Vaga vagaTeste = new Vaga();
			vagaTeste.setTitulo(conteudo);
			assertTrue("O campo está preenchido", vagaTeste.getTitulo().isEmpty());
		}


}
