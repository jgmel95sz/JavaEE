package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PspUsuario.class)
public abstract class PspUsuario_ {

	public static volatile SingularAttribute<PspUsuario, String> idUser;
	public static volatile SingularAttribute<PspUsuario, Integer> uid;
	public static volatile SingularAttribute<PspUsuario, String> idTarjeta;
	public static volatile SingularAttribute<PspUsuario, Short> stdUid;
	public static volatile SingularAttribute<PspUsuario, String> tempData;
	public static volatile SingularAttribute<PspUsuario, DrtDirectorio> drtDirectorio;
	public static volatile ListAttribute<PspUsuario, PspGroupuser> pspGroupuserList;
	public static volatile ListAttribute<PspUsuario, PguPagospersCab> pguPagospersCabList;
	public static volatile SingularAttribute<PspUsuario, byte[]> pwd;
	public static volatile SingularAttribute<PspUsuario, String> config;

}

