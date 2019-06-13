/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.PguPagospersDet;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class PguPagosDetDAO extends GenericoJPADAO<PguPagospersDet> implements PguPagosDetDAOLocal {
    
    @Override
    public Short buscarPago(String secuencia, Date fecha, Float monto ,Integer dir){                              
        boolean estado = true;
       Query q;
        List<PguPagospersDet> resultados;
       
            q=em.createQuery("SELECT object(u) FROM PguPagospersDet AS u WHERE u.pguPagospersCab.idDir =:dir AND u.monto = :monto AND u.nroOperacion  = :secuencia AND u.fechaOper=:fecha AND u.estado=:estado "); 
            q.setParameter("dir", dir);
            q.setParameter("secuencia", secuencia);
            q.setParameter("fecha", fecha);
            q.setParameter("monto", monto);
            q.setParameter("estado", estado);
            resultados = q.getResultList();
            
            if (resultados.size()<=0){
             System.out.println("no encotrno en PAGOS");
             System.out.println("voucher no fue usado");
                return 0; // No encontrado
            }else{
             System.out.println("encontro ALGUITO en PAGOS");
             System.out.println("voucher usado");
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return 1; // Devuelve el alumno encontrado            
            }
    }
    
    
    
    
    
   @Override
   public PguPagospersDet buscarPagoPorAlumnoMatriculado(Integer id_pgucab){                              
       boolean estado = true;
        Query q=em.createQuery("SELECT object(u) FROM PguPagospersDet AS u WHERE u.pguPagospersCab.idNumpago=:id_pgucab AND u.estado=:estado"); 
         q.setParameter("id_pgucab", id_pgucab);
         q.setParameter("estado", estado);
         List<PguPagospersDet> resultados = q.getResultList();

        if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                return resultados.get(0); // Devuelve el alumno encontrado            
            }
   }
   
   
   @Override
   public List<PguPagospersDet> BuscarDirParaValidarVoucher(String secuencia, Date fecha, Float monto ){
   boolean estado = true;
   Query q;
   List<PguPagospersDet> resultados;
       
    q=em.createQuery("SELECT object(u) FROM PguPagospersDet AS u WHERE  u.monto = :monto AND u.nroOperacion  = :secuencia AND u.fechaOper=:fecha AND u.estado=:estado "); 
             q.setParameter("secuencia", secuencia);
             q.setParameter("fecha", fecha);
             q.setParameter("monto", monto);
             q.setParameter("estado", estado);
             resultados = q.getResultList();
             
             if (resultados.size()<=0){
             System.out.println("no encotrno en PAGOS");
             System.out.println("voucher no fue usado");
                return null; // No encontrado
            }else{
             System.out.println("encontro ALGUITO en PAGOS");
             System.out.println("voucher usado");
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }
   
   }
   
}
