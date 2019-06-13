package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PguModalidadTipospagos.class)
public abstract class PguModalidadTipospagos_ {

	public static volatile SingularAttribute<PguModalidadTipospagos, String> descripcion;
	public static volatile SingularAttribute<PguModalidadTipospagos, PguModalidad> pguModalidad;
	public static volatile SingularAttribute<PguModalidadTipospagos, Float> montoPagar;
	public static volatile SingularAttribute<PguModalidadTipospagos, Short> nrodiasMora;
	public static volatile SingularAttribute<PguModalidadTipospagos, Integer> idModltipo;
	public static volatile SingularAttribute<PguModalidadTipospagos, Float> nroPartes;
	public static volatile SingularAttribute<PguModalidadTipospagos, PguTipoPagos> pguTipoPagos;
	public static volatile SingularAttribute<PguModalidadTipospagos, Float> montoMora;
	public static volatile ListAttribute<PguModalidadTipospagos, PguPagospersDet> pguPagospersDetList;
	public static volatile SingularAttribute<PguModalidadTipospagos, Float> interes;
	public static volatile SingularAttribute<PguModalidadTipospagos, Boolean> activo;

}

