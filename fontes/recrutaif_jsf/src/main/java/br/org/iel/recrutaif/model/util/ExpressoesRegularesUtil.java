package br.org.iel.recrutaif.model.util;

public class ExpressoesRegularesUtil {

	/**
	 * Regex para textos em geral
	 */
	public static final String VALIDA_TEXTO_COM_ACENTUACAO_E_NOMES_EM_GERAL = "(?=^.{2,60}$)^[A-ZÀÁÂĖÈÉÊÌÍÒÓÔÕÙÚÛÇ][a-zàáâãèéêìíóôõùúç]+(?:[ ](?:das?|dos?|de|e|[A-Za-zÀ-ú]+))*$";
	public static final String VALIDA_TEXTO_COM_ACENTUACAO_E_NOMES_EM_GERAL_COM_NUMEROS = "(?=^.{2,60}$)^[A-ZÀÁÂĖÈÉÊÌÍÒÓÔÕÙÚÛÇ][a-zàáâãèéêìíóôõùúç]+(?:[ ](?:das?|dos?|de|e|Av.?|R.?|[A-Za-zÀ-ð0-9]+))*$";
	/**
	 * Patterns para usuários
	 */
	public static final String REGEX_EMAIL = "(?=^.{5,60}$)^[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]";
	public static final String REGEX_CPFCNPJ = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})";
	public static final String REGEX_CPF = "^[0-9]{3}.?[0-9]{3}.?[0-9]{3}-?[0-9]{2}";
	public static final String REGEX_TELEFONE = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$";
	public static final String REGEX_SENHA = "^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9]).{8,})\\S$";
	public static final String REGEX_NOME = VALIDA_TEXTO_COM_ACENTUACAO_E_NOMES_EM_GERAL;
	public static final String REGEX_NOME_FORTE = "^(?![ ])(?!.*[ ]{3})((?:e|da|do|das|dos|de|d'|D'|la|las|el|los)\\s*?|(?:[A-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð'][^\\s]*\\s*?)(?!.*[ ]$))+$";
	public static final String REGEX_MATRICULA = "^\\\\d{5}$";

	/**
	 * Regex para vaga
	 */
	public static final String REGEX_DESCRICAO = "(?=^.{2,500}$)^[A-ZÀÁÂĖÈÉÊÌÍÒÓÔÕÙÚÛÇ][a-zàáâãèéêìíóôõùúç]+(?:[ ](?:das?|dos?|de|e|Av.?|R.?|[A-Za-zÀ-ð0-9]+))*$";
	public static final String REGEX_TITULO = "(?=^.{2,50}$)^[A-ZÀÁÂĖÈÉÊÌÍÒÓÔÕÙÚÛÇ][a-zàáâãèéêìíóôõùúç]+(?:[ ](?:das?|dos?|de|e|[A-Za-zÀ-ú]+))*$";

	/**
	 * Patters para endereço
	 */
	public static final String REGEX_CEP = "^\\d{5}[-]\\d{3}$";
	public static final String REGEX_LOGRADOURO = VALIDA_TEXTO_COM_ACENTUACAO_E_NOMES_EM_GERAL_COM_NUMEROS;
	public static final String REGEX_NUMERO_CASA = "^[0-9]{1,6}";
	public static final String REGEX_COMPLEMENTO = VALIDA_TEXTO_COM_ACENTUACAO_E_NOMES_EM_GERAL_COM_NUMEROS;
}
