package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepTipoDesarrollo.class)
public abstract class CepTipoDesarrollo_ {

	public static volatile SingularAttribute<CepTipoDesarrollo, String> nomTipoDes;
	public static volatile ListAttribute<CepTipoDesarrollo, CepCecCursoSubdet> cepCecCursoSubdetList;
	public static volatile SingularAttribute<CepTipoDesarrollo, Integer> numCepTipoDes;
	public static volatile SingularAttribute<CepTipoDesarrollo, Integer> idTipoDes;
	public static volatile SingularAttribute<CepTipoDesarrollo, Short> estadoTipoDes;

}

