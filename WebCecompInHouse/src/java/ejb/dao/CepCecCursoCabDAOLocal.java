/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecCursoCab;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface CepCecCursoCabDAOLocal extends GenericoJPADAOLocal<CepCecCursoCab>{
     // List<CepCecCursoCab> buscarNombres();
      Integer ValidarRepeticiones(String name_curso);
       List<CepCecCursoCab> buscarTodos(int pageNumber);
    public long calculandoTotalRegistrosNombresCab();
      List<CepCecCursoCab> buscarTodosNombres();
}