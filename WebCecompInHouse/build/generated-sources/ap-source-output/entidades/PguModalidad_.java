package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PguModalidad.class)
public abstract class PguModalidad_ {

	public static volatile SingularAttribute<PguModalidad, Float> nroUnid;
	public static volatile SingularAttribute<PguModalidad, Short> idUnidad;
	public static volatile SingularAttribute<PguModalidad, Integer> idModld;
	public static volatile SingularAttribute<PguModalidad, String> nombre;
	public static volatile SingularAttribute<PguModalidad, Boolean> activo;
	public static volatile ListAttribute<PguModalidad, PguModalidadTipospagos> pguModalidadTipospagosList;

}

