/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.MetodosExtras;
import clases.TipoCronograma;
import ejb.dao.CronogramasCabDAOLocal;
import entidades.CepCecCronogramaDet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ejb.dao.CronogramasDetDAOLocal;
import entidades.CepCecCronogramaCab;
import entidades.CepCecCurGrup;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Victor Lluen
 */
@Stateless
public class GestorCronogramasDetService implements GestorCronogramasDetServiceLocal {

    @EJB
    private GestorCursoGrupoServiceLocal gestorCursoGrupoService;

    @EJB
    private CronogramasCabDAOLocal cronogramasCabDAO;

    @EJB
    private CronogramasDetDAOLocal cronogramasDetDAO;

    @Override
    public CepCecCronogramaDet crearNuevoCronograma(CepCecCronogramaDet nuevo) {
        return cronogramasDetDAO.crear(nuevo);
    }

    @Override
    public List<CepCecCronogramaDet> buscarTodos() {
        return cronogramasDetDAO.buscarTodos();
    }

    @Override
    public CepCecCronogramaDet capturarDetalleEnCronograma(int curgrupo) {
        return cronogramasDetDAO.capturarDetalleEnCronograma(curgrupo);
    }

    @Override
    public CepCecCronogramaDet actualizarCronograma(CepCecCronogramaDet entidad) {
        return cronogramasDetDAO.actualizar(entidad);
    }

    @Override
    public CepCecCronogramaDet recuperarId(int id) {
        return cronogramasDetDAO.buscarPorId(id);
    }

