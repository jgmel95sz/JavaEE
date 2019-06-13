package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecPlan.class)
public abstract class CepCecPlan_ {

	public static volatile SingularAttribute<CepCecPlan, Integer> idPlan;
	public static volatile SingularAttribute<CepCecPlan, Integer> numPeriodo;
	public static volatile SingularAttribute<CepCecPlan, Boolean> planActual;
	public static volatile SingularAttribute<CepCecPlan, Date> fechaReg;
	public static volatile SingularAttribute<CepCecPlan, CepCecCursoDet> cepCecCursoDet;
	public static volatile SingularAttribute<CepCecPlan, String> detalles;
	public static volatile SingularAttribute<CepCecPlan, Short> estadoPlan;
	public static volatile ListAttribute<CepCecPlan, CepCecSesion> cepCecSesionList;
	public static volatile SingularAttribute<CepCecPlan, Integer> anio;

}

