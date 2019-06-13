package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DrtProvincia.class)
public abstract class DrtProvincia_ {

	public static volatile ListAttribute<DrtProvincia, DrtDistrito> drtDistritoList;
	public static volatile SingularAttribute<DrtProvincia, DrtProvinciaPK> drtProvinciaPK;
	public static volatile SingularAttribute<DrtProvincia, String> nombreProv;
	public static volatile SingularAttribute<DrtProvincia, Integer> idProvI;
	public static volatile SingularAttribute<DrtProvincia, DrtDepartamento> drtDepartamento;
	public static volatile SingularAttribute<DrtProvincia, String> abreviaturaProv;
	public static volatile SingularAttribute<DrtProvincia, String> codigoProv;

}

