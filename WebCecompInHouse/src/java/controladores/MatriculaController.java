/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

//import ejb.negocio.GestorCronogramasServiceLocal;
import clases.InversionCurso;
import clases.MetodosExtras;
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
//import java.io.Serializable;
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
import ejb.negocio.GestorNotasServiceLocal;
import ejb.negocio.GestorRcdConceptoServiceLocal;
import ejb.negocio.GestorUsuarioEstGeneralServiceLocal;
import entidades.CepCecExonerados;
import entidades.CepCecInversionCurso;
import entidades.CepCecMatriPago;
import entidades.RcdConcepto;
import entidades.RcdVoucher;
import frameworkHANM.*;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Melvin
 */
@ManagedBean(name = "matriculaController")
//@Named(value = "matriculaController")
@SessionScoped
public class MatriculaController {



  
    //1. Atributos
    // llamando usuario controller
    @ManagedProperty(value = "#{usuarioController}")
    public UsuarioController usuarioController;
    private Integer id_grupo;
    private List<CepCecCurGrup> lstGrupos;
    private CepCecCurGrup cepCecCurGrup;
    private List<InversionCurso> lstInversion;
    private int id_curSubdetalle;  // atributo para recuperar el id del detalle curso elegido
    private CepCecCurGrupDet cepCecCurGrupDet;
    private CepCecCronogramaDet cepCecCronogramaDet;
    private DrtPersonanatural drtPersonanatural;
    private DrtPersonanatural drtMatriculado;
    private int formapago ;
    //atributos voucher
    private Integer secuencia;
    private String cod_alumno;
    private Date fecha_pago;
    private Short cod_agencia;
    private String dni;
    private Short valido; // para la vista si es valido o no el voucher
    private Integer tipoPago;
    //concepto
    private Integer idconcepto;
    //inversion
    private InversionCurso inversionCurso;
    //matricula
    private CepCecMatriAlu cepCecMatriAlu;
    private Integer id_matricula;
    private List<CepCecMatriAlu> lstMatri;
    //pago
    private CepCecMatriPago cepCecMatriPago;
    private PguPagospersDet pguPagospersDet;
    private List<CepCecMatriPago> lstPagosMatri;
    private PagosMatricula pago;
    private List<PagosMatricula> lstpagos;
    private List<Integer> lstCuotas; // para listar el numero de cada cuota que se pago
    private Integer vistaPagoPension;
    private Map parametros;
    private  CepCecExonerados cepCecExonerados;
    private Integer toPagar;
    private Integer numCronogramaPago;
    //lsttipocronograma
     private List<TipoCronograma> lstTipoCronograma;
     private  TipoCronograma cronogramaClass ;
//2. EJBs
    @EJB
    private GestorRcdConceptoServiceLocal gestorRcdConceptoService;

    @EJB
    private GestorCursoGrupoServiceLocal gestorCursoGrupoService;

    @EJB
    private GestorInversionServiceLocal gestorInversionService;

    @EJB
    private GestorCepCecCurGrupDetalleServiceLocal gestorCepCecCurGrupDetalleService;

    @EJB
    private GestorCronogramasDetServiceLocal gestorCronogramasService;

    @EJB
    private GestorRcdVoucherServiceLocal gestorRcdVoucherService;

    @EJB
    private GestorTipoPagosServiceLocal gestorTipoPagosService;

    @EJB
    private GestorPguModalidadTipoPagoServiceLocal gestorPguModalidadTipoPagoService;

    @EJB
    private GestorPguPagosCabServiceLocal gestorPguPagosCabService;

    @EJB
    private GestorPguPagoDetServiceLocal gestorPguPagoDetService;

    @EJB
    private GestorMatriculaAluServiceLocal gestorMatriculaAluService;

    @EJB
    private GestorMatriPagoServiceLocal gestorMatriPagoService;

    @EJB
    private GestorNotasServiceLocal gestorNotasService;

    @EJB
    private GestorUsuarioEstGeneralServiceLocal gestorUsuarioEstGeneralService;

    @EJB
    private DescuentoExoServiceLocal descuentoExoService;

    @EJB
    private ExoneradosServiceLocal exoneradosService;
    
    @EJB
    private GestorCronogramasDetServiceLocal gestorCronogramasDetService;
    
    
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
    // llama todos lo grupos habilitados para matricula dentro de las fechas de cronogramas establecidas
    public List<CepCecCurGrup> doBuscarGruposToInscripcion() {
        return lstGrupos = gestorCursoGrupoService.buscarGruposParaInscripcion();
    }

    // metodo para web alumno cecomp
    public List<InversionCurso> dobuscarInversionTipoAlumno() {
        // por tipo de alumno iniciado cesion  1: uns 2: externo  3: trabajdor

        lstInversion = new ArrayList<InversionCurso>();
        System.out.println("tipo de alumno" + usuarioController.getTipo_alumno());
        System.out.println("Curso es " + id_curSubdetalle); // SE OBTUVO EN CAPTURARGRUPO O CAPTURAR MATRICULA
        this.idconcepto = 0;
        return lstInversion = gestorInversionService.buscarInversionPorTipo(id_curSubdetalle, usuarioController.getTipo_alumno(), idconcepto);
    }

    public void capturarGrupo(CepCecCurGrup entidadGrupo) {
        cepCecCurGrup = new CepCecCurGrup();
        cepCecCurGrup = entidadGrupo;
        cepCecCurGrupDet = new CepCecCurGrupDet();
        cepCecCurGrupDet = gestorCepCecCurGrupDetalleService.capturarDetalle(cepCecCurGrup.getIdCurGrup());
        cepCecCronogramaDet = new CepCecCronogramaDet();
        cepCecCronogramaDet = gestorCronogramasService.capturarDetalleEnCronograma(cepCecCurGrup.getIdCurGrup());
        id_curSubdetalle = cepCecCurGrup.getCepCecCursoSubdet().getIdCursoSubdet();
        // cepCecCurGrupDet = new CepCecCurGrupDet();
        // cepCecCurGrupDet = gestorCepCecCurGrupDetalleService.capturarDetalle(cepCecCurGrup.getIdCurGrup());          
        System.out.println("" + cepCecCurGrup.getCepCecCursoSubdet().getCepCecCursoDet().getCepCecCursoCab().getNomCurso());
        this.tipoPago = 1;//MATRICULA
    }

