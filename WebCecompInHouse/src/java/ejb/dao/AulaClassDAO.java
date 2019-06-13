/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepAulaClass;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author MELVN
 */
@Stateless
public class AulaClassDAO extends GenericoJPADAO<CepAulaClass> implements AulaClassDAOLocal {

      // Busca todos los cursos registrados en la bd
     @Override
     public List<CepAulaClass> buscarTodos(){
        String lugar = "CECOMP";
        Query q = em.createQuery("SELECT object(p) FROM CepAulaClass as p WHERE p.lugar = :Lugar");
        q.setParameter("Lugar", lugar);
        List<CepAulaClass> resultados =q.getResultList();  
        if (resultados.size()<=0){
            System.out.println("No encontro nada en la sentencia pql para aulas");
                  return null; // No encontrado
              }else{
                System.out.println("Si encontro datos en la sentencia pql para aulas");
                  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados; // Devuelve el alumno encontrado            
              }
       }
    
}
