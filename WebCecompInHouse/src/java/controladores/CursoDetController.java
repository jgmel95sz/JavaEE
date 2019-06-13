/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.MetodosExtras;
import ejb.dao.CursoGrupoDAOLocal;
import ejb.negocio.DescuentoExoServiceLocal;
import ejb.negocio.ExoneradosServiceLocal;
import ejb.negocio.GestorCepCecCursoCabServiceLocal;
import ejb.negocio.GestorCepNivelServiceLocal;
import ejb.negocio.GestorCursoDetServiceLocal;
import ejb.negocio.GestorCursoGrupoServiceLocal;
import ejb.negocio.GestorCursoSubDetServiceLocal;
import ejb.negocio.GestorEscalaModalidadServiceLocal;
import ejb.negocio.GestorPlanServiceLocal;
import ejb.negocio.GestorSesionPlanServiceLocal;
import ejb.negocio.GestorTemaPlanServiceLocal;
import ejb.negocio.GestorTipoDesarrolloServiceLocal;
import ejb.negocio.GestorTipoModalidadLocal;
import ejb.negocio.GestorTipoPagosServiceLocal;
import entidades.CepCecCursoCab;
import entidades.CepCecCursoDet;
import entidades.CepCecCursoSubdet;
import entidades.CepCecInversionCurso;
import entidades.CepCecPlan;
import entidades.CepCecSesion;
import entidades.CepCecTema;
import entidades.CepEscalaTipomod;
import entidades.CepNivel;
import entidades.CepTipoDesarrollo;
import entidades.CepTipoModalidad;
import entidades.PguTipoPagos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
//import javax.inject.Named;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
//import javax.enterprise.context.SessionScoped;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.RowEditEvent;
import ejb.negocio.GestorInversionServiceLocal;
import ejb.negocio.GestorRcdConceptoServiceLocal;
import ejb.negocio.GestorRcdTarifarioServiceLocal;
import ejb.negocio.GestorTipoAlumnoServiceLocal;
import ejb.negocio.GestorTipoInversionServiceLocal;
import entidades.CepCecDescExonerados;
import entidades.CepCecExonerados;
import entidades.CepCecTipAlumno;
import entidades.CepCecTipoInversion;
import entidades.DrtPersonanatural;
import entidades.RcdConcepto;
import entidades.RcdTarifario;
import frameworkHANM.*;
import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;

/**
 *
 * @author MELVN
 */
@ManagedBean(name = "cursoDetController")
@SessionScoped
public class CursoDetController implements Serializable {

//1. Atributos
    /**
     * Tipo: Variable <br>
     * Descripcion: Nombre del archivo a cargar o descargar. <br>
     * Ejemplo: Manual.pdf
     */
    // llamando usuario controller
    @ManagedProperty(value = "#{usuarioController}")
    public UsuarioController usuarioController;

    @PostConstruct
    public void init() {
        pageNumberCursoDet = 1;
        pageNumberPlan = 1;
        pageNumberMediaBeca = 1;
        tipoEnsenanza = 0;
        pageNumberCursoCab = 1;
        this.doListarConceptosRcd();
    }

    private CepCecDescExonerados cepCecDescExonerados;
    //Atributos de curso      
    private CepCecCursoCab cursocab;
    private List<CepCecCursoCab> lstCursos;
    private List<CepCecCursoCab> lstCursosNombres;
    private int idCurso;
    private String nom_curso;
    private String desCrip;
    private Short curEstado;
    private int tipoEnsenanza;
    private int pageNumberCursoCab;
    private List<Integer> paginacionCursoCab;
    private Integer visibleEditarCurso;
    private String nomcur_found = "";
    //Atributos plan
    private int idPlan;
    private int pageNumberPlan;
    private List<Integer> paginacionPlan;
    private String detPlan;
    private Short estadoPlan = 0;
    private List<CepCecPlan> lstPlan;
    private Date fecha_reg_plan;
    private CepCecPlan cepCecPlan;
    private int periodo = 0;
    private int anio_plan;
    private String name_cur_plan;
    private List<CepCecPlan> lstPeriodoPlan;
    private int id_ultimo_plan;
    private CepCecPlan SelectedConPlanEdit; // se usa para seleccionar en la tabla una fila en objeto 
    private Short verNuevoPlan;
    private boolean copiarBase;
    //UltimaActualizacion
    //Atributos Sesion
    private int id_sesion;
    private String nombre_sesion;
    private CepCecSesion cepCecSesion;
    private List<CepCecSesion> lstSesion;
    private CepCecSesion SelectRowSesion; // se usa para seleccionar en la tabla una fila en objeto 
    private CepCecSesion SelectedFilaSesion; // se usa para seleccionar en la tabla una fila en objeto 
    private int conforme = 0;
    private Integer validarCurso;
    // atributos tema
    private int id_tema;
    private String nom_tema;
    private CepCecTema cepCecTema;
    private List<CepCecTema> lstTema;
    private CepCecTema SelectedFilaTema;

    // Atributos Nivel
    private List<CepNivel> lstNivel;
    private int idnivel;
    private String nom_nivel;
    private int num_cep_nivel = 0;
    private CepNivel cepNivel;

    // atributos tipo de desarrollo
    private String nomDesarollo;
    private Short estadoDesarrollo = 0;
    private int cep_num = 0;
    private List<CepTipoDesarrollo> lstTipoDesarrollo;
    private int idTipoDesarollo;
    private CepTipoDesarrollo cepTipoDesarrollo;

    // atributos tipo de modalidad
    private int id_Modalidad;
    private String nomModalidad;
    private Short estadoModalidad = 0;
    private int cep_num_modalidad = 0;
    private List<CepTipoModalidad> lstTipoModalidad;
    private CepTipoModalidad cepTipoModalidad;

    // atributos escala_tipomodalidad
    private List<String> lstNomEscala;
    private int idEscalita;
    private String nomEscala;
    private int numEscala;
    private Short estadoEscala;
    private List<CepEscalaTipomod> lstTodoEscala;  // atributo para traer toda la entidad y listar
    private CepEscalaTipomod cepEscalaTipomod;

    // atributos cursodet
    private int id_curso_det;
    private Short estado_curso_det;
    private CepCecCursoDet cepCursoDet;
    private List<CepCecCursoDet> lstCursoDet;
    private List<CepCecCursoDet> lstCursoDetTodos;
    private CepCecCursoDet selectedCursos; // se usa para seleccionar en la tabla una fila en objeto 
    private int pageNumberCursoDet;
    private List<Integer> paginacionCursoDet;
    private String nombreCursoCompleto;
    //atributos cursosubdet
    private Integer num_cuotas;
    private int min_alu;
    private int num_pagos;
    private int max_alum;
    private Short estado_detcur;
    private int horas_lectivas;
    private CepCecCursoSubdet cepCursoSubDet;
    private List<CepCecCursoSubdet> lstCusoSubDet;
    private CepCecCursoSubdet SelectedListCurSubDet; // se usa para seleccionar en la tabla una fila en objeto 
    private int formapago;
    private int num_clases;
    //atributos tipoPagos
    private List<PguTipoPagos> lstConceptosPGU;
    private Integer id_tipoPagos;
    private String concepto_pgu;
    private Float precio_pgu;
    private PguTipoPagos pguTipoPagos;

    //atributos inversion
    private int id_inversion;
    private String codigo_inversion;
    private String nombre_inversion;
    private Float precio_total;
    private Float precio;
    private Short estado_inver;
    private String descrp_inver;
    private boolean estado_concepto_total;
    private List<CepCecInversionCurso> lstInverAlumUNS;
    private List<CepCecInversionCurso> lstInverPubGen;
    private List<CepCecInversionCurso> lstInverTrabUNS;
    private CepCecInversionCurso SelectedInversion; // se usa para seleccionar en la tabla una fila en objeto 
    private CepCecInversionCurso cepCecInversionCurso;
    private int conformeInver;
    private char optionPago;
    private List<CepCecDescExonerados> lsCecDescExoneradoses;

    // atributos tipo inversion
    private List<CepCecTipoInversion> lstTipoInversion;
    private int id_tipo_inver;
    private String nombre_tipoinver;
    private int ver_tipoinver;
    private CepCecTipoInversion cepCecTipoInversion;
    private String capturaTipoPagos;

    // atributos tipo alumno
    private int id_tipoAlumno;
    private String id_tipoAlu;
    private String nom_tipo_alumno;
    private CepCecTipAlumno cepCecTipAlumno;
    private List<CepCecTipAlumno> lstTipoAlumno;

    //atributos para rcd tarifario y concepto
    private List<RcdConcepto> lstRcdConceptos;
    private RcdTarifario rcdTarifario;
    private int id_rcdConcepto;
    private RcdConcepto rcdConcepto;

    // para habilitar y desabilitar botones
    private boolean enabled;
    private boolean disabled;

    //variables de validacion de modals de confirmacion
    private int tipoModal;

    //MediaBeca
    //private List<CepCecDescExonerados> lstCursoDet;
    private int pageNumberMediaBeca;
    private List<Integer> paginacionMediaBeca;
    private Date fechaLimite;
    private String fechaMin;

    //Beca
    private String secuenciaExo;
    private Short agenciaExo;
    private String fechaExo;
    private String numResoulcion;
    private Integer tipoExo;
    private int id_exo;
    private int pagototal;
    private int id_desc_exonerados;
    private List<CepCecExonerados> lstExonerados;

//2. EJBs
    @EJB
    private GestorCepCecCursoCabServiceLocal gestorCepCecCursoCabService;

    @EJB
    private GestorPlanServiceLocal gestorPlanService;

    @EJB
    private GestorCepNivelServiceLocal gestorCepNivelService;

    @EJB
    private GestorTipoDesarrolloServiceLocal gestorTipoDesarrolloService;// llama negocio de Tipo de desarrollo

    @EJB
    private GestorEscalaModalidadServiceLocal gestorEscalaModalidadService;
    @EJB
    private GestorTipoModalidadLocal gestorTipoModalidad; // llama negocio de Tipo de modalidad

    @EJB
    private GestorCursoDetServiceLocal gestorCursoDetService;

    @EJB
    private GestorSesionPlanServiceLocal gestorSesionPlanService;

    @EJB
    private GestorTemaPlanServiceLocal gestorTemaPlanService;

    @EJB
    private GestorCursoSubDetServiceLocal gestorCursoSubDetService;

    @EJB
    private GestorTipoPagosServiceLocal gestorTipoPagosService;

    @EJB
    private GestorInversionServiceLocal gestorInversionService;

    @EJB
    private GestorTipoInversionServiceLocal gestorTipoInversionService;

    @EJB
    private GestorTipoAlumnoServiceLocal gestorTipoAlumnoService;

    @EJB
    private GestorRcdTarifarioServiceLocal gestorRcdTarifarioService;

    @EJB
    private GestorRcdConceptoServiceLocal gestorRcdConceptoService;

    @EJB
    private GestorCursoGrupoServiceLocal gestorCursoGrupoService;

    @EJB
    private DescuentoExoServiceLocal descuentoExoService;

    @EJB
    private ExoneradosServiceLocal exoneradosService;

    //3. Acciones JSF
    public CursoDetController() {

    }

    //4. Metodos Propios
    // This function send some data to db (Esta funcion envia datos a la bd)
    public void doTamanoPaginacionCursoCab() {
        // Calcula tras metodos numericos cauntas pagSize cuantos botones de paginacion va tener
        int x = gestorCepCecCursoCabService.tamanoPaginacionNombreCab();
        System.out.println("x es " + x);
        paginacionCursoCab = new ArrayList<>();
        //si la paginacion es 0 entonces solo se agregara un unico boton
        if (x == 0) {
            paginacionCursoCab.add(1); // es 1 para que no de error en el calculo al llamar la lista de la tabla
        } else {
            //llena los numeros a las lista integer 
            for (int i = 1; i <= x; i++) {
                paginacionCursoCab.add(i);
            }
        }
        System.out.println("salio de paginacion");
        System.out.println("el tamaño es "+ paginacionCursoCab.size());
        //retorna esta lista para que en la vista con un repetidor listar los botones de paginacion
        //return paginacionCursoDet;
    }

    // This function send some data to db (Esta funcion envia datos a la bd)
    public void doTamanoPaginacionCursoDet() {
        // Calcula tras metodos numericos cauntas pagSize cuantos botones de paginacion va tener
        int x = gestorCursoDetService.tamanoPaginacionCursoDet();
        System.out.println("x es " + x);
        paginacionCursoDet = new ArrayList<>();
        //si la paginacion es 0 entonces solo se agregara un unico boton
        if (x == 0) {
            paginacionCursoDet.add(1); // es 1 para que no de error en el calculo al llamar la lista de la tabla
        } else {
            //llena los numeros a las lista integer 
            for (int i = 1; i <= x; i++) {
                paginacionCursoDet.add(i);
            }
        }
        //retorna esta lista para que en la vista con un repetidor listar los botones de paginacion
        //return paginacionCursoDet;
    }
    
    // This function send some data to db (Esta funcion envia datos a la bd)
    public void doTamanoPaginacionCursoDetFiltro() {
        // Calcula tras metodos numericos cauntas pagSize cuantos botones de paginacion va tener
        int x = gestorCursoDetService.tamanoPaginacionCursoDetFiltro(nomcur_found , tipoEnsenanza);
        System.out.println("x es " + x);
        paginacionCursoDet = new ArrayList<>();
        //si la paginacion es 0 entonces solo se agregara un unico boton
        if (x == 0) {
            paginacionCursoDet.add(1); // es 1 para que no de error en el calculo al llamar la lista de la tabla
        } else {
            //llena los numeros a las lista integer 
            for (int i = 1; i <= x; i++) {
                paginacionCursoDet.add(i);
            }
        }
        //retorna esta lista para que en la vista con un repetidor listar los botones de paginacion
        //return paginacionCursoDet;
    }

    public void doCapturarPaginaCurDet(Integer pagina) {
        //caputra el numero de la pagina
        this.pageNumberCursoDet = pagina;
        //y gracias al ajax update actualizare 
        this.doBuscarCursoDet();
    }

    public void doBuscarCursoDet() {
        //this.pageNumberCursoDet se inicializa con 1 en el @postContruct que se ejectua al comienzo del programa 
        lstCursoDet = new ArrayList<>();
        lstCursoDet = gestorCursoDetService.buscarTodos(this.pageNumberCursoDet);
    }

 
     public void doBuscarCursoDetFiltro() {
        //this.pageNumberCursoDet se inicializa con 1 en el @postContruct que se ejectua al comienzo del programa 
        lstCursoDet = new ArrayList<>();
        lstCursoDet = gestorCursoDetService.buscarTodosFiltro(this.pageNumberCursoDet,nomcur_found,tipoEnsenanza);
    }
    
    public void doBuscarCursoDetTodos() {
        //this.pageNumberCursoDet se inicializa con 1 en el @postContruct que se ejectua al comienzo del programa 
        lstCursoDetTodos = new ArrayList<>();
        lstCursoDetTodos = gestorCursoDetService.buscarTodosCurDet();
    }
    // This function send some data to db (Esta funcion envia datos a la bd)// This function send some data to db (Esta funcion envia datos a la bd)
    public void doCrearCursoGeneral() {

        System.out.println("SE INGRESO " + nom_curso);

        int validar = gestorCepCecCursoCabService.validarRepeticionNombres(nom_curso);
        System.out.println("VALIDAR " + validar);

        if (validar == 0) {
            curEstado = 1;
            cursocab = new CepCecCursoCab();
            cursocab.setNomCurso(nom_curso);
            cursocab.setEstadoCabcur(curEstado);
            gestorCepCecCursoCabService.crearNuevoCurso(cursocab);
            pageNumberCursoCab=1;
            this.doTamanoPaginacionCursoCab();
            this.doBuscarCursos();
            usuarioController.getFramework().doMensajeF("Exito", "Se guardo correctamente!", 1);
            //doMensajeR("Exito", "Se guardo correctamente!", 1);

        } else {
            usuarioController.getFramework().doMensajeF("Repeticion", "Este nombre de curso ya existe!", 4);
            //doMensajeR("Repeticion", "Este nombre de curso ya existe!", 4);
            //doMensajeF("Repeticion", "Este nombre de curso ya existe!", 4);
            System.out.println("SE REPITEN");
        }

    }

