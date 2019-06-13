/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.InversionCurso;
import ejb.dao.MatriculaDAOLocal;
import ejb.dao.PguPagosCabDAOLocal;
import entidades.CepCecCurGrup;
import entidades.CepCecMatriAlu;
import entidades.DrtPersonanatural;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorMatriculaAluService implements GestorMatriculaAluServiceLocal {

    
    @EJB
    private GestorPguPagosCabServiceLocal gestorPguPagosCabService;

    
    @EJB
    private MatriculaDAOLocal matriculaDAO;

    
    
    @Override
    public CepCecMatriAlu crearMatriAlu(CepCecCurGrup cepCecCurGrup,DrtPersonanatural drtPersonanatural,Integer tipo_alumno) {
         Short estado = 1;
         CepCecMatriAlu cepCecMatriAlu = new CepCecMatriAlu();
         cepCecMatriAlu .setCepCecCurGrup(cepCecCurGrup);
         //cepCecMatriAlu.setDrtPersonanatural(drtPersonanatural);
         cepCecMatriAlu.setEstadoMatri(estado);
         cepCecMatriAlu.setEstadoAcademico(true);
         cepCecMatriAlu.setTipoAlumno(tipo_alumno);
         cepCecMatriAlu.setDrtPersonanatural(drtPersonanatural);
         //cepCecMatriAlu.setNomMatriculado(drtPersonanatural.getNombreCompleto());
         cepCecMatriAlu.setFechaRegMa( gestorPguPagosCabService.obtenerFechaActual());
         cepCecMatriAlu.setHoraRegMa(gestorPguPagosCabService.obtenerFechaActual());
        System.out.println("");
        return matriculaDAO.crear(cepCecMatriAlu);
    }
    
    
     @Override
    public CepCecMatriAlu recuperarEntidadMatriAlu(int id) {
        return matriculaDAO.buscarPorId(id);
    }

    @Override
    public List<CepCecMatriAlu> buscarCursosEnProcesoPorAlumno(Integer id_dir){
        return matriculaDAO.buscarCursosEnProcesoPorAlumno(id_dir);
    }
   
      @Override
    public List<CepCecMatriAlu> buscarCursosHistorialPorAlumno(Integer id_dir){
        return matriculaDAO.buscarCursosHistorialPorAlumno(id_dir);
    }
    
    
  @Override
    public List<CepCecMatriAlu> buscarAlumnosMatriculados(Integer id_grupo){
    return  matriculaDAO.buscarAlumnosMatriculados(id_grupo);
    }
    
    @Override
    public int cantidadAlumnosMatriculadosPorGrupo(int id_grupo){
      List<CepCecMatriAlu> matriculados =  matriculaDAO.buscarAlumnosMatriculados(id_grupo);
        if (matriculados == null) {
             return 0;
        }else{
            return matriculados.size();
        }

    }
    
    
      @Override
    public CepCecMatriAlu actualizarMatri(CepCecMatriAlu entidad) {
        return matriculaDAO.actualizar(entidad);
    }
     
}
