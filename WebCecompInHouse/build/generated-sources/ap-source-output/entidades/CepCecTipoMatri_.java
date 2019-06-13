package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CepCecTipoMatri.class)
public abstract class CepCecTipoMatri_ {

	public static volatile SingularAttribute<CepCecTipoMatri, Short> estadoTipoMatri;
	public static volatile SingularAttribute<CepCecTipoMatri, Integer> idTipoMatri;
	public static volatile SingularAttribute<CepCecTipoMatri, String> nomTipoMatri;
	public static volatile ListAttribute<CepCecTipoMatri, CepCecMatriPago> cepCecMatriPagoList;

}

