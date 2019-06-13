/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.PguPagosCabDAOLocal;
import entidades.PguPagospersCab;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorPguPagosCabService implements GestorPguPagosCabServiceLocal {

    @EJB
    private PguPagosCabDAOLocal pguPagosCabDAO;

  @Override
    public PguPagospersCab crearNuevoPagoCab(Integer id_dir) {
        Integer id_dep = 113;
        Float saldo = Float.valueOf(0);
        Float mora = Float.valueOf(0);
        Boolean estado = true;
        String observ = "Creado por el Sistema Web Cecomp";
        PguPagospersCab entidad =new  PguPagospersCab();
        entidad.setIdDep(id_dep);
        entidad.setIdDir(id_dir);
        entidad.setFecha(obtenerFechaActual());
        entidad.setSaldo(saldo);
        entidad.setMora(mora);
        entidad.setEstado(estado);
        entidad.setObservacion(observ); 
        return pguPagosCabDAO.crear(entidad);
    }
    
      @Override
     public Date obtenerFechaActual(){
       //Obtenemos fecha y hora actuales
         Calendar currDtCal = Calendar.getInstance();
        //Guardamos la fecha y hora actuales sin segundos ni milisegundos
        Date actual = currDtCal.getTime();
        return actual;
    }
     
    @Override
    public PguPagospersCab actualizarPguCab(PguPagospersCab plan) {
        return pguPagosCabDAO.actualizar(plan);
    }
    
   @Override
    public PguPagospersCab recuperarPguCab(int id) {
        return pguPagosCabDAO.buscarPorId(id);
    } 
     
     
}
