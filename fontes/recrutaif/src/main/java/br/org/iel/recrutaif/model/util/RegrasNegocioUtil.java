package br.org.iel.recrutaif.model.util;

import java.util.Calendar;
import java.util.Date;

public class RegrasNegocioUtil {

	/**
	 * Função retorna a idade mínima
	 * 
	 * @return
	 */

	public Date getMinAge() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.YEAR, -100);
		return currentDate.getTime();
	}

	/**
	 * Funcao retorma a idade máxima
	 * 
	 * @return
	 */
	public Date getMaxAge() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.YEAR, -18);
		return currentDate.getTime();
	}
}
