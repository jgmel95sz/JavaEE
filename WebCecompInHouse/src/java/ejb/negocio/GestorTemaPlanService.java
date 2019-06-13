/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.TemaPlanDAOLocal;
import entidades.CepCecTema;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorTemaPlanService implements GestorTemaPlanServiceLocal {

    @EJB
    private TemaPlanDAOLocal temaPlanDAO;

    // va a buscar los temas por sesion
    @Override
    public List<CepCecTema> buscarTodos(int idSesion) {
        System.out.println("ENTRO A NEGOCIO TEMA ");
        return temaPlanDAO.buscarTodos(idSesion);
    }
    
    @Override
    public CepCecTema crearNuevaTema(CepCecTema tema) {
        System.out.println("ENTRO NEGOCIO A CREAR TEMA");
        return temaPlanDAO.crear(tema);
    }
    
    @Override
    public CepCecTema actualizarTema(CepCecTema tema) {
        return temaPlanDAO.actualizar(tema);
    }
    
     @Override
    public CepCecTema recuperarIdSesion(int id) {
        return temaPlanDAO.buscarPorId(id);
    }
}
