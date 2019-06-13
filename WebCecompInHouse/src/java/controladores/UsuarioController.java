/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.trazaMsg;
import ejb.negocio.DrtDepartamentoServiceLocal;
//import ejb.negocio.DrtDirectorioClaseService;
import ejb.negocio.DrtDirectorioClaseServiceLocal;
import ejb.negocio.DrtDirectorioServiceLocal;
import ejb.negocio.DrtDistritoServiceLocal;
import ejb.negocio.DrtDocidentidadServiceLocal;
import ejb.negocio.DrtPaisServiceLocal;
import ejb.negocio.DrtPernatUnsServiceLocal;
import ejb.negocio.DrtProvinciaServiceLocal;
import ejb.negocio.DrtTipoPerUnsServiceLocal;
import ejb.negocio.GestorUsuarioAdminServiceLocal;
import ejb.negocio.GestorUsuarioDocenteServiceLocal;
import ejb.negocio.GestorUsuarioEstGeneralServiceLocal;
import ejb.negocio.GestorUsuarioEstServiceLocal;
import ejb.negocio.PspUserAppServiceLocal;
import entidades.DrtDepartamento;
import entidades.DrtDirectorio;
import entidades.DrtDirectorioClase;
import entidades.DrtDistrito;
import entidades.DrtDocidentidad;
import entidades.DrtPais;
import entidades.DrtPernatUns;
import entidades.DrtPersonanatural;
import entidades.DrtProvincia;
import entidades.DrtTipoPeruns;
import entidades.FxaEstudiante;
import entidades.PspUsuario;
import java.io.IOException;
//import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import frameworkHANM.*;  // poner en el usuario controller
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author Melvin
 */
