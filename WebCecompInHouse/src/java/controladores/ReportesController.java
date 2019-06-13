/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.InversionCurso;
import clases.PagosMatricula;
import clases.TipoCronograma;
import ejb.dao.CronogramasCabDAOLocal;
import ejb.negocio.GestorCepCecCurGrupDetalleServiceLocal;
import ejb.negocio.GestorCursoGrupoServiceLocal;
import ejb.negocio.GestorInversionServiceLocal;
import ejb.negocio.GestorMatriPagoServiceLocal;
import ejb.negocio.GestorMatriculaAluServiceLocal;
import ejb.negocio.GestorPguModalidadTipoPagoServiceLocal;
import ejb.negocio.GestorPguPagoDetServiceLocal;
import ejb.negocio.GestorPguPagosCabServiceLocal;
import ejb.negocio.GestorRcdVoucherServiceLocal;
import ejb.negocio.GestorTipoPagosServiceLocal;
import entidades.CepCecCronogramaDet;
//import entidades.CepCecCronograma;
import entidades.CepCecCurGrup;
import entidades.CepCecCurGrupDet;
import entidades.CepCecMatriAlu;
import entidades.DrtPersonanatural;
import entidades.PguModalidadTipospagos;
import entidades.PguPagospersCab;
import entidades.PguPagospersDet;
import entidades.PguTipoPagos;
import java.io.IOException;
//import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
import ejb.negocio.DescuentoExoServiceLocal;
import ejb.negocio.ExoneradosServiceLocal;
import ejb.negocio.GestorCronogramasDetServiceLocal;
import ejb.negocio.GestorHorariosServiceLocal;
import ejb.negocio.GestorNotasServiceLocal;
import ejb.negocio.GestorPlanServiceLocal;
import ejb.negocio.GestorRcdConceptoServiceLocal;
import ejb.negocio.GestorSesionPlanServiceLocal;
import ejb.negocio.GestorTemaPlanServiceLocal;
import ejb.negocio.GestorUsuarioEstGeneralServiceLocal;
import entidades.CepCecCursoSubdet;
import entidades.CepCecExonerados;
import entidades.CepCecHorarios;
import entidades.CepCecInversionCurso;
import entidades.CepCecMatriPago;
import entidades.CepCecPlan;
import entidades.CepCecSesion;
import entidades.CepCecTema;
import entidades.RcdConcepto;
import entidades.RcdVoucher;
import frameworkHANM.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import javax.faces.event.ActionEvent;
//import javafx.event.ActionEvent;
import net.sf.jasperreports.engine.JasperPrint;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.primefaces.model.StreamedContent;


import java.util.ArrayList;
import java.util.List;
import javax.activation.MimetypesFileTypeMap;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Melvin
 */
@ManagedBean(name = "reportesController")
//@Named(value = "reportesController")
@SessionScoped
public class ReportesController implements Serializable {

    /**
     * Creates a new instance of ReportesController
     */
    public ReportesController() {
    }
    
    //1.variables
        // llamando usuario controller
        @ManagedProperty(value = "#{usuarioController}")
        public UsuarioController usuarioController;
        private Map parametros;
        CepCecPlan entityPlan;
        List<CepCecSesion> lstSesiones ;
        List<CepCecTema> lstTemas ;
        
        //descargar
        String bs_rutaFile;
        String bs_nombreFile;
        StreamedContent bsc_file;
    //2.EJB
      @EJB
    private GestorCepCecCurGrupDetalleServiceLocal gestorCepCecCurGrupDetalleService;
    @EJB
    private GestorHorariosServiceLocal gestorHorariosService;

    @EJB
    private GestorPguPagosCabServiceLocal gestorPguPagosCabService;

    @EJB
    private GestorPguPagoDetServiceLocal gestorPguPagoDetService;

    @EJB
    private GestorMatriculaAluServiceLocal gestorMatriculaAluService;

    @EJB
    private GestorMatriPagoServiceLocal gestorMatriPagoService;
    
    @EJB
    private GestorPlanServiceLocal gestorPlanService;
   
    @EJB
    private GestorSesionPlanServiceLocal gestorSesionPlanService;

    @EJB
    private GestorTemaPlanServiceLocal gestorTemaPlanService;


//3.ACCIONES JSF
    
