/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.OrgDependenciaDAOLocal;
import entidades.OrgDependencia;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorOrgDependeciaService implements GestorOrgDependeciaServiceLocal {

    @EJB
    private OrgDependenciaDAOLocal orgDependenciaDAO;

     @Override
    public OrgDependencia recuperarOrgDependencia(Integer id) {
        return orgDependenciaDAO.buscarPorId(id);
    }
}
