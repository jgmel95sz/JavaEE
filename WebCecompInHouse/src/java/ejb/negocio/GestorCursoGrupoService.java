/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;


import clases.MetodosExtras;
import ejb.dao.CursoGrupoDAOLocal;
import entidades.CepCecCronogramaDet;
import entidades.CepCecCurGrup;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ejb.dao.CronogramasDetDAOLocal;

/**
 *
 * @author MELVN
 */
@Stateless
public class GestorCursoGrupoService implements GestorCursoGrupoServiceLocal {

    @EJB
    private CronogramasDetDAOLocal cronogramasDetDAO;

    @EJB
    private GestorCronogramasDetServiceLocal gestorCronogramasDetService;

    @EJB
    private CursoGrupoDAOLocal cursoGrupoDAO;
    
     @Override
    public boolean validarNumeroDeGrupo(int id_cursodetallado,int id_grupo){
        return cursoGrupoDAO.validarNumeroDeGrupo(id_cursodetallado,id_grupo)!=null;
    }
    
    @Override
    public CepCecCurGrup actualizarEntidad(CepCecCurGrup entidad) {
        return cursoGrupoDAO.actualizar(entidad);
    }
   
    @Override
    public CepCecCurGrup crearNuevoGrupoCurso(CepCecCurGrup grupocurso) {
        System.out.println("ENTRO A CREAR NEGOCIO DE GRUPO CURSO");
        return cursoGrupoDAO.crear(grupocurso);
    }

 @Override
    public List<CepCecCurGrup> buscarTodos() {
        System.out.println("EN SERVICE GRUPO");
        return cursoGrupoDAO.buscarTodos();
    }
   
    
    @Override
    public List<CepCecCurGrup> buscarGrupoPorFiltro(int id_cursogeneral,int pageNumber) {
        System.out.println("EN SERVICE LISTA FILTRO GRUPO");
        return cursoGrupoDAO.buscarPorFiltroCurso(id_cursogeneral,pageNumber);
    }
    
    @Override
     public int tamanoPaginacionGrupo(int id_cursogeneral){
        int finalTamano =0;
         try {
             MetodosExtras obj = new MetodosExtras();
             int countResult= (int)cursoGrupoDAO.calculandoTotalRegistrosGrupo(id_cursogeneral);
             int pageSize = 5 ; // 5 por pagina
              finalTamano =   obj.tamanoPaginacion(pageSize, countResult);
         } catch (Exception e) {
             System.out.println("error en paginacion del grupo");
         }
         return finalTamano;
     }
       
    
    @Override
    public List<CepCecCurGrup> buscarHistoricos() {
        return cursoGrupoDAO.buscarHistorico();
    }
    
    @Override
    public List<CepCecCurGrup> buscarHistoricoPorFiltro(int id_cursogeneral) {
        return cursoGrupoDAO.buscarHistoricoPorFiltroCurso(id_cursogeneral);
    }
    
    
    
