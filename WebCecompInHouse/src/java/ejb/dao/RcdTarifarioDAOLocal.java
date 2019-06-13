/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.RcdTarifario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface RcdTarifarioDAOLocal extends GenericoJPADAOLocal<RcdTarifario>{
     public List<RcdTarifario> ListarRcdConceptos(Short typePeople,int condicional,String cadena,String cadenaPrimeraPalabra,String cadPriPalMay,String cadPriPalMin,String cadenaPrimeraPalabraSintilde,
        String cadPriPalSintilMay,String cadPriPalSintilMin,String cadPriPalFormal,String cadPriPalFormalLimpio);
}
