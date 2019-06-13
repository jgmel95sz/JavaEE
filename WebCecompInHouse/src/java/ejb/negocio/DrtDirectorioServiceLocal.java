/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.DrtDirectorio;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface DrtDirectorioServiceLocal {
     public DrtDirectorio recuperarIdEntidad(int id);
     public DrtDirectorio crearEntidad(DrtDirectorio entidad);
     public DrtDirectorio actualizarEntidad(DrtDirectorio entidad) ;
}
