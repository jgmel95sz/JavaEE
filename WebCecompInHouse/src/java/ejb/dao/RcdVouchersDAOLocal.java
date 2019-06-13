/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.RcdVoucher;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface RcdVouchersDAOLocal  extends GenericoJPADAOLocal<RcdVoucher>{
    public List<RcdVoucher> buscarPagoDeVoucherAlumno(String cod_alumno, Integer secuencia, Date fecha, Short agencia, Integer concepto);
    public List<RcdVoucher> buscarPagoDeVoucherAluGeneral(String dni, Integer secuencia, Date fecha, Short agencia, Integer concepto );

}
