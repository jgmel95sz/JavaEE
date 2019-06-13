/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepHorarioDias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface CepHorarioDiasDAOLocal extends GenericoJPADAOLocal<CepHorarioDias> {
    List<CepHorarioDias> buscarTodos();
     public Integer buscarRepeticion(String nomDias);
}