    /*
     @Override
     public String descripcionCronograma(Integer idCurGrup,Integer tipo_cronograma) {
         String descripcion = "";
        Integer size;
        // obtiene la longitud de cronogrmaas del curso, verifica si esque no existe de tipo 1 (matricula)
        // o de tipo 2 (demas pagos de cuotas) . Si es 0 es porque no tiene ningun cronograma
        // por ello se le crea una descripcion de Matricula , si es mayor que 0 entonces pago normal
         size = cronogramasDetDAO.obtenerTamanoCronogramaPago(idCurGrup);
       
         if (tipo_cronograma==1 || tipo_cronograma==2 ) {
                if (size==0) {
                    descripcion = "Matricula - Pago "+ (size+1);
                }
                else{    
                    descripcion = "Pago - " + (size+1);
                }
         }else{
               Integer sizeExt = cronogramasDetDAO.obtenerTamanoCronogramaPagoExt(idCurGrup);
              
         }
        
         
         return descripcion;
    }
     */
    @Override
    public List<TipoCronograma> buscarCronogramaPorGrupo(Integer idCurGrup) {

        List<CepCecCronogramaCab> lstCronograma = new ArrayList<>();
        List<TipoCronograma> lstTipoCronograma = new ArrayList<>();
        TipoCronograma tipoCronograma;
        // llama al id de la cabecera cronograma con el id del grupo cabecera
        lstCronograma = cronogramasCabDAO.buscarCronogramaCabPorGrupo(idCurGrup);
        if (lstCronograma != null) {

          /*  for (CepCecCronogramaCab itema : lstCronograma) {
                System.out.println("cab " + itema.getIdCronogramaCab());
            }*/

            //System.out.println("cargo cab");
            for (CepCecCronogramaCab item : lstCronograma) {
                // aqui el id de la cabecera llama a todos sus hijos
                List<CepCecCronogramaDet> lstCronogramaDet = new ArrayList<>();
                lstCronogramaDet = cronogramasDetDAO.buscarCronogramaPorGrupo(item.getIdCronogramaCab());
                //System.out.println("cargo det");

               /* if (lstCronogramaDet != null) {
                    for (CepCecCronogramaDet ite : lstCronogramaDet) {
                        System.out.println("det " + ite.getIdCronogramaDet() + " : cab" + ite.getCepCecCronogramaCab().getIdCronogramaCab());
                    }
                }*/

                int cont = 1;
                if (lstCronogramaDet != null) {
                    for (CepCecCronogramaDet detalle : lstCronogramaDet) {
                        tipoCronograma = new TipoCronograma();
                        String des;
                        String id;

                       // System.out.println("entro buclie det");
                        // Si el detalle es de tipo 1 es porque es el pago de la inscripcion o matricula
                        if (detalle.getTipoCronograma() == 1) {
                            id = "" + detalle.getCepCecCronogramaCab().getNumPago();
                            if (detalle.getCepCecCronogramaCab().getCepCecCurGrup().getCepCecCursoSubdet().getFormaPago() == 1) {
                                des = "Matricula Pago Mes -" + id;
                            } else {
                                des = "Matricula Pago Cuota -" + id;
                            }

                        } else {
                            // Si la entidad es de tipo 2 es porque es los siguientes pagos a la inscripcion o matricula
                            if (detalle.getTipoCronograma() == 2) {
                                id = "" + detalle.getCepCecCronogramaCab().getNumPago();
                                if (detalle.getCepCecCronogramaCab().getCepCecCurGrup().getCepCecCursoSubdet().getFormaPago() == 1) {
                                    des = "Pago Mes - " + id;
                                } else {
                                    des = "Pago Cuota - " + id;
                                }

                            } else {
                                // Si la entida es de tipo 3 espoque es un pago extemporaneo
                                if (detalle.getCepCecCronogramaCab().getCepCecCurGrup().getCepCecCursoSubdet().getFormaPago() == 1) {
                                    id = "" + detalle.getCepCecCronogramaCab().getNumPago() + "." + cont;
                                    des = "Pago Mes - " + detalle.getCepCecCronogramaCab().getNumPago() + " Extemporaneo " + cont;

                                } else {
                                    id = "" + detalle.getCepCecCronogramaCab().getNumPago() + "." + cont;
                                    des = "Pago Cuota - " + detalle.getCepCecCronogramaCab().getNumPago() + " Extemporaneo " + cont;
                                }
                                cont++;
                            }
                        }
                        System.out.println("va cargar");
                        
                        tipoCronograma.setId(id);
                        tipoCronograma.setId_cronogramaDet(detalle.getIdCronogramaDet());
                        tipoCronograma.setFi(detalle.getFechaIniCro());
                        tipoCronograma.setHi(detalle.getHoraIniCro());
                        tipoCronograma.setFf(detalle.getFechaFinCro());
                        tipoCronograma.setHf(detalle.getHoraFinCro());
                        tipoCronograma.setTipo(detalle.getTipoCronograma());
                        tipoCronograma.setDescripcion(des);
                        tipoCronograma.setNumpago(detalle.getCepCecCronogramaCab().getNumPago());
                        lstTipoCronograma.add(tipoCronograma);
                        System.out.println("guardo");
                    }
                }
            }
        }

       // System.out.println("retornara");
        return lstTipoCronograma;

    }

