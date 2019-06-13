/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.PguModalidadTipospagos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class PguModalidadTipoPagosDAO extends GenericoJPADAO<PguModalidadTipospagos> implements PguModalidadTipoPagosDAOLocal {

     @Override
    public PguModalidadTipospagos buscarModalidadPago(Integer id_tipopago){
        Boolean estado = true;
        Query q = em.createQuery("SELECT object(c) FROM PguModalidadTipospagos as c WHERE c.activo=:estado AND c.pguTipoPagos.idTipopag=:id_tipopago" );
        q.setParameter("estado", estado);
        q.setParameter("id_tipopago", id_tipopago);
        List<PguModalidadTipospagos> resultados =q.getResultList();  
        if (resultados.size()<=0 ){
                  return null; // No encontrado
              }else{
                  return resultados.get(0);
  
              }
       }
    
}
