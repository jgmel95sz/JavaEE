/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecCronogramaCab;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class CronogramasCabDAO extends GenericoJPADAO<CepCecCronogramaCab> implements CronogramasCabDAOLocal {

     @Override
     public Integer buscarNumPago(Integer id_cur_grup){
         Short estado = 1;
         Query q = em.createQuery("SELECT object(p) FROM CepCecCronogramaCab as p WHERE p.estadoCroCab=:estado AND p.cepCecCurGrup.idCurGrup=:id_cur_grup");
         q.setParameter("estado",estado);
         q.setParameter("id_cur_grup", id_cur_grup);
         List<CepCecCronogramaCab> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return 0; // No encontrado
              }else{
                  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados.size(); // Devuelve el alumno encontrado            
              }
       }
     
    
     
       // Busca todos los cursos registrados en la bd por grupo
     @Override
     public List<CepCecCronogramaCab> buscarCronogramaCabPorGrupo(Integer curGrupo){
        Short estado=1; 
         Query q = em.createQuery("SELECT object(p) FROM CepCecCronogramaCab as p WHERE p.cepCecCurGrup.idCurGrup =:curGrupo AND p.estadoCroCab=:estado");
         q.setParameter("estado", estado);
         q.setParameter("curGrupo", curGrupo);
         List<CepCecCronogramaCab> resultados =q.getResultList();  
        
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  //System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados; // Devuelve el alumno encontrado            
              }
       }
     
     
     
}
