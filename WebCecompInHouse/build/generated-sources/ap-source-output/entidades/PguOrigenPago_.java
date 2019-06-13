package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PguOrigenPago.class)
public abstract class PguOrigenPago_ {

	public static volatile SingularAttribute<PguOrigenPago, Integer> idOrigenpag;
	public static volatile SingularAttribute<PguOrigenPago, String> nombre;
	public static volatile ListAttribute<PguOrigenPago, PguPagospersDet> pguPagospersDetList;
	public static volatile SingularAttribute<PguOrigenPago, Boolean> activo;

}

