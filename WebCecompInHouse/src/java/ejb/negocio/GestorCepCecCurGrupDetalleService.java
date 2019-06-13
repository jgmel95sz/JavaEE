/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.CurGrupDetDoc;
import ejb.dao.CepCecGrupoCurDetalleDAOLocal;
import entidades.CepCecCurGrupDet;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Victor Lluen
 */
@Stateless
public class GestorCepCecCurGrupDetalleService implements GestorCepCecCurGrupDetalleServiceLocal {

    @EJB
    private CepCecGrupoCurDetalleDAOLocal cepCecGrupoCurDetalleDAO;

    
 @Override
    public CepCecCurGrupDet crearNuevoGrupoCurDetalle(CepCecCurGrupDet nuevo) {
        System.out.println("ENTRO A CREAR DURACION");
        return cepCecGrupoCurDetalleDAO.crear(nuevo);
    }
    
     @Override
    public List<CurGrupDetDoc> listarDocenteCurGrupDet() {
        return cepCecGrupoCurDetalleDAO.listarDocentesCursoGrupDet();
    }
    
    @Override
    public CepCecCurGrupDet recuperarIdGrupoCurso(int id) {
        return cepCecGrupoCurDetalleDAO.buscarPorId(id);
    }
    
    
    @Override
    public CepCecCurGrupDet capturarDetalle(int curgrupo) {
        return cepCecGrupoCurDetalleDAO.capturarDetalle(curgrupo);
    }
    
    
    
    @Override
        public Integer buscarDocentes(int curgrup) {
            return  cepCecGrupoCurDetalleDAO.buscarDocentes(curgrup);
        }
        
        
    @Override
    public CepCecCurGrupDet actualizarGrupodet(CepCecCurGrupDet entidad) {
        return cepCecGrupoCurDetalleDAO.actualizar(entidad);
    }
    
  @Override
    public Integer buscarLaboratoriosAsignados(int curgrup){
      return  cepCecGrupoCurDetalleDAO.buscarLaboratoriosAsignados(curgrup);
    }   
    
   @Override
   public List<CepCecCurGrupDet> buscarGruposPorDocente(Integer dir) {
       return  cepCecGrupoCurDetalleDAO.buscarGruposPorDocente(dir);
   }
        
        
}
