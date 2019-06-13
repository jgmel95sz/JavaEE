package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecDescExonerados.class)
public abstract class CepCecDescExonerados_ {

	public static volatile SingularAttribute<CepCecDescExonerados, String> codAlumno;
	public static volatile SingularAttribute<CepCecDescExonerados, String> numDocumento;
	public static volatile SingularAttribute<CepCecDescExonerados, String> descripcionDes;
	public static volatile SingularAttribute<CepCecDescExonerados, Integer> idDir;
	public static volatile SingularAttribute<CepCecDescExonerados, Date> fechaRegMb;
	public static volatile SingularAttribute<CepCecDescExonerados, Date> fechaLimite;
	public static volatile ListAttribute<CepCecDescExonerados, CepCecExonerados> cepCecExoneradosList;
	public static volatile SingularAttribute<CepCecDescExonerados, Boolean> estadoDes;
	public static volatile SingularAttribute<CepCecDescExonerados, String> nomCompletosExo;
	public static volatile SingularAttribute<CepCecDescExonerados, Integer> idAluDesExo;
	public static volatile SingularAttribute<CepCecDescExonerados, CepCecInversionCurso> cepCecInversionCurso;

}

