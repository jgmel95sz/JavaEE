/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecDescExonerados;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class DescuentoExoDAO extends GenericoJPADAO<CepCecDescExonerados> implements DescuentoExoDAOLocal {

    
     @Override
     public List<CepCecDescExonerados> buscarMediasBecas(int idinversion,int pageNumber){
         boolean estado=true;
         int idtipoinver=2; //media beca
         Query q = em.createQuery("SELECT object(p) FROM CepCecDescExonerados as p WHERE p.cepCecInversionCurso.idInversion=:idinversion AND p.estadoDes=:estado AND p.cepCecInversionCurso.cepCecTipoInversion.idTipoinversion=:idtipoinver");
         q.setParameter("idinversion", idinversion);
         q.setParameter("estado", estado);
         q.setParameter("idtipoinver", idtipoinver);
 
        //********************AÑADIR SOLO ESTA PARTE Y EL PARAMETRO*********************************
         //int pageNumber = 1;
        int pageSize=5;
        q.setFirstResult((pageNumber-1) * pageSize); //El primer registro **considerar que comienza desde 0
        q.setMaxResults(pageSize); //el tamaño maximo de registros a mostrar 
        //********************AÑADIR SOLO ESTA PARTE*********************************

         List<CepCecDescExonerados> resultados =q.getResultList();  
          if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }

     }
     
     @Override
    public long calculandoTotalRegistrosMediasBecas(int idinversion){
           ///Calculando el total de registros  
         Boolean estado = true;
         Query queryTotal = em.createQuery("Select count(f.idAluDesExo) from CepCecDescExonerados as f WHERE f.estadoDes=:estado AND f.cepCecInversionCurso.idInversion=:idinversion");
         queryTotal.setParameter("estado", estado);
         queryTotal.setParameter("idinversion", idinversion);
         long countResult = (long)queryTotal.getSingleResult();  
         System.out.println("Total de registro de Todos los Grupos = "+countResult);
        ///Fin calculo total de registros
        //int countResult = 56;
         //int pageNumber = 1;
         return countResult;
    }
     
     
     @Override
     public List<CepCecDescExonerados> buscarBecas(int idcursodetsub){
         boolean estado=true;
         int idtipoinverBeca=7; //media beca
         int idtipoinverDesc=8; //Descuento por planilla
         Short estadoinver = 1;
         Query q = em.createQuery("SELECT object(p) FROM CepCecDescExonerados as p WHERE p.cepCecInversionCurso.cepCecCursoSubdet.idCursoSubdet=:idcursodetsub AND p.estadoDes=:estado AND (p.cepCecInversionCurso.cepCecTipoInversion.idTipoinversion=:idtipoinverBeca OR  p.cepCecInversionCurso.cepCecTipoInversion.idTipoinversion=:idtipoinverDesc) AND p.cepCecInversionCurso.estadoInver=:estadoinver");
         q.setParameter("idcursodetsub", idcursodetsub);
         q.setParameter("estado", estado);
         q.setParameter("idtipoinverBeca", idtipoinverBeca);
         q.setParameter("idtipoinverDesc", idtipoinverDesc);
        q.setParameter("estadoinver", estadoinver);



         List<CepCecDescExonerados> resultados =q.getResultList();  
          if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }

     }
     
      @Override
      public CepCecDescExonerados validarLaNoRepeticionAlumnoUns(int id_inversion_curso, String codigoUns){
          
         boolean estado=true;
        
         Query q = em.createQuery("SELECT object(p) FROM CepCecDescExonerados as p WHERE p.cepCecInversionCurso.idInversion=:id_inversion_curso AND p.codAlumno=:codigoUns AND p.estadoDes=:estado");
         q.setParameter("codigoUns", codigoUns);
         q.setParameter("estado", estado);
         q.setParameter("id_inversion_curso", id_inversion_curso);
         List<CepCecDescExonerados> resultados =q.getResultList();  
          if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados.get(0); // Devuelve el alumno encontrado            
            }

      }
      
    
    @Override
     public CepCecDescExonerados validarLaNoRepeticionPubGeneral(int id_inversion_curso, String dni){
          
         boolean estado=true;
        
         Query q = em.createQuery("SELECT object(p) FROM CepCecDescExonerados as p WHERE p.cepCecInversionCurso.idInversion=:id_inversion_curso AND p.numDocumento=:dni AND p.estadoDes=:estado");
         q.setParameter("dni", dni);
         q.setParameter("estado", estado);
         q.setParameter("id_inversion_curso", id_inversion_curso);
         List<CepCecDescExonerados> resultados =q.getResultList();  
          if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados.get(0); // Devuelve el alumno encontrado            
            }

      } 

     
    
    
}
