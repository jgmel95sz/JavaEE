/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepNivel;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ejb.dao.CepNivelDAOLocal;

/**
 *
 * @author MELVN
 */
@Stateless
public class GestorCepNivelService implements GestorCepNivelServiceLocal {

    @EJB
    private CepNivelDAOLocal cepNivelDAO;

    @Override
    public List<CepNivel> buscarTodos() {
        return cepNivelDAO.buscarTodos();
    }

   
     @Override
    public CepNivel recuperarIdNivel(int id) {
        return cepNivelDAO.buscarPorId(id);
    }
    
}