@ManagedBean(name = "usuarioController")
//@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController  implements Serializable{


  // 1. Atributos    

    //public Integer editPlan; //  para saber si se puede editar o no el plan
    // Trabajador de cecomp
    private String usuarioTrab;
    private String idCardTrab ;
    private String passTrab;

    //Estudiante UNS
    private String codigoEst;
    private String dniEst;
    private String passEstu;

    //Estudiante Trabajador
    private String usuarioEstTrab ;
    private String idCardEstTrab;
    private String passEstTrab;
    private String dniTrabaj;

    //Estudiante General
    private String dniEstGene;
    private String passEstGene;
    
     //Docente Cecomp
    private String dniDocente;
    private String passDocente ;
    private String idCardDocen;
    private String userDocente;

    //Estado de loguin
    private boolean logeado;
   

    //Usuario actual
    private PspUsuario usuarioActualEmp ;
    private FxaEstudiante estudianteActualUns ;
    private DrtPersonanatural estudianteActualGene ;
    private DrtPersonanatural DocenteActual ;
    private DrtPersonanatural drtPersonanatural;
    private int id_dir;
    //Tipo de acceso
    private String acceso;

    //Nombre Accesido
    private String nomAccedido;

    //Para encriptar clave de empleado
    private byte[] claveByte;

    //atribuo basecontroller
    private fwGeneral1 framework1 = new fwGeneral1();
    private fwGeneral2 framework = new fwGeneral2();
    //public fwGeneral2 baseController;
    //public fwGeneral1 baseController1;
    private int id_curso_subdet; // se usa para caputrar el id del cur_det para mandar al controlador grupo 
    public int enabled_docente; // se usa par alos botones en seleccion de docentes
    private int tipo_alumno; 
    public int id_plan; //se usa para caputrar el plan
    private int id_curso_grupo;
    private int num_matriculados;
    //public String numdni;
    private String numdni;
    private int sexo;
    //Para crear
    private List<DrtDocidentidad> lstdrtDocidentidad;
    private List<DrtPais> lstPaises;
    private List<DrtDepartamento> lstDepartamentos;
    private List<DrtProvincia> lstProvincias;
    private List<DrtDistrito> lstDistritos;
    private List<DrtDepartamento> lstDep;
    private List<DrtProvincia> lstPro;
    private List<DrtDistrito> lstDis;
    private DrtDocidentidad drtDocidentidad;
    private DrtDepartamento drtDepartamento;
    private DrtProvincia drtProvincia;
    private DrtDistrito drtDistrito;
    private DrtDepartamento drtDep;
    private DrtProvincia drtPro;
    private DrtDistrito drtDis;
    private Integer id_ubg_nac; // Nacimiento
    private Integer id_ubg_pro; // residencia
    private DrtDirectorioClase drtDirectorioClase;
    private DrtDirectorio drtDirectorio;
    private DrtPernatUns drtPernatUns;
    private DrtTipoPeruns drtTipoPeruns;
    
    
    //2.EJB
    @EJB
    private GestorUsuarioAdminServiceLocal gestorUsuarioAdminService;
    @EJB
    private GestorUsuarioEstServiceLocal gestorUsuarioEstService;
    @EJB
    private GestorUsuarioEstGeneralServiceLocal gestorUsuarioEstGeneralService;
    @EJB
    private GestorUsuarioDocenteServiceLocal gestorUsuarioDocenteService;
    @EJB
    private DrtTipoPerUnsServiceLocal drtTipoPerUnsService;
    @EJB
    private DrtProvinciaServiceLocal drtProvinciaService;
    @EJB
    private DrtPernatUnsServiceLocal drtPernatUnsService;
    @EJB
    private DrtPaisServiceLocal drtPaisService;
    @EJB
    private DrtDocidentidadServiceLocal drtDocidentidadService;
    @EJB
    private DrtDistritoServiceLocal drtDistritoService;
    @EJB
    private DrtDirectorioServiceLocal drtDirectorioService;
    @EJB
    private DrtDirectorioClaseServiceLocal drtDirectorioClaseService;
    @EJB
    private DrtDepartamentoServiceLocal drtDepartamentoService;
     @EJB
    private PspUserAppServiceLocal pspUserAppService;
    
    public UsuarioController() {
        
    }

    //3. do 
 public void doLoginAdministrador() {
       //validar si es un empleado
        System.out.println("LOGEANDO");
        System.out.println("USUARIO : "+usuarioTrab);
        System.out.println("CARD : "+idCardTrab );
        System.out.println("CONTRA: "+framework.doEncriptar2(passTrab));
        try {
            
           if (gestorUsuarioAdminService.validarUsuario(usuarioTrab, idCardTrab, framework.doEncriptar2(passTrab))) {//framework.doEncriptar(passTrab,"SHA-1")
            //busca al usuario actual mediante su usuario y su idCard
            usuarioActualEmp = gestorUsuarioAdminService.buscarUsuario(usuarioTrab, idCardTrab);
            
             // si es true entonces tiene acceso al sistema como administrador el trabajdor
               if (pspUserAppService.tieneAccesoComoAdministrador(usuarioActualEmp.getUid())) {
                   // está logeado
                    logeado = true;
                    // el acceso es del administrador
                    acceso = "ADMINISTRADOR";
                    //obtiene el nombre del usuario accedido
                    nomAccedido = usuarioActualEmp.getDrtDirectorio().getDrtPersonanatural().getNombreCompleto();
                    System.out.println("LOGEADO ADMINISTRADOR");
                    //llama a la función para que redireccione a su pagina de administrador
                   drtPersonanatural = new DrtPersonanatural();
                                    try {
                                           drtPersonanatural = usuarioActualEmp.getDrtDirectorio().getDrtPersonanatural();
                                    } catch (Exception e) {
                                           framework.doMensajeF("Mensaje", "Error Data Invalidad", 4);

                                    }
                    logeadoAdmin();
               }  else {
                    // no se pudo logear logeado
                    logeado = false;
                    System.out.println("Usted No está autorisado para ese sistema");
                   framework.doMensajeF("Mensaje", "Usted No está autorisado para ese sistema", 4);
                    //doMensajeR("Mensaje", "Usted No está autorisado para ese sistema", 4);
                }
               
            } else {
                 //no se pudo logear logeado
               logeado = false;
               framework.doMensajeF("Error", "El Usuario, id Tarjeta o Contraseña es incorrecto", 4);
               System.out.println("El Usuario, id Tarjeta o Contraseña es incorrecto");
           }
            
        } catch (Exception e) {
           framework.doMensajeF("Mensaje", "Contraseña Incorrecta", 4);
        }
 
       
    }
    
    
     //3. do house

   /*public void doLoginAdministrador() {
       //validar si es un empleado
        System.out.println("LOGEANDO");
        System.out.println("USUARIO : "+usuarioTrab);
        System.out.println("CARD : "+idCardTrab );
        System.out.println("CONTRA: "+framework.doEncriptar2(passTrab));
        try {
            
           //if (gestorUsuarioAdminService.validarUsuario(usuarioTrab, idCardTrab, framework.doEncriptar2(passTrab))) {//framework.doEncriptar(passTrab,"SHA-1")
            //busca al usuario actual mediante su usuario y su idCard
            usuarioActualEmp = gestorUsuarioAdminService.buscarUsuario(usuarioTrab, idCardTrab);
            
             // si es true entonces tiene acceso al sistema como administrador el trabajdor
               if (pspUserAppService.tieneAccesoComoAdministrador(usuarioActualEmp.getUid())) {
                   // está logeado
                    logeado = true;
                    // el acceso es del administrador
                    acceso = "ADMINISTRADOR";
                    //obtiene el nombre del usuario accedido
                    nomAccedido = usuarioActualEmp.getDrtDirectorio().getDrtPersonanatural().getNombreCompleto();
                    System.out.println("LOGEADO ADMINISTRADOR");
                    drtPersonanatural = new DrtPersonanatural();
                                    try {
                                           drtPersonanatural = usuarioActualEmp.getDrtDirectorio().getDrtPersonanatural();
                                    } catch (Exception e) {
                                           framework.doMensajeF("Mensaje", "Error Data Invalidad", 4);

                                    }
                    //llama a la función para que redireccione a su pagina de administrador
                    logeadoAdmin();
               }  else {
                    // no se pudo logear logeado
                    logeado = false;
                    System.out.println("Usted No está autorisado para ese sistema");
                   framework.doMensajeF("Mensaje", "Usted No está autorisado para ese sistema", 4);
                    //doMensajeR("Mensaje", "Usted No está autorisado para ese sistema", 4);
                }
               
           // } else {
          //       //no se pudo logear logeado
          //     logeado = false;
         //      framework.doMensajeF("Error", "El Usuario, id Tarjeta o Contraseña es incorrecto", 4);
          //     System.out.println("El Usuario, id Tarjeta o Contraseña es incorrecto");
          // }
            
        } catch (Exception e) {
           framework.doMensajeF("Mensaje", "Contraseña Incorrecta", 4);
        }
 
       
    }*/
    
    public void doLoginMantenimiento(){
    
     if (gestorUsuarioAdminService.validarUsuario(usuarioTrab, idCardTrab, framework.doEncriptar2(passTrab))) {//framework.doEncriptar(passTrab,"SHA-1")   
            
         usuarioActualEmp = gestorUsuarioAdminService.buscarUsuario(usuarioTrab, idCardTrab);
         try {
             if (pspUserAppService.tieneAccesoComoMantenimiento(usuarioActualEmp.getUid())) {
                     // está logeado
                       logeado = true;
                       // el acceso es del matenimiento
                       acceso = "MANTENIMIENTO";
                       //almacena el nombre en la variable nomAccedido
                       nomAccedido = usuarioActualEmp.getDrtDirectorio().getDrtPersonanatural().getNombreCompleto();
                       // redirecciona a la pagina de mantenimiento
                       drtPersonanatural = new DrtPersonanatural();
                                    try {
                                           drtPersonanatural = usuarioActualEmp.getDrtDirectorio().getDrtPersonanatural();
                                    } catch (Exception e) {
                                           framework.doMensajeF("Mensaje", "Error Data Invalidad", 4);

                                    }
                        logeadoAdmin();
                  }
                   else {
                      // no se pudo logear logeado
                     logeado = false;
                      System.out.println("Usted No está autorisado para ese sistema");
                      framework.doMensajeF("Mensaje", "Usted No está autorisado para ese sistema", 4);
                    //doMensajeR("Mensaje", "Usted No está autorisado para ese sistema", 4);
                 }
         } catch (NullPointerException e) {
             System.out.println("No encotnro usuarioActualEmp");
         }
                 
     }
     else {
             //no se pudo logear logeado
           logeado = false;
           //framework.doMensajeR("Error", "El Usuario, id Tarjeta o Contraseña es incorrecto", 2);
           System.out.println("El Usuario, id Tarjeta o Contraseña es incorrecto");
           framework.doMensajeF("Error!", "El Usuario, id Tarjeta o Contraseña es incorrecto", 4);
    }
        
    }

    public void doLoginEstAlu() {
        //evalua si es estudiante de la UNS
        System.out.println("ENTRO");
        System.out.println("codigo "+codigoEst);
        System.out.println("DNI "+dniEst);
        System.out.println("CONTRA "+ passEstu);
        System.out.println("ENCRIP  "+framework.doEncriptar(passEstu, "SHA-1"));
        if (gestorUsuarioEstService.validarAlumno(codigoEst, dniEst, framework.doEncriptar(passEstu, "SHA-1"))) {
            System.out.println("valido");
            // está logeado
            logeado = true;
            // otro tipo de estudiante se hace nulo
            estudianteActualGene = null;
            //obtiene los dalot mediante el codigo y dni
            estudianteActualUns = gestorUsuarioEstService.recuperarDatosUsuario(codigoEst, dniEst);
            // el acceso es del estudiante de la uns
            acceso = "ALUMNO UNS";
            //almacena el nombre en la variable nomAccedido
            nomAccedido = estudianteActualUns.getDrtPersonanatural().getNombreCompleto();
            // redirecciona al la pagina del alumno
            tipo_alumno = 1;
            logeadoAlumno();
        }
        else {
            System.out.println("son incorrectos");
            framework.doMensajeF("Error", "Los datos ingresados son incorrectos", 4);
            logeado = false;
        }
        
    }
    
    public void doLoginAluGeneral(){
         System.out.println("ENTRO");
        System.out.println("DNI "+dniEstGene);
        System.out.println("CONTRA "+  framework.doEncriptar(passEstGene, "SHA-1"));
        
     if (gestorUsuarioEstGeneralService.validarEstGeneral(dniEstGene, framework.doEncriptar(passEstGene, "SHA-1"))) {
            // está logeado
            logeado = true;
            // estudiante de la UNS se hace nulo
            estudianteActualUns = null;
            //obtiene los dalot mediante el codigo y dni
            trazaMsg obj =gestorUsuarioEstGeneralService.recuperarDatosEstGeneral(dniEstGene);
            estudianteActualGene = obj.getDrtPersonanatural();
            // el acceso es del estudiante general
            acceso = "ALUMNO GENERAL";
            //almacena el nombre en la variable nomAccedido
            nomAccedido = estudianteActualGene.getNombreCompleto();
            // redirecciona al la pagina del alumno
            tipo_alumno=2;
            logeadoAlumno();
        }   else {
            System.out.println("son incorrectos");
            framework.doMensajeF("Error", "Los datos ingresados son incorrectos", 4);
            logeado = false;
        }
        
    
    }
    
    
    public void doLoginAluTrabj(){
        System.out.println("ENTRO");
        System.out.println("codigo "+usuarioEstTrab);
        System.out.println("DNI "+idCardEstTrab);
        System.out.println("CONTRA "+framework.doEncriptar2(passEstTrab));
       if (gestorUsuarioAdminService.validarUsuario(usuarioEstTrab, idCardEstTrab,framework.doEncriptar2(passEstTrab))) {
          ///  if (true) {
      
            // está logeado
            logeado = true;
            // estudiante de la UNS se hace nulo
            estudianteActualUns = null;
            // otro tipo de estudiante se hace nulo
            estudianteActualGene = null;
            //obtiene los dalos mediante el usuario y id card
            usuarioActualEmp = gestorUsuarioAdminService.buscarUsuario(usuarioEstTrab, idCardEstTrab);
            // el acceso es del estudiante trabajador
            acceso = "ALUMNO TRABAJADOR";
            //obtiene el nombre del logeado
            nomAccedido = usuarioActualEmp.getDrtDirectorio().getDrtPersonanatural().getNombreCompleto();
            tipo_alumno=3;
            logeadoAlumno();
        }  else {
            System.out.println("son incorrectos");
            framework.doMensajeF("Error", "Los datos ingresados son incorrectos", 4);
            logeado = false;
        }
    }
    
    
    public void doLoginDocente() {
        System.out.println("ingreso docente");
        try {
           if (gestorUsuarioDocenteService.validarUsuario(userDocente,idCardDocen,framework.doEncriptar2(passDocente))) {
            System.out.println("correcto");
            // está logeado
            //obtiene los dalot mediante  dni
            //DocenteActual = gestorUsuarioDocenteService.recuperarDatosDocente(dniDocente);
            DocenteActual = gestorUsuarioAdminService.buscarUsuario(userDocente, idCardDocen).getDrtDirectorio().getDrtPersonanatural();
             //VERIFICAR SI ESTA activo ENSEÑANDO UN CURSO
               if (gestorUsuarioDocenteService.validarSiEsDocente(DocenteActual.getIdDir())) {
                       logeado = true;
                        // el acceso es del estudiante trabajador
                        acceso = "DOCENTE";
                        //obtiene el nombre del logeado
                        nomAccedido = DocenteActual.getNombreCompleto();
                        // redirecciona al la pagina del alumno
                        logeadoDocente();
               }else{
                        framework.doMensajeR("Error", "El Usuario, id Tarjeta o Contraseña es incorrecto", 2);
                        logeado = false;
               }
            
            }
            else{
                  // funcion llamada desde el base controller
                  framework.doMensajeF("Error", "El Usuario, id Tarjeta o Contraseña es incorrecto", 4);
                  logeado = false;
            }
        } catch (Exception e) {
            System.out.println("ERROR LOGIN DOCENTE");
        }
  
     
        
    }
    
    public void logeadoAdmin() {
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Datos/DatosPersonales.xhtml";
        logeado(direccionar);
    }

    public void logeadoMante() {
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Datos/DatosPersonales.xhtml";
        logeado(direccionar);
    }

    public void logeadoAlumno() {
             
        drtPersonanatural = new DrtPersonanatural();
               switch (tipo_alumno) {
                   case 1:
                        drtPersonanatural = getEstudianteActualUns().getDrtPersonanatural();
                       break;
                   case 2:
                       drtPersonanatural =   getEstudianteActualGene();
                       break;
                   case 3:
                        drtPersonanatural =  getUsuarioActualEmp().getDrtDirectorio().getDrtPersonanatural();
                       break;
                   default:
                       throw new AssertionError();
               }
     
        String direccionar = "/WebCecompInHouse/faces/pages/Usuario/Datos/DatosPersonales.xhtml";
        logeado(direccionar);
    }
    
    public void logeadoDocente(){
         drtPersonanatural = new DrtPersonanatural();
        drtPersonanatural = DocenteActual;
        String direccionar = "/WebCecompInHouse/faces/pages/Docente/Datos/DatosPersonales.xhtml";
        logeado (direccionar);
    }

    public void logeado(String direccionar) {
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            contex.getExternalContext().redirect(direccionar);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doLogoutAdmin() {
        logeado = false;
        usuarioActualEmp = null;
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            contex.getExternalContext().redirect("/WebCecompInHouse/faces/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        System.out.println("Cerraste sesión");
    }

    public void doLogoutAlum() {
        logeado = false;
        usuarioActualEmp = null;
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            contex.getExternalContext().redirect("/WebCecompInHouse/faces/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        System.out.println("Cerraste sesión");
    }
    
    public void doLogoutDoce() {
        logeado = false;
        usuarioActualEmp = null;
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            contex.getExternalContext().redirect("/WebCecompInHouse"
                    + "/faces/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        System.out.println("Cerraste sesión");
    }

    /*public String EncriptarClave(String clave) {
        String salida = "";
        String isKey = "secret";
        String subClave;
        String subKey;

        int keyLen = isKey.length();
        int claveLen = clave.length();
        int i;
        int keyPtr = 0;
        int temVal;
        int temKey;
        //System.out.println("llegando al for del encriptador");
        byte[] newClave = new byte[claveLen];
        claveByte = new byte[claveLen * 2];
        for (i = 1; i <= claveLen; i++) {
            subClave = clave.substring(i - 1, i);
            temVal = subClave.codePointAt(0);
            subKey = isKey.substring(keyPtr, keyPtr + 1);
            temKey = subKey.codePointAt(0);
            //System.out.println("temval: " + temVal + " temkey: " +temKey );
            temVal = temVal + temKey;
            //System.out.println("tamval t: " + temVal);
            while (temVal > 255) {
                if (temVal > 255) {
                    temVal = temVal - 255;
                }
            }
            //System.out.println("tamVal enc: " + temVal);
            salida = salida + (char) temVal;
            newClave[i - 1] = (byte) temVal;
            keyPtr++;
            if (keyPtr > keyLen - 1) {
                keyPtr = 0;
            }
        }
        //System.out.println("encriptado: " + salida + " - blob: " + (salida.getBytes()));

        //System.out.println("clavebyte: " + claveByte);
        claveLen = claveLen * 2;
        for (i = 0; i < claveLen; i++) {
            if (i % 2 == 0) {
                claveByte[i] = newClave[i / 2];
            } else {
                claveByte[i] = 0;
            }
            //System.out.println(": " + claveByte[i]);
        }
        //byteSalida=salida.getBytes(Charset.forName("UTF-8"));
        //return byteSalida;

        return salida;
    }*/

    
    //*********REGISTRO USUARIO EXTERNO - NOUNS*****************/////
    //Lista tipo de documento Solo llama a DNI y Carnet Extranjeria
    
   /* public List<DrtDocidentidad> listTipoDocIde(){
     return drtDocidentidadService.listarTipoDoc();
    }*/
    
    
    public void doCargarRegistroMatricula(){
       lstdrtDocidentidad = new ArrayList<>();
       lstdrtDocidentidad = drtDocidentidadService.listarTipoDoc();
       drtPersonanatural  = new DrtPersonanatural();
       drtDocidentidad = new DrtDocidentidad();
       drtDepartamento = new DrtDepartamento();
       drtProvincia = new DrtProvincia();
       drtDistrito = new DrtDistrito();
       drtDep = new DrtDepartamento();
       drtPro = new DrtProvincia();
       drtDis = new DrtDistrito();
       lstDepartamentos = new ArrayList<>();
       lstDepartamentos = drtDepartamentoService.listarTodos();
       lstProvincias =  new ArrayList<>();
       lstDistritos = new ArrayList<>();
       lstDep = new ArrayList<>();
       lstDep = drtDepartamentoService.listarTodos();
       lstPro =  new ArrayList<>();
       lstDis = new ArrayList<>();
       
       drtPersonanatural.setNumeroPndid(numdni);
       
    }
    
   public void doCargarProvincia(){
      lstProvincias =  new ArrayList<>();
      // selecciona las provincias segun el departamento elegido
      lstProvincias = drtProvinciaService.buscarTodos(drtDepartamento.getDrtDepartamentoPK().getIdPais(),drtDepartamento.getDrtDepartamentoPK().getIdDpto());
   } 
   
   public void doCargarProvinciaResidencia(){
      lstPro =  new ArrayList<>();
      // selecciona las provincias segun el departamento elegido
      lstPro = drtProvinciaService.buscarTodos(drtDep.getDrtDepartamentoPK().getIdPais(),drtDep.getDrtDepartamentoPK().getIdDpto());
        
   } 
   
   public void doCargarDistrito(){
     lstDistritos = new ArrayList<>();
     lstDistritos = drtDistritoService.buscarTodos(drtProvincia.getDrtProvinciaPK().getIdPais(),drtProvincia.getDrtProvinciaPK().getIdDpto(),drtProvincia.getDrtProvinciaPK().getIdProv());
   }
   
     public void doCargarDistritoResidencia(){
     lstDis = new ArrayList<>();
     lstDis = drtDistritoService.buscarTodos(drtPro.getDrtProvinciaPK().getIdPais(),drtPro.getDrtProvinciaPK().getIdDpto(),drtPro.getDrtProvinciaPK().getIdProv());
   }
     
     public void doCrearPersonaExterna(){
        Date fechaActual = new Date(); 
       // recupera persona natural que tiene id=1
       drtDirectorioClase = new DrtDirectorioClase();
       drtDirectorioClase  = drtDirectorioClaseService.recuperarIdDirectorioClase((short)1); 
       
       //Paso 1 crea Directorio
        drtDirectorio = new DrtDirectorio();
        drtDirectorio.setDrtDirectorioClase(drtDirectorioClase);
        drtDirectorio.setPspApp(0);
        drtDirectorio.setPspCxt((short)0);
        drtDirectorio.setPspUid(0);
        drtDirectorio.setDateinsert(fechaActual);
        drtDirectorio = drtDirectorioService.crearEntidad(drtDirectorio);
        System.out.println("creo drtDirectorio");
       //Paso 2 
        
       if (drtDocidentidad.getIdPdid()==5) {
             //sino selecciono tipo de documento extranjero
             drtPersonanatural.setDrtDistrito(drtDistritoService.buscarEntidadNull());
        }
        
         drtPersonanatural.setDrtDirectorio(drtDirectorio);
         drtPersonanatural.setIdDir(drtDirectorio.getIdDir());
         drtPersonanatural.setIdColegio(0);
         drtPersonanatural.setIdGrpsng(0);
         drtPersonanatural.setIdPnec(0);
         drtPersonanatural.setEstadoPernat('1');
         drtPersonanatural.setFechaIng(fechaActual);
         drtPersonanatural.setIdPdid((int)drtDocidentidad.getIdPdid());
         drtPersonanatural.setAnioEgresoCole(0);
         drtPersonanatural.setUpdateFlow(0);
         drtPersonanatural.setUpdateSelf(0);
         drtPersonanatural.setNombreCompleto(drtPersonanatural.getApPaterno()+" "+drtPersonanatural.getApMaterno()+" "+drtPersonanatural.getNombre());
         //**crea su pasword con su dni
         
        // baseController = new fwGeneral2();
         drtPersonanatural.setPswa(framework.doEncriptar(drtPersonanatural.getNumeroPndid() , "SHA-1")); 
         drtPersonanatural = gestorUsuarioEstGeneralService.crearEntidad(drtPersonanatural);
         System.out.println("Registro drtPersonaNatural");
         
         int id_tipoperuns = 2400; // almnos del cecomp
        
         drtPernatUns = new DrtPernatUns();
         drtPernatUns.setIdDir(drtPersonanatural.getIdDir());
         drtPernatUns.setDrtPersonanatural(drtPersonanatural);
         drtPernatUns.setDrtTipoPeruns( drtTipoPerUnsService.recuperarIdEntidad(id_tipoperuns));
         drtPernatUns.setUbigeoPro(0);
         drtPernatUns.setFechaIng(fechaActual);
         drtPernatUnsService.crearEntidad(drtPernatUns);
         System.out.println("guardo pernat uns");
        
     }
     
     public void doGenerarUsuarioContrasena(){
         try {
           DrtPersonanatural  drtPersonanatural2 = new DrtPersonanatural();
             // dir se recupero de Matriculla controler cuando se valido que era un usuario pero sin contraseña
             //asi que el sistema le generara una contraseña para que pueda acceder al sistema
         drtPersonanatural2 = gestorUsuarioEstGeneralService.recuperarIdEntidadDrtPersona(id_dir);
         drtPersonanatural2.setPswa(framework.doEncriptar(drtPersonanatural2.getNumeroPndid(), "SHA-1"));
         drtPersonanatural = new DrtPersonanatural();
         drtPersonanatural = gestorUsuarioEstGeneralService.actualizarEntidad(drtPersonanatural2);
         doRegistroExitoso();
         } catch (Exception e) {
             System.out.println("no se pudo crear generar usurio y contraseña");
         }
         
     }
     
    public void doRegistroExitoso() {
        String direccionar = "/WebCecompInHouse/faces/pages/UserExterno/registroExitoso.xhtml";
        logeado(direccionar);
    }
   
    /////////////************** MEDIA BECA *************  //////////////////
    
    public void doBuscarAlumnoUns(){ 
      
         System.out.println("CONTROLLER");
         trazaMsg traza  = gestorUsuarioEstService.buscarAlumno(codigoEst);
       
         
            drtPersonanatural = new  DrtPersonanatural();
         
            drtPersonanatural = traza.getDrtPersonanatural();
            //System.out.println("drt ="+drtPersonanatural.getNombreCompleto());
          
            
            
            if (drtPersonanatural!=null) {
                System.out.println("CONTROLLER NOT EMPTY");
                if (drtPersonanatural.getSexo()=='M') {
                   sexo = 1; // hombre
               }else{
                   sexo = 2; //mujer
               }
                 id_dir = drtPersonanatural.getIdDir();
            }else{
                System.out.println("CONTROLLER NULL");
                 sexo = 3; // No encontro
                   if (traza.getTipoAlumno()==1) {
                   sexo=11;   //UNS 
                    }else{
                        if (traza.getTipoAlumno()==2) {
                            sexo=12;  // PUBLICO
                        }else{
                            if (traza.getTipoAlumno()==3) {
                                System.out.println("CONTROLLER TRABAJADOR");
                              sexo=13; //TRABAJADOR
                            }else{
                                sexo = 3;
                                id_dir=0;
                            }

                        }
                    }
            }
           
            
             
             

    }
    
public void doBuscarPersona(){
        // este objeto clase se encargade setear dos valores retornados desde el service
        trazaMsg traza = gestorUsuarioEstGeneralService.recuperarDatosEstGeneral(dniEstGene);
         drtPersonanatural = new  DrtPersonanatural();
         drtPersonanatural = traza.getDrtPersonanatural();
         
        if (drtPersonanatural!=null) {
            if (drtPersonanatural.getSexo()=='M') {
                sexo = 1; // hombre
            }else{
                sexo = 2; //mujer
            }
            id_dir = drtPersonanatural.getIdDir();
        }else{
               sexo = 3; // No encontro
              id_dir=0;
                if (traza.getTipoAlumno()==1) {
               sexo=11;   //UNS 
                }else{
                    if (traza.getTipoAlumno()==2) {
                        sexo=12;  // PUBLICO
                    }else{
                        if (traza.getTipoAlumno()==3) {
                          sexo=13; //TRABAJADOR
                        }else{
                            sexo = 3;
                            id_dir=0;
                        }

                    }
                }
        }
    }



public void doBuscarEstTrabajador(){
  try {
            
                  // este objeto clase se encargade setear dos valores retornados desde el service
        trazaMsg traza = gestorUsuarioAdminService.buscarTrabajadorUNSporDni(idCardEstTrab);
         drtPersonanatural = new  DrtPersonanatural();
         drtPersonanatural = traza.getDrtPersonanatural();
         
        if (drtPersonanatural!=null) {
            if (drtPersonanatural.getSexo()=='M') {
                sexo = 1; // hombre
            }else{
                sexo = 2; //mujer
            }
            id_dir = drtPersonanatural.getIdDir();
        }else{
               sexo = 3; // No encontro
              id_dir=0;
                if (traza.getTipoAlumno()==1) {
               sexo=11;   //UNS 
                }else{
                    if (traza.getTipoAlumno()==2) {
                        sexo=12;  // PUBLICO
                    }else{
                        if (traza.getTipoAlumno()==3) {
                          sexo=13; //TRABAJADOR
                        }else{
                            sexo = 3;
                            id_dir=0;
                        }

                   }
              }
        }
            
            
       /*     drtPersonanatural = new  DrtPersonanatural();
             trazaMsg traza 
       
            PspUsuario pspuser = gestorUsuarioAdminService.buscarTrabajadorUNS(idCardEstTrab);
           
            if(pspuser!=null) {
                drtPersonanatural = pspuser.getDrtDirectorio().getDrtPersonanatural();
                dniEstGene = drtPersonanatural.getNumeroPndid();
                if (drtPersonanatural.getSexo()=='M') {
                    sexo = 1; // hombre
                }else{
                    sexo = 2; //mujer
                }
            id_dir = drtPersonanatural.getIdDir();
            }else{
                sexo = 3; // No encontro
                id_dir=0;
            }
        */
        } catch (Exception e) {
          framework.doMensajeF("Error", "Validacion del Trabajador externo", 4);
        }
     
    }
    
    
    //4. GET and SET
    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    public PspUsuario getUsuarioActualEmp() {
        return usuarioActualEmp;
    }

    public void setUsuarioActualEmp(PspUsuario usuarioActualEmp) {
        this.usuarioActualEmp = usuarioActualEmp;
    }

    public String getPassEstu() {
        return passEstu;
    }

    public void setPassEstu(String passEstu) {
        this.passEstu = passEstu;
    }

    
    public String getDniEstGene() {
        return dniEstGene;
    }

    public void setDniEstGene(String dniEstGene) {
        this.dniEstGene = dniEstGene;
    }

    public String getPassEstGene() {
        return passEstGene;
    }

    public void setPassEstGene(String passEstGene) {
        this.passEstGene = passEstGene;
    }

    public DrtDirectorioClase getDrtDirectorioClase() {
        return drtDirectorioClase;
    }

    public void setDrtDirectorioClase(DrtDirectorioClase drtDirectorioClase) {
        this.drtDirectorioClase = drtDirectorioClase;
    }

    public DrtDirectorio getDrtDirectorio() {
        return drtDirectorio;
    }

    public void setDrtDirectorio(DrtDirectorio drtDirectorio) {
        this.drtDirectorio = drtDirectorio;
    }

    public DrtPernatUns getDrtPernatUns() {
        return drtPernatUns;
    }
    
    public void setDrtPernatUns(DrtPernatUns drtPernatUns) {
        this.drtPernatUns = drtPernatUns;
    }

    public DrtTipoPeruns getDrtTipoPeruns() {
        return drtTipoPeruns;
    }

    public void setDrtTipoPeruns(DrtTipoPeruns drtTipoPeruns) {
        this.drtTipoPeruns = drtTipoPeruns;
    }

    
    public DrtPersonanatural getEstudianteActualGene() {
        return estudianteActualGene;
    }

    public void setEstudianteActualGene(DrtPersonanatural estudianteActualGene) {
        this.estudianteActualGene = estudianteActualGene;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getNomAccedido() {
        return nomAccedido;
    }

    public void setNomAccedido(String nomAccedido) {
        this.nomAccedido = nomAccedido;
    }

    public String getUsuarioTrab() {
        return usuarioTrab;
    }

    public void setUsuarioTrab(String usuarioTrab) {
        this.usuarioTrab = usuarioTrab;
    }

    public String getIdCardTrab() {
        return idCardTrab;
    }

    public void setIdCardTrab(String idCardTrab) {
        this.idCardTrab = idCardTrab;
    }

    public String getPassTrab() {
        return passTrab;
    }

    public void setPassTrab(String passTrab) {
        this.passTrab = passTrab;
    }

    public String getCodigoEst() {
        return codigoEst;
    }

    public void setCodigoEst(String codigoEst) {
        this.codigoEst = codigoEst;
    }

    public String getDniEst() {
        return dniEst;
    }

    public void setDniEst(String dniEst) {
        this.dniEst = dniEst;
    }

    public String getUsuarioEstTrab() {
        return usuarioEstTrab;
    }

    public void setUsuarioEstTrab(String usuarioEstTrab) {
        this.usuarioEstTrab = usuarioEstTrab;
    }

    public String getIdCardEstTrab() {
        return idCardEstTrab;
    }

    public void setIdCardEstTrab(String idCardEstTrab) {
        this.idCardEstTrab = idCardEstTrab;
    }

    public String getPassEstTrab() {
        return passEstTrab;
    }

    public void setPassEstTrab(String passEstTrab) {
        this.passEstTrab = passEstTrab;
    }

    public FxaEstudiante getEstudianteActualUns() {
        return estudianteActualUns;
    }

    public void setEstudianteActualUns(FxaEstudiante estudianteActualUns) {
        this.estudianteActualUns = estudianteActualUns;
    }

     public String getDniDocente() {
        return dniDocente;
    }

    public void setDniDocente(String dniDocente) {
        this.dniDocente = dniDocente;
    }

    public String getPassDocente() {
        return passDocente;
    }

    public void setPassDocente(String passDocente) {
        this.passDocente = passDocente;
    }

    public DrtPersonanatural getDocenteActual() {
        return DocenteActual;
    }

    public void setDocenteActual(DrtPersonanatural DocenteActual) {
        this.DocenteActual = DocenteActual;
    } 
 
//// lo ultimo

  
   

    public int getId_curso_subdet() {
        return id_curso_subdet;
    }

    public void setId_curso_subdet(int id_curso_subdet) {
        this.id_curso_subdet = id_curso_subdet;
    }

    public int getEnabled_docente() {
        return enabled_docente;
    }

    public void setEnabled_docente(int enabled_docente) {
        this.enabled_docente = enabled_docente;
    }

    public int getTipo_alumno() {
        return tipo_alumno;
    }

    public void setTipo_alumno(int tipo_alumno) {
        this.tipo_alumno = tipo_alumno;
    }

    public DrtPersonanatural getDrtPersonanatural() {
        return drtPersonanatural;
    }

    public void setDrtPersonanatural(DrtPersonanatural drtPersonanatural) {
        this.drtPersonanatural = drtPersonanatural;
    }

    public byte[] getClaveByte() {
        return claveByte;
    }

    public void setClaveByte(byte[] claveByte) {
        this.claveByte = claveByte;
    }

    public GestorUsuarioAdminServiceLocal getGestorUsuarioAdminService() {
        return gestorUsuarioAdminService;
    }

    public void setGestorUsuarioAdminService(GestorUsuarioAdminServiceLocal gestorUsuarioAdminService) {
        this.gestorUsuarioAdminService = gestorUsuarioAdminService;
    }

    public GestorUsuarioEstServiceLocal getGestorUsuarioEstService() {
        return gestorUsuarioEstService;
    }

    public void setGestorUsuarioEstService(GestorUsuarioEstServiceLocal gestorUsuarioEstService) {
        this.gestorUsuarioEstService = gestorUsuarioEstService;
    }

    public GestorUsuarioEstGeneralServiceLocal getGestorUsuarioEstGeneralService() {
        return gestorUsuarioEstGeneralService;
    }

    public void setGestorUsuarioEstGeneralService(GestorUsuarioEstGeneralServiceLocal gestorUsuarioEstGeneralService) {
        this.gestorUsuarioEstGeneralService = gestorUsuarioEstGeneralService;
    }

    public GestorUsuarioDocenteServiceLocal getGestorUsuarioDocenteService() {
        return gestorUsuarioDocenteService;
    }

    public void setGestorUsuarioDocenteService(GestorUsuarioDocenteServiceLocal gestorUsuarioDocenteService) {
        this.gestorUsuarioDocenteService = gestorUsuarioDocenteService;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public DrtTipoPerUnsServiceLocal getDrtTipoPerUnsService() {
        return drtTipoPerUnsService;
    }

    public void setDrtTipoPerUnsService(DrtTipoPerUnsServiceLocal drtTipoPerUnsService) {
        this.drtTipoPerUnsService = drtTipoPerUnsService;
    }

    public DrtProvinciaServiceLocal getDrtProvinciaService() {
        return drtProvinciaService;
    }

    public void setDrtProvinciaService(DrtProvinciaServiceLocal drtProvinciaService) {
        this.drtProvinciaService = drtProvinciaService;
    }

    public DrtPernatUnsServiceLocal getDrtPernatUnsService() {
        return drtPernatUnsService;
    }

    public void setDrtPernatUnsService(DrtPernatUnsServiceLocal drtPernatUnsService) {
        this.drtPernatUnsService = drtPernatUnsService;
    }

    public DrtPaisServiceLocal getDrtPaisService() {
        return drtPaisService;
    }

    public void setDrtPaisService(DrtPaisServiceLocal drtPaisService) {
        this.drtPaisService = drtPaisService;
    }

    public DrtDocidentidadServiceLocal getDrtDocidentidadService() {
        return drtDocidentidadService;
    }

    public void setDrtDocidentidadService(DrtDocidentidadServiceLocal drtDocidentidadService) {
        this.drtDocidentidadService = drtDocidentidadService;
    }

    public DrtDistritoServiceLocal getDrtDistritoService() {
        return drtDistritoService;
    }

    public void setDrtDistritoService(DrtDistritoServiceLocal drtDistritoService) {
        this.drtDistritoService = drtDistritoService;
    }

    public DrtDirectorioServiceLocal getDrtDirectorioService() {
        return drtDirectorioService;
    }

    public void setDrtDirectorioService(DrtDirectorioServiceLocal drtDirectorioService) {
        this.drtDirectorioService = drtDirectorioService;
    }

    public DrtDirectorioClaseServiceLocal getDrtDirectorioClaseService() {
        return drtDirectorioClaseService;
    }

    public void setDrtDirectorioClaseService(DrtDirectorioClaseServiceLocal drtDirectorioClaseService) {
        this.drtDirectorioClaseService = drtDirectorioClaseService;
    }

    public DrtDepartamentoServiceLocal getDrtDepartamentoService() {
        return drtDepartamentoService;
    }

    public void setDrtDepartamentoService(DrtDepartamentoServiceLocal drtDepartamentoService) {
        this.drtDepartamentoService = drtDepartamentoService;
    }

    public List<DrtDocidentidad> getLstdrtDocidentidad() {
        return lstdrtDocidentidad;
    }

    public void setLstdrtDocidentidad(List<DrtDocidentidad> lstdrtDocidentidad) {
        this.lstdrtDocidentidad = lstdrtDocidentidad;
    }

    public List<DrtPais> getLstPaises() {
        return lstPaises;
    }

    public void setLstPaises(List<DrtPais> lstPaises) {
        this.lstPaises = lstPaises;
    }

    public List<DrtDepartamento> getLstDepartamentos() {
        return lstDepartamentos;
    }

    public void setLstDepartamentos(List<DrtDepartamento> lstDepartamentos) {
        this.lstDepartamentos = lstDepartamentos;
    }

    public List<DrtProvincia> getLstProvincias() {
        return lstProvincias;
    }

    public void setLstProvincias(List<DrtProvincia> lstProvincias) {
        this.lstProvincias = lstProvincias;
    }

    public List<DrtDistrito> getLstDistritos() {
        return lstDistritos;
    }

    public void setLstDistritos(List<DrtDistrito> lstDistritos) {
        this.lstDistritos = lstDistritos;
    }

    public DrtDocidentidad getDrtDocidentidad() {
        return drtDocidentidad;
    }

    public void setDrtDocidentidad(DrtDocidentidad drtDocidentidad) {
        this.drtDocidentidad = drtDocidentidad;
    }

    public DrtDepartamento getDrtDepartamento() {
        return drtDepartamento;
    }

    public void setDrtDepartamento(DrtDepartamento drtDepartamento) {
        this.drtDepartamento = drtDepartamento;
    }

    public DrtProvincia getDrtProvincia() {
        return drtProvincia;
    }

    public void setDrtProvincia(DrtProvincia drtProvincia) {
        this.drtProvincia = drtProvincia;
    }

    public DrtDistrito getDrtDistrito() {
        return drtDistrito;
    }

    public void setDrtDistrito(DrtDistrito drtDistrito) {
        this.drtDistrito = drtDistrito;
    }

    public Integer getId_ubg_nac() {
        return id_ubg_nac;
    }

    public void setId_ubg_nac(Integer id_ubg_nac) {
        this.id_ubg_nac = id_ubg_nac;
    }

    public Integer getId_ubg_pro() {
        return id_ubg_pro;
    }

    public void setId_ubg_pro(Integer id_ubg_pro) {
        this.id_ubg_pro = id_ubg_pro;
    }

    public DrtDepartamento getDrtDep() {
        return drtDep;
    }

    public void setDrtDep(DrtDepartamento drtDep) {
        this.drtDep = drtDep;
    }

    public DrtProvincia getDrtPro() {
        return drtPro;
    }

    public void setDrtPro(DrtProvincia drtPro) {
        this.drtPro = drtPro;
    }

    public DrtDistrito getDrtDis() {
        return drtDis;
    }

    public void setDrtDis(DrtDistrito drtDis) {
        this.drtDis = drtDis;
    }

    public List<DrtDepartamento> getLstDep() {
        return lstDep;
    }

    public void setLstDep(List<DrtDepartamento> lstDep) {
        this.lstDep = lstDep;
    }

    public List<DrtProvincia> getLstPro() {
        return lstPro;
    }

    public void setLstPro(List<DrtProvincia> lstPro) {
        this.lstPro = lstPro;
    }

    public List<DrtDistrito> getLstDis() {
        return lstDis;
    }

    public void setLstDis(List<DrtDistrito> lstDis) {
        this.lstDis = lstDis;
    }

    public String getNumdni() {
        return numdni;
    }

    public void setNumdni(String numdni) {
        this.numdni = numdni;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

  

    public fwGeneral2 getFramework() {
        return framework;
    }

    public void setFramework(fwGeneral2 framework) {
        this.framework = framework;
    }

    public int getId_dir() {
        return id_dir;
    }

    public void setId_dir(int id_dir) {
        this.id_dir = id_dir;
    }

    public String getDniTrabaj() {
        return dniTrabaj;
    }

    public void setDniTrabaj(String dniTrabaj) {
        this.dniTrabaj = dniTrabaj;
    }

    public int getId_curso_grupo() {
        return id_curso_grupo;
    }

    public void setId_curso_grupo(int id_curso_grupo) {
        this.id_curso_grupo = id_curso_grupo;
    }

    public int getNum_matriculados() {
        return num_matriculados;
    }

    public void setNum_matriculados(int num_matriculados) {
        this.num_matriculados = num_matriculados;
    }

    public String getIdCardDocen() {
        return idCardDocen;
    }

    public void setIdCardDocen(String idCardDocen) {
        this.idCardDocen = idCardDocen;
    }

    public String getUserDocente() {
        return userDocente;
    }

    public void setUserDocente(String userDocente) {
        this.userDocente = userDocente;
    }

    public PspUserAppServiceLocal getPspUserAppService() {
        return pspUserAppService;
    }

    public void setPspUserAppService(PspUserAppServiceLocal pspUserAppService) {
        this.pspUserAppService = pspUserAppService;
    }

    public fwGeneral1 getFramework1() {
        return framework1;
    }

    public void setFramework1(fwGeneral1 framework1) {
        this.framework1 = framework1;
    }

    

   


    
}
