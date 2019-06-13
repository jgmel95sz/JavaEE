/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.RcdConcepto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class RcdConceptoDAO  extends GenericoJPADAO<RcdConcepto> implements RcdConceptoDAOLocal {
     
    
    @Override
    public List<RcdConcepto> buscarConceptosCecomp(){
        String tipo="CECOMP";
        Short estado=1;
        Query q = em.createQuery("SELECT object(c) FROM RcdConcepto as c WHERE c.tipo=:tipo" );
        q.setParameter("tipo", tipo);
        List<RcdConcepto> resultados =q.getResultList();  
        if (resultados.size()<=0){
            return null; // No encontrado
        }else{
            return resultados;// Devuelve el alumno encontrado            
        }
    }
    
 /*   
     @Override
    public List<RcdConcepto> buscarConceptos(){
        String tipo="CECOMP";
        Short estado=1;
        Query q = em.createQuery("SELECT object(c) FROM RcdConcepto as c WHERE c.tipo=:tipo " );
        q.setParameter("tipo", tipo);
        List<RcdConcepto> resultados =q.getResultList();  
        if (resultados.size()<=0){
            return null; // No encontrado
        }else{
            return resultados;// Devuelve el alumno encontrado            
        }
    }*/
}
