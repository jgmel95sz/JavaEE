/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.InversionCurso;
import ejb.dao.PguPagosDetDAOLocal;
import ejb.dao.RcdVouchersDAOLocal;
import ejb.dao.UsuarioEstGeneralDAOLocal;
import entidades.PguPagospersDet;
import entidades.RcdVoucher;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorRcdVoucherService implements GestorRcdVoucherServiceLocal {

    @EJB
    private DescuentoExoServiceLocal descuentoExoService;

    @EJB
    private UsuarioEstGeneralDAOLocal usuarioEstGeneralDAO;

    @EJB
    private PguPagosDetDAOLocal pguPagosDetDAO;

    @EJB
    private RcdVouchersDAOLocal rcdVouchersDAO;
    
    
    
    public Integer buscarSemibecado(int id_inver_curso, String num_documento, int tipo_alumno){
          if  (descuentoExoService.validarSemiBecado(id_inver_curso,num_documento , tipo_alumno)==1){
               return 1;
           }else{
              return 0;
          }
    }
    
    @Override
    public InversionCurso buscarVoucher(List<InversionCurso> lstInversion , Integer secuencia, Short agencia, String codigo_est ,Date fechapago , Integer dir , String dni , Integer tipo_alumno ){
        // List<InversionCurso> lstInversion  me trae todos los conceptos segun el tipo de alumno y el curso
        int tieneMediaBeca =0; 
        Integer concepto;
         Short condicional = 0;
         List<RcdVoucher> lstvoucher = new ArrayList<>() ;
         InversionCurso resultado = new InversionCurso(); ;
         String doc_ide="";
         Integer id_rcdvoucher = null;
         String num_doc;
         if (tipo_alumno==1) {
            num_doc = codigo_est;
         }else{
           num_doc = dni;
         }
         
      ///PRIMERO SE TIENE QUE DEFINIR EL TIPO DE INVERSION QUE SE VERIFICARA , SI ES MEDIA BECA O NORMAL
          for ( InversionCurso item  : lstInversion) {
              //Busca si hay Inversion tipo Media Beca 
              if (item.getCondicion_alumno()==2 && item.getId_tipo_alumno()==tipo_alumno) {
                  //Si existen entonces verifica si el alumno esta asignado
                  tieneMediaBeca =   buscarSemibecado(item.getInversion(),num_doc,tipo_alumno);
                 break;
               }
          }
          
          
       List<InversionCurso> lstInversion2 = new ArrayList<>();  
       // si tiene media beca entonces llena en la lista la inversion  solo la  inversion de media beca 
       if (tieneMediaBeca == 1) {
            for (InversionCurso item : lstInversion) {
                if (item.getCondicion_alumno()==2 && item.getId_tipo_alumno()==tipo_alumno) {
                 lstInversion2.add(item);
               }
            }
        }else{
            for (InversionCurso item : lstInversion) {
                if (item.getCondicion_alumno()==1 && item.getId_tipo_alumno()==tipo_alumno) {
                 lstInversion2.add(item);
               }
            }
 
       }
  
   
         
         System.out.println("EN EL SERVICIO VOUCHER");
         // recorre todos los conceptos asignados para el curso , estos se asignaron en la vista de conceptos del curso
        for ( InversionCurso item  : lstInversion2) {
           // guarda el codigo del curso en la variable concepto de tipo entero
            concepto = item.getCodigo();
            System.out.println("concepto = "+concepto);
            System.out.println("ENTRO AL PRIMER FOR");
            System.out.println("inver ; " +item.getNombre());
            //Carga segun el tipo de alumno todos los vouchers del pagados en el banco al curso 
            // y lo almacena en la lista de rcd_voucher que se llamara lstvoucher
                switch (tipo_alumno) {
                    case 1:  
                        lstvoucher = rcdVouchersDAO.buscarPagoDeVoucherAlumno(codigo_est, secuencia, fechapago, agencia , concepto );
                        break;
                    case 2:  
                          doc_ide = "0000000"+dni ; // se agrega ceros porque en la tabla rcd_voucher se guarda de esa forma
                          lstvoucher = rcdVouchersDAO.buscarPagoDeVoucherAluGeneral(doc_ide, secuencia, fechapago, agencia, concepto);
                        break;
                    case 3:
                        // trabjador UNS
                          doc_ide = "0000000"+dni ; // se agrega ceros porque en la tabla rcd_voucher se guarda de esa forma
                          lstvoucher = rcdVouchersDAO.buscarPagoDeVoucherAluGeneral(doc_ide, secuencia, fechapago, agencia, concepto);

                        break;
                    default:
                        throw new AssertionError();
                }
          
          
            
                        // busca el voucher
                        if (lstvoucher !=null ) {
                            // si la lista es diferente de null es porque encontro el voucher en rcd_voucher
                            // verifica si los montos son correctos 
                            System.out.println("va entrar al segundo for");
                            //lstvoucher = rcdVouchersDAO.buscarPagoDeVoucherAlumno(codigo_est, secuencia, fechapago, agencia , concepto );
                         

                                    for (RcdVoucher voucher : lstvoucher) {
                                         System.out.println("ENTRA AL SEGUNDO  for ");
                                         System.out.println("mi precio"+item.getPrecio());

                                         int result = Float.compare(voucher.getImportePagado(), item.getPrecio());
                                        // si es 1 -> a es mayor q b   
                                        // si es 0 -> son iguales
                                        // si es diferente entonces b es mayor que a


                                         if (result==0) {
                                             System.out.println("condicion=1");

                                             if (dir!=0) {
                                                        // si es 0 el voucher puede ser usado, pero si es 1 ya fue usado
                                                      if (validarVoucher(secuencia, fechapago, voucher.getImportePagado(), dir)==0) {
                                                            System.out.println("voucher no fue usado");
                                                            condicional = 1 ;
                                                            // igualo el la entidad de Inversion
                                                            resultado = item;
                                                            id_rcdvoucher = voucher.getIdVoucher();
                                                            break;
                                                           }else{
                                                             condicional = 0;
                                                          }
                                             }else{
                                                     //****************VALIDACION VOUCHER USUARIO EXTERNO**********************
                                                    // cuando dir es 0 es porque esta entrando desde el modo de registro nuevo al inicio  
                                                    List<PguPagospersDet> lstpagoDet =  new ArrayList<>();
                                                    lstpagoDet =pguPagosDetDAO.BuscarDirParaValidarVoucher(ConvertirSecuencia(secuencia), fechapago, voucher.getImportePagado());
                                                   if (lstpagoDet!=null) {
                                                       condicional = 0;

                                                    }else{
                                                       condicional = 1;
                                                        resultado = item;
                                                       break;
                                                   }
                                                   //**fin validacion cvouches
                                                    // para cortar el for de lstvoucher  


                                                }
                                            }
                                        }
                                      ///fin for
                              if (condicional==1) {
                                             break;
                               }

                        }else{
                            System.out.println("NO HAY VOUCHERS");
                            break;
                        }
            
        }
        // fin bucle
        
        if (condicional==1) {
            System.out.println("voucher valido para registrar");
              resultado.setId_rcdVoucher(id_rcdvoucher);
              return resultado;
        }else{
             System.out.println("el voucher no es valido");
            return null;  
        }
        
      
    }
    
    
    
       @Override
       public Short validarVoucher(Integer secuencia, Date fecha_ope, Float monto ,Integer dir){   
           // se convierte a String la secuencia ya que en las tablas de pagos esta como String 
           // asi que se convierte a string y se agrega ceros si la longitud no es de 7
            String secuenciaFinal="";
           secuenciaFinal=ConvertirSecuencia(secuencia);
           System.out.println("secuncia final "+secuenciaFinal);
           return pguPagosDetDAO.buscarPago(secuenciaFinal, fecha_ope, monto, dir);
        }
       
       
  
    public String ConvertirSecuencia(Integer secuencia){
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
        
       return secuenciaFinal;
    }   
    
    
  
    @Override
    public RcdVoucher recuperarEntidad(int id) {
        return rcdVouchersDAO.buscarPorId(id);
    }
    
   @Override
    public RcdVoucher actualizarEntidad(RcdVoucher entidad) {
        return rcdVouchersDAO.actualizar(entidad);
    }
       
       
}
