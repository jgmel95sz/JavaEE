package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecExonerados.class)
public abstract class CepCecExonerados_ {

	public static volatile SingularAttribute<CepCecExonerados, Boolean> estadoExo;
	public static volatile SingularAttribute<CepCecExonerados, Date> fechaReg;
	public static volatile SingularAttribute<CepCecExonerados, Date> fechaVencimiento;
	public static volatile SingularAttribute<CepCecExonerados, Short> codAgencia;
	public static volatile SingularAttribute<CepCecExonerados, Date> fechaUso;
	public static volatile SingularAttribute<CepCecExonerados, String> secuencia;
	public static volatile SingularAttribute<CepCecExonerados, CepCecDescExonerados> cepCecDescExonerados;
	public static volatile SingularAttribute<CepCecExonerados, String> numResolucion;
	public static volatile SingularAttribute<CepCecExonerados, Integer> idExonerados;
	public static volatile SingularAttribute<CepCecExonerados, Date> fechaPago;
	public static volatile SingularAttribute<CepCecExonerados, Boolean> pagototal;

}

