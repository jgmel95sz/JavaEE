package ejb.negocio;

import clases.trazaMsg;
import ejb.dao.UsuarioAdminDAOLocal;
import ejb.dao.UsuarioEstDAOLocal;
import ejb.dao.UsuarioEstGeneralDAOLocal;
import ejb.dao.UsuarioEstGeneralDAOLocal;
import entidades.DrtPersonanatural;
import entidades.PspUsuario;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class GestorUsuarioEstGeneralService implements GestorUsuarioEstGeneralServiceLocal {

    @EJB
    private UsuarioEstDAOLocal usuarioEstDAO;

    @EJB
    private UsuarioEstGeneralDAOLocal usuarioEstGeneralDAO;

    @EJB
    private UsuarioAdminDAOLocal usuarioAdminDAO;

    @Override
    public boolean validarEstGeneral(String dni, String pass) {
        boolean encontrado = false;
        try {
            DrtPersonanatural alumno;
            alumno = usuarioEstGeneralDAO.validarEstGeneral(dni);
            System.out.println("CONTRA BD; " + alumno.getPswa());
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

    @Override
    public boolean existeEstGeneral(String dni) {
        return (usuarioEstGeneralDAO.validarEstGeneral(dni)) != null;
    }

    @Override
    public trazaMsg recuperarDatosEstGeneral(String dni) {
        trazaMsg traza;
        
        if (usuarioAdminDAO.validarDocente(dni)!=null) { //Ops! es igual trabajdor uns o docente 
             return new trazaMsg(null, 3); // retorna null y el tipo de alumno es 3 osea trabajador UNS y vigente
        }else{
           if (!usuarioEstDAO.buscarPersonaEnAlumnosUNS(dni)) { //retorna FALSE Si ya existes
            return  new trazaMsg(null,1); // retorna null y tipo de alumno UNS
            }else{
                DrtPersonanatural persona = usuarioEstGeneralDAO.validarEstGeneral(dni);
               if (persona!=null) {
                   return new trazaMsg(persona,2); // retorna la entidad y el tipo de alumno Publico general
               }else{
                   return  new trazaMsg(null,0); // no encontro nada
               }
           }
        }
        
        

      
    }
    
    

    @Override
    public DrtPersonanatural crearEntidad(DrtPersonanatural entidad) {
        return usuarioEstGeneralDAO.crear(entidad);
    }

    @Override
    public DrtPersonanatural actualizarEntidad(DrtPersonanatural entidad) {
        return usuarioEstGeneralDAO.actualizar(entidad);
    }

    @Override
    public DrtPersonanatural BuscarDni(String dni) {
        DrtPersonanatural persona = new DrtPersonanatural();
        //busca si es alumno
        if (this.usuarioEstDAO.buscarPersonaEnAlumnosUNS(dni)) {

            System.out.println("No encontro dni");
            //ahora busca si es trabajador
            PspUsuario trabajdor = this.usuarioAdminDAO.validarDocente(dni);
            if (trabajdor == null) {
                //lo compara directamente a DrtPernatural
                
                persona  = usuarioEstGeneralDAO.CompararDni(dni);
                if (persona==null) {
                    System.out.println("No encontro dni");
                    return null; //crear persona desde 0
                } else {
                   
                    System.out.println("encontro");
                    return persona;
                }
            }else{
              return persona;
            }

        }else{
        return persona;
        }

    }

    @Override
    public DrtPersonanatural recuperarIdEntidadDrtPersona(int id) {
        return usuarioEstGeneralDAO.buscarPorId(id);
    }

}
