/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.DrtDepartamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class DrtDepartamentoDAO extends GenericoJPADAO<DrtDepartamento> implements DrtDepartamentoDAOLocal {

    @Override
    public List<DrtDepartamento> buscarTodos(){
       
        Query q = em.createQuery("SELECT object(c) FROM DrtDepartamento as c");
        // q.setParameter("dni", dni);
        // q.setParameter("extran", extran);
        List<DrtDepartamento> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados;
                  // Devuelve el alumno encontrado            
              }
       }
    
    
}
