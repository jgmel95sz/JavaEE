/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecHorarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author MELVN
 */
@Stateless
public class HorariosDAO extends GenericoJPADAO<CepCecHorarios> implements HorariosDAOLocal {
        // Busca todos los cursos registrados en la bd
     @Override
     public List<CepCecHorarios> buscarTodos(){
        Query q = em.createQuery("SELECT object(p) FROM CepCecHorarios as p");
        List<CepCecHorarios> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados; // Devuelve el alumno encontrado            
              }
       }
     
      @Override
    public List<CepCecHorarios> listarHorarioPorId(int id) {
        Query q = em.createQuery("SELECT object(u) FROM CepCecHorarios as u WHERE u.idHorario = :id");
        q.setParameter("id", id);
        List<CepCecHorarios> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            return null;
        } else {
            return resultados;
        }
    }
    
    
      @Override
     public CepCecHorarios capturarHorarioPorId(Integer id) {
        Short estado = 1;
        Query q = em.createQuery("SELECT object(u) FROM CepCecHorarios as u WHERE u.idHorario = :id AND u.estadoHorario=:estado");
        q.setParameter("id", id);
        q.setParameter("estado", estado);
        List<CepCecHorarios> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            return null;
        } else {
            return resultados.get(0);
        }
    }

}
