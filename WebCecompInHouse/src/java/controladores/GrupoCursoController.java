/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

//import javax.inject.Named;
import clases.CurGrupDetDoc;
import clases.InversionCurso;
import clases.TipoCronograma;
import ejb.negocio.GestorAulaClassServiceLocal;
import ejb.negocio.GestorCepCecCurGrupDetalleServiceLocal;
import ejb.negocio.GestorCepHorarioDiasServiceLocal;
import ejb.negocio.GestorCronogramasCabServiceLocal;
import ejb.negocio.GestorCursoDetServiceLocal;
import ejb.negocio.GestorCursoGrupoServiceLocal;
import ejb.negocio.GestorCursoSubDetServiceLocal;
import ejb.negocio.GestorGrupoServiceLocal;
import ejb.negocio.GestorHorariosServiceLocal;
import ejb.negocio.GestorInversionServiceLocal;
import ejb.negocio.GestorUsuarioDocenteServiceLocal;
import entidades.CepAulaClass;
import entidades.CepCecCronogramaDet;
import entidades.CepCecCurGrup;
import entidades.CepCecCurGrupDet;
import entidades.CepCecCursoDet;
import entidades.CepCecCursoSubdet;
import entidades.CepCecGrupo;
import entidades.CepCecHorarios;
import entidades.CepCecInversionCurso;
import entidades.CepHorarioDias;
import entidades.CepTipoModalidad;
import entidades.DrtPersonanatural;
import entidades.PguTipoPagos;
import frameworkHANM.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FlowEvent;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import ejb.negocio.GestorCronogramasDetServiceLocal;
import ejb.negocio.GestorPlanServiceLocal;
import entidades.CepCecCronogramaCab;
import entidades.CepCecPlan;
import clases.MetodosExtras;

/**
 *
 * @author MELVN
 */
@ManagedBean(name = "grupoCursoController")
@SessionScoped
public class GrupoCursoController {

    //1. Atributos
    /**
     * Tipo: Variable <br>
     * Descripcion: Nombre del archivo a cargar o descargar. <br>
     * Ejemplo: Manual.pdf
     */
    // llamando usuario controller
    @ManagedProperty(value = "#{usuarioController}")
    public UsuarioController usuarioController;

    private CepCecPlan cepCecPlan;
    private int id_curSubdetalle;  // atributo para recuperar el id del detalle curso elegido
    private CepCecInversionCurso cepCecInversionCurso;

// atributos aula class
    private List<CepAulaClass> lstAula;
    private int id_aula;
    private CepAulaClass cepAulaClass;

    // aatributos grupo
    private int id_grupo;
    private List<CepCecGrupo> lstGrupo;
    private CepCecGrupo cepCecGrupo;
    private String nom_grupo;
    

    // atributos grupoCurso
    private String seccion;
    private Short estado_grup;
    private CepCecCurGrup cepCecCurGrup;
    private List<CepCecCurGrup> lstGrupoCur;
    //private CepCecCurGrup SelectedListCurGrup; // se usa para seleccionar en la tabla una fila en objeto 
    private int id_cur_grupo;
    private CepCecCurGrup cepCecCurGrup2;
    private boolean estadoAcademico;
     private int pageNumberGrupo;
    private List<Integer> paginacionGrupo;

    // atributos GrupoCursoDet
    private Short estado_grupcurdet;
    private CepCecCurGrupDet cepCecCurGrupDet;
    private Integer id_grup_det;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String minFechaInicio;
    private String minFechaFin;

    //clase nueva CurGrupDetDoc 
    private List<CurGrupDetDoc> lstDocCurGrupDet;
    private String num_dni;

    // atributos de cep_horario_dias
    private int id_horarios_dias;
    private String nombreHorarioDias;
    private CepHorarioDias cepHorarioDias;
    private List<CepHorarioDias> lstHorarioDias;
    private List<String> dias;
    private String[] selectDias;
    //private horarios

    private Date hora_inicio;
    private Date hora_fin;
    private Short estado_horario;
    private CepCecHorarios cepCecHorarios;
    private List<CepCecHorarios> lstHorarios;
    private int minHoraFinHorario;
    private int minMinuteFinHorario;
    // objeto de la tabla  curso det
    private CepCecCursoSubdet cepCecCursoSubDet;

    // para el wizard de hablitar curso
    private boolean skip;

    //DOCENTE
    private DrtPersonanatural drtPersonanatural;
    private List<DrtPersonanatural> lstDocente;
    private int id_docente;
    private String nom_docente;

    //atributos cronograma
    private CepCecCronogramaDet cepCecCronogramaDet;
    private CepCecCronogramaCab cepCecCronogramaCab;
    private Short estado_cronograma;
    private Date fecha_ini_cro;
    private Date fecha_fin_cro;
    private Date fecha_Registro_cro;
    private String descripcion_cronograma;
    private int id_cronograma;
    private Date hora_ini_cro;
    private Date hora_fin_cro;
    private List<CepCecCronogramaDet> lstCronograma;
    private TipoCronograma tipoCronograma;
    private List<TipoCronograma> lstTipoCronograma;
    private Integer ultimeCrono;
    private Short habilitarEditCro;
    private Integer cronoActualizado;
    //atributos cronograma validar fecha y hora
    private int dayActual;
    private int monthActual;
    private int yearActual;
    private String MinDia;
    private String FFMinDia;
    private int daySelect;
    private int monthSelect;
    private int yearSelect;
    private int hora;
    private int minute;
    private int hora_f;
    private int minute_f;
    private int hora_actual;
    private int minute_actual;
    private int horaSelect;
    private int minuteSelect;
    private Calendar fecha;
    private java.util.Date fechaActual;
    private MetodosExtras metodosExtras;
    private String descripcion;
    private int numpago;
    private String name_etapa;
    private Integer verificarSiFaltaDocente;
    private String nombreFiltro;

    //2. EJBs
    @EJB
    private GestorAulaClassServiceLocal gestorAulaClassService;
    @EJB
    private GestorGrupoServiceLocal gestorGrupoService;
    @EJB
    private GestorCursoGrupoServiceLocal gestorCursoGrupoService;
    @EJB
    private GestorCepHorarioDiasServiceLocal gestorCepHorarioDiasService;
    @EJB
    private GestorHorariosServiceLocal gestorHorariosService;
    @EJB
    private GestorUsuarioDocenteServiceLocal gestorUsuarioDocenteService;
    @EJB
    private GestorCepCecCurGrupDetalleServiceLocal gestorCepCecCurGrupDetalleService;
    @EJB
    private GestorCronogramasDetServiceLocal gestorCronogramasDetService;
    @EJB
    private GestorCursoSubDetServiceLocal gestorCursoSubDetService;
    @EJB
    private GestorInversionServiceLocal gestorInversionService;
    @EJB
    private GestorCronogramasCabServiceLocal gestorCronogramasCabService;
    @EJB
    private GestorPlanServiceLocal gestorPlanService;

    //llamando al Usuario Controller
    //@ManagedProperty(value = "#{cursoDetController}")
    //CursoDetController cursoDetController;
    //3. Acciones JSF
    public GrupoCursoController() {

    }

