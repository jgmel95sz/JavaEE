package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DrtPais.class)
public abstract class DrtPais_ {

	public static volatile SingularAttribute<DrtPais, String> codigoPostal;
	public static volatile SingularAttribute<DrtPais, Integer> idPais;
	public static volatile SingularAttribute<DrtPais, String> abreviaturaPais;
	public static volatile ListAttribute<DrtPais, DrtDepartamento> drtDepartamentoList;
	public static volatile SingularAttribute<DrtPais, String> nombrePais;

}

