/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecTema;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class TemaPlanDAO extends GenericoJPADAO<CepCecTema> implements TemaPlanDAOLocal {

    @Override
    public List<CepCecTema> buscarTodos(Integer idSesion){
        
        System.out.println("INGRESA A DAO TEMA");
        Short estado=1;
        Query q = em.createQuery("SELECT object(c) FROM CepCecTema as c WHERE c.cepCecSesion.idSesion = :idSesionsita AND c.estadoTema=:estado");
        q.setParameter("idSesionsita", idSesion);
         q.setParameter("estado", estado);
        List<CepCecTema> resultados =q.getResultList();  
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
}
