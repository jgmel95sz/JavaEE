
package ejb.negocio;

import ejb.dao.CepCecGrupoCurDetalleDAOLocal;
import ejb.dao.UsuarioAdminDAOLocal;
import ejb.dao.UsuarioDocenteDAOLocal;
import ejb.dao.UsuarioEstGeneralDAOLocal;
import entidades.DrtPersonanatural;
import entidades.PspUsuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class GestorUsuarioDocenteService implements GestorUsuarioDocenteServiceLocal {

    @EJB
    private CepCecGrupoCurDetalleDAOLocal cepCecGrupoCurDetalleDAO;

    @EJB
    private UsuarioAdminDAOLocal usuarioAdminDAO;

    @EJB
    private UsuarioDocenteDAOLocal usuarioDocenteDAO;
    
    
    
    /*@Override
    public boolean validarDocente(String dni, String pass) {
        boolean encontrado = false;
        try {
            DrtPersonanatural alumno;
            alumno = usuarioDocenteDAO.validarEstGeneral(dni);
            if (alumno != null) {
//                System.out.println("si hay alumno existente");
                if (alumno.getPswa().equals(pass)) {
//                    System.out.println("el pass es correcto");
                    encontrado = true;
                }
            }
        } catch (Exception e) {
             System.err.println("Exception: " + e);
        }
        return encontrado;
    }
*/
     @Override
    public boolean validarUsuario(String usuario, String idCard, String clave) {
        PspUsuario usuarioActual;
        boolean encontrado = false;
        usuarioActual = usuarioAdminDAO.validarUsuario(usuario, idCard);
        System.out.println("CONTRA BD : "+usuarioActual.getPwd());
        if (usuarioActual !=null) {
            byte[] encClave = usuarioActual.getPwd();
            int tamanioClave = encClave.length;
            String cadena = "";
            for (int i = 0; i < tamanioClave -1; i++) {
                if(i % 2 == 0){
                    cadena = cadena + (char) (256 + encClave[i]);
                }
            }
            if (cadena.equals(clave)) {
                encontrado = true;
            }
        }
        return encontrado;
    }
    
    
     @Override
     public boolean validarSiEsDocente(int dir){
         return cepCecGrupoCurDetalleDAO.validarSiEsDocente(dir);
      }

    
    
    @Override
    public boolean existeDocente(String dni) {
        return (usuarioAdminDAO.validarDocente(dni)) != null;
    }

    @Override
    public DrtPersonanatural recuperarDatosDocente(String dni) {
        DrtPersonanatural docente = new DrtPersonanatural();
        try {
             docente =   usuarioAdminDAO.validarDocente(dni).getDrtDirectorio().getDrtPersonanatural();
             
           
        } catch (Exception e) {
            System.out.println("error recuperar docente en service");
        }
        if (docente!=null) {
            System.out.println("TENGO EL DOCENTE");
            return docente;
        }else{
             System.out.println("NO TENGO EL DOCENTE");

            return null;
        }
        
    }

     @Override
    public List<DrtPersonanatural> listarDocentes(String dni) {
        return usuarioDocenteDAO.listarDocente(dni);
    }
    
       @Override
    public DrtPersonanatural recuperarIdDocente(int id) {
        return usuarioDocenteDAO.buscarPorId(id);
    }
}
