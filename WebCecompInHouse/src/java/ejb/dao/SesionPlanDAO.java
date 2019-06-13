/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecSesion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class SesionPlanDAO extends GenericoJPADAO<CepCecSesion> implements SesionPlanDAOLocal{


    @Override
    public List<CepCecSesion> buscarTodos(Integer idplancito){
        Short estado=1;
        Query q = em.createQuery("SELECT object(c) FROM CepCecSesion as c WHERE c.cepCecPlan.idPlan = :idPlansito AND c.estadoSesion=:estado" );
        q.setParameter("idPlansito", idplancito);
        q.setParameter("estado", estado);
        List<CepCecSesion> resultados =q.getResultList();  
        if (resultados.size()<=0){
   
                  return null; // No encontrado
                  
              }else{
               
                  return resultados;
                  // Devuelve el alumno encontrado            
              }
       }
}
