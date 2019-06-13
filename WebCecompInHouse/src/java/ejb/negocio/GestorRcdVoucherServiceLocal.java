/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.InversionCurso;
import entidades.RcdVoucher;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorRcdVoucherServiceLocal {
        
  public InversionCurso buscarVoucher(List<InversionCurso> lstInversion, Integer secuencia, Short agencia, String codigo_est ,Date fechapago,Integer dir,String dni, Integer tipo_alumno);
  public Short validarVoucher(Integer secuencia, Date fecha_ope, Float monto ,Integer dir);
  public RcdVoucher recuperarEntidad(int id);
  public RcdVoucher actualizarEntidad(RcdVoucher entidad);
  
}
