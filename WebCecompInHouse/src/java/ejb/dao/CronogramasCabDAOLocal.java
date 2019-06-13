/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecCronogramaCab;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface  CronogramasCabDAOLocal  extends GenericoJPADAOLocal<CepCecCronogramaCab>{
    public Integer buscarNumPago(Integer id_cur_grup);
    public List<CepCecCronogramaCab> buscarCronogramaCabPorGrupo(Integer curGrupo);

}
