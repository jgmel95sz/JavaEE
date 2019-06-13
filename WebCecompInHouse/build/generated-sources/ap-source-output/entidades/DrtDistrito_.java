package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DrtDistrito.class)
public abstract class DrtDistrito_ {

	public static volatile SingularAttribute<DrtDistrito, String> ubigeoActualizado;
	public static volatile SingularAttribute<DrtDistrito, DrtProvincia> drtProvincia;
	public static volatile SingularAttribute<DrtDistrito, String> abreviaturaDist;
	public static volatile ListAttribute<DrtDistrito, DrtPersonanatural> drtPersonanaturalList;
	public static volatile ListAttribute<DrtDistrito, DrtPersonanatural> drtPersonanaturalList1;
	public static volatile SingularAttribute<DrtDistrito, DrtDistritoPK> drtDistritoPK;
	public static volatile SingularAttribute<DrtDistrito, Integer> idUbg;
	public static volatile SingularAttribute<DrtDistrito, String> codigoDist;
	public static volatile SingularAttribute<DrtDistrito, String> nombreDist;

}

