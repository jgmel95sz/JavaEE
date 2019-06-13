/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepCecCronogramaCab;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorCronogramasCabServiceLocal {
    
        public CepCecCronogramaCab crearNuevoCronogramaCab(CepCecCronogramaCab nuevo) ;
         public CepCecCronogramaCab actualizarCronogramaCab(CepCecCronogramaCab entidad);
          public Integer buscarNumPago(Integer id_cur_grup);
          public CepCecCronogramaCab recuperarId(int id);
}
