/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.DrtDistritoDAOLocal;
import entidades.DrtDistrito;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class DrtDistritoService implements DrtDistritoServiceLocal {

    @EJB
    private DrtDistritoDAOLocal drtDistritoDAO;

    
    @Override
    public DrtDistrito recuperarIdEntidad(int id) {
        return drtDistritoDAO.buscarPorId(id);
    }
    
   @Override
    public List<DrtDistrito> buscarTodos(Integer pais,Integer departamento,Integer provincia){
      return  drtDistritoDAO.buscarTodos(pais, departamento, provincia);
    }
   
    @Override
    public DrtDistrito buscarEntidadNull(){
      return  drtDistritoDAO.buscarEntidadNull();
    };
    
   
}
