/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.FxaEstudiante;
import javax.ejb.Local;


@Local
public interface UsuarioEstDAOLocal extends GenericoJPADAOLocal<FxaEstudiante> {
    FxaEstudiante validarEstudiante(String codigo, String dni);
    FxaEstudiante buscarAlumno(String codigo);
    public boolean buscarPersonaEnAlumnosUNS(String dni);
}