    public void doModificarNombreCurso() {
        try {
            System.out.println("entro a modificar");
            gestorCepCecCursoCabService.actualizarCurso(cursocab);
            System.out.println("modifico");
            usuarioController.getFramework().doMensajeF("Exito!", "Se modifico", 1);
            this.doTamanoPaginacionCursoCab();
            this.doBuscarCursos();

        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "No se pudo modificar", 4);
        }

    }

    public void doModificarCursoGeneral() {
        //  usuarioController.baseController = new fwGeneral2();
        //cepCursoDet = new CepCecCursoDet();
        //cepCursoDet.setCepCecCursoCab(selectedCursos.getCepCecCursoCab()); 
        // cepCursoDet.setCepNivel(selectedCursos.getCepNivel());
        try {
            gestorCursoDetService.actualizarCurso(selectedCursos);
            usuarioController.getFramework().doMensajeF("Exito!", "Se modifico satisfactoriamente", 1);
            System.out.println("se modifico");
            selectedCursos = new CepCecCursoDet();
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "No se modifico ", 4);

        }

    }

    public void doModificarCursoDetallado() {
        //usuarioController.baseController = new fwGeneral2();
        if (num_pagos == 1) { // Solo 1
            num_cuotas = 1;
            formapago = 0;
            cepCursoSubDet.setNumCuotas(num_cuotas);
            cepCursoSubDet.setFormaPago(0);
        }
        gestorCursoSubDetService.actualizarCursoDet(cepCursoSubDet);
        usuarioController.getFramework().doMensajeF("Exito!", "Se modifico satisfactoriamente", 1);
        System.out.println("se modifico");
        cepCursoSubDet = new CepCecCursoSubdet();
    }

    //validar si el curso 
    public int doValidaridCursoCab(int id) {
        // id = id_cursocab
        conforme = 0; // no encontro

        if (gestorCursoDetService.validarIdCursoCab(id)) {
            conforme = 1; // encontro
        }
        return conforme;
    }

    public void doOcultarNombreCurso() {

        try {
            Short estado = 0;
            cursocab.setEstadoCabcur(estado);
            gestorCepCecCursoCabService.actualizarCurso(cursocab);
            System.out.println("Se oculto ");
            this.doTamanoPaginacionCursoCab();
            this.doBuscarCursos();
            usuarioController.getFramework().doMensajeF("Exito!", "Se borro registro", 1);
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "No se borro registro", 4);

        }

    }

    public void doOcultarCursosSubDetalles() {
        Short estado = 0;
        // usuarioController.baseController = new fwGeneral2();

        cepCursoSubDet.setEstadoDetcur(estado);
        gestorCursoSubDetService.actualizarCursoDet(cepCursoSubDet);
        usuarioController.getFramework().doMensajeF("Exito!", "Se borro correctamente", 1);
        System.out.println("Se oculto ");
        lstCusoSubDet = new ArrayList<>();
        lstCusoSubDet = this.doBuscarCursoSubDet();

    }

    public void doCrearTaller() {
        //usuarioController.baseController = new fwGeneral2();
        tipoEnsenanza = 2; //1:curso 2:taller
        //si ya existe
        if (gestorCursoDetService.validarRepeticion(idCurso, idnivel, tipoEnsenanza) == 1) {
            //entonces
            usuarioController.getFramework().doMensajeF("Fallo!", "Ya existe el taller!", 4);

        } else {
            ///crear en tupla detCurso
            cepCursoDet = new CepCecCursoDet();
            estado_curso_det = 1;
            cursocab = gestorCepCecCursoCabService.recuperarIdCursoCab(idCurso);
            cepCursoDet.setCepCecCursoCab(cursocab);
            cepNivel = new CepNivel();
            cepNivel = gestorCepNivelService.recuperarIdNivel(idnivel);
            cepCursoDet.setCepNivel(cepNivel);
            cepCursoDet.setEstadoCursoDet(estado_curso_det);
            gestorCursoDetService.crearNuevoDetCurso(cepCursoDet);
            usuarioController.getFramework().doMensajeF("Exito!", "Se guardo correctamente!", 1);
            redireccionAhCursos();
        }

        this.cepCursoDet = new CepCecCursoDet();

    }

    public void doCrearCursoDet() {
        //usuarioController.baseController = new fwGeneral2();
        // tipoEnsenanza ; //1:curso 2:taller
        //si ya existe
        try {
                if (gestorCursoDetService.validarRepeticion(idCurso, idnivel, tipoEnsenanza) == 1) {
                    //entonces
                    System.out.println("se repiteeeeeee");
                    usuarioController.getFramework().doMensajeR("Fallo!", "Ya existe!", 4);

                } else {
                    ///crear en tupla detCurso
                    cepCursoDet = new CepCecCursoDet();
                    estado_curso_det = 1;
                    cursocab = gestorCepCecCursoCabService.recuperarIdCursoCab(idCurso);
                    cepCursoDet.setCepCecCursoCab(cursocab);
                    cepNivel = new CepNivel();
                    cepNivel = gestorCepNivelService.recuperarIdNivel(idnivel);
                    cepCursoDet.setCepNivel(cepNivel);
                    cepCursoDet.setEstadoCursoDet(estado_curso_det);
                    cepCursoDet.setHorasLectivas(horas_lectivas);
                    cepCursoDet.setModEnsenanza(tipoEnsenanza);
                    gestorCursoDetService.crearNuevoDetCurso(cepCursoDet);
                    usuarioController.getFramework().doMensajeR("Exito!", "Se guardo correctamente!", 1);
                    redireccionAhCursos();
                    
                }

        this.cepCursoDet = new CepCecCursoDet();

        } catch (Exception e) {
                  usuarioController.getFramework().doMensajeF("Fallo!", "Error al intentar crear curso!", 4);

        }
        
    }

    public void doCapturarNombreCurso(CepCecCursoCab cecCursoCab2) {
        cursocab = new CepCecCursoCab();
        cursocab = cecCursoCab2;
        System.out.println("capturo");
    }

    public void doCapturarCursoDet(CepCecCursoDet cepCecCursoDet2) {
        this.doListarNombres();
        selectedCursos = new CepCecCursoDet();
        selectedCursos = cepCecCursoDet2;
        System.out.println("*****************");
        //System.out.println(selectedCursos.getCepCecCursoCab().getNomCurso() ;// selectedCursos.getCepNivel().getNombreNivel());
    }

    public void doCapturarCursoSubDet(CepCecCursoSubdet cepCecCursoSubdet2) {
        cepCursoSubDet = new CepCecCursoSubdet();
        cepCursoSubDet = cepCecCursoSubdet2;
        
         if (doValidarSiExisteInversion(cepCursoSubDet.getIdCursoSubdet())== 0) {
            visibleEditarCurso = 1;
             doBuscarEscala();//carga lista
                    tipoModal = 5;
                    System.out.println("modal 5");
                    if (cepCursoSubDet.getNumCuotas() > 1) {
                        num_pagos = 2;
                    } else {
                        if (cepCursoSubDet.getNumCuotas() <= 0) {
                            num_pagos = 0;
                            System.out.println("Error num de pagos menor igual a 0");
                        } else {
                            num_pagos = 1;
                        }
                    }
        }else{
            visibleEditarCurso =0;
        }
       
        
       
        
    }

    public void doCapturarPaginaCurCab(Integer pagina) {
        //caputra el numero de la pagina
        this.pageNumberCursoCab = pagina;
        //y gracias al ajax update actualizare 
        this.doBuscarCursos();
    }

    // this function recuperate data to db  (esta funcion trae datos de la bd)
    public void doBuscarCursos() {
        lstCursos = new ArrayList<>();
        lstCursos = gestorCepCecCursoCabService.buscarTodos(this.pageNumberCursoCab);
    }
    
   /*  public void doBuscarTodosCursosNombres() {
        lstCursos = new ArrayList<>();
        lstCursos = gestorCepCecCursoCabService.buscarTodosNombres();
    }*/

    public void doListarNombres() {
      lstCursosNombres=  new ArrayList<>();
      lstCursosNombres = gestorCepCecCursoCabService.buscarTodosNombres();
    }
    public List<CepTipoDesarrollo> doBuscarTipoDesarollo() {
        return lstTipoDesarrollo = gestorTipoDesarrolloService.buscarTodos();
    }

    public List<CepTipoModalidad> doBuscarTipoModalidad() {
        return lstTipoModalidad = gestorTipoModalidad.buscarTodos();
    }

    // en el get de la lista lo cargo
    public List<CepCecInversionCurso> dobuscarInversion() {
        lstInverAlumUNS = new ArrayList<>();
        System.out.println("ENTRO A CONTROLLER");
        return lstInverAlumUNS = gestorInversionService.buscarInversion(usuarioController.getId_curso_subdet(), id_tipo_inver);
    }

    // en el get de la lista lo cargo
    public List<CepCecTipAlumno> doBuscarTodosTipoAlumnos() {
        lstTipoAlumno = new ArrayList<>();
        return lstTipoAlumno = gestorTipoAlumnoService.buscarTiposInversion();
    }

    public void doTamanoPaginacionPlan() {
        // Calcula tras metodos numericos cauntas pagSize cuantos botones de paginacion va tener
        int x = gestorPlanService.tamanoPaginacionPlan(this.id_curso_det);
        System.out.println("x es " + x);
        paginacionPlan = new ArrayList<>();
        //si la paginacion es 0 entonces solo se agregara un unico boton
        if (x == 0) {
            paginacionPlan.add(1); // es 1 para que no de error en el calculo al llamar la lista de la tabla
        } else {
            //llena los numeros a las lista integer 
            for (int i = 1; i <= x; i++) {
                paginacionPlan.add(i);
            }
        }
        //retorna esta lista para que en la vista con un repetidor listar los botones de paginacion
        //return paginacionCursoDet;
    }

    // llama los planes por curso
    // public List<CepCecPlan> doBuscarPlanes() {
    public void doBuscarPlanes() {
        // el id_curso_det se obtiene en el metodo CapturarCurso();
        lstPlan = new ArrayList<>();
        lstPlan = gestorPlanService.buscarPlanes(this.id_curso_det, this.pageNumberPlan);
    }

    public void doCapturarPaginaPlan(Integer pagina) {
        //caputra el numero de la pagina
        this.pageNumberPlan = pagina;
        //y gracias al ajax update actualizare 
        this.doBuscarPlanes();
    }

    //metodos de tipo inversion 
    public List<CepCecTipoInversion> dobuscarTipoInversion() {

        lstTipoInversion = new ArrayList<>();
        for (CepCecTipoInversion entidad : gestorTipoInversionService.buscarTiposInversion()) {
            if (entidad.getIdTipoinversion() == 1 || entidad.getIdTipoinversion() == 2) {
                lstTipoInversion.add(entidad);
            }
        }
        return lstTipoInversion;
    }

    // llama a un OneMenu la lista los conceptos del cecomp en pgu_tipo_pagos
    public List<PguTipoPagos> doBuscarConceptosCecomp() {
        return lstConceptosPGU = gestorTipoPagosService.buscarTodosConceptosCecomp(nom_curso);
    }

    // llama a un OneMenu la lista los conceptos del cecomp en rcd_concepto
   /* public List<RcdTarifario> doListarConceptosRcd() {
        lstRcdConceptos = new ArrayList<>();
        return lstRcdConceptos = gestorRcdTarifarioService.ListarRcdConceptos(id_tipo_inver, id_tipoAlumno, nom_curso);
    }*/
    
    public void doListarConceptosRcd() {
        lstRcdConceptos = new ArrayList<>();
       lstRcdConceptos = gestorRcdConceptoService.buscarConceptosCecomp();
    }

    // lo cargo antes de su vista
    public void doBuscarEscala() {
        lstTodoEscala = gestorEscalaModalidadService.buscarTodos();
    }

    public List<CepCecPlan> doBuscarPlan() {

        return lstPlan = gestorPlanService.buscarTodos();
    }

    public List<CepNivel> doBuscarNivel() {
        return lstNivel = gestorCepNivelService.buscarTodos();
    }

    public List<CepCecSesion> doBuscarSesion() {

        return lstSesion = gestorSesionPlanService.buscarTodos(idPlan);
    }

    public List<CepCecTema> doBuscarTema() {
        /// primero ya caputro id_Sesion en el metodo doCaputrarIdSesion 
        System.out.println("Eentra a DoBuscarTema");

        return lstTema = gestorTemaPlanService.buscarTodos(id_sesion);
    }

    public List<CepCecCursoSubdet> doBuscarCursoSubDet() {
        if (id_curso_det == 0) {
            return lstCusoSubDet = gestorCursoSubDetService.buscarTodos();
        } else {
            if (id_curso_det > 0) {
                return lstCusoSubDet = gestorCursoSubDetService.buscarFiltroPorCursoGeneral(id_curso_det);
            } else {
                return null;
            }
        }
    }

   
    
    public void doElegirInversiones() {
        lstInverAlumUNS = new ArrayList<>();
        lstInverAlumUNS = dobuscarInversion();
    }

    public void doCargarCursosDetalladosDesdeCursosGenerales(CepCecCursoDet entidad) {
        this.id_curso_det = entidad.getIdCursoDet();
        doBuscarCursoSubDet();
        redireccionAhCursosDetallados();
    }

    public void doCargarFiltroPorCursoDet() {
        lstCusoSubDet = doBuscarCursoSubDet();
    }

    public void doCapturarIdCurSubDet(CepCecCursoSubdet cepCecCursoSubdet2) {
        System.out.println("ENTRO CAPTURA CURSO");
        this.SelectedListCurSubDet = new CepCecCursoSubdet();
        SelectedListCurSubDet = cepCecCursoSubdet2;
        usuarioController.enabled_docente = 0;
        usuarioController.setId_curso_subdet(SelectedListCurSubDet.getIdCursoSubdet());
        //usuarioController.id_curso_subdet = SelectedListCurSubDet.getIdCursoSubdet();
        System.out.println("Obtuvo el id " + usuarioController.getId_curso_subdet());
        //obteniendo el plan actual
        this.cepCecPlan = new CepCecPlan();
        cepCecPlan = gestorPlanService.buscarPlanActual(SelectedListCurSubDet.getCepCecCursoDet().getIdCursoDet());
        detPlan = cepCecPlan.getDetalles();
        usuarioController.id_plan = cepCecPlan.getIdPlan();
        System.out.println("EL PLAN ES " + detPlan);
        //redireccionAhCreateGroup(); // me envia a la pagina de crear grupo
        if (doValidarSiExisteInversion(SelectedListCurSubDet.getIdCursoSubdet())==0) {
            visibleEditarCurso = 1;
        }else{
            visibleEditarCurso = 0;
        }

        
    }

    public void doBuscarPlanActual(CepCecCursoSubdet item) {
        this.cepCecPlan = new CepCecPlan();
        cepCecPlan = gestorPlanService.buscarPlanActual(item.getCepCecCursoDet().getIdCursoDet());
    }

    public int findRegistroCursoSubDet(int id_cursosubdet) {
        int exito = 0;
        if (gestorCursoGrupoService.findRegistroCursoSubDet(id_cursosubdet) == 1) {
            exito = 1;
        }
        return exito;

    }

    public String doBeforeCrearPlan() {

        /*ArrayList<String> romanos = new ArrayList<>();
        romanos.add(0, "I");
        romanos.add(1, "II");
        romanos.add(2, "III");
        romanos.add(3, "IV");
         */
        System.out.println("ingreso los romanitos");

        //captura el año del año: 
        Date fechaActual = new Date();
        fecha_reg_plan = fechaActual;
        System.out.println("Fecha reg" + fecha_reg_plan);
        Calendar fechita = Calendar.getInstance();
        int año = fechita.get(Calendar.YEAR);
        anio_plan = año;
        System.out.println("año acutal : " + anio_plan);

        // idCurso = SelectedFilaCurSinPlan.getIdCursoCab();
        //nom_curso = SelectedFilaCurSinPlan.getCepCecCursoCab().getNomCurso();
        nom_curso = selectedCursos.getCepCecCursoCab().getNomCurso();
        nom_nivel = selectedCursos.getCepNivel().getNombreNivel();
        idnivel = selectedCursos.getCepNivel().getIdNivel();
        tipoEnsenanza = selectedCursos.getModEnsenanza();
        // nom_nivel =SelectedFilaCurSinPlan.getCepNivel().getNombreNivel();
        System.out.println("nombre curso: " + nom_curso);
        System.out.println("nom nivel :" + nom_nivel);
        id_curso_det = selectedCursos.getIdCursoDet();
        //id_curso_det = SelectedFilaCurSinPlan.getIdCursoDet();
        System.out.println("id cursoD_det es : " + id_curso_det);
        //llama la lista del año actual para ver si se creo un plan 
        lstPeriodoPlan = gestorPlanService.buscarUltimoPeriodo(id_curso_det, anio_plan);
        if (lstPeriodoPlan == null) {

            periodo = 1;

        } else {
            System.out.println("Entro a bucle");
            Integer ultimo_periodo = 0;
            for (CepCecPlan plan : lstPeriodoPlan) {
                // para ver cual fue el ultimo periodo 
                if (plan.getNumPeriodo() > ultimo_periodo) {
                    ultimo_periodo = plan.getNumPeriodo();
                }
            }
            // luego el ultimo_periodo se le suma uno, para que se guarde el nuevo periodo a guardar. 
            periodo = ultimo_periodo + 1;
        }

        // se sabe el id del ultimo plan activo
        CepCecPlan entidadPlan = new CepCecPlan();
        entidadPlan = gestorPlanService.buscarPlanActual(id_curso_det);
        if (entidadPlan != null) {
            id_ultimo_plan = entidadPlan.getIdPlan();
        } else {
            id_ultimo_plan = 0;
        }
        System.out.println("ultimo plan " + id_ultimo_plan);
        System.out.println("periodo: " + periodo);

        /* for (int i = 0; i < romanos.size(); i++) {
            if ((periodo - 1) == i) {
                periodo_romano = romanos.get(i);
            }
        }*/
        String periodo_romano = gestorPlanService.convertirANumerosRomanos(periodo);

        System.out.println("Reemplazo el num al romano ");
        System.out.println("periodo == " + periodo_romano);
        
        if (tipoEnsenanza == 2) {
             if (idnivel == 0) { //  ninguno
            detPlan = "Temario " + nom_curso + "  " + anio_plan + " - " + periodo_romano;
             } else {
            detPlan = "Temario " + nom_curso + " " + nom_nivel + "  " + anio_plan + " - " + periodo_romano;
        }
        }else{
             if (idnivel == 0) { //  ninguno
            detPlan = "Plan " + nom_curso + "  " + anio_plan + " - " + periodo_romano;
             } else {
            detPlan = "Plan " + nom_curso + " " + nom_nivel + "  " + anio_plan + " - " + periodo_romano;
        }
        }
       
        System.out.println("NOMBRE DEL PLAN : " + detPlan);
        verNuevoPlan = 1; //solo es una condicion para que   se muestre el boton de crear nuevo plan

        return detPlan;

    }

    public void doValidarPlan(){
        cepCecPlan = new CepCecPlan();
        cepCecPlan = gestorPlanService.recuperarIdPlan(idPlan);
       lstSesion =  new ArrayList<>();
       lstSesion =gestorSesionPlanService.buscarTodos(idPlan);
        if (lstSesion!=null) {
            estadoPlan = 1;
           cepCecPlan.setEstadoPlan(estadoPlan);
           cepCecPlan.setPlanActual(true);
           gestorPlanService.actualizarPlan(cepCecPlan);
                if (id_ultimo_plan != 0) {
                // actualizar anterior plan
                 CepCecPlan ultimoPlan = new CepCecPlan();
                 ultimoPlan = gestorPlanService.recuperarIdPlan(id_ultimo_plan);
                 ultimoPlan.setPlanActual(false);
                 //cepCecPlan.setEstadoPlan(estadoPlan);
                 gestorPlanService.actualizarPlan(ultimoPlan);
                 id_ultimo_plan=0;
                
                }else{
                     //actualizar estado de curdet
                    cepCursoDet = new CepCecCursoDet();
                    estado_curso_det = 1;
                    id_curso_det = selectedCursos.getIdCursoDet();
                    //id_curso_det = SelectedFilaCurSinPlan.getIdCursoDet();
                    cepCursoDet = gestorCursoDetService.recuperarIdCurDet(id_curso_det);
                    cepCursoDet.setEstadoCursoDet(estado_curso_det);
                    gestorCursoDetService.actualizarCurso(cepCursoDet);
                    //usuarioController.editPlan = 0;     
                    //Redireccion a Admin/Cursos/CreatePlan.xhtml
                   
                }
             this.redireccionAhCursos();
        }else{
            usuarioController.getFramework().doMensajeR("Error!", "No se ingreso ninguna sesion", 4);
        }
        
    }
    
    public void doCrearPlan() {

        /// llenar a la base
        //id_curso_det = SelectedFilaCurSinPlan.getIdCursoDet();
        id_curso_det = selectedCursos.getIdCursoDet();
        cepCursoDet = gestorCursoDetService.recuperarIdCurDet(id_curso_det);
        estadoPlan = 0;
        cepCecPlan = new CepCecPlan();
        cepCecPlan.setCepCecCursoDet(cepCursoDet);
        cepCecPlan.setDetalles(detPlan);
        cepCecPlan.setAnio(anio_plan);
        cepCecPlan.setNumPeriodo(periodo);
        cepCecPlan.setFechaReg(fecha_reg_plan);
        cepCecPlan.setEstadoPlan(estadoPlan);
        cepCecPlan.setPlanActual(false);
        cepCecPlan = gestorPlanService.crearNuevoPlan(cepCecPlan);

        System.out.println("creo plan");

        idPlan = cepCecPlan.getIdPlan();
        System.out.println("el id plan que se creo es " + idPlan);

        //se carga en crear before plan , y es para coger el ultimo plan activo anterior y ponerle estado inactivo
        // QUIERE DECIR QUE YA EXISTEN PLANES ANTERIORES
        if (id_ultimo_plan != 0) {
            // actualizar anterior plan
            //CepCecPlan ultimoPlan = new CepCecPlan();
            //ultimoPlan = gestorPlanService.recuperarIdPlan(id_ultimo_plan);
            //ultimoPlan.setPlanActual(false);
           // gestorPlanService.actualizarPlan(ultimoPlan);

            // si le da check en copiar base en la vista entonces copiara el plan activo anterior
            if (copiarBase) {
                // llama una lista de sesiones que contiene el plan
                lstSesion = new ArrayList<>();
                lstSesion = gestorSesionPlanService.buscarTodos(id_ultimo_plan);
                if (lstSesion != null) {
                    for (CepCecSesion sesion : lstSesion) {
                        //Copia y Crea nueva sesion en el nuevo plan
                        cepCecSesion = new CepCecSesion();
                        cepCecSesion.setNomSesion(sesion.getNomSesion());
                        cepCecSesion.setEstadoSesion(sesion.getEstadoSesion());
                        cepCecSesion.setCepCecPlan(cepCecPlan); // copia como fk al nuevo plan creado
                        cepCecSesion = gestorSesionPlanService.crearNuevaSesion(cepCecSesion);
                        // por cada tema busca sus temas y los guarda en una lista
                        lstTema = new ArrayList<>();
                        lstTema = gestorTemaPlanService.buscarTodos(sesion.getIdSesion());
                        if (lstTema != null) {
                            for (CepCecTema tema : lstTema) {
                                // Copia y Crea nuevo tema en el nuevo plan  por cada sesion
                                cepCecTema = new CepCecTema();
                                cepCecTema.setNomTema(tema.getNomTema());
                                cepCecTema.setEstadoTema(tema.getEstadoTema());
                                cepCecTema.setCepCecSesion(cepCecSesion);//copia como fk al nuevo sesion creado
                                gestorTemaPlanService.crearNuevaTema(cepCecTema);
                            }
                        }
                    }
                }
            }
            //fin copiar base

        } else {
            //actualizar estado de curdet
           // cepCursoDet = new CepCecCursoDet();
            //estado_curso_det = 1;
          //  id_curso_det = selectedCursos.getIdCursoDet();
           // //id_curso_det = SelectedFilaCurSinPlan.getIdCursoDet();
          //  cepCursoDet = gestorCursoDetService.recuperarIdCurDet(id_curso_det);
         //   cepCursoDet.setEstadoCursoDet(estado_curso_det);
         //   gestorCursoDetService.actualizarCurso(cepCursoDet);
            //usuarioController.editPlan = 0;     
            //Redireccion a Admin/Cursos/CreatePlan.xhtml
        }

        redireccionAhCreatePlan(); // me envia a la pagina de crear grupo

    }

    public void doCapturarSesion() {
        // caputra el id sesion cuando selecciono en la vista de sesiones del plan para listar sus temas
        id_sesion = SelectRowSesion.getIdSesion();
        System.out.println("Obtuvo el id de sesion " + id_sesion);
        lstTema = new ArrayList<>();
        lstTema = this.doBuscarTema();
    }

    // lo que hace es que busca el id del plan del curso seleccionado en la tabla
    // que esta en la vista Cursogenerales.xhtml donde estan todos los cursos generales con sus niveles
    public void doCapturarCurso() {
        cepCecPlan = new CepCecPlan();
        id_curso_det = selectedCursos.getIdCursoDet();
        // id_curso_det = item.getIdCursoDet();
        cepCecPlan = gestorPlanService.buscarPlanActual(id_curso_det);
        usuarioController.id_plan = cepCecPlan.getIdPlan(); // para que se pueda utilizar en el grupoController
        idPlan = cepCecPlan.getIdPlan(); // se sabe el plan actual osea el ultimo creado
        detPlan = cepCecPlan.getDetalles();
        System.out.println("Obtuvo el id de Plan y es " + usuarioController.id_plan);
        System.out.println("Nombre del plan obtenido es: " + detPlan);
        verNuevoPlan = 1; //solo es una condicion para que  se muestre el boton de crear nuevo plan
        pageNumberCursoDet = 1;
        this.doTamanoPaginacionPlan();
        this.doBuscarPlanes();
        //id_ultimo_plan=1;
        // redireccionAhCreatePlan();
    }

    public void doCapturarPlan(CepCecPlan item) {
        idPlan = item.getIdPlan();
        detPlan = item.getDetalles();

    }

    public void doOcultarPlan() {
        try {

            // como ya se cargo la lista antes entonces trae al penultimo plan para ponerlo activo otra vez
            if (lstPlan.size() <= 1) {
                usuarioController.getFramework().doMensajeF("", "No se puede borrar plan , porque es el unico que existe ", 1);
            } else {
                //quitamos el plan como activo y estado 0 
                Short estadoplan = 0;
                cepCecPlan = new CepCecPlan();
                cepCecPlan = gestorPlanService.recuperarIdPlan(idPlan);
                cepCecPlan.setPlanActual(false);
                cepCecPlan.setEstadoPlan(estadoplan);
                gestorPlanService.actualizarPlan(cepCecPlan);
                //asignamos al penultimo plan como activo
                cepCecPlan = new CepCecPlan();
                cepCecPlan = lstPlan.get(1);
                cepCecPlan.setPlanActual(true);
                gestorPlanService.actualizarPlan(cepCecPlan);
                usuarioController.getFramework().doMensajeF("Exito!", "Se borro plan", 1);
                //cargar planes y su paginacion
                pageNumberCursoDet = 1;
                this.doTamanoPaginacionPlan();
                this.doBuscarPlanes();
            }

        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "Ocurrio un problema al borrar el ultimo plan activo creado", 4);
        }

    }

    public void doOcultarCurso() {
        try {
            estado_curso_det = 0;
            selectedCursos.setEstadoCursoDet(estado_curso_det);
            gestorCursoDetService.actualizarCurso(selectedCursos);
            this.doTamanoPaginacionCursoDet();
            this.doBuscarCursoDet();
            System.out.println("Se oculto ");
          usuarioController.getFramework().doMensajeF("Exito!","Se borro registro",1);
        } catch (Exception e) {
          usuarioController.getFramework().doMensajeF("Error!","No se borro registro",4);
        }
 
       
    }

    public void doCrearSesion() {
        Short estado_sesion = 1;
        //usuarioController.baseController = new fwGeneral2();
        try {
            cepCecSesion = new CepCecSesion();
            cepCecPlan = gestorPlanService.recuperarIdPlan(idPlan);
            cepCecSesion.setCepCecPlan(cepCecPlan);
            cepCecSesion.setNomSesion(nombre_sesion);
            cepCecSesion.setEstadoSesion(estado_sesion);
            gestorSesionPlanService.crearNuevaSesion(cepCecSesion);
            System.out.println("CREO SESION");
            usuarioController.getFramework().doMensajeF("Exito", "Se creo la sesion", 1);
            lstSesion = new ArrayList<>();
            lstSesion = doBuscarSesion();
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error", "No se pudo crear ", 4);

        }

    }

    public void doCapturarSesionBorrar(CepCecSesion cepCecSesion2) {
        System.out.println("entro a acptasdsdsd");
        cepCecSesion = new CepCecSesion();
        cepCecSesion = cepCecSesion2;
        System.out.println("*****************");
    }

    public void doOcultarSesion() {
        Short estado_sesion = 0;
        //usuarioController.baseController = new fwGeneral2();
        try {
            cepCecSesion.setEstadoSesion(estado_sesion);
            gestorSesionPlanService.actualizarSesion(cepCecSesion);
            usuarioController.getFramework().doMensajeF("Exito", "Se borro registro", 1);
            lstSesion = new ArrayList<>();
            lstSesion = doBuscarSesion();
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error", "Se no pudo borrar", 4);

        }

    }

    /*  public void doModificarSesion(){
        idCurso = SelectedFilaCurSinPlan.getIdCursoCab();
        cepCecSesion = new CepCecSesion();
        cepCecPlan = gestorPlanService.recuperarIdPlan(idPlan);
        
    }*/
    public void doCrearTema() {
        try {
            Short estado = 1;
            //usuarioController.baseController = new fwGeneral2();
            cepCecTema = new CepCecTema();
            System.out.println("SESION EN CREAR TEMA ES " + id_sesion);
            cepCecSesion = gestorSesionPlanService.recuperarIdSesion(id_sesion);
            cepCecTema.setCepCecSesion(cepCecSesion);
            cepCecTema.setNomTema(nom_tema);
            cepCecTema.setEstadoTema(estado);
            gestorTemaPlanService.crearNuevaTema(cepCecTema);
            System.out.println("CREO TEMA");
            lstTema = new ArrayList<>();
            lstTema = this.doBuscarTema();
            usuarioController.getFramework().doMensajeF("Exito", "Se creo el tema", 1);
        } catch (Exception e) {
            System.out.println("Error crear tema");
            usuarioController.getFramework().doMensajeF("fallo", "No se creo el tema", 4);
        }

    }

    public void doCapturarTemaBorrar(CepCecTema cepCecTema2) {
        System.out.println("entro a acptasdsdsd");
        cepCecTema = new CepCecTema();
        cepCecTema = cepCecTema2;
        System.out.println("*****************");
    }

    public void doOcultarTema() {
        try {
            Short estado_tema = 0;
            //usuarioController.baseController = new fwGeneral2();
            cepCecTema.setEstadoTema(estado_tema);
            gestorTemaPlanService.actualizarTema(cepCecTema);
            lstTema = new ArrayList<>();
            lstTema = this.doBuscarTema();
            usuarioController.getFramework().doMensajeF("Exito", "Se borro registro", 1);

        } catch (Exception e) {
            System.out.println("error borrar tema");
            usuarioController.getFramework().doMensajeF("Exito", "No se borro registro", 4);

        }

    }

    public void doCrearCursoSubDetalle() {
        doBuscarEscala();
        id_curso_det = selectedCursos.getIdCursoDet();
        cepCecPlan = gestorPlanService.buscarPlanActual(id_curso_det);

        //doCapturarCurso();// este metodo nos dice que id plan tenemos acutal
        redireccionAhCrearDetallesCurso();
    }

    public void doGuardarCursoSubDet() {
        try {
            
             //usuarioController.baseController = new fwGeneral2();
        //id_curso_det = SelectedConPlan.getCepCecCursoDet().getIdCursoDet();
        id_curso_det = selectedCursos.getIdCursoDet();
        estado_detcur = 1;
        System.out.println("id curso: " + id_curso_det);
        System.out.println("tipo desarrollo: " + idTipoDesarollo);
        System.out.println("id nivel " + idnivel);
        System.out.println("id_escala " + idEscalita);
        System.out.println("id_plan:" + idPlan);
        //System.out.println("horas lectivas: " + horas_lectivas);
        System.out.println("num cuotas :" + num_cuotas);
        System.out.println("Max alu: " + max_alum);
        System.out.println("min alu: " + min_alu);

      //  if (gestorCursoSubDetService.validarRepeticiones(idTipoDesarollo, idEscalita, id_curso_det,num_cuotas,max_alum,min_alu) == 1) {

     //       usuarioController.getFramework().doMensajeF("Fallo!", "ya existe!", 4);

     //   } else {
            cepNivel = new CepNivel();
            cepTipoDesarrollo = new CepTipoDesarrollo();
            cepCursoDet = new CepCecCursoDet();
            cepNivel = new CepNivel();
            cepEscalaTipomod = new CepEscalaTipomod();
            // primero recupera la fila en una entidad de la tabla del foreing key
            // recupera fila del id de curso y lo guarda en objeto
            cepCursoDet = gestorCursoDetService.recuperarIdCurDet(id_curso_det);
            // cursocab = gestorCepCecCursoCabService.recuperarIdCursoCab(idCurso);
            // recupera fila del id de tipo de desarrollo y lo guarda en objeto
            cepTipoDesarrollo = gestorTipoDesarrolloService.recuperarIdTipoDes(idTipoDesarollo);
            // recupera fila del id de tipo de nivel y lo guarda en objeto
            cepNivel = gestorCepNivelService.recuperarIdNivel(idnivel);
            // recupera fila del id de escala y lo guarda en objeto
            cepEscalaTipomod = gestorEscalaModalidadService.recuperarIdEscala(idEscalita);
            // recupera fila del id de plan y lo guarda en objeto
            // cepCecPlan = gestorPlanService.recuperarIdPlan(idPlan);
            //instancio variable de la entidad a ingresar los foreig keys
            cepCursoSubDet = new CepCecCursoSubdet();
            //setear osea ingresar todos las variables en la fila de la nueva entidad
            cepCursoSubDet.setCepTipoDesarrollo(cepTipoDesarrollo);
            // cepCursoSubDet.setCepCecCursoCab(cursocab);
            //cepCursoSubDet.setCepCecPlan(cepCecPlan);
            // cepCursoSubDet.setHorasLectivas(horas_lectivas);
            cepCursoSubDet.setCepCecCursoDet(cepCursoDet);
            cepCursoSubDet.setCepEscalaTipomod(cepEscalaTipomod);
            cepCursoSubDet.setNumClases(num_clases);
            cepCursoSubDet.setMinAlum(min_alu);
            cepCursoSubDet.setMaxAlum(max_alum);

            if (num_pagos == 1) { // Solo 1
                num_cuotas = 1;
                formapago = 0;
            }

            cepCursoSubDet.setNumCuotas(num_cuotas);
            cepCursoSubDet.setFormaPago(formapago);
            cepCursoSubDet.setEstadoDetcur(estado_detcur);
            gestorCursoSubDetService.crearNuevoSubDetCurso(cepCursoSubDet);
          
            System.out.println("GUARDO DETALLE CURSO");
 //            redireccionAhCursosDetallados();
              redireccionAhCursosDetalladosDespuesDeCrear();
              usuarioController.getFramework().doMensajeR("Exitoso", "Se guardo detalle del curso en la BD", 1);
            System.out.println("SE REEDIRECICIONO A LA PAGINA DET CURSO");
      //  }

            
        } catch (Exception e) {
                        usuarioController.getFramework().doMensajeF("Fallo!", "Hubo un problema al tratar de guardar curso detallado!", 4);

        }
       
    }

    // Guarda en la tabla cep_escala_tipomod
    public void doAsignarModEscala() {
        try {
            
            System.out.println("ENTRO A ASIGNAR");
            estadoEscala = 1;
            int cond_repeticion; // para verificar si se repete  1:se repite 0:no se repite
            cep_num = 3; // 2 :ceiduns  3:cecomp  4:cepuns
            System.out.println("Modalidad: " + id_Modalidad);
            System.out.println("NomEscala: " + nomEscala);
            System.out.println("Numero de escala: " + numEscala);

            if (numEscala==1) {
                if (nomEscala.compareTo("Semanas")==0) {
                nomEscala = "Semana";
                }else{
                    if (nomEscala.compareTo("Meses")==0) {
                        nomEscala = "Mes";
                    }else{
                        if (nomEscala.compareTo("Dias")==0) {
                            nomEscala = "Dia";
                        }
                    }
                }
            }
            
            
            cond_repeticion = gestorEscalaModalidadService.buscarRepeticiones(id_Modalidad, nomEscala, numEscala);
            if (cond_repeticion == 0) {
                cepTipoModalidad = new CepTipoModalidad();
                cepTipoModalidad = gestorTipoModalidad.recuperarIdTipoMod(id_Modalidad);
                cepEscalaTipomod = new CepEscalaTipomod();
                cepEscalaTipomod.setCepTipoModalidad(cepTipoModalidad);
                cepEscalaTipomod.setNombreEscala(nomEscala);
                cepEscalaTipomod.setNumEscala(numEscala);
                cepEscalaTipomod.setEstadoEscala(estadoEscala);
                cepEscalaTipomod.setNumCepEstpm(cep_num);
                gestorEscalaModalidadService.crearNuevaDuracionCurso(cepEscalaTipomod);
                usuarioController.getFramework().doMensajeF("Exitoso", "Se guardo la Duracion en la BD", 1);
                //doMensajeF("Exitoso", "Se guardo la Duracion en la BD", 1);
                System.out.println("listo");
                doBuscarEscala();
            } else {
                usuarioController.getFramework().doMensajeF("Fallido", "Ya existe esta duracion", 4);
            }

        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error", "No se pudo crear la duracion", 4);

        }

    }

    public void doModificarSesion(CepCecSesion sesion) {
        //System.out.println("id plan es : " + idPlan);
        //System.out.println("SI SE PUEDE");
        //System.out.println("id sesion es :" + idsesion);
        //System.out.println("nuevo nombre es : " + );
        try {
            cepCecSesion = new CepCecSesion();
            cepCecSesion = sesion;
            //cepCecSesion = gestorSesionPlanService.recuperarIdSesion(idsesion);
            //cepCecSesion.setNomSesion(nombre_sesion);
            gestorSesionPlanService.actualizarSesion(cepCecSesion);
            System.out.println("Modifico SESION");
            lstSesion = new ArrayList<>();
            lstSesion = doBuscarSesion();
        } catch (Exception e) {
            System.out.println("Error modificar sesion");
        }

    }

    public void doModificarTema(CepCecTema tema) {
        try {//System.out.println("id sesion es :" + idtema);
            System.out.println("nuevo nombre es : " + nom_tema);
            cepCecTema = new CepCecTema();
            cepCecTema = tema;
            //cepCecTema = gestorTemaPlanService.recuperarIdSesion(idtema);
            //cepCecTema.setNomTema(nom_tema);
            gestorTemaPlanService.actualizarTema(cepCecTema);
            System.out.println("Modifico tema");
            lstTema = new ArrayList<>();
            lstTema = this.doBuscarTema();

        } catch (Exception e) {
            System.out.println("Error crear tema");
        }

    }

    //validar si el curso  tiene plan
    public int doValidarPlanIdCursoDet(int id) {
        conforme = 0;
        validarCurso = 0;
        id_curso_det = id;
        if (gestorPlanService.validarPlanPorIdCursoDet(id_curso_det)) {
            validarCurso = 1;
            conforme = 1;
        }
        return conforme;
    }

    public void doModificarEscala(CepEscalaTipomod cepEscalaTipomod2) {
        int cond_repeticion;
        cepEscalaTipomod = new CepEscalaTipomod();
        cepEscalaTipomod = cepEscalaTipomod2;

        id_Modalidad = cepEscalaTipomod.getCepTipoModalidad().getIdModalidad();
        nomEscala = cepEscalaTipomod.getNombreEscala();
        numEscala = cepEscalaTipomod.getNumEscala();
        cond_repeticion = gestorEscalaModalidadService.buscarRepeticiones(id_Modalidad, nomEscala, numEscala);

        if (cond_repeticion == 0) {
            this.cepTipoModalidad = new CepTipoModalidad();
            cepTipoModalidad = gestorTipoModalidad.recuperarIdTipoMod(id_Modalidad);
            if (numEscala>1) {
                if (nomEscala.compareTo("Semanas")==0) {
                nomEscala = "Semana";
                }else{
                    if (nomEscala.compareTo("Meses")==0) {
                        nomEscala = "Mes";
                    }else{
                        if (nomEscala.compareTo("Dias")==0) {
                            nomEscala = "Dia";
                        }
                    }
                }
            }
            cepEscalaTipomod.setCepTipoModalidad(cepTipoModalidad);
            cepEscalaTipomod.setNombreEscala(nomEscala);
            cepEscalaTipomod.setNumEscala(numEscala);
            gestorEscalaModalidadService.actualizarEscala(cepEscalaTipomod);
            usuarioController.getFramework().doMensajeF("Exito!", "Campo Editado", 1);
        } else {
            usuarioController.getFramework().doMensajeF("Fallido", "Ya existe esta duracion", 4);
        }
        doBuscarEscala();
    }

    //validar si el curso  tiene plan
    public int doValidarEscalaEnpProceso(int id) {

        conforme = 0;
        idEscalita = id;

        if (gestorCursoSubDetService.validarIdEscala(idEscalita)) {
            conforme = 1;
        }
        return conforme;
    }

    public void doCapturarCodBanco() {
        System.out.println("entro aqui");
        System.out.println("el codigo es " + id_tipoAlumno);

    }

    public void doCapturaPrecio() {
        if (id_tipo_inver == 2) {

            if (precio != 0) {
                if (optionPago == '1') {
                    System.out.println("el precio_pgu es " + precio);
                    System.out.println("el numero de cuotas " + num_cuotas);
                    precio_total = precio * num_cuotas;
                    System.out.println("precio_total " + precio_total);
                } else {
                    precio_total = precio;
                }

            } else {
                precio = new Float(0.00);
                precio_total = new Float(0.00);
                System.out.println("el precio_pgu es " + precio_pgu);
                System.out.println("precio_total " + precio_total);

            }

        } else {
            if (precio != 0) {
                System.out.println("el precio_pgu es " + precio);
                System.out.println("el numero de cuotas " + num_cuotas);
                precio_total = precio * num_cuotas;
                System.out.println("precio_total " + precio_total);

            } else {
                precio = new Float(0.00);
                precio_total = new Float(0.00);
                System.out.println("el precio_pgu es " + precio_pgu);
                System.out.println("precio_total " + precio_total);

            }

        }

    }

    //validar si el curso  tiene inversion
    public int doValidarSiExisteInversion(int id) {

        conformeInver = 0;
        usuarioController.setId_curso_subdet(id);
        // usuarioController.id_curso_subdet = id;

        if (gestorInversionService.validarSiExisteInversionporCurso(usuarioController.getId_curso_subdet())) {
            conformeInver = 1;
        }
        return conformeInver;
    }

    public void doCapturarDuracion(CepEscalaTipomod cepEscalaTipomod2) {
        cepEscalaTipomod = new CepEscalaTipomod();
        cepEscalaTipomod = cepEscalaTipomod2;

    }

    public void doOcultarDuracion() {
        estadoEscala = 0;
        cepEscalaTipomod.setEstadoEscala(estadoEscala);
        gestorEscalaModalidadService.actualizarEscala(cepEscalaTipomod);
        System.out.println("Se oculto ");
        doBuscarEscala(); // actualiza la lista de la tabla

    }

    public void doVerTipoInversion() {
        ver_tipoinver = 0;
        System.out.println("id_tipo_inver " + id_tipo_inver);
    }

    public void doIrCrearInversion() {
        usuarioController.setId_curso_subdet(SelectedListCurSubDet.getIdCursoSubdet());
        //usuarioController.id_curso_subdet = SelectedListCurSubDet.getIdCursoSubdet();
        System.out.println("Obtuvo el id " + usuarioController.getId_curso_subdet());
        num_cuotas = SelectedListCurSubDet.getNumCuotas();
        System.out.println("num cuotas " + num_cuotas);
        nom_curso = SelectedListCurSubDet.getCepCecCursoDet().getCepCecCursoCab().getNomCurso();
        if (SelectedListCurSubDet.getCepCecCursoDet().getModEnsenanza()==2) {
         nom_curso = "Taller " + nom_curso;   
        }
       
        System.out.println("EL CURSO ES  : " + nom_curso);
        nomDesarollo = SelectedListCurSubDet.getCepTipoDesarrollo().getNomTipoDes();
        System.out.println("Desarrollo : " + nomDesarollo);
        nomModalidad = SelectedListCurSubDet.getCepEscalaTipomod().getCepTipoModalidad().getNomModalidad();
        System.out.println("Modalidad " + nomModalidad);
        if (SelectedListCurSubDet.getCepCecCursoDet().getCepNivel().getIdNivel()==0) {
            nom_nivel = "";
        }else{
           nom_nivel = SelectedListCurSubDet.getCepCecCursoDet().getCepNivel().getNomAbrevNivel();
        }
        System.out.println("Nivel = " + nom_nivel);
        tipoModal = 1; // borrar inversion
        rcdConcepto = new RcdConcepto();
        id_tipo_inver = 1;
        formapago = SelectedListCurSubDet.getFormaPago();
        System.out.println("forma de pago es "+formapago);
        nombreCursoCompleto = nom_curso +" "+  nom_nivel + " "+  nomDesarollo +" / " +nomModalidad; 
        dobuscarInversion();
        redireccionAhCreateInversion();
    }

    public void crearNombreInversion() {
        // todo estos datos se caputran en doIrCrearInversion()
        switch (id_tipo_inver) {
            case 1:

                nombre_inversion = nom_curso + " " + nom_nivel + " - " + cepCecTipAlumno.getNomAbrev() + " / " + nomDesarollo + " - " + nomModalidad;
                break;
            case 2:
                if (optionPago == '2') {
                    nombre_inversion = nom_curso + " " + nom_nivel + " 1/2 Beca" + " - " + cepCecTipAlumno.getNomAbrev() + " / " + nomDesarollo + " - " + nomModalidad + " - Pago Completo";
                } else {
                    nombre_inversion = nom_curso + " " + nom_nivel + " 1/2 Beca" + " - " + cepCecTipAlumno.getNomAbrev() + " / " + nomDesarollo + " - " + nomModalidad;
                }

                break;
            case 7:
                nombre_inversion = nom_curso + " " + nom_nivel + " Beca" + " - " + nom_tipo_alumno + " / " + nomDesarollo + " - " + nomModalidad;

                break;
            case 8:
                nombre_inversion = nom_curso + " " + nom_nivel + " Descuento Planilla" + " - " + nom_tipo_alumno + " / " + nomDesarollo + " - " + nomModalidad;

                break;

            default:
                nombre_inversion = rcdConcepto.getNombre() + " - " + cepCecTipAlumno.getNomAbrev();
        }
        System.out.println("nombre_inversion creada = " + nombre_inversion);

    }

    public void doIrCrearInversionDesdeGrupo(CepCecCursoSubdet curso) {
        try {
               SelectedListCurSubDet = new CepCecCursoSubdet();
        SelectedListCurSubDet = curso;
        usuarioController.setId_curso_subdet(SelectedListCurSubDet.getIdCursoSubdet());
        //usuarioController.id_curso_subdet = SelectedListCurSubDet.getIdCursoSubdet();
        System.out.println("Obtuvo el id " + usuarioController.getId_curso_subdet());
        num_cuotas = SelectedListCurSubDet.getNumCuotas();
        System.out.println("num cuotas " + num_cuotas);
        nom_curso = SelectedListCurSubDet.getCepCecCursoDet().getCepCecCursoCab().getNomCurso();
        if (SelectedListCurSubDet.getCepCecCursoDet().getModEnsenanza()==2) {
         nom_curso = "Taller " + nom_curso;   
        }
        System.out.println("EL CURSO ES  : " + nom_curso);
        nomDesarollo = SelectedListCurSubDet.getCepTipoDesarrollo().getNomTipoDes();
        System.out.println("Desarrollo : " + nomDesarollo);
        nomModalidad = SelectedListCurSubDet.getCepEscalaTipomod().getCepTipoModalidad().getNomModalidad();
        System.out.println("Modalidad " + nomModalidad);
        nom_nivel = SelectedListCurSubDet.getCepCecCursoDet().getCepNivel().getNomAbrevNivel();
        System.out.println("Nivel = " + nom_nivel);
        tipoModal = 1; // borrar inversion
        rcdConcepto = new RcdConcepto();
        id_tipo_inver = 1;
        formapago = SelectedListCurSubDet.getFormaPago();
        dobuscarInversion();
        redireccionAhCreateInversion();
        } catch (Exception e) {
        }
        
     
    }

    public void doCrearInversion(int condicional) {
        
        try {
             Boolean unico_pagototal = false;
        Integer idcurso = usuarioController.getId_curso_subdet();
        Integer tipoalu = id_tipoAlumno;
        Integer tipoinver = id_tipo_inver;
        if (gestorInversionService.inversionExiste(idcurso, tipoalu, tipoinver)) {
            //usuarioController.baseController = new fwGeneral2();
            usuarioController.getFramework().doMensajeF("Error", "Ya esta asignado", 4);
        } else {
            // System.out.println("El tipo de alumno " + id_tipoAlumno);
           // if (condicional != 1 ) { // es para otros tipos de pagos como certificado,examen 
           //     precio_total = precio;
            //    estado_concepto_total = false;
          //  }

          //  if (tipoinver == 7) { //osea si es inversion tipo beca
         //       estado_concepto_total = true;
          //  }

            
            Short estado_contotal = null;
           
            if (id_tipo_inver == 2) {
                 if (optionPago == '2') {
                    estado_concepto_total = true;
                    estado_contotal = 1;
                    unico_pagototal = true;
                  }else{
                     if (optionPago=='1') {
                         unico_pagototal = false;
                        if (estado_concepto_total) {
                            estado_contotal = 1;
                        } else {
                            estado_contotal = 0;
                        }
                     }
 
                 }
            }else{
                  if (id_tipo_inver==1) {
                    if (SelectedListCurSubDet.getNumCuotas()>1) {
                        //estado_concepto_total = false;
                        unico_pagototal=false;
                     }else{
                         unico_pagototal = true;
                    }
                    
                        if (estado_concepto_total) {
                            estado_contotal = 1;
                        } else {
                            estado_contotal = 0;
                        }
                }
            }
          
            dobuscarInversion(); // cargas las lista en la tabla
      
            cepCecInversionCurso = new CepCecInversionCurso();
            estado_inver = 1;
            //(int id,Float precio,Short estadoConcepto,Integer tipoInver,Integer rcd) 
            // buscarInversioNula(Integer idCurSubDet,Float precio,Short estadoConcepto,Integer tipoInver,Integer rcd) ;
            // si es null es porque no existio antes este tipo de inversion
            if (gestorInversionService.buscarInversioNula(usuarioController.getId_curso_subdet(), precio, estado_contotal, id_tipo_inver, id_rcdConcepto) == null) {

                System.out.println("id_tipo_inver " + id_tipo_inver);
                System.out.println("id_ de pgu" + id_tipoPagos);
                System.out.println("id_id_tipo_alumno " + id_tipoAlumno);
                System.out.println("concepto = " + concepto_pgu);
                System.out.println("precio =" + precio_pgu);
                System.out.println("precio tota = " + precio_total);
                System.out.println("descripcion = " + descrp_inver);
                System.out.println("Codigo banco " + codigo_inversion);
                System.out.println("estado_concepto_total" + estado_concepto_total);

                cepCecTipAlumno = gestorTipoAlumnoService.recuperarTipoAlumno(id_tipoAlumno);
                cepCecTipoInversion = gestorTipoInversionService.recuperartipoInversion(id_tipo_inver);
                rcdConcepto = gestorRcdConceptoService.recuperarRcdConcepto(id_rcdConcepto);
                cepCursoSubDet = gestorCursoSubDetService.recuperarIdCurSubDet(usuarioController.getId_curso_subdet());
                crearNombreInversion();
                cepCecInversionCurso.setCepCecCursoSubdet(cepCursoSubDet);
                cepCecInversionCurso.setCepCecTipAlumno(cepCecTipAlumno);
                cepCecInversionCurso.setCepCecTipoInversion(cepCecTipoInversion);
                cepCecInversionCurso.setRcdConcepto(rcdConcepto);
                cepCecInversionCurso.setDescripcionInv(descrp_inver);
                cepCecInversionCurso.setPrecioPension(precio);
                cepCecInversionCurso.setPrecioTotal(precio_total);
                cepCecInversionCurso.setNombreConcepto(nombre_inversion);
                cepCecInversionCurso.setEstadoInver(estado_inver);
                cepCecInversionCurso.setConceptoTotal(estado_contotal);
                cepCecInversionCurso.setUnicoPagototal(unico_pagototal);
                gestorInversionService.crearInversion(cepCecInversionCurso);
                System.out.println("se creo con exito la inversion");
                //usuarioController.baseController = new fwGeneral2();

                usuarioController.getFramework().doMensajeF("Exito", "Se Guardo Inversion", 1);
                //doMsg("Exito", "Se Guardo Inversion", 1);
                 precio = (float) 0;
                precio_total =(float) 0;
                dobuscarInversion();
            } else {
                //sino ya exisitio
                cepCecInversionCurso = gestorInversionService.buscarInversioNula(usuarioController.getId_curso_subdet(), precio, estado_contotal, id_tipo_inver, id_rcdConcepto);
                cepCecInversionCurso.setDescripcionInv(descrp_inver);
                cepCecInversionCurso.setEstadoInver(estado_inver);
                cepCecInversionCurso.setUnicoPagototal(unico_pagototal);
                gestorInversionService.actualizarInversion(cepCecInversionCurso);
                // usuarioController.baseController = new fwGeneral2();
                System.out.println("se creo con exito la inversion");
                usuarioController.getFramework().doMensajeF("Exito", "Se Guardo Inversion", 1);
                //doMsg("Exito", "Se Guardo Inversion", 1);
                
                //limpiar 
                 precio = (float) 0;
                precio_total =(float) 0;
                
                dobuscarInversion();
            }
        }
        } catch (Exception e) {
           usuarioController.getFramework().doMensajeF("Error", "no se  Guardo Inversion", 4);

        }
       
    }

    // prueba
    /*public void doLeerEntidad(CepCecInversionCurso cepCecInversionCurso2){
        cepCecInversionCurso = new CepCecInversionCurso();
        cepCecInversionCurso =   cepCecInversionCurso2;
        System.out.println("el id es "+cepCecInversionCurso.getIdInversion());
         System.out.println("el des es "+cepCecInversionCurso.getDescripcionInv());
        gestorInversionService.actualizarInversion(cepCecInversionCurso);    
       System.out.println("Modifico inversion");  
    }*/
    public void doModificarInversion(CepCecInversionCurso cepCecInversionCurso2) {
        cepCecInversionCurso = new CepCecInversionCurso();
        cepCecInversionCurso = cepCecInversionCurso2;
        System.out.println("el id es " + cepCecInversionCurso.getIdInversion());
        // System.out.println("el codigo es " + cepCecInversionCurso.getCodigoBanco());
        System.out.println("el num es " + cepCecInversionCurso.getDescripcionInv());
        id_tipo_inver = cepCecInversionCurso.getCepCecTipoInversion().getIdTipoinversion();
        System.out.println("el tipo de inver es :" + id_tipo_inver);

        precio = cepCecInversionCurso.getPrecioPension();
        //id_tipoAlumno = cepCecInversionCurso.getCepCecTipAlumno().getIdTipAlumno();
        // this.cepCecTipAlumno = new CepCecTipAlumno();
        //  cepCecTipAlumno = gestorTipoAlumnoService.recuperarTipoAlumno(id_tipoAlumno);
        // System.out.println("id_tipo_alumno : " + id_tipoAlumno);

        // solo lo llamo para que obtenga el nombre del concepto cuando este es de tipo_inver = 4 osea otros conceptos extras
        //this.rcdConcepto = new RcdConcepto();
        // rcdConcepto.setNombre(cepCecInversionCurso.getRcdConcepto().getNombre());
        // System.out.println("nombre concepto es  " + rcdConcepto.getNombre());
        doCapturaPrecio();// hace las operaciones de precios

        if (cepCecInversionCurso.getCepCecTipoInversion().getIdTipoinversion() == 3) { //si es de tipo pago total
            precio_total = precio;
        }

        // crearNombreInversion();// cambia el nombre actual segun el id_tipo_inver
        cepCecInversionCurso.setPrecioPension(precio);
        cepCecInversionCurso.setPrecioTotal(precio_total);
        gestorInversionService.actualizarInversion(cepCecInversionCurso);
        System.out.println("Modifico inversion");
    }

    public void doCapturarInversion(CepCecInversionCurso cepCecInversionCurso2) {
        cepCecInversionCurso = new CepCecInversionCurso();
        cepCecInversionCurso = cepCecInversionCurso2;

    }

    public void doOcultarInversion() {
        System.out.println("Entro a doOcultar Controller");
        estado_inver = 0;
        System.out.println("instancio");
        cepCecInversionCurso.setEstadoInver(estado_inver);
        gestorInversionService.actualizarInversion(cepCecInversionCurso);
        System.out.println("Se oculto ");
        dobuscarInversion();

    }

    public void Leer(CepCecInversionCurso cepCecInversionCurso2) {
        cepCecInversionCurso = cepCecInversionCurso2;
        System.out.println("el id es " + cepCecInversionCurso.getIdInversion());
        //  System.out.println("el num es " + cepCecInversionCurso.getCodigoBanco());
    }

    public void LeerSape() {

        System.out.println("el id es " + id_tipoAlumno);
        //  System.out.println("el num es " + cepCecInversionCurso.getCodigoBanco());
    }

    public void onRowEdit(RowEditEvent event) {

        /**
         * Funcion que permite mostrar un mensaje a la derecha de la pagina
         *
         * @param titulo: Es el titulo que tendra el mensaje
         * @param msgbox: Es el mensaje que se desea mostrar
         * @param tipo: 1: Informativo 2: Peligro 3: Fatal 4: Error
         */
        //          titulo  msgbox   tipo
        usuarioController.getFramework().doMensajeF("Exito!", "Campo Editado", 1);
        //doMensajeF("Exito!", "Campo Editado", 1);
        //FacesMessage msg = new FacesMessage("Edited", ((CepCecSesion) event.getObject()).getNomSesion());
        //  FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {

        /**
         * Funcion que permite mostrar un mensaje a la derecha de la pagina
         *
         * @param titulo: Es el titulo que tendra el mensaje
         * @param msgbox: Es el mensaje que se desea mostrar
         * @param tipo: 1: Informativo 2: Peligro 3: Fatal 4: Error
         */
        //          titulo  msgbox   tipo
        usuarioController.getFramework().doMensajeF("Exito!", "Campo Editado", 1);
        //doMensajeF("Cancelado!", " No sé edito", 1);
        //FacesMessage msg = new FacesMessage("Edit Cancelled", ((CepCecSesion) event.getObject()).getNomSesion());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    ////////////////////////*MEDIABECA***********************-------------
    public void doCapturarTipoAlumno(CepCecInversionCurso item) {
        //caputra el tipo de alumno para la vista
        id_tipoAlumno = item.getCepCecTipAlumno().getIdTipAlumno();
        System.out.println("Tipo Alumno es " + id_tipoAlumno);
        nom_tipo_alumno = item.getCepCecTipAlumno().getNomTipAlumno();
        usuarioController.setDrtPersonanatural(null); //inicialiazcion
        usuarioController.setSexo(0); //inicialiazcion
        //fecha minima
        MetodosExtras obj = new MetodosExtras();
        fechaMin = obj.doConvertirFechaAhFormatoddMMyyyy(new Date());
        id_inversion = item.getIdInversion();
        System.out.println("inversion es " + id_inversion + " : " + item.getNombreConcepto());
        System.out.println("El page number es " + this.pageNumberMediaBeca);
        this.doTamanoPaginacionMediaBecca();
        this.doListarMediaBecas();

    }

    public void doCapturarPaginaMediaBeca(Integer pagina) {
        //caputra el numero de la pagina
        this.pageNumberMediaBeca = pagina;
        //y gracias al ajax update actualizare 
        this.doTamanoPaginacionMediaBecca();
        this.doListarMediaBecas();
    }

    public void doListarMediaBecas() {
        // carga la lista
        System.out.println("El page number es " + this.pageNumberMediaBeca);
        lsCecDescExoneradoses = new ArrayList<>();
        lsCecDescExoneradoses = descuentoExoService.buscarMediasBecas(id_inversion, this.pageNumberMediaBeca);

    }

    // This function send some data to db (Esta funcion envia datos a la bd)
    public void doTamanoPaginacionMediaBecca() {
        // Calcula tras metodos numericos cauntas pagSize cuantos botones de paginacion va tener
        int x = descuentoExoService.tamanoPaginacionMediaBeca(id_inversion);
        System.out.println("x es " + x);
        this.paginacionMediaBeca = new ArrayList<>();
        //si la paginacion es 0 entonces solo se agregara un unico boton
        if (x == 0) {
            paginacionMediaBeca.add(1); // es 1 para que no de error en el calculo al llamar la lista de la tabla
        } else {
            //llena los numeros a las lista integer 
            for (int i = 1; i <= x; i++) {
                paginacionMediaBeca.add(i);
            }
        }
        System.out.println("tamano de paginacion es " + paginacionMediaBeca.size());
        //retorna esta lista para que en la vista con un repetidor listar los botones de paginacion
        //return paginacionCursoDet;
    }

    public void doCrearMediaBeca() {
        String dni;
        String num_documento;
        try {
            DrtPersonanatural drtPersonanatural = new DrtPersonanatural();
            switch (id_tipoAlumno) {
                case 1:
                    drtPersonanatural = usuarioController.getGestorUsuarioEstGeneralService().recuperarIdEntidadDrtPersona(usuarioController.getId_dir());
                    dni = drtPersonanatural.getNumeroPndid();
                    num_documento = usuarioController.getCodigoEst();
                    break;
                case 2:
                    dni = usuarioController.getDniEstGene();
                    num_documento = usuarioController.getDniEstGene();
                    break;
                case 3:
                    dni = usuarioController.getDniEstGene();
                    num_documento = usuarioController.getIdCardEstTrab();
                    break;
                default:
                    throw new AssertionError();
            }

            CepCecDescExonerados entidad = new CepCecDescExonerados();
            if (id_tipoAlumno == 1) {
                entidad.setCodAlumno(usuarioController.getCodigoEst());
                entidad.setNumDocumento(dni);
            } else {
                entidad.setNumDocumento(num_documento);
            }
            //llama a los EJB del UsuarioControllerParaRecuperarEntidad,Ingresardo como parametro el id_dir que se guardo al momento debuscar la persona , eso tambien se hizo en usuarioController
            // especificamente en las clases doBuscarAlumnoUns() y doBuscarPersona() 
            if (usuarioController.getId_dir() != 0) {
                //drtPersonanatural = new DrtPersonanatural();
                drtPersonanatural = usuarioController.getGestorUsuarioEstGeneralService().recuperarIdEntidadDrtPersona(usuarioController.getId_dir());
                entidad.setIdDir(drtPersonanatural.getIdDir());
                entidad.setNomCompletosExo(drtPersonanatural.getNombreCompleto());
                //entidad.setDrtPersonanatural(drtPersonanatural);
            }
            cepCecInversionCurso = new CepCecInversionCurso();
            cepCecInversionCurso = gestorInversionService.recuperarEntidadInversion(id_inversion);
            entidad.setCepCecInversionCurso(cepCecInversionCurso);
            entidad.setEstadoDes(true);
            entidad.setFechaRegMb(new Date());
            entidad.setFechaLimite(fechaLimite);
            descuentoExoService.crearEntidad(entidad);
            //carga la paginacion y lista
            this.doTamanoPaginacionMediaBecca();
            this.doListarMediaBecas();

            usuarioController.getFramework().doMensajeF("Exito!", "Se Agrego semiBecado Correctamente", 1);
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "Error de guardado", 4);
        }
    }

    public void doCapturarMediBEca(CepCecDescExonerados entidadMedia) {
        cepCecDescExonerados = entidadMedia;
        System.out.println("capturaste media beca: ");
        //System.out.println(cepCecDescExonerados);
        id_desc_exonerados = entidadMedia.getIdAluDesExo();

    }

    public void doEliminarMediBEca() {
        try {
            System.out.println("entro a eliminar media beca");
            System.out.println("id_desc_exonerados = " + id_desc_exonerados);
            CepCecDescExonerados entidadMedia = new CepCecDescExonerados();
            entidadMedia = descuentoExoService.recuperarIdEntidad(id_desc_exonerados);
            System.out.println("" + entidadMedia.getCodAlumno());
            System.out.println("" + entidadMedia.getCepCecInversionCurso().getNombreConcepto());
            System.out.println("" + entidadMedia.getIdAluDesExo());
            /*  try {
                cepCecDescExonerados = new CepCecDescExonerados();
                cepCecDescExonerados = descuentoExoService.actualizarEntidad(entidadMedia);
                System.out.println("entidad actuali : "+cepCecDescExonerados);
            } catch (NullPointerException e) {
                System.out.println("error nulo");
            }*/

            Boolean estado = false;
            //     cepCecDescExonerados.setEstadoDes(estado);
            entidadMedia.setEstadoDes(estado);
            entidadMedia.setFechaLimite(new Date());
            entidadMedia.setDescripcionDes("Cancelado");
            System.out.println("casi listo para editar");
            descuentoExoService.actualizarEntidad(entidadMedia);
            System.out.println(":::eliminó::::");
            // carga la lista
            //lsCecDescExoneradoses = new ArrayList<>();
            //lsCecDescExoneradoses = descuentoExoService.buscarBecas(usuarioController.getId_curso_subdet());
            //carga la paginacion y lista
            this.doTamanoPaginacionMediaBecca();
            this.doListarMediaBecas();
            usuarioController.getFramework().doMensajeF("Exito", "Se elimino con exito", 1);

        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error", "No se pudo eliminar", 4);

        }

    }

    public void doPrepararBeca(CepCecCursoSubdet item) {
        
         if (doValidarSiExisteInversion(item.getIdCursoSubdet())==1) {
          //  visibleEditarCurso = 0;
              usuarioController.setId_curso_subdet(item.getIdCursoSubdet());// captura cusubdet
            System.out.println("curso sub det = " + item.getCepCecCursoDet().getCepCecCursoCab().getNomCurso());
            System.out.println("el id es " + usuarioController.getId_curso_subdet());
            id_tipoAlumno = 0; // inicializacion importante para vista
            tipoExo = 0;
            //vista
            fechaExo = "";
            agenciaExo = null;
            secuenciaExo = "";
            num_cuotas = item.getNumCuotas();
            nom_curso = "Exonerados en : " + item.getCepCecCursoDet().getCepCecCursoCab().getNomCurso() + " " + item.getCepCecCursoDet().getCepNivel().getNomAbrevNivel() + " - " + item.getCepTipoDesarrollo().getNomTipoDes() + " / " + item.getCepEscalaTipomod().getCepTipoModalidad().getNomModalidad();
            // carga la lista
            lsCecDescExoneradoses = new ArrayList<>();
            lsCecDescExoneradoses = descuentoExoService.buscarBecas(usuarioController.getId_curso_subdet());
            this.redireccionAhExonerados();
        }else{
           // visibleEditarCurso = 1;
            usuarioController.getFramework().doMensajeR("Error!", "Primero debe asignar una inversion al curso", 4);
        }
      

    }

    public void doCapturarExonerado(CepCecExonerados entidad) {
        id_exo = entidad.getIdExonerados();
    }

    public void doEliminarVoucheFicticio() {
        try {
            CepCecExonerados voucherExo = new CepCecExonerados();
            voucherExo = exoneradosService.recuperarIdEntidad(id_exo);
            voucherExo.setEstadoExo(false);
            exoneradosService.actualizarEntidad(voucherExo);
            usuarioController.getFramework().doMensajeF("Exito", "Se elimino con exito", 1);
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("ERROR!", "", 1);

        }

        //cargar
        lstExonerados = new ArrayList<>();
        lstExonerados = exoneradosService.listaVoucherPorAlumno(id_desc_exonerados);

    }

    public void doVoucherFicticio(CepCecDescExonerados item) {
        lstExonerados = new ArrayList<>();
        lstExonerados = exoneradosService.listaVoucherPorAlumno(item.getIdAluDesExo());
        id_desc_exonerados = item.getIdAluDesExo();
    }

    public void doCrearBeca() {
        String dni;
        String num_documento;
        try {
            DrtPersonanatural drtPersonanatural = new DrtPersonanatural();
            switch (id_tipoAlumno) {
                case 1:
                    drtPersonanatural = usuarioController.getGestorUsuarioEstGeneralService().recuperarIdEntidadDrtPersona(usuarioController.getId_dir());
                    dni = drtPersonanatural.getNumeroPndid();
                    num_documento = usuarioController.getCodigoEst();
                    break;
                case 2:
                    drtPersonanatural = usuarioController.getGestorUsuarioEstGeneralService().recuperarIdEntidadDrtPersona(usuarioController.getId_dir());
                    dni = usuarioController.getDniEstGene();
                    num_documento = usuarioController.getDniEstGene();
                    break;
                case 3:
                    dni = usuarioController.getIdCardEstTrab();
                    num_documento = usuarioController.getIdCardEstTrab();
                    usuarioController.setDniEstGene(dni);
                    break;
                default:
                    throw new AssertionError();
            }
            System.out.println("paso a drtPersonaNatural");
            /// Si elije tipo de alumno trabajador y tipo de exoneracion es Descuento por planilla 
            // entonces el tipo de inversion sera Concepto por Descuento de planilla que su id es 8 en la tabla de cep_cec_inversion_curso
            if (id_tipoAlumno == 3 && tipoExo == 1) {
                id_tipo_inver = 8; // DESCUENTO POR PLANILLA
            } else {
                id_tipo_inver = 7; // beca
            }

            secuenciaExo = dni;
            MetodosExtras objeto = new MetodosExtras();
            Date fechaActual = objeto.obtenerFechaActualSinTime(); // Guardo la fecha la actual sin hora, minuto ni segundo
            fechaExo = objeto.doFechaConFormatoDMY(fechaActual); // le doy un formato para la vista
            agenciaExo = 999;
            System.out.println("llego a new Inversion");
            cepCecInversionCurso = new CepCecInversionCurso();
            cepCecInversionCurso = gestorInversionService.inversionBeca(usuarioController.getId_curso_subdet(), id_tipoAlumno, id_tipo_inver);
            // Si el Concepto no esta creado entonces se crea, sino ya fue traido esa entidad en cepCecInversionCurso
            if (cepCecInversionCurso == null) {
                //crea la en inversion un concepto de beca
                //CepCecInversionCurso becaEntidad = new CepCecInversionCurso();
                cepCecInversionCurso = new CepCecInversionCurso();
                cepCecInversionCurso = doCrearInversionBeca();
                System.out.println("se creo con exito la inversion");
            }

            //public CepCecDescExonerados validarLaNoRepeticionAlumno(int id_tipoAlumno, int id_inversion_curso, String num_documento)
            // Verifican si el becado ya existe para no repetir
            CepCecDescExonerados entidad = new CepCecDescExonerados();
            entidad = descuentoExoService.validarLaNoRepeticionAlumno(id_tipoAlumno, cepCecInversionCurso.getIdInversion(), num_documento);

            if (entidad == null) {
                //*************crea tabla de desc_exonerados/********/
                entidad = new CepCecDescExonerados();
                if (id_tipoAlumno==1) {
                     entidad.setCodAlumno(usuarioController.getCodigoEst());
                }
                entidad.setNumDocumento(usuarioController.getDniEstGene());
                entidad.setCepCecInversionCurso(cepCecInversionCurso);
                entidad.setEstadoDes(true);
                //llama a los EJB del UsuarioControllerParaRecuperarEntidad,Ingresardo como parametro el id_dir que se guardo al momento debuscar la persona , eso tambien se hizo en usuarioController
                // especificamente en las clases doBuscarAlumnoUns() y doBuscarPersona() 
                if (usuarioController.getId_dir() != 0) {
                    drtPersonanatural = new DrtPersonanatural();
                    drtPersonanatural = usuarioController.getGestorUsuarioEstGeneralService().recuperarIdEntidadDrtPersona(usuarioController.getId_dir());
                    entidad.setIdDir(drtPersonanatural.getIdDir());
                    entidad.setNomCompletosExo(drtPersonanatural.getNombreCompleto());
                }
                System.out.println("va crear exonerados");
                CepCecDescExonerados descuentoExoEntidad = new CepCecDescExonerados();
                descuentoExoEntidad = descuentoExoService.crearEntidad(entidad);
                id_desc_exonerados = descuentoExoEntidad.getIdAluDesExo();
            } else {
                System.out.println("descexo null");
                id_desc_exonerados = entidad.getIdAluDesExo();
            }
            try {
                ///*************Crear Tabla Exonerados***********///
                CepCecExonerados entidadDetalle = new CepCecExonerados();
                entidadDetalle.setSecuencia(secuenciaExo);
                entidadDetalle.setCodAgencia(agenciaExo);
                entidadDetalle.setFechaPago(fechaActual);
                if (id_tipoAlumno == 3 && tipoExo == 1) {
                    entidadDetalle.setNumResolucion(numResoulcion);
                }
                entidadDetalle.setCepCecDescExonerados(descuentoExoService.recuperarIdEntidad(id_desc_exonerados));
                entidadDetalle.setEstadoExo(true);
                if (pagototal == 1) {
                    entidadDetalle.setPagototal(true);
                } else {
                    entidadDetalle.setPagototal(false);
                }
                entidadDetalle.setFechaReg(new Date());
                entidadDetalle.setFechaVencimiento(fechaLimite);
                exoneradosService.crearEntidad(entidadDetalle);
            } catch (Exception e) {
                usuarioController.getFramework().doMensajeF("Error!", "Error al crear voucher ficticio", 4);
            }

            usuarioController.getFramework().doMensajeF("Exito!", "Se creo nuevo registro", 1);

        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "Error de guardado", 4);
        }

        // carga la lista
        lsCecDescExoneradoses = new ArrayList<>();
        lsCecDescExoneradoses = descuentoExoService.buscarBecas(usuarioController.getId_curso_subdet());
        //reset sexo
        usuarioController.setSexo(0);
    }

    public CepCecInversionCurso doCrearInversionBeca() {
        //id_rcdConcepto=11;//es fut
        cepCursoSubDet = new CepCecCursoSubdet();
        cepCecTipoInversion = new CepCecTipoInversion();
        cepCecTipAlumno = new CepCecTipAlumno();
        estado_inver = 1;
        cepCecTipAlumno = gestorTipoAlumnoService.recuperarTipoAlumno(id_tipoAlumno);
        cepCecTipoInversion = gestorTipoInversionService.recuperartipoInversion(id_tipo_inver);
        //rcdConcepto = gestorRcdConceptoService.recuperarRcdConcepto(id_rcdConcepto);
        cepCursoSubDet = gestorCursoSubDetService.recuperarIdCurSubDet(usuarioController.getId_curso_subdet());
        nom_curso = cepCursoSubDet.getCepCecCursoDet().getCepCecCursoCab().getNomCurso();
        nom_nivel = cepCursoSubDet.getCepCecCursoDet().getCepNivel().getNombreNivel();
        nom_tipo_alumno = cepCecTipAlumno.getNomAbrev();
        nomDesarollo = cepCursoSubDet.getCepTipoDesarrollo().getNomTipoDes();
        nomModalidad = cepCursoSubDet.getCepEscalaTipomod().getCepTipoModalidad().getNomModalidad();
        crearNombreInversion();
        cepCecInversionCurso.setCepCecCursoSubdet(cepCursoSubDet);
        cepCecInversionCurso.setCepCecTipAlumno(cepCecTipAlumno);
        cepCecInversionCurso.setCepCecTipoInversion(cepCecTipoInversion);
        //cepCecInversionCurso.setRcdConcepto(rcdConcepto);
        //cepCecInversionCurso.setDescripcionInv(descrp_inver);
        //precio = new Float(0.00);
        //cepCecInversionCurso.setPrecioPension(precio);
        //  cepCecInversionCurso.setPrecioTotal(precio_total);
        cepCecInversionCurso.setNombreConcepto(nombre_inversion);
        cepCecInversionCurso.setEstadoInver(estado_inver);
        // cepCecInversionCurso.setConceptoTotal(estado_contotal);
        // gestorInversionService.crearInversion(cepCecInversionCurso);
        //cepCecInversionCurso.setConceptoTotal(estado_contotal);
        cepCecInversionCurso.setUnicoPagototal(false);
        System.out.println("se va crear con exito la inversion");
        System.out.println("curso " + cepCursoSubDet.getCepCecCursoDet().getCepCecCursoCab().getNomCurso());
        System.out.println("tipo inver " + cepCecTipoInversion.getNomTipoinversion());
        System.out.println("tipo alu " + cepCecTipAlumno.getNomTipAlumno());
        return gestorInversionService.crearInversion(cepCecInversionCurso);
    }

    ////////////////////////*REEDIRECCIONAMIENTOS***********************-------------
    public void redireccionAhCursosDetallados() {
     // this.doBuscarCursoDet(); // cargala lista para el selectOne
        tipoModal = 5;
        cepCursoSubDet = new CepCecCursoSubdet();
        this.id_curso_det = -1;
        this.doBuscarCursoDetTodos();
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/CursosDetallados.xhtml";
        redireccionado(direccionar);
    }
    
    public void redireccionAhCursosDetalladosDespuesDeCrear() {
       this.doBuscarCursoDetTodos(); // cargala lista para el selectOne
        tipoModal = 5;
        cepCursoSubDet = new CepCecCursoSubdet();
       // id_curso_det  se obtiene en crear detalle
        this.doBuscarCursoSubDet();
         
       // this.doBuscarCursoDetTodos();
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/CursosDetallados.xhtml";
        redireccionado(direccionar);
    }

    public void redireccionAhCursos() {

        tipoModal = 3; // para borrar
        selectedCursos = new CepCecCursoDet();
        System.out.println("tipo moda " + tipoModal);
        pageNumberCursoDet = 1;
        this.doTamanoPaginacionCursoDet();
        this.doBuscarCursoDet();
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/CursosGenerales.xhtml";
        redireccionado(direccionar);

    }

    public void redireccionAhCrearDetallesCurso() {
        System.out.println("entro a reidrecion");
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/CrearDetallesCurso.xhtml";
        redireccionado(direccionar);
    }

    public void redireccionAhExonerados() {
        MetodosExtras obj = new MetodosExtras();
        fechaMin = obj.doConvertirFechaAhFormatoddMMyyyy(new Date()); 
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/Exonerados.xhtml";
        redireccionado(direccionar);
    }

    public void redireccionAhListExonerados() {
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/ListExonerados.xhtml";
        redireccionado(direccionar);
    }

    public void redireccionAhCreateGroup() {
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/CreateGrupo.xhtml";
        redireccionado(direccionar);
    }

    public void redireccionAhCreatePlan() {
        lstSesion = new ArrayList<>();
        lstSesion = this.doBuscarSesion();
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/CreatePlan.xhtml";
        redireccionado(direccionar);
    }

    public void redireccionAhModificarPlan() {
        lstSesion = new ArrayList<>();
        lstSesion = this.doBuscarSesion();
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/ModificarPlan.xhtml";
        redireccionado(direccionar);
    }
    
    public void redireccionAhVerPlan() {
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/verPlan.xhtml";
        redireccionado(direccionar);
    }

    public void redireccionAhCreateInversion() {
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/CrearInversionCurso.xhtml";
        redireccionado(direccionar);
    }

    public void redireccionAhCreateDuracion() {
        tipoModal = 2; // borrar duracion
        doBuscarEscala(); // carga la lista 
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/CreateDuracion.xhtml";
        redireccionado(direccionar);
    }

    public void redireccionAhCreateCurso() {
        tipoModal = 4; // borrar nombre curso
        this.doBuscarCursos();
        this.doListarNombres();
        doBuscarEscala(); // carga la lista 
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/CreateCurso.xhtml";
        redireccionado(direccionar);
    }

    /*public void redireccionAhCreateTaller() {
        tipoModal = 4; // borrar nombre curso
        doBuscarEscala(); // carga la lista 
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/CreateTaller.xhtml";
        redireccionado(direccionar);
    }
*/
    public void redireccionado(String direccionar) {
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            contex.getExternalContext().redirect(direccionar);
        } catch (IOException ex) {
            Logger.getLogger(CursoDetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * public void saveMessage() { FacesContext context =
     * FacesContext.getCurrentInstance(); context.addMessage(null, new
     * FacesMessage("Guardado Exitoso", "Se guardo con exito en la base de
     * datos"));
     *
     * }
     */
    public void enableButton() {
        enabled = true;
    }

    public boolean isEnabled() {

        return enabled;
    }

    public void doHabilitar() {
        disabled = false;
    }

    public void doDeshabilitar() {
        disabled = true;
    }

    //5. Metodos Get y Set
    public int getConformeInver() {
        return conformeInver;
    }

    public List<CepCecDescExonerados> getLsCecDescExoneradoses() {
        return lsCecDescExoneradoses;
    }

    public void setLsCecDescExoneradoses(List<CepCecDescExonerados> lsCecDescExoneradoses) {
        this.lsCecDescExoneradoses = lsCecDescExoneradoses;
    }

    public void setConformeInver(int conformeInver) {
        this.conformeInver = conformeInver;
    }

    public List<CepCecTipoInversion> getLstTipoInversion() {
        return lstTipoInversion;
    }

    public void setLstTipoInversion(List<CepCecTipoInversion> lstTipoInversion) {
        this.lstTipoInversion = lstTipoInversion;
    }

    public CepCecCursoCab getCursocab() {
        return cursocab;
    }

    public void setCursocab(CepCecCursoCab cursocab) {
        this.cursocab = cursocab;
    }

    public List<CepCecCursoCab> getLstCursos() {
        return lstCursos;
    }

    public void setLstCursos(List<CepCecCursoCab> lstCursos) {
        this.lstCursos = lstCursos;
    }

    public List<CepCecCursoCab> getLstCursosNombres() {
        return lstCursosNombres;
    }

    public void setLstCursosNombres(List<CepCecCursoCab> lstCursosNombres) {
        this.lstCursosNombres = lstCursosNombres;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNom_curso() {
        return nom_curso;
    }

    public void setNom_curso(String nom_curso) {
        this.nom_curso = nom_curso;
    }

    public String getDesCrip() {
        return desCrip;
    }

    public void setDesCrip(String desCrip) {
        this.desCrip = desCrip;
    }

    public Short getCurEstado() {
        return curEstado;
    }

    public void setCurEstado(Short curEstado) {
        this.curEstado = curEstado;
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public String getDetPlan() {
        return detPlan;
    }

    public void setDetPlan(String detPlan) {
        this.detPlan = detPlan;
    }

    public Short getEstadoPlan() {
        return estadoPlan;
    }

    public void setEstadoPlan(Short estadoPlan) {
        this.estadoPlan = estadoPlan;
    }

    public List<CepCecPlan> getLstPlan() {
        return lstPlan;
    }

    public void setLstPlan(List<CepCecPlan> lstPlan) {
        this.lstPlan = lstPlan;
    }

    public Date getFecha_reg_plan() {
        return fecha_reg_plan;
    }

    public void setFecha_reg_plan(Date fecha_reg_plan) {
        this.fecha_reg_plan = fecha_reg_plan;
    }

    public CepCecPlan getCepCecPlan() {
        return cepCecPlan;
    }

    public void setCepCecPlan(CepCecPlan cepCecPlan) {
        this.cepCecPlan = cepCecPlan;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getAnio_plan() {
        return anio_plan;
    }

    public void setAnio_plan(int anio_plan) {
        this.anio_plan = anio_plan;
    }

    public String getName_cur_plan() {
        return name_cur_plan;
    }

    public void setName_cur_plan(String name_cur_plan) {
        this.name_cur_plan = name_cur_plan;
    }

    public List<CepCecPlan> getLstPeriodoPlan() {
        return lstPeriodoPlan;
    }

    public void setLstPeriodoPlan(List<CepCecPlan> lstPeriodoPlan) {
        this.lstPeriodoPlan = lstPeriodoPlan;
    }

    public int getId_sesion() {
        return id_sesion;
    }

    public void setId_sesion(int id_sesion) {
        this.id_sesion = id_sesion;
    }

    public String getNombre_sesion() {
        return nombre_sesion;
    }

    public void setNombre_sesion(String nombre_sesion) {
        this.nombre_sesion = nombre_sesion;
    }

    public CepCecSesion getCepCecSesion() {
        return cepCecSesion;
    }

    public void setCepCecSesion(CepCecSesion cepCecSesion) {
        this.cepCecSesion = cepCecSesion;
    }

    public List<CepCecSesion> getLstSesion() {
        return lstSesion;
    }

    public void setLstSesion(List<CepCecSesion> lstSesion) {
        this.lstSesion = lstSesion;
    }

    public CepCecSesion getSelectedFilaSesion() {
        return SelectedFilaSesion;
    }

    public void setSelectedFilaSesion(CepCecSesion SelectedFilaSesion) {
        this.SelectedFilaSesion = SelectedFilaSesion;
    }

    public int getId_tema() {
        return id_tema;
    }

    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

    public String getNom_tema() {
        return nom_tema;
    }

    public void setNom_tema(String nom_tema) {
        this.nom_tema = nom_tema;
    }

    public CepCecTema getCepCecTema() {
        return cepCecTema;
    }

    public void setCepCecTema(CepCecTema cepCecTema) {
        this.cepCecTema = cepCecTema;
    }

    public List<CepCecTema> getLstTema() {
        return lstTema;
    }

    public void setLstTema(List<CepCecTema> lstTema) {
        this.lstTema = lstTema;
    }

    public CepCecTema getSelectedFilaTema() {
        return SelectedFilaTema;
    }

    public void setSelectedFilaTema(CepCecTema SelectedFilaTema) {
        this.SelectedFilaTema = SelectedFilaTema;
    }

    public List<CepNivel> getLstNivel() {
        return lstNivel;
    }

    public void setLstNivel(List<CepNivel> lstNivel) {
        this.lstNivel = lstNivel;
    }

    public int getIdnivel() {

        return idnivel;
    }

    public void setIdnivel(int idnivel) {
        this.idnivel = idnivel;
    }

    public String getNom_nivel() {
        return nom_nivel;
    }

    public void setNom_nivel(String nom_nivel) {
        this.nom_nivel = nom_nivel;
    }

    public int getNum_cep_nivel() {
        return num_cep_nivel;
    }

    public void setNum_cep_nivel(int num_cep_nivel) {
        this.num_cep_nivel = num_cep_nivel;
    }

    public CepNivel getCepNivel() {
        return cepNivel;
    }

    public void setCepNivel(CepNivel cepNivel) {
        this.cepNivel = cepNivel;
    }

    public String getNomDesarollo() {
        return nomDesarollo;
    }

    public void setNomDesarollo(String nomDesarollo) {
        this.nomDesarollo = nomDesarollo;
    }

    public Short getEstadoDesarrollo() {
        return estadoDesarrollo;
    }

    public void setEstadoDesarrollo(Short estadoDesarrollo) {
        this.estadoDesarrollo = estadoDesarrollo;
    }

    public int getCep_num() {
        return cep_num;
    }

    public void setCep_num(int cep_num) {
        this.cep_num = cep_num;
    }

    public List<CepTipoDesarrollo> getLstTipoDesarrollo() {
        return lstTipoDesarrollo;
    }

    public void setLstTipoDesarrollo(List<CepTipoDesarrollo> lstTipoDesarrollo) {
        this.lstTipoDesarrollo = lstTipoDesarrollo;
    }

    public int getIdTipoDesarollo() {
        return idTipoDesarollo;
    }

    public void setIdTipoDesarollo(int idTipoDesarollo) {
        this.idTipoDesarollo = idTipoDesarollo;
    }

    public CepTipoDesarrollo getCepTipoDesarrollo() {
        return cepTipoDesarrollo;
    }

    public void setCepTipoDesarrollo(CepTipoDesarrollo cepTipoDesarrollo) {
        this.cepTipoDesarrollo = cepTipoDesarrollo;
    }

    public int getId_Modalidad() {
        return id_Modalidad;
    }

    public void setId_Modalidad(int id_Modalidad) {
        this.id_Modalidad = id_Modalidad;
    }

    public String getNomModalidad() {
        return nomModalidad;
    }

    public void setNomModalidad(String nomModalidad) {
        this.nomModalidad = nomModalidad;
    }

    public Short getEstadoModalidad() {
        return estadoModalidad;
    }

    public void setEstadoModalidad(Short estadoModalidad) {
        this.estadoModalidad = estadoModalidad;
    }

    public int getCep_num_modalidad() {
        return cep_num_modalidad;
    }

    public void setCep_num_modalidad(int cep_num_modalidad) {
        this.cep_num_modalidad = cep_num_modalidad;
    }

    public List<CepTipoModalidad> getLstTipoModalidad() {
        return lstTipoModalidad;
    }

    public void setLstTipoModalidad(List<CepTipoModalidad> lstTipoModalidad) {
        this.lstTipoModalidad = lstTipoModalidad;
    }

    public CepTipoModalidad getCepTipoModalidad() {
        return cepTipoModalidad;
    }

    public void setCepTipoModalidad(CepTipoModalidad cepTipoModalidad) {
        this.cepTipoModalidad = cepTipoModalidad;
    }

    public List<String> getLstNomEscala() {
        return lstNomEscala;
    }

    public void setLstNomEscala(List<String> lstNomEscala) {
        this.lstNomEscala = lstNomEscala;
    }

    public int getIdEscalita() {
        return idEscalita;
    }

    public void setIdEscalita(int idEscalita) {
        this.idEscalita = idEscalita;
    }

    public String getNomEscala() {
        return nomEscala;
    }

    public void setNomEscala(String nomEscala) {
        this.nomEscala = nomEscala;
    }

    public int getNumEscala() {
        return numEscala;
    }

    public void setNumEscala(int numEscala) {
        this.numEscala = numEscala;
    }

    public Short getEstadoEscala() {
        return estadoEscala;
    }

    public void setEstadoEscala(Short estadoEscala) {
        this.estadoEscala = estadoEscala;
    }

    public List<CepEscalaTipomod> getLstTodoEscala() {
        return lstTodoEscala;
    }

    public void setLstTodoEscala(List<CepEscalaTipomod> lstTodoEscala) {
        this.lstTodoEscala = lstTodoEscala;
    }

    public CepEscalaTipomod getCepEscalaTipomod() {
        return cepEscalaTipomod;
    }

    public void setCepEscalaTipomod(CepEscalaTipomod cepEscalaTipomod) {
        this.cepEscalaTipomod = cepEscalaTipomod;
    }

    public int getId_curso_det() {
        return id_curso_det;
    }

    public void setId_curso_det(int id_curso_det) {
        this.id_curso_det = id_curso_det;
    }

    public Short getEstado_curso_det() {
        return estado_curso_det;
    }

    public void setEstado_curso_det(Short estado_curso_det) {
        this.estado_curso_det = estado_curso_det;
    }

    public CepCecCursoDet getCepCursoDet() {
        return cepCursoDet;
    }

    public void setCepCursoDet(CepCecCursoDet cepCursoDet) {
        this.cepCursoDet = cepCursoDet;
    }

    public List<CepCecCursoDet> getLstCursoDet() {
        return lstCursoDet;
    }

    public void setLstCursoDet(List<CepCecCursoDet> lstCursoDet) {
        this.lstCursoDet = lstCursoDet;
    }

    public Integer getNum_cuotas() {
        return num_cuotas;
    }

    public void setNum_cuotas(Integer num_cuotas) {
        this.num_cuotas = num_cuotas;
    }

    public int getMin_alu() {
        return min_alu;
    }

    public void setMin_alu(int min_alu) {
        this.min_alu = min_alu;
    }

    public int getMax_alum() {
        return max_alum;
    }

    public void setMax_alum(int max_alum) {
        this.max_alum = max_alum;
    }

    public Short getEstado_detcur() {
        return estado_detcur;
    }

    public void setEstado_detcur(Short estado_detcur) {
        this.estado_detcur = estado_detcur;
    }

    public int getHoras_lectivas() {
        return horas_lectivas;
    }

    public void setHoras_lectivas(int horas_lectivas) {
        this.horas_lectivas = horas_lectivas;
    }

    public CepCecCursoSubdet getCepCursoSubDet() {
        return cepCursoSubDet;
    }

    public void setCepCursoSubDet(CepCecCursoSubdet cepCursoSubDet) {
        this.cepCursoSubDet = cepCursoSubDet;
    }

    public List<CepCecCursoSubdet> getLstCusoSubDet() {
        return lstCusoSubDet;
    }

    public void setLstCusoSubDet(List<CepCecCursoSubdet> lstCusoSubDet) {
        this.lstCusoSubDet = lstCusoSubDet;
    }

    public CepCecCursoSubdet getSelectedListCurSubDet() {
        return SelectedListCurSubDet;
    }

    public void setSelectedListCurSubDet(CepCecCursoSubdet SelectedListCurSubDet) {
        this.SelectedListCurSubDet = SelectedListCurSubDet;
    }

    public GestorCepCecCursoCabServiceLocal getGestorCepCecCursoCabService() {
        return gestorCepCecCursoCabService;
    }

    public void setGestorCepCecCursoCabService(GestorCepCecCursoCabServiceLocal gestorCepCecCursoCabService) {
        this.gestorCepCecCursoCabService = gestorCepCecCursoCabService;
    }

    public GestorPlanServiceLocal getGestorPlanService() {
        return gestorPlanService;
    }

    public void setGestorPlanService(GestorPlanServiceLocal gestorPlanService) {
        this.gestorPlanService = gestorPlanService;
    }

    public GestorCepNivelServiceLocal getGestorCepNivelService() {
        return gestorCepNivelService;
    }

    public void setGestorCepNivelService(GestorCepNivelServiceLocal gestorCepNivelService) {
        this.gestorCepNivelService = gestorCepNivelService;
    }

    public GestorTipoDesarrolloServiceLocal getGestorTipoDesarrolloService() {
        return gestorTipoDesarrolloService;
    }

    public void setGestorTipoDesarrolloService(GestorTipoDesarrolloServiceLocal gestorTipoDesarrolloService) {
        this.gestorTipoDesarrolloService = gestorTipoDesarrolloService;
    }

    public GestorEscalaModalidadServiceLocal getGestorEscalaModalidadService() {
        return gestorEscalaModalidadService;
    }

    public void setGestorEscalaModalidadService(GestorEscalaModalidadServiceLocal gestorEscalaModalidadService) {
        this.gestorEscalaModalidadService = gestorEscalaModalidadService;
    }

    public GestorTipoModalidadLocal getGestorTipoModalidad() {
        return gestorTipoModalidad;
    }

    public void setGestorTipoModalidad(GestorTipoModalidadLocal gestorTipoModalidad) {
        this.gestorTipoModalidad = gestorTipoModalidad;
    }

    public GestorCursoDetServiceLocal getGestorCursoDetService() {
        return gestorCursoDetService;
    }

    public void setGestorCursoDetService(GestorCursoDetServiceLocal gestorCursoDetService) {
        this.gestorCursoDetService = gestorCursoDetService;
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

    public CepCecSesion getSelectRowSesion() {
        return SelectRowSesion;
    }

    public void setSelectRowSesion(CepCecSesion SelectRowSesion) {
        this.SelectRowSesion = SelectRowSesion;
    }

    public int getId_ultimo_plan() {
        return id_ultimo_plan;
    }

    public void setId_ultimo_plan(int id_ultimo_plan) {
        this.id_ultimo_plan = id_ultimo_plan;
    }

    public CepCecPlan getSelectedConPlanEdit() {
        return SelectedConPlanEdit;
    }

    public void setSelectedConPlanEdit(CepCecPlan SelectedConPlanEdit) {
        this.SelectedConPlanEdit = SelectedConPlanEdit;
    }

    public GestorCursoSubDetServiceLocal getGestorCursoSubDetService() {
        return gestorCursoSubDetService;
    }

    public void setGestorCursoSubDetService(GestorCursoSubDetServiceLocal gestorCursoSubDetService) {
        this.gestorCursoSubDetService = gestorCursoSubDetService;
    }

    public int getConforme() {
        return conforme;
    }

    public void setConforme(int conforme) {
        this.conforme = conforme;
    }

    public CepCecCursoDet getSelectedCursos() {
        return selectedCursos;
    }

    public void setSelectedCursos(CepCecCursoDet selectedCursos) {
        this.selectedCursos = selectedCursos;
    }

    public GestorTipoPagosServiceLocal getGestorTipoPagosService() {
        return gestorTipoPagosService;
    }

    public void setGestorTipoPagosService(GestorTipoPagosServiceLocal gestorTipoPagosService) {
        this.gestorTipoPagosService = gestorTipoPagosService;
    }

    public List<PguTipoPagos> getLstConceptosPGU() {
        return lstConceptosPGU;
    }

    public void setLstConceptosPGU(List<PguTipoPagos> lstConceptosPGU) {
        this.lstConceptosPGU = lstConceptosPGU;
    }

    public GestorInversionServiceLocal getGestorInversionService() {
        return gestorInversionService;
    }

    public void setGestorInversionService(GestorInversionServiceLocal gestorInversionService) {
        this.gestorInversionService = gestorInversionService;
    }

    public int getId_inversion() {
        return id_inversion;
    }

    public void setId_inversion(int id_inversion) {
        this.id_inversion = id_inversion;
    }

    public String getCodigo_inversion() {
        return codigo_inversion;
    }

    public void setCodigo_inversion(String codigo_inversion) {
        this.codigo_inversion = codigo_inversion;
    }

    public Short getEstado_inver() {
        return estado_inver;
    }

    public void setEstado_inver(Short estado_inver) {
        this.estado_inver = estado_inver;
    }

    public String getDescrp_inver() {
        return descrp_inver;
    }

    public void setDescrp_inver(String descrp_inver) {
        this.descrp_inver = descrp_inver;
    }

    public List<CepCecInversionCurso> getLstInverAlumUNS() {
        return lstInverAlumUNS;
    }

    public void setLstInverAlumUNS(List<CepCecInversionCurso> lstInverAlumUNS) {
        this.lstInverAlumUNS = lstInverAlumUNS;
    }

    public List<CepCecInversionCurso> getLstInverPubGen() {
        return lstInverPubGen;
    }

    public void setLstInverPubGen(List<CepCecInversionCurso> lstInverPubGen) {
        this.lstInverPubGen = lstInverPubGen;
    }

    public List<CepCecInversionCurso> getLstInverTrabUNS() {
        return lstInverTrabUNS;
    }

    public void setLstInverTrabUNS(List<CepCecInversionCurso> lstInverTrabUNS) {
        this.lstInverTrabUNS = lstInverTrabUNS;
    }

    public PguTipoPagos getPguTipoPagos() {
        return pguTipoPagos;
    }

    public void setPguTipoPagos(PguTipoPagos pguTipoPagos) {
        this.pguTipoPagos = pguTipoPagos;
    }

    public String getConcepto_pgu() {
        return concepto_pgu;
    }

    public void setConcepto_pgu(String concepto_pgu) {
        this.concepto_pgu = concepto_pgu;
    }

    public Integer getId_tipoPagos() {
        return id_tipoPagos;
    }

    public void setId_tipoPagos(Integer id_tipoPagos) {
        this.id_tipoPagos = id_tipoPagos;
    }

    public GestorTipoInversionServiceLocal getGestorTipoInversionService() {
        return gestorTipoInversionService;
    }

    public void setGestorTipoInversionService(GestorTipoInversionServiceLocal gestorTipoInversionService) {
        this.gestorTipoInversionService = gestorTipoInversionService;
    }

    public int getId_tipo_inver() {
        return id_tipo_inver;
    }

    public void setId_tipo_inver(int id_tipo_inver) {
        this.id_tipo_inver = id_tipo_inver;
    }

    public String getNombre_tipoinver() {
        return nombre_tipoinver;
    }

    public void setNombre_tipoinver(String nombre_tipoinver) {
        this.nombre_tipoinver = nombre_tipoinver;
    }

    public int getVer_tipoinver() {
        return ver_tipoinver;
    }

    public void setVer_tipoinver(int ver_tipoinver) {
        this.ver_tipoinver = ver_tipoinver;
    }

    public CepCecInversionCurso getSelectedInversion() {
        return SelectedInversion;
    }

    public void setSelectedInversion(CepCecInversionCurso SelectedInversion) {
        this.SelectedInversion = SelectedInversion;
    }

    public GestorTipoAlumnoServiceLocal getGestorTipoAlumnoService() {
        return gestorTipoAlumnoService;
    }

    public void setGestorTipoAlumnoService(GestorTipoAlumnoServiceLocal gestorTipoAlumnoService) {
        this.gestorTipoAlumnoService = gestorTipoAlumnoService;
    }

    public String getNom_tipo_alumno() {
        return nom_tipo_alumno;
    }

    public void setNom_tipo_alumno(String nom_tipo_alumno) {
        this.nom_tipo_alumno = nom_tipo_alumno;
    }

    public CepCecInversionCurso getCepCecInversionCurso() {
        return cepCecInversionCurso;
    }

    public void setCepCecInversionCurso(CepCecInversionCurso cepCecInversionCurso) {
        this.cepCecInversionCurso = cepCecInversionCurso;
    }

    public CepCecTipoInversion getCepCecTipoInversion() {
        return cepCecTipoInversion;
    }

    public void setCepCecTipoInversion(CepCecTipoInversion cepCecTipoInversion) {
        this.cepCecTipoInversion = cepCecTipoInversion;
    }

    public CepCecTipAlumno getCepCecTipAlumno() {
        return cepCecTipAlumno;
    }

    public void setCepCecTipAlumno(CepCecTipAlumno cepCecTipAlumno) {
        this.cepCecTipAlumno = cepCecTipAlumno;
    }

    public Float getPrecio_pgu() {
        return precio_pgu;
    }

    public void setPrecio_pgu(Float precio_pgu) {
        this.precio_pgu = precio_pgu;
    }

    public Float getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Float precio_total) {
        this.precio_total = precio_total;
    }

    public String getCapturaTipoPagos() {
        return capturaTipoPagos;
    }

    public void setCapturaTipoPagos(String capturaTipoPagos) {
        this.capturaTipoPagos = capturaTipoPagos;
    }

    public List<CepCecTipAlumno> getLstTipoAlumno() {
        return lstTipoAlumno;
    }

    public void setLstTipoAlumno(List<CepCecTipAlumno> lstTipoAlumno) {
        this.lstTipoAlumno = lstTipoAlumno;
    }

    public List<RcdConcepto> getLstRcdConceptos() {
        return lstRcdConceptos;
    }

    public void setLstRcdConceptos(List<RcdConcepto> lstRcdConceptos) {
        this.lstRcdConceptos = lstRcdConceptos;
    }

   

    public RcdTarifario getRcdTarifario() {
        return rcdTarifario;
    }

    public void setRcdTarifario(RcdTarifario rcdTarifario) {
        this.rcdTarifario = rcdTarifario;
    }

    public GestorRcdTarifarioServiceLocal getGestorRcdTarifarioService() {
        return gestorRcdTarifarioService;
    }

    public void setGestorRcdTarifarioService(GestorRcdTarifarioServiceLocal gestorRcdTarifarioService) {
        this.gestorRcdTarifarioService = gestorRcdTarifarioService;
    }

    public int getId_rcdConcepto() {
        return id_rcdConcepto;
    }

    public void setId_rcdConcepto(int id_rcdConcepto) {
        this.id_rcdConcepto = id_rcdConcepto;
    }

    public RcdConcepto getRcdConcepto() {
        return rcdConcepto;
    }

    public void setRcdConcepto(RcdConcepto rcdConcepto) {
        this.rcdConcepto = rcdConcepto;
    }

    public String getId_tipoAlu() {
        return id_tipoAlu;
    }

    public void setId_tipoAlu(String id_tipoAlu) {
        this.id_tipoAlu = id_tipoAlu;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public GestorRcdConceptoServiceLocal getGestorRcdConceptoService() {
        return gestorRcdConceptoService;
    }

    public void setGestorRcdConceptoService(GestorRcdConceptoServiceLocal gestorRcdConceptoService) {
        this.gestorRcdConceptoService = gestorRcdConceptoService;
    }

    public String getNombre_inversion() {
        return nombre_inversion;
    }

    public void setNombre_inversion(String nombre_inversion) {
        this.nombre_inversion = nombre_inversion;
    }

    public int getTipoModal() {
        return tipoModal;
    }

    public void setTipoModal(int tipoModal) {
        this.tipoModal = tipoModal;
    }

    public UsuarioController getUsuarioController() {
        return usuarioController;
    }

    public void setUsuarioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public GestorCursoGrupoServiceLocal getGestorCursoGrupoService() {
        return gestorCursoGrupoService;
    }

    public void setGestorCursoGrupoService(GestorCursoGrupoServiceLocal gestorCursoGrupoService) {
        this.gestorCursoGrupoService = gestorCursoGrupoService;
    }

    public Short getVerNuevoPlan() {
        return verNuevoPlan;
    }

    public void setVerNuevoPlan(Short verNuevoPlan) {
        this.verNuevoPlan = verNuevoPlan;
    }

    public boolean isEstado_concepto_total() {
        return estado_concepto_total;
    }

    public void setEstado_concepto_total(boolean estado_concepto_total) {
        this.estado_concepto_total = estado_concepto_total;
    }

    public boolean isCopiarBase() {
        return copiarBase;
    }

    public void setCopiarBase(boolean copiarBase) {
        this.copiarBase = copiarBase;
    }

    public char getOptionPago() {
        return optionPago;
    }

    public void setOptionPago(char optionPago) {
        this.optionPago = optionPago;
    }

    public DescuentoExoServiceLocal getDescuentoExoService() {
        return descuentoExoService;
    }

    public void setDescuentoExoService(DescuentoExoServiceLocal descuentoExoService) {
        this.descuentoExoService = descuentoExoService;
    }

    public ExoneradosServiceLocal getExoneradosService() {
        return exoneradosService;
    }

    public void setExoneradosService(ExoneradosServiceLocal exoneradosService) {
        this.exoneradosService = exoneradosService;
    }

    public String getSecuenciaExo() {
        return secuenciaExo;
    }

    public void setSecuenciaExo(String secuenciaExo) {
        this.secuenciaExo = secuenciaExo;
    }

    public Short getAgenciaExo() {
        return agenciaExo;
    }

    public void setAgenciaExo(Short agenciaExo) {
        this.agenciaExo = agenciaExo;
    }

    public String getFechaExo() {
        return fechaExo;
    }

    public void setFechaExo(String fechaExo) {
        this.fechaExo = fechaExo;
    }

    public String getNumResoulcion() {
        return numResoulcion;
    }

    public void setNumResoulcion(String numResoulcion) {
        this.numResoulcion = numResoulcion;
    }

    public Integer getTipoExo() {
        return tipoExo;
    }

    public void setTipoExo(Integer tipoExo) {
        this.tipoExo = tipoExo;
    }

    public int getPagototal() {
        return pagototal;
    }

    public void setPagototal(int pagototal) {
        this.pagototal = pagototal;
    }

    public int getId_desc_exonerados() {
        return id_desc_exonerados;
    }

    public void setId_desc_exonerados(int id_desc_exonerados) {
        this.id_desc_exonerados = id_desc_exonerados;
    }

    public List<CepCecExonerados> getLstExonerados() {
        return lstExonerados;
    }

    public void setLstExonerados(List<CepCecExonerados> lstExonerados) {
        this.lstExonerados = lstExonerados;
    }

    public int getId_exo() {
        return id_exo;
    }

    public void setId_exo(int id_exo) {
        this.id_exo = id_exo;
    }

    public int getNum_pagos() {
        return num_pagos;
    }

    public void setNum_pagos(int num_pagos) {
        this.num_pagos = num_pagos;
    }

    public int getFormapago() {
        return formapago;
    }

    public void setFormapago(int formapago) {
        this.formapago = formapago;
    }

    public int getNum_clases() {
        return num_clases;
    }

    public void setNum_clases(int num_clases) {
        this.num_clases = num_clases;
    }

    public int getPageNumberCursoDet() {
        return pageNumberCursoDet;
    }

    public void setPageNumberCursoDet(int pageNumberCursoDet) {
        this.pageNumberCursoDet = pageNumberCursoDet;
    }

    public List<Integer> getPaginacionCursoDet() {
        return paginacionCursoDet;
    }

    public void setPaginacionCursoDet(List<Integer> paginacionCursoDet) {
        this.paginacionCursoDet = paginacionCursoDet;
    }

    public int getPageNumberPlan() {
        return pageNumberPlan;
    }

    public void setPageNumberPlan(int pageNumberPlan) {
        this.pageNumberPlan = pageNumberPlan;
    }

    public List<Integer> getPaginacionPlan() {
        return paginacionPlan;
    }

    public void setPaginacionPlan(List<Integer> paginacionPlan) {
        this.paginacionPlan = paginacionPlan;
    }

    public int getPageNumberMediaBeca() {
        return pageNumberMediaBeca;
    }

    public void setPageNumberMediaBeca(int pageNumberMediaBeca) {
        this.pageNumberMediaBeca = pageNumberMediaBeca;
    }

    public List<Integer> getPaginacionMediaBeca() {
        return paginacionMediaBeca;
    }

    public void setPaginacionMediaBeca(List<Integer> paginacionMediaBeca) {
        this.paginacionMediaBeca = paginacionMediaBeca;
    }

    public int getId_tipoAlumno() {
        return id_tipoAlumno;
    }

    public void setId_tipoAlumno(int id_tipoAlumno) {
        this.id_tipoAlumno = id_tipoAlumno;
    }

    public int getTipoEnsenanza() {
        return tipoEnsenanza;
    }

    public void setTipoEnsenanza(int tipoEnsenanza) {
        this.tipoEnsenanza = tipoEnsenanza;
    }

    public int getPageNumberCursoCab() {
        return pageNumberCursoCab;
    }

    public void setPageNumberCursoCab(int pageNumberCursoCab) {
        this.pageNumberCursoCab = pageNumberCursoCab;
    }

    public CepCecDescExonerados getCepCecDescExonerados() {
        return cepCecDescExonerados;
    }

    public void setCepCecDescExonerados(CepCecDescExonerados cepCecDescExonerados) {
        this.cepCecDescExonerados = cepCecDescExonerados;
    }

    public List<Integer> getPaginacionCursoCab() {
        return paginacionCursoCab;
    }

    public void setPaginacionCursoCab(List<Integer> paginacionCursoCab) {
        this.paginacionCursoCab = paginacionCursoCab;
    }

    public List<CepCecCursoDet> getLstCursoDetTodos() {
        return lstCursoDetTodos;
    }

    public void setLstCursoDetTodos(List<CepCecCursoDet> lstCursoDetTodos) {
        this.lstCursoDetTodos = lstCursoDetTodos;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getFechaMin() {
        return fechaMin;
    }

    public void setFechaMin(String fechaMin) {
        this.fechaMin = fechaMin;
    }

    public String getNombreCursoCompleto() {
        return nombreCursoCompleto;
    }

    public void setNombreCursoCompleto(String nombreCursoCompleto) {
        this.nombreCursoCompleto = nombreCursoCompleto;
    }

    public Integer getVisibleEditarCurso() {
        return visibleEditarCurso;
    }

    public void setVisibleEditarCurso(Integer visibleEditarCurso) {
        this.visibleEditarCurso = visibleEditarCurso;
    }

    public Integer getValidarCurso() {
        return validarCurso;
    }

    public void setValidarCurso(Integer validarCurso) {
        this.validarCurso = validarCurso;
    }

    public String getNomcur_found() {
        return nomcur_found;
    }

    public void setNomcur_found(String nomcur_found) {
        this.nomcur_found = nomcur_found;
    }

  

    
}
