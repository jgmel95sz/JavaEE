package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PguPagospersCab.class)
public abstract class PguPagospersCab_ {

	public static volatile SingularAttribute<PguPagospersCab, Date> fecha;
	public static volatile SingularAttribute<PguPagospersCab, PspUsuario> pspUsuario;
	public static volatile SingularAttribute<PguPagospersCab, Integer> idDep;
	public static volatile SingularAttribute<PguPagospersCab, Float> mora;
	public static volatile SingularAttribute<PguPagospersCab, Boolean> estado;
	public static volatile SingularAttribute<PguPagospersCab, Integer> idDir;
	public static volatile ListAttribute<PguPagospersCab, CepCecMatriPago> cepCecMatriPagoList;
	public static volatile SingularAttribute<PguPagospersCab, Float> saldo;
	public static volatile SingularAttribute<PguPagospersCab, Integer> idNumpago;
	public static volatile SingularAttribute<PguPagospersCab, String> observacion;
	public static volatile ListAttribute<PguPagospersCab, PguPagospersDet> pguPagospersDetList;

}

