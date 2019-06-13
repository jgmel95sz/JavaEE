/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.CurGrupDetDoc;
import entidades.CepCecCurGrupDet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Victor Lluen
 */
@Local
public interface GestorCepCecCurGrupDetalleServiceLocal {

    public CepCecCurGrupDet crearNuevoGrupoCurDetalle(CepCecCurGrupDet nuevo);

    public List<CurGrupDetDoc> listarDocenteCurGrupDet();

    public CepCecCurGrupDet recuperarIdGrupoCurso(int id);

    public CepCecCurGrupDet capturarDetalle(int curgrupo);

    public Integer buscarDocentes(int curgrup);

    public CepCecCurGrupDet actualizarGrupodet(CepCecCurGrupDet entidad);
    
     public Integer buscarLaboratoriosAsignados(int curgrup);
     
     public List<CepCecCurGrupDet> buscarGruposPorDocente(Integer dir);
}
