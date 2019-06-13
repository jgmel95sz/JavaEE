/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.TipoModalidadDAOLocal;
import entidades.CepEscalaTipomod;
import entidades.CepTipoDesarrollo;
import entidades.CepTipoModalidad;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author MELVN
 */
@Stateless
public class GestorTipoModalidad implements GestorTipoModalidadLocal {

    @EJB
    private TipoModalidadDAOLocal tipoModalidadDAO;

    
    @Override
    public List<CepTipoModalidad> buscarTodos() {
      
        
        return tipoModalidadDAO.buscarTodos();
        
        
    }

    @Override
    public CepTipoModalidad recuperarIdTipoMod(int id) {
        return tipoModalidadDAO.buscarPorId(id);
    }
    
}
