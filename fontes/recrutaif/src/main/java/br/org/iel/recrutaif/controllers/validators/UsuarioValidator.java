package br.org.iel.recrutaif.controllers.validators;

import br.org.iel.recrutaif.model.entity.Usuario;
import br.org.iel.recrutaif.model.util.ValidacoesUtil;

public class UsuarioValidator {

	public boolean validaUsuario(Usuario pessoa) {
		boolean validacao = true;

		if (ValidacoesUtil.validaEmail(pessoa.getEmail()) == false) {
			imprimeLog("Problema ao validar Email");
			validacao = false;
		}
		if (ValidacoesUtil.validaNome(pessoa.getNome()) == false) {
			imprimeLog("Problema ao validar Nome");
			validacao = false;
		}
		if (ValidacoesUtil.validaSenha(pessoa.getSenha()) == false) {
			imprimeLog("Problema ao validar Senha");
			validacao = false;
		}
		if (ValidacoesUtil.validaDataAdmissao(pessoa.getDataAdmissao()) == false) {
			imprimeLog("Problema ao validar DataAdmissao");
			validacao = false;
		}
		if (ValidacoesUtil.validaMatricula(pessoa.getMatricula()) == false) {
			imprimeLog("Problema ao validar DataAdmissao");
			validacao = false;
		}
		return validacao;
	}

	private static void imprimeLog(String mensagem) {
		System.out.println("[ERRO] " + mensagem);
	}

	// private boolean nomeEhValida(Usuario usuario) {
	//
	// if (usuario.getNome() != null) {
	//
	// System.out.println("nome não é nulo");
	//
	// if (!usuario.getNome().isEmpty()) {
	//
	// System.out.println("nome não está vazio");
	// Pattern pattern = Pattern.compile("[0-9]");
	// Matcher matcher = pattern.matcher(usuario.getNome());
	//
	// if (matcher.find()) {
	//
	// System.out.println("nome possui numeros");
	//
	// System.out.println("ERRO Não deve conter caracteres!");
	// return false;
	//
	// } else {
	// if (usuario.getNome().length() >= 101) {
	// System.out.println("erro nome possui mais de 100 caracteres");
	// System.out.println("O nome não deve conter mais que 100 caracteres");
	// return false;
	// }
	// }
	// }
	// }
	// System.out.println("nome está ok");
	// return true;
	// }
	//
	// private boolean dataEhValida(Usuario usuario) {
	// System.out.println("Deu false dentro do dataEhValida");
	// return true;
	// }
}