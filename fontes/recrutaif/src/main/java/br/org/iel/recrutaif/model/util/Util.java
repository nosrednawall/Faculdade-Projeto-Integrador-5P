package br.org.iel.recrutaif.model.util;

import java.util.Calendar;
import java.util.Date;

public class Util {

	/**
	 * Função retorna a idade mínima
	 * 
	 * @return
	 */

	public static Date getPrazoMinimoVaga() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.DAY_OF_WEEK_IN_MONTH, +1);
		return currentDate.getTime();
	}

	public static Date getPrazoMaximoVaga() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.MONTH, +180);
		return currentDate.getTime();
	}

	public static Date getMinAge() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.YEAR, -100);
		return currentDate.getTime();
	}

	/**
	 * Funcao retorma a idade máxima
	 * 
	 * @return
	 */
	public static Date getMaxAge() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.YEAR, -18);
		return currentDate.getTime();
	}
}
