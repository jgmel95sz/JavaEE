/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.DrtDocidentidad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class DrtDocidentidadDAO  extends GenericoJPADAO<DrtDocidentidad> implements DrtDocidentidadDAOLocal {

    @Override
    public List<DrtDocidentidad> buscarTodos(){
       Short dni=4;
       Short extran=5;
        Query q = em.createQuery("SELECT object(c) FROM DrtDocidentidad as c WHERE c.idPdid=:dni OR c.idPdid=:extran");
         q.setParameter("dni", dni);
         q.setParameter("extran", extran);
        List<DrtDocidentidad> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados;
                  // Devuelve el alumno encontrado            
              }
       }
    
}
