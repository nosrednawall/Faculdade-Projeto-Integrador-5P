package br.org.iel.recrutaif.controllers.validators;

import br.org.iel.recrutaif.model.entity.Usuario;

public class RegistroValidar extends Usuario{
	
	static Usuario Usuariol;
	
	private boolean email;
	private boolean senha;
	private boolean matricula;	
	private boolean nome;	
	

	private boolean validarEmail() {
		return email;
	}

	private boolean validarSenha() {
		return senha;
	}

	private boolean validarMatricula() {
		return matricula;
	}

	private boolean validarNome() {
		return true;
	}

	
}

























/*package br.org.iel.recrutaif.controllers.validators;

import br.org.iel.recrutaif.model.entity.Vaga;

public class RegistroValidar {

	public static boolean validar(Vaga vagaTeste) {
		vaga = vagaTeste;
		
		DataValidaIntervalo.valida(vagaTeste.getDataCriacao());
		DataValidaDiasInvalidos.valida(vagaTeste.getDataCriacao());
		DataValidaDiasFeriados.valida(vagaTeste.getDataCriacao());
		
		return false;

}
*/