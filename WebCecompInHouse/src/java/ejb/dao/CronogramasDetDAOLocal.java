/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecCronogramaDet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Victor Lluen
 */
@Local
public interface CronogramasDetDAOLocal extends GenericoJPADAOLocal<CepCecCronogramaDet> {

    List<CepCecCronogramaDet> buscarTodos();

    public CepCecCronogramaDet capturarDetalleEnCronograma(int curgrupo);

    public List<CepCecCronogramaDet> buscarCronogramaPorGrupo(Integer cabCro);

    public Integer obtenerTamanoCronogramaPago(Integer curgrupo);

    public Integer obtenerTamanoCronogramaPagoExt(Integer curgrupo);

    public List<CepCecCronogramaDet> capturarCronogramaExtemporaneoMatricula(Integer croCab);

    public List<CepCecCronogramaDet> capturarCronogramaPagos(Integer curgrupo);

    public CepCecCronogramaDet deshabilitarEditCronograma(Integer idCroDet);
    
    public List<CepCecCronogramaDet> buscarCronogramasPorcadaGrupo(Integer curGrupo);
    
     public List<CepCecCronogramaDet> ultimoCronograma(Integer idgrup);
}
