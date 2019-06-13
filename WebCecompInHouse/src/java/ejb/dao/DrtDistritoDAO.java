/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.DrtDistrito;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class DrtDistritoDAO extends GenericoJPADAO<DrtDistrito>  implements DrtDistritoDAOLocal {

  @Override
    public List<DrtDistrito> buscarTodos(Integer pais,Integer departamento,Integer provincia){
       
        Query q = em.createQuery("SELECT object(c) FROM DrtDistrito as c WHERE c.drtDistritoPK.idPais=:pais AND c.drtDistritoPK.idDpto=:departamento AND c.drtDistritoPK.idProv=:provincia");
        q.setParameter("departamento", departamento);
        q.setParameter("pais", pais);
        q.setParameter("provincia", provincia);

        List<DrtDistrito> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados;
              }
       }
    
    
    @Override
    public DrtDistrito buscarEntidadNull(){
       Integer nulo=0;
        Query q = em.createQuery("SELECT object(c) FROM DrtDistrito as c WHERE c.idUbg=:nulo");
        q.setParameter("nulo", nulo);
        //q.setParameter("pais", pais);
        //q.setParameter("provincia", provincia);

        List<DrtDistrito> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados.get(0);
              }
       }
}
