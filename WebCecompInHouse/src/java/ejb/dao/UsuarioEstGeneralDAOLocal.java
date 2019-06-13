/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import clases.trazaMsg;
import entidades.DrtPersonanatural;
import javax.ejb.Local;


@Local
public interface UsuarioEstGeneralDAOLocal extends GenericoJPADAOLocal<DrtPersonanatural>{
    DrtPersonanatural validarEstGeneral(String dni);
    public String buscarDni(Integer dir); 
   public DrtPersonanatural CompararDni(String dni) ;
}
