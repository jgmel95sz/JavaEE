/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.PguPagospersDet;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface PguPagosDetDAOLocal extends GenericoJPADAOLocal<PguPagospersDet> {
        public Short buscarPago(String secuencia, Date fecha_ope, Float monto ,Integer dir);                           
        public PguPagospersDet buscarPagoPorAlumnoMatriculado(Integer id_pgucab);
           public List<PguPagospersDet> BuscarDirParaValidarVoucher(String secuencia, Date fecha, Float monto );

}
