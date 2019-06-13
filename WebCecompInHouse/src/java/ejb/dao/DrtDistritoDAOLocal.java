/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.DrtDistrito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface DrtDistritoDAOLocal extends GenericoJPADAOLocal<DrtDistrito>{
    
    public List<DrtDistrito> buscarTodos(Integer pais,Integer departamento,Integer provincia);
    public DrtDistrito buscarEntidadNull();
}
