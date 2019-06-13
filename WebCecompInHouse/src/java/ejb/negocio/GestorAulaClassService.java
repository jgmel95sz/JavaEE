/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.AulaClassDAOLocal;
import entidades.CepAulaClass;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author MELVN
 */
@Stateless
public class GestorAulaClassService implements GestorAulaClassServiceLocal {

    @EJB
    private AulaClassDAOLocal aulaClassDAO;
    
    // LLama a a la funcion buscar todos en el Dao 
    @Override
    public List<CepAulaClass> buscarTodos() {
        return aulaClassDAO.buscarTodos();
    }
    
     @Override
    public CepAulaClass recuperarIdAula(int id) {
        return aulaClassDAO.buscarPorId(id);
    }
    
}
