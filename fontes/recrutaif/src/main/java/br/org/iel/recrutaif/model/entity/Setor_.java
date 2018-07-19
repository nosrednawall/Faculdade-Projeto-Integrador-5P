package br.org.iel.recrutaif.model.entity;

import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-07-18T17:17:16.185-0300")
@StaticMetamodel(Setor.class)
public class Setor_ {
	public static volatile SingularAttribute<Setor, Integer> id;
	public static volatile SingularAttribute<Setor, String> nome;
	public static volatile SingularAttribute<Setor, StatusBinarioEnum> status;
}
