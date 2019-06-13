package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecCronogramaDet.class)
public abstract class CepCecCronogramaDet_ {

	public static volatile SingularAttribute<CepCecCronogramaDet, Integer> idCronogramaDet;
	public static volatile SingularAttribute<CepCecCronogramaDet, String> descripcionCro;
	public static volatile SingularAttribute<CepCecCronogramaDet, Short> estadoCroDet;
	public static volatile SingularAttribute<CepCecCronogramaDet, Date> fechaFinCro;
	public static volatile SingularAttribute<CepCecCronogramaDet, Integer> tipoCronograma;
	public static volatile SingularAttribute<CepCecCronogramaDet, Date> horaIniCro;
	public static volatile SingularAttribute<CepCecCronogramaDet, Date> horaFinCro;
	public static volatile SingularAttribute<CepCecCronogramaDet, Date> fechaRegCro;
	public static volatile SingularAttribute<CepCecCronogramaDet, CepCecCronogramaCab> cepCecCronogramaCab;
	public static volatile SingularAttribute<CepCecCronogramaDet, Date> fechaModCro;
	public static volatile SingularAttribute<CepCecCronogramaDet, Date> fechaIniCro;

}

