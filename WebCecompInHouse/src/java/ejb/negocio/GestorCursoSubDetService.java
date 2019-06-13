/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.CursoSubDetalleDAOLocal;
import entidades.CepCecCursoSubdet;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorCursoSubDetService implements GestorCursoSubDetServiceLocal {

    @EJB
    private CursoSubDetalleDAOLocal cursoSubDetalleDAO;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<CepCecCursoSubdet> buscarTodos() {
        return cursoSubDetalleDAO.buscarTodos();
    }
    
    @Override
    public List<CepCecCursoSubdet> buscarFiltroPorCursoGeneral(int id_curso_det){
      return cursoSubDetalleDAO.buscarPorFiltro(id_curso_det);
    };
    
     @Override
    public CepCecCursoSubdet actualizarCursoDet(CepCecCursoSubdet cursosubDet) {
        return cursoSubDetalleDAO.actualizar(cursosubDet);
    }
    
    
     @Override
    public CepCecCursoSubdet crearNuevoSubDetCurso(CepCecCursoSubdet duracion) {
        System.out.println("");
        return cursoSubDetalleDAO.crear(duracion);
    }
    
    @Override
    public CepCecCursoSubdet recuperarIdCurSubDet(int id) {
        return cursoSubDetalleDAO.buscarPorId(id);
    }
    
    @Override
    public boolean validarIdEscala(int Escala) {
        return ( cursoSubDetalleDAO.validarIdEscala(Escala)) !=null;
    }
    
     @Override
     public Integer validarRepeticiones(int id_desarrollo,int id_escala,int id_curdet){
     return cursoSubDetalleDAO.validarRepeticiones(id_desarrollo, id_escala, id_curdet);
     }
    
}
