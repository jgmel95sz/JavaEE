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
public class UsuarioEstGeneralDAO extends GenericoJPADAO<DrtPersonanatural> implements UsuarioEstGeneralDAOLocal {

    @Override
    public DrtPersonanatural validarEstGeneral(String dni) {
        Query q = em.createQuery("SELECT object(u) FROM DrtPersonanatural AS u WHERE u.numeroPndid = :dni");
        q.setParameter("dni", dni);
//        System.out.println("dni ingresado: " + dni);
        List<DrtPersonanatural> resultados = q.getResultList();
//        System.out.println("cantidad de resultado: " + resultados.size());
        if (resultados.size()<=0) {
            return null;  // No encontrado
        } else {
            return resultados.get(0);  // Devuelve el encontrado
        }
    }
    
    
    @Override
    public String buscarDni(Integer dir) {
        Query q = em.createQuery("SELECT object(u) FROM DrtPersonanatural AS u WHERE u.idDir=:dir");
        q.setParameter("dir", dir);
//        System.out.println("dni ingresado: " + dni);
        List<DrtPersonanatural> resultados = q.getResultList();
//        System.out.println("cantidad de resultado: " + resultados.size());
        if (resultados.size()<=0) {
            return null;  // No encontrado      
        } else {
            return resultados.get(0).getNumeroPndid();  // Devuelve el encontrado
        }
    }

    @Override
    public DrtPersonanatural CompararDni(String dni) {
        Query q = em.createQuery("SELECT object(u) FROM DrtPersonanatural AS u WHERE u.numeroPndid=:dni");
        q.setParameter("dni", dni);
//        System.out.println("dni ingresado: " + dni);
        List<DrtPersonanatural> resultados = q.getResultList();
//        System.out.println("cantidad de resultado: " + resultados.size());
        if (resultados.size()<=0) {
            return null;  // NO EXISTE      
        } else {
            return resultados.get(0);  // SI EXISTE
        }
    } 
    
}
