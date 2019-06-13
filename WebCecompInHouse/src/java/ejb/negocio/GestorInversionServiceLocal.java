/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.InversionCurso;
import entidades.CepCecInversionCurso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorInversionServiceLocal {

    public List<CepCecInversionCurso> buscarInversion(Integer idCursoSubDet, Integer id_tipo_inver);

    public List<InversionCurso> buscarInversionPorTipo(Integer idCurSubDet, Integer tipoAlumno, Integer idconcepto);

    /*public List<CepCecInversionCurso> buscarInversionPorPubGeneral(Integer idCursoSubDet);

    public List<CepCecInversionCurso> buscarInversionTrabajadorUNS(Integer idCursoSubDet);*/
    public CepCecInversionCurso crearInversion(CepCecInversionCurso inversion);

    public boolean validarSiExisteInversionporCurso(int idCursoSubDet);

    public CepCecInversionCurso actualizarInversion(CepCecInversionCurso inversion);

    public CepCecInversionCurso recuperarEntidadInversion(int id);

    public CepCecInversionCurso buscarInversioNula(Integer idCurSubDet, Float precio, Short estadoConcepto, Integer tipoInver, Integer rcd);

    public CepCecInversionCurso buscarCostoTotal(Integer id_cursosubdet, Integer tipo_alu, Integer tipo_inver);

    public boolean inversionExiste(Integer idcursosub, Integer idtipoalu, Integer idtipoinver);
    
    public CepCecInversionCurso inversionBeca(Integer idcursosub , Integer idtipoalu, Integer idtipoinver);

     public List<CepCecInversionCurso> listaInversion(Integer id_cursosubdet, Integer tipo_alu);
     
     public CepCecInversionCurso buscarInver(Integer id_cursosubdet ,Integer tipo_alu,Integer tipo_inver);

}
