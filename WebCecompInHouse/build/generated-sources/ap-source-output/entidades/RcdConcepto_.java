package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RcdConcepto.class)
public abstract class RcdConcepto_ {

	public static volatile SingularAttribute<RcdConcepto, String> tipo;
	public static volatile ListAttribute<RcdConcepto, RcdTarifario> rcdTarifarioList;
	public static volatile SingularAttribute<RcdConcepto, Integer> idConcepto;
	public static volatile SingularAttribute<RcdConcepto, Integer> idPartida1;
	public static volatile ListAttribute<RcdConcepto, CepCecInversionCurso> cepCecInversionCursoList;
	public static volatile SingularAttribute<RcdConcepto, Integer> idPartida2;
	public static volatile SingularAttribute<RcdConcepto, String> nombre;
	public static volatile SingularAttribute<RcdConcepto, Short> condicion;
	public static volatile ListAttribute<RcdConcepto, RcdVoucher> rcdVoucherList;

}

