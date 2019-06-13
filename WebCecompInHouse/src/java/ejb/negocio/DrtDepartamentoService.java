/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.DrtDepartamentoDAOLocal;
import entidades.DrtDepartamento;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class DrtDepartamentoService implements DrtDepartamentoServiceLocal {

    @EJB
    private DrtDepartamentoDAOLocal drtDepartamentoDAO;
   
    @Override
    public DrtDepartamento recuperarIdDepartamento(int id) {
        return drtDepartamentoDAO.buscarPorId(id);
    }
 
    @Override
    public List<DrtDepartamento> listarTodos (){
      return drtDepartamentoDAO.buscarTodos();
    }
}
