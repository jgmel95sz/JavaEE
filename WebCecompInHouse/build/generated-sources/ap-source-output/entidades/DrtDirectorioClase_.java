package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DrtDirectorioClase.class)
public abstract class DrtDirectorioClase_ {

	public static volatile SingularAttribute<DrtDirectorioClase, String> descripcion;
	public static volatile SingularAttribute<DrtDirectorioClase, String> abrevia;
	public static volatile SingularAttribute<DrtDirectorioClase, Short> idDclas;
	public static volatile SingularAttribute<DrtDirectorioClase, String> nombre;
	public static volatile ListAttribute<DrtDirectorioClase, DrtDirectorio> drtDirectorioList;

}

