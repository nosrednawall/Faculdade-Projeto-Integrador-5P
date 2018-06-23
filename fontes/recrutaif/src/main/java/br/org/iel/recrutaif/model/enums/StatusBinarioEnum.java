package br.org.iel.recrutaif.model.enums;

/**
 * Enum que seta o status de uma vaga
 * @author anderson
 *
 */
public enum StatusBinarioEnum {
	ATIVO(0), INATIVO(1), AMBOS(2);

	private final Integer indice;

	private StatusBinarioEnum(Integer indice) {
		this.indice = indice;
	}

	public Integer getIndice() {
		return this.indice;
	}

	public StatusBinarioEnum getStatusPeloIndice(Integer indice) {
		if (indice == 0) {
			return StatusBinarioEnum.ATIVO;
		} else if (indice == 1) {
			return StatusBinarioEnum.INATIVO;
		} else if (indice == 2) {
			return StatusBinarioEnum.AMBOS;
		}
		return null;
	}
}
