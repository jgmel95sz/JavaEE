package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrgDependencia.class)
public abstract class OrgDependencia_ {

	public static volatile SingularAttribute<OrgDependencia, String> depEstado;
	public static volatile SingularAttribute<OrgDependencia, Integer> idDep;
	public static volatile SingularAttribute<OrgDependencia, Integer> codigoDep;
	public static volatile SingularAttribute<OrgDependencia, String> anexo;
	public static volatile SingularAttribute<OrgDependencia, String> nombreDep;
	public static volatile SingularAttribute<OrgDependencia, String> abreviaDep;
	public static volatile SingularAttribute<OrgDependencia, Integer> orgIdDep;
	public static volatile SingularAttribute<OrgDependencia, Integer> idDepTipo;
	public static volatile SingularAttribute<OrgDependencia, String> jerarqDep;
	public static volatile SingularAttribute<OrgDependencia, String> sitioweb;
	public static volatile SingularAttribute<OrgDependencia, String> subdep;
	public static volatile SingularAttribute<OrgDependencia, Integer> idDtra;
	public static volatile SingularAttribute<OrgDependencia, Date> fechaReg;
	public static volatile SingularAttribute<OrgDependencia, String> descDep;
	public static volatile SingularAttribute<OrgDependencia, String> tmp;
	public static volatile ListAttribute<OrgDependencia, PguTipoPagos> pguTipoPagosList;
	public static volatile SingularAttribute<OrgDependencia, Integer> idUbi;
	public static volatile SingularAttribute<OrgDependencia, String> telefono1;
	public static volatile SingularAttribute<OrgDependencia, String> telefono2;
	public static volatile SingularAttribute<OrgDependencia, String> email;
	public static volatile SingularAttribute<OrgDependencia, Integer> idOrg;

}

