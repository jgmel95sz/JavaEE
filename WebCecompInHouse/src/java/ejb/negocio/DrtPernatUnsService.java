/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

//import ejb.dao.DrtPernatUnsDAO;
import ejb.dao.DrtPernatUnsDAOLocal;
import entidades.DrtPernatUns;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class DrtPernatUnsService implements DrtPernatUnsServiceLocal {

    @EJB
    private DrtPernatUnsDAOLocal drtPernatUnsDAO;

    @Override
    public DrtPernatUns recuperarIdEntidad(int id) {
        return drtPernatUnsDAO.buscarPorId(id);
    }
    
        @Override
    public DrtPernatUns crearEntidad(DrtPernatUns entidad) {
        return drtPernatUnsDAO.crear(entidad);
    }
    
    @Override
    public DrtPernatUns actualizarEntidad(DrtPernatUns entidad) {
        return drtPernatUnsDAO.actualizar(entidad);
    }
    
    

}
