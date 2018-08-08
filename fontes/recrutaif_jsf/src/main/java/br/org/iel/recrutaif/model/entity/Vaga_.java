package br.org.iel.recrutaif.model.entity;

import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-07-18T17:17:16.322-0300")
@StaticMetamodel(Vaga.class)
public class Vaga_ {
	public static volatile SingularAttribute<Vaga, Integer> id;
	public static volatile SingularAttribute<Vaga, String> titulo;
	public static volatile SingularAttribute<Vaga, String> descricao;
	public static volatile SingularAttribute<Vaga, StatusBinarioEnum> status;
	public static volatile SingularAttribute<Vaga, Date> dataCriacao;
	public static volatile SingularAttribute<Vaga, Date> dataExpiracao;
	public static volatile SingularAttribute<Vaga, Setor> setor;
	public static volatile SetAttribute<Vaga, VagaPreenchida> inscritos;
}
