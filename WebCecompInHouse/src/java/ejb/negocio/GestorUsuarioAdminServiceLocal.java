/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.trazaMsg;
import entidades.PspUsuario;
import javax.ejb.Local;

/**
 *
 * @author Victor Lluen
 */
@Local
public interface GestorUsuarioAdminServiceLocal {
    boolean validarUsuario(String usuario, String idCard, String clave);
    PspUsuario buscarUsuario(String usuario,String idCard);
   PspUsuario buscarTrabajadorUNS(String idCard) ;
    public trazaMsg buscarTrabajadorUNSporDni(String dni);

    
}
