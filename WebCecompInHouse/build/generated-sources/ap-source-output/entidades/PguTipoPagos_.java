package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PguTipoPagos.class)
public abstract class PguTipoPagos_ {

	public static volatile SingularAttribute<PguTipoPagos, Integer> idJerdep;
	public static volatile SingularAttribute<PguTipoPagos, PguGrupoTipospagos> pguGrupoTipospagos;
	public static volatile SingularAttribute<PguTipoPagos, Integer> idAmbito;
	public static volatile SingularAttribute<PguTipoPagos, Integer> idFacultad;
	public static volatile ListAttribute<PguTipoPagos, PguModalidadTipospagos> pguModalidadTipospagosList;
	public static volatile SingularAttribute<PguTipoPagos, OrgDependencia> orgDependencia;
	public static volatile SingularAttribute<PguTipoPagos, Integer> idCiclo;
	public static volatile SingularAttribute<PguTipoPagos, Float> precio;
	public static volatile SingularAttribute<PguTipoPagos, Integer> idAcper;
	public static volatile SingularAttribute<PguTipoPagos, String> concepto;
	public static volatile SingularAttribute<PguTipoPagos, Integer> idCurso;
	public static volatile SingularAttribute<PguTipoPagos, Integer> idTipopag;
	public static volatile SingularAttribute<PguTipoPagos, Short> orden;
	public static volatile SingularAttribute<PguTipoPagos, Integer> idEspecialidad;
	public static volatile SingularAttribute<PguTipoPagos, Short> anio;
	public static volatile SingularAttribute<PguTipoPagos, Boolean> activo;

}

