/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.TipoCronograma;
import entidades.CepCecCronogramaDet;
import entidades.CepCecCurGrup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Victor Lluen
 */
@Local
public interface GestorCronogramasDetServiceLocal {

    public CepCecCronogramaDet crearNuevoCronograma(CepCecCronogramaDet nuevo);

    public List<CepCecCronogramaDet> buscarTodos();

    public CepCecCronogramaDet capturarDetalleEnCronograma(int curgrupo);

    public List<TipoCronograma> buscarCronogramaPorGrupo(Integer idCurGrup);
    //public List<CepCecCronograma> ListarCronogramaPorGrupo(Integer idCurGrup);

    public CepCecCronogramaDet recuperarId(int id);

    public CepCecCronogramaDet actualizarCronograma(CepCecCronogramaDet entidad);

    public Short DesHabilitarEditCronograma(Integer id_detalle);

    //public List<TipoCronograma>  ListarTipoCronograma(List<CepCecCronograma> lstCronograma);
    // public String descripcionCronograma(Integer idCurGrup,Integer tipo_cronograma);
    public Short capturarEtapa(CepCecCronogramaDet tipoCrono, CepCecCurGrup grupo);

    public TipoCronograma buscarProximoPago(List<TipoCronograma> lstCronograma);

    public Integer numPagodelCronograma(CepCecCurGrup grup);
    
    public CepCecCronogramaDet encontrarUltimoCronograma(Integer grupo);
}
