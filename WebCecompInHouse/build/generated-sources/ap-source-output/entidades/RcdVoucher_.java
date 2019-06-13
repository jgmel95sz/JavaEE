package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RcdVoucher.class)
public abstract class RcdVoucher_ {

	public static volatile SingularAttribute<RcdVoucher, String> codAlumno;
	public static volatile SingularAttribute<RcdVoucher, String> numDocumento;
	public static volatile SingularAttribute<RcdVoucher, Boolean> estado;
	public static volatile SingularAttribute<RcdVoucher, Short> tipoPersona;
	public static volatile SingularAttribute<RcdVoucher, Short> codCajero;
	public static volatile SingularAttribute<RcdVoucher, String> nombre;
	public static volatile SingularAttribute<RcdVoucher, Integer> numCheque;
	public static volatile SingularAttribute<RcdVoucher, Short> codUnidadRecaudadora;
	public static volatile SingularAttribute<RcdVoucher, String> cuenta;
	public static volatile SingularAttribute<RcdVoucher, Short> sede;
	public static volatile SingularAttribute<RcdVoucher, Integer> secuencia;
	public static volatile SingularAttribute<RcdVoucher, RcdConcepto> rcdConcepto;
	public static volatile SingularAttribute<RcdVoucher, Short> condicion;
	public static volatile SingularAttribute<RcdVoucher, Date> fechaPago;
	public static volatile SingularAttribute<RcdVoucher, Short> tipoDocumento;
	public static volatile SingularAttribute<RcdVoucher, Date> fechaEnvio;
	public static volatile SingularAttribute<RcdVoucher, Integer> idAcper;
	public static volatile SingularAttribute<RcdVoucher, Integer> situacion;
	public static volatile SingularAttribute<RcdVoucher, Short> codAgencia;
	public static volatile SingularAttribute<RcdVoucher, Date> fechaUso;
	public static volatile SingularAttribute<RcdVoucher, Short> tipoPago;
	public static volatile SingularAttribute<RcdVoucher, Integer> idVoucher;
	public static volatile SingularAttribute<RcdVoucher, Short> formaPago;
	public static volatile SingularAttribute<RcdVoucher, Date> horaPago;
	public static volatile SingularAttribute<RcdVoucher, Float> importePagado;
	public static volatile SingularAttribute<RcdVoucher, Short> codBanco;

}

