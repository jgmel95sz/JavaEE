/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.trazaMsg;
import ejb.dao.UsuarioAdminDAOLocal;
import ejb.dao.UsuarioEstDAOLocal;
import ejb.dao.UsuarioEstGeneralDAOLocal;
import entidades.DrtPersonanatural;
//import entidades.FxaEstudiante;
import entidades.PspUsuario;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class GestorUsuarioAdminService implements GestorUsuarioAdminServiceLocal {

    @EJB
    private UsuarioAdminDAOLocal usuarioAdminDAO;
    
     @EJB
    private UsuarioEstDAOLocal usuarioEstDAO;

    @EJB
    private UsuarioEstGeneralDAOLocal usuarioEstGeneralDAO;

    
    @Override
    public boolean validarUsuario(String usuario, String idCard, String clave) {
        PspUsuario usuarioActual;
        boolean encontrado = false;
        try {
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
        } catch (Exception e) {
           
        }
       
        return encontrado;
    }

    @Override
    public PspUsuario buscarUsuario(String usuario, String idCard) {
        PspUsuario usuarioActual;
        usuarioActual = usuarioAdminDAO.validarUsuario(usuario, idCard);
        return usuarioActual;
    }
    
    @Override
    public PspUsuario buscarTrabajadorUNS(String idCard) {
        return  usuarioAdminDAO.validarTrabajadorUNS(idCard);
    }
    
    @Override
    public trazaMsg buscarTrabajadorUNSporDni(String dni) {
        
        PspUsuario pspusuario =   usuarioAdminDAO.validarDocente(dni);
        trazaMsg traza;
        if (pspusuario!=null) { //Ops! es igual trabajdor uns o docente 
             return new trazaMsg(pspusuario.getDrtDirectorio().getDrtPersonanatural(), 3); // retorna null y el tipo de alumno es 3 osea trabajador UNS y vigente
        }else{
           if (!usuarioEstDAO.buscarPersonaEnAlumnosUNS(dni)) { //retorna FALSE Si ya existes
            return  new trazaMsg(null,1); // retorna null y tipo de alumno UNS
            }else{
                DrtPersonanatural persona = usuarioEstGeneralDAO.validarEstGeneral(dni);
               if (persona!=null) {
                   return new trazaMsg(null,2); // retorna la entidad y el tipo de alumno Publico general
               }else{
                   return  new trazaMsg(null,0); // no encontro nada
               }
           }
        }
               
       
      
    }
    

}
