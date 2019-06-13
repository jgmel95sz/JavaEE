/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecExonerados;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class ExoneradosDAO extends GenericoJPADAO<CepCecExonerados> implements ExoneradosDAOLocal {

    
       
    @Override
     public List<CepCecExonerados> listarVoucherFicticiosAlumno(int id_des_alu){
          
         boolean estado=true;
        
         Query q = em.createQuery("SELECT object(p) FROM CepCecExonerados as p WHERE p.cepCecDescExonerados.idAluDesExo=:id_des_alu AND p.estadoExo=:estado");
         q.setParameter("estado", estado);
         q.setParameter("id_des_alu", id_des_alu);
         List<CepCecExonerados> resultados =q.getResultList();  
          if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }

      }
     
     
      @Override
     public int validarSiTieneVoucherFicticioElAlumno(int id_des_alu){
          
         boolean estado=true;
        
         Query q = em.createQuery("SELECT object(p) FROM CepCecExonerados as p WHERE p.cepCecDescExonerados.idAluDesExo=:id_des_alu AND p.estadoExo=:estado");
         q.setParameter("estado", estado);
         q.setParameter("id_des_alu", id_des_alu);
         List<CepCecExonerados> resultados =q.getResultList();  
          if (resultados.size()<=0){
                return 0; // No encontrado
            }else{
               // System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return 1; // Devuelve el alumno encontrado            
            }

      }
     
     @Override
     public CepCecExonerados verSiExisteVoucherFicticioAlumno(String secuencia , Date fecha , Short agencia , String cod_alumno , int id_curso_subdet ){
         boolean estado=true;
         Query q = em.createQuery("SELECT object(p) FROM CepCecExonerados as p WHERE p.cepCecDescExonerados.codAlumno=:cod_alumno AND p.codAgencia=:agencia AND p.fechaPago=:fecha AND p.secuencia=:secuencia AND p.cepCecDescExonerados.cepCecInversionCurso.cepCecCursoSubdet.idCursoSubdet=:id_curso_subdet AND p.estadoExo=:estado AND p.fechaUso IS NULL");
         q.setParameter("estado", estado);
         q.setParameter("secuencia", secuencia);
         q.setParameter("fecha", fecha);
         q.setParameter("agencia", agencia);
         q.setParameter("id_curso_subdet", id_curso_subdet);
         q.setParameter("cod_alumno", cod_alumno);

         List<CepCecExonerados> resultados =q.getResultList();  
          if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados.get(0); // Devuelve el alumno encontrado            
            }
      }
     
     
     @Override
     public CepCecExonerados verSiExisteVoucherFicticioNoAlumnoUns(String secuencia , Date fecha , Short agencia , String dni , int id_curso_subdet ){
         boolean estado=true;
         Query q = em.createQuery("SELECT object(p) FROM CepCecExonerados as p WHERE p.cepCecDescExonerados.numDocumento=:dni AND p.codAgencia=:agencia AND p.fechaPago=:fecha AND p.secuencia=:secuencia AND p.cepCecDescExonerados.cepCecInversionCurso.cepCecCursoSubdet.idCursoSubdet=:id_curso_subdet AND p.estadoExo=:estado AND p.fechaUso IS NULL");
         q.setParameter("estado", estado);
         q.setParameter("secuencia", secuencia);
         q.setParameter("fecha", fecha);
         q.setParameter("agencia", agencia);
         q.setParameter("id_curso_subdet", id_curso_subdet);
         q.setParameter("dni", dni);

         List<CepCecExonerados> resultados =q.getResultList();  
          if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados.get(0); // Devuelve el alumno encontrado            
            }
      }
     
     @Override
     public CepCecExonerados verSiExisteVoucherFicticioRegistroExterno(String secuencia , Date fecha , Short agencia , String dni  ){
        boolean estado=true;
         Query q = em.createQuery("SELECT object(p) FROM CepCecExonerados as p WHERE p.cepCecDescExonerados.numDocumento=:dni AND p.codAgencia=:agencia AND p.fechaPago=:fecha AND p.secuencia=:secuencia  AND p.estadoExo=:estado AND p.fechaUso IS NULL");
         q.setParameter("estado", estado);
         q.setParameter("secuencia", secuencia);
         q.setParameter("fecha", fecha);
         q.setParameter("agencia", agencia);
        // q.setParameter("id_curso_subdet", id_curso_subdet);
         q.setParameter("dni", dni);

         List<CepCecExonerados> resultados =q.getResultList();  
          if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados.get(0); // Devuelve el alumno encontrado            
            } 
     }
   
}
