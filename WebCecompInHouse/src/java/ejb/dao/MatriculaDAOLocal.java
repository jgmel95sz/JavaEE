/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecMatriAlu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface MatriculaDAOLocal extends GenericoJPADAOLocal<CepCecMatriAlu> {
    public List<CepCecMatriAlu> buscarCursosEnProcesoPorAlumno(Integer id_dir);
     public List<CepCecMatriAlu> buscarCursosHistorialPorAlumno(Integer id_dir);
    public List<CepCecMatriAlu> buscarAlumnosMatriculados(int id_grupo);
}
