/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;


import entidades.CepHorarioDias;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author MELVN
 */
@Stateless
public class CepHorarioDiasDAO extends GenericoJPADAO<CepHorarioDias> implements CepHorarioDiasDAOLocal {
 
     @Override  
     public List<CepHorarioDias> buscarTodos(){
      Query q = em.createQuery("SELECT object(p) FROM CepHorarioDias as p");
      List<CepHorarioDias> resultados =q.getResultList();  
      if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }
     }
     
      @Override  
     public Integer buscarRepeticion(String nomDias){
      Integer condicion;
      Query q = em.createQuery("SELECT object(p) FROM CepHorarioDias as p WHERE p.nomHorarioDias=:nomDias");
      q.setParameter("nomDias", nomDias);
      List<CepHorarioDias> resultados =q.getResultList();  
        if (resultados.size()<=0){
                condicion = 0 ; // No encontrado
            }else{
                condicion  = 1;
            }
      return condicion;
     
     }
     
    
}
