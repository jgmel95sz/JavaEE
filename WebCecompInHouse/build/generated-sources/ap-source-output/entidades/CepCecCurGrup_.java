package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecCurGrup.class)
public abstract class CepCecCurGrup_ {

	public static volatile SingularAttribute<CepCecCurGrup, Boolean> estadoAcademico;
	public static volatile ListAttribute<CepCecCurGrup, CepCecMatriAlu> cepCecMatriAluList;
	public static volatile ListAttribute<CepCecCurGrup, CepCecCurGrupDet> cepCecCurGrupDetList;
	public static volatile ListAttribute<CepCecCurGrup, CepCecCronogramaCab> cepCecCronogramaCabList;
	public static volatile SingularAttribute<CepCecCurGrup, Date> fechaFin;
	public static volatile SingularAttribute<CepCecCurGrup, Integer> idPlan;
	public static volatile ListAttribute<CepCecCurGrup, CepCecHorarios> cepCecHorariosList;
	public static volatile SingularAttribute<CepCecCurGrup, CepCecCursoSubdet> cepCecCursoSubdet;
	public static volatile SingularAttribute<CepCecCurGrup, Integer> idCurGrup;
	public static volatile SingularAttribute<CepCecCurGrup, Date> fechaInicio;
	public static volatile SingularAttribute<CepCecCurGrup, Date> regFechafinacademico;
	public static volatile SingularAttribute<CepCecCurGrup, CepCecGrupo> cepCecGrupo;
	public static volatile SingularAttribute<CepCecCurGrup, Short> estadoGrupoCab;

}