    public void capturarMatricula(CepCecMatriAlu entidad) {
        this.cepCecMatriAlu = new CepCecMatriAlu();
        this.cepCecMatriAlu = entidad;
        id_matricula = cepCecMatriAlu.getIdMatriAlu();
        this.cepCecCurGrup = new CepCecCurGrup();
        this.cepCecCurGrup = this.cepCecMatriAlu.getCepCecCurGrup();
        this.cepCecCurGrupDet = new CepCecCurGrupDet();
        this.cepCecCurGrupDet = gestorCepCecCurGrupDetalleService.capturarDetalle(this.cepCecCurGrup.getIdCurGrup());
        this.cepCecCronogramaDet = new CepCecCronogramaDet();
        this.cepCecCronogramaDet = gestorCronogramasService.capturarDetalleEnCronograma(this.cepCecCurGrup.getIdCurGrup());
        id_curSubdetalle = this.cepCecCurGrup.getCepCecCursoSubdet().getIdCursoSubdet();
        // cepCecCurGrupDet = new CepCecCurGrupDet();
        // cepCecCurGrupDet = gestorCepCecCurGrupDetalleService.capturarDetalle(cepCecCurGrup.getIdCurGrup());          
        System.out.println("" + cepCecCurGrup.getCepCecCursoSubdet().getCepCecCursoDet().getCepCecCursoCab().getNomCurso());
        this.tipoPago = 2;//DEMAS PAGOS

    }

    
   
       
    public void doValidarVoucher() {
        valido = 0;
        inversionCurso = new InversionCurso();
        String num_documento;
        drtPersonanatural = new DrtPersonanatural();
        Short condicional = 0;

        // carga la lista
        dobuscarInversionTipoAlumno();
        System.out.println("cod_agencia " + cod_agencia);
        System.out.println("secuencia " + secuencia);
        System.out.println("fecha " + fecha_pago);

        //ya se cargo en ***public void capturarGrupo(CepCecCurGrup entidadGrupo)** las entidades
        // carga lstInversion que es una lista donde estaran los codigos y precios 
        //dobuscarInversionTipoAlumno();
        // instancio la entidad tipo clase 
        // InversionCurso entidad = new InversionCurso();
        // si es estudiante entonces me trae su codigo
        switch (usuarioController.getTipo_alumno()) {
            case 1:
                //cod_alumno = "0201415050";
                dni = usuarioController.getEstudianteActualUns().getDrtPersonanatural().getNumeroPndid();
                cod_alumno = usuarioController.getEstudianteActualUns().getCodigoEstudiante();
                num_documento = cod_alumno;
                drtPersonanatural = usuarioController.getEstudianteActualUns().getDrtPersonanatural();
                // dir=usuarioController.getEstudianteActualUns().getDrtPersonanatural().getIdDir();
                System.out.println(cod_alumno);
                inversionCurso = gestorRcdVoucherService.buscarVoucher(lstInversion, secuencia, cod_agencia, cod_alumno, fecha_pago, drtPersonanatural.getIdDir(), dni, usuarioController.getTipo_alumno());
                break;
            case 2:
                // si es estudiante general
                this.cod_alumno = "0000";
                this.dni = usuarioController.getEstudianteActualGene().getNumeroPndid();
                num_documento = usuarioController.getEstudianteActualGene().getNumeroPndid();;
                this.drtPersonanatural = usuarioController.getEstudianteActualGene();
                //dir=usuarioController.getEstudianteActualGene().getIdDir();

                System.out.println(dni);
                this.inversionCurso = gestorRcdVoucherService.buscarVoucher(lstInversion, secuencia, cod_agencia, cod_alumno, fecha_pago, drtPersonanatural.getIdDir(), dni, usuarioController.getTipo_alumno());

                break;
            case 3:
                this.cod_alumno = "0000";
                this.dni = usuarioController.getUsuarioActualEmp().getDrtDirectorio().getDrtPersonanatural().getNumeroPndid();
                num_documento = dni;
                //dir = usuarioController.getUsuarioActualEmp().getDrtDirectorio().getIdDir();
                this.drtPersonanatural = usuarioController.getUsuarioActualEmp().getDrtDirectorio().getDrtPersonanatural();
                System.out.println(dni);
                this.inversionCurso = gestorRcdVoucherService.buscarVoucher(lstInversion, secuencia, cod_agencia, cod_alumno, fecha_pago, drtPersonanatural.getIdDir(), dni, usuarioController.getTipo_alumno());

                break;
            default:
                throw new AssertionError();
        }
        
        
      
        // verifica si es o no valido el voucher
        if (inversionCurso != null) {
             /// ve en que cronograma se encuentra
             numCronogramaPago = gestorCronogramasDetService.numPagodelCronograma(cepCecCurGrup);
             
            ////////**pgu
            PguTipoPagos pguTipoPagos = new PguTipoPagos();
            PguModalidadTipospagos modtipago = new PguModalidadTipospagos();
            PguPagospersCab pguPagosCab = new PguPagospersCab();
            //CepCecMatriAlu cepCecMatriAlu = null;
            valido = 1;// variable que solo sirve para un render en la vista
            System.out.println("voucher valido");
            //reacomodo del nombre del concepto a crear o verificar, se le va añadir el grupo
            String nuevo_nameconcepto = inversionCurso.getNombre() + " / " + cepCecCurGrup.getCepCecGrupo().getNomGrupo(); 
            inversionCurso.setNombre(nuevo_nameconcepto);
            // guarda en pgu
            // 1er paso verifica si el concepto en pgu existe , sino la crea ?como? bueno verifica el nombre y el monto ya que son unicos
            // busco la en la tabla pgu_tipopagos para ver si existe el concepto
            pguTipoPagos = gestorTipoPagosService.buscarConcepto(inversionCurso);
            // ahora verifica si esta en la tabla de pgu_modalidad_tipo_pagos
            modtipago = gestorPguModalidadTipoPagoService.buscarModalidadPago(pguTipoPagos);
            // envia el id_dir del usuario y crea el el pago cabecera
            pguPagosCab = gestorPguPagosCabService.crearNuevoPagoCab(drtPersonanatural.getIdDir());
            // guarda cabecera de pago
            
            // guarda en detalle
            gestorPguPagoDetService.crearNuevoPagoDet(pguPagosCab, modtipago, fecha_pago, secuencia, inversionCurso.getPrecio());
            System.out.println("SE GUARDO det ");
            // guarda matricula 
            //cepCecCurGrup
            if (tipoPago == 1) { //CUANDO PAGA LA MATRICULA osea la 1 CUOTA
                this.cepCecMatriAlu =new CepCecMatriAlu();
                this.cepCecMatriAlu = gestorMatriculaAluService.crearMatriAlu(cepCecCurGrup, drtPersonanatural, usuarioController.getTipo_alumno());
                System.out.println("Creo matricula");
                MetodosExtras obj = new MetodosExtras();
                String codGenerado= obj.doGeneradorDeCodigo(this.cepCecMatriAlu.getIdMatriAlu());
                System.out.println("codgenerado "+codGenerado);
                this.cepCecMatriAlu.setCodMatricula(codGenerado);
                CepCecMatriAlu matricula = new CepCecMatriAlu();
                matricula=gestorMatriculaAluService.actualizarMatri(cepCecMatriAlu);
                System.out.println("Creo codigo y actualizo entidad ");
                // a la misma ves crea la entidad de notas
                gestorNotasService.crearNuevasNotas(matricula);
                System.out.println("creo notas");
                gestorMatriPagoService.crearMatriPago(matricula, pguPagosCab, tipoPago,inversionCurso.getCondicion_alumno(),inversionCurso.getPagoTotal(),inversionCurso.getCodigo(),numCronogramaPago);
                 System.out.println("creo pagos");
                System.out.println("SE MATRICULO");
            } else {  ///CUANDO ENTRA A PAGAR DEMAS PAGOS DE LAS CUOTAS DEL CURSO
                this.tipoPago = 2;
                cepCecMatriAlu = new CepCecMatriAlu();
                cepCecMatriAlu = gestorMatriculaAluService.recuperarEntidadMatriAlu(id_matricula);
                gestorMatriPagoService.crearMatriPago(cepCecMatriAlu, pguPagosCab, tipoPago,inversionCurso.getCondicion_alumno(),inversionCurso.getPagoTotal(),inversionCurso.getCodigo(),numCronogramaPago);
                System.out.println("se registro PAGO");
            }

            //Quito el estado en rcd_voucher
            RcdVoucher rcdvoucher = new RcdVoucher();
            rcdvoucher = gestorRcdVoucherService.recuperarEntidad(inversionCurso.getId_rcdVoucher());
            rcdvoucher.setEstado(false);
            gestorRcdVoucherService.actualizarEntidad(rcdvoucher);

        } else {
       
            //*****************VERIFICA SI ES QUE NO TIENES ALGUNA BECA, O DESCUENTO POR PLANILLA /////
            String secExo = "" + secuencia;
            //id_curSubdetalle se obtuvo en capturarMatricula o CapturarGrupo
            cepCecExonerados = new CepCecExonerados();
            cepCecExonerados = exoneradosService.verSiExisteVoucherFicticioAlumno(secExo, fecha_pago, cod_agencia, num_documento, id_curSubdetalle, usuarioController.getTipo_alumno());
            if (cepCecExonerados!=null) {
                   MetodosExtras obj = new MetodosExtras();
                   Date today= obj.obtenerFechaActualSinTime();
                   if (today.after(cepCecExonerados.getFechaVencimiento()) ) {
                       System.out.println("Invalido, fecha caduco");
                          valido = 0;
                   }else{
                       

                          System.out.println("voucher valido tabla exonerados");
                          System.out.println("ss "+cepCecCurGrup.getFechaInicio());
                          numCronogramaPago = gestorCronogramasDetService.numPagodelCronograma(cepCecCurGrup);
                          
                           //guarda matricula
                           // PguPagospersCab pguPagosCab=null;
                                  if (tipoPago == 1) { //CUANDO PAGA LA MATRICULA osea la 1 CUOTA

                                      this.cepCecMatriAlu = new CepCecMatriAlu();
                                      
                                         this.cepCecMatriAlu = gestorMatriculaAluService.crearMatriAlu(cepCecCurGrup, drtPersonanatural, usuarioController.getTipo_alumno());
                                            obj = new MetodosExtras();
                                          CepCecMatriAlu matricula = new CepCecMatriAlu();

                                            cepCecMatriAlu.setCodMatricula(obj.doGeneradorDeCodigo(cepCecMatriAlu.getIdMatriAlu()));
                                           matricula = gestorMatriculaAluService.actualizarMatri(cepCecMatriAlu);                            
                           // a la misma ves crea la entidad de notas
                                      gestorNotasService.crearNuevasNotas(matricula);
                                      //cepCecExonerados.getPagototal()== Si es true en el voucherFicticio el pago es x el curso total
                                      gestorMatriPagoService.crearMatriPagoParaExonerados(matricula, tipoPago,cepCecExonerados.getCepCecDescExonerados().getCepCecInversionCurso().getCepCecTipoInversion().getIdTipoinversion(),cepCecExonerados.getPagototal(),cepCecExonerados,numCronogramaPago);

                                      System.out.println("SE MATRICULO");
                                  } else {  ///CUANDO ENTRA A PAGAR DEMAS PAGOS DE LAS CUOTAS DEL CURSO
                                      tipoPago = 2;
                                      this.cepCecMatriAlu = new CepCecMatriAlu();
                                      this.cepCecMatriAlu = gestorMatriculaAluService.recuperarEntidadMatriAlu(id_matricula);

                                      gestorMatriPagoService.crearMatriPagoParaExonerados(cepCecMatriAlu, tipoPago,cepCecExonerados.getCepCecDescExonerados().getCepCecInversionCurso().getCepCecTipoInversion().getIdTipoinversion(),cepCecExonerados.getPagototal(),cepCecExonerados,numCronogramaPago);
                                      System.out.println("se registro PAGO");
                                  }

                                  // Actualiza la entidad
                                  Date fechaUso = new Date();
                                  this.cepCecExonerados.setFechaUso(fechaUso);
                                  this.exoneradosService.actualizarEntidad(cepCecExonerados);
                                    valido = 1;// variable que solo sirve para un render en la vista  

                   }
                          
                    }else{
                       valido = 0;
                       System.out.println("voucher no valido");
                    }
           
           
        }

    }
    

   
  

