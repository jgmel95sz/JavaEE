/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepCecCursoSubdet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorCursoSubDetServiceLocal {

    public List<CepCecCursoSubdet> buscarTodos();

    public List<CepCecCursoSubdet> buscarFiltroPorCursoGeneral(int id_curso_det);
    
    public CepCecCursoSubdet crearNuevoSubDetCurso(CepCecCursoSubdet duracion);

    CepCecCursoSubdet recuperarIdCurSubDet(int id);

    public boolean validarIdEscala(int Escala);
    
    public Integer validarRepeticiones(int id_desarrollo,int id_escala,int id_curdet);
    
    public CepCecCursoSubdet actualizarCursoDet(CepCecCursoSubdet cursosubDet);
}
