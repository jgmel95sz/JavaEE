/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepCecTipoInversion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorTipoInversionServiceLocal {
         public List<CepCecTipoInversion> buscarTiposInversion();
         CepCecTipoInversion recuperartipoInversion(int id);
    
}