    public void redireccionado(String direccionar) {
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            contex.getExternalContext().redirect(direccionar);
        } catch (IOException ex) {
            Logger.getLogger(CursoDetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // wizard
    /*public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }*/
    //4. Metodos Propios
    @PostConstruct
    public void init() {

        dias = new ArrayList<>();
        dias.add("Lunes");
        dias.add("Martes");
        dias.add("Miercoles");
        dias.add("Jueves");
        dias.add("Viernes");
        dias.add("Sabado");
        dias.add("Domingo");

        pageNumberGrupo = 1;
    }

    // llama a un OneMenu la lista de aulas del Centro de Prodccion = CECOMP
    public List<CepAulaClass> doBuscarAulas() {
        return lstAula = gestorAulaClassService.buscarTodos();
    }

    // llama a un OneMenu la lista de grupos nombres
    public List<CepCecGrupo> doBuscarGrupos() {
        return lstGrupo = gestorGrupoService.buscarTodos();
    }

    public void doFiltroBuscarGruposCursos(){
        pageNumberGrupo = 1;
        this.doTamanoPaginacionCursoDet();
        this.doBuscarGruposCursos();
    }
    
    // llama a un OneMenu la lista de grupos nombres
    public void doBuscarGruposCursos() {
        
        lstGrupoCur = new ArrayList<>();
        System.out.println("en controaller");
        System.out.println("id_curso_det = " + usuarioController.getId_curso_subdet());
   
            System.out.println(" EN FILTRO LISTA GRUPO");
           lstGrupoCur = gestorCursoGrupoService.buscarGrupoPorFiltro(usuarioController.getId_curso_subdet(),this.pageNumberGrupo);
            
        
    }
  public void doCapturarPaginaGrupo(Integer pagina){
     this.pageNumberGrupo = pagina;
     this.doBuscarGruposCursos();
  
  }
  public void doActualizaGrupos(){
        this.pageNumberGrupo= 1;
        this.doTamanoPaginacionCursoDet();
        this.doBuscarGruposCursos();
  }
  
  
 // This function send some data to db (Esta funcion envia datos a la bd)
    public void doTamanoPaginacionCursoDet() {
        // Calcula tras metodos numericos cauntas pagSize cuantos botones de paginacion va tener
        int x = gestorCursoGrupoService.tamanoPaginacionGrupo(usuarioController.getId_curso_subdet());
        System.out.println("x es " + x);
        paginacionGrupo = new ArrayList<>();
        //si la paginacion es 0 entonces solo se agregara un unico boton
        if (x == 0) {
            paginacionGrupo.add(1); // es 1 para que no de error en el calculo al llamar la lista de la tabla
        } else {
            //llena los numeros a las lista integer 
            for (int i = 1; i <= x; i++) {
                paginacionGrupo.add(i);
            }
        }
        //retorna esta lista para que en la vista con un repetidor listar los botones de paginacion
        //return paginacionCursoDet;
    }
    
    
    public void doBuscarGruposCursosHistoricos() {
        lstGrupoCur = new ArrayList<>();
        System.out.println("en controaller");
        if (usuarioController.getId_curso_subdet() == 0) {
            lstGrupoCur = gestorCursoGrupoService.buscarHistoricos();            
        } else {
            lstGrupoCur = gestorCursoGrupoService.buscarHistoricoPorFiltro(usuarioController.getId_curso_subdet());
        }
    }

    // llama a listar todos los horarios en cep_horario_dias
    public List<CepHorarioDias> doBuscarHorarioDias() {
        return lstHorarioDias = gestorCepHorarioDiasService.buscarTodos();
    }

    // llama u la lista de cronograma
    public List<CepCecCronogramaDet> doBuscarCronograma() {
        return lstCronograma = gestorCronogramasDetService.buscarTodos();
    }

    // llama u la lista de horarios
    public List<CepCecHorarios> doBuscarHorarios() {
        return lstHorarios = gestorHorariosService.buscarTodos();
    }

    // metodo para web alumno cecomp
    /* public List<InversionCurso> dobuscarInversionTipoAlumno() {
        // por tipo de alumno iniciado cesion  1: uns 2: externo  3: trabajdor
        
        lstInversion = new ArrayList<InversionCurso>();
        System.out.println("tipo de alumno" +usuarioController.tipo_alumno);
        System.out.println("Curso es "+id_curSubdetalle);
        
        return lstInversion = gestorInversionService.buscarInversionPorTipo(id_curSubdetalle, usuarioController.tipo_alumno);
    }*/
    public void doTraerFilaPorIdGrupo() {
        //recuperar toda la fila del grupo por id
        cepCecGrupo = gestorGrupoService.recuperarIdSeccion(id_grupo);
        nom_grupo = cepCecGrupo.getNomGrupo();
    }

    public void doTraerFilaPorIdHorarioDias() {
        cepHorarioDias = gestorCepHorarioDiasService.recuperarIdDiasdeHorario(id_horarios_dias);
        nombreHorarioDias = cepHorarioDias.getNomHorarioDias();

    }

    //ES PARA TRAER ATRIBUTOS DE HIJO A PADRE buscar por id el curso grupo y mostrar la lista del horario 
    public List<CepCecHorarios> doListarHorarioPorId(int id) {
        return lstHorarios = gestorHorariosService.listarIdHorario(id);
    }

    //DOCENTE
    //listar docentes
    public List<DrtPersonanatural> doListarDocente() {
        // ingresa numero de dni por mientras
        doBuscarDocentePorDni();
        return lstDocente = gestorUsuarioDocenteService.listarDocentes(num_dni);
    }

    //Listar docentes que ya estan registrados en curso grupo det
    public List<CurGrupDetDoc> doListarDocenteCursoGrupDet() {
        return lstDocCurGrupDet = gestorCepCecCurGrupDetalleService.listarDocenteCurGrupDet();
    }

    //buscar docente por dni
    public void doBuscarDocentePorDni() {

        System.out.println("ingresó");
        if (!"".equals(num_dni)) {
            if (gestorUsuarioDocenteService.existeDocente(num_dni)) {
                System.out.println("correcto");

                drtPersonanatural = gestorUsuarioDocenteService.recuperarDatosDocente(num_dni);
                nom_docente = drtPersonanatural.getNombreCompleto();
                id_docente = drtPersonanatural.getIdDir();

                usuarioController.enabled_docente = 1; // activa el boton de agregar lista docente
                System.out.println("enable = " + usuarioController.enabled_docente);
            } else {
                System.out.println("incorrecto");
                nom_docente = "El docente no fue registrado en el SIIGAA";
                usuarioController.enabled_docente = 0; // activa el boton de agregar lista docente
                System.out.println("enable = " + usuarioController.enabled_docente);

                // usuarioController.getFramework().doMensajeF("Error!", "El docente no fue registrado en el SIIGAA", 4);
                // cursoDetController.doMensajeR("Docente No Encontrado", "Por favor ingrese un DNI Válido", 1);
            }
        } else {
            nom_docente = null;
            usuarioController.enabled_docente = 0; // activa el boton de agregar lista docente
            //  usuarioController.getFramework().doMensajeF("Error!", "El docente no fue registrado en el SIIGAA", 4);
            System.out.println("enable = " + usuarioController.enabled_docente);

        }

    }

    public void doLimpiarDocente() {

        //num_dni=null;
        nom_docente = null;
        usuarioController.enabled_docente = 0;
    }

    public void doDeshabilitarBotonDocente() {
        System.out.println("ENTRO A DESHABILITAR");
        usuarioController.enabled_docente = 0;
        System.out.println("docente " + usuarioController.enabled_docente);
        num_dni = "";
        nom_docente = "";
    }

    //carga el docente que va a mostar en confirmar
    public void doCargarDocente() {
        System.out.println("id_docente = " + id_docente);
        drtPersonanatural = gestorUsuarioDocenteService.recuperarIdDocente(id_docente);
        System.out.println("el docente seleccionado es " + drtPersonanatural.getNombreCompleto());
    }

    //carga el ambiente que va a mostar en confirmar
    public void doCargarAmbiente() {
        cepAulaClass = new CepAulaClass();
        cepAulaClass = gestorAulaClassService.recuperarIdAula(id_aula);

    }

    // Crear unac combinacion de dias de horario nuevo
    public void doCrearHorarioDias() {
        int tamano;
        String cadena;
        int condicional;
        cepHorarioDias = new CepHorarioDias();
        //usuarioController.baseController = new fwGeneral2();
        tamano = selectDias.length;
        System.out.println("tamano = " + tamano);

        if (tamano != 0) {
            cadena = gestorCepHorarioDiasService.formatoHorarioDias(selectDias);
            condicional = gestorCepHorarioDiasService.buscarRepeticion(cadena);

            if (condicional == 0) {
                // ahora se va al negocio y se guarda en el objeto cepHorarioDias
                cepHorarioDias.setNomHorarioDias(cadena);
                // ahora se guarda el obejto
                gestorCepHorarioDiasService.crearNuevoHorarioDias(cepHorarioDias);
                System.out.println("Guardo");

                usuarioController.getFramework().doMensajeF("Exitoso", "Se guardo combinacion  Dias de clase en la BD", 1);
            } else {
                usuarioController.getFramework().doMensajeF("Fallido!", "Esta combinacion de dias ya existe!", 4);
                System.out.println("Ya se guardo esta combinacion de dias");
            }
        } else {
            usuarioController.getFramework().doMensajeF("Fallido!", "No se Ingreso ninguna combinacion de dias!", 4);
            System.out.println("No se ingeso nada");
        }

    }

    public void doCrearParametrosMatricula() {
        //recuperar id de curso detalle
            
            
        System.out.println("ENTRO A CREAR LA UNION PARAMETROS MATRICULA");
        if ( !gestorCursoGrupoService.validarNumeroDeGrupo(usuarioController.getId_curso_subdet(), id_grupo)) {
             doCrearGrupo();
            System.out.println("SE GUARDO EN LA UNION LA CREACION EN GRUPO");
            doCrearHorarios();
            System.out.println("SE GUARDO EN LA UNION LA CREACION DE GRUPO DET");
            doCrearCronograma();
            System.out.println("SE GUARDO EN LA UNION LA CREAACION DE HORARIOS");
            doCrearDetGrupoCur();
            System.out.println("SE GUARDO EN LA UNION EL   CRONOGRAMA");
            usuarioController.getFramework().doMensajeR("Exito!", "Se guardo Grupo", 1);
            System.out.println("EXITOSO LO LOGRASTE ");
            doLimpiarParametrosMatricula();
            System.out.println("se limpiaron los registros");
            usuarioController.setId_curso_subdet(cepCecCursoSubDet.getCepCecCursoDet().getIdCursoDet());
            this.redireccionAhGroupCursoDesdeCreate();
            //return "irListarGrupo";
            //redireccionAhGroupCurso();
        }else{
              usuarioController.getFramework().doMensajeR("Fallo!", "Ya existe un grupo de este curso o taller con el mismo numero de grupo!", 4);
        }

       
    }

    public void doLimpiarParametrosMatricula() {
        // grupo 
        id_grupo = 0;
        fecha_inicio = null;
        fecha_fin = null;
        //horarios
        id_horarios_dias = 0;
        hora_inicio = null;
        hora_fin = null;
        //cronogrma
        fecha_ini_cro = null;
        hora_ini_cro = null;
        fecha_fin_cro = null;
        hora_fin_cro = null;
        id_aula = 0;
        id_docente = 0;
        nom_docente = "";
        num_dni = "";
        nom_docente = "";
        drtPersonanatural = new DrtPersonanatural();
        System.out.println("id Aula: " + id_aula);
        System.out.println("docente = " + id_docente);
        System.out.println(" obtuvo id de horario_dias " + id_horarios_dias);
        System.out.println("Hora inicio " + hora_inicio);
        System.out.println("Hora fin " + hora_fin);
        System.out.println("Estado de horario  " + estado_horario);
        System.out.println("fecha ini crono " + fecha_ini_cro);
        System.out.println("Hora ini crono " + hora_ini_cro);
        System.out.println("Fecha fin crono " + fecha_fin_cro);
        System.out.println("Hora fin crono " + hora_fin_cro);

    }

    //creando detalle del grupo
    public void doCrearDetGrupoCur() {
        estado_grupcurdet = 1;
        System.out.println("ENTRO A CREAR DETALLE DEL GRUPO");
        System.out.println("id Aula: " + id_aula);
        System.out.println("id_GrupoCurso" + id_cur_grupo);
        //System.out.println("id_ciclo = " + id_ciclo);
        System.out.println("docente = " + id_docente);
        //recuperar toda la fila del aula clase del id 
        cepAulaClass = new CepAulaClass();
        cepAulaClass = gestorAulaClassService.recuperarIdAula(id_aula);
        //recuperar toda la fila del aula clase del id 
        //cepCecCiclo2 = gestorCepCecCicloService.recuperarIdCiclo(id_ciclo);
        //recuperar toda la fila del personnatural como docente del id 
        drtPersonanatural = new DrtPersonanatural();
        drtPersonanatural = gestorUsuarioDocenteService.recuperarIdDocente(id_docente);
        //
        cepCecCurGrup = new CepCecCurGrup();
        cepCecCurGrup = gestorCursoGrupoService.recuperarIdGrupoCurso(id_cur_grupo);

        // setear e ingresar en la tupla
        cepCecCurGrupDet = new CepCecCurGrupDet();
        cepCecCurGrupDet.setCepAulaClass(cepAulaClass);
        //cepCecCurGrupDet.setCepCecCiclo2(cepCecCiclo2);
        cepCecCurGrupDet.setCepCecCurGrup(cepCecCurGrup);
        // seteamos el id de la persona natural que asignaremos como docente
        cepCecCurGrupDet.setIdDir(drtPersonanatural.getIdDir());
        cepCecCurGrupDet.setEstadoCurGrupDet(estado_grupcurdet);
        cepCecCurGrupDet.setFechaI(fecha_inicio);
        //cepCecCurGrupDet.setFechaF(fecha_fin);
        cepCecCurGrupDet = gestorCepCecCurGrupDetalleService.crearNuevoGrupoCurDetalle(cepCecCurGrupDet);
        System.out.println("GUARDO EN DETALLE GRUPO CURSO");
        id_grup_det = cepCecCurGrupDet.getIdCurGrupDet();
    }

    //Creando tupla n la tabla cep_cec_horario
    public void doCrearHorarios() {
        estado_horario = 1;
        System.out.println("ENTRO A CREAR HORARIOS");
        System.out.println(" obtuvo id de horario_dias " + id_horarios_dias);
        System.out.println("Hora inicio " + hora_inicio);
        System.out.println("Hora fin " + hora_fin);
        System.out.println("Estado de horario  " + estado_horario);
        System.out.println("obutvoo id de curso grupos" + id_cur_grupo);
        //recuperar id de curso detalle     
        cepCecCurGrup = new CepCecCurGrup();
        cepCecCurGrup = gestorCursoGrupoService.recuperarIdGrupoCurso(id_cur_grupo);
        cepHorarioDias = new CepHorarioDias();
        cepHorarioDias = gestorCepHorarioDiasService.recuperarIdDiasdeHorario(id_horarios_dias);
        // setear e ingresar en la tupla
        cepCecHorarios = new CepCecHorarios();
        cepCecHorarios.setCepCecCurGrup(cepCecCurGrup);
        cepCecHorarios.setCepHorarioDias(cepHorarioDias);
        cepCecHorarios.setHoraIni(hora_inicio);
        cepCecHorarios.setHoraFin(hora_fin);
        cepCecHorarios.setEstadoHorario(estado_horario);
        // manda la nueva fila al negocio para guardarse
        gestorHorariosService.crearNuevoHorarioCurso(cepCecHorarios);

    }

    //guardar en tabla cur_grup
    public void doCrearGrupo() {
        try {
            System.out.println("ENTRO A crear Grupo");
            estado_grup = 1;
            boolean estado = true;
            System.out.println("secion: " + id_grupo);
            System.out.println("estado: " + estado_grup);
            System.out.println(" fecha inicio: " + fecha_inicio);
            System.out.println("Fecha fin: " + fecha_fin);

            id_curSubdetalle = usuarioController.getId_curso_subdet();
            //  cursoDetController.getId_curso_subdet()

            System.out.println("el id del curso detalle en el controllador de grupo es: " + id_curSubdetalle);

            //recuperar id de curso detalle
            cepCecCursoSubDet = new CepCecCursoSubdet();
            cepCecCursoSubDet = gestorCursoSubDetService.recuperarIdCurSubDet(id_curSubdetalle);
            cepCecGrupo = new CepCecGrupo();
            cepCecGrupo = gestorGrupoService.recuperarIdSeccion(id_grupo);
            cepCecPlan = new CepCecPlan();
            cepCecPlan = gestorPlanService.recuperarIdPlan(usuarioController.id_plan);
            // setear e ingresar en la tupla
            cepCecCurGrup = new CepCecCurGrup();
            cepCecCurGrup.setCepCecCursoSubdet(cepCecCursoSubDet);
            cepCecCurGrup.setIdPlan(cepCecPlan.getIdPlan());
            System.out.println("SETIO BIEN ID DEL CURSO DETALLE");
            cepCecCurGrup.setCepCecGrupo(cepCecGrupo);
            System.out.println("SETIO BIEN ID DEL GRUPO");
            cepCecCurGrup.setFechaInicio(fecha_inicio);
            System.out.println("SETIO BIEN LA FECHA INI");
            cepCecCurGrup.setFechaFin(fecha_fin);
            System.out.println("SETIO BIEN LA FECHA FIN");
            cepCecCurGrup.setEstadoGrupoCab(estado_grup);
            cepCecCurGrup.setEstadoAcademico(estado);
            // manda la nueva fila al negocio para guardarse
            // guarda en el objeto cepCecCurGrup2 lo recien guardado
            cepCecCurGrup2 = new CepCecCurGrup();
            cepCecCurGrup2 = gestorCursoGrupoService.crearNuevoGrupoCurso(cepCecCurGrup);
            id_cur_grupo = cepCecCurGrup2.getIdCurGrup();
            // saveMessage();
            System.out.println("GUARDO DATOS EN TABLA CURSO GRUPO");

        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "Error al tratar de crear grupo", 4);

        }

    }

    // seteamos y guardamos un nuevo registro en la tabla cronograma
    public void doCrearCronograma() {

        try {
            estado_cronograma = 1;
            int tipo_cronograma = 1; // 1: matricula
            Date date = new Date();
            DateFormat horaFecha = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            String fechita = horaFecha.format(date);
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

            try {
                fecha_Registro_cro = formatoDelTexto.parse(fechita);
            } catch (ParseException ex) {
                Logger.getLogger(GrupoCursoController.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("fecha ini crono " + fecha_ini_cro);
            System.out.println("Hora ini crono " + hora_ini_cro);
            System.out.println("Fecha fin crono " + fecha_fin_cro);
            System.out.println("Hora fin crono " + hora_fin_cro);
            System.out.println("Fecha registro crono" + fecha_Registro_cro);
            System.out.println("descripcion cronograma " + descripcion_cronograma);
            System.out.println("estado crono " + estado_cronograma);
            //recuperar id de curso detalle 
            //recuperar id de curso detalle     
            cepCecCurGrup = new CepCecCurGrup();
            cepCecCurGrup = gestorCursoGrupoService.recuperarIdGrupoCurso(id_cur_grupo);
            //cepCecCurGrupDet = gestorCepCecCurGrupDetalleService.recuperarIdGrupoCurso(id_grup_det);
            System.out.println("ultimo cur" + id_cur_grupo);
            //seteamos 
            cepCecCronogramaCab = new CepCecCronogramaCab();
            cepCecCronogramaDet = new CepCecCronogramaDet();
            // cabezera
            cepCecCronogramaCab.setCepCecCurGrup(cepCecCurGrup);
            cepCecCronogramaCab.setEstadoCroCab(estado_cronograma);
            cepCecCronogramaCab.setNumPago(1); // porque se cuando recien se crea el curso
            cepCecCronogramaCab = gestorCronogramasCabService.crearNuevoCronogramaCab(cepCecCronogramaCab);
            //descripcion_cronograma=gestorCronogramasDetService.descripcionCronograma(tipo_cronograma,id_cur_grupo);
            // cepCecCronograma.setCepCecCurGrupDet(cepCecCurGrupDet);
            cepCecCronogramaDet.setCepCecCronogramaCab(cepCecCronogramaCab);
            cepCecCronogramaDet.setFechaIniCro(fecha_ini_cro);
            cepCecCronogramaDet.setFechaFinCro(fecha_fin_cro);
            cepCecCronogramaDet.setFechaRegCro(fecha_Registro_cro);
            cepCecCronogramaDet.setEstadoCroDet(estado_cronograma);
            cepCecCronogramaDet.setHoraIniCro(hora_ini_cro);
            cepCecCronogramaDet.setHoraFinCro(hora_fin_cro);
            cepCecCronogramaDet.setTipoCronograma(tipo_cronograma);
            cepCecCronogramaDet.setDescripcionCro(descripcion_cronograma);
            gestorCronogramasDetService.crearNuevoCronograma(cepCecCronogramaDet);
            System.out.println("REGISTRO CRONOGRAMA");

        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "Error al tratar de crear Cronogama", 4);
        }

    }
    
    public void doCapturarNombre(){
        String nom_curso = cepCecCurGrup.getCepCecCursoSubdet().getCepCecCursoDet().getCepCecCursoCab().getNomCurso();
        if (cepCecCurGrup.getCepCecCursoSubdet().getCepCecCursoDet().getModEnsenanza()==2) {
         nom_curso = "Taller " + nom_curso;   
        }
        System.out.println("EL CURSO ES  : " + nom_curso);
        String nomDesarollo = cepCecCurGrup.getCepCecCursoSubdet().getCepTipoDesarrollo().getNomTipoDes();
        System.out.println("Desarrollo : " + nomDesarollo);
        String nomModalidad = cepCecCurGrup.getCepCecCursoSubdet().getCepEscalaTipomod().getCepTipoModalidad().getNomModalidad();
        System.out.println("Modalidad " + nomModalidad);
        String nom_nivel = cepCecCurGrup.getCepCecCursoSubdet().getCepCecCursoDet().getCepNivel().getNomAbrevNivel();
        System.out.println("Nivel = " + nom_nivel);
        
        nombreFiltro =  nom_curso + " " + nom_nivel + "%"  + "/ " + nomDesarollo + " - " + nomModalidad + "%/ " + cepCecCurGrup.getCepCecGrupo().getNomGrupo();
        
    }

    public void doCapturarGrupo(CepCecCurGrup cepCecCurGrup1) {

        try {
            System.out.println("AQUI TA");
            cepCecCurGrup = new CepCecCurGrup();
            cepCecCurGrup = cepCecCurGrup1;
            cepCecCurGrupDet = new CepCecCurGrupDet();
            cepCecCurGrupDet = gestorCepCecCurGrupDetalleService.capturarDetalle(cepCecCurGrup.getIdCurGrup());
            doCapturarNombre();
            if (cepCecCurGrupDet.getIdDir() != null) {
                usuarioController.setDocenteActual(gestorUsuarioDocenteService.recuperarIdDocente(cepCecCurGrupDet.getIdDir()));
            } else {
                usuarioController.setDocenteActual(null);
            }

            cepCecPlan = gestorPlanService.recuperarIdPlan(cepCecCurGrup.getIdPlan());

            //cepCecCronograma = new CepCecCronograma();
            //cepCecCronograma= gestorCronogramasService.capturarDetalleEnCronograma(cepCecCurGrup.getIdCurGrup());
            id_curSubdetalle = cepCecCurGrup.getCepCecCursoSubdet().getIdCursoSubdet();
            // cepCecInversionCurso = new CepCecInversionCurso();
            //  cepCecInversionCurso = gestorInversionService.recuperarEntidadInversion(cepCecCurGrup.getCepCecCursoSubdet().getIdCursoSubdet());
            id_cur_grupo = cepCecCurGrup.getIdCurGrup();
            //id_grup_det = cepCecCurGrupDet.getIdCurGrupDet();
            this.fecha_inicio = cepCecCurGrup.getFechaInicio();
            this.fecha_fin = cepCecCurGrup.getFechaFin();
          
            //minFechaInicio =  "" + metodosExtras.obtenerFechaActualSinTime();
            fechaActual = new java.util.Date(); //Fecha actual del sistema 

                //fecha = new GregorianCalendar();
               
                minFechaInicio = metodosExtras.doConvertirFechaAhFormatoddMMyyyy(fechaActual);
                System.out.println("min fecha inicio" + minFechaInicio);

        } catch (Exception e) {
        }

    }

    public void doEliminarGrupo() {
        try {

            if (usuarioController.getNum_matriculados() == 0) {
                Short estado = 0;
                cepCecCurGrup = new CepCecCurGrup();
                cepCecCurGrup = gestorCursoGrupoService.recuperarIdGrupoCurso(usuarioController.getId_curso_grupo());
                cepCecCurGrup.setEstadoGrupoCab(estado);
                cepCecCurGrup.setEstadoAcademico(false);
                gestorCursoGrupoService.actualizarEntidad(cepCecCurGrup);
                usuarioController.getFramework().doMensajeF("Exito!", "Grupo Eliminado ", 1);

                this.doBuscarGruposCursos();
            } else {
                System.out.println("No se puede Eliminar el Grupo porque tiene asignado matriculados ");
                usuarioController.getFramework().doMensajeF("Fallo!", "No se puede Eliminar el Grupo porque tiene asignado matriculados ", 4);
            }

        } catch (Exception e) {
            System.out.println("Fallo al tratar de Eliminar Grupo ");
            usuarioController.getFramework().doMensajeF("Error!", "Fallo al tratar de Eliminar Grupo ", 4);

        }

    }

    public void doEliminarGrupoHistorico() {
        try {

            if (usuarioController.getNum_matriculados() == 0) {
                Short estado = 0;
                cepCecCurGrup = new CepCecCurGrup();
                cepCecCurGrup = gestorCursoGrupoService.recuperarIdGrupoCurso(usuarioController.getId_curso_grupo());
                cepCecCurGrup.setEstadoGrupoCab(estado);
                cepCecCurGrup.setEstadoAcademico(false);
                gestorCursoGrupoService.actualizarEntidad(cepCecCurGrup);
                usuarioController.getFramework().doMensajeF("Exito!", "Grupo Eliminado ", 1);

                this.doBuscarGruposCursosHistoricos();
            } else {
                System.out.println("No se puede Eliminar el Grupo porque tiene asignado matriculados ");
                usuarioController.getFramework().doMensajeF("Fallo!", "No se puede Eliminar el Grupo porque tiene asignado matriculados ", 4);
            }

        } catch (Exception e) {
            System.out.println("Fallo al tratar de Eliminar Grupo ");
            usuarioController.getFramework().doMensajeF("Error!", "Fallo al tratar de Eliminar Grupo ", 4);

        }

    }

    public void doCapturarCronograma(CepCecCurGrup cepCecCurGrup1) {

        try {
            cronoActualizado = 0;
            cepCecCurGrup = new CepCecCurGrup();
            cepCecCurGrup = cepCecCurGrup1;
            //cepCecCronograma= gestorCronogramasService.capturarDetalleEnCronograma(cepCecCurGrup.getIdCurGrup());
            lstTipoCronograma = new ArrayList<>();
            lstTipoCronograma = gestorCronogramasDetService.buscarCronogramaPorGrupo(cepCecCurGrup.getIdCurGrup());

            //lstTipoCronograma = gestorCronogramasService.ListarTipoCronograma(lstCronograma);
            cepCecCronogramaDet = new CepCecCronogramaDet();
            //cepCecCronogramaDet = gestorCronogramasDetService.recuperarId(lstTipoCronograma.get(0).getId_cronogramaDet());
        
           
            // 
            if (lstTipoCronograma!=null) {
                // me trae el ultimo cronograma de pago que se hizo y a que pago esta asignado
                  
                cepCecCronogramaDet=gestorCronogramasDetService.recuperarId(lstTipoCronograma.get(lstTipoCronograma.size()-1).getId_cronogramaDet());  
                    id_grup_det = cepCecCronogramaDet.getIdCronogramaDet();
                    this.fecha_fin = cepCecCurGrup.getFechaFin();
                    try {
                    usuarioController.setId_curso_subdet(cepCecCronogramaDet.getCepCecCronogramaCab().getCepCecCurGrup().getCepCecCursoSubdet().getCepCecCursoDet().getIdCursoDet());
                    } catch (Exception e) {
                        usuarioController.getFramework().doMensajeR("Error 15", "Falied!", 4);
                        System.out.println("Error 15!");
                    }
                    
                numpago = cepCecCronogramaDet.getCepCecCronogramaCab().getNumPago();
                ultimeCrono = numpago;
                System.out.println("ultimo pago es" + numpago);
                if ( numpago < cepCecCronogramaDet.getCepCecCronogramaCab().getCepCecCurGrup().getCepCecCursoSubdet().getNumCuotas() ) {
                    int formapago=  cepCecCronogramaDet.getCepCecCronogramaCab().getCepCecCurGrup().getCepCecCursoSubdet().getFormaPago();
                    if (formapago==1) {
                        numpago++;
                        descripcion ="Añadir Cronograma de Pago - Mes "+numpago;
                        descripcion_cronograma = "La cantidad de Meses (Pagos) para este curso o taller es de : ";
                                
                    }else{
                        numpago++;
                        descripcion ="Añadir Cronograma de Pago - Cuota "+numpago;
                        descripcion_cronograma = "La cantidad de Cuotas (Pagos) para este curso o taller es de: ";
                    }   
                }else{
                        numpago = -99;
                        descripcion = "Cronograma de pagos completo";
                }
                
                
            }else{
                numpago = 0;
                descripcion = "Añadir Cronograma de Matricula";
            }
 
        } catch (Exception e) {
            System.out.println("error en capturar cronograma");
        }

    }

   /* public String doCapturarEtapa(CepCecCurGrup grupo) {

        try { //primero su cronograma
            name_etapa = "";
            Short etapa;  // 1: antes   2: En Proceso   3:fin   4: fin del grupo  5:error
            int tipo = 1; //matri = 1    pagos = 2   // al final del for captura el tipo de cronograma, por eso se inicializa en 1 porque el primero será cronograma de matricula
            //ARMO ordenadamente el cronograma en la clase tipocronograma  luego lo recorro
            lstTipoCronograma = new ArrayList<>();
            
            lstTipoCronograma = gestorCronogramasDetService.buscarCronogramaPorGrupo(grupo.getIdCurGrup());
            for (TipoCronograma claseCrono : lstTipoCronograma) {
                etapa = gestorCronogramasDetService.capturarEtapa(claseCrono, grupo);
                if (etapa == 1) {
                    if (claseCrono.getTipo() == 1) { //1:Matricula  2:pago normal  3:pago extemporaneo
                        name_etapa = "Pre-Matricula";
                        break;
                    } else {
                        if (claseCrono.getTipo() == 3 && tipo == 1) { //Si es MATRICULA EXTEMPORANEA 
                            name_etapa = "En Proceso";
                        } else {
                            if (claseCrono.getTipo() == 2) { //
                                name_etapa = "En Proceso";
                            } else {
                                if (claseCrono.getTipo() == 3 && tipo == 2) {
                                    name_etapa = "En Proceso";
                                } else {
                                    name_etapa = "----";
                                }
                            }
                        }
                    }
                } else {
                    if (etapa == 2) {
                        if (claseCrono.getTipo() == 1) { //1:Matricula  2:pago normal  3:pago extemporaneo
                            name_etapa = "Matricula";
                            break;
                        } else {
                            if (claseCrono.getTipo() == 3 && tipo == 1) {
                                name_etapa = "Matricula Extemp.";
                                break;
                            } else {
                                if (claseCrono.getTipo() == 2) {
                                    try {
                                        cepCecCronogramaDet = new CepCecCronogramaDet();
                                        cepCecCronogramaDet = gestorCronogramasDetService.recuperarId(claseCrono.getId_cronogramaDet());
                                        //si la forma de pago es 1 entonces quiere decir que es por mes el pago
                                        if (cepCecCronogramaDet.getCepCecCronogramaCab().getCepCecCurGrup().getCepCecCursoSubdet().getFormaPago() == 1) {
                                            name_etapa = "Pago - " + cepCecCronogramaDet.getCepCecCronogramaCab().getNumPago() + " Mes";
                                        } else {
                                            name_etapa = "Pago - " + cepCecCronogramaDet.getCepCecCronogramaCab().getNumPago() + " Cuota";
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Error en etapas grupo");
                                    }
                                } else {
                                    if (claseCrono.getTipo() == 3 && tipo == 2) {
                                        try {
                                            cepCecCronogramaDet = new CepCecCronogramaDet();
                                            cepCecCronogramaDet = gestorCronogramasDetService.recuperarId(claseCrono.getId_cronogramaDet());
                                            if (cepCecCronogramaDet.getCepCecCronogramaCab().getCepCecCurGrup().getCepCecCursoSubdet().getFormaPago() == 1) {
                                                name_etapa = "Extemp. Pago - " + cepCecCronogramaDet.getCepCecCronogramaCab().getNumPago() + " Mes";
                                            } else {
                                                name_etapa = "Extemp. Pago - " + cepCecCronogramaDet.getCepCecCronogramaCab().getNumPago() + " Cuota";

                                            }
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Error en etapas grupo");
                                        }
                                    } else {
                                        name_etapa = "----";
                                    }
                                }
                            }
                        }
                    } else {
                        if (etapa == 3) {
                            if (claseCrono.getTipo() == 1) { //1:Matricula  2:pago normal  3:pago extemporaneo
                                name_etapa = "En Proceso";
                            } else {
                                if (claseCrono.getTipo() == 3 && tipo == 1) {
                                    name_etapa = "En Proceso";
                                } else {
                                    if (claseCrono.getTipo() == 2) {
                                        name_etapa = "En Proceso";
                                    } else {
                                        if (claseCrono.getTipo() == 3 && tipo == 2) {
                                            name_etapa = "En Proceso";
                                        } else {
                                            name_etapa = "----";
                                        }
                                    }
                                }
                            }
                        } else {
                            if (etapa == 4) {
                                name_etapa = "Fin del Grupo";

                            } else {
                                name_etapa = "----";

                            }
                        }
                    }
                }

                if (claseCrono.getTipo() != 3) {
                    tipo = claseCrono.getTipo(); // al final para coger el anterior cronograma excepto si son extemporaneos **recordar que la lista esta en orden, primero matricula con sus respectivos extemporaneos, luego los pagos tambien con sus respectivos extemporanoes*
                }

            }
            return name_etapa;

        } catch (Exception e) {
            return "Failed!";
        }
    }*/
    
     public String doCapturarEtapa(CepCecCurGrup grupo) {

        try { //primero su cronograma
          
          cepCecCronogramaDet = new CepCecCronogramaDet();
         
            try {
                 cepCecCronogramaDet = gestorCronogramasDetService.encontrarUltimoCronograma(grupo.getIdCurGrup());
            } catch (Exception e) {
                 System.out.println("Null Exception Pointer , No hay ningun cronograma");
                 return "Failed 1!";
            }
            name_etapa = "";
            Short etapa;  // 1: antes   2: En Proceso  3:Fin antes del inicio del grupo  4:fin despues del inicio del gryupo   5: fin del grupo  6:error
            etapa = gestorCronogramasDetService.capturarEtapa(cepCecCronogramaDet, grupo);
           // si es  matricula
            if (cepCecCronogramaDet.getTipoCronograma() == 1) {
                   if (etapa == 1  || etapa==3) {
                        name_etapa = "Pre-Matricula";
                    }else{
                       if (etapa==2) {
                              name_etapa = "Matricula";
                       }else{
                           if (etapa==4) {
                               name_etapa = "En Proceso";
                           }else{
                               if (etapa==5) {
                                     name_etapa = "Fin del Grupo";
                               }else{
                                   //etapa==5
                                     name_etapa="-----!";
                               }
                             
                           }
                       }
                     
                   }
                   
            }else{
                //si es  matricula extemporaneo
                if (cepCecCronogramaDet.getTipoCronograma() == 3 && cepCecCronogramaDet.getCepCecCronogramaCab().getNumPago()==1) {
                    if (etapa == 1  || etapa==3) {
                        name_etapa = "Pre-Matricula";
                    }else{
                       if (etapa==2) {
                              name_etapa = "Matricula Ext.";
                       }else{
                           if (etapa==4) {
                               name_etapa = "En Proceso";
                           }else{
                               if (etapa==5) {
                                     name_etapa = "Fin del Grupo";
                               }else{
                                   //etapa==5
                                     name_etapa="-----!";
                               }
                             
                           }
                       }
                     
                    }
                }else{
                    //si es pago mensual o cuota
                    if (cepCecCronogramaDet.getTipoCronograma() == 2){
                         if (etapa == 1  || etapa==3 || etapa==4) {
                           name_etapa = "En Proceso";
                            }else{
                               if (etapa==2) {
                                      if (cepCecCronogramaDet.getCepCecCronogramaCab().getCepCecCurGrup().getCepCecCursoSubdet().getFormaPago() == 1) {
                                            name_etapa = "Pago - " + cepCecCronogramaDet.getCepCecCronogramaCab().getNumPago() + " Mes";
                                        } else {
                                            name_etapa = "Pago - " + cepCecCronogramaDet.getCepCecCronogramaCab().getNumPago() + " Cuota";
                                        }
                                     
                               }else{
                                   if (etapa==5) {
                                       name_etapa = "Fin del Grupo";
                                   }else{
                                       //etapa==5
                                       name_etapa="-----!";
                                   }
                               }

                           }
                    } else{
                        //si es pago extemporaneo mensual o cuota
                        //cepCecCronogramaDet.getTipoCronograma() == 3
                         if (etapa == 1  || etapa==3 || etapa==4) {
                           name_etapa = "En Proceso";
                            }else{
                               if (etapa==2) {
                                      if (cepCecCronogramaDet.getCepCecCronogramaCab().getCepCecCurGrup().getCepCecCursoSubdet().getFormaPago() == 1) {
                                            name_etapa = "Pago Extem. - " + cepCecCronogramaDet.getCepCecCronogramaCab().getNumPago() + " Mes";
                                        } else {
                                            name_etapa = "Pago Extem - " + cepCecCronogramaDet.getCepCecCronogramaCab().getNumPago() + " Cuota";
                                        }
                                     
                               }else{
                                   if (etapa==5) {
                                       name_etapa = "Fin del Grupo";
                                   }else{
                                       //etapa==5
                                       name_etapa="-----!";
                                   }
                               }

                           }
                    }
                }
                
            }
 
         
            
            
            return name_etapa;
        } catch (Exception e) {
            return "Failed!";
        }
    }
 
     
     public void doActualizarGrupo(){
       usuarioController.setId_curso_subdet(-1);// Solo es una bandera para que se filtren todos los grupos activos
        this.pageNumberGrupo= 1;
        this.doTamanoPaginacionCursoDet();
        this.doBuscarGruposCursos();
     }
     
     
    public void doCapturarTipoCronograma(TipoCronograma entidad) {
        tipoCronograma = new TipoCronograma();
        tipoCronograma = entidad;
        cepCecCronogramaDet = new CepCecCronogramaDet();
        cepCecCronogramaDet = gestorCronogramasDetService.recuperarId(tipoCronograma.getId_cronogramaDet());
        System.out.println("inicializo entidad cronograma" + cepCecCronogramaDet.getIdCronogramaDet());
    }

    public void doModificarCronograma() {
        try {

            System.out.println("inicializo entidad cronograma" + cepCecCronogramaDet.getIdCronogramaDet());
            System.out.println("entro amodificar");
            Date date = new Date();
            fecha_Registro_cro = date;
            cepCecCronogramaDet.setFechaModCro(fecha_Registro_cro);
            gestorCronogramasDetService.actualizarCronograma(cepCecCronogramaDet);
            lstTipoCronograma = new ArrayList<>();
            lstTipoCronograma = gestorCronogramasDetService.buscarCronogramaPorGrupo(cepCecCurGrup.getIdCurGrup());
            //usuarioController.baseController = new fwGeneral2();
            usuarioController.getFramework().doMensajeF("Exito!", "Se modifico pago " + tipoCronograma.getId(), 1);
            cronoActualizado = 1 ;
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "Error al tratar de modificar Cronogama", 4);

        }
    }

    public void doFinalizarCronograma() {
        try {
            // cepCecCronogramaDet = new CepCecCronogramaDet();
            // cepCecCronogramaDet = gestorCronogramasDetService.recuperarId(this.tipoCronograma.getId_cronogramaDet());
            System.out.println("inicializo entidad cronograma" + cepCecCronogramaDet.getIdCronogramaDet());
            metodosExtras = new MetodosExtras();
            cepCecCronogramaDet.setFechaFinCro(metodosExtras.obtenerFechaActualSinTime());
            cepCecCronogramaDet.setHoraFinCro(metodosExtras.obtenerHoraActualSinFecha());
            fechaActual = new Date();
            cepCecCronogramaDet.setFechaModCro(fechaActual);
            gestorCronogramasDetService.actualizarCronograma(cepCecCronogramaDet);

            //cargar lista otra vez
            lstTipoCronograma = new ArrayList<>();
            lstTipoCronograma = gestorCronogramasDetService.buscarCronogramaPorGrupo(cepCecCurGrup.getIdCurGrup());
            usuarioController.getFramework().doMensajeF("Exito!", "El cronograma finalizo " + tipoCronograma.getId(), 1);
            cronoActualizado = 1 ;
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "Error al tratar de finalizar Cronogama", 4);
            System.out.println("error finalizar cronograma");
        }
    }

