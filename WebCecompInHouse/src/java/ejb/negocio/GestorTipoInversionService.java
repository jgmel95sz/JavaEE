/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.tipoInversionDAOLocal;
import entidades.CepCecTipoInversion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorTipoInversionService implements GestorTipoInversionServiceLocal {

    @EJB
    private tipoInversionDAOLocal tipoInversionDAO;

    
    @Override
    public List<CepCecTipoInversion> buscarTiposInversion() {
        return tipoInversionDAO.buscarTiposInversion();
    }
    
    @Override
    public CepCecTipoInversion recuperartipoInversion(int id) {
        return tipoInversionDAO.buscarPorId(id);
    }
   
}
