package br.org.iel.recrutaif.controllers.validators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.org.iel.recrutaif.model.entity.Usuario;

/*
* Testa Campo Registre-se do login
*/

class UsuarioValidatorTest {

	/*
	Testa limite de caracteres de no maximo 100
	*/
	
	@Test
	@DisplayName("Tem mais de 100 caracteres")
	public void TemMaisDe100Caracteres() throws ParseException {
		
		String Cem = "dasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
				+ "dassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
				+ "dassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
				+ "dassssssssssssssssssssssssssssssssssssss";

		UsuarioValidator validador = new UsuarioValidator();
		Usuario usuario = new Usuario();
		usuario.setNome(Cem);
		assertTrue("O campo tem mais de 100 caracteres", validador.validaUsuario(usuario));
	}
	
	@Test
	@DisplayName("Tem menos de 100 caracteres")
	public void TemMenosDe100Caracteres() throws ParseException {
		String Cem = "Antigos espiritos do mal transformem este teste decadente em JUnit!!! O de vida eterna!!!";
		
		UsuarioValidator validador = new UsuarioValidator();
		Usuario usuario = new Usuario();
		usuario.setNome(Cem);
		assertTrue("O campo tem menos de 100 caracteres", validador.validaUsuario(usuario));
	}
	
	@Test
	@DisplayName("Tem mais de 50 caracteres")
	public void TemMaisDe50Caracteres() throws ParseException {
		
		String Cem = "dasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
				+ "dassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
				+ "dassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
			
		UsuarioValidator validador = new UsuarioValidator();
		Usuario usuario = new Usuario();
		usuario.setNome(Cem);
		assertTrue("O campo tem mais de 100 caracteres", validador.validaUsuario(usuario));
	}
	
	@Test
	@DisplayName("Tem menos de 50 caracteres")
	public void TemMenosDe50Caracteres() throws ParseException {
		String Cem = "Antigos espiritos do mal transformem este teste decadente em JUnit!!! O de vida eterna!!!";
		
		UsuarioValidator validador = new UsuarioValidator();
		Usuario usuario = new Usuario();
		usuario.setNome(Cem);
		assertTrue("O campo tem menos de 100 caracteres", validador.validaUsuario(usuario));
	}
	

	
	/*Testa se o campo foi inserido numeros
	*/
	
	@Test
	@DisplayName("Foi inserido caracter")
	public void validaSeFoiInseridoCaracter() throws ParseException {

		String conteudo = "Mexico Campeão";
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
			assertTrue("Campo contem números", validaVaga.getNome().isEmpty());
		{
			return;
		}
	}


    /*
	Testa se o campo esta vazio
	*/
	
  	@Test
  	@DisplayName("Retorna Erro se o campo estiver vazio")
  	public void RetornarErroSeOCampoEstiverNull() throws ParseException {
  		
  		String vazio = null;
  		  		
  		UsuarioValidator validador = new UsuarioValidator();
  		
  		Usuario usuario = new Usuario();
  		
  		usuario.setNome(vazio);
  				
  		assertEquals(null, validador.validaUsuario(usuario));

  	}
      
	@Test
	@DisplayName("Retorna Erro se o campo estiver em branco")
	public void RetornarErroSeOCampoEstiverVazio() throws ParseException {
		String vazio = "";
		
		UsuarioValidator validador = new UsuarioValidator();
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(vazio);
				
		assertTrue("", validador.validaUsuario(usuario));

	}
	

}

	




