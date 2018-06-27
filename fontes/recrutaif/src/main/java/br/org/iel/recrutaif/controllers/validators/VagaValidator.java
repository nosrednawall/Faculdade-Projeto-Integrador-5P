package br.org.iel.recrutaif.controllers.validators;

import br.org.iel.recrutaif.model.entity.Vaga;
import br.org.iel.recrutaif.model.util.ValidacoesUtil;

public class VagaValidator {
	public boolean validaVaga(Vaga vaga) {
		boolean validacao = true;

		if (ValidacoesUtil.validaDescricao(vaga.getDescricao()) == false) {
			imprimeLog("Problema ao validar Email");
			validacao = false;
		}
		if (ValidacoesUtil.validaTitulo(vaga.getTitulo()) == false) {
			imprimeLog("Problema ao validar Nome");
			validacao = false;
		}
		if (ValidacoesUtil.validaDataExpiracao(vaga.getDataExpiracao()) == false) {
			imprimeLog("Problema ao validar Data Expiracao");
			validacao = false;
		}
		return validacao;
	}

	private static void imprimeLog(String mensagem) {
		System.out.println("[ERRO] " + mensagem);
	}
}