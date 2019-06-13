/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;


import ejb.dao.TipoDesarrolloDAOLocal;
import entidades.CepTipoDesarrollo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author MELVN
 */
@Stateless
public class GestorTipoDesarrolloService implements GestorTipoDesarrolloServiceLocal {

    @EJB
    private TipoDesarrolloDAOLocal tipoDesarrolloDAO;

    @Override
    public List<CepTipoDesarrollo> buscarTodos() {
        return tipoDesarrolloDAO.buscarTodos();
    }
    
     @Override
    public CepTipoDesarrollo recuperarIdTipoDes(int id) {
        return tipoDesarrolloDAO.buscarPorId(id);
    }
    
}
