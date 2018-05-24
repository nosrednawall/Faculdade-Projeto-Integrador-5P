package br.org.iel.recrutaif.controllers.validators;

public class VagaValidator {
	public boolean validaTitulo (String titulo) {
		boolean resultado = false;
		
		while ((titulo = new String(br.readLine().getBytes(), "ISO-8859-1")) != null) {
			System.out.println(titulo);
		}
		
		
		return resultado;
	}
}
