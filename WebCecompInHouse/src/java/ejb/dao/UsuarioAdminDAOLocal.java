/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.PspUsuario;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface UsuarioAdminDAOLocal extends GenericoJPADAOLocal<PspUsuario>{
    PspUsuario validarUsuario(String usuario, String idCard);
     PspUsuario validarTrabajadorUNS(String idCard);
    public PspUsuario validarDocente(String dni);
}
