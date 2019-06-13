package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecNotas.class)
public abstract class CepCecNotas_ {

	public static volatile SingularAttribute<CepCecNotas, Float> notaSubsanacion;
	public static volatile SingularAttribute<CepCecNotas, Date> fechaRn;
	public static volatile SingularAttribute<CepCecNotas, Float> nota1;
	public static volatile SingularAttribute<CepCecNotas, Float> nota4;
	public static volatile SingularAttribute<CepCecNotas, Float> notaFinal;
	public static volatile SingularAttribute<CepCecNotas, Float> nota2;
	public static volatile SingularAttribute<CepCecNotas, Float> nota3;
	public static volatile SingularAttribute<CepCecNotas, Integer> idNotas;
	public static volatile SingularAttribute<CepCecNotas, Boolean> estadoNotas;
	public static volatile SingularAttribute<CepCecNotas, Date> fechaModNota;
	public static volatile SingularAttribute<CepCecNotas, CepCecMatriAlu> cepCecMatriAlu;

}

