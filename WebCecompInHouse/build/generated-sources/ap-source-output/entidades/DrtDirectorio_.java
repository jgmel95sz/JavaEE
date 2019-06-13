package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DrtDirectorio.class)
public abstract class DrtDirectorio_ {

	public static volatile SingularAttribute<DrtDirectorio, DrtPersonanatural> drtPersonanatural;
	public static volatile SingularAttribute<DrtDirectorio, Integer> pspApp;
	public static volatile SingularAttribute<DrtDirectorio, Integer> idDir;
	public static volatile SingularAttribute<DrtDirectorio, Integer> pspUid;
	public static volatile SingularAttribute<DrtDirectorio, Short> pspCxt;
	public static volatile ListAttribute<DrtDirectorio, PspUsuario> pspUsuarioList;
	public static volatile SingularAttribute<DrtDirectorio, Date> dateinsert;
	public static volatile SingularAttribute<DrtDirectorio, DrtDirectorioClase> drtDirectorioClase;

}

