package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecInversionCurso.class)
public abstract class CepCecInversionCurso_ {

	public static volatile SingularAttribute<CepCecInversionCurso, String> descripcionInv;
	public static volatile ListAttribute<CepCecInversionCurso, CepCecDescExonerados> cepCecDescExoneradosList;
	public static volatile SingularAttribute<CepCecInversionCurso, Short> estadoInver;
	public static volatile SingularAttribute<CepCecInversionCurso, CepCecTipAlumno> cepCecTipAlumno;
	public static volatile SingularAttribute<CepCecInversionCurso, Boolean> unicoPagototal;
	public static volatile SingularAttribute<CepCecInversionCurso, RcdConcepto> rcdConcepto;
	public static volatile SingularAttribute<CepCecInversionCurso, String> nombreConcepto;
	public static volatile SingularAttribute<CepCecInversionCurso, Short> conceptoTotal;
	public static volatile SingularAttribute<CepCecInversionCurso, CepCecTipoInversion> cepCecTipoInversion;
	public static volatile SingularAttribute<CepCecInversionCurso, Integer> idInversion;
	public static volatile SingularAttribute<CepCecInversionCurso, CepCecCursoSubdet> cepCecCursoSubdet;
	public static volatile SingularAttribute<CepCecInversionCurso, Float> precioPension;
	public static volatile SingularAttribute<CepCecInversionCurso, Float> precioTotal;

}

