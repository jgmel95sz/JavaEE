package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DrtTipoPeruns.class)
public abstract class DrtTipoPeruns_ {

	public static volatile SingularAttribute<DrtTipoPeruns, Integer> idTipoPeruns;
	public static volatile SingularAttribute<DrtTipoPeruns, String> nombreTipoPeruns;
	public static volatile SingularAttribute<DrtTipoPeruns, String> abreviaturaTipoPeruns;
	public static volatile SingularAttribute<DrtTipoPeruns, String> descripcionTipoPeruns;
	public static volatile SingularAttribute<DrtTipoPeruns, Character> vigenciaTipoPeruns;
	public static volatile ListAttribute<DrtTipoPeruns, DrtPernatUns> drtPernatUnsList;

}

