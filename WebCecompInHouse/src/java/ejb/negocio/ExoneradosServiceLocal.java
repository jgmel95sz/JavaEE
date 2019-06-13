/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepCecExonerados;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface ExoneradosServiceLocal {
    public CepCecExonerados recuperarIdEntidad(int id);
    public CepCecExonerados crearEntidad(CepCecExonerados entidad);
    public CepCecExonerados actualizarEntidad(CepCecExonerados entidad);
   // public Integer doCrearSecuencia(String dni);
    public List<CepCecExonerados> listaVoucherPorAlumno(int id_des_alu);
    public CepCecExonerados verSiExisteVoucherFicticioAlumno(String secuencia , Date fecha , Short agencia , String numdoc , int id_curso_subdet , int tipoalumno );
   // public CepCecExonerados verSiExisteVoucherFicticioNoAlumnoUns(String secuencia , Date fecha , Short agencia , String dni , int id_curso_subdet );
 public CepCecExonerados verSiExisteVoucherFicticioRegistroExterno(String secuencia , Date fecha , Short agencia , String dni  );
}
