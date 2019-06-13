/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecCurGrup;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author MELVN
 */
@Stateless
public class CursoGrupoDAO extends GenericoJPADAO<CepCecCurGrup> implements CursoGrupoDAOLocal {

    
   @Override
    public long calculandoTotalRegistrosGrupo(int id_cursogeneral){
         ///Calculando el total de registros  
         Short estado = 1;
         Boolean academico = true;
        Query queryTotal;
         if (id_cursogeneral==0) {
          queryTotal = em.createQuery("Select count(f.idCurGrup) FROM CepCecCurGrup as f WHERE f.estadoGrupoCab =:estado AND f.estadoAcademico=:academico");
          queryTotal.setParameter("estado", estado);
          queryTotal.setParameter("academico", academico);
        }else{
          queryTotal = em.createQuery("Select count(f.idCurGrup) FROM CepCecCurGrup as f WHERE f.estadoGrupoCab =:estado AND f.estadoAcademico=:academico AND f.cepCecCursoSubdet.cepCecCursoDet.idCursoDet=:id_cursogeneral");
          queryTotal.setParameter("estado", estado);
          queryTotal.setParameter("academico", academico); 
          queryTotal.setParameter("id_cursogeneral", id_cursogeneral);
         }
         
         long countResult = (long)queryTotal.getSingleResult();  
         System.out.println("Total de registro de Todos los Grupos = "+countResult);
         ///Fin calculo total de registros
         //int countResult = 56;
         //int pageNumber = 1;
         return countResult;
    }
    
  @Override  
     public List<CepCecCurGrup> buscarTodos(){
         System.out.println("EN DAO GRUPO");
      boolean estadoAcademico= true;
      Short estado = 1;
      Query q = em.createQuery("SELECT object(p) FROM CepCecCurGrup as p WHERE p.estadoAcademico=:estadoAcademico AND p.estadoGrupoCab=:estado");
       q.setParameter("estado", estado);
        q.setParameter("estadoAcademico", estadoAcademico);
     
        ///Calculando el total de registros  
         Query queryTotal = em.createQuery("Select count(f.idCurGrup) from CepCecCurGrup as f");
         long countResult = (long)queryTotal.getSingleResult();  
         System.out.println("Total de registro de Todos los Grupos = "+countResult);
        ///Fin calculo total de registros
        
      
      List<CepCecCurGrup> resultados =q.getResultList();  
      if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }
     }
     
     
      @Override  
     public List<CepCecCurGrup> buscarPorFiltroCurso(int id_cursogeneral, int pageNumber){
          System.out.println("EN DAO BUSCAR GRUPO POR FILTRO");
      boolean estadoAcademico= true;
      Short estado = 1;
      Query q;
       if (id_cursogeneral==0) { //osea quiere que muestre todoss
                q = em.createQuery("SELECT object(p) FROM CepCecCurGrup as p WHERE p.estadoAcademico=:estadoAcademico AND p.estadoGrupoCab=:estado");
                q.setParameter("estado", estado);
                q.setParameter("estadoAcademico", estadoAcademico);  
          }else{
             //por filtro
                q = em.createQuery("SELECT object(p) FROM CepCecCurGrup as p WHERE p.estadoAcademico=:estadoAcademico AND p.estadoGrupoCab=:estado AND p.cepCecCursoSubdet.cepCecCursoDet.idCursoDet=:id_cursogeneral ");
                q.setParameter("estado", estado);
                q.setParameter("estadoAcademico", estadoAcademico);
                q.setParameter("id_cursogeneral", id_cursogeneral);

       }
       
        //********************AÑADIR SOLO ESTA PARTE Y EL PARAMETRO*********************************
         //int pageNumber = 1;
        int pageSize=5;
        q.setFirstResult((pageNumber-1) * pageSize); //El primer registro **considerar que comienza desde 0
        q.setMaxResults(pageSize); //el tamaño maximo de registros a mostrar 
        //********************AÑADIR SOLO ESTA PARTE*********************************
    
      List<CepCecCurGrup> resultados =q.getResultList();  
      if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }
     }
     
     
     @Override  
     public List<CepCecCurGrup> buscarHistorico(){
      boolean estadoAcademico= false;
      Short estado = 1;
      Query q = em.createQuery("SELECT object(p) FROM CepCecCurGrup as p WHERE p.estadoAcademico=:estadoAcademico AND p.estadoGrupoCab=:estado");
       q.setParameter("estado", estado);
       q.setParameter("estadoAcademico", estadoAcademico);
      List<CepCecCurGrup> resultados =q.getResultList();  
      if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }
     }
     
     
      @Override  
     public List<CepCecCurGrup> buscarHistoricoPorFiltroCurso(int id_cursogeneral){
      boolean estadoAcademico= false;
      Short estado = 1;
      Query q = em.createQuery("SELECT object(p) FROM CepCecCurGrup as p WHERE p.estadoAcademico=:estadoAcademico AND p.estadoGrupoCab=:estado AND p.cepCecCursoSubdet.cepCecCursoDet.idCursoDet=:id_cursogeneral ");
       q.setParameter("estado", estado);
       q.setParameter("estadoAcademico", estadoAcademico);
       q.setParameter("id_cursogeneral", id_cursogeneral);

      List<CepCecCurGrup> resultados =q.getResultList();  
      if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }
     }
     
     @Override
     public Integer findRegistroCursoSubDet(int id_cursubdet){
         Short estado = 1;
         Query q = em.createQuery("SELECT object(p) FROM CepCecCurGrup as p WHERE p.cepCecCursoSubdet.idCursoSubdet=:id_cursubdet AND p.estadoGrupoCab =:estado ");
         q.setParameter("id_cursubdet", id_cursubdet);
         List<CepCecCurGrup> resultados =q.getResultList();  
          if (resultados.size()<=0){
                return 1; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return 0; // Devuelve el alumno encontrado            
            }

     }
    
     
     @Override  
     public Integer compruebaSiPlanEstaAsignadoAhGrupo(Integer id_plan){
      Query q = em.createQuery("SELECT object(p) FROM CepCecCurGrup as p WHERE p.idPlan=:id_plan");
      q.setParameter("id_plan", id_plan);
      List<CepCecCurGrup> resultados =q.getResultList();  
      if (resultados.size()<=0){
                return 0; // No encontrado
            }else{
                return 1; // Devuelve el alumno encontrado            
            }
     }


     @Override  
     public CepCecCurGrup validarNumeroDeGrupo(int id_cursodetallado,int id_grupo){
      boolean estadoAcademico= true;
      Short estado = 1;
      Query q = em.createQuery("SELECT object(p) FROM CepCecCurGrup as p WHERE p.estadoAcademico=:estadoAcademico AND p.estadoGrupoCab=:estado AND p.cepCecCursoSubdet.idCursoSubdet=:id_cursodetallado AND p.cepCecGrupo.idGrupo=:id_grupo");
       q.setParameter("estado", estado);
       q.setParameter("estadoAcademico", estadoAcademico);
       q.setParameter("id_cursodetallado", id_cursodetallado);
       q.setParameter("id_grupo", id_grupo);

      List<CepCecCurGrup> resultados =q.getResultList();  
      if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados.get(0); // Devuelve el alumno encontrado            
            }
     }

}
