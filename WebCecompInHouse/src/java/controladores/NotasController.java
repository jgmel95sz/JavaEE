/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

//import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
//import java.io.Serializable;
import ejb.negocio.GestorCepCecCurGrupDetalleServiceLocal;
import ejb.negocio.GestorNotasServiceLocal;
import entidades.CepCecCurGrup;
import entidades.CepCecCurGrupDet;
import entidades.CepCecMatriAlu;
import entidades.CepCecNotas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author Melvin
 */
@ManagedBean(name = "notasController")
//@Named(value = "notasController")
@SessionScoped
public class NotasController{

   
    //1. Atributos
    // llamando usuario controller
     @ManagedProperty(value = "#{usuarioController}")
     public UsuarioController usuarioController;
     
      //grupo
      private CepCecCurGrup cepCecCurGrup;
      private Integer id_grupoCurso;
      //notas
      private List<CepCecNotas> lstnotas;
      private CepCecNotas cepCecNotas;
      private List<CepCecNotas> lstnotasHistorial;
      
      public NotasController() {
        }
      
      
    //2. EJBs
      @EJB
      private GestorCepCecCurGrupDetalleServiceLocal gestorCepCecCurGrupDetalleService;
      
       @EJB
      private GestorNotasServiceLocal gestorNotasService;

      
     //3. Acciones JSF
      
     public void redireccionado(String direccionar) {
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            contex.getExternalContext().redirect(direccionar);
        } catch (IOException ex) {
            Logger.getLogger(CursoDetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     

    //4. Metodos Propios
    
     public List<CepCecCurGrupDet> listarGruposAsignadoPorDocente(){
           return gestorCepCecCurGrupDetalleService.buscarGruposPorDocente(usuarioController.getDrtPersonanatural().getIdDir());
     }
     
     public void doCapturarGrupo(CepCecCurGrup item){
         cepCecCurGrup = new CepCecCurGrup();
         cepCecCurGrup = item;
         lstnotas =  new ArrayList<CepCecNotas>();
         lstnotas = gestorNotasService.buscarNotasDeAlumnosMatriculados(cepCecCurGrup.getIdCurGrup());
         
    }
     
   /* public List<CepCecNotas> listarNotasAlumnosMatriculados(){
          System.out.println("id_grupo "+cepCecCurGrup.getIdCurGrup());
           return lstnotas = gestorNotasService.buscarNotasDeAlumnosMatriculados(cepCecCurGrup.getIdCurGrup());
     }*/
     
      public List<CepCecNotas> listarNotasCursosMatriculados(){
           System.out.println("dir : "+usuarioController.getDrtPersonanatural().getIdDir());
           return lstnotas = gestorNotasService.buscarNotasDeLosCursosMatriculadosActivos(usuarioController.getDrtPersonanatural().getIdDir());
     }
    
    public List<CepCecNotas> listarHistorialNotasCursosMatriculados(){
           System.out.println("dir : "+usuarioController.getDrtPersonanatural().getIdDir());
           return lstnotasHistorial = gestorNotasService.buscarNotasDeLosCursosMatriculadosInactivos(usuarioController.getDrtPersonanatural().getIdDir());
     }
    
    public void doActualizarNotas(){
        for (CepCecNotas item : lstnotas) {
            // System.out.println("alu "+item.getCepCecMatriAlu().getNomMatriculado());
            System.out.println("nota "+item.getNota1());
            
            gestorNotasService.actualizarNotas(item);
        }
    }
    
    public void doActualizarSubsanacionNota(){
        for (CepCecNotas item : lstnotas) {
            // System.out.println("alu "+item.getCepCecMatriAlu().getNomMatriculado());
            System.out.println("nota "+item.getNotaSubsanacion());
            gestorNotasService.actualizarNotasSubsanacion(item);
        }
    }
     
    // es para ver notas individual 
   public void doCapturarNotasEnAdministrador(CepCecMatriAlu item){
               cepCecNotas= new CepCecNotas();
               cepCecNotas = gestorNotasService.buscarNotasPorMatricula(item.getIdMatriAlu());
       }
   
   
   public void doCapturarGrupoEnAdministrador(CepCecCurGrup item){
         id_grupoCurso = item.getIdCurGrup();
     }
   
   public void doListarTodasLasNotasModoAdmin(){
         lstnotas =  new ArrayList<CepCecNotas>();
         lstnotas = gestorNotasService.buscarNotasDeAlumnosMatriculados(id_grupoCurso);
   }
   
   
     public void redirecciontoNotasAdmin() {
        System.out.println("entro a contoller");
        this.doListarTodasLasNotasModoAdmin();
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Matricula/Notas.xhtml";
        redireccionado(direccionar);
      }  
   
      public void redirecciontoNotas() {
        System.out.println("entro a contoller");
        String direccionar = "/WebCecompInHouse/faces/pages/Docente/notas/notas.xhtml";
        redireccionado(direccionar);
      }  
     
 /*
     public void redireccionAhMisCursos() {
        System.out.println("entro a contoller");
        String direccionar = "/WebCecompInHouse/faces/pages/Docente/notas/misCursos.xhtml";
        redireccionado(direccionar);
      }  
 */ 
     
    
    // 5 get y set

    public UsuarioController getUsuarioController() {
        return usuarioController;
    }

    public void setUsuarioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public GestorCepCecCurGrupDetalleServiceLocal getGestorCepCecCurGrupDetalleService() {
        return gestorCepCecCurGrupDetalleService;
    }

    public void setGestorCepCecCurGrupDetalleService(GestorCepCecCurGrupDetalleServiceLocal gestorCepCecCurGrupDetalleService) {
        this.gestorCepCecCurGrupDetalleService = gestorCepCecCurGrupDetalleService;
    }

    public CepCecCurGrup getCepCecCurGrup() {
        return cepCecCurGrup;
    }

    public void setCepCecCurGrup(CepCecCurGrup cepCecCurGrup) {
        this.cepCecCurGrup = cepCecCurGrup;
    }

    public List<CepCecNotas> getLstnotas() {
        return lstnotas;
    }

    public void setLstnotas(List<CepCecNotas> lstnotas) {
        this.lstnotas = lstnotas;
    }

    public GestorNotasServiceLocal getGestorNotasService() {
        return gestorNotasService;
    }

    public void setGestorNotasService(GestorNotasServiceLocal gestorNotasService) {
        this.gestorNotasService = gestorNotasService;
    }

    public CepCecNotas getCepCecNotas() {
        return cepCecNotas;
    }

    public void setCepCecNotas(CepCecNotas cepCecNotas) {
        this.cepCecNotas = cepCecNotas;
    }

    public Integer getId_grupoCurso() {
        return id_grupoCurso;
    }

    public void setId_grupoCurso(Integer id_grupoCurso) {
        this.id_grupoCurso = id_grupoCurso;
    }

    public List<CepCecNotas> getLstnotasHistorial() {
        return lstnotasHistorial;
    }

    public void setLstnotasHistorial(List<CepCecNotas> lstnotasHistorial) {
        this.lstnotasHistorial = lstnotasHistorial;
    }
   
    
    
}