    //4.Metodos Propios
    public void doReporteMatricula(CepCecMatriAlu cepCecMatriAlu) {
        CepCecMatriAlu matricula = new CepCecMatriAlu();
        matricula = cepCecMatriAlu;
        // List<CepCecMatriAlu> lstmat = new ArrayList<>();
       // try {
           //  usuarioController.getFramework().doMensajeR("1", "msas", 1);
            System.out.println("entro al try");
            JasperPrint jasperPrint;
            //Preparar jasperPrint
            parametros = new HashMap();
            ///***** duracion
            
            String duracion;
            Integer cant = matricula.getCepCecCurGrup().getCepCecCursoSubdet().getCepEscalaTipomod().getNumEscala();
           // usuarioController.getFramework().doMensajeR("2", "msas", 1);

            duracion = cant + matricula.getCepCecCurGrup().getCepCecCursoSubdet().getCepEscalaTipomod().getNombreEscala();
          
            System.out.println(matricula.getDrtPersonanatural().getNumeroPndid());
            System.out.println(matricula.getDrtPersonanatural().getNombreCompleto());
            Integer fpago = null;
            ///****forma de pago/***   1:mensual   2:por cuotas
            try {
               fpago= matricula.getCepCecCurGrup().getCepCecCursoSubdet().getFormaPago();

            } catch (NullPointerException e) {
                            usuarioController.getFramework().doMensajeR("Forma de Pago", "Asigne una forma de pago al curso detallado", 4);
            }
                String formapago="" ;
            if (fpago==1) {
                formapago = "Pago Mensual";
            }else{
                Integer ncuotas = null;
                try {
                    ncuotas = matricula.getCepCecCurGrup().getCepCecCursoSubdet().getNumCuotas();
                } catch (NullPointerException e) {
                  usuarioController.getFramework().doMensajeR("Error", "El curso no tiene asignado un numero de cuotas", 4);
                }
                formapago = "Pago en "+ ncuotas  +" cuotas";
            }
            System.out.println("forma de pago es "+formapago);
                       // usuarioController.getFramework().doMensajeR("3", ""+formapago, 1);

            //*datos personales
            String apellidos = matricula.getDrtPersonanatural().getApPaterno()+ " " + matricula.getDrtPersonanatural().getApMaterno() ;
            CepCecCursoSubdet curso =   matricula.getCepCecCurGrup().getCepCecCursoSubdet();
            //  usuarioController.getFramework().doMensajeR("4", ""+curso.getCepCecCursoDet().getCepCecCursoCab().getNomCurso(), 1);
            String nomcurso  = curso.getCepCecCursoDet().getCepCecCursoCab().getNomCurso() + " " +curso.getCepCecCursoDet().getCepNivel().getNomAbrevNivel()  ;
            String desarrollo = curso.getCepTipoDesarrollo().getNomTipoDes();
            String modalidad = curso.getCepEscalaTipomod().getCepTipoModalidad().getNomModalidad();
            int idcurgrup =  matricula.getCepCecCurGrup().getIdCurGrup();
            //CepCecCurGrupDet grupo  =gestorCepCecCurGrupDetalleService.recuperarIdGrupoCurso(idcurgrup);
            CepCecHorarios horario= gestorHorariosService.capturarIdHorario(idcurgrup);
             String horarios ="";
            try {
                 horarios =horario.getCepHorarioDias().getNomHorarioDias();
            } catch (NullPointerException e) {
                 usuarioController.getFramework().doMensajeR("Error 5", ""+e, 4);
            }
            
            String horai = "" + horario.getHoraIni();
            String horaf = "" + horario.getHoraFin();
            String tipoalu ;
            switch (usuarioController.getTipo_alumno()) {
                case 1:
                    tipoalu = "Alumno UNS";
                    break;
                case 2:
                    tipoalu = "Pub. General";
                    break;
                case 3:
                    tipoalu = "Trabj. UNS";
                    break;
               default:
                    throw new AssertionError();
            }
           //    usuarioController.getFramework().doMensajeR("5", ""+tipoalu, 1);
            System.out.println("tipo de al es "+tipoalu);
            String sexo;
            if (matricula.getDrtPersonanatural().getSexo()=='M') {
                sexo = "Masculino";
            }else{
                sexo= "Femenino";
            }
         // usuarioController.getFramework().doMensajeR("6", ""+sexo, 1);
        
            CepCecMatriPago inscripcion= gestorMatriPagoService.buscarPagoMatriculaPorAlumno(matricula.getIdMatriAlu());
            if (inscripcion!=null) {
                String condicion;
                switch (inscripcion.getCondicionAlu()) {
                        case 1:
                            condicion = "Alumno Normal";
                        break;
                        case 2:
                           condicion = "Alumno Media Beca";
                        break;
                        case 7:
                            condicion = "Alumno Becado";
                        break;
                        case 8:
                            condicion = "Alumno Trabajador Uns, pago descuento por planilla";
                        break;
                    default:
                        throw new AssertionError();
                }
                System.out.println("condicion es  "+condicion);
                 //usuarioController.getFramework().doMensajeR("7", ""+condicion, 1);

                if (inscripcion.getCondicionAlu()==7 || inscripcion.getCondicionAlu()==8 ) {
                    String codconepto =" ";
                             String monto = " " ;
                             if (inscripcion.getCondicionAlu()==7) {
                                    if (fpago==1) {
                                        if (inscripcion.getIsPagototal()) {
                                             formapago ="Beca Completo";
                                        }else{
                                            formapago ="Beca para un mes";
                                        }
                                    }else{
                                        //fpago==2
                                        if (inscripcion.getIsPagototal()) {
                                            formapago ="Beca Completo";
                                        }else{
                                            formapago="Beca para una cuota";
                                        }
                                    }
                              }else{
                                 ///  inscripcion.getCondicionAlu()==8
                                    if (fpago==1) {
                                        if (inscripcion.getIsPagototal()) {
                                             formapago ="Descuento por Planilla(Pago Completo)";
                                        }else{
                                            formapago ="Descuento por Planilla un Mes";
                                        }
                                    }else{
                                        //fpago==2
                                        if (inscripcion.getIsPagototal()) {
                                            formapago ="Descuento por Planilla(Pago Completo)";
                                        }else{
                                            formapago="Descuento por Planilla una cuota";
                                        }
                                    }
                               }
                             
                                     usuarioController.getFramework().doMensajeR("7", "", 1);

                                         parametros.put("codMatri",  matricula.getCodMatricula());
                                         parametros.put("condicion", condicion);
                                         parametros.put("duracion", duracion);
                                         parametros.put("formapago", formapago);
                                         parametros.put("pago", monto);
                                         parametros.put("codconepto",codconepto);
                                         parametros.put("sexo", sexo);
                                         parametros.put("tipoalu", tipoalu);
                                         parametros.put("horaf", horaf);
                                         parametros.put("horai", horai);
                                         parametros.put("horarios", horarios);
                                         parametros.put("modalidad",modalidad);
                                         parametros.put("desarrollo",desarrollo); 
                                         parametros.put("nomcurso",nomcurso);
                                         //parametros.put("apellidos", apellidos);

                                   //usuarioController.getFramework().doMensajeR("8", ""+sexo, 1);


                                     String bs_nombreFile = "reporteInscripcion"; //nombre del reporte jrxml;
                                     System.out.println("guardo nombre");
                                    // usuarioController.getFramework().doMensajeR("9", "guardonombre", 1);

                                     jasperPrint = usuarioController.getFramework().doGenerarJasper(new Object[]{matricula}, parametros, bs_nombreFile);
                                     System.out.println("guardo jasperrprint");
                                    // usuarioController.getFramework().doMensajeR("10", "guardo jasperprint", 1);
                                     //jasperPrint = usuarioContrcabooller.getFramework().doGenerarJasper(lstEvaluacionDetallada, parametros, bs_nombreFile);
                                     String bs_nombreDescarga = "Inscripcion"+matricula.getDrtPersonanatural().getNumeroPndid();
                                     usuarioController.getFramework().doReportePdf(jasperPrint, bs_nombreDescarga);
                                    // usuarioController.getFramework().doMensajeR("11", "acabo", 1);
                                     System.out.println("acabo");
                                     //usuarioController.getFramework().doReportePdf(jasperPrint, bs_nombreDescarga);
                }else{
                    PguPagospersDet pago = gestorPguPagoDetService.buscarPagoPorAlumnoMatriculado(inscripcion.getPguPagospersCab().getIdNumpago());

                       if (pago!=null) {
                             String codconepto =""+ inscripcion.getCodConcepto();
                             String monto = "S/. " + pago.getMonto();
                              if ( inscripcion.getIsPagototal()) {
                                 formapago = "Pago al Contado total del curso";
                              }
                               usuarioController.getFramework().doMensajeR("12", "pago", 1);
                             System.out.println("mon es "+monto);
                                         parametros.put("codMatri",  matricula.getCodMatricula());
                                         parametros.put("condicion", condicion);
                                         parametros.put("duracion", duracion);
                                         parametros.put("formapago", formapago);
                                         parametros.put("pago", monto);
                                         parametros.put("codconepto",codconepto);
                                         parametros.put("sexo", sexo);
                                         parametros.put("tipoalu", tipoalu);
                                         parametros.put("horaf", horaf);
                                         parametros.put("horai", horai);
                                         parametros.put("horarios", horarios);
                                         parametros.put("modalidad",modalidad);
                                         parametros.put("desarrollo",desarrollo); 
                                         parametros.put("nomcurso",nomcurso);
                                         //parametros.put("apellidos", apellidos);

                                        //  usuarioController.getFramework().doMensajeR("13", "inicia", 1);
                                         
                                     String bs_nombreFile = "reporteInscripcion"; //nombre del reporte jrxml;
                                     System.out.println("guardo nombre");
                                    // usuarioController.getFramework().doMensajeR("14", "guardonombre", 1);

                                     jasperPrint = usuarioController.getFramework().doGenerarJasper(new Object[]{matricula}, parametros, bs_nombreFile);
                                     System.out.println("guardo jasperrprint");
                                    //  usuarioController.getFramework().doMensajeR("15", "guardo jasperprint", 1);

                                     //jasperPrint = usuarioContrcabooller.getFramework().doGenerarJasper(lstEvaluacionDetallada, parametros, bs_nombreFile);
                                     String bs_nombreDescarga = "reporteInscripcion";
                                     usuarioController.getFramework().doReportePdf(jasperPrint, bs_nombreDescarga);
                                     System.out.println("acabo");
                                     //usuarioController.getFramework().doMensajeR("16", "acabo", 1);

                                     //usuarioController.getFramework().doReportePdf(jasperPrint, bs_nombreDescarga);
                         }else{
                          usuarioController.getFramework().doMensajeR("Matricula", "Alumno sin registro de pago", 4);
                         }
                    
                }
 
             
            }else{
                   usuarioController.getFramework().doMensajeR("Matricula", "Alumno sin registro de pago", 4);

            }
    
       // } catch (Exception e) {
         //   usuarioController.getFramework().doMensajeR("Error 404!", ""+e, 2);
       // }

    }
    
