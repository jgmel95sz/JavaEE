/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.DrtDirectorioClaseDAOLocal;
import entidades.DrtDirectorioClase;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class DrtDirectorioClaseService implements DrtDirectorioClaseServiceLocal {

    @EJB
    private DrtDirectorioClaseDAOLocal drtDirectorioClaseDAO;

    @Override
    public DrtDirectorioClase recuperarIdDirectorioClase(short id) {
        return drtDirectorioClaseDAO.buscarPorId(id);
    }

    
}
