/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecPlan;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface PlanDaoLocal extends GenericoJPADAOLocal<CepCecPlan> {

    List<CepCecPlan> buscarTodos();

    List<CepCecPlan> buscarUltimoPeriodo(Integer curso, Integer anio);

    CepCecPlan validarIdCursoDet(int id);

    CepCecPlan buscarPlanActual(int id);

    public List<CepCecPlan> buscarPlanes(int id,int pageNumber);
    
     public long calculandoTotalRegistrosPlanes(int id_curso_det);

}
