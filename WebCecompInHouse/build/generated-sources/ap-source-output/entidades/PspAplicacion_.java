package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PspAplicacion.class)
public abstract class PspAplicacion_ {

	public static volatile SingularAttribute<PspAplicacion, Short> stdApp;
	public static volatile SingularAttribute<PspAplicacion, String> etiqueta;
	public static volatile SingularAttribute<PspAplicacion, Short> pspApp;
	public static volatile SingularAttribute<PspAplicacion, Short> requerirDep;
	public static volatile SingularAttribute<PspAplicacion, String> pwd;
	public static volatile SingularAttribute<PspAplicacion, String> nombre;
	public static volatile ListAttribute<PspAplicacion, PspUserapp> pspUserappList;

}

