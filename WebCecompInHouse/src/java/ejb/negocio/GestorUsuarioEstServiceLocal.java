/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.trazaMsg;
import entidades.FxaEstudiante;
import javax.ejb.Local;

/**
 *
 * @author Victor Lluen
 */
@Local
public interface GestorUsuarioEstServiceLocal {
    boolean validarAlumno(String codigo, String dni, String clave);
    boolean existeAlumno(String codigo, String dni);
    FxaEstudiante recuperarDatosUsuario(String codigo,String dni);
    trazaMsg buscarAlumno(String codigo);
    
}
