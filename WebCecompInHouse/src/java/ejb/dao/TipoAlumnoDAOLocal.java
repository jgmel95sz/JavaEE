/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecTipAlumno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface TipoAlumnoDAOLocal extends GenericoJPADAOLocal<CepCecTipAlumno> {
     public List<CepCecTipAlumno> buscarTiposAlumnos();
}
