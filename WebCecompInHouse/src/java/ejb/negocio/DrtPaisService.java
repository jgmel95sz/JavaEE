/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.DrtPaisDAOLocal;
import entidades.DrtPais;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class DrtPaisService implements DrtPaisServiceLocal {

    @EJB
    private DrtPaisDAOLocal drtPaisDAO;

    @Override
    public DrtPais recuperarIdEntidad(int id) {
        return drtPaisDAO.buscarPorId(id);
    }
     
    
    

    
}
