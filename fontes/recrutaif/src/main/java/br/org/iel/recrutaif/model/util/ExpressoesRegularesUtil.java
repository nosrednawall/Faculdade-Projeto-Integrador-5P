package br.org.iel.recrutaif.model.util;

public class ExpressoesRegularesUtil {

	/**
	 * Regex para textos em geral
	 */
	private final String VALIDA_TEXTO_COM_ACENTUACAO_E_NOMES_EM_GERAL = "(?=^.{2,60}$)^[A-ZÀÁÂĖÈÉÊÌÍÒÓÔÕÙÚÛÇ][a-zàáâãèéêìíóôõùúç]+(?:[ ](?:das?|dos?|de|e|[A-Za-zÀ-ú]+))*$";
	private final String VALIDA_TEXTO_COM_ACENTUACAO_E_NOMES_EM_GERAL_COM_NUMEROS = "(?=^.{2,60}$)^[A-ZÀÁÂĖÈÉÊÌÍÒÓÔÕÙÚÛÇ][a-zàáâãèéêìíóôõùúç]+(?:[ ](?:das?|dos?|de|e|Av.?|R.?|[A-Za-zÀ-ð0-9]+))*$";
	/**
	 * Patterns para usuários
	 */
	private final String REGEX_EMAIL = "(?=^.{5,60}$)^[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]";
	private final String REGEX_CPFCNPJ = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})";
	private final String REGEX_CPF = "^[0-9]{3}.?[0-9]{3}.?[0-9]{3}-?[0-9]{2}";
	private final String REGEX_TELEFONE = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$";
	// private final String REGEX_SENHA = "^[a-zA-Z]\\w{3,14}$";
	private final String REGEX_SENHA = "^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9]).{6,})\\S$";
	private final String REGEX_NOME = VALIDA_TEXTO_COM_ACENTUACAO_E_NOMES_EM_GERAL;
	private final String REGEX_NOME_FORTE = "^(?![ ])(?!.*[ ]{3})((?:e|da|do|das|dos|de|d'|D'|la|las|el|los)\\s*?|(?:[A-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð'][^\\s]*\\s*?)(?!.*[ ]$))+$";

	/**
	 * Regex para textos
	 */
	private final String REGEX_TEXTO_ALFANUMERICO = "^[A-Za-z0-9]+";
	private final String REGEX_TEXTO_ALFABETO = "^[A-Za-z]+";

	/**
	 * Patters para endereço
	 */
	private final String REGEX_CEP = "^\\d{5}[-]\\d{3}$";
	private final String REGEX_LOGRADOURO = VALIDA_TEXTO_COM_ACENTUACAO_E_NOMES_EM_GERAL_COM_NUMEROS;
	private final String REGEX_NUMERO_CASA = "^[0-9]{1,6}";
	private final String REGEX_COMPLEMENTO = VALIDA_TEXTO_COM_ACENTUACAO_E_NOMES_EM_GERAL_COM_NUMEROS;

	/**
	 * Getters and setters
	 */
	public String getREGEX_EMAIL() {
		return REGEX_EMAIL;
	}

	public String getREGEX_CPFCNPJ() {
		return REGEX_CPFCNPJ;
	}

	public String getREGEX_CPF() {
		return REGEX_CPF;
	}

	public String getREGEX_TELEFONE() {
		return REGEX_TELEFONE;
	}

	public String getREGEX_SENHA() {
		return REGEX_SENHA;
	}

	public String getREGEX_NOME() {
		return REGEX_NOME;
	}

	public String getREGEX_NOME_FORTE() {
		return REGEX_NOME_FORTE;
	}

	public String getREGEX_TEXTO_ALFANUMERICO() {
		return REGEX_TEXTO_ALFANUMERICO;
	}

	public String getREGEX_TEXTO_ALFABETO() {
		return REGEX_TEXTO_ALFABETO;
	}

	public String getREGEX_CEP() {
		return REGEX_CEP;
	}

	public String getREGEX_LOGRADOURO() {
		return REGEX_LOGRADOURO;
	}

	public String getREGEX_NUMERO_CASA() {
		return REGEX_NUMERO_CASA;
	}

	public String getREGEX_COMPLEMENTO() {
		return REGEX_COMPLEMENTO;
	}
}
