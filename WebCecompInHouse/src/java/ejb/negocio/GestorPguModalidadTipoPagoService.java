/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.PguModalidadDAOLocal;
import ejb.dao.PguModalidadTipoPagosDAOLocal;
import entidades.PguModalidadTipospagos;
import entidades.PguTipoPagos;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorPguModalidadTipoPagoService implements GestorPguModalidadTipoPagoServiceLocal {

    @EJB
    private PguModalidadDAOLocal pguModalidadDAO;

    @EJB
    private PguModalidadTipoPagosDAOLocal pguModalidadTipoPagosDAO;

    
    
    
    
    @Override
    public PguModalidadTipospagos crearNuevoModalidadTipago(PguModalidadTipospagos entidad) {
        return pguModalidadTipoPagosDAO.crear(entidad);
    }
    
    
    
    
    @Override
    public PguModalidadTipospagos actualizarNuevoModalidadTipago(PguModalidadTipospagos entidad) {
        return pguModalidadTipoPagosDAO.actualizar(entidad);
    }
    
    @Override
    public PguModalidadTipospagos buscarModalidadPago(PguTipoPagos tipopagos) {
        PguModalidadTipospagos entidad = new PguModalidadTipospagos();
        entidad=pguModalidadTipoPagosDAO.buscarModalidadPago(tipopagos.getIdTipopag());
        
        if (entidad!=null) {
            // encuentra y retorna
            return entidad;
        }else{
            entidad = new PguModalidadTipospagos();
            // SINO ENCUENTRA CREA en pgu_modalidad_tipopagos
            int id_modld=1;
            String descr="Creado por el Sistema Web Cecomp";
            Float nro_parte = Float.valueOf(1) ;
            Float InteresMora = Float.valueOf(0);
            Short diasmora = 0;
            Boolean active = true;
            // guarda la entidad del pgu_Tipo_pago
            entidad.setPguTipoPagos(tipopagos);
            // llama y guarda la entidad de pgumodalidad con id 1 que es al contado
            entidad.setPguModalidad(pguModalidadDAO.buscarPorId(id_modld));
            // en la descripcion se detallara que fue creado via web
            entidad.setDescripcion(descr);
            // el numero de partes es 1 por defecto
            entidad.setNroPartes(nro_parte);
            // copia el precio del concpeo del tipo pago 
            entidad.setMontoPagar(tipopagos.getPrecio());
            // el numero de dias de mora e interes es  0 porque no se aplica
            entidad.setMontoMora(InteresMora);
            entidad.setInteres(InteresMora);
            entidad.setNrodiasMora(diasmora);
            entidad.setActivo(active);
            System.out.println("guardo en modalidadpagos");
            // retorna la modalidadtipopagoCreada
            return crearNuevoModalidadTipago(entidad);  
        }
       
    }
    
}
