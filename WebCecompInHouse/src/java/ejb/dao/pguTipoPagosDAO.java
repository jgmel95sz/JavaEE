/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.PguTipoPagos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class pguTipoPagosDAO extends GenericoJPADAO<PguTipoPagos> implements pguTipoPagosDAOLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    // Busca todos los cursos registrados en la bd
    /*
    @Override
     public List<PguTipoPagos> buscarTodosConceptosCecomp(String name){
        Query q = em.createQuery
        ("SELECT object(p) FROM PguTipoPagos as p WHERE p.idDep=113 AND (p.concepto LIKE concat('%',:name,'%') OR p.concepto LIKE upper(concat('%',:name,'%')) OR p.concepto LIKE lower(concat('%',:name,'%')) AND  "
                + " p.concepto   LIKE concat( '%',:name,'%' )     ) " );
        q.setParameter("name", name);
        List<PguTipoPagos> resultados =q.getResultList();  
        if (resultados.size()<=0){
              System.out.println("no encontro");
                  return null; // No encontrado
              }else{
                  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados;
                  // Devuelve el alumno encontrado            
              }
       }  */
     
     @Override
     public List<PguTipoPagos> buscarTodosConceptosCecomp(String name){
         Integer id_dep=113;
         Query q = em.createQuery("SELECT object(p) FROM PguTipoPagos as p WHERE p.orgDependencia.idDep=:id_dep" );
             q.setParameter("id_dep", id_dep);
         List<PguTipoPagos> resultados =q.getResultList();  
        if (resultados.size()<=0){
              System.out.println("no encontro");
                  return null; // No encontrado
              }else{
                  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados;
                  // Devuelve el alumno encontrado            
              }
       }
     
      @Override
    public PguTipoPagos capturarPrecio(Integer idTipopag) {
                 System.out.println("EN  DAO");
    
        Query q = em.createQuery("SELECT object(u) FROM PguTipoPagos AS u WHERE u.idTipopag = :idTipopag");
    
        q.setParameter("idTipopag", idTipopag);
//        System.out.println("dni ingresado: " + dni);
        List<PguTipoPagos> resultados = q.getResultList();
//        System.out.println("cantidad de resultado: " + resultados.size());
        if (resultados == null) {
            return null;  // No encontrado
        } else if (resultados.size() != 1) {
            return null; // No se encontro solo uno
        } else {
                             System.out.println("EN  DAO SI DIO");

            return resultados.get(0);  // Devuelve el encontrado
        }
    }
    
    
     @Override
     public PguTipoPagos buscarRepeticionConcepto(String name,Float precio){
        Integer id_dep=113;
        
         Query q = em.createQuery("SELECT object(p) FROM PguTipoPagos as p WHERE p.orgDependencia.idDep=:id_dep AND p.concepto=:name AND p.precio=:precio" );
         q.setParameter("id_dep", id_dep);
         q.setParameter("name", name);
         q.setParameter("precio", precio);
        List<PguTipoPagos> resultados =q.getResultList();  
        if (resultados.size()<=0 || resultados.size() > 1 ){
              System.out.println("no encontro DAO TIPOPAGO");
                  return null; // No encontrado
              }else{
                 // System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                 System.out.println("si encontro en DAO TIPOPAGO");
                  return resultados.get(0);
                  // Devuelve el alumno encontrado            
              }
       }
     
}
