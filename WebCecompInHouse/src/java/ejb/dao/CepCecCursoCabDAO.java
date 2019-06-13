/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecCursoCab;
import entidades.CepNivel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author MELVN
 */
@Stateless
public class CepCecCursoCabDAO extends GenericoJPADAO<CepCecCursoCab> implements CepCecCursoCabDAOLocal {

    // Busca todos los cursos registrados en la bd
    /* @Override
     public List<CepCecCursoCab> buscarNombres(){
        Query q = em.createQuery("SELECT DISTINCT p.nomCurso  FROM CepCecCursoCab as p");
        List<CepCecCursoCab> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados; // Devuelve el alumno encontrado            
              }
       }
     */
     
     @Override
     public Integer ValidarRepeticiones(String name_curso){
        Short estado = 1;
        Query q = em.createQuery("SELECT object(p) FROM CepCecCursoCab as p WHERE p.nomCurso = :namecurso AND p.estadoCabcur=:estado" );
        q.setParameter("namecurso", name_curso);
        q.setParameter("estado", estado);

        List<CepCecCursoCab> resultados =q.getResultList();  
        
        if (resultados.size()<=0){
                  return 0; // No encontrado
              }else{
               //   System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return 1; // Devuelve si encontro         
              }
       }
     
    
    @Override  
     public List<CepCecCursoCab> buscarTodos(int pageNumber){
         Short estado = 1;
      Query q = em.createQuery("SELECT object(p) FROM CepCecCursoCab as p WHERE p.estadoCabcur=:estado ORDER BY p.idCursoCab DESC");
       q.setParameter("estado", estado);
        int pageSize=10;
        q.setFirstResult((pageNumber-1) * pageSize); //El primer registro **considerar que comienza desde 0
        q.setMaxResults(pageSize); //el tamaño maximo de registros a mostrar 
      List<CepCecCursoCab> resultados =q.getResultList();  
      
      if (resultados.size()<=0){
                return null; // No encontrado
            }else{
              //  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }
     }
     
     
      @Override  
     public List<CepCecCursoCab> buscarTodosNombres(){
         Short estado = 1;
      Query q = em.createQuery("SELECT object(p) FROM CepCecCursoCab as p WHERE p.estadoCabcur=:estado ORDER BY p.idCursoCab DESC");
       q.setParameter("estado", estado);
       
      List<CepCecCursoCab> resultados =q.getResultList();  
      
      if (resultados.size()<=0){
                return null; // No encontrado
            }else{
             //   System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }
     }
     
     
     
       @Override
     public long calculandoTotalRegistrosNombresCab(){
         
           ///Calculando el total de registros  
         Short estado = 1;
         Query queryTotal = em.createQuery("Select count(f.idCursoCab) from CepCecCursoCab as f WHERE f.estadoCabcur=:estado");
         queryTotal.setParameter("estado", estado);
         long countResult = (long)queryTotal.getSingleResult();  
         System.out.println("Total de registro de los nombres = "+countResult);
        ///Fin calculo total de registros
        //int countResult = 56;
         //int pageNumber = 1;
         return countResult;
    }
    
        
}
