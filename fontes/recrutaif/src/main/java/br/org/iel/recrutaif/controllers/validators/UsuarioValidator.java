package br.org.iel.recrutaif.controllers.validators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.org.iel.recrutaif.model.entity.Usuario;

public class UsuarioValidator {

	public boolean validaUsuario(Usuario usuario) {
		
		validaNome(usuario.getNome());
//		validaEmail(usuario);
//		validaSenha(usuario);
//		validaDataNascimento(usuario);
//		validaMatricula(usuario);
		
		return true;
	}

	//função para validar strings
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
					
					
				}
			}
		}
		
	}
	
}
