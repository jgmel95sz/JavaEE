/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.MetodosExtras;
import ejb.dao.DescuentoExoDAOLocal;
import ejb.dao.ExoneradosDAOLocal;
import entidades.CepCecDescExonerados;
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
public class DescuentoExoService implements DescuentoExoServiceLocal {

    @EJB
    private ExoneradosDAOLocal exoneradosDAO;

    @EJB
    private DescuentoExoDAOLocal descuentoExoDAO;

    
   @Override
    public void eliminarEntidad(CepCecDescExonerados entidad) {
         descuentoExoDAO.eliminar(entidad);
    }
    
    @Override
    public CepCecDescExonerados recuperarIdEntidad(int id) {
        return descuentoExoDAO.buscarPorId(id);
    }
 
    @Override
    public CepCecDescExonerados crearEntidad(CepCecDescExonerados entidad) {
        return descuentoExoDAO.crear(entidad);
    }
    
    @Override
    public CepCecDescExonerados actualizarEntidad(CepCecDescExonerados entidad) {
        return descuentoExoDAO.actualizar(entidad);
    }
    
    @Override
    public List<CepCecDescExonerados> buscarMediasBecas(int idinversion,int pageNumber){
        return  descuentoExoDAO.buscarMediasBecas(idinversion,pageNumber);
    }

     @Override
     public int tamanoPaginacionMediaBeca(int idinversion){
        int finalTamano =0;
         try {
             MetodosExtras obj = new MetodosExtras();
             int countResult= (int)descuentoExoDAO.calculandoTotalRegistrosMediasBecas(idinversion);
             int pageSize = 5 ; // 5 por pagina
              finalTamano =   obj.tamanoPaginacion(pageSize, countResult);
         } catch (Exception e) {
         }
         
         return finalTamano;
     }
     
    @Override
    public List<CepCecDescExonerados> buscarBecas(int idcursodetsub){
        
         List<CepCecDescExonerados> lstdescuento = new ArrayList<>();
         //List<CepCecDescExonerados> lstdescuento1 = new ArrayList<>();

        List<CepCecDescExonerados>  lstdescuento1 = descuentoExoDAO.buscarBecas(idcursodetsub);
        if (lstdescuento1!=null) {
            for (CepCecDescExonerados cepCecDescExonerados : lstdescuento1) {
                //VERIFICA SI TIENE ALGUN VOUCHER FICTICIO EL ALUMNO
                if (exoneradosDAO.validarSiTieneVoucherFicticioElAlumno(cepCecDescExonerados.getIdAluDesExo())==1) {
                 lstdescuento.add(cepCecDescExonerados);
                }
            }
            return lstdescuento;
        }else{
        
            return  null;
         }
     
        
      
    }
    
     @Override
    public CepCecDescExonerados validarLaNoRepeticionAlumno(int id_tipoAlumno, int id_inversion_curso, String num_documento){
          
         if (id_tipoAlumno==1) {
               return descuentoExoDAO.validarLaNoRepeticionAlumnoUns(id_inversion_curso, num_documento);
         }else{
              return descuentoExoDAO.validarLaNoRepeticionPubGeneral(id_inversion_curso, num_documento);
         }
       
    }
    
    
     @Override
    public Integer validarSemiBecado (int id_inversion_curso,String num_documento,int tipo_alumno){
      MetodosExtras obj = new MetodosExtras();
      Integer retorno=0;
      try {
             
         
      if (tipo_alumno==1) {
           CepCecDescExonerados entity =  descuentoExoDAO.validarLaNoRepeticionAlumnoUns(id_inversion_curso, num_documento);
              if (entity!=null) {
                    Date today =obj.obtenerFechaActualSinTime();
                  if (today.equals(entity.getFechaLimite()) || today.before(entity.getFechaLimite())) {
                      retorno = 1;//VALIDO
                  }else{
                      retorno = 0; //NO VALIDO se PASO LA FECHA LIMITE
                  }
                 
             }else{
                  retorno = 0; //NO VALIDO
               }
         }
         else{
         
            if (descuentoExoDAO.validarLaNoRepeticionPubGeneral(id_inversion_curso, num_documento)!=null) {
                  retorno = 1; //VALIDO
             }else{
                  retorno = 0; //NO VALIDO
               }
         
         }
      } catch (Exception e) {
       retorno =  0; //error   
      }
  
return retorno;
    }
    
    
}
