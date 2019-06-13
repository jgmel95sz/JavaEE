/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.DrtPersonanatural;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface UsuarioDocenteDAOLocal extends GenericoJPADAOLocal<DrtPersonanatural>{
    DrtPersonanatural validarEstGeneral(String dni);
       //listar docentes
    

    List<DrtPersonanatural> listarDocente(String dni);
}