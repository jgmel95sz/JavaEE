/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepCecCurGrup;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface GestorCursoGrupoServiceLocal {

      public boolean validarNumeroDeGrupo(int id_cursodetallado,int id_grupo);
              
    public CepCecCurGrup actualizarEntidad(CepCecCurGrup entidad);
             
    public CepCecCurGrup crearNuevoGrupoCurso(CepCecCurGrup grupocurso);

    public List<CepCecCurGrup> buscarTodos();
    
    public List<CepCecCurGrup> buscarHistoricos();
    
    public List<CepCecCurGrup> buscarHistoricoPorFiltro(int id_cursogeneral);    
    
    public List<CepCecCurGrup> buscarGrupoPorFiltro(int id_cursogeneral,int pageNumber) ;
    
    CepCecCurGrup recuperarIdGrupoCurso(int id);

    public Integer findRegistroCursoSubDet(int id_cursubdet);

    public List<CepCecCurGrup> buscarGruposParaInscripcion();

    public Date obtenerFechaActual();

    public Calendar toCalendar(Date date);

    public String FormatoFechas(Date fecha);

    public Integer habilitarNextPago(Integer id_grupCurso);

    public Integer compruebaSiPlanEstaAsignadoAhGrupo(Integer id_plan);
    
    public int tamanoPaginacionGrupo(int id_curso);
}
