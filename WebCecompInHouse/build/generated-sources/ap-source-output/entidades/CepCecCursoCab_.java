package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecCursoCab.class)
public abstract class CepCecCursoCab_ {

	public static volatile SingularAttribute<CepCecCursoCab, Integer> idCursoCab;
	public static volatile ListAttribute<CepCecCursoCab, CepCecCursoDet> cepCecCursoDetList;
	public static volatile SingularAttribute<CepCecCursoCab, Short> estadoCabcur;
	public static volatile SingularAttribute<CepCecCursoCab, String> nomCurso;

}

