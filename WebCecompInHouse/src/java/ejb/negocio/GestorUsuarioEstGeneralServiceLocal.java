/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.trazaMsg;
import entidades.DrtPersonanatural;
import javax.ejb.Local;


@Local
public interface GestorUsuarioEstGeneralServiceLocal {
    boolean validarEstGeneral(String dni, String pass);
    boolean existeEstGeneral(String dni);
    trazaMsg recuperarDatosEstGeneral(String dni);
    public DrtPersonanatural crearEntidad(DrtPersonanatural entidad);
    public DrtPersonanatural actualizarEntidad(DrtPersonanatural entidad) ;
    public DrtPersonanatural BuscarDni(String dni);
      public DrtPersonanatural recuperarIdEntidadDrtPersona(int id) ;


}
