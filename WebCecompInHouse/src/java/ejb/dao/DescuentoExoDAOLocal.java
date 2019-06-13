/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecDescExonerados;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface DescuentoExoDAOLocal extends GenericoJPADAOLocal<CepCecDescExonerados> {

    public List<CepCecDescExonerados> buscarMediasBecas(int idinversion,int pageNumber);

    public long calculandoTotalRegistrosMediasBecas(int idinversion);
            
    public List<CepCecDescExonerados> buscarBecas(int idinversion);

    public CepCecDescExonerados validarLaNoRepeticionAlumnoUns(int id_inversion_curso, String codigoUns);

    public CepCecDescExonerados validarLaNoRepeticionPubGeneral(int id_inversion_curso, String dni);

   
}
