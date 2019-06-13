/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.FxaEstudiante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;


@Stateless
public class UsuarioEstDAO extends GenericoJPADAO<FxaEstudiante> implements UsuarioEstDAOLocal {

    @Override
    public FxaEstudiante validarEstudiante(String codigo, String dni) {
        Query q = em.createQuery("SELECT object(u) FROM FxaEstudiante AS u WHERE u.codigoEstudiante = :codigo AND u.drtPersonanatural.numeroPndid = :dni");
        q.setParameter("codigo", codigo);
        q.setParameter("dni", dni);
        List<FxaEstudiante> resultados = q.getResultList();
        if (resultados ==null) {
            return null;  // No encontrado
        }
        else if (resultados.size() != 1){
            return null; // No se encontro solo uno
        }
        else {
            return resultados.get(0);  // Devuelve el encontrado
        }
    }
    
     @Override
      public FxaEstudiante buscarAlumno(String codigo){
             Query q = em.createQuery("SELECT object(u) FROM FxaEstudiante AS u WHERE u.codigoEstudiante = :codigo");
             q.setParameter("codigo", codigo);
             List<FxaEstudiante> resultados = q.getResultList();
        if (resultados.size()<=0) {
            return null;  // No encontrado
        }  else {
            return resultados.get(0);  // Devuelve el encontrado
        }
      };
      
      
     @Override
      public boolean buscarPersonaEnAlumnosUNS(String dni){
             Query q = em.createQuery("SELECT object(u) FROM FxaEstudiante AS u WHERE u.drtPersonanatural.numeroPndid = :dni");
             q.setParameter("dni", dni);
             List<FxaEstudiante> resultados = q.getResultList();
        if (resultados.size()<=0) {
            return true;  // NO EXISTE
        }  else {
            return false;  // SI EXISTE
        }
      };

}
