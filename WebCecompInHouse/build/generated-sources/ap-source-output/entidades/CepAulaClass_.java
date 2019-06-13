package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepAulaClass.class)
public abstract class CepAulaClass_ {

	public static volatile SingularAttribute<CepAulaClass, Integer> piso;
	public static volatile SingularAttribute<CepAulaClass, Integer> idDep;
	public static volatile SingularAttribute<CepAulaClass, String> nomAula;
	public static volatile ListAttribute<CepAulaClass, CepCecCurGrupDet> cepCecCurGrupDetList;
	public static volatile SingularAttribute<CepAulaClass, Integer> idAulClass;
	public static volatile SingularAttribute<CepAulaClass, String> lugar;
	public static volatile SingularAttribute<CepAulaClass, Integer> numAlu;
	public static volatile SingularAttribute<CepAulaClass, Character> condicion;

}

