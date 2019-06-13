package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecTema.class)
public abstract class CepCecTema_ {

	public static volatile SingularAttribute<CepCecTema, Integer> idTema;
	public static volatile SingularAttribute<CepCecTema, CepCecSesion> cepCecSesion;
	public static volatile SingularAttribute<CepCecTema, String> nomTema;
	public static volatile SingularAttribute<CepCecTema, Short> estadoTema;

}

