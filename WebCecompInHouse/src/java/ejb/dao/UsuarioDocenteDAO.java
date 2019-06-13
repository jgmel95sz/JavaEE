/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.DrtPersonanatural;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class UsuarioDocenteDAO extends GenericoJPADAO<DrtPersonanatural> implements UsuarioDocenteDAOLocal {

    @Override
    public DrtPersonanatural validarEstGeneral(String dni) {
        Query q = em.createQuery("SELECT object(u) FROM DrtPersonanatural AS u WHERE u.numeroPndid = :dni");
        q.setParameter("dni", dni);
//        System.out.println("dni ingresado: " + dni);
        List<DrtPersonanatural> resultados = q.getResultList();
//        System.out.println("cantidad de resultado: " + resultados.size());
        if (resultados == null) {
            return null;  // No encontrado
        } else if (resultados.size() != 1) {
            return null; // No se encontro solo uno
        } else {
            return resultados.get(0);  // Devuelve el encontrado
        }
    }
    
    
       @Override
    public List<DrtPersonanatural> listarDocente(String dni) {
        Query q = em.createQuery("SELECT object(u) FROM DrtPersonanatural as u WHERE u.numeroPndid = :dni");
        q.setParameter("dni", dni);
        List<DrtPersonanatural> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            return null;
        } else {
            return resultados;
        }
    }
    
   

}