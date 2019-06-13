/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecCursoSubdet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface CursoSubDetalleDAOLocal extends GenericoJPADAOLocal<CepCecCursoSubdet> {
      List<CepCecCursoSubdet> buscarTodos();
      public List<CepCecCursoSubdet> buscarPorFiltro(int id_curso_det);
      public CepCecCursoSubdet validarIdEscala(int id);
      public Integer validarRepeticiones(int id_desarrollo,int id_escala,int id_curdet);
}