    @Override
    public List<CepCecCurGrup> buscarGruposParaInscripcion() {
         
        List<CepCecCurGrup> lista  = new ArrayList<> ();
        List<CepCecCurGrup> lsdGrupos  = new ArrayList<> ();
        
        lsdGrupos  = cursoGrupoDAO.buscarTodos();
        if (lsdGrupos!=null) {
           for (CepCecCurGrup item : lsdGrupos) {
       
            // recupera el cronograma de cada entidad por iteracion
            CepCecCronogramaDet cronograma= new CepCecCronogramaDet();
            cronograma = gestorCronogramasDetService.capturarDetalleEnCronograma(item.getIdCurGrup());    
            Date fecha_inicio = cronograma.getFechaIniCro();
            Date fecha_fin = cronograma.getFechaFinCro();
            Date hora_inicio = cronograma.getHoraIniCro();
            Date hora_fin = cronograma.getHoraFinCro();
            // convierte date a calendar
            Calendar currDtCal= toCalendar(fecha_inicio);
            Calendar currDtCalFin= toCalendar(fecha_fin);
            //modifica los calendar 
            currDtCal.set(Calendar.HOUR_OF_DAY, hora_inicio.getHours());
            currDtCal.set(Calendar.MINUTE, hora_inicio.getMinutes());
            currDtCal.set(Calendar.SECOND,0);
            currDtCal.set(Calendar.MILLISECOND, 0);     
            currDtCalFin.set(Calendar.HOUR_OF_DAY, hora_fin.getHours());
            currDtCalFin.set(Calendar.MINUTE, hora_fin.getMinutes());
            currDtCalFin.set(Calendar.SECOND, 0);
            currDtCalFin.set(Calendar.MILLISECOND, 0);
            // convierte calendar a date
            Date fecha_inicio1 = currDtCal.getTime();
            Date fecha_fin1 = currDtCalFin.getTime();
            //Mostramos por pantalla la hora actual y la introducida manualmente
            //System.out.println("La a comparar es: "+currDtCal.getTime());
            System.out.println("Fecha Inicio: "+FormatoFechas(fecha_inicio1));
            System.out.println("Fecha Fin: "+FormatoFechas(fecha_fin1));
            System.out.println("Fecha Actual  "+FormatoFechas(obtenerFechaActual()));
            // verifica si la fecha de inicio el cronograma del grupo es igual , es mayor que la fecha inicio
            // pero menor o igual que la fecha fin
             if ( (obtenerFechaActual().after(fecha_inicio1)  || obtenerFechaActual().equals(fecha_inicio1)) && (obtenerFechaActual().before(fecha_fin1)  || obtenerFechaActual().equals(fecha_fin1)) ) 
             {
                System.out.println("habilitado");
                   lista.add(item);
                   }else{
                  System.out.println("not hability");
                   List<CepCecCronogramaDet> lstExtemporaneo = new ArrayList<>();
                   lstExtemporaneo = cronogramasDetDAO.capturarCronogramaExtemporaneoMatricula(cronograma.getCepCecCronogramaCab().getIdCronogramaCab());
                        if (lstExtemporaneo!=null) {
                                        for (CepCecCronogramaDet det : lstExtemporaneo) {
                                                    cronograma= new CepCecCronogramaDet();
                                                    // recupera el cronograma de cada entidad por iteracion
                                                       cronograma = det; 
                                                        fecha_inicio = cronograma.getFechaIniCro();
                                                        fecha_fin = cronograma.getFechaFinCro();
                                                        hora_inicio = cronograma.getHoraIniCro();
                                                        hora_fin = cronograma.getHoraFinCro();
                                                       // convierte date a calendar
                                                        currDtCal= toCalendar(fecha_inicio);
                                                        currDtCalFin= toCalendar(fecha_fin);
                                                       //modifica los calendar 
                                                       currDtCal.set(Calendar.HOUR_OF_DAY, hora_inicio.getHours());
                                                       currDtCal.set(Calendar.MINUTE, hora_inicio.getMinutes());
                                                       currDtCal.set(Calendar.SECOND,0);
                                                       currDtCal.set(Calendar.MILLISECOND, 0);     
                                                       currDtCalFin.set(Calendar.HOUR_OF_DAY, hora_fin.getHours());
                                                       currDtCalFin.set(Calendar.MINUTE, hora_fin.getMinutes());
                                                       currDtCalFin.set(Calendar.SECOND, 0);
                                                       currDtCalFin.set(Calendar.MILLISECOND, 0);
                                                       // convierte calendar a date
                                                        fecha_inicio1 = currDtCal.getTime();
                                                        fecha_fin1 = currDtCalFin.getTime();

                                                        if ( (obtenerFechaActual().after(fecha_inicio1)  || obtenerFechaActual().equals(fecha_inicio1)) && (obtenerFechaActual().before(fecha_fin1)  || obtenerFechaActual().equals(fecha_fin1)) )
                                                        {
                                                              System.out.println("habilitado extemproaneo");
                                                                 lista.add(item);
                                                                 break;
                                                        }  
                                            }
                        
                        }
                     
                 }
          }
        }
       
                
        return lista;
    }
    
    
      @Override
       public  Calendar toCalendar(Date date){ 
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
     }
      
       @Override
        public  Date obtenerFechaActual(){
        //Obtenemos fecha y hora actuales
         Calendar currDtCal = Calendar.getInstance();
        //Eliminamos segundos y milisegundos si no necesitamos esa precisión.
        currDtCal.set(Calendar.SECOND, 0);
        currDtCal.set(Calendar.MILLISECOND, 0);
        //Guardamos la fecha y hora actuales sin segundos ni milisegundos
        Date actual = currDtCal.getTime();
        return actual;
    }
       
        @Override
        public  String FormatoFechas(Date fecha){
        String pattern = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(fecha);
        //String date = simpleDateFormat.format(new Date());
        return date;
    }
    
    

    @Override
    public CepCecCurGrup recuperarIdGrupoCurso(int id) {
        return cursoGrupoDAO.buscarPorId(id);
    }

