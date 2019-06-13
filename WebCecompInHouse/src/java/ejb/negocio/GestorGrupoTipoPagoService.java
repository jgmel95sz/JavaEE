/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.PguGrupoTipoPagoDAOLocal;
import entidades.PguGrupoTipospagos;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorGrupoTipoPagoService implements GestorGrupoTipoPagoServiceLocal {

    @EJB
    private PguGrupoTipoPagoDAOLocal PguGrupoTipospagos;

     @Override
    public PguGrupoTipospagos recuperarPguGrupoTipoPago(int id) {
        return PguGrupoTipospagos.buscarPorId(id);
    }
    
}
