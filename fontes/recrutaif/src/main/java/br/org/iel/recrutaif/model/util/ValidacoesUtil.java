package br.org.iel.recrutaif.model.util;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacoesUtil {

	// chamo as regex daqui
	static ExpressoesRegularesUtil regex = new ExpressoesRegularesUtil();
	static RegrasNegocioUtil regras = new RegrasNegocioUtil();

	/**
	 * Valida cep
	 * 
	 * @param cep
	 * @return boolean
	 */
	public static boolean validaSenha(String senha) {
		if (!senha.matches(regex.getREGEX_SENHA())) {
			return false;
		}
		return true;
	}

	/**
	 * Valida nome
	 * 
	 * @param nome
	 * @return boolean
	 */
	public static boolean validaNome(String nome) {
		boolean validado = true;

		if (nome != null) {

			if (nome == "") {
				imprimeLog("O campo nome não pode ficar em branco!");
				validado = false;
			}

			Pattern padraoNumeros = Pattern.compile("[0-9]");
			Matcher farejador = padraoNumeros.matcher(nome);

			if (farejador.find()) {
				imprimeLog("nome não deve conter números!");
				validado = false;
			}

			if (!nome.matches(regex.getREGEX_NOME())) {
				imprimeLog("O Campo nome não é válido");
				validado = false;
			}

		} else {
			imprimeLog("Nome não pode ser nulo");
			validado = false;
		}
		return validado;
	}

	/**
	 * Método boolean que recebe um email e retorna se ele está validado ou não
	 * 
	 * @param email
	 * @return boolean
	 */
	public static boolean validaEmail(String email) {

		boolean validado = true;

		// primeiro valida se não é null
		if (email != null) {

			// veirifica se não é uma string vazia
			if (email.isEmpty()) {
				imprimeLog("Email não pode ser vazio");
				validado = false;
			}

			/**
			 * Verifica se o email é válido, ex: possui \w@\w.\w
			 */
			if (!email.matches(regex.getREGEX_EMAIL())) {
				imprimeLog("Email informado não é um email válido");
				validado = false;
			}

			// caso seja nulo
		} else {
			imprimeLog("Email não pode ser nulo");
			validado = false;
		}

		return validado;
	}

	/**
	 * Valida a data de nascimento
	 * 
	 * @param dataNascimento
	 * @return
	 */
	public static boolean validaDataNascimeto(Date dataNascimento) {
		boolean validado = true;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		// verifica se não é nulo
		if (dataNascimento != null) {
			String dataTexto = dateFormat.format(dataNascimento);

			// verifica se não está vazio
			if (dataTexto.isEmpty()) {
				imprimeLog("DataNascimento não pode ser vazio");
				validado = false;
			}

			/**
			 * tenta fazer um parse, caso esteja no formato errado lança excessão
			 */
			dateFormat.setLenient(false); // aqui o pulo do gato
			try {
				System.out.println(dateFormat.parse(dataTexto));
				// data válida
			} catch (ParseException ex) {
				imprimeLog("DataNascimento inválida " + ex);
				validado = false;
			}

			// verifica se não excedeu a idade máxima
			if (dataNascimento.before(regras.getMaxAge())) {
				imprimeLog("DataNascimento não pode ser maior que a data limite de " + regras.getMaxAge());
				validado = false;
			}

			// verifica se não está menor que a idade mínima
			if (dataNascimento.after(regras.getMinAge())) {
				imprimeLog("DataNascimento não pode ser menor que a data limite de " + regras.getMinAge());
				validado = false;
			}

		} else {
			imprimeLog("DataNascimento não pode ser nulo");
			validado = false;
		}
		return validado;
	}

	/**
	 * Método que remove os acentos de uma string
	 * http://www.guj.com.br/t/expressao-regular-alfanumerico-espaco-acentuacao/108978/8
	 * 
	 * @param acentuada
	 * @return
	 */
	public static String removerAcentos(String acentuada) {
		CharSequence cs = new StringBuilder(acentuada);
		return Normalizer.normalize(cs, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}

	/**
	 * Método converte uma data de String para o formato Date
	 * 
	 * @param data
	 * @return
	 */
	public static Date getDataInDate(String data) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			return dateFormat.parse(data);
		} catch (ParseException e) {
			imprimeLog("Data inválida");
			return null;
		}
	}

	private static void imprimeLog(String mensagem) {
		System.out.println("[ERRO] " + mensagem);
	}

	/**
	 * Valida a data de admissao de um usuário
	 * 
	 * @param dataAdmissao
	 * @return
	 */
	public static boolean validaDataAdmissao(Date dataAdmissao) {
		boolean validado = true;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		// verifica se não é nulo
		if (dataAdmissao != null) {
			String dataTexto = dateFormat.format(dataAdmissao);

			// verifica se não está vazio
			if (dataTexto.isEmpty()) {
				imprimeLog("DataNascimento não pode ser vazio");
				validado = false;
			}

			/**
			 * tenta fazer um parse, caso esteja no formato errado lança excessão
			 */
			dateFormat.setLenient(false); // aqui o pulo do gato
			try {
				System.out.println(dateFormat.parse(dataTexto));
				// data válida
			} catch (ParseException ex) {
				imprimeLog("DataNascimento inválida " + ex);
				validado = false;
			}

			// verifica se não está menor que a data de hoje, ou seja no futuro
			try {
				if (dataAdmissao.after(Date.class.newInstance())) {
					imprimeLog("DataNascimento não pode ser menor que a data limite de " + regras.getMinAge());
					validado = false;
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			imprimeLog("DataNascimento não pode ser nulo");
			validado = false;
		}
		return validado;
	}

	public static boolean validaMatricula(String matricula) {
		if (!matricula.matches(regex.getREGEX_SENHA())) {
			imprimeLog("problema ao validar data Admissao");
			return false;
		}
		return true;
	}
}
