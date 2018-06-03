package br.org.iel.recrutaif.controllers.validators.regras;

import static org.junit.Assert.assertTrue;
import java.util.Calendar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.org.iel.recrutaif.model.entity.Usuario;

public class CampoNaoPodeEstarVazio {

	@Test
	@DisplayName("Retorna OK se o campo estiver vazio")
	public static void valida(Calendar dataCriacao) {
			String conteudo = "";
			Usuario nomeTeste = new Usuario();
			nomeTeste.setNome(conteudo);
			assertTrue("O campo está vazio", nomeTeste.getNome().isEmpty());		
		
	}

}
