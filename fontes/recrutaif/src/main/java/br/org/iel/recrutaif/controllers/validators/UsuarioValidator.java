package br.org.iel.recrutaif.controllers.validators;

import br.org.iel.recrutaif.model.entity.Usuario;

public class UsuarioValidator {

	public boolean validaVaga(Usuario usuario) {
		boolean resultado = true;

		if(dataEhValida(usuario) == false) {
			resultado = false;
		}
		
		return resultado;
	}

	private boolean dataEhValida(Usuario usuario) {
		System.out.println("Deu false dentro do dataEhValida");
		return false;
	}
}