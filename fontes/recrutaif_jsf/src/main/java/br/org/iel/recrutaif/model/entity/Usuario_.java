package br.org.iel.recrutaif.model.entity;

import br.org.iel.recrutaif.model.enums.NivelPermissao;
import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-07-18T17:17:16.320-0300")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, Integer> id;
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, String> matricula;
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, Date> dataAdmissao;
	public static volatile SingularAttribute<Usuario, NivelPermissao> permissao;
	public static volatile SingularAttribute<Usuario, StatusBinarioEnum> status;
	public static volatile SetAttribute<Usuario, VagaPreenchida> candidaturas;
}
