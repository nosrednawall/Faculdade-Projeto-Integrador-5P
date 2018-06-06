package br.org.iel.recrutaif.controllers.validators;

import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.org.iel.recrutaif.model.entity.Usuario;

/*
Testa Campo Registre-se do login
*/

class UsuarioValidatorTest {

	/*
	Testa limite de caracteres de no maximo 100
	*/
	
	@Test
	@DisplayName("Tem mais de 100 caracteres")
	public void TemMaisDe100Caracteres() throws ParseException {
		String cem = "dasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
				+ "dassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
				+ "dassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
				+ "dassssssssssssssssssssssssssssssssssssss";

		UsuarioValidator validador = new UsuarioValidator();
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(cem);
		
		assertTrue("O campo tem mais de 100 caracteres", validador.validaUsuario(usuario));
	}
	
	@Test
	@DisplayName("Tem menos de 100 caracteres")
	public void TemMenosDe100Caracteres() throws ParseException {
		String cem = "Antigos Espiritos do Mal Transformem este código decadente em JUnit";
		
		UsuarioValidator validador = new UsuarioValidator();
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(cem);
		
		assertTrue("O campo tem menos de 100 caracteres", validador.validaUsuario(usuario));
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