    ///*************retorna la logica del Service si el cronogramaDet esta en etapa de inicio para el pago 
    // entonces se deshabiltia la opcion de editar , retorna 1 si se deshabilita y 0 si se puede editar
    public Short doDeshabilitarEditCronograma(TipoCronograma entidad) {
        tipoCronograma = new TipoCronograma();
        tipoCronograma = entidad;
        System.out.println("esta en controller");
        habilitarEditCro = gestorCronogramasDetService.DesHabilitarEditCronograma(tipoCronograma.getId_cronogramaDet());
        return habilitarEditCro;
    }

    public int doDesahabilitarCrearExtemporaneo() {
        metodosExtras = new MetodosExtras();
        if (fecha_fin != null) {
            if (metodosExtras.obtenerFechaActualSinTime().before(fecha_fin) || metodosExtras.obtenerFechaActualSinTime().equals(fecha_fin)) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 0;
        }

    }

    public void doCrearExtemporaneo() {
        try {
            System.out.println("assdsd");
            estado_cronograma = 1;
            Integer tipo_cronograma = 3; // 1: inscripcion 2>pagos 3:extemporaneo
            Date date = new Date();
            fecha_Registro_cro = date;
            cepCecCronogramaCab = new CepCecCronogramaCab();
            // obtien la entida cabecera
            cepCecCronogramaCab = cepCecCronogramaDet.getCepCecCronogramaCab();
            cepCecCronogramaDet = new CepCecCronogramaDet();
            cepCecCronogramaDet.setCepCecCronogramaCab(cepCecCronogramaCab);
            cepCecCronogramaDet.setTipoCronograma(tipo_cronograma);
            cepCecCronogramaDet.setFechaIniCro(fecha_ini_cro);
            cepCecCronogramaDet.setHoraIniCro(hora_ini_cro);
            cepCecCronogramaDet.setFechaFinCro(fecha_fin_cro);
            cepCecCronogramaDet.setHoraFinCro(hora_fin_cro);
            cepCecCronogramaDet.setEstadoCroDet(estado_cronograma);
            cepCecCronogramaDet.setFechaRegCro(fecha_Registro_cro);
            gestorCronogramasDetService.crearNuevoCronograma(cepCecCronogramaDet);
            lstTipoCronograma = new ArrayList<>();
            lstTipoCronograma = gestorCronogramasDetService.buscarCronogramaPorGrupo(cepCecCurGrup.getIdCurGrup());
            // usuarioController.baseController = new fwGeneral2();
            usuarioController.getFramework().doMensajeF("Exito!", "Se agrego pago extemporaneo ", 1);
            System.out.println("adminitod");
            cronoActualizado= 1;
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "Error al tratar de crear Extemporaneo", 4);

        }

    }

    public void doOcultarCronograma() {
        try {
            
            
             estado_cronograma = 0;
        cepCecCronogramaDet.setEstadoCroDet(estado_cronograma);
        gestorCronogramasDetService.actualizarCronograma(cepCecCronogramaDet);
        
        if (cepCecCronogramaDet.getTipoCronograma()!=3) { //osea extemporaneo
            cepCecCronogramaCab = new CepCecCronogramaCab();
        cepCecCronogramaCab = gestorCronogramasCabService.recuperarId(cepCecCronogramaDet.getCepCecCronogramaCab().getIdCronogramaCab());
        cepCecCronogramaCab.setEstadoCroCab(estado_cronograma);
        gestorCronogramasCabService.actualizarCronogramaCab(cepCecCronogramaCab);
        //usuarioController.baseController = new fwGeneral2();
       cronoActualizado = 1;
        System.out.println("Se oculto ");
            
        }
       usuarioController.getFramework().doMensajeF("Exito!", "Se borro correctamente", 1);
        //lstTipoCronograma = new ArrayList<>();
       // lstTipoCronograma = gestorCronogramasDetService.buscarCronogramaPorGrupo(cepCecCurGrup.getIdCurGrup());
        
          /////////////////-----------------cargar----------------
        this.docargarTipoCronogramas();
            
        } catch (Exception e) {
        }
       

    }

    public void doCrearCronoPagos() {
        Integer cuotas = cepCecCronogramaDet.getCepCecCronogramaCab().getCepCecCurGrup().getCepCecCursoSubdet().getNumCuotas();
        System.out.println("*********************************numero de cuotas es************** " + cuotas);
        System.out.println("el tamaño es de");
        //*** recorro la lista que se cargo anterioremente en caputrarTipoCronograma , y veo el tamano acutal
        // sincontar si es de tipo 3 que viene hacer los cronogramas extemporaneaos o de casos spesciales
        Integer tamanoActual = 0;
        for (TipoCronograma item : lstTipoCronograma) {
            if (item.getTipo() != 3) {
                tamanoActual++;
            }
        }

        if (fecha_ini_cro.before(fecha_fin) && (fecha_fin_cro.before(fecha_fin) || fecha_fin_cro.equals(fecha_fin))) {
            if (tamanoActual < cuotas) {
                System.out.println("assdsd");
                estado_cronograma = 1;
                Integer tipo_cronograma = 2; // 1: inscripcion 2>pagos 
                Date date = new Date();
                fecha_Registro_cro = date;
                cepCecCronogramaDet = new CepCecCronogramaDet();
                cepCecCronogramaCab = new CepCecCronogramaCab();
                cepCecCronogramaCab.setCepCecCurGrup(cepCecCurGrup);
                cepCecCronogramaCab.setEstadoCroCab(estado_cronograma);
                // vemos que pago es
                Integer numcuota = gestorCronogramasCabService.buscarNumPago(cepCecCurGrup.getIdCurGrup());
                cepCecCronogramaCab.setNumPago(numcuota);
                cepCecCronogramaCab = gestorCronogramasCabService.crearNuevoCronogramaCab(cepCecCronogramaCab);
                //**** crear detalle***////
                cepCecCronogramaDet.setCepCecCronogramaCab(cepCecCronogramaCab);
                cepCecCronogramaDet.setTipoCronograma(tipo_cronograma);
                cepCecCronogramaDet.setFechaIniCro(fecha_ini_cro);
                cepCecCronogramaDet.setHoraIniCro(hora_ini_cro);
                cepCecCronogramaDet.setFechaFinCro(fecha_fin_cro);
                cepCecCronogramaDet.setHoraFinCro(hora_fin_cro);
                cepCecCronogramaDet.setEstadoCroDet(estado_cronograma);
                cepCecCronogramaDet.setFechaRegCro(fecha_Registro_cro);
                gestorCronogramasDetService.crearNuevoCronograma(cepCecCronogramaDet);
                lstTipoCronograma = new ArrayList<>();
                lstTipoCronograma = gestorCronogramasDetService.buscarCronogramaPorGrupo(cepCecCurGrup.getIdCurGrup());
              
                        
                //usuarioController.baseController = new fwGeneral2();
                usuarioController.getFramework().doMensajeF("Exito!", "Se agrego pago", 1);
                System.out.println("adminitod");
                cronoActualizado = 1;
            } else {
                //usuarioController.baseController = new fwGeneral2();
                usuarioController.getFramework().doMensajeF("Error!", "El numero de pagos esta completo", 4);
                
                System.out.println("No es adminitod");
            }
        } else {
            usuarioController.getFramework().doMensajeF("Error!", "Las fechas ingresadas no estan en el rango permitido por el grupo", 4);

            System.out.println("No es adminitod");
        }
          /////////////////-----------------cargar----------------
        this.docargarTipoCronogramas();

    }
    
    
    public void docargarTipoCronogramas(){
          /////////////////-----------------cargar----------------
        try {
             //cepCecCronograma= gestorCronogramasService.capturarDetalleEnCronograma(cepCecCurGrup.getIdCurGrup());
             lstTipoCronograma = new ArrayList<>();
             lstTipoCronograma = gestorCronogramasDetService.buscarCronogramaPorGrupo(cepCecCurGrup.getIdCurGrup());

              if (lstTipoCronograma!=null) {
                // me trae el ultimo cronograma de pago que se hizo y a que pago esta asignado
                  
                cepCecCronogramaDet=gestorCronogramasDetService.recuperarId(lstTipoCronograma.get(lstTipoCronograma.size()-1).getId_cronogramaDet());  
                numpago = cepCecCronogramaDet.getCepCecCronogramaCab().getNumPago();
                ultimeCrono = numpago;
                if ( numpago < cepCecCronogramaDet.getCepCecCronogramaCab().getCepCecCurGrup().getCepCecCursoSubdet().getNumCuotas() ) {
                    int formapago=  cepCecCronogramaDet.getCepCecCronogramaCab().getCepCecCurGrup().getCepCecCursoSubdet().getFormaPago();
                    if (formapago==1) {
                        numpago++;
                        descripcion ="Añadir Cronograma de Pago - Mes "+numpago;
                    }else{
                        numpago++;
                        descripcion ="Añadir Cronograma de Pago - Cuota "+numpago;
                    }   
                }else{
                        numpago = -99;
                        descripcion = "Cronograma de pagos completos";
                }
                
                
            }else{
                numpago = 0;
                descripcion = "Añadir Cronograma de Matricula";
            }
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Erro!", "No hay cronogramas", 4);
        }
     
        
    }

    public void doCaputrarHorario(CepCecCurGrup cepCecCurGrup1) {
        System.out.println("");
        cepCecCurGrup = new CepCecCurGrup();
        cepCecCurGrup = cepCecCurGrup1;
        cepCecHorarios = new CepCecHorarios();
        cepCecHorarios = gestorHorariosService.capturarIdHorario(cepCecCurGrup.getIdCurGrup());
          this.hora_inicio = cepCecHorarios.getHoraIni();
          this.hora_fin = cepCecHorarios.getHoraFin();
          this.id_horarios_dias = cepCecHorarios.getCepHorarioDias().getIdHorarioDias();
        //usuarioController.setId_curso_subdet(cepCecCurGrup.getCepCecCursoSubdet().getIdCursoSubdet());
    }

    public Integer doFindDocenteEnGrupo() {
        if (gestorCepCecCurGrupDetalleService.buscarDocentes(id_cur_grupo) == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public Integer doBuscarLaboratorioEnGrupo() {
        if (gestorCepCecCurGrupDetalleService.buscarLaboratoriosAsignados(id_cur_grupo) == 1) {
            return 1; // encontro
        } else {
            return 0; // no enctorno
        }
    }

    public Integer doVerificarSiFaltanDatos(CepCecCurGrup item) {
        if (gestorCepCecCurGrupDetalleService.buscarLaboratoriosAsignados(item.getIdCurGrup()) == 1 && gestorCepCecCurGrupDetalleService.buscarDocentes(item.getIdCurGrup()) == 1) {
            return verificarSiFaltaDocente = 1; // No faltan datos
        } else {
            return verificarSiFaltaDocente = 0; // Si faltan datos
        }
    }

    /*  
    public void doCompruebaSiPlanEstaAsignadoAhGrupo(){
        // If the return is 0 then in the view createPlan.xhtml its sesion and themes, the edit button is going to be disabled
        // but the return is 1 then the button is going to be enabled
        System.out.println("controller group id_plan es "+usuarioController.id_plan);
        usuarioController.editPlan = gestorCursoGrupoService.compruebaSiPlanEstaAsignadoAhGrupo(usuarioController.id_plan);
        System.out.println("el edita plan es "+usuarioController.editPlan);
    }
    
     */
    public Integer doCompruebaSiPlanEstaAsignadoAhGrupo(Integer id_planSelect) {
        // If the return is 0 then in the view createPlan.xhtml its sesion and themes, the edit button is going to be disabled
        // but the return is 1 then the button is going to be enabled

        if (gestorCursoGrupoService.compruebaSiPlanEstaAsignadoAhGrupo(id_planSelect) == 1) {
            return 1;
        } else {
            return 0;
        }

    }

    public Integer doCompruebaSiPlanActivoEstaAsignadoAhGrupo(Integer id_curso) {
        //este metodo se usa para saber si el plan esta asignado o no para un grupo
        // sino lo esta, entonces no se puede crear otro plan
        //pero si esta asignado entonces si se puede crear otro plan
        CepCecPlan plan = gestorPlanService.buscarPlanActual(id_curso);
        int idplancapturado = 0;
        if (plan != null) {
            idplancapturado = plan.getIdPlan();
        }

        return doCompruebaSiPlanEstaAsignadoAhGrupo(idplancapturado);
    }

    public void doGuardarDocentePostMatricula() {
        try {
            cepCecCurGrupDet.setIdDir(drtPersonanatural.getIdDir());
            gestorCepCecCurGrupDetalleService.actualizarGrupodet(cepCecCurGrupDet);
            usuarioController.setDocenteActual(gestorUsuarioDocenteService.recuperarIdDocente(drtPersonanatural.getIdDir()));
            System.out.println("se guardo docente");
            usuarioController.getFramework().doMensajeF("Exito!", "Se asigno docente al grupo", 1);
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "No se asigno docente al grupo", 4);
        }

    }

    public void doModificarLaboratorio() {

        try {
            cepCecCurGrupDet.setCepAulaClass(cepAulaClass);
            gestorCepCecCurGrupDetalleService.actualizarGrupodet(cepCecCurGrupDet);
            System.out.println("se guardo docente");
            usuarioController.getFramework().doMensajeF("Exito!", "Se asigno laboratorio al grupo", 1);
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "No se asigno laboratorio al grupo", 4);

        }

    }
    
     public void doModificarFechas() {

        try {
            
             cepCecCurGrup.setFechaInicio(fecha_inicio);
             cepCecCurGrup.setFechaFin(fecha_fin);
             gestorCursoGrupoService.actualizarEntidad(cepCecCurGrup);
            //cepCecCurGrupDet.setCepAulaClass(cepAulaClass);
           // cepCecCurGrupDet.setFechaI(this.fecha_inicio);
            //cepCecCurGrupDet.setFechaF(this.fecha_fin);
            //gestorCepCecCurGrupDetalleService.actualizarGrupodet(cepCecCurGrupDet);
           // System.out.println("se guardo docente");
            usuarioController.getFramework().doMensajeF("Exito!", "Se edito la fechas de inicio y/o fin del grupo", 1);
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "No se pudo editar fecha al grupo", 4);

        }

    }
     
     public void doModificarHorario() {

        try {
            cepCecHorarios.setHoraIni(this.hora_inicio);
            cepCecHorarios.setHoraFin(this.hora_fin);
            cepHorarioDias = new CepHorarioDias();
            cepHorarioDias = gestorCepHorarioDiasService.recuperarIdDiasdeHorario(id_horarios_dias);
            cepCecHorarios.setCepHorarioDias(cepHorarioDias);
            gestorHorariosService.actualizarTema(cepCecHorarios);
            //cepCecCurGrupDet.setCepAulaClass(cepAulaClass);
            //cepCecCurGrupDet.setFechaI(this.fecha_inicio);
            //cepCecCurGrupDet.setFechaF(this.fecha_fin);
            //gestorCepCecCurGrupDetalleService.actualizarGrupodet(cepCecCurGrupDet);
           // System.out.println("se guardo docente");
            usuarioController.getFramework().doMensajeF("Exito!", "Se edito la fechas de inicio y/o fin del grupo", 1);
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "No se pudo editar fecha al grupo", 4);

        }

    }

    public void doEstadoAcademico(CepCecCurGrup cepCecCurGrup1) {

        System.out.println("AQUI TA");
        try {
            cepCecCurGrup = new CepCecCurGrup();
            cepCecCurGrup = cepCecCurGrup1;
            id_cur_grupo = cepCecCurGrup.getIdCurGrup(); // por si se pierde la comunicacion de la entidad con la base de datos
            usuarioController.setId_curso_grupo(cepCecCurGrup.getIdCurGrup());
            estadoAcademico = cepCecCurGrup.getEstadoAcademico();
            System.out.println("estado academico actual = " + estadoAcademico);
        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "Error al tratar de cambiar estado academico de Grupo", 4);
        }

    }

    public void doFinalizarGrupo() {
        //cambia el estado academico
        try {
            if (!estadoAcademico) {
                cepCecCurGrup = new CepCecCurGrup();
                cepCecCurGrup = gestorCursoGrupoService.recuperarIdGrupoCurso(id_cur_grupo);
                cepCecCurGrup.setEstadoAcademico(false);
                gestorCursoGrupoService.actualizarEntidad(cepCecCurGrup);
                usuarioController.getFramework().doMensajeF("Grupo Finalizado", "El Grupo ahora se podra visualizar como Historico", 1);
                this.doBuscarGruposCursos();
            } else {
                
                if (estadoAcademico) {
                    cepCecCurGrup = new CepCecCurGrup();
                    cepCecCurGrup = gestorCursoGrupoService.recuperarIdGrupoCurso(id_cur_grupo);
                    cepCecCurGrup.setEstadoAcademico(true);
                    gestorCursoGrupoService.actualizarEntidad(cepCecCurGrup);
                    usuarioController.getFramework().doMensajeF("Grupo Reactivado", "El Grupo ahora se podra visualizar como Activos", 1);
                    this.doBuscarGruposCursosHistoricos();
                }else{
                              usuarioController.getFramework().doMensajeF("Aviso", "No se hicieron cambios", 1);
                }
      

            }

        } catch (Exception e) {
            usuarioController.getFramework().doMensajeF("Error!", "Error al tratar de finalizar Grupo", 4);

        }

    }

    public Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    // para arreglar que se suma en la vista 5
    public Date doArreglandoFormatoTime(Date hora) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(hora);
        calendar.add(Calendar.HOUR, -05);
        return calendar.getTime();
    }

    public String doFormatoTime(Date hora) {

        Date hora_con_formato = null;

        DateFormat horaFecha = new SimpleDateFormat("h:mm a");
        String fechita = horaFecha.format(hora);
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("h:mm a");

        try {
            //hora_con_formato=  // formatoDelTexto.parse(fechita);
            formatoDelTexto.format(hora);
        } catch (Exception ex) {
            Logger.getLogger(GrupoCursoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formatoDelTexto.format(hora);
    }

    // Caputra id de la tabla Curso Grupo   
    /* public void doCapturarIdCurGrup() {
        id_cur_grupo = SelectedListCurGrup.getIdCurGrup();
        System.out.println("Obtuvo el id de GRUPO CURSO " + id_cur_grupo);
    }*/
    //evento para la fecha inicio y fin del curso
    public void onDateSelectGrupo(SelectEvent event) {
        fechaActual = new java.util.Date(); //Fecha actual del sistema 

        fecha = new GregorianCalendar();
        Calendar fechaSelect;
        fechaSelect = toCalendar(fecha_inicio);
        System.out.println("entro al eEEEEEEEEEEEEEEE");
        minFechaFin = fechaSelect.get(Calendar.DAY_OF_MONTH) + "/" + (fecha_inicio.getMonth() + 1) + "/" + (fecha_inicio.getYear() - 100);
        System.out.println("min fecha" + minFechaFin);

    }

    // restringe que la hora fin no sea menor a la hora inicio
    public void onTimeSelectHorario(SelectEvent event) {
        minHoraFinHorario = hora_inicio.getHours();
        minMinuteFinHorario = hora_inicio.getMinutes();
    }

    // evento que hace influye en la hora fin , resetenado a cero los minutos si es mayor a la hora inicio
    public void onTimeSelectHorarioFin(SelectEvent event) {

        if (hora_fin.getHours() > hora_inicio.getHours()) {
            minMinuteFinHorario = 0;
        } else {

            minMinuteFinHorario = hora_inicio.getMinutes();
        }
    }

    // preapara las variables para validar fecha y hora en grupo
    public void doInicializacionValidacionDates() {
        drtPersonanatural = new DrtPersonanatural();
        id_docente = 0;
        num_dni = null;
        System.out.println("entro a before cronograma");
        fecha = new GregorianCalendar();
        fechaActual = new java.util.Date(); //Fecha actual del sistema 
        monthActual = fechaActual.getMonth() + 1;
        yearActual = fechaActual.getYear() - 100;
        dayActual = fecha.get(Calendar.DAY_OF_MONTH);
        MinDia = dayActual + "/" + monthActual + "/" + yearActual;
        FFMinDia = MinDia; // minimo de dia de fecha fin
        // variables que valida en la fecha de inicio y fin del curso 
        minFechaInicio = MinDia;
        minFechaFin = FFMinDia;
        System.out.println(MinDia);

        hora_actual = fechaActual.getHours();
        minute_actual = fechaActual.getMinutes();
        hora = hora_actual;
        minute = minute_actual;
        hora_f = hora_actual;
        minute_f = minute_actual;

        fecha_ini_cro = null;
        fecha_fin_cro = null;
        hora_ini_cro = null;
        hora_fin_cro = null;

        minHoraFinHorario = 0;
        minMinuteFinHorario = 0;
        
        
    }

    public void onDateSelect(SelectEvent event) {

        fechaActual = new java.util.Date(); //Fecha actual del sistema 
        fecha = new GregorianCalendar();
        Calendar fechaSelect;
        fechaSelect = toCalendar(fecha_ini_cro);
        monthActual = fechaActual.getMonth() + 1;
        yearActual = fechaActual.getYear() - 100;
        dayActual = fecha.get(Calendar.DAY_OF_MONTH);

        daySelect = fechaSelect.get(Calendar.DAY_OF_MONTH);
        monthSelect = fecha_ini_cro.getMonth() + 1;
        yearSelect = fecha_ini_cro.getYear() - 100;
        FFMinDia = daySelect + "/" + monthSelect + "/" + yearSelect;
        // si la fecha selecciona es igual a la actual se pone las horas exactas
        if ((daySelect == dayActual) && (monthActual == monthSelect) && (yearActual == yearSelect)) {
            hora_actual = fechaActual.getHours();
            minute_actual = fechaActual.getMinutes();
            hora = hora_actual;
            minute = minute_actual;

        } else {
            hora = 0;
            minute = 0; // si es otro dia entonces la hora y minutos se restablecen a 00:00

        }
        hora_f = hora;
        minute_f = minute;
        //  ff=null;
        //  hi=null;
        //  hf=null;
    }

    public void onSelectFechaFin(SelectEvent event) {

        Calendar fechaSelect;
        fechaSelect = toCalendar(fecha_fin_cro);
        System.out.println("va entrar");
        if (daySelect == fechaSelect.get(Calendar.DAY_OF_MONTH) && monthSelect == (fecha_fin_cro.getMonth() + 1) && yearSelect == (fecha_fin_cro.getYear() - 100)) {
            System.out.println("dias dias iguales");
            hora_f = hora_ini_cro.getHours();
            minute_f = hora_ini_cro.getMinutes();

        } else {

            hora_f = 0;
            minute_f = 0;
        }

        // hf=null;
    }

    public void onTimeSelectInicio(SelectEvent event) {
        fechaActual = new java.util.Date(); //Fecha actual del sistema 
        if ((daySelect == dayActual) && (monthActual == monthSelect) && (yearActual == yearSelect)) {
            if (hora_ini_cro.getHours() > fechaActual.getHours()) {
                minute = 0;
            } else {
                minute = fechaActual.getMinutes();
            }
        } else {
            minute = 0;
        }

        hora_f = hora_ini_cro.getHours();
        minute_f = hora_ini_cro.getMinutes();
        // hf = null;

    }

    public void onTimeSelectFinal(SelectEvent event) {
        fechaActual = new java.util.Date(); //Fecha actual del sistema 
        Calendar fechaSelect;
        fechaSelect = toCalendar(fecha_fin_cro);

        if (daySelect == fechaSelect.get(Calendar.DAY_OF_MONTH) && monthSelect == (fecha_fin_cro.getMonth() + 1) && yearSelect == (fecha_fin_cro.getYear() - 100)) {

            hora_f = hora_ini_cro.getHours();
            minute_f = hora_ini_cro.getMinutes();

            if (hora_fin_cro.getHours() > hora_ini_cro.getHours()) {
                minute_f = 0;
            } else {
                minute_f = hora_ini_cro.getMinutes();
            }
        } else {
            hora_f = 0;
            minute_f = 0;

        }

    }

    public void redireccionAhGroupCursoDesdeCreate(){
        this.pageNumberGrupo= 1;
        this.doTamanoPaginacionCursoDet();
        this.doBuscarGruposCursos();
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/Grupos.xhtml";
        redireccionado(direccionar);
    }
    
    public void redireccionAhGroupCurso() {
        usuarioController.setId_curso_subdet(-1);// Solo es una bandera para que se filtren todos los grupos activos
        this.pageNumberGrupo= 1;
        this.doTamanoPaginacionCursoDet();
        this.doBuscarGruposCursos();
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/Grupos.xhtml";
        redireccionado(direccionar);
    }

    public void redireccionAhGroupCursoHistorico() {
        usuarioController.setId_curso_subdet(-2);// Solo es una bandera para que se filtren todos los grupos historicos
        this.doBuscarGruposCursosHistoricos();
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Cursos/GruposHistoricos.xhtml";
        redireccionado(direccionar);
    }

    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Guardado Exitoso", "Se guardo con exito en la base de datos"));

    }

    //5. Metodos Get y Set
    public List<CurGrupDetDoc> getLstDocCurGrupDet() {
        return lstDocCurGrupDet;
    }

    public void setLstDocCurGrupDet(List<CurGrupDetDoc> lstDocCurGrupDet) {
        this.lstDocCurGrupDet = lstDocCurGrupDet;
    }

    public List<CepAulaClass> getLstAula() {
        return lstAula;
    }

    public void setLstAula(List<CepAulaClass> lstAula) {
        this.lstAula = lstAula;
    }

    public int getId_aula() {
        return id_aula;
    }

    public void setId_aula(int id_aula) {
        this.id_aula = id_aula;
    }

    public CepAulaClass getCepAulaClass() {
        return cepAulaClass;
    }

    public void setCepAulaClass(CepAulaClass cepAulaClass) {
        this.cepAulaClass = cepAulaClass;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public List<CepCecGrupo> getLstGrupo() {
        return lstGrupo;
    }

    public void setLstGrupo(List<CepCecGrupo> lstGrupo) {
        this.lstGrupo = lstGrupo;
    }

    public CepCecGrupo getCepCecGrupo() {
        return cepCecGrupo;
    }

    public void setCepCecGrupo(CepCecGrupo cepCecGrupo) {
        this.cepCecGrupo = cepCecGrupo;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public Short getEstado_grup() {
        return estado_grup;
    }

    public void setEstado_grup(Short estado_grup) {
        this.estado_grup = estado_grup;
    }

    public CepCecCurGrup getCepCecCurGrup() {
        return cepCecCurGrup;
    }

    public void setCepCecCurGrup(CepCecCurGrup cepCecCurGrup) {
        this.cepCecCurGrup = cepCecCurGrup;
    }

    public List<CepCecCurGrup> getLstGrupoCur() {
        return lstGrupoCur;
    }

    public void setLstGrupoCur(List<CepCecCurGrup> lstGrupoCur) {
        this.lstGrupoCur = lstGrupoCur;
    }

    public int getId_cur_grupo() {
        return id_cur_grupo;
    }

    public void setId_cur_grupo(int id_cur_grupo) {
        this.id_cur_grupo = id_cur_grupo;
    }

    public CepCecCurGrup getCepCecCurGrup2() {
        return cepCecCurGrup2;
    }

    public void setCepCecCurGrup2(CepCecCurGrup cepCecCurGrup2) {
        this.cepCecCurGrup2 = cepCecCurGrup2;
    }

    public Short getEstado_grupcurdet() {
        return estado_grupcurdet;
    }

    public void setEstado_grupcurdet(Short estado_grupcurdet) {
        this.estado_grupcurdet = estado_grupcurdet;
    }

    public CepCecCurGrupDet getCepCecCurGrupDet() {
        return cepCecCurGrupDet;
    }

    public void setCepCecCurGrupDet(CepCecCurGrupDet cepCecCurGrupDet) {
        this.cepCecCurGrupDet = cepCecCurGrupDet;
    }

    public int getId_horarios_dias() {
        return id_horarios_dias;
    }

    public void setId_horarios_dias(int id_horarios_dias) {
        this.id_horarios_dias = id_horarios_dias;
    }

    public String getNombreHorarioDias() {
        return nombreHorarioDias;
    }

    public void setNombreHorarioDias(String nombreHorarioDias) {
        this.nombreHorarioDias = nombreHorarioDias;
    }

    public CepHorarioDias getCepHorarioDias() {
        return cepHorarioDias;
    }

    public void setCepHorarioDias(CepHorarioDias cepHorarioDias) {
        this.cepHorarioDias = cepHorarioDias;
    }

    public List<CepHorarioDias> getLstHorarioDias() {
        return lstHorarioDias;
    }

    public void setLstHorarioDias(List<CepHorarioDias> lstHorarioDias) {
        this.lstHorarioDias = lstHorarioDias;
    }

    public Date getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Date getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Date hora_fin) {
        this.hora_fin = hora_fin;
    }

    public Short getEstado_horario() {
        return estado_horario;
    }

    public void setEstado_horario(Short estado_horario) {
        this.estado_horario = estado_horario;
    }

    public CepCecHorarios getCepCecHorarios() {
        return cepCecHorarios;
    }

    public void setCepCecHorarios(CepCecHorarios cepCecHorarios) {
        this.cepCecHorarios = cepCecHorarios;
    }

    public CepCecCursoSubdet getCepCecCursoSubDet() {
        return cepCecCursoSubDet;
    }

    public void setCepCecCursoSubDet(CepCecCursoSubdet cepCecCursoSubDet) {
        this.cepCecCursoSubDet = cepCecCursoSubDet;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public GestorAulaClassServiceLocal getGestorAulaClassService() {
        return gestorAulaClassService;
    }

    public void setGestorAulaClassService(GestorAulaClassServiceLocal gestorAulaClassService) {
        this.gestorAulaClassService = gestorAulaClassService;
    }

    public GestorGrupoServiceLocal getGestorGrupoService() {
        return gestorGrupoService;
    }

    public void setGestorGrupoService(GestorGrupoServiceLocal gestorGrupoService) {
        this.gestorGrupoService = gestorGrupoService;
    }

    public GestorCursoGrupoServiceLocal getGestorCursoGrupoService() {
        return gestorCursoGrupoService;
    }

    public void setGestorCursoGrupoService(GestorCursoGrupoServiceLocal gestorCursoGrupoService) {
        this.gestorCursoGrupoService = gestorCursoGrupoService;
    }

    public GestorCepHorarioDiasServiceLocal getGestorCepHorarioDiasService() {
        return gestorCepHorarioDiasService;
    }

    public void setGestorCepHorarioDiasService(GestorCepHorarioDiasServiceLocal gestorCepHorarioDiasService) {
        this.gestorCepHorarioDiasService = gestorCepHorarioDiasService;
    }

    public GestorHorariosServiceLocal getGestorHorariosService() {
        return gestorHorariosService;
    }

    public void setGestorHorariosService(GestorHorariosServiceLocal gestorHorariosService) {
        this.gestorHorariosService = gestorHorariosService;
    }

    public DrtPersonanatural getDrtPersonanatural() {
        return drtPersonanatural;
    }

    public void setDrtPersonanatural(DrtPersonanatural drtPersonanatural) {
        this.drtPersonanatural = drtPersonanatural;
    }

    public List<DrtPersonanatural> getLstDocente() {
        return lstDocente;
    }

    public void setLstDocente(List<DrtPersonanatural> lstDocente) {
        this.lstDocente = lstDocente;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public GestorUsuarioDocenteServiceLocal getGestorUsuarioDocenteService() {
        return gestorUsuarioDocenteService;
    }

    public void setGestorUsuarioDocenteService(GestorUsuarioDocenteServiceLocal gestorUsuarioDocenteService) {
        this.gestorUsuarioDocenteService = gestorUsuarioDocenteService;
    }

    public GestorCepCecCurGrupDetalleServiceLocal getGestorCepCecCurGrupDetalleService() {
        return gestorCepCecCurGrupDetalleService;
    }

    public void setGestorCepCecCurGrupDetalleService(GestorCepCecCurGrupDetalleServiceLocal gestorCepCecCurGrupDetalleService) {
        this.gestorCepCecCurGrupDetalleService = gestorCepCecCurGrupDetalleService;
    }

    public Short getEstado_cronograma() {
        return estado_cronograma;
    }

    public void setEstado_cronograma(Short estado_cronograma) {
        this.estado_cronograma = estado_cronograma;
    }

    public Date getFecha_ini_cro() {
        return fecha_ini_cro;
    }

    public void setFecha_ini_cro(Date fecha_ini_cro) {
        this.fecha_ini_cro = fecha_ini_cro;
    }

    public Date getFecha_fin_cro() {
        return fecha_fin_cro;
    }

    public void setFecha_fin_cro(Date fecha_fin_cro) {
        this.fecha_fin_cro = fecha_fin_cro;
    }

    public Date getFecha_Registro_cro() {
        return fecha_Registro_cro;
    }

    public void setFecha_Registro_cro(Date fecha_Registro_cro) {
        this.fecha_Registro_cro = fecha_Registro_cro;
    }

    public String getDescripcion_cronograma() {
        return descripcion_cronograma;
    }

    public void setDescripcion_cronograma(String descripcion_cronograma) {
        this.descripcion_cronograma = descripcion_cronograma;
    }

    public int getId_cronograma() {
        return id_cronograma;
    }

    public void setId_cronograma(int id_cronograma) {
        this.id_cronograma = id_cronograma;
    }

    public Date getHora_ini_cro() {
        return hora_ini_cro;
    }

    public void setHora_ini_cro(Date hora_ini_cro) {
        this.hora_ini_cro = hora_ini_cro;
    }

    public Date getHora_fin_cro() {
        return hora_fin_cro;
    }

    public void setHora_fin_cro(Date hora_fin_cro) {
        this.hora_fin_cro = hora_fin_cro;
    }

    public String getNom_grupo() {
        return nom_grupo;
    }

    public void setNom_grupo(String nom_grupo) {
        this.nom_grupo = nom_grupo;
    }

    public CepCecCronogramaDet getCepCecCronogramaDet() {
        return cepCecCronogramaDet;
    }

    public void setCepCecCronogramaDet(CepCecCronogramaDet cepCecCronogramaDet) {
        this.cepCecCronogramaDet = cepCecCronogramaDet;
    }

    public List<CepCecCronogramaDet> getLstCronograma() {
        return lstCronograma;
    }

    public void setLstCronograma(List<CepCecCronogramaDet> lstCronograma) {
        this.lstCronograma = lstCronograma;
    }

    public GestorCronogramasDetServiceLocal getGestorCronogramasDetService() {
        return gestorCronogramasDetService;
    }

    public void setGestorCronogramasDetService(GestorCronogramasDetServiceLocal gestorCronogramasDetService) {
        this.gestorCronogramasDetService = gestorCronogramasDetService;
    }

    public List<CepCecHorarios> getLstHorarios() {
        return lstHorarios;
    }

    public void setLstHorarios(List<CepCecHorarios> lstHorarios) {
        this.lstHorarios = lstHorarios;
    }

    public int getId_curSubdetalle() {
        return id_curSubdetalle;
    }

    public void setId_curSubdetalle(int id_curSubdetalle) {
        this.id_curSubdetalle = id_curSubdetalle;
    }

    public GestorCursoSubDetServiceLocal getGestorCursoSubDetService() {
        return gestorCursoSubDetService;
    }

    public void setGestorCursoSubDetService(GestorCursoSubDetServiceLocal gestorCursoSubDetService) {
        this.gestorCursoSubDetService = gestorCursoSubDetService;
    }

    public Integer getId_grup_det() {
        return id_grup_det;
    }

    public void setId_grup_det(Integer id_grup_det) {
        this.id_grup_det = id_grup_det;
    }

    public String getNum_dni() {
        return num_dni;
    }

    public void setNum_dni(String num_dni) {
        this.num_dni = num_dni;
    }

    public String getNom_docente() {
        return nom_docente;
    }

    public void setNom_docente(String nom_docente) {
        this.nom_docente = nom_docente;
    }

    public List<String> getDias() {
        return dias;
    }

    public void setDias(List<String> dias) {
        this.dias = dias;
    }

    public String[] getSelectDias() {
        return selectDias;
    }

    public void setSelectDias(String[] selectDias) {
        this.selectDias = selectDias;
    }

    public UsuarioController getUsuarioController() {
        return usuarioController;
    }

    public void setUsuarioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public int getDayActual() {
        return dayActual;
    }

    public void setDayActual(int dayActual) {
        this.dayActual = dayActual;
    }

    public int getMonthActual() {
        return monthActual;
    }

    public void setMonthActual(int monthActual) {
        this.monthActual = monthActual;
    }

    public int getYearActual() {
        return yearActual;
    }

    public void setYearActual(int yearActual) {
        this.yearActual = yearActual;
    }

    public String getMinDia() {
        return MinDia;
    }

    public void setMinDia(String MinDia) {
        this.MinDia = MinDia;
    }

    public String getFFMinDia() {
        return FFMinDia;
    }

    public void setFFMinDia(String FFMinDia) {
        this.FFMinDia = FFMinDia;
    }

    public int getDaySelect() {
        return daySelect;
    }

    public void setDaySelect(int daySelect) {
        this.daySelect = daySelect;
    }

    public int getMonthSelect() {
        return monthSelect;
    }

    public void setMonthSelect(int monthSelect) {
        this.monthSelect = monthSelect;
    }

    public int getYearSelect() {
        return yearSelect;
    }

    public void setYearSelect(int yearSelect) {
        this.yearSelect = yearSelect;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHora_f() {
        return hora_f;
    }

    public void setHora_f(int hora_f) {
        this.hora_f = hora_f;
    }

    public int getMinute_f() {
        return minute_f;
    }

    public void setMinute_f(int minute_f) {
        this.minute_f = minute_f;
    }

    public int getHora_actual() {
        return hora_actual;
    }

    public void setHora_actual(int hora_actual) {
        this.hora_actual = hora_actual;
    }

    public int getMinute_actual() {
        return minute_actual;
    }

    public void setMinute_actual(int minute_actual) {
        this.minute_actual = minute_actual;
    }

    public int getHoraSelect() {
        return horaSelect;
    }

    public void setHoraSelect(int horaSelect) {
        this.horaSelect = horaSelect;
    }

    public int getMinuteSelect() {
        return minuteSelect;
    }

    public void setMinuteSelect(int minuteSelect) {
        this.minuteSelect = minuteSelect;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getMinFechaInicio() {
        return minFechaInicio;
    }

    public void setMinFechaInicio(String minFechaInicio) {
        this.minFechaInicio = minFechaInicio;
    }

    public String getMinFechaFin() {
        return minFechaFin;
    }

    public void setMinFechaFin(String minFechaFin) {
        this.minFechaFin = minFechaFin;
    }

    public int getMinHoraFinHorario() {
        return minHoraFinHorario;
    }

    public void setMinHoraFinHorario(int minHoraFinHorario) {
        this.minHoraFinHorario = minHoraFinHorario;
    }

    public int getMinMinuteFinHorario() {
        return minMinuteFinHorario;
    }

    public void setMinMinuteFinHorario(int minMinuteFinHorario) {
        this.minMinuteFinHorario = minMinuteFinHorario;
    }

    public GestorInversionServiceLocal getGestorInversionService() {
        return gestorInversionService;
    }

    public void setGestorInversionService(GestorInversionServiceLocal gestorInversionService) {
        this.gestorInversionService = gestorInversionService;
    }

    public CepCecInversionCurso getCepCecInversionCurso() {
        return cepCecInversionCurso;
    }

    public void setCepCecInversionCurso(CepCecInversionCurso cepCecInversionCurso) {
        this.cepCecInversionCurso = cepCecInversionCurso;
    }

    public List<TipoCronograma> getLstTipoCronograma() {
        return lstTipoCronograma;
    }

    public void setLstTipoCronograma(List<TipoCronograma> lstTipoCronograma) {
        this.lstTipoCronograma = lstTipoCronograma;
    }

    public TipoCronograma getTipoCronograma() {
        return tipoCronograma;
    }

    public void setTipoCronograma(TipoCronograma tipoCronograma) {
        this.tipoCronograma = tipoCronograma;
    }

    public CepCecCronogramaCab getCepCecCronogramaCab() {
        return cepCecCronogramaCab;
    }

    public void setCepCecCronogramaCab(CepCecCronogramaCab cepCecCronogramaCab) {
        this.cepCecCronogramaCab = cepCecCronogramaCab;
    }

    public GestorCronogramasCabServiceLocal getGestorCronogramasCabService() {
        return gestorCronogramasCabService;
    }

    public void setGestorCronogramasCabService(GestorCronogramasCabServiceLocal gestorCronogramasCabService) {
        this.gestorCronogramasCabService = gestorCronogramasCabService;
    }

    public CepCecPlan getCepCecPlan() {
        return cepCecPlan;
    }

    public void setCepCecPlan(CepCecPlan cepCecPlan) {
        this.cepCecPlan = cepCecPlan;
    }

    public GestorPlanServiceLocal getGestorPlanService() {
        return gestorPlanService;
    }

    public void setGestorPlanService(GestorPlanServiceLocal gestorPlanService) {
        this.gestorPlanService = gestorPlanService;
    }

    public boolean isEstadoAcademico() {
        return estadoAcademico;
    }

    public void setEstadoAcademico(boolean estadoAcademico) {
        this.estadoAcademico = estadoAcademico;
    }

    public MetodosExtras getMetodosExtras() {
        return metodosExtras;
    }

    public void setMetodosExtras(MetodosExtras metodosExtras) {
        this.metodosExtras = metodosExtras;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumpago() {
        return numpago;
    }

    public void setNumpago(int numpago) {
        this.numpago = numpago;
    }

    public int getPageNumberGrupo() {
        return pageNumberGrupo;
    }

    public void setPageNumberGrupo(int pageNumberGrupo) {
        this.pageNumberGrupo = pageNumberGrupo;
    }

    public List<Integer> getPaginacionGrupo() {
        return paginacionGrupo;
    }

    public void setPaginacionGrupo(List<Integer> paginacionGrupo) {
        this.paginacionGrupo = paginacionGrupo;
    }

    public String getName_etapa() {
        return name_etapa;
    }

    public void setName_etapa(String name_etapa) {
        this.name_etapa = name_etapa;
    }

   
    public Integer getUltimeCrono() {
        return ultimeCrono;
    }

    public void setUltimeCrono(Integer ultimeCrono) {
        this.ultimeCrono = ultimeCrono;
    }

    public Integer getVerificarSiFaltaDocente() {
        return verificarSiFaltaDocente;
    }

    public void setVerificarSiFaltaDocente(Integer verificarSiFaltaDocente) {
        this.verificarSiFaltaDocente = verificarSiFaltaDocente;
    }

    public Short getHabilitarEditCro() {
        return habilitarEditCro;
    }

    public void setHabilitarEditCro(Short habilitarEditCro) {
        this.habilitarEditCro = habilitarEditCro;
    }

    public Integer getCronoActualizado() {
        return cronoActualizado;
    }

    public void setCronoActualizado(Integer cronoActualizado) {
        this.cronoActualizado = cronoActualizado;
    }

    public String getNombreFiltro() {
        return nombreFiltro;
    }

    public void setNombreFiltro(String nombreFiltro) {
        this.nombreFiltro = nombreFiltro;
    }

   
    
}
