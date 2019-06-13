/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.DrtProvincia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class DrtProvinciaDAO extends GenericoJPADAO<DrtProvincia> implements DrtProvinciaDAOLocal {
        
     @Override
    public List<DrtProvincia> buscarTodos(Integer pais,Integer departamento){
       
        Query q = em.createQuery("SELECT object(c) FROM DrtProvincia as c WHERE c.drtProvinciaPK.idDpto=:departamento AND c.drtProvinciaPK.idPais=:pais");
        q.setParameter("pais", pais);
        q.setParameter("departamento", departamento);
        List<DrtProvincia> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados;
              }
       }
        
}
