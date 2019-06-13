package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DrtDepartamento.class)
public abstract class DrtDepartamento_ {

	public static volatile SingularAttribute<DrtDepartamento, DrtDepartamentoPK> drtDepartamentoPK;
	public static volatile SingularAttribute<DrtDepartamento, DrtPais> drtPais;
	public static volatile ListAttribute<DrtDepartamento, DrtProvincia> drtProvinciaList;
	public static volatile SingularAttribute<DrtDepartamento, String> abreviaturaDpto;
	public static volatile SingularAttribute<DrtDepartamento, String> nombreDpto;
	public static volatile SingularAttribute<DrtDepartamento, String> codigoDpto;

}

