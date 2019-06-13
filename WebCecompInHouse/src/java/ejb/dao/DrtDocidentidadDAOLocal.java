/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.DrtDocidentidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface DrtDocidentidadDAOLocal extends GenericoJPADAOLocal<DrtDocidentidad> {
    public List<DrtDocidentidad> buscarTodos();
}
