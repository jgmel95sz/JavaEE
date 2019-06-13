package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecHorarios.class)
public abstract class CepCecHorarios_ {

	public static volatile SingularAttribute<CepCecHorarios, Date> horaFin;
	public static volatile SingularAttribute<CepCecHorarios, Integer> idHorario;
	public static volatile SingularAttribute<CepCecHorarios, Date> horaIni;
	public static volatile SingularAttribute<CepCecHorarios, Short> estadoHorario;
	public static volatile SingularAttribute<CepCecHorarios, CepCecCurGrup> cepCecCurGrup;
	public static volatile SingularAttribute<CepCecHorarios, CepHorarioDias> cepHorarioDias;

}

