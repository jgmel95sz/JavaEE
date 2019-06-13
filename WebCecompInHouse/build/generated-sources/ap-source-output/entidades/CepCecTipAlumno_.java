package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecTipAlumno.class)
public abstract class CepCecTipAlumno_ {

	public static volatile SingularAttribute<CepCecTipAlumno, String> nomAbrev;
	public static volatile SingularAttribute<CepCecTipAlumno, String> nomTipAlumno;
	public static volatile SingularAttribute<CepCecTipAlumno, Short> estadoTipAlumno;
	public static volatile ListAttribute<CepCecTipAlumno, CepCecInversionCurso> cepCecInversionCursoList;
	public static volatile SingularAttribute<CepCecTipAlumno, Integer> idTipAlumno;

}

