/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;
import clases.InversionCurso;
import ejb.dao.pguTipoPagosDAOLocal;
import entidades.OrgDependencia;
import entidades.PguGrupoTipospagos;
import entidades.PguTipoPagos;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */

@Stateless
public class GestorTipoPagosService implements GestorTipoPagosServiceLocal {

    @EJB
    private GestorGrupoTipoPagoServiceLocal gestorGrupoTipoPagoService;

    @EJB
    private GestorOrgDependeciaServiceLocal gestorOrgDependeciaService;


    @EJB
    private pguTipoPagosDAOLocal pguTipoPagosDAO;
    

    
    
    @Override
    public PguTipoPagos crearNuevoTipoPago(PguTipoPagos entidad) {
        return pguTipoPagosDAO.crear(entidad);
    }
   
      @Override
    public List<PguTipoPagos> buscarTodosConceptosCecomp(String name) {
         System.out.println("EN  NEGOCIO");
        return pguTipoPagosDAO.buscarTodosConceptosCecomp(name);
    }
    
    
    
     @Override
    public PguTipoPagos capturarPrecio(Integer idTipPag) {
         System.out.println("EN  NEGOCIO");
        return pguTipoPagosDAO.capturarPrecio(idTipPag);
    }
    
     @Override
    public PguTipoPagos recuperarIdTipPag(int id) {
         
        return pguTipoPagosDAO.buscarPorId(id);
    }
    

    @Override
    public PguTipoPagos buscarConcepto(InversionCurso inversion) {
         System.out.println("EN  NEGOCIO");
         PguTipoPagos entidad = new PguTipoPagos();
         entidad = pguTipoPagosDAO.buscarRepeticionConcepto(inversion.getNombre(),inversion.getPrecio());
         if (entidad!=null) {
             System.out.println("Ya existe el concepto con el mismo precio");
              return entidad ; 
         }else{
              entidad = new PguTipoPagos();
             //******************* CREA NUEVO TIPOPAGO********************************************
               System.out.println("no existe el concepto por lo que sera creado");
             OrgDependencia orgDepende = new OrgDependencia();
             PguGrupoTipospagos GrupoTipopag = new PguGrupoTipospagos();
             Integer id_dep = 113;
             int id_grupopag = 4;
             Integer id_ambito = 11; 
             Short orden = 32767;
             // llama la entidad de la dependecia del centro de computo que su id es el 113 en la tabla org_dependencia
             System.out.println("orgde");
             orgDepende = gestorOrgDependeciaService.recuperarOrgDependencia(id_dep);
 
             entidad.setOrgDependencia(orgDepende);
             System.out.println("setio org");
            //accper null
             //ciclo null
             // recupera la entidad de tipo 4 que sirve para los tipo de pagos del centro de computo

             System.out.println("grupotipopago"); 
             GrupoTipopag = gestorGrupoTipoPagoService.recuperarPguGrupoTipoPago(id_grupopag);
             
             entidad.setPguGrupoTipospagos(GrupoTipopag);
             System.out.println("setio grupotipopag");
             // ingresa el nombre del concepto y el precio que se creo de la inversion del curso que se ah pagado
             entidad.setConcepto(inversion.getNombre());
             System.out.println("setio getnombre");
             entidad.setPrecio(inversion.getPrecio());
             System.out.println("setio getprecio");

             // llama a la clase obtenerAnioActual() que me retorna el año acutal del sistema
             entidad.setAnio(obtenerAnioActual());
             Boolean estado = true;
             entidad.setActivo(estado);
             // id_jerdup  null
             // id_especialidad null
             // id_curso null
             // idambito no llama a entidad, escodigoendurado
             entidad.setIdAmbito(id_ambito);
             // idfacultado null
             // orden endurado 32767
             entidad.setOrden(orden);
             // crea la entidad
             entidad = crearNuevoTipoPago(entidad);
             System.out.println("creo nuevo concepto");
             return entidad;  
         }

    }
    
   
    public Short obtenerAnioActual(){
        //Obtenemos fecha y hora actuales
       Calendar currDtCal = Calendar.getInstance();
        Integer a  = currDtCal.get(Calendar.YEAR);
        Short anio = a.shortValue();
        return anio;
    }
    
    
  
    
}
