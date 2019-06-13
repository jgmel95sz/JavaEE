package entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecCertificado.class)
public abstract class CepCecCertificado_ {

	public static volatile SingularAttribute<CepCecCertificado, String> codDec;
	public static volatile SingularAttribute<CepCecCertificado, Date> fechaEmision;
	public static volatile SingularAttribute<CepCecCertificado, BigDecimal> notaFinalCur;
	public static volatile SingularAttribute<CepCecCertificado, CepCecMatriAlu> cepCecMatriAlu;
	public static volatile SingularAttribute<CepCecCertificado, Integer> idCertificado;
	public static volatile SingularAttribute<CepCecCertificado, Short> estadoCertif;

}

