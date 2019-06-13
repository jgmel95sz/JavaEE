package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DrtPersonanatural.class)
public abstract class DrtPersonanatural_ {

	public static volatile SingularAttribute<DrtPersonanatural, Integer> updateFlow;
	public static volatile SingularAttribute<DrtPersonanatural, String> emailPrin;
	public static volatile SingularAttribute<DrtPersonanatural, Integer> idPnec;
	public static volatile SingularAttribute<DrtPersonanatural, Integer> idDir;
	public static volatile SingularAttribute<DrtPersonanatural, Date> fechaIng;
	public static volatile SingularAttribute<DrtPersonanatural, String> nombreCompleto;
	public static volatile SingularAttribute<DrtPersonanatural, String> telefonoPrin;
	public static volatile SingularAttribute<DrtPersonanatural, String> nombre;
	public static volatile SingularAttribute<DrtPersonanatural, Integer> idGrpsng;
	public static volatile SingularAttribute<DrtPersonanatural, String> apMaterno;
	public static volatile SingularAttribute<DrtPersonanatural, String> pswv;
	public static volatile SingularAttribute<DrtPersonanatural, DrtDirectorio> drtDirectorio;
	public static volatile SingularAttribute<DrtPersonanatural, Integer> idPdid;
	public static volatile SingularAttribute<DrtPersonanatural, String> apPaterno;
	public static volatile SingularAttribute<DrtPersonanatural, String> observacion;
	public static volatile SingularAttribute<DrtPersonanatural, String> numeroPndid;
	public static volatile SingularAttribute<DrtPersonanatural, String> celularPrin;
	public static volatile SingularAttribute<DrtPersonanatural, String> otroColegio;
	public static volatile ListAttribute<DrtPersonanatural, CepCecMatriAlu> cepCecMatriAluList;
	public static volatile SingularAttribute<DrtPersonanatural, String> direccion;
	public static volatile SingularAttribute<DrtPersonanatural, Integer> anioEgresoCole;
	public static volatile SingularAttribute<DrtPersonanatural, Integer> updateSelf;
	public static volatile SingularAttribute<DrtPersonanatural, Date> fechaNac;
	public static volatile SingularAttribute<DrtPersonanatural, DrtDistrito> drtDistrito1;
	public static volatile SingularAttribute<DrtPersonanatural, Character> estadoPernat;
	public static volatile SingularAttribute<DrtPersonanatural, DrtPernatUns> drtPernatUns;
	public static volatile SingularAttribute<DrtPersonanatural, String> pswa;
	public static volatile SingularAttribute<DrtPersonanatural, Character> sexo;
	public static volatile SingularAttribute<DrtPersonanatural, Integer> idColegio;
	public static volatile SingularAttribute<DrtPersonanatural, DrtDistrito> drtDistrito;
	public static volatile ListAttribute<DrtPersonanatural, FxaEstudiante> fxaEstudianteList;

}

