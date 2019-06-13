/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecCurGrup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface CursoGrupoDAOLocal extends GenericoJPADAOLocal<CepCecCurGrup> {
     List<CepCecCurGrup> buscarTodos();
     public Integer findRegistroCursoSubDet(int id_cursubdet);
     public Integer compruebaSiPlanEstaAsignadoAhGrupo(Integer id_plan);
     public List<CepCecCurGrup> buscarPorFiltroCurso(int id_cursogeneral,int pageNumber);
      public List<CepCecCurGrup> buscarHistorico();
      public List<CepCecCurGrup> buscarHistoricoPorFiltroCurso(int id_cursogeneral);
      public long calculandoTotalRegistrosGrupo(int id_cursogeneral);
      public CepCecCurGrup validarNumeroDeGrupo(int id_cursodetallado,int id_grupo);
      
}
