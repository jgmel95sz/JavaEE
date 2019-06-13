/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecCronogramaDet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Victor Lluen
 */
@Stateless
public class CronogramasDetDAO  extends GenericoJPADAO<CepCecCronogramaDet> implements CronogramasDetDAOLocal {

   // Busca todos los cursos registrados en la bd
     @Override
     public List<CepCecCronogramaDet> buscarTodos(){
        Query q = em.createQuery("SELECT object(p) FROM CepCecCronogramaDet as p");
        List<CepCecCronogramaDet> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados; // Devuelve el alumno encontrado            
              }
       }
     
     
     
       // Busca todos los cursos registrados en la bd por grupo
     @Override
     public List<CepCecCronogramaDet> buscarCronogramaPorGrupo(Integer cronoCab){
        Short estado=1; 
         Query q = em.createQuery("SELECT object(p) FROM CepCecCronogramaDet as p WHERE p.cepCecCronogramaCab.idCronogramaCab=:cronoCab AND p.estadoCroDet=:estado");
         q.setParameter("estado", estado);
         q.setParameter("cronoCab", cronoCab);
         List<CepCecCronogramaDet> resultados =q.getResultList();  
        
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  //System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados; // Devuelve el alumno encontrado            
              }
       }
     
     @Override
    public CepCecCronogramaDet capturarDetalleEnCronograma(int curgrupo){
         Short estado=1;  
         Integer tipo=1;
         Query q = em.createQuery("SELECT object(p)  FROM CepCecCronogramaDet as p WHERE p.cepCecCronogramaCab.cepCecCurGrup.idCurGrup=:curgrupo AND p.estadoCroDet=:estado AND p.tipoCronograma=:tipo");
         q.setParameter("estado", estado);
         q.setParameter("curgrupo", curgrupo);
         q.setParameter("tipo", tipo);
         List<CepCecCronogramaDet> resultados =q.getResultList(); 
              if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados.get(0); // Devuelve el primero de la lista que es la matricula   
              }
    }

     @Override
    public List<CepCecCronogramaDet> capturarCronogramaExtemporaneoMatricula(Integer croCab){
         Short estado=1;  
         Integer tipo=3;
         Query q = em.createQuery("SELECT object(p)  FROM CepCecCronogramaDet as p WHERE p.cepCecCronogramaCab.idCronogramaCab=:croCab  AND p.estadoCroDet=:estado AND p.tipoCronograma=:tipo");
         q.setParameter("estado", estado);
         q.setParameter("croCab", croCab);
         q.setParameter("tipo", tipo);
         List<CepCecCronogramaDet> resultados =q.getResultList(); 
              if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados; // Devuelve el primero de la lista que es la matricula   
              }
    }
    
    
    @Override
    public Integer obtenerTamanoCronogramaPago(Integer curgrupo){
         Short estado=1;  
         Integer tipo=1;
         Integer tipo2=2;
         Query q = em.createQuery("SELECT object(p)  FROM CepCecCronogramaDet as p WHERE p.cepCecCronogramaCab.cepCecCurGrup.idCurGrup = :curgrupo AND p.estadoCroDet = :estado AND (p.tipoCronograma=:tipo OR p.tipoCronograma=:tipo2)");
         q.setParameter("estado", estado);
         q.setParameter("curgrupo", curgrupo);
         q.setParameter("tipo", tipo);
         q.setParameter("tipo2", tipo2);

         List<CepCecCronogramaDet> resultados =q.getResultList(); 
              if (resultados.size()<=0){
                  return 0; // No encontrado
              }else{
                  System.out.println("tamano es "+resultados.size());
                  return resultados.size(); // Devuelve el primero de la lista que es la matricula   
              }
    }
    
    
        
    @Override
    public Integer obtenerTamanoCronogramaPagoExt(Integer curgrupo){
         Short estado=1;  
         Integer tipo=3;
         Query q = em.createQuery("SELECT object(p)  FROM CepCecCronogramaDet as p WHERE p.cepCecCronogramaCab.cepCecCurGrup.idCurGrup = :curgrupo AND p.estadoCroDet = :estado AND p.tipoCronograma=:tipo");
         q.setParameter("estado", estado);
         q.setParameter("curgrupo", curgrupo);
         q.setParameter("tipo", tipo);

         List<CepCecCronogramaDet> resultados =q.getResultList(); 
              if (resultados.size()<=0){
                  return 0; // No encontrado
              }else{
                  System.out.println("tamano es "+resultados.size());
                  return resultados.size(); // Devuelve el primero de la lista que es la matricula   
              }
      
    }
    
    
      @Override
    public List<CepCecCronogramaDet>  capturarCronogramaPagos(Integer curgrupo){
         Short estado=1;  
         Integer tipo=2;
         Query q = em.createQuery("SELECT object(p)  FROM CepCecCronogramaDet as p WHERE p.cepCecCronogramaCab.cepCecCurGrup.idCurGrup=:curgrupo AND p.estadoCroDet=:estado AND p.tipoCronograma=:tipo");
         q.setParameter("estado", estado);
         q.setParameter("curgrupo", curgrupo);
         q.setParameter("tipo", tipo);
         List<CepCecCronogramaDet> resultados =q.getResultList(); 
              if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados; // Devuelve el primero de la lista que es la matricula   
              }
    }
    
    
    @Override
    public CepCecCronogramaDet deshabilitarEditCronograma(Integer idCroDet){
         Short estado=1;   
         Query q = em.createQuery("SELECT object(p)  FROM CepCecCronogramaDet as p WHERE p.idCronogramaDet =:idCroDet AND p.estadoCroDet=:estado ");
         q.setParameter("estado", estado);
         q.setParameter("idCroDet", idCroDet);
     
         List<CepCecCronogramaDet> resultados =q.getResultList(); 
              if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados.get(0); // Devuelve el primero de la lista que es la matricula   
              }
    }
    
    @Override
     public List<CepCecCronogramaDet> ultimoCronograma(Integer idgrup){
        Short estado=1; 
         Query q = em.createQuery("SELECT object(p) FROM CepCecCronogramaDet as p WHERE p.cepCecCronogramaCab.cepCecCurGrup.idCurGrup=:idgrup AND p.estadoCroDet=:estado ");
         q.setParameter("estado", estado);
         q.setParameter("idgrup", idgrup);
         List<CepCecCronogramaDet> resultados =q.getResultList();  
        
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  //System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados; // Devuelve el alumno encontrado            
              }
       }
    
    
     @Override
     public List<CepCecCronogramaDet> buscarCronogramasPorcadaGrupo(Integer idgrup){
        Short estado=1; 
        Boolean academic= true;
         Query q = em.createQuery("SELECT object(p) FROM CepCecCronogramaDet as p WHERE p.cepCecCronogramaCab.cepCecCurGrup.idCurGrup=:idgrup AND p.estadoCroDet=:estado AND p.cepCecCronogramaCab.estadoCroCab=:estado AND p.cepCecCronogramaCab.cepCecCurGrup.estadoGrupoCab=:estado AND p.cepCecCronogramaCab.cepCecCurGrup.estadoAcademico=:academic");
         q.setParameter("estado", estado);
         q.setParameter("idgrup", idgrup);
         q.setParameter("academic", academic);
         List<CepCecCronogramaDet> resultados =q.getResultList();  
        
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  //System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados; // Devuelve el alumno encontrado            
              }
       }
     
    
}