    ///********cursos matriculados en proceso por grupo*************
    public List<CepCecMatriPago> doListarMatriculadosPorGrupo() {
        //id_Grupo lo captura en el metodo capturarGrupoParaVerMatriculados()
        return gestorMatriPagoService.buscarAlumnosMatriculados(id_grupo);
    }

    ///********cursos matriculados en proceso por alumno*************
    public List<CepCecMatriAlu> doListarCursosProcesosActivos() {
        doIniciarlizarDrt(); //Inicializar el persona natural segun el tipo de alumno
        return gestorMatriculaAluService.buscarCursosEnProcesoPorAlumno(drtPersonanatural.getIdDir());
    }

     public List<CepCecMatriAlu> doListarCursosHistorial() {
        doIniciarlizarDrt(); //Inicializar el persona natural segun el tipo de alumno
        return gestorMatriculaAluService.buscarCursosHistorialPorAlumno(drtPersonanatural.getIdDir());
    }
    ///***********Condicional si se habilita o no el boton de opcio de pagos por curso ******************* 
 /*   public Integer doCondicionalNextPago(CepCecMatriAlu item) {
        cepCecMatriAlu = new CepCecMatriAlu();
        cepCecMatriAlu = item;
        Integer numpago;
        Integer condicional = 0;//Si es 1 , se habilita but si es 0 no se habilita 
        // 
        try {
        System.out.println("ENTRARA VALIDAR NEXTPAGP");
        numpago = gestorCursoGrupoService.habilitarNextPago(cepCecMatriAlu.getCepCecCurGrup().getIdCurGrup());
        System.out.println("VALIDO NEXT PAGO");
        if (numpago != 0) {
            System.out.println("ENTRO VALIDAR NEXPAGO");
            // si no es diferente de 0, nos quiere decir que este en el periodo de fecha de pago
            // entonces compara si es que ya pago, como asi?  hace una busqueda de las veces que pago 
            // asi que el pago debe tener tipo de pago  1 o  2  
            if (numpago > gestorMatriPagoService.buscarSizePagosPorAlumno(cepCecMatriAlu.getIdMatriAlu())) {

                System.out.println("ENTRO A VALIDAR SIZE PAGOS");
                //ahora se verifica si se puede pagar total del curso y se ve si este pago completo
                //CepCecInversionCurso InversionCurso = new CepCecInversionCurso();
                List<CepCecInversionCurso>lstInversionCurso = new ArrayList<>();
                System.out.println("curso " + cepCecMatriAlu.getCepCecCurGrup().getCepCecCursoSubdet().getIdCursoSubdet());

                lstInversionCurso = gestorInversionService.listaInversion(cepCecMatriAlu.getCepCecCurGrup().getCepCecCursoSubdet().getIdCursoSubdet(), usuarioController.getTipo_alumno());
                // entonces si el curso esta habilitado para pagar pago completo(osea cuando conceptotal=1), ya no se habilita la opcion del pago de la siguiente cuota
                // porque ya pago las dos cuotas 
                //System.out.println("el monto es  " + InversionCurso.getPrecioTotal());
                     
                              
                              cepCecMatriPago = new CepCecMatriPago();
                              System.out.println("matri " + cepCecMatriAlu.getIdMatriAlu());
                              //BUSCA EN EL PAGO DE TIPO  1 QUE ES EL PRIMER PAGO PARA VER SI PAGO EL CURSO EN SU TOTALIDAD
                              cepCecMatriPago = gestorMatriPagoService.buscarPagoMatriculaPorAlumno(cepCecMatriAlu.getIdMatriAlu());
                              if (cepCecMatriPago != null) {
                                  
                                 //llama la inversion correcta
                                 CepCecInversionCurso InversionCurso = new CepCecInversionCurso();
                                 InversionCurso = gestorInversionService.buscarInver(cepCecMatriAlu.getCepCecCurGrup().getCepCecCursoSubdet().getIdCursoSubdet(), usuarioController.getTipo_alumno(),cepCecMatriPago.getCondicionAlu());
                                  if (InversionCurso!=null) {
                                            
                                           System.out.println("Inversion: "+InversionCurso.getNombreConcepto());
                                          if (InversionCurso.getConceptoTotal()==1) {
                                          
                                                  System.out.println("matripago " + cepCecMatriPago.getIdNumpago());
                                                System.out.println("ENTRO  a ver pgu det");
                                                pguPagospersDet = new PguPagospersDet();
                                                pguPagospersDet = gestorPguPagoDetService.buscarPagoPorAlumnoMatriculado(cepCecMatriPago.getIdNumpago());
                                                 // verifica si es el monto pagado es igual al monto total  
                                                System.out.println("monto de pgu " + pguPagospersDet.getMonto());
                                                System.out.println("verifica monto");
                                                int retval = Float.compare(pguPagospersDet.getMonto(), InversionCurso.getPrecioTotal());
                                                if (pguPagospersDet != null && retval == 0) {
                                                System.out.println("es 0");
                                                condicional = 0; // no se habilita tiene los pagos completos

                                                } else {
                                                   condicional = 1; // // se habilita
                                               }
                                       
                                            }else{
                                             condicional = 1; // // se habilita
                                          }
  
                                    }else{
                                        System.out.println("No existe una inversion, o se elimino para validar un siguiente pago");
                                    }
                                

                              } else {
                                  System.out.println("Error no existe Ningun pago de inscripcion");
                              }
                         

                } else {
                    System.out.println("SIZE PAGO ES 0");
                    condicional = 0; // ya pago no se habilita
                }
            } else {
                System.out.println("Error el numero de pagos es null ");
                condicional = 0; // no se habilita
            }
        } catch (Exception e) {
            System.out.println("ERROR TRYCATCH");
            condicional = 0; // no se habilita
        }
       
        System.out.println("va retnorar CONDICINAL");
        return condicional;
    }*/
    
    
    
