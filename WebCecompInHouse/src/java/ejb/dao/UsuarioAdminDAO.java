package ejb.dao;

import entidades.PspUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;



@Stateless
public class UsuarioAdminDAO extends GenericoJPADAO<PspUsuario> implements UsuarioAdminDAOLocal {

    @Override
    public PspUsuario validarUsuario(String usuario, String idCard) {
        Short estado=1;
        Query q = em.createQuery("SELECT object(u) FROM PspUsuario AS u WHERE  u.idUser = :idUser AND u.idTarjeta = :idTarjeta AND u.stdUid=:estado");
        q.setParameter("idUser", usuario);
        q.setParameter("idTarjeta", idCard);
        q.setParameter("estado", estado);
        List<PspUsuario> resultados = q.getResultList();
        if (resultados == null) {
            return null;  // No encontrado
        } else if (resultados.size() != 1) {
            return null; // No se encontro solo uno
        } else {
            return resultados.get(0);  // Devuelve el encontrado
        }
    }
    
    
    
    
    @Override
    public PspUsuario validarTrabajadorUNS(String idCard) {
        Query q = em.createQuery("SELECT object(u) FROM PspUsuario AS u WHERE  u.idTarjeta = :idTarjeta");
        q.setParameter("idTarjeta", idCard);
        List<PspUsuario> resultados = q.getResultList();
        if (resultados == null) {
            return null;  // No encontrado
        } else if (resultados.size() != 1) {
            return null; // No se encontro solo uno
        } else {
            return resultados.get(0);  // Devuelve el encontrado
        }
    }
    
    
        @Override
    public PspUsuario validarDocente(String dni) {
        Short estado=1;
        Query q = em.createQuery("SELECT object(u) FROM PspUsuario AS u WHERE u.drtDirectorio.drtPersonanatural.numeroPndid=:dni AND u.stdUid=:estado");
        q.setParameter("dni", dni);
        q.setParameter("estado",estado);

//        System.out.println("dni ingresado: " + dni);
        List<PspUsuario> resultados = q.getResultList();
//        System.out.println("cantidad de resultado: " + resultados.size());
        if (resultados.size() <= 0) {
            return null;  // No encontrado
        } else  {
            return resultados.get(0);  // Devuelve el encontrado
        }
    }
    
    
    

}
