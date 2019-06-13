/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

//import clases.MetodosExtras;
import ejb.dao.ExoneradosDAOLocal;
import entidades.CepCecExonerados;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class ExoneradosService implements ExoneradosServiceLocal {

    @EJB
    private ExoneradosDAOLocal exoneradosDAO;

     @Override
    public CepCecExonerados recuperarIdEntidad(int id) {
        return exoneradosDAO.buscarPorId(id);
    }
 
    @Override
    public CepCecExonerados crearEntidad(CepCecExonerados entidad) {
        return exoneradosDAO.crear(entidad);
    }
    
    @Override
    public CepCecExonerados actualizarEntidad(CepCecExonerados entidad) {
        System.out.println("valor de estado = "+entidad.getEstadoExo());
        System.out.println("");
        
        return  exoneradosDAO.actualizar(entidad);
               
    }
    
    @Override
    public List<CepCecExonerados> listaVoucherPorAlumno(int id_des_alu) {
        return exoneradosDAO.listarVoucherFicticiosAlumno(id_des_alu);
    }
    
    @Override
    public CepCecExonerados verSiExisteVoucherFicticioAlumno(String secuencia , Date fecha , Short agencia , String numdoc, int id_curso_subdet , int tipo_alumno ){
          if (tipo_alumno==1) {
                    return exoneradosDAO.verSiExisteVoucherFicticioAlumno(secuencia, fecha, agencia, numdoc, id_curso_subdet);
        }else{
                  return exoneradosDAO.verSiExisteVoucherFicticioNoAlumnoUns(secuencia, fecha, agencia, numdoc, id_curso_subdet);
          }
    }
    
    @Override
    public CepCecExonerados verSiExisteVoucherFicticioRegistroExterno(String secuencia , Date fecha , Short agencia , String dni  ){
        
          return exoneradosDAO.verSiExisteVoucherFicticioRegistroExterno(secuencia, fecha, agencia, dni);
    
    }
    
    
  /*  @Override
    public Integer doCrearSecuencia(String dni){
        // se va formar de las 4 primeros numeros del numero de documento y 3 numeros aleatorios
         MetodosExtras funcion = new MetodosExtras();
         String aleatorio  = funcion.doAleatorio(); // devuelve un numero minimo 1 digito maximo 3
         System.out.println("ALEATORIO :"+aleatorio);
         String subStr= dni.substring(0, 4); //obitnene 4 digitos
         System.out.println("DNI 4 DIGITOS : "+subStr);
         subStr = subStr + "" + aleatorio  ;
         System.out.println("SECUENCIA :" + subStr);
         Integer secuencia = Integer.parseInt(subStr);
       return  secuencia ;
    }*/
 
}
