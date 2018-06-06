package br.org.iel.recrutaif.controllers.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.org.iel.recrutaif.model.entity.Usuario;


class UsuarioValidatorTest {

	@Test
	@DisplayName("Limite de 100 caracteres respeitado")
	public void LimiteDe100CaracteresRespeitado() throws ParseException {
		String Cem = "Rá";
		
		Usuario validaVaga = new Usuario();
		
		validaVaga.setNome(Cem);
		assertTrue("O campo está dentro de cinquenta caracteres", validaVaga.getNome().isEmpty());
	}
	
	@Test
	@DisplayName("Limite de 100 caracteres NOK")
	public void LimiteDe100CaracteresNOK() throws ParseException {
		String Cem = "NaMinhaMaquinaFuncionaRádfffffffffffffffffffffffffffffffffffffffffddddddddddddddddddddd"
				+ "fdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
				+ "sdssssssdsfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
				+ "fdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
				+ "sdssssssdsfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
				+ "fdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
				+ "sdssssssdsfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
				+ "fdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
				+ "sdssssssdsfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
				+ "fdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
				+ "sdssssssdsfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
		
		Usuario validaVaga = new Usuario();
		
		validaVaga.setNome(Cem);
		assertFalse("O campo está dentro de cinquenta caracteres", validaVaga.getNome().isEmpty());
	}
}


