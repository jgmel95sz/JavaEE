/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecInversionCurso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface InversionDAOLocal extends GenericoJPADAOLocal<CepCecInversionCurso> {

    public List<CepCecInversionCurso> buscarInversion(Integer idCurSubDet,Integer id_tipo_inver);

    public List<CepCecInversionCurso> buscarInversionPorTipoAlmuno(Integer idCurSubDet, Integer tipoAlumno,Integer idconcepto);

// public List<CepCecInversionCurso> buscarInversionPorPubGeneral(Integer idCurSubDet);
    //public List<CepCecInversionCurso> buscarInversionTrabajadorUNS(Integer idCurSubDet);
    public CepCecInversionCurso validarSiExisteInversionporCurso(int id);

    public CepCecInversionCurso buscarInversionNulo(Integer idCurSubDet, Float precio, Short estadoConcepto, Integer tipoInver, Integer rcd);

    public List<CepCecInversionCurso> buscarCostoTotal(Integer idCurSubDet, Integer tipoAlumno, Integer tipo_inver);
  
      public List<CepCecInversionCurso> listaInversion(Integer id_cursosubdet, Integer tipo_alu);
      
      public CepCecInversionCurso buscarInver(Integer idCurSubDet, Integer tipoAlumno,Integer tipo_inver);
}