    @Override
    public Integer findRegistroCursoSubDet(int id_cursubdet) {
        return cursoGrupoDAO.findRegistroCursoSubDet(id_cursubdet);
    }
   
    
    @Override
    public Integer compruebaSiPlanEstaAsignadoAhGrupo(Integer id_plan){
      
        if (id_plan==0) {
            return 1;
        }else{
            if (cursoGrupoDAO.compruebaSiPlanEstaAsignadoAhGrupo(id_plan)==1)   {
               return 1; 
           }
            else{ 
               return 0;
           }
        
        }
   
        
       
    }
    
   
    
    
    @Override
     public Integer habilitarNextPago(Integer id_grupCurso) {
          Integer habilitado=0; // 1 si  0 no
         
         // recupera el cronograma de cada entidad por iteracion
            List<CepCecCronogramaDet> lstCronogramPagos= new ArrayList<>();
            lstCronogramPagos = cronogramasDetDAO.capturarCronogramaPagos(id_grupCurso);
          if (lstCronogramPagos!=null) {
              for (CepCecCronogramaDet cronograma : lstCronogramPagos) {
             
                   Date fecha_inicio = cronograma.getFechaIniCro();
                   Date fecha_fin = cronograma.getFechaFinCro();
                   Date hora_inicio = cronograma.getHoraIniCro();
                   Date hora_fin = cronograma.getHoraFinCro();
                   // convierte date a calendar
                   Calendar currDtCal= toCalendar(fecha_inicio);
                   Calendar currDtCalFin= toCalendar(fecha_fin);
                   //modifica los calendar 
                   currDtCal.set(Calendar.HOUR_OF_DAY, hora_inicio.getHours());
                   currDtCal.set(Calendar.MINUTE, hora_inicio.getMinutes());
                   currDtCal.set(Calendar.SECOND,0);
                   currDtCal.set(Calendar.MILLISECOND, 0);     
                   currDtCalFin.set(Calendar.HOUR_OF_DAY, hora_fin.getHours());
                   currDtCalFin.set(Calendar.MINUTE, hora_fin.getMinutes());
                   currDtCalFin.set(Calendar.SECOND, 0);
                   currDtCalFin.set(Calendar.MILLISECOND, 0);
                   // convierte calendar a date
                   Date fecha_inicio1 = currDtCal.getTime();
                   Date fecha_fin1 = currDtCalFin.getTime();
                   //Mostramos por pantalla la hora actual y la introducida manualmente
                   //System.out.println("La a comparar es: "+currDtCal.getTime());
                   System.out.println("Fecha Inicio: "+FormatoFechas(fecha_inicio1));
                   System.out.println("Fecha Fin: "+FormatoFechas(fecha_fin1));
                   System.out.println("Fecha Actual  "+FormatoFechas(obtenerFechaActual()));

                        // verifica si la fecha de inicio el cronograma del grupo es igual , es mayor que la fecha inicio
                         // pero menor o igual que la fecha fin
                          if ( (obtenerFechaActual().after(fecha_inicio1)  || obtenerFechaActual().equals(fecha_inicio1)) && (obtenerFechaActual().before(fecha_fin1)  || obtenerFechaActual().equals(fecha_fin1)) ) 
                          {   
                              // te lanza el numero de pago que siempre es diferente de 0
                              habilitado= cronograma.getCepCecCronogramaCab().getNumPago();
                             System.out.println("habilitado");

                              break;
                          }else{
                               System.out.println("not hability");
                               // obtiene el id de su cabezera , una vez que lo obtiene entonces busca todos los extemporaneos segun ese id de cabecera en este caso de tipo 2 de "demas pagos"
                                List<CepCecCronogramaDet> lstExtemporaneo = new ArrayList<>();
                                lstExtemporaneo = cronogramasDetDAO.capturarCronogramaExtemporaneoMatricula(cronograma.getCepCecCronogramaCab().getIdCronogramaCab());
                                     if (lstExtemporaneo!=null) {
                                                     for (CepCecCronogramaDet det : lstExtemporaneo) {
                                                                 cronograma= new CepCecCronogramaDet();
                                                                 // recupera el cronograma de cada entidad por iteracion
                                                                    cronograma = det; 
                                                                     fecha_inicio = cronograma.getFechaIniCro();
                                                                     fecha_fin = cronograma.getFechaFinCro();
                                                                     hora_inicio = cronograma.getHoraIniCro();
                                                                     hora_fin = cronograma.getHoraFinCro();
                                                                    // convierte date a calendar
                                                                     currDtCal= toCalendar(fecha_inicio);
                                                                     currDtCalFin= toCalendar(fecha_fin);
                                                                    //modifica los calendar 
                                                                    currDtCal.set(Calendar.HOUR_OF_DAY, hora_inicio.getHours());
                                                                    currDtCal.set(Calendar.MINUTE, hora_inicio.getMinutes());
                                                                    currDtCal.set(Calendar.SECOND,0);
                                                                    currDtCal.set(Calendar.MILLISECOND, 0);     
                                                                    currDtCalFin.set(Calendar.HOUR_OF_DAY, hora_fin.getHours());
                                                                    currDtCalFin.set(Calendar.MINUTE, hora_fin.getMinutes());
                                                                    currDtCalFin.set(Calendar.SECOND, 0);
                                                                    currDtCalFin.set(Calendar.MILLISECOND, 0);
                                                                    // convierte calendar a date
                                                                     fecha_inicio1 = currDtCal.getTime();
                                                                     fecha_fin1 = currDtCalFin.getTime();

                                                                     if ( (obtenerFechaActual().after(fecha_inicio1)  || obtenerFechaActual().equals(fecha_inicio1)) && (obtenerFechaActual().before(fecha_fin1)  || obtenerFechaActual().equals(fecha_fin1)) )
                                                                     {
                                                                           System.out.println("habilitado extemproaneo");
                                                                             // te lanza el numero de pago que siempre es diferente de 0
                                                                                 habilitado= cronograma.getCepCecCronogramaCab().getNumPago();
                                                                              break;
                                                                     }  
                                                         }
                                     }
                                }
                 }
          
         }
  
           
           
         
         return habilitado;
     }
    
     


    
     
   
}
