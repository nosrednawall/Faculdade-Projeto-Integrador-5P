package br.org.iel.recrutaif.controllers.validators;

import br.org.iel.recrutaif.model.entity.Vaga;


public class VagaValidator {
public boolean validaVaga(Vaga vaga) {
		boolean resultado = true;

		if(dataEhValida(vaga) == false) {
			resultado = false;
		}
		
		return resultado;
	}

	private boolean dataEhValida(Vaga vaga) {
		return true;
	}
	
	
}