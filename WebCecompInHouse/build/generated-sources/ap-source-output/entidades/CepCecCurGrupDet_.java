package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecCurGrupDet.class)
public abstract class CepCecCurGrupDet_ {

	public static volatile SingularAttribute<CepCecCurGrupDet, Date> fechaI;
	public static volatile SingularAttribute<CepCecCurGrupDet, CepAulaClass> cepAulaClass;
	public static volatile SingularAttribute<CepCecCurGrupDet, Integer> idDir;
	public static volatile SingularAttribute<CepCecCurGrupDet, Date> fechaF;
	public static volatile SingularAttribute<CepCecCurGrupDet, Integer> idCurGrupDet;
	public static volatile SingularAttribute<CepCecCurGrupDet, Short> estadoCurGrupDet;
	public static volatile SingularAttribute<CepCecCurGrupDet, CepCecCurGrup> cepCecCurGrup;

}

