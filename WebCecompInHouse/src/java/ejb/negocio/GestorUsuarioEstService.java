/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.trazaMsg;
import ejb.dao.UsuarioAdminDAOLocal;
import ejb.dao.UsuarioEstDAOLocal;
import entidades.FxaEstudiante;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Victor Lluen
 */
@Stateless
public class GestorUsuarioEstService implements GestorUsuarioEstServiceLocal {

    @EJB
    private UsuarioEstDAOLocal usuarioEstDAO;
    
      @EJB
    private UsuarioAdminDAOLocal usuarioAdminDAO;
      
    @Override
    public boolean validarAlumno(String codigo, String dni, String clave) {
        boolean encontrado = false;
        try {
            FxaEstudiante alumno;
            alumno = usuarioEstDAO.validarEstudiante(codigo, dni);
            if (alumno != null) {
                System.out.println("PasswOrd Encriptado en la bd es "+alumno.getPassEnc());
                if (alumno.getPassEnc().equals(clave)) {
                    encontrado = true;
                }
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
        return encontrado;
    }

    @Override
    public boolean existeAlumno(String codigo, String dni) {
        return (usuarioEstDAO.validarEstudiante(codigo, dni)) != null;
    }

    @Override
    public FxaEstudiante recuperarDatosUsuario(String codigo, String dni) {
        return usuarioEstDAO.validarEstudiante(codigo, dni);
    }

    @Override
     public trazaMsg buscarAlumno(String codigo){
         trazaMsg traza;
         System.out.println("SERVICE");
         try {
             FxaEstudiante estudiante = usuarioEstDAO.buscarAlumno(codigo);
             System.out.println("ESTUDIANTE = "+estudiante.getDrtPersonanatural().getNombreCompleto());
         if ( estudiante != null) {
             
             if ( usuarioAdminDAO.validarDocente(estudiante.getDrtPersonanatural().getNumeroPndid())!=null) {
                  System.out.println("3");
                 return new trazaMsg(null,3); // es trabajador
             }else{
                  System.out.println("ENCONTROOOOOOOOOOOO");
                  return new trazaMsg(estudiante.getDrtPersonanatural(),1);//encontro 
             }
        }else{
               System.out.println("0");
               return new trazaMsg(null,0);//no encontro nada
         }
        } catch (Exception e) {
             System.out.println("Error en el service usuarioEst");
            return new trazaMsg(null,0);//no encontro nada
        }
      
        
      
     
     };

   
}
