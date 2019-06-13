/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.PguModalidadTipospagos;
import entidades.PguPagospersCab;
import entidades.PguPagospersDet;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorPguPagoDetServiceLocal {
    public PguPagospersDet crearNuevoPagoDet(PguPagospersCab pguPagosCab,PguModalidadTipospagos modtipago,Date fecha_pago,Integer secuencia,Float monto ) ;
    public PguPagospersDet buscarPagoPorAlumnoMatriculado(Integer id_pgucab);
    public PguPagospersDet actualizarPguDet(PguPagospersDet entidad);
}
