/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.InversionCurso;
import entidades.PguTipoPagos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorTipoPagosServiceLocal {
    public PguTipoPagos crearNuevoTipoPago(PguTipoPagos entidad);
         public List<PguTipoPagos> buscarTodosConceptosCecomp(String name);
         PguTipoPagos capturarPrecio(Integer idTipPag);
         public PguTipoPagos recuperarIdTipPag(int id);
        public PguTipoPagos buscarConcepto(InversionCurso inversion);
}
