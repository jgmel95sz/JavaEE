/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.DrtTipoPerUnsDAOLocal;
import entidades.DrtTipoPeruns;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class DrtTipoPerUnsService implements DrtTipoPerUnsServiceLocal {

    @EJB
    private DrtTipoPerUnsDAOLocal drtTipoPerUnsDAO;

    
    @Override
    public DrtTipoPeruns recuperarIdEntidad(int id) {
        return drtTipoPerUnsDAO.buscarPorId(id);
    }
 
    
}
