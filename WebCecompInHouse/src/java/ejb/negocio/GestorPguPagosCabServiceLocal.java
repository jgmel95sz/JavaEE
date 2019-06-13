/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.PguPagospersCab;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorPguPagosCabServiceLocal {

    public PguPagospersCab crearNuevoPagoCab(Integer id_dir);

    public Date obtenerFechaActual();

    public PguPagospersCab actualizarPguCab(PguPagospersCab plan);

    public PguPagospersCab recuperarPguCab(int id);
}
