/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepCecCursoDet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface GestorCursoDetServiceLocal {

    List<CepCecCursoDet> buscarTodos(int pageNumber);
     List<CepCecCursoDet> buscarTodosFiltro(int pageNumber,String nombre , Integer modensenanza);
    List<CepCecCursoDet> buscarTodosCurDet( );
    // public List<CepCecCursoDet> buscarPorFiltro(int id_curso_det) ;

    public CepCecCursoDet crearNuevoDetCurso(CepCecCursoDet duracion);

    public CepCecCursoDet actualizarCurso(CepCecCursoDet curso);

    public boolean validarIdCursoCab(int idCursoName);

    CepCecCursoDet recuperarIdCurDet(int id);

    public Integer validarRepeticion(int id_cur_cab, int id_nivel,int mod_ensenanza);
    
    public int tamanoPaginacionCursoDet();
    
     public int tamanoPaginacionCursoDetFiltro(String nombre , Integer modensenanza);
}
