package br.org.iel.recrutaif.model.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-07-18T17:17:16.326-0300")
@StaticMetamodel(VagaPreenchida.class)
public class VagaPreenchida_ {
	public static volatile SingularAttribute<VagaPreenchida, Integer> id;
	public static volatile SingularAttribute<VagaPreenchida, Date> dataInscricao;
	public static volatile SingularAttribute<VagaPreenchida, Vaga> vaga;
	public static volatile SingularAttribute<VagaPreenchida, Usuario> candidato;
}
