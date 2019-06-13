package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecCursoSubdet.class)
public abstract class CepCecCursoSubdet_ {

	public static volatile SingularAttribute<CepCecCursoSubdet, Integer> maxAlum;
	public static volatile ListAttribute<CepCecCursoSubdet, CepCecCurGrup> cepCecCurGrupList;
	public static volatile SingularAttribute<CepCecCursoSubdet, Short> estadoDetcur;
	public static volatile SingularAttribute<CepCecCursoSubdet, Integer> numClases;
	public static volatile SingularAttribute<CepCecCursoSubdet, CepEscalaTipomod> cepEscalaTipomod;
	public static volatile SingularAttribute<CepCecCursoSubdet, Integer> minAlum;
	public static volatile SingularAttribute<CepCecCursoSubdet, Integer> idCursoSubdet;
	public static volatile ListAttribute<CepCecCursoSubdet, CepCecInversionCurso> cepCecInversionCursoList;
	public static volatile SingularAttribute<CepCecCursoSubdet, CepCecCursoDet> cepCecCursoDet;
	public static volatile SingularAttribute<CepCecCursoSubdet, CepTipoDesarrollo> cepTipoDesarrollo;
	public static volatile SingularAttribute<CepCecCursoSubdet, Integer> formaPago;
	public static volatile SingularAttribute<CepCecCursoSubdet, Integer> numCuotas;

}

