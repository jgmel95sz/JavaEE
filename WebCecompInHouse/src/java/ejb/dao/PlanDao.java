/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecPlan;
import entidades.CepTipoDesarrollo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author MELVN
 */
@Stateless
public class PlanDao extends GenericoJPADAO<CepCecPlan> implements PlanDaoLocal {
 // Busca todos los cursos registrados en la bd
   
    @Override
    public List<CepCecPlan> buscarTodos(){
        Query q = em.createQuery("SELECT object(c) FROM CepCecPlan as c WHERE c.estadoPlan=1" );
        List<CepCecPlan> resultados =q.getResultList();  
        if (resultados.size()<=0){
            System.out.println("no encontro");
                  return null; // No encontrado
                  
              }else{
                  System.out.println("ENTRO A DAO");
                  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados;
                  // Devuelve el alumno encontrado            
              }
       }
    
    
      // Busca todos los cursos registrados en la bd
     @Override
     public List<CepCecPlan> buscarUltimoPeriodo(Integer curso,Integer anio){
        Short estado=1;  
        Query q = em.createQuery("SELECT object(p) FROM CepCecPlan as p WHERE p.cepCecCursoDet.idCursoDet=:Curso AND p.anio=:Anito AND p.estadoPlan=:estado");
        q.setParameter("Curso", curso);
        q.setParameter("Anito", anio);
        q.setParameter("estado",estado);

        List<CepCecPlan> resultados =q.getResultList();  
        if (resultados.size()<=0){
            System.out.println("No encontro nada en la sentencia pql ");
                  return null; // No encontrado
              }else{
                System.out.println("Si encontro datos en la sentencia pql");
                  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados; // Devuelve el alumno encontrado            
              }
     }
     
     
    @Override
    public CepCecPlan validarIdCursoDet(int id) {
        Short estado=1;
        Query q = em.createQuery("SELECT object(u) FROM CepCecPlan AS u WHERE u.cepCecCursoDet.idCursoDet=:id AND u.estadoPlan=:estado");
        q.setParameter("id", id);
        q.setParameter("estado", estado);

        List<CepCecPlan> resultados = q.getResultList();
//        resultados.forEach((re) -> {
//            System.out.println(re.getCepCeiCursoCab2().getIdCursoCab());
//        });
        if (resultados.size() <= 0) {
            System.out.println("NO ENCONTROUU");
            return null;
        } else {
                        System.out.println("SI ENCONTROUU");

            return resultados.get(0);
        }
    }
    
    
    @Override
    public CepCecPlan buscarPlanActual(int id){
        Short estado=1;
        Boolean plan_actual = true;
        Query q = em.createQuery("SELECT object(c) FROM CepCecPlan as c WHERE c.estadoPlan=:estado AND c.cepCecCursoDet.idCursoDet=:id AND c.planActual=:plan_actual" );
        q.setParameter("id", id);
        q.setParameter("estado", estado);
        q.setParameter("plan_actual", plan_actual);
        List<CepCecPlan> resultados =q.getResultList();  
        
        if (resultados.size() <= 0) {
            return null;
        } else {
            return resultados.get(0);
        }
        
       }
    
    
         
     @Override
     public List<CepCecPlan> buscarPlanes(int id,int pageNumber){
        Short estado=1;
        Boolean plan_actual = true;
        Query q = em.createQuery("SELECT object(c) FROM CepCecPlan as c WHERE c.estadoPlan=:estado AND c.cepCecCursoDet.idCursoDet=:id ORDER BY c.idPlan DESC" );
        q.setParameter("id", id);
        q.setParameter("estado", estado);
        //q.setParameter("plan_actual", plan_actual);
           //int pageNumber = 1;
        int pageSize=5;
        q.setFirstResult((pageNumber-1) * pageSize); //El primer registro **considerar que comienza desde 0
        q.setMaxResults(pageSize); //el tamaño maximo de registros a mostrar 
        
        List<CepCecPlan> resultados =q.getResultList();  
        
        if (resultados.size() <= 0) {
            return null;
        } else {
            return resultados;
        }
        
       } 
    
   
    @Override
    public long calculandoTotalRegistrosPlanes(int id_curso_det){
         
           ///Calculando el total de registros  
         Short estado = 1;
         Query queryTotal = em.createQuery("Select count(f.idPlan) from CepCecPlan as f WHERE f.estadoPlan=:estado AND f.cepCecCursoDet.idCursoDet=:id_curso_det");
         queryTotal.setParameter("estado", estado);
          queryTotal.setParameter("id_curso_det", id_curso_det);
         long countResult = (long)queryTotal.getSingleResult();  
         System.out.println("Total de registro de Todos los planes = "+countResult);
        ///Fin calculo total de registros
        //int countResult = 56;
         //int pageNumber = 1;
         return countResult;
    }
     
        
    
}