    ///***********Condicional si se habilita o no el boton de opcio de pagos por curso ******************* 
    public Integer doCondicionalNextPago(CepCecMatriAlu item) {
        cepCecMatriAlu = new CepCecMatriAlu();
        cepCecMatriAlu = item;
        Integer numpago;
        Integer condicional = 0;//Si es 1 , se habilita but si es 0 no se habilita 
        // 
        try {
        System.out.println("ENTRARA VALIDAR NEXTPAGP");
        // me trae si esta habilitado la fecha esta habilitada para pgar
        numpago = gestorCursoGrupoService.habilitarNextPago(cepCecMatriAlu.getCepCecCurGrup().getIdCurGrup());
        System.out.println("VALIDO NEXT PAGO");
        if (numpago != 0) {
            System.out.println("ENTRO VALIDAR NEXPAGO");
            // si no es diferente de 0, nos quiere decir que este en el periodo de fecha de pago
            // entonces compara si es que ya pago, como asi?  hace una busqueda de las veces que pago 
            // asi que el pago debe tener tipo de pago  1 o  2  
            if (numpago > gestorMatriPagoService.buscarSizePagosPorAlumno(cepCecMatriAlu.getIdMatriAlu())) {
  
                              cepCecMatriPago = new CepCecMatriPago();
                              System.out.println("matri " + cepCecMatriAlu.getIdMatriAlu());
                              //BUSCA EN EL PAGO DE TIPO  1 QUE ES EL PRIMER PAGO PARA VER SI PAGO EL CURSO EN SU TOTALIDAD
                             try {
                                cepCecMatriPago = gestorMatriPagoService.buscarPagoMatriculaPorAlumno(cepCecMatriAlu.getIdMatriAlu());
                                    if (cepCecMatriPago.getIsPagototal()) {
                                        condicional= -2;     // pago todo  
                                    }else{
                                        condicional = numpago;   // no pago todo
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("null pago matriculo error fatal");
                                }
                } else {
                    System.out.println("SIZE PAGO ES 0");
                    condicional = 0; // ya pago no se habilita
                }
            } else {
                     //BUSCA EN EL PAGO DE TIPO  1 QUE ES EL PRIMER PAGO PARA VER SI PAGO EL CURSO EN SU TOTALIDAD
                             try {
                                cepCecMatriPago = gestorMatriPagoService.buscarPagoMatriculaPorAlumno(cepCecMatriAlu.getIdMatriAlu());
                                    if (cepCecMatriPago.getIsPagototal()) {
                                        condicional= -2;     // pago todo  
                                    }else{
                                         System.out.println("Error el numero de pagos es null ");
                                         condicional = 0; // no se habilita
                                    }
                                } catch (NullPointerException e) {
                                    condicional=0;
                                    System.out.println("null pago matriculo error fatal");
                                }   
            
               
            }
        } catch (Exception e) {
            System.out.println("ERROR TRYCATCH");
            condicional = 0; // no se habilita
        }
       
        System.out.println("va retnorar CONDICINAL");
        return condicional;
    }
    
    
    
    
  public Integer doCronogramaProximopago(CepCecMatriAlu item){
    //cepCecCronograma= gestorCronogramasService.capturarDetalleEnCronograma(cepCecCurGrup.getIdCurGrup());
    
            toPagar = this.doCondicionalNextPago(item);
             
            
            if (toPagar==0) {
                 lstTipoCronograma = new ArrayList<>();
                 lstTipoCronograma = gestorCronogramasDetService.buscarCronogramaPorGrupo(item.getCepCecCurGrup().getIdCurGrup());
                 // busca algun pago cerca
                 TipoCronograma cronograma = gestorCronogramasDetService.buscarProximoPago(lstTipoCronograma);
              
                 if (cronograma==null) {
                   toPagar=-1;
                  }  
                
            }
           System.out.println("topagar = "+toPagar);
            return toPagar;
              
  }
  
  public void doCapturaProximoCronograma(CepCecMatriAlu item){
      lstTipoCronograma = new ArrayList<>();
      lstTipoCronograma = gestorCronogramasDetService.buscarCronogramaPorGrupo(item.getCepCecCurGrup().getIdCurGrup());
                 // busca algun pago cerca
      cronogramaClass = gestorCronogramasDetService.buscarProximoPago(lstTipoCronograma);
  }
  
    
  
  

    public void doIniciarlizarDrt() {
        drtPersonanatural = new DrtPersonanatural();
        switch (usuarioController.getTipo_alumno()) {
            case 1:
                drtPersonanatural = usuarioController.getEstudianteActualUns().getDrtPersonanatural();
                break;
            case 2:
                drtPersonanatural = usuarioController.getEstudianteActualGene();
                break;
            case 3:
                drtPersonanatural = usuarioController.getUsuarioActualEmp().getDrtDirectorio().getDrtPersonanatural();
                break;
            default:
                throw new AssertionError();
        }
    }

    /*
     public void redireccionAhDatosPersonales() {
        doIniciarlizarDrt(); //Inicializar el persona natural segun el tipo de alumno
        String direccionar = "/WebCecompInHouse/faces/pages/Usuario/Datos/DatosPersonales.xhtml";
        redireccionado(direccionar);
        
     }
     */
    ////****************************metodos para el modo administrador****************************
    
    public void doTotalMatriculadosPorGrupo(){
        //calcula el numero de matriculados
        //num_matriculados se declara en UsuarioController 
        // id_curso_grupo se declara y se caputra en el GrupoCursoController
        try {
             usuarioController.setNum_matriculados(gestorMatriculaAluService.cantidadAlumnosMatriculadosPorGrupo(usuarioController.getId_curso_grupo())); 

        } catch (Exception e) {
            System.out.println("Error en doTotalMatriculadosPorGrupo() en MatriculaController");
        }
       
    }
    
    
    public void doCapturarMatriculaEnAdministrador(CepCecMatriAlu item) {
        cepCecMatriAlu = new CepCecMatriAlu();
        cepCecMatriAlu = item;
        drtMatriculado = new DrtPersonanatural();
        //drtMatriculado = gestorUsuarioEstGeneralService.recuperarIdEntidadDrtPersona();
        drtMatriculado = cepCecMatriAlu.getDrtPersonanatural();
        id_matricula = cepCecMatriAlu.getIdMatriAlu();
        System.out.println("id_matri es " + id_matricula);
    
    }

    public void docapturarGrupoParaVerMatriculados(CepCecCurGrup entidadGrupo) {
        cepCecCurGrup = new CepCecCurGrup();
        cepCecCurGrup = entidadGrupo;
        id_grupo = cepCecCurGrup.getIdCurGrup();
        System.out.println("id grupo es " + id_grupo);
        formapago = cepCecCurGrup.getCepCecCursoSubdet().getFormaPago();
        //captura la cantidad de cuotas para la generar la lista en ver pagos grupo  en la vista 
        lstCuotas = new ArrayList<>();
        lstCuotas = gestorMatriPagoService.generarListaDePagosPensionMatricula(cepCecCurGrup.getCepCecCursoSubdet().getNumCuotas());

        redireccionAhMatriculados();
    }

    public void doMostrarPagosPorMatriculaEnGrupoModoAdmi(CepCecMatriAlu cecMatriAlu) {
        //Declaro la lista de la clase PagosMatricula
        lstpagos = new ArrayList<>();
        //LIsta todoslos pagos
        lstPagosMatri = new ArrayList<>();
        lstPagosMatri = gestorMatriPagoService.buscarPagosPorMatricula(cecMatriAlu.getIdMatriAlu());
        try {
          if (lstPagosMatri!=null) {
                for (CepCecMatriPago matriPago : lstPagosMatri) {
                //recorre cada pago
                //instancia clase pago 
                pago = new PagosMatricula();
                pago.setId(matriPago.getIdMatriPago());
                // caputro el detalle del pago 
                pguPagospersDet = new PguPagospersDet();
                pguPagospersDet = gestorPguPagoDetService.buscarPagoPorAlumnoMatriculado(matriPago.getPguPagospersCab().getIdNumpago());
                pago.setConcepto(pguPagospersDet.getPguModalidadTipospagos().getPguTipoPagos().getConcepto());
                pago.setFecha(pguPagospersDet.getFechaOper());
                pago.setMonto(pguPagospersDet.getMonto());
                //INGRESA LA ENTIDAD A LA LISTA
                lstpagos.add(pago);
                }
          }
        } catch (NullPointerException e) {
          //  usuarioController.getFramework().doMensajeR("Error 26", "No existe ", tipoPago);
        }
        
       
    }

    public void doVerPagosPorTodoGrupo() {
        lstMatri = new ArrayList<>();
        lstMatri = gestorMatriculaAluService.buscarAlumnosMatriculados(id_grupo);
    }

    public List<Integer> doVerPagosPorMatricula(CepCecMatriAlu matricula) {
        cepCecMatriAlu = new CepCecMatriAlu();
        cepCecMatriAlu = matricula;
        //ahora verifica cual es el monto a pagar para este tipo de alumno
        //CepCecInversionCurso InversionCurso = new CepCecInversionCurso();
        System.out.println("curso " + cepCecMatriAlu.getCepCecCurGrup().getCepCecCursoSubdet().getIdCursoSubdet());
       //ya no * //Filtro la inversion por el id del curso,tipo de alumno (Alumno Uns, publico genera o Trabj UNS) y si la condicion si es 1.normal 2.mediabeca 7 becado 
        //ya no *  // List<CepCecInversionCurso> lstInversionCurso = new ArrayList<>();
       // lstInversionCurso = gestorInversionService.listaInversion(cepCecMatriAlu.getCepCecCurGrup().getCepCecCursoSubdet().getIdCursoSubdet(), cepCecMatriAlu.getTipoAlumno());
        //InversionCurso = gestorInversionService.buscarCostoTotal(cepCecMatriAlu.getCepCecCurGrup().getCepCecCursoSubdet().getIdCursoSubdet(), cepCecMatriAlu.getTipoAlumno(), cepCecMatriAlu.getCondicionAlu());
        //System.out.println("el monto es  " + InversionCurso.getPrecioTotal());
        // ahora verificara si el concepto se puede pagar como un costo toal

        // REVISA EL NUMERO DE PAGOS QUE TENEMOS EN LA MATRICULA LUEGO COMPARA SI ES QUE EL NUMERO D EPAGOS ES IGUAL
        // AL NUMERO DE CUOTAS A PAGAR SINO ES ASI, ENTONCES VERIFICA SI EL CONCEPTO AL QUE SE PAGO TIENE LA CONDICION DE 
        //PAGAR EL COSTO TOTAL EN UN SOLO PAGO, SI ES ASI VERIFICA Y LO MARCA COMO PAGADO TODO 
          
          List<Integer>  lstPagos=  gestorMatriPagoService.listarConformidadPagosMatriculaPorAlumno(cepCecMatriAlu);
            if (lstPagos.get(0) == 27 ) {
                  usuarioController.getFramework().doMensajeR("Error 27", "El numero de pagos del curso es  0!", 4);
            } else { 
                if (lstPagos.get(0)==28) {
                     usuarioController.getFramework().doMensajeR("Error 28! ", " El alumno debe tener minimo un pago (Matricula) ", 4);
                }
            } 
            
           return lstPagos;   
 
    }

    public void doEliminarMatricula() {
        cepCecMatriAlu = new CepCecMatriAlu();
        Short estado = 0;
        System.out.println("id matri es " + id_matricula);
        cepCecMatriAlu = gestorMatriculaAluService.recuperarEntidadMatriAlu(id_matricula);
        cepCecMatriAlu.setEstadoMatri(estado);

        //LIsta todoslos pagos
        lstPagosMatri = new ArrayList<>();
        lstPagosMatri = gestorMatriPagoService.buscarPagosPorMatricula(cepCecMatriAlu.getIdMatriAlu());
        gestorMatriculaAluService.actualizarMatri(cepCecMatriAlu);
    
        try {
           
            for (CepCecMatriPago pagos : lstPagosMatri) {
            CepCecMatriPago pag = new CepCecMatriPago();
            pag = pagos;
            pag.setEstadoMat(estado);
            gestorMatriPagoService.actualizarMatriPago(pag);
                if (pagos.getIdVoucherFicticio()==null) {
                      if (pag.getCondicionAlu()==1 || pag.getCondicionAlu()==2) {
                        PguPagospersCab pguCab = new PguPagospersCab();
                        pguCab = gestorPguPagosCabService.recuperarPguCab(pagos.getPguPagospersCab().getIdNumpago());
                        pguCab.setEstado(false);
                        pguPagospersDet = new PguPagospersDet();
                        pguPagospersDet = gestorPguPagoDetService.buscarPagoPorAlumnoMatriculado(pagos.getPguPagospersCab().getIdNumpago());
                        pguPagospersDet.setObserv("Anulado por el Sistema WEB CECOMP");
                        pguPagospersDet.setEstado(false);
                        gestorPguPagoDetService.actualizarPguDet(pguPagospersDet);
                        gestorPguPagosCabService.actualizarPguCab(pguCab);
                 }
                
                }
        }
            usuarioController.getFramework().doMensajeF("Exito!","Se Elimino Matricula y pago!" , 1);
        } catch (NullPointerException e) {
            usuarioController.getFramework().doMensajeF("Aviso!","Error 2! Comunicarse con UDEMSI", 4);
        }
        
        

    }
    
 

    
    /// redireccionamientos
    public void redireccionAhVoucher() {
        String direccionar = "/WebCecompInHouse/faces/pages/Usuario/Cursos/voucher.xhtml";
        redireccionado(direccionar);
    }

    public void redireccionAhMatriculados() {
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Matricula/Matriculas.xhtml";
        redireccionado(direccionar);
    }

    public void redireccionAhPagosDeMatriculados() {
        String direccionar = "/WebCecompInHouse/faces/pages/Administrador/Matricula/Pagos.xhtml";
        redireccionado(direccionar);
    }

    //***********************************************************************/// 
    //***************metodos para validar voucher usuarioexterno**************///
    //***********************************************************************/// 
    public List<RcdConcepto> doListarConceptos() {
        return gestorRcdConceptoService.buscarConceptosCecomp();
    }

    public void doValidarVoucherForRegistroUsers() {

        lstInversion = new ArrayList<InversionCurso>();

        System.out.println("Curso es " + id_curSubdetalle); // SE OBTUVO EN CAPTURARGRUPO O CAPTURAR MATRICULA
        usuarioController.setTipo_alumno(2);  // publico en general
        System.out.println("tipo de alumno" + usuarioController.getTipo_alumno());
        id_curSubdetalle = 0;
        // Carga los conceptos
        lstInversion = gestorInversionService.buscarInversionPorTipo(id_curSubdetalle, usuarioController.getTipo_alumno(), idconcepto);
        inversionCurso = new InversionCurso();
        Integer dir = 0;
        cod_alumno = "0";
        inversionCurso = gestorRcdVoucherService.buscarVoucher(lstInversion, secuencia, cod_agencia, cod_alumno, fecha_pago, dir, dni, usuarioController.getTipo_alumno());
        if (inversionCurso != null) {
             DrtPersonanatural persona = new DrtPersonanatural();
               persona = gestorUsuarioEstGeneralService.BuscarDni(dni);
            if (persona==null) {
                System.out.println("VOUCHER VALIDO Y NO REGISTRADO");
                valido = 1;
                usuarioController.setNumdni(dni);
                //usuarioController.numdni = dni;
                usuarioController.doCargarRegistroMatricula(); // carga el metodo que esta en el controlador de Usuario
            } else {
                if (persona.getPswa()==null) {
                     usuarioController.setId_dir(persona.getIdDir());
                     /*dni encontroad */ valido = 3; // ya existe pero no tiene passwoord
                }else{
                /*dni encontroad */ valido = 2;  //es valido pero el dni ya existe asi que ya no se puede registrar

                }
            }

        } else {
                //*****************VERIFICA SI ES QUE NO TIENES ALGUNA BECA, O DESCUENTO POR PLANILLA /////
                String secExo = "" + secuencia;
                //id_curSubdetalle se obtuvo en capturarMatricula o CapturarGrupo
                cepCecExonerados = new CepCecExonerados();
                cepCecExonerados=exoneradosService.verSiExisteVoucherFicticioRegistroExterno(secExo, fecha_pago, cod_agencia, dni);
                
                if (cepCecExonerados!=null) {
                        
                   MetodosExtras obj = new MetodosExtras();
                   Date today= obj.obtenerFechaActualSinTime();
                   if (today.after(cepCecExonerados.getFechaVencimiento()) ) {
                       System.out.println("Invalido, fecha caduco");
                          valido = 0;
                   }else{
                       
                           DrtPersonanatural  persona = gestorUsuarioEstGeneralService.BuscarDni(dni);
                           if (persona==null) {
                                System.out.println("VOUCHER VALIDO Y NO REGISTRADO");
                                valido = 1;
                                usuarioController.setNumdni(dni);
                                //usuarioController.numdni = dni;
                                usuarioController.doCargarRegistroMatricula(); // carga el metodo que esta en el controlador de Usuario
                            } else {
                               
                                       if (persona.getPswa()==null) {
                                            usuarioController.setId_dir(persona.getIdDir());
                                            /*dni encontroad */ valido = 3; // ya existe pero no tiene passwoord
                                       }else{
                                       /*dni encontroad */ valido = 2;  //es valido pero el dni ya existe asi que ya no se puede registrar

                                       }
                               
                            }
                       
                   }
                     
                }else{
                  System.out.println("VOUCHER NO VALIDO");
                valido = 0;
                }
            
        }

    }

    /*
    public void redireccionValidarVoucherForRegUser() {
        String direccionar = "/WebCecompInHouse/faces/pages/UserExterno/voucherExterno.xhtml";
        redireccionado(direccionar);
    } */
    // 5 get y set
    public CepCecMatriPago getCepCecMatriPago() {
        return cepCecMatriPago;
    }

    public void setCepCecMatriPago(CepCecMatriPago cepCecMatriPago) {
        this.cepCecMatriPago = cepCecMatriPago;
    }

    public GestorNotasServiceLocal getGestorNotasService() {
        return gestorNotasService;
    }

    public void setGestorNotasService(GestorNotasServiceLocal gestorNotasService) {
        this.gestorNotasService = gestorNotasService;
    }

    public Integer getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(Integer tipoPago) {
        this.tipoPago = tipoPago;
    }

    public CepCecMatriAlu getCepCecMatriAlu() {
        return cepCecMatriAlu;
    }

    public void setCepCecMatriAlu(CepCecMatriAlu cepCecMatriAlu) {
        this.cepCecMatriAlu = cepCecMatriAlu;
    }

    public CepCecCronogramaDet getCepCecCronogramaDet() {
        return cepCecCronogramaDet;
    }

    public void setCepCecCronogramaDet(CepCecCronogramaDet cepCecCronogramaDet) {
        this.cepCecCronogramaDet = cepCecCronogramaDet;
    }

    public CepCecCurGrup getCepCecCurGrup() {
        return cepCecCurGrup;
    }

    public void setCepCecCurGrup(CepCecCurGrup cepCecCurGrup) {
        this.cepCecCurGrup = cepCecCurGrup;
    }

    public List<CepCecCurGrup> getLstGrupos() {
        return lstGrupos;
    }

    public void setLstGrupos(List<CepCecCurGrup> lstGrupos) {
        this.lstGrupos = lstGrupos;
    }

    public GestorCursoGrupoServiceLocal getGestorCursoGrupoService() {
        return gestorCursoGrupoService;
    }

    public void setGestorCursoGrupoService(GestorCursoGrupoServiceLocal gestorCursoGrupoService) {
        this.gestorCursoGrupoService = gestorCursoGrupoService;
    }

    public UsuarioController getUsuarioController() {
        return usuarioController;
    }

    public void setUsuarioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public List<InversionCurso> getLstInversion() {
        return lstInversion;
    }

    public void setLstInversion(List<InversionCurso> lstInversion) {
        this.lstInversion = lstInversion;
    }

    public int getId_curSubdetalle() {
        return id_curSubdetalle;
    }

    public void setId_curSubdetalle(int id_curSubdetalle) {
        this.id_curSubdetalle = id_curSubdetalle;
    }

    public CepCecCurGrupDet getCepCecCurGrupDet() {
        return cepCecCurGrupDet;
    }

    public void setCepCecCurGrupDet(CepCecCurGrupDet cepCecCurGrupDet) {
        this.cepCecCurGrupDet = cepCecCurGrupDet;
    }

    public CepCecCronogramaDet getCepCecCronograma() {
        return cepCecCronogramaDet;
    }

    public void setCepCecCronograma(CepCecCronogramaDet cepCecCronograma) {
        this.cepCecCronogramaDet = cepCecCronograma;
    }

    public GestorInversionServiceLocal getGestorInversionService() {
        return gestorInversionService;
    }

    public void setGestorInversionService(GestorInversionServiceLocal gestorInversionService) {
        this.gestorInversionService = gestorInversionService;
    }

    public GestorCepCecCurGrupDetalleServiceLocal getGestorCepCecCurGrupDetalleService() {
        return gestorCepCecCurGrupDetalleService;
    }

    public void setGestorCepCecCurGrupDetalleService(GestorCepCecCurGrupDetalleServiceLocal gestorCepCecCurGrupDetalleService) {
        this.gestorCepCecCurGrupDetalleService = gestorCepCecCurGrupDetalleService;
    }

    public GestorCronogramasDetServiceLocal getGestorCronogramasService() {
        return gestorCronogramasService;
    }

    public void setGestorCronogramasService(GestorCronogramasDetServiceLocal gestorCronogramasService) {
        this.gestorCronogramasService = gestorCronogramasService;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public String getCod_alumno() {
        return cod_alumno;
    }

    public void setCod_alumno(String cod_alumno) {
        this.cod_alumno = cod_alumno;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Short getCod_agencia() {
        return cod_agencia;
    }

    public void setCod_agencia(Short cod_agencia) {
        this.cod_agencia = cod_agencia;
    }

    public GestorRcdVoucherServiceLocal getGestorRcdVoucherService() {
        return gestorRcdVoucherService;
    }

    public void setGestorRcdVoucherService(GestorRcdVoucherServiceLocal gestorRcdVoucherService) {
        this.gestorRcdVoucherService = gestorRcdVoucherService;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Short getValido() {
        return valido;
    }

    public void setValido(Short valido) {
        this.valido = valido;
    }

    public InversionCurso getInversionCurso() {
        return inversionCurso;
    }

    public void setInversionCurso(InversionCurso inversionCurso) {
        this.inversionCurso = inversionCurso;
    }

    public GestorTipoPagosServiceLocal getGestorTipoPagosService() {
        return gestorTipoPagosService;
    }

    public void setGestorTipoPagosService(GestorTipoPagosServiceLocal gestorTipoPagosService) {
        this.gestorTipoPagosService = gestorTipoPagosService;
    }

    public GestorPguModalidadTipoPagoServiceLocal getGestorPguModalidadTipoPagoService() {
        return gestorPguModalidadTipoPagoService;
    }

    public void setGestorPguModalidadTipoPagoService(GestorPguModalidadTipoPagoServiceLocal gestorPguModalidadTipoPagoService) {
        this.gestorPguModalidadTipoPagoService = gestorPguModalidadTipoPagoService;
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

    public DrtPersonanatural getDrtPersonanatural() {
        return drtPersonanatural;
    }

    public void setDrtPersonanatural(DrtPersonanatural drtPersonanatural) {
        this.drtPersonanatural = drtPersonanatural;
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

    public Integer getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(Integer id_matricula) {
        this.id_matricula = id_matricula;
    }

    public PguPagospersDet getPguPagospersDet() {
        return pguPagospersDet;
    }

    public void setPguPagospersDet(PguPagospersDet pguPagospersDet) {
        this.pguPagospersDet = pguPagospersDet;
    }

    public Integer getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(Integer id_grupo) {
        this.id_grupo = id_grupo;
    }

    public List<CepCecMatriPago> getLstPagosMatri() {
        return lstPagosMatri;
    }

    public void setLstPagosMatri(List<CepCecMatriPago> lstPagosMatri) {
        this.lstPagosMatri = lstPagosMatri;
    }

    public PagosMatricula getPago() {
        return pago;
    }

    public void setPago(PagosMatricula pago) {
        this.pago = pago;
    }

    public List<PagosMatricula> getLstpagos() {
        return lstpagos;
    }

    public void setLstpagos(List<PagosMatricula> lstpagos) {
        this.lstpagos = lstpagos;
    }

    public List<Integer> getLstCuotas() {
        return lstCuotas;
    }

    public void setLstCuotas(List<Integer> lstCuotas) {
        this.lstCuotas = lstCuotas;
    }

    public List<CepCecMatriAlu> getLstMatri() {
        return lstMatri;
    }

    public void setLstMatri(List<CepCecMatriAlu> lstMatri) {
        this.lstMatri = lstMatri;
    }

    public Integer getVistaPagoPension() {
        return vistaPagoPension;
    }

    public void setVistaPagoPension(Integer vistaPagoPension) {
        this.vistaPagoPension = vistaPagoPension;
    }

    public Integer getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Integer idconcepto) {
        this.idconcepto = idconcepto;
    }

    public GestorRcdConceptoServiceLocal getGestorRcdConceptoService() {
        return gestorRcdConceptoService;
    }

    public void setGestorRcdConceptoService(GestorRcdConceptoServiceLocal gestorRcdConceptoService) {
        this.gestorRcdConceptoService = gestorRcdConceptoService;
    }

    public Map getParametros() {
        return parametros;
    }

    public void setParametros(Map parametros) {
        this.parametros = parametros;
    }

    public GestorUsuarioEstGeneralServiceLocal getGestorUsuarioEstGeneralService() {
        return gestorUsuarioEstGeneralService;
    }

    public void setGestorUsuarioEstGeneralService(GestorUsuarioEstGeneralServiceLocal gestorUsuarioEstGeneralService) {
        this.gestorUsuarioEstGeneralService = gestorUsuarioEstGeneralService;
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

    public CepCecExonerados getCepCecExonerados() {
        return cepCecExonerados;
    }

    public void setCepCecExonerados(CepCecExonerados cepCecExonerados) {
        this.cepCecExonerados = cepCecExonerados;
    }

    public DrtPersonanatural getDrtMatriculado() {
        return drtMatriculado;
    }

    public void setDrtMatriculado(DrtPersonanatural drtMatriculado) {
        this.drtMatriculado = drtMatriculado;
    }

    public List<TipoCronograma> getLstTipoCronograma() {
        return lstTipoCronograma;
    }

    public void setLstTipoCronograma(List<TipoCronograma> lstTipoCronograma) {
        this.lstTipoCronograma = lstTipoCronograma;
    }

    public TipoCronograma getCronogramaClass() {
        return cronogramaClass;
    }

    public void setCronogramaClass(TipoCronograma cronogramaClass) {
        this.cronogramaClass = cronogramaClass;
    }

    public GestorCronogramasDetServiceLocal getGestorCronogramasDetService() {
        return gestorCronogramasDetService;
    }

    public void setGestorCronogramasDetService(GestorCronogramasDetServiceLocal gestorCronogramasDetService) {
        this.gestorCronogramasDetService = gestorCronogramasDetService;
    }

    public Integer getToPagar() {
        return toPagar;
    }

    public void setToPagar(Integer toPagar) {
        this.toPagar = toPagar;
    }

    public Integer getNumCronogramaPago() {
        return numCronogramaPago;
    }

    public void setNumCronogramaPago(Integer numCronogramaPago) {
        this.numCronogramaPago = numCronogramaPago;
    }

    public int getFormapago() {
        return formapago;
    }

    public void setFormapago(int formapago) {
        this.formapago = formapago;
    }
    
    

}
