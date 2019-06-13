package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecMatriPago.class)
public abstract class CepCecMatriPago_ {

	public static volatile SingularAttribute<CepCecMatriPago, Integer> codConcepto;
	public static volatile SingularAttribute<CepCecMatriPago, Date> fechaRegMp;
	public static volatile SingularAttribute<CepCecMatriPago, Boolean> isPagototal;
	public static volatile SingularAttribute<CepCecMatriPago, PguPagospersCab> pguPagospersCab;
	public static volatile SingularAttribute<CepCecMatriPago, Integer> numCuota;
	public static volatile SingularAttribute<CepCecMatriPago, Integer> idMatriPago;
	public static volatile SingularAttribute<CepCecMatriPago, Integer> condicionAlu;
	public static volatile SingularAttribute<CepCecMatriPago, CepCecTipoMatri> cepCecTipoMatri;
	public static volatile SingularAttribute<CepCecMatriPago, Integer> idVoucherFicticio;
	public static volatile SingularAttribute<CepCecMatriPago, CepCecMatriAlu> cepCecMatriAlu;
	public static volatile SingularAttribute<CepCecMatriPago, Short> estadoMat;
	public static volatile SingularAttribute<CepCecMatriPago, Date> horaRegMp;

}