    public void doReportePlan(CepCecPlan plan){
       entityPlan = plan; 
       lstSesiones = new ArrayList<>();
       lstTemas = new ArrayList<>();

      //  try {
                                ///*** cargar sesiones**//
                                lstSesiones = gestorSesionPlanService.buscarTodos(entityPlan.getIdPlan());
                                
                              JasperPrint jasperPrint;
                              //Preparar jasperPrint
                              parametros = new HashMap();    
                              parametros.put("plan", entityPlan.getDetalles() );
                                    
                                     String bs_nombreFile = "reporteTemario"; //nombre del reporte jrxml;
                                     System.out.println("guardo nombre");
                                     jasperPrint = usuarioController.getFramework().doGenerarJasper(lstSesiones, parametros, bs_nombreFile);
                                     System.out.println("guardo jasperrprint");
                                     //jasperPrint = usuarioContrcabooller.getFramework().doGenerarJasper(lstEvaluacionDetallada, parametros, bs_nombreFile);
                                     String bs_nombreDescarga = "reportetTemario";
                                     usuarioController.getFramework().doReportePdf(jasperPrint, bs_nombreDescarga);
                                     System.out.println("acabo");
                                     //usuarioController.getFramework().doReportePdf(jasperPrint, bs_nombreDescarga);
            
     //   } catch (Exception e) {
                  usuarioController.getFramework().doMensajeR("Error", "", 4);

       // }
    
    }
       
    
    public void doDescagarManualDocente(ActionEvent event){
      try {
            this.bs_nombreFile = "ManualCecompDoc.pdf";
            this.bs_rutaFile ="D:/UDEMSI-SIIGAA/Manuales";
// this.bs_rutaFile = "D:/UDEMSI-SIIGAA/Manuales";
        this.doDescargarFile();           
//usuarioController.getFramework().doDescargarFile(bs_rutaFile, bs_nombreFile);
        } catch (FileNotFoundException e) {
            usuarioController.getFramework().doMensajeR("Descarga de Archivo", "El archivo de descarga no existe", 4);
        }
    }
    
