/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.InversionCurso;
import entidades.CepCecCurGrup;
import entidades.CepCecMatriAlu;
import entidades.DrtPersonanatural;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorMatriculaAluServiceLocal {
    
    public CepCecMatriAlu recuperarEntidadMatriAlu(int id);
    public CepCecMatriAlu crearMatriAlu(CepCecCurGrup cepCecCurGrup,DrtPersonanatural drtPersonanatural,Integer tipo_alumno);
    public List<CepCecMatriAlu> buscarCursosEnProcesoPorAlumno(Integer id_dir);
    public List<CepCecMatriAlu> buscarCursosHistorialPorAlumno(Integer id_dir);
   public List<CepCecMatriAlu> buscarAlumnosMatriculados(Integer id_grupo);
     public CepCecMatriAlu actualizarMatri(CepCecMatriAlu entidad);
     public int cantidadAlumnosMatriculadosPorGrupo(int id_grupo);
}
