package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PguBancoPago.class)
public abstract class PguBancoPago_ {

	public static volatile SingularAttribute<PguBancoPago, Integer> idBanco;
	public static volatile SingularAttribute<PguBancoPago, String> abrev;
	public static volatile SingularAttribute<PguBancoPago, String> nombre;
	public static volatile ListAttribute<PguBancoPago, PguPagospersDet> pguPagospersDetList;
	public static volatile SingularAttribute<PguBancoPago, Boolean> activo;

}

