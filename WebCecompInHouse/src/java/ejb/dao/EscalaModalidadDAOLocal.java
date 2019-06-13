/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepEscalaTipomod;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface EscalaModalidadDAOLocal extends GenericoJPADAOLocal<CepEscalaTipomod>{
    
    List<CepEscalaTipomod> buscarTodos();
    public Integer buscarRepeticion(int id_modalidad,String escala, int cantidad);

}
