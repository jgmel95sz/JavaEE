package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PguGrupoTipospagos.class)
public abstract class PguGrupoTipospagos_ {

	public static volatile SingularAttribute<PguGrupoTipospagos, Integer> idGrupopag;
	public static volatile ListAttribute<PguGrupoTipospagos, PguTipoPagos> pguTipoPagosList;
	public static volatile SingularAttribute<PguGrupoTipospagos, String> nombre;
	public static volatile SingularAttribute<PguGrupoTipospagos, Boolean> activo;

}

