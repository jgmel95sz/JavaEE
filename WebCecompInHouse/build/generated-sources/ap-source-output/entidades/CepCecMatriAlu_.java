package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecMatriAlu.class)
public abstract class CepCecMatriAlu_ {

	public static volatile SingularAttribute<CepCecMatriAlu, DrtPersonanatural> drtPersonanatural;
	public static volatile SingularAttribute<CepCecMatriAlu, Short> estadoMatri;
	public static volatile SingularAttribute<CepCecMatriAlu, Date> fechaRegMa;
	public static volatile SingularAttribute<CepCecMatriAlu, String> codMatricula;
	public static volatile SingularAttribute<CepCecMatriAlu, Boolean> estadoAcademico;
	public static volatile SingularAttribute<CepCecMatriAlu, Integer> idMatriAlu;
	public static volatile ListAttribute<CepCecMatriAlu, CepCecMatriPago> cepCecMatriPagoList;
	public static volatile ListAttribute<CepCecMatriAlu, CepCecNotas> cepCecNotasList;
	public static volatile SingularAttribute<CepCecMatriAlu, Integer> tipoAlumno;
	public static volatile SingularAttribute<CepCecMatriAlu, Date> horaRegMa;
	public static volatile SingularAttribute<CepCecMatriAlu, CepCecCurGrup> cepCecCurGrup;
	public static volatile ListAttribute<CepCecMatriAlu, CepCecCertificado> cepCecCertificadoList;

}

