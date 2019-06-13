/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.PguTipoPagos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface pguTipoPagosDAOLocal extends GenericoJPADAOLocal<PguTipoPagos>{
      public  List<PguTipoPagos> buscarTodosConceptosCecomp(String name);
       public   PguTipoPagos capturarPrecio(Integer idTipopag);
       public PguTipoPagos buscarRepeticionConcepto(String name,Float precio);


}
