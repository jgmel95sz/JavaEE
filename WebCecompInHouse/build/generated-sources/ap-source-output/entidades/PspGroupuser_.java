package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PspGroupuser.class)
public abstract class PspGroupuser_ {

	public static volatile SingularAttribute<PspGroupuser, PspGroupuserPK> pspGroupuserPK;
	public static volatile SingularAttribute<PspGroupuser, PspGrupo> pspGrupo;
	public static volatile SingularAttribute<PspGroupuser, PspUsuario> pspUsuario;
	public static volatile ListAttribute<PspGroupuser, PspUserapp> pspUserappList;

}

