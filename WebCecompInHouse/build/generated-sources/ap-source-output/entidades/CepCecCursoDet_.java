package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecCursoDet.class)
public abstract class CepCecCursoDet_ {

	public static volatile SingularAttribute<CepCecCursoDet, Integer> idCursoDet;
	public static volatile SingularAttribute<CepCecCursoDet, CepNivel> cepNivel;
	public static volatile ListAttribute<CepCecCursoDet, CepCecCursoSubdet> cepCecCursoSubdetList;
	public static volatile SingularAttribute<CepCecCursoDet, Integer> modEnsenanza;
	public static volatile SingularAttribute<CepCecCursoDet, CepCecCursoCab> cepCecCursoCab;
	public static volatile SingularAttribute<CepCecCursoDet, Short> estadoCursoDet;
	public static volatile SingularAttribute<CepCecCursoDet, Integer> horasLectivas;
	public static volatile ListAttribute<CepCecCursoDet, CepCecPlan> cepCecPlanList;

}

