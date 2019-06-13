/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.InversionCurso;
import ejb.dao.MatriTiposDAOLocal;
import ejb.dao.MatriculaPagoDAOLocal;
import ejb.dao.PguPagosDetDAO;
import ejb.dao.PguPagosDetDAOLocal;
import entidades.CepCecExonerados;
import entidades.CepCecInversionCurso;
import entidades.CepCecMatriAlu;
import entidades.CepCecMatriPago;
import entidades.CepCecTipoMatri;
import entidades.PguPagospersCab;
import entidades.PguPagospersDet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorMatriPagoService implements GestorMatriPagoServiceLocal {

    @EJB
    private PguPagosDetDAOLocal pguPagosDetDAO;

    @EJB
    private GestorPguPagosCabServiceLocal gestorPguPagosCabService;

    @EJB
    private MatriTiposDAOLocal matriTiposDAO;

    @EJB
    private MatriculaPagoDAOLocal matriculaPagoDAO;

    @Override
    public CepCecMatriPago crearMatriPago(CepCecMatriAlu cepCecMatriAlu, PguPagospersCab pguPagospersCab, Integer tipomatri,Integer condicion , Boolean isPagoTotal,Integer codconcepto, Integer numCronogramaPago) {
        CepCecMatriPago cepCecMatriPago = new CepCecMatriPago();
        //CepCecTipoMatri cepCecTipoMatri = new CepCecTipoMatri();

        cepCecMatriPago.setCepCecMatriAlu(cepCecMatriAlu);
        //int id_tipo_matricula = 2; // 1:inscripcion 2: Pension  3:extemporaneo 4:examen subsanacion 5:examen otro 6:certificado
        cepCecMatriPago.setCepCecTipoMatri(matriTiposDAO.buscarPorId(tipomatri));
        cepCecMatriPago.setPguPagospersCab(pguPagospersCab);
        cepCecMatriPago.setFechaRegMp(gestorPguPagosCabService.obtenerFechaActual());
        cepCecMatriPago.setHoraRegMp(gestorPguPagosCabService.obtenerFechaActual());
        cepCecMatriPago.setNumCuota(numCronogramaPago);
        cepCecMatriPago.setCodConcepto(codconcepto);
        // 1: pago normal
        //2 media beca
         cepCecMatriPago.setCondicionAlu(condicion);
         cepCecMatriPago.setIsPagototal(isPagoTotal);
        Short estado = 1;
        cepCecMatriPago.setEstadoMat(estado);
        return matriculaPagoDAO.crear(cepCecMatriPago);
    }

    
    @Override
    public CepCecMatriPago crearMatriPagoParaExonerados(CepCecMatriAlu cepCecMatriAlu, Integer tipomatri,Integer condicion , Boolean isPagoTotal,CepCecExonerados cepCecExonerados,Integer numCronogramaPago ) {
        CepCecMatriPago cepCecMatriPago = new CepCecMatriPago();
        //CepCecTipoMatri cepCecTipoMatri = new CepCecTipoMatri();
       
        cepCecMatriPago.setCepCecMatriAlu(cepCecMatriAlu);
        //int id_tipo_matricula = 2; // 1:inscripcion 2: Pension  3:extemporaneo
        cepCecMatriPago.setCepCecTipoMatri(matriTiposDAO.buscarPorId(tipomatri));
        //cepCecMatriPago.setPguPagospersCab(pguPagospersCab);
        cepCecMatriPago.setFechaRegMp(gestorPguPagosCabService.obtenerFechaActual());
        cepCecMatriPago.setHoraRegMp(gestorPguPagosCabService.obtenerFechaActual());
        //cepCecMatriPago.setCepCecExonerados(cepCecExonerados);
        // 7: beca
        //8 descuento planilla
        //
         cepCecMatriPago.setCondicionAlu(condicion);
         cepCecMatriPago.setNumCuota(numCronogramaPago);
         cepCecMatriPago.setIsPagototal(isPagoTotal);
        Short estado = 1;
        cepCecMatriPago.setEstadoMat(estado);
        cepCecMatriPago.setIdVoucherFicticio(cepCecExonerados.getIdExonerados());
        return matriculaPagoDAO.crear(cepCecMatriPago);
    }
    
    @Override
    public CepCecMatriPago recuperarEntidadPago(int id) {
        return matriculaPagoDAO.buscarPorId(id);
    }

    @Override
    public CepCecMatriPago actualizarMatriPago(CepCecMatriPago entidad) {
        return matriculaPagoDAO.actualizar(entidad);
    }

    @Override
    public Integer buscarSizePagosPorAlumno(int id_matri) {
        System.out.println("NEGOCIO PAGO");
        return matriculaPagoDAO.buscarSizePagosPorAlumno(id_matri);
    }

    @Override
    public CepCecMatriPago buscarPagoMatriculaPorAlumno(Integer id_matri) {
        return matriculaPagoDAO.buscarPagoMatriculaPorAlumno(id_matri);
    }

    @Override
    public List<CepCecMatriPago> buscarPagosPorMatricula(Integer id_matri) {
        return matriculaPagoDAO.buscarPagosPorMatricula(id_matri);
    }

    @Override
    public List<Integer> generarListaDePagosPensionMatricula(Integer num_cuotas) {
        // declaras la lista
        List<Integer> lista = new ArrayList<>();
        Integer x = 1;

        if (num_cuotas > 0) {
            // recorres while
            while (x <= num_cuotas) {
                lista.add(x);
                x++;
            }
        }
        return lista;
    }

  /*  @Override
    public List<Integer> listarConformidadPagosMatriculaPorAlumno(CepCecMatriAlu cecMatriAlu, List<CepCecInversionCurso> lstinversion) {
        List<Integer> conformidad = new ArrayList<>();
        List<CepCecMatriPago> pagos = matriculaPagoDAO.buscarPagosPorMatricula(cecMatriAlu.getIdMatriAlu()); // solo sin son matricula o pension
        if (pagos != null) {
            int numero_cuotas = pagos.get(0).getCepCecMatriAlu().getCepCecCurGrup().getCepCecCursoSubdet().getNumCuotas();
            System.out.println("num cuotas es = " + numero_cuotas);
            // ingresa a la lista si pago 
            for (CepCecMatriPago pago : pagos) {
                conformidad.add(1); //´PAGO
            }
            
           
            //ahora si la lista supongamos que haya hecho 2 pagos, pero el numero de cuotas ah pagar 
            //del curso es 5 entonces hace una resta 5-2 = 3 entonces a las tres siguiente le pondra un guion
            if (pagos.size() < numero_cuotas) {
                int hasta = numero_cuotas - pagos.size();
                CepCecInversionCurso inversion= new CepCecInversionCurso();
                //coge la matricula_pago segun el tipo de condicion que tiene el pago 1:normal 2:media beca 7:beca
                // asi capturo la inversion correcta del pago 
                   for (CepCecInversionCurso inver : lstinversion) {
                         if (inver.getCepCecTipoInversion().getIdTipoinversion()==pagos.get(0).getCondicionAlu()) {
                            inversion = inver;
                        }
                    }

                
                if (inversion.getConceptoTotal() == 1) { //si se puede pagar al concepto total entonces
                    inversion.getPrecioTotal();
                    Integer numpago = pagos.get(0).getPguPagospersCab().getIdNumpago(); // coge el primer pago y su id de numpago
                    PguPagospersDet pgu = new PguPagospersDet();
                    // trae el pago
                    pgu = pguPagosDetDAO.buscarPagoPorAlumnoMatriculado(numpago);
                    if (pgu != null) {
                        // verifica si es el monto pagado es igual al monto total  
                        System.out.println("monto de pgu " + pgu.getMonto());
                        System.out.println("verifica monto");
                        int retval = Float.compare(pgu.getMonto(), inversion.getPrecioTotal());
                        if (retval == 0) { //si es 0 entonces si pago pago completo
                            for (int i = 0; i < hasta; i++) {
                                conformidad.add(3); // PAGO COMPLETO
                            }
                        } else {//si es diferente de 0 entonces es porque no pago completo 
                            for (int i = 0; i < hasta; i++) {
                                conformidad.add(0); // - 
                            }
                        }
                    }

                } else {

                    for (int i = 0; i < hasta; i++) {
                        conformidad.add(0); // - 
                    }
                }

            }
        }

        return conformidad;
    }
    */
    
    
     @Override
    public List<Integer> listarConformidadPagosMatriculaPorAlumno(CepCecMatriAlu cecMatriAlu) {
         ///*** CONDICION***//
         // 0 = NO PAGO
         // 1 = PAGO NORMAL 
         // 2 = PAGO 1/2 BECA
         // 7 = BECA 
         // 8 = DESC.PLANILLA
         
         // 10 = PAGO NORMAL COMPLETO (TODO EL CURSO) (UN SOLO PAGO)
         // 20 = PAGO 1/2 BECA COMPLETO (TODO EL CURSO) (UN SOLO PAGO)
         // 70 = BECA COMPLETO (TODO EL CURSO) (UN SOLO PAGO)
         // 80 = DESC.PLANILLA COMPLETO (TODO EL CURSO) (UN SOLO PAGO)
        
        int bandIsPagoTotal=0;
        Integer condicion = null;
        List<Integer> conformidad = new ArrayList<>();
        List<CepCecMatriPago> pagos = matriculaPagoDAO.buscarPagosPorMatricula(cecMatriAlu.getIdMatriAlu()); // solo sin son matricula o pension
         if (pagos!=null) {
             
      
          
                 int numero_cuotas = cecMatriAlu.getCepCecCurGrup().getCepCecCursoSubdet().getNumCuotas();
                 if (numero_cuotas>0) {
                     
                            System.out.println("num cuotas es = " + numero_cuotas);
                           // ingresa a la lista si pago 
                           for (CepCecMatriPago pago : pagos) {
                                 if (pago.getIsPagototal()) {
                                     condicion = pago.getCondicionAlu()*10;
                                     conformidad.add(condicion); //´total
                                     bandIsPagoTotal=1;
                                     break;
                                 }else{
                                     condicion=pago.getCondicionAlu();
                                     conformidad.add(condicion); // pagonoraml
                                     }
                           }


                           //ahora si la lista supongamos que haya hecho 2 pagos, pero el numero de cuotas ah pagar 
                           //del curso es 5 entonces hace una resta 5-2 = 3 entonces a las tres siguiente le pondra un guion
                           if (pagos.size() < numero_cuotas) {
                               int hasta = numero_cuotas - pagos.size();


                                      if (bandIsPagoTotal==1) { //es pago total

                                           for (int i = 0; i < hasta; i++) {
                                                conformidad.add(condicion); // - 
                                           }

                                       } else {

                                           for (int i = 0; i < hasta; i++) {
                                               conformidad.add(0); // - 
                                           }
                                       }
                           }
                    
                }else{
                     System.out.println("Error 27! el numero de pagos del curso es  0");
                     conformidad.add(27);
                 }
                    
          }else{
           
                System.out.println("Error 28! El alumno  "+cecMatriAlu.getDrtPersonanatural().getNombreCompleto() + "debe tener minimo un pago (Matricula)");
                conformidad.add(28);
         } 
    
        return conformidad;
    }
    
    
    @Override
    public List<CepCecMatriPago> buscarAlumnosMatriculados(Integer id_grupo){
    return  matriculaPagoDAO.buscarAlumnosMatriculados(id_grupo);
    }

}
