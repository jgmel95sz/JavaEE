/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.PguBancoPagoDAOLocal;
import ejb.dao.PguOrigenPagoDAOLocal;
import ejb.dao.PguPagosDetDAOLocal;
import entidades.PguModalidadTipospagos;
import entidades.PguPagospersCab;
import entidades.PguPagospersDet;
import entidades.PguPagospersDetPK;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorPguPagoDetService implements GestorPguPagoDetServiceLocal {

    @EJB
    private GestorPguPagosCabServiceLocal gestorPguPagosCabService;

    @EJB
    private PguOrigenPagoDAOLocal pguOrigenPagoDAO;

    @EJB
    private PguBancoPagoDAOLocal pguBancoPagoDAO;

    @EJB
    private PguPagosDetDAOLocal pguPagosDetDAO;
    
    
    

   @Override
    public PguPagospersDet crearNuevoPagoDet(PguPagospersCab pguPagosCab,PguModalidadTipospagos modtipago,Date fecha_pago,Integer secuencia,Float monto ) {
                  
                   PguPagospersDet pguPagospersDet = new PguPagospersDet();
                   PguPagospersDetPK pguPagospersDetPK  = new PguPagospersDetPK();
                   // guarda la cabecera
                   pguPagospersDet.setPguPagospersCab(pguPagosCab);
                   System.out.println("guardo cabecera");
                    //guarda el id_modltipo
                   pguPagospersDet.setPguModalidadTipospagos(modtipago);
                  System.out.println("guardo modltip");
                   // guarda id origen pago
                   Integer id_origenpag=1;
                   pguPagospersDet.setPguOrigenPago(pguOrigenPagoDAO.buscarPorId(id_origenpag));  
                  System.out.println("guardo origen");
                   // id esc  null
                   // id mesd null
                   // guarda id banco
                   Integer id_banco = 2; // de la nacion
                   pguPagospersDet.setPguBancoPago(pguBancoPagoDAO.buscarPorId(id_banco));
                  System.out.println("guardo banco");
                 
                   // poner id porque PK es otra entidad
                   pguPagospersDetPK.setIdNumpago(pguPagosCab.getIdNumpago());
                   pguPagospersDetPK.setIdModltipo(modtipago.getIdModltipo());
                   
                  
                   pguPagospersDetPK.setFechaPago(gestorPguPagosCabService.obtenerFechaActual());
                  // pguPagospersDet.getPguPagospersDetPK().setFechaPago(gestorPguPagosCabService.obtenerFechaActual());
                  System.out.println("guardo fecha");
                   short nro_cuota=1;
                   pguPagospersDetPK.setNroCuota(nro_cuota);
                    //pguPagospersDet.getPguPagospersDetPK().setNroCuota(nro_cuota);
                   System.out.println("guardo cuota");
                   short nro_parte=1;
                   pguPagospersDetPK.setNroParte(nro_parte);
                   // pguPagospersDet.getPguPagospersDetPK().setNroParte(nro_parte);
                   System.out.println("guardo parte");
                   // fecha que se pago  voucher
                   pguPagospersDet.setFechaOper(fecha_pago);
                   System.out.println("guardo fechapago");
                    // secuencia
                   pguPagospersDet.setNroOperacion(convertirSecuencia(secuencia));
                   System.out.println("guardo secuencia");
                    // monto 
                   pguPagospersDet.setMonto(monto);
                   System.out.println("guardo monto");
                   //observ
                   String obs="Creado por el Sistema Web Cecomp";
                   pguPagospersDet.setObserv(obs);
                   System.out.println("guardo obse");
                   //estado
                   boolean estado = true;
                   //pguPagospersDetPK.setEstado(estado);
                   pguPagospersDet.setEstado(estado);
                   System.out.println("guardo estado");
                   pguPagospersDet.setHoraPago(gestorPguPagosCabService.obtenerFechaActual());
                   System.out.println("guardo horapago"); 
                   pguPagospersDet.setPguPagospersDetPK(pguPagospersDetPK);
                   System.out.println("guaro pk");
                   return pguPagosDetDAO.crear(pguPagospersDet);
    }
    
    public String convertirSecuencia (Integer secuencia){
    
       // se convierte a String la secuencia ya que en las tablas de pagos esta como String 
           // asi que se convierte a string y se agrega ceros si la longitud no es de 7
           String secuenciaCad= "0000000000"+secuencia;
           String nvSecuenciacad = "";
           String secuenciaFinal="";
           System.out.println("la secuencia es "+secuenciaCad);
           
           int contador=0;
           int i = secuenciaCad.length()-1;
           while (contador<7) {               
               nvSecuenciacad =  nvSecuenciacad + secuenciaCad.charAt(i); 
               contador++;
               i--;
           }
           System.out.println("la nueva secuencia  es "+nvSecuenciacad);
           for (int j = nvSecuenciacad.length()-1; j >=0  ; j--) {
               secuenciaFinal = secuenciaFinal + nvSecuenciacad.charAt(j);
           }
           System.out.println("secuncia final "+secuenciaFinal);
           return secuenciaFinal;
    }
    
    @Override
    public PguPagospersDet buscarPagoPorAlumnoMatriculado(Integer id_pgucab){
       // PguPagospersDet entidad = new PguPagospersDet();
        return  pguPagosDetDAO.buscarPagoPorAlumnoMatriculado(id_pgucab);
    }
    
     @Override
    public PguPagospersDet actualizarPguDet(PguPagospersDet entidad) {
        return pguPagosDetDAO.actualizar(entidad);
    }
    
    
}
