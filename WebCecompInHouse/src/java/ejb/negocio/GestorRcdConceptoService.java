/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.RcdConceptoDAOLocal;
import entidades.RcdConcepto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorRcdConceptoService implements GestorRcdConceptoServiceLocal {

    @EJB
    private RcdConceptoDAOLocal rcdConceptoDAO;
 
    @Override
    public RcdConcepto recuperarRcdConcepto(int id) {
         
        return rcdConceptoDAO.buscarPorId(id);
    }
  
    @Override
    public List<RcdConcepto> buscarConceptosCecomp(){
       return rcdConceptoDAO.buscarConceptosCecomp();
    }
}