    //****Saber si el cronograma de matricula de x curso esta habilitado *****
    // se usa para la condicional de edicion del cronograma de matricula
    // si el cronograma de matricula de x curso esta habilitado entonces ya no se puede editar
    @Override
    public Short DesHabilitarEditCronograma(Integer id_detalle) {
        Short deshabilitar = 0; // 1 si  0 no
        System.out.println("entroa service");
        // recupera el cronograma de cada entidad por iteracion
        CepCecCronogramaDet cronograma = new CepCecCronogramaDet();
        cronograma = cronogramasDetDAO.deshabilitarEditCronograma(id_detalle);
        System.out.println("que sera");
        if (cronograma != null) {
            System.out.println("entro a conidiconal");
            Date fecha_inicio = cronograma.getFechaIniCro();
            Date fecha_fin = cronograma.getFechaFinCro();
            Date hora_inicio = cronograma.getHoraIniCro();
            Date hora_fin = cronograma.getHoraFinCro();
            // convierte date a calendar
            //Calendar currDtCal = gestorCursoGrupoService.toCalendar(fecha_inicio);
            // Calendar currDtCalFin = gestorCursoGrupoService.toCalendar(fecha_fin);
            //modifica los calendar 
            //currDtCal.set(Calendar.HOUR_OF_DAY, hora_inicio.getHours());
            //currDtCal.set(Calendar.MINUTE, hora_inicio.getMinutes());
            // currDtCal.set(Calendar.SECOND, 0);
            // currDtCal.set(Calendar.MILLISECOND, 0);
            //currDtCalFin.set(Calendar.HOUR_OF_DAY, hora_fin.getHours());
            //currDtCalFin.set(Calendar.MINUTE, hora_fin.getMinutes());
            // currDtCalFin.set(Calendar.SECOND, 0);
            // currDtCalFin.set(Calendar.MILLISECOND, 0);
            // convierte calendar a date
            // Date fecha_inicio1 = currDtCal.getTime();
            //  Date fecha_fin1 = currDtCalFin.getTime();
            MetodosExtras obj = new MetodosExtras();
            Date fecha_inicio1 = obj.unirFechayHora(fecha_inicio, hora_inicio);
            Date fecha_fin1 = obj.unirFechayHora(fecha_fin, hora_fin);
            //Mostramos por pantalla la hora actual 
            //System.out.println("La obja comparar es: "+currDtCal.getTime());
            System.out.println("Fecha Inicio: " + obj.doFechaHoraConFormato(fecha_inicio1));
            System.out.println("Fecha Fin: " + obj.doFechaHoraConFormato(fecha_fin1));
            System.out.println("Fecha Actual  " + obj.doFechaHoraConFormato(obj.obtenerFechaActualSinSegundos()));

            // verifica si la fecha de inicio el cronograma del grupo es igual , es mayor que la fecha inicio
            if ((obj.obtenerFechaActualSinSegundos().after(fecha_inicio1) || obj.obtenerFechaActualSinSegundos().equals(fecha_inicio1))) {
                System.out.println("ya no se puede editar");
                if (obj.obtenerFechaActualSinSegundos().before(fecha_fin1)) {
                    deshabilitar = 2; // nos dejare poder acabarla en cualquier momento
                } else {
                    deshabilitar = 1;
                }
            } else {
                // si la fecha actual esta antes que la fecha fin
                System.out.println("aun se puede editar");
                deshabilitar = 0;

            }
        }

        return deshabilitar;
    }

   @Override
   public CepCecCronogramaDet encontrarUltimoCronograma(Integer grupo){
       List<CepCecCronogramaDet> lstcro = cronogramasDetDAO.ultimoCronograma(grupo);
      CepCecCronogramaDet crodet = new CepCecCronogramaDet();
       try {
             crodet= lstcro.get(lstcro.size()-1);
            
       } catch (Exception e) {
           System.out.println("nullo en encontrar ultimocrnograma");
       }
       return crodet;
   }
    
