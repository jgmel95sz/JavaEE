/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

//import ejb.dao.DrtPernatUnsDAO;
import entidades.DrtPernatUns;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface DrtPernatUnsServiceLocal {

    public DrtPernatUns recuperarIdEntidad(int id);

    public DrtPernatUns crearEntidad(DrtPernatUns entidad);

    public DrtPernatUns actualizarEntidad(DrtPernatUns entidad);
}
