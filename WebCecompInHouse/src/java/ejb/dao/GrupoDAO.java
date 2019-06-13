/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecGrupo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author MELVN
 */
@Stateless
public class GrupoDAO extends GenericoJPADAO<CepCecGrupo> implements GrupoDAOLocal{

    
    @Override  
     public List<CepCecGrupo> buscarTodos(){
      Query q = em.createQuery("SELECT object(p) FROM CepCecGrupo as p");
      List<CepCecGrupo> resultados =q.getResultList();  
      if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }
     }
}
