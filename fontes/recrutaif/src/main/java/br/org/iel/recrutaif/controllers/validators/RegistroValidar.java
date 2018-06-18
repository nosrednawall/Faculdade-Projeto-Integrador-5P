
package br.org.iel.recrutaif.controllers.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.org.iel.recrutaif.model.entity.Usuario;

public class RegistroValidar extends Usuario{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static Usuario Usuario;
	
	private boolean email;
	private boolean senha;
	private boolean matricula;	
	private boolean nome;	
	private boolean dataAdmissao;

	private boolean validarEmail() {
		return email;
	}

	private boolean validarSenha() {
		return senha;
	}

	private boolean validarMatricula() {
		return matricula;
	}
	
	private boolean Date() {
		return dataAdmissao;
	}

	private void validaNome(String nomeUsuario) {
		//verifica se não é null
		if(nomeUsuario != null) {
		//verifica se não está vazio
			if(!nomeUsuario.isEmpty()) {
				//verifica se está com números
				Pattern pattern = Pattern.compile("[0-9]");
				Matcher matcher = pattern.matcher(nomeUsuario);
				if(matcher.find()){
					System.out.println("Não deve conter caracteres!");
						}else {
							if(nomeUsuario.length()>=101) {
								System.out.println("O nome não deve conter mais que 100 caracteres");
							}
							
						}
				}
			}

}

	public boolean isNome() {
		return nome;
	}

	public void setNome(boolean nome) {
		this.nome = nome;
	}
}
