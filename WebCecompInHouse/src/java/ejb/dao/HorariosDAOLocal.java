/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecHorarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface HorariosDAOLocal extends GenericoJPADAOLocal<CepCecHorarios> {
     List<CepCecHorarios> buscarTodos();
      List<CepCecHorarios> listarHorarioPorId(int id);
       public CepCecHorarios capturarHorarioPorId(Integer id);
}
