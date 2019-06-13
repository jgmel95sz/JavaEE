/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.SesionPlanDAOLocal;
import entidades.CepCecSesion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorSesionPlanService implements GestorSesionPlanServiceLocal {

    
    @EJB
    private SesionPlanDAOLocal sesionPlanDAO;

    @Override
    public List<CepCecSesion> buscarTodos(Integer idPlan) {
        System.out.println("ENTRO A NEGOCIO");
        return sesionPlanDAO.buscarTodos( idPlan);
    }
    
    @Override
    public CepCecSesion crearNuevaSesion(CepCecSesion sesion) {
        System.out.println("ENTRO NEGOCIO A CREAR SESION");
        return sesionPlanDAO.crear(sesion);
    }
    
  
    
    
    @Override
    public CepCecSesion recuperarIdSesion(int id) {
        return sesionPlanDAO.buscarPorId(id);
    }
    
      @Override
    public CepCecSesion actualizarSesion(CepCecSesion sesion) {
        return sesionPlanDAO.actualizar(sesion);
    }
    
    
}
