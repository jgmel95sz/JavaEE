/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecTipoInversion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class tipoInversionDAO extends GenericoJPADAO<CepCecTipoInversion> implements tipoInversionDAOLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
     @Override
     public List<CepCecTipoInversion> buscarTiposInversion(){
       // Integer inver = 4; // pago total
        Short estado = 1;
        Query q = em.createQuery("SELECT object(p) FROM CepCecTipoInversion as p WHERE p.estadoTipoinversion=:estado");
        //q.setParameter("inver", inver);
        q.setParameter("estado", estado);
        List<CepCecTipoInversion> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados;
                  // Devuelve el alumno encontrado            
              }
       }
}
