package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RcdTarifario.class)
public abstract class RcdTarifario_ {

	public static volatile SingularAttribute<RcdTarifario, Integer> idUndeje;
	public static volatile SingularAttribute<RcdTarifario, Short> tipoPersona;
	public static volatile SingularAttribute<RcdTarifario, Short> pagoParcial;
	public static volatile SingularAttribute<RcdTarifario, RcdConcepto> rcdConcepto;
	public static volatile SingularAttribute<RcdTarifario, Integer> idSituacest;
	public static volatile SingularAttribute<RcdTarifario, Integer> idTarifario;
	public static volatile SingularAttribute<RcdTarifario, Float> importe;
	public static volatile SingularAttribute<RcdTarifario, Short> condicion;

}

