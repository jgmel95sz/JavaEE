/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.DrtDirectorioDAOLocal;
import entidades.DrtDirectorio;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class DrtDirectorioService implements DrtDirectorioServiceLocal {

    @EJB
    private DrtDirectorioDAOLocal drtDirectorioDAO;

    @Override
    public DrtDirectorio recuperarIdEntidad(int id) {
        return drtDirectorioDAO.buscarPorId(id);
    }
 
    @Override
    public DrtDirectorio crearEntidad(DrtDirectorio entidad) {
        return drtDirectorioDAO.crear(entidad);
    }
    
    @Override
    public DrtDirectorio actualizarEntidad(DrtDirectorio entidad) {
        return drtDirectorioDAO.actualizar(entidad);
    }
    
    
}
