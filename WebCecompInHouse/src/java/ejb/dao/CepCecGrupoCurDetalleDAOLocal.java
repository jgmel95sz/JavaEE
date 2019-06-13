/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import clases.CurGrupDetDoc;
import entidades.CepCecCurGrupDet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Victor Lluen
 */
@Local
public interface CepCecGrupoCurDetalleDAOLocal extends GenericoJPADAOLocal<CepCecCurGrupDet> {

    public Integer buscarDocentes(int curgrup);

    public List<CurGrupDetDoc> listarDocentesCursoGrupDet();

    public CepCecCurGrupDet capturarDetalle(int curgrupo);
    public Integer buscarLaboratoriosAsignados(int curgrup);
    public List<CepCecCurGrupDet> buscarGruposPorDocente(Integer dir);
    public boolean validarSiEsDocente(int dir);
    
}
