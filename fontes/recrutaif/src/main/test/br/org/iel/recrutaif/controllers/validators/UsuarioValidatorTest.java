package br.org.iel.recrutaif.controllers.validators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

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
		String cem = "Antigos espiritos do mal transformem este teste decadente em JUnit!!! O de vida eterna!!!";
		
		UsuarioValidator validador = new UsuarioValidator();
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(cem);
		
		assertTrue("O campo tem menos de 100 caracteres", validador.validaUsuario(usuario));
	}
	
/*
Testa Campo Registre-se do login


class UsuarioValidatorTest {

	
	Testa limite de caracteres de no maximo 100 --- OK
	
	
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
		String cem = "Antigos espiritos do mal transformem este teste decadente em JUnit!!! O de vida eterna!!!";
		
		UsuarioValidator validador = new UsuarioValidator();
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(cem);
		
		assertTrue("O campo tem menos de 100 caracteres", validador.validaUsuario(usuario));
	}*/
      
    /*
	Testa se o campo esta vazio
	*/
	
  /*	@Test
  	@DisplayName("Retorna Erro se o campo estiver vazio")
  	public void RetornarErroSeOCampoEstiverVazio() throws ParseException {
  		
  		String vazio = null;
  		  		
  		UsuarioValidator validador = new UsuarioValidator();
  		
  		Usuario usuario = new Usuario();
  		
  		usuario.setNome(vazio);
  				
  		assertEquals(null, validador.validaUsuario(usuario));

  	}
      
	@Test
	@DisplayName("Retorna Erro se o campo estiver vazio")
	public void RetornarErroSeOCampoEstiverVazio() throws ParseException {
		String vazio = "";
		
		UsuarioValidator validador = new UsuarioValidator();
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(vazio);
				
		assertTrue("O campo está vazio!", validador.validaUsuario(usuario));

	}
	
	@Test
	@DisplayName("teste1")
	public void teste() throws ParseException {

        String test = "";
        
        if (StringUtils.isBlank(test)) {
            System.out.println("THE STRING TEST IS EMPTY");
        }

     }
	
	@Test
	@DisplayName("teste1")
	public void teste2() throws ParseException {

        String testOne = null;
   
        if (StringUtils.isBlank(testOne)) {
            System.out.println("THE STRING TEST IS NULL");
        }

    }
	
	@Test
	@DisplayName("Retorna OK se o campo estiver preenchido")
	public void RetornarOKSeOCampoEstiverPreenchido() throws ParseException {
		String vazio = "Cheio";
		
		UsuarioValidator validador = new UsuarioValidator();
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(vazio);
		
		assertTrue("O campo está preenchido!", validador.validaUsuario(usuario));
		
	
	Testa se o campo foi inserido numeros
	
	
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

*/	

}