    @Override
    public Short capturarEtapa(CepCecCronogramaDet tipoCrono, CepCecCurGrup grupo) {
        Short etapa = 0; // 1 si  0 no
        System.out.println("entroa service");
        // recupera el cronograma de cada entidad por iteracion
        // CepCecCronogramaDet cronograma = new CepCecCronogramaDet();
        //cronograma = cronogramasDetDAO.deshabilitarEditCronograma(id_detalle);
        System.out.println("que sera");
        // Si ele estado academico no es true , es porque ya finalizo
        if (grupo.getEstadoAcademico()) {
            //si el tipo de cronograma es null es porque hay un erro, al parecer se creo sin un cronograma de matricula el curso
            // ya que al menos debe haber un tipoCronograma que seria el de la matricula
            try {
                System.out.println("entro a conidiconal");
                Date fecha_inicio = tipoCrono.getFechaIniCro();
                Date fecha_fin = tipoCrono.getFechaFinCro();
                Date hora_inicio = tipoCrono.getHoraIniCro();
                Date hora_fin = tipoCrono.getHoraFinCro();

                MetodosExtras obj = new MetodosExtras();
                Date fecha_inicio1 = obj.unirFechayHora(fecha_inicio, hora_inicio);
                Date fecha_fin1 = obj.unirFechayHora(fecha_fin, hora_fin);
                //Mostramos por pantalla la hora actual 
                //System.out.println("La obja comparar es: "+currDtCal.getTime());
                System.out.println("Fecha Inicio: " + obj.doFechaHoraConFormato(fecha_inicio1));
                System.out.println("Fecha Fin: " + obj.doFechaHoraConFormato(fecha_fin1));
                System.out.println("Fecha Actual  " + obj.doFechaHoraConFormato(obj.obtenerFechaActualSinSegundos()));
                // verifica si la fecha de inicio el cronograma del grupo es igual , es mayor que la fecha inicio

                if (obj.obtenerFechaActualSinSegundos().before(fecha_inicio1)) {
                    etapa = 1;  // Esttamos en el momento antes que empieze el cronograma seleccionado
                } else {
                    if ((obj.obtenerFechaActualSinSegundos().equals(fecha_inicio1) || obj.obtenerFechaActualSinSegundos().after(fecha_inicio1)) && obj.obtenerFechaActualSinSegundos().before(fecha_fin1)) {
                        etapa = 2;              // ETAPA DEl cronograma EN PROCESO :OSEA que esta que se ejecuta este cronograma de pago o de matricula
                    } else {
                        if ((obj.obtenerFechaActualSinSegundos().equals(fecha_fin1) || obj.obtenerFechaActualSinSegundos().after(fecha_fin1) ) && obj.obtenerFechaActualSinSegundos().before(grupo.getFechaInicio())) {
                            // antes de la fecha inicio
                            etapa= 3;
                        }else{
                             if ((obj.obtenerFechaActualSinSegundos().equals(fecha_fin1) || obj.obtenerFechaActualSinSegundos().after(fecha_fin1) ) && obj.obtenerFechaActualSinSegundos().before(grupo.getFechaFin())) {
                            etapa = 4; // Etapa que ya acabo el cronograma pero el grupo aun no finalizo
                            } else {
                                etapa = 5; // luego que finalizo el grupo su fecha fin
                            }
                        }
                       
                    }
                }
            } catch (NullPointerException e) {
                  System.out.println("ERROR!si el tipo de cronograma es null es porque hay un erroR, al parecer se creo sin un cronograma de matricula el curso a que al menos debe haber un tipoCronograma que seria el de la matricula" );
                    etapa=6; // Error Cronograma
            }
        } else {

            etapa = 5;//curso finalizado 
        }

        return etapa;
    }
    
    

    @Override
    public TipoCronograma buscarProximoPago(List<TipoCronograma> lstCronograma) {
        MetodosExtras obj = new MetodosExtras();
        TipoCronograma cronograma = null;

        if (lstCronograma.size() > 0) {
            for (TipoCronograma entidad : lstCronograma) {
                Date fecha_inicio = entidad.getFi();
                Date fecha_fin = entidad.getFf();
                Date hora_inicio = entidad.getHi();
                Date hora_fin = entidad.getHf();

                fecha_inicio = obj.unirFechayHora(fecha_inicio, hora_inicio);
                fecha_fin = obj.unirFechayHora(fecha_fin, hora_fin);

                if (obj.obtenerFechaActualSinSegundos().before(fecha_inicio)) {
                    cronograma = entidad;
                    break;

                }
            }

        }

        return cronograma;
    }

    
    
    
    @Override
    public Integer numPagodelCronograma(CepCecCurGrup grup) {
        Integer cuotapago = 0;
        try {
            List<CepCecCronogramaDet> lstCrono = new ArrayList<>();
            lstCrono = cronogramasDetDAO.buscarCronogramasPorcadaGrupo(grup.getIdCurGrup());
            MetodosExtras obj = new MetodosExtras();
            for (CepCecCronogramaDet entity : lstCrono) {
                Date fi = obj.unirFechayHora(entity.getFechaIniCro(), entity.getHoraIniCro());
                Date ff = obj.unirFechayHora(entity.getFechaFinCro(), entity.getHoraFinCro());
                Date fecha_actual = obj.obtenerFechaActualSinSegundos();
                if ((fecha_actual.after(fi) || fecha_actual.equals(fi)) && (fecha_actual.before(ff))) {
                    cuotapago = entity.getCepCecCronogramaCab().getNumPago();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("error en gestor cronogramasDetService");
        }

        return cuotapago;
    }

}
