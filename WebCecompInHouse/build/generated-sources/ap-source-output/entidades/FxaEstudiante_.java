package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FxaEstudiante.class)
public abstract class FxaEstudiante_ {

	public static volatile SingularAttribute<FxaEstudiante, String> passEnc;
	public static volatile SingularAttribute<FxaEstudiante, Short> promocionId;
	public static volatile SingularAttribute<FxaEstudiante, Short> idAmbito;
	public static volatile SingularAttribute<FxaEstudiante, Short> cicloNumero;
	public static volatile SingularAttribute<FxaEstudiante, Date> dateinsert;
	public static volatile SingularAttribute<FxaEstudiante, String> passVerifica;
	public static volatile SingularAttribute<FxaEstudiante, DrtPersonanatural> drtPersonanatural;
	public static volatile SingularAttribute<FxaEstudiante, Boolean> migrado;
	public static volatile SingularAttribute<FxaEstudiante, String> codNivAcad;
	public static volatile SingularAttribute<FxaEstudiante, Integer> idPlancur;
	public static volatile SingularAttribute<FxaEstudiante, Integer> idAcexp;
	public static volatile SingularAttribute<FxaEstudiante, String> situacion;
	public static volatile SingularAttribute<FxaEstudiante, String> codSitAcad;
	public static volatile SingularAttribute<FxaEstudiante, Character> promSeccion;
	public static volatile SingularAttribute<FxaEstudiante, Integer> idEspecialidad;
	public static volatile SingularAttribute<FxaEstudiante, Boolean> anulado;
	public static volatile SingularAttribute<FxaEstudiante, String> codigoEstudiante;
	public static volatile SingularAttribute<FxaEstudiante, Boolean> activo;

}

