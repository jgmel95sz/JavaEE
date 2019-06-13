/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.InversionCurso;
import ejb.dao.InversionDAOLocal;
import ejb.dao.tipoInversionDAOLocal;
import entidades.CepCecInversionCurso;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorInversionService implements GestorInversionServiceLocal {

    @EJB
    private tipoInversionDAOLocal tipoInversionDAO;

    @EJB
    private InversionDAOLocal inversionDAO;
    
   
    

    @Override
    public List<CepCecInversionCurso>buscarInversion(Integer idCurSubDet, Integer id_tipo_iver) {
        System.out.println("ENTRO A SERVICE");
        return inversionDAO.buscarInversion(idCurSubDet,id_tipo_iver);
    }
    
    @Override
    public List<InversionCurso> buscarInversionPorTipo(Integer idCurSubDet,Integer tipoAlumno,Integer idconcepto) {
        
         List<InversionCurso> ListaEntidad = new ArrayList<>();
         List<CepCecInversionCurso> lista = new ArrayList<>();
         // guarda en una lista todas las inversiones de matricula tipo 1 y 2 segun el tipo de alumno que haya iniciado sesion y el curso que selecciono
         lista= inversionDAO.buscarInversionPorTipoAlmuno(idCurSubDet, tipoAlumno,idconcepto);
              
       if (lista!=null) {
           //** burbuja para ordenar SIEMPRE la Media Beca va ir Primero en la Lista , que es necesario para la validacion
           // de los voucher siempre primero verifique las medias becas si existieran
            System.out.println("/*****************************");
            for (int i = 0; i < lista.size(); i++) {
                for (int j = 0; j < lista.size() - 1 - i; j++) {
                    if ( lista.get(j).getCepCecTipoInversion().getIdTipoinversion() < lista.get(j+1).getCepCecTipoInversion().getIdTipoinversion()) {
                        CepCecInversionCurso aux = lista.get(j);
                        lista.set(j, lista.get(j+1));
                        lista.set(j+1, aux);
                         }
                     }
              } 
           
              System.out.println("/*****************************");
           // recorre la lista para verificar si se puede pagar el monto total para mostrarlo en la vista
              Integer cont_id=0;
               for (int i = 0; i <lista.size(); i++) {
                  System.out.println(""+lista.get(i).getPrecioPension());
                  
                  InversionCurso temp = new InversionCurso();
                  //crea un id
                  temp.setIdInversionCurso(cont_id);
                  //  por cada iteracion guarda el codigo 
                  temp.setCodigo(lista.get(i).getRcdConcepto().getIdConcepto());
                  // por cada iteracion guarda el precio
                  temp.setPrecio(lista.get(i).getPrecioPension());
                  // se agrega el codigo de inversion que se genero en nuestra tablas
                  temp.setInversion(lista.get(i).getIdInversion());
                 
                  // se agrega la conidicion NORMAL,MEDIA BECA, BECA COMPLETA
                  temp.setCondicion_alumno(lista.get(i).getCepCecTipoInversion().getIdTipoinversion());
                  // se agrega el tipo de alumno
                  temp.setId_tipo_alumno(lista.get(i).getCepCecTipAlumno().getIdTipAlumno());
                
                  
                    //por cada iteracion verifica de que tipo es la inversion y guarda su descripcion
                  if (lista.get(i).getCepCecTipoInversion().getIdTipoinversion()==1 && lista.get(i).getUnicoPagototal()==false) {
                       if (lista.get(i).getCepCecCursoSubdet().getFormaPago()==1) {
                           temp.setDescripcion("Concepto Pago por Mes");
                        }else{
                           if (lista.get(i).getCepCecCursoSubdet().getFormaPago()==2) {
                               temp.setDescripcion("Concepto Pago por Cuota");
                           }
                       }
                            // el pago total sera false
                            temp.setPagoTotal(false);
                             // se agrega el nombre
                             temp.setNombre(lista.get(i).getNombreConcepto());
                  }else{
                      if (lista.get(i).getCepCecTipoInversion().getIdTipoinversion()==1 && lista.get(i).getUnicoPagototal()==true) {
                           temp.setDescripcion("Concepto para el pago unico");
                           // el pago total sera false
                           temp.setPagoTotal(true);
                           // se agrega el nombre
                           temp.setNombre(lista.get(i).getNombreConcepto());
                      }else{
                               if (lista.get(i).getCepCecTipoInversion().getIdTipoinversion()==2 && lista.get(i).getUnicoPagototal()==false) {
                               
                                   if (lista.get(i).getCepCecCursoSubdet().getFormaPago()==1) {
                                       temp.setDescripcion("Concepto Pago  1/2 Beca por Mes");  
                                   }else{
                                        temp.setDescripcion("Concepto Pago  1/2 Beca por Cuota"); 
                                   }
                                   
                                 // el pago total sera false
                                 temp.setPagoTotal(false);
                                 // se agrega el nombre
                                 temp.setNombre(lista.get(i).getNombreConcepto());
                                }else{
                                   if (lista.get(i).getCepCecTipoInversion().getIdTipoinversion()==2 && lista.get(i).getUnicoPagototal()==true){
                                         temp.setDescripcion("Concepto Pago Total 1/2 Beca");  
                                          // el pago total sera true
                                           temp.setPagoTotal(true);
                                           // codigo endurado no cambiar la cadena porque por el nombre se verificara la repeticion de conceptos en pgu
                                           //String name_completo = lista.get(i).getNombreConcepto()+" - Pago Completo"; 
                                           String name_completo = lista.get(i).getNombreConcepto();
                                           temp.setNombre(name_completo);
                                   }
                                }
                      }
               
                  }
                  
                  // agrega la entidad en la lista
                  ListaEntidad.add(temp);
                  cont_id++;
                  // si se da el caso que el costo total tambien es aceptable como pago entonces se crea una nueva fila en la lista
                  // añadiendo su costo descripcion y concepto
                  if (lista.get(i).getConceptoTotal()==1 && lista.get(i).getUnicoPagototal()==false) {
                    temp = new InversionCurso();
                    //crea un id
                    temp.setIdInversionCurso(cont_id);
                    temp.setCodigo(lista.get(i).getRcdConcepto().getIdConcepto());
                    temp.setPrecio(lista.get(i).getPrecioTotal());  
                    // se agrega el codigo de inversion que se genero en nuestra tablas
                    temp.setInversion(lista.get(i).getIdInversion()); 
                    //pagto total si es 
                    temp.setPagoTotal(true);
                    // codigo endurado no cambiar la cadena porque por el nombre se verificara la repeticion de conceptos en pgu
                    String name_completo = lista.get(i).getNombreConcepto()+" - Pago Completo";
                     temp.setNombre(name_completo);
                    // se agrega la conidicion NORMAL,MEDIA BECA, BECA COMPLETA
                    temp.setCondicion_alumno(lista.get(i).getCepCecTipoInversion().getIdTipoinversion()); 
                     
                     if (lista.get(i).getCepCecTipoInversion().getIdTipoinversion()==1){
                      temp.setDescripcion("Concepto Pago total del curso");
                      
                    }
                     if (lista.get(i).getCepCecTipoInversion().getIdTipoinversion()==2 ){
                       temp.setDescripcion("Concepto Pago total 1/2 Beca"); 
                     }
                       // se agrega el tipo de alumno
                     temp.setId_tipo_alumno(lista.get(i).getCepCecTipAlumno().getIdTipAlumno());
                    // se agrega a la lista nueva fila
                    ListaEntidad.add(temp);
                    cont_id++;
                  }
                  
                 
           }
           
        

       }
       
    
     
     return ListaEntidad;
    }

    @Override
    public CepCecInversionCurso crearInversion(CepCecInversionCurso Inversion) {
        return inversionDAO.crear(Inversion);
    }
    
    
     @Override
    public CepCecInversionCurso recuperarEntidadInversion(int id) {
        return inversionDAO.buscarPorId(id);
    }
    
     @Override
    public boolean validarSiExisteInversionporCurso(int idCursoSubDet) {
        return ( inversionDAO.validarSiExisteInversionporCurso(idCursoSubDet)) !=null;
    }
    
      @Override
    public CepCecInversionCurso actualizarInversion(CepCecInversionCurso inversion) {
        return inversionDAO.actualizar(inversion);
    }
    
    
    
    @Override
    public CepCecInversionCurso buscarInversioNula(Integer idCurSubDet,Float precio,Short estadoConcepto,Integer tipoInver,Integer rcd) {
           
      // public CepCecInversionCurso buscarInversionNulo(Integer idCurSubDet,Float precio,Short estadoConcepto,Integer tipoInver, Integer rcd) ;
      // si no encuentra entonces  envia nulo, pero si encuentra envia la entidad encontrada
       if ( inversionDAO.buscarInversionNulo(idCurSubDet, precio, estadoConcepto, tipoInver, rcd) != null) {
            return inversionDAO.buscarInversionNulo(idCurSubDet, precio, estadoConcepto, tipoInver, rcd);
        }
          else{
              return null;
         }
    }
    
    @Override
    public CepCecInversionCurso buscarCostoTotal(Integer id_cursosubdet ,Integer tipo_alu,Integer tipo_inver) {
        // solo retorno la unica entidad de la lista
        return inversionDAO.buscarCostoTotal(id_cursosubdet, tipo_alu, tipo_inver).get(0);  
    }
    
    
     @Override
    public List<CepCecInversionCurso> listaInversion(Integer id_cursosubdet, Integer tipo_alu){
        // solo retorno la unica entidad de la lista
        return inversionDAO.listaInversion(id_cursosubdet, tipo_alu);  
    }

    
    // paara poder validar si la nueva inversion ya no tiene un monto asignado
    @Override
    public boolean inversionExiste(Integer idcursosub , Integer idtipoalu, Integer idtipoinver){
           if (inversionDAO.buscarCostoTotal(idcursosub, idtipoalu, idtipoinver)==null) {
               System.out.println("Sipuede crear una nueva inversion");
               return false;
           }else{
               System.out.println("No se puede crear una nueva inversion");
              return true;
            } 
         
    }
    
    @Override
    public CepCecInversionCurso inversionBeca(Integer idcursosub , Integer idtipoalu, Integer idtipoinver){
        List<CepCecInversionCurso> inversion = new ArrayList<>();
        inversion =  inversionDAO.buscarCostoTotal(idcursosub, idtipoalu, idtipoinver);   
         if (inversion!=null) {
             return inversion.get(0);
         }else{
           return null; 
         }
        
    }
    
    
     @Override
    public CepCecInversionCurso buscarInver(Integer id_cursosubdet ,Integer tipo_alu,Integer tipo_inver) {
        // solo retorno la unica entidad de la lista
        return inversionDAO.buscarInver(id_cursosubdet, tipo_alu, tipo_inver);  
    }
    
    
}
