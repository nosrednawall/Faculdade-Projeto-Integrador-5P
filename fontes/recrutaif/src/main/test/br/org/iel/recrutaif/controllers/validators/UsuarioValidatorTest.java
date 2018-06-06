package br.org.iel.recrutaif.controllers.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.org.iel.recrutaif.model.entity.Usuario;
import br.org.iel.recrutaif.model.entity.Vaga;

/*
Testa Campo Registre-se do login
*/

class UsuarioValidatorTest {

	/*
	Testa limite de caracteres de no maximo 100
	*/
	
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
	
	
	/*
	Testa se o campo esta vazio
	*/
	
	@Test
	@DisplayName("Retorna Erro se o campo estiver vazio")
	public void RetornarErroSeOCampoEstiverVazio() throws ParseException {

		String conteudo = "";
		Usuario validaVaga = new Usuario();
		validaVaga.setNome(conteudo);
		assertTrue("O campo está preenchido", validaVaga.getNome().isEmpty());

	}

	@Test
	@DisplayName("Retorna OK se o campo estiver preenchido")
	public void RetornarOKSeOCampoEstiverPreenchido() throws ParseException {

		String conteudo = "ererer";
		Usuario validaVaga = new Usuario();
		validaVaga.setNome(conteudo);
		assertTrue("O campo está preenchido", validaVaga.getNome().isEmpty());
	}

	/*
	Testa se o campo foi inserido numeros
	*/
	
	@Test
	@DisplayName("Foi inserido caracter")
	public void validaSeFoiInseridoCaracter() throws ParseException {

		String conteudo = "MumRáá";
		Usuario validaVaga = new Usuario();
		validaVaga.setNome(conteudo);
		if (Character.isAlphabetic((((String) conteudo).charAt(0)))
				&& Character.isAlphabetic((((String) conteudo).charAt(conteudo.length() - 1))))
			assertTrue("Campo contem caracteres", validaVaga.getNome().isEmpty());
		{
			return;
		}
	}

	@Test
	@DisplayName("Foi inserido número")
	public void validaSeFoiInseridoNumero() throws ParseException {

		String conteudo = "141425";
		Usuario validaVaga = new Usuario();
		validaVaga.setNome(conteudo);
		if (Character.isAlphabetic((((String) conteudo).charAt(0)))
				&& Character.isAlphabetic((((String) conteudo).charAt(conteudo.length() - 1))))
			assertTrue("Campo contem caracteres", validaVaga.getNome().isEmpty());
		{
			return;
		}

}
}





