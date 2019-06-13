/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.PguModalidadTipospagos;
import entidades.PguTipoPagos;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorPguModalidadTipoPagoServiceLocal {
      public PguModalidadTipospagos crearNuevoModalidadTipago(PguModalidadTipospagos entidad);
       public PguModalidadTipospagos actualizarNuevoModalidadTipago(PguModalidadTipospagos entidad);
       public PguModalidadTipospagos buscarModalidadPago(PguTipoPagos tipopagos);
}
