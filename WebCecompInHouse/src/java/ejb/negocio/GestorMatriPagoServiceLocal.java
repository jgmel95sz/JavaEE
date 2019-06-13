/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.InversionCurso;
import entidades.CepCecExonerados;
import entidades.CepCecInversionCurso;
import entidades.CepCecMatriAlu;
import entidades.CepCecMatriPago;
import entidades.PguPagospersCab;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorMatriPagoServiceLocal {

    public CepCecMatriPago crearMatriPago(CepCecMatriAlu cepCecMatriAlu, PguPagospersCab pguPagospersCab, Integer tipomatri,Integer condicion,Boolean isPagoTotal,Integer codconcepto,Integer numCronogramaPago);

    public CepCecMatriPago crearMatriPagoParaExonerados (CepCecMatriAlu cepCecMatriAlu, Integer tipomatri,Integer condicion,Boolean isPagoTotal, CepCecExonerados cepCecExonerados,Integer numCronogramaPago);

    public CepCecMatriPago recuperarEntidadPago(int id);

    public Integer buscarSizePagosPorAlumno(int id_matri);

    public CepCecMatriPago buscarPagoMatriculaPorAlumno(Integer id_matri);

    public List<CepCecMatriPago> buscarPagosPorMatricula(Integer id_matri);

    public List<Integer> generarListaDePagosPensionMatricula(Integer num_cuotas);

    public List<Integer> listarConformidadPagosMatriculaPorAlumno(CepCecMatriAlu id_matri);

    public CepCecMatriPago actualizarMatriPago(CepCecMatriPago entidad);
    
    public List<CepCecMatriPago> buscarAlumnosMatriculados(Integer id_grupo);
    
}
