package br.org.iel.recrutaif.controllers.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import br.org.iel.recrutaif.model.entity.Usuario;

public class UsuarioValidator {

	public boolean validaUsuario(Usuario usuario) {
		boolean resultado = true;

		if (dataEhValida(usuario) == false) {
			resultado = false;
		}

		if (nomeEhValida(usuario) == false) {
			resultado = false;
		}

		return resultado;
	}

	private boolean nomeEhValida(Usuario usuario) {

		if (usuario.getNome() != null) {

			System.out.println("nome não é nulo");
			
			if (!usuario.getNome().isEmpty()) {

				System.out.println("nome não está vazio");
				Pattern pattern = Pattern.compile("[0-9]");
				Matcher matcher = pattern.matcher(usuario.getNome());

				if (matcher.find()) {

					System.out.println("nome possui numeros");
					
					System.out.println("ERRO Não deve conter caracteres!");
					return false;

				} else {
					if (usuario.getNome().length() >= 101) {
						System.out.println("erro nome possui mais de 100 caracteres");
						System.out.println("O nome não deve conter mais que 100 caracteres");
						return false;
					}
				}
			}
		}
		System.out.println("nome está ok");
		return true;
	}

	private boolean dataEhValida(Usuario usuario) {
		System.out.println("Deu false dentro do dataEhValida");
		return true;
	}
}