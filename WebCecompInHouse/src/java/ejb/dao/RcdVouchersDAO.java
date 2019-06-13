/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.RcdVoucher;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class RcdVouchersDAO extends GenericoJPADAO<RcdVoucher> implements RcdVouchersDAOLocal{

  /* @Override
    public RcdVoucher buscarPagoDeVoucherAlumno(String cod_alumno, Integer secuencia, Date fecha, Short agencia, Integer concepto){
        Query q=em.createQuery(" SELECT object(u) FROM RcdVoucher AS u WHERE u.codAlumno= :cod_alumno and u.secuencia=:secuencia and u.fechaPago=:fecha and u.codAgencia=:agencia and u.rcdConcepto.idConcepto=:concepto  "); //and u.estado= :estado
        q.setParameter("cod_alumno", cod_alumno);
        q.setParameter("secuencia", secuencia);
        q.setParameter("fecha", fecha);
        q.setParameter("agencia", agencia);
        q.setParameter("concepto", concepto);
        
         List<RcdVoucher> resultados =q.getResultList();  
         if (resultados.size() <= 0) {
            return null; // No encontrado
         } else {
             return resultados.get(0); // Devuelve el alumno encontrado            
         }
    }
    */
    
    @Override
    public List<RcdVoucher> buscarPagoDeVoucherAlumno(String cod_alumno, Integer secuencia, Date fecha, Short agencia, Integer concepto ){
        System.out.println("DAO VOUCER");
        //Query q=em.createQuery(" SELECT object(u) FROM RcdVoucher AS u WHERE u.codAlumno=:cod_alumno AND u.rcdConcepto.idConcepto=:concepto AND u.secuencia=:secuencia  AND u.codAgencia=:agencia "); 
        
        Query q=em.createQuery("SELECT object(u) FROM RcdVoucher AS u WHERE u.secuencia=:secuencia AND u.fechaPago=:fecha AND u.codAgencia = :agencia AND u.rcdConcepto.idConcepto=:concepto AND u.codAlumno =:cod_alumno "); 
        q.setParameter("cod_alumno", cod_alumno);
        q.setParameter("secuencia", secuencia);
        q.setParameter("fecha", fecha);
        q.setParameter("agencia", agencia);
        q.setParameter("concepto", concepto);
        
         List<RcdVoucher> resultados = q.getResultList();
         for (RcdVoucher resultado : resultados) {
                 System.out.println(""+resultado.getSecuencia());  
                System.out.println(""+ resultado.getRcdConcepto().getIdConcepto());
                 System.out.println(""+resultado.getFechaPago());
                  System.out.println(""+resultado.getCodAgencia());
                  System.out.println(""+resultado.getCodAlumno());
                  System.out.println(""+resultado.getImportePagado());

        }
       
         
         if (resultados.size()<=0){
             System.out.println("no encotrno");
                return null; // No encontrado
            }else{
             System.out.println("encontro ALGUITO");
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }
          
    }
    
    
    @Override
    public List<RcdVoucher> buscarPagoDeVoucherAluGeneral(String dni, Integer secuencia, Date fecha, Short agencia, Integer concepto ){
        System.out.println("DAO VOUCER");
        //Query q=em.createQuery(" SELECT object(u) FROM RcdVoucher AS u WHERE u.codAlumno=:cod_alumno AND u.rcdConcepto.idConcepto=:concepto AND u.secuencia=:secuencia  AND u.codAgencia=:agencia "); 
        
        Query q=em.createQuery("SELECT object(u) FROM RcdVoucher AS u WHERE u.secuencia=:secuencia AND u.fechaPago=:fecha AND u.codAgencia = :agencia AND u.rcdConcepto.idConcepto=:concepto AND u.numDocumento = :dni "); 
        q.setParameter("dni", dni);
        q.setParameter("secuencia", secuencia);
        q.setParameter("fecha", fecha);
        q.setParameter("agencia", agencia);
        q.setParameter("concepto", concepto);
        
         List<RcdVoucher> resultados = q.getResultList();
         for (RcdVoucher resultado : resultados) {
                 System.out.println(""+resultado.getSecuencia());  
                System.out.println(""+ resultado.getRcdConcepto().getIdConcepto());
                 System.out.println(""+resultado.getFechaPago());
                  System.out.println(""+resultado.getCodAgencia());
                  System.out.println(""+resultado.getNumDocumento());
                  System.out.println(""+resultado.getImportePagado());

        }
       
         
         if (resultados.size()<=0){
             System.out.println("no encotrno");
                return null; // No encontrado
            }else{
             System.out.println("encontro ALGUITO");
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }
          
    }
    
    
    
    
    
}
