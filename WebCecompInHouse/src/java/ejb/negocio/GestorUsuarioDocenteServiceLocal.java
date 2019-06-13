/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.DrtPersonanatural;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface GestorUsuarioDocenteServiceLocal {
   // boolean validarDocente(String dni, String pass);
   boolean validarUsuario(String usuario, String idCard, String clave);
     boolean validarSiEsDocente(int dir);
    boolean existeDocente(String dni);
    DrtPersonanatural recuperarDatosDocente(String dni);
    List<DrtPersonanatural> listarDocentes(String dni);
     DrtPersonanatural recuperarIdDocente(int id);
}