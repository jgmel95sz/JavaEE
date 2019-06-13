package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PspGrupo.class)
public abstract class PspGrupo_ {

	public static volatile SingularAttribute<PspGrupo, Integer> gid;
	public static volatile SingularAttribute<PspGrupo, String> idGroup;
	public static volatile SingularAttribute<PspGrupo, Short> pspCxt;
	public static volatile ListAttribute<PspGrupo, PspGroupuser> pspGroupuserList;
	public static volatile SingularAttribute<PspGrupo, Short> stdGrp;
	public static volatile SingularAttribute<PspGrupo, String> nombre;
	public static volatile SingularAttribute<PspGrupo, Short> pspNivel;

}