    public void doDescagarManualAlumno(ActionEvent event){
    try {
            this.bs_nombreFile = "ManualCecompAlu.pdf";
            this.bs_rutaFile = "D:/UDEMSI-SIIGAA/Manuales";
            //usuarioController.getFramework().doDescargarFile(bs_rutaFile, bs_nombreFile);
            this.doDescargarFile();
        } catch (FileNotFoundException e) {
            usuarioController.getFramework().doMensajeR("Descarga de Archivo", "El archivo de descarga no existe", 4);
        }
    }
      
    public void doDescagarManualAdmi(ActionEvent event){
    try {
            this.bs_nombreFile = "ManualCecompAdm.pdf";
            this.bs_rutaFile = "D:/UDEMSI-SIIGAA/Manuales";
            this.doDescargarFile();
            //usuarioController.getFramework().doDescargarFile(bs_rutaFile, bs_nombreFile);
        } catch (FileNotFoundException e) {
            usuarioController.getFramework().doMensajeR("Descarga de Archivo", "El archivo de descarga no existe", 4);
        }
    }
    
    
    protected StreamedContent doDescargarFile() throws FileNotFoundException {
        //System.out.println("llego a doDescarArchivo");
        bs_rutaFile = bs_rutaFile + "/" + bs_nombreFile;
        File tempFile = new File(bs_rutaFile);
        InputStream stream;
        stream = new FileInputStream(tempFile);
        bsc_file = new DefaultStreamedContent(stream, new MimetypesFileTypeMap().getContentType(tempFile), bs_nombreFile);
        
        try {
            stream.reset();
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
        return bsc_file;
    }
     

    //*5 GET Y SET
    public Map getParametros() {
        return parametros;
    }

    public void setParametros(Map parametros) {
        this.parametros = parametros;
    }

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

    public void setGestorHorariosService(GestorHorariosServiceLocal gestorHorariosService) {
        this.gestorHorariosService = gestorHorariosService;
    }

    public GestorPguPagosCabServiceLocal getGestorPguPagosCabService() {
        return gestorPguPagosCabService;
    }

    public void setGestorPguPagosCabService(GestorPguPagosCabServiceLocal gestorPguPagosCabService) {
        this.gestorPguPagosCabService = gestorPguPagosCabService;
    }

    public GestorPguPagoDetServiceLocal getGestorPguPagoDetService() {
        return gestorPguPagoDetService;
    }

    public void setGestorPguPagoDetService(GestorPguPagoDetServiceLocal gestorPguPagoDetService) {
        this.gestorPguPagoDetService = gestorPguPagoDetService;
    }

    public GestorMatriculaAluServiceLocal getGestorMatriculaAluService() {
        return gestorMatriculaAluService;
    }

    public void setGestorMatriculaAluService(GestorMatriculaAluServiceLocal gestorMatriculaAluService) {
        this.gestorMatriculaAluService = gestorMatriculaAluService;
    }

    public GestorMatriPagoServiceLocal getGestorMatriPagoService() {
        return gestorMatriPagoService;
    }

    public void setGestorMatriPagoService(GestorMatriPagoServiceLocal gestorMatriPagoService) {
        this.gestorMatriPagoService = gestorMatriPagoService;
    }

    public void setEntityPlan(CepCecPlan entityPlan) {
        this.entityPlan = entityPlan;
    }

    public void setLstSesiones(List<CepCecSesion> lstSesiones) {
        this.lstSesiones = lstSesiones;
    }

    public void setLstTemas(List<CepCecTema> lstTemas) {
        this.lstTemas = lstTemas;
    }

    public GestorPlanServiceLocal getGestorPlanService() {
        return gestorPlanService;
    }

    public void setGestorPlanService(GestorPlanServiceLocal gestorPlanService) {
        this.gestorPlanService = gestorPlanService;
    }

    public GestorSesionPlanServiceLocal getGestorSesionPlanService() {
        return gestorSesionPlanService;
    }

    public void setGestorSesionPlanService(GestorSesionPlanServiceLocal gestorSesionPlanService) {
        this.gestorSesionPlanService = gestorSesionPlanService;
    }

    public GestorTemaPlanServiceLocal getGestorTemaPlanService() {
        return gestorTemaPlanService;
    }

    public void setGestorTemaPlanService(GestorTemaPlanServiceLocal gestorTemaPlanService) {
        this.gestorTemaPlanService = gestorTemaPlanService;
    }

    public String getBs_rutaFile() {
        return bs_rutaFile;
    }

    public void setBs_rutaFile(String bs_rutaFile) {
        this.bs_rutaFile = bs_rutaFile;
    }

    public String getBs_nombreFile() {
        return bs_nombreFile;
    }

    public void setBs_nombreFile(String bs_nombreFile) {
        this.bs_nombreFile = bs_nombreFile;
    }

    public StreamedContent getBsc_file() {
        return bsc_file;
    }

    public void setBsc_file(StreamedContent bsc_file) {
        this.bsc_file = bsc_file;
    }

    
    
    
}
