/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.DrtProvinciaDAOLocal;
import entidades.DrtProvincia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class DrtProvinciaService implements DrtProvinciaServiceLocal {

    @EJB
    private DrtProvinciaDAOLocal drtProvinciaDAO;

    @Override
    public DrtProvincia recuperarIdEntidad(int id) {
        return drtProvinciaDAO.buscarPorId(id);
    }
    
    @Override
    public List<DrtProvincia> buscarTodos(Integer pais,Integer departamento){
        return drtProvinciaDAO.buscarTodos(pais, departamento);
    }
      
    
   
    
}
