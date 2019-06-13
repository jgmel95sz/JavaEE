package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecSesion.class)
public abstract class CepCecSesion_ {

	public static volatile SingularAttribute<CepCecSesion, CepCecPlan> cepCecPlan;
	public static volatile SingularAttribute<CepCecSesion, Integer> idSesion;
	public static volatile SingularAttribute<CepCecSesion, Short> estadoSesion;
	public static volatile SingularAttribute<CepCecSesion, String> nomSesion;
	public static volatile ListAttribute<CepCecSesion, CepCecTema> cepCecTemaList;

}

