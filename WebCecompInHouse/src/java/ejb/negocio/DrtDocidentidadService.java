/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.DrtDocidentidadDAOLocal;
import entidades.DrtDocidentidad;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class DrtDocidentidadService implements DrtDocidentidadServiceLocal {

    @EJB
    private DrtDocidentidadDAOLocal drtDocidentidadDAO;

    @Override
    public DrtDocidentidad recuperarIdEntidad(int id) {
        return drtDocidentidadDAO.buscarPorId(id);
    }
  
    @Override
    public List<DrtDocidentidad> listarTipoDoc(){
        return drtDocidentidadDAO.buscarTodos();
    };
    
}
