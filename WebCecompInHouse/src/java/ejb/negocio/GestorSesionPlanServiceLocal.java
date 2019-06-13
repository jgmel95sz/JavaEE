/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepCecSesion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorSesionPlanServiceLocal {
     public List<CepCecSesion> buscarTodos(Integer idPlan);
     public CepCecSesion crearNuevaSesion(CepCecSesion sesion);
     public CepCecSesion recuperarIdSesion(int id);
      public CepCecSesion actualizarSesion(CepCecSesion sesion);
}
