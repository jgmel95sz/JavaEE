/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.GrupoDAOLocal;
import entidades.CepCecGrupo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author MELVN
 */
@Stateless
public class GestorGrupoService implements GestorGrupoServiceLocal {

    @EJB
    private GrupoDAOLocal grupoDAO;
// LLama a a la funcion buscar todos en el Dao 
    @Override
    public List<CepCecGrupo> buscarTodos() {
        return grupoDAO.buscarTodos();
    }
    
      @Override
    public CepCecGrupo recuperarIdSeccion(int id) {
        return grupoDAO.buscarPorId(id);
    }
     
}
