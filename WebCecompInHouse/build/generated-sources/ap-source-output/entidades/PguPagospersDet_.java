package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PguPagospersDet.class)
public abstract class PguPagospersDet_ {

	public static volatile SingularAttribute<PguPagospersDet, PguOrigenPago> pguOrigenPago;
	public static volatile SingularAttribute<PguPagospersDet, Boolean> estado;
	public static volatile SingularAttribute<PguPagospersDet, String> nroOperacion;
	public static volatile SingularAttribute<PguPagospersDet, PguPagospersCab> pguPagospersCab;
	public static volatile SingularAttribute<PguPagospersDet, PguPagospersDetPK> pguPagospersDetPK;
	public static volatile SingularAttribute<PguPagospersDet, Integer> idEsc;
	public static volatile SingularAttribute<PguPagospersDet, String> observ;
	public static volatile SingularAttribute<PguPagospersDet, Date> fechaOper;
	public static volatile SingularAttribute<PguPagospersDet, Float> monto;
	public static volatile SingularAttribute<PguPagospersDet, PguBancoPago> pguBancoPago;
	public static volatile SingularAttribute<PguPagospersDet, Short> idMesd;
	public static volatile SingularAttribute<PguPagospersDet, Date> horaPago;
	public static volatile SingularAttribute<PguPagospersDet, PguModalidadTipospagos> pguModalidadTipospagos;

}

