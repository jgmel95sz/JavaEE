/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecSesion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface SesionPlanDAOLocal extends GenericoJPADAOLocal<CepCecSesion> {
    List<CepCecSesion> buscarTodos(Integer idplancito);

}
