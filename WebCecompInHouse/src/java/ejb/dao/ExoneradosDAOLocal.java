/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecExonerados;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface ExoneradosDAOLocal extends GenericoJPADAOLocal<CepCecExonerados>{
      public List<CepCecExonerados> listarVoucherFicticiosAlumno(int id_des_alu);
      public CepCecExonerados verSiExisteVoucherFicticioAlumno(String secuencia , Date fecha , Short agencia , String cod_alumno , int id_curso_subdet );
      public CepCecExonerados verSiExisteVoucherFicticioNoAlumnoUns(String secuencia , Date fecha , Short agencia , String dni , int id_curso_subdet );
       public CepCecExonerados verSiExisteVoucherFicticioRegistroExterno(String secuencia , Date fecha , Short agencia , String dni  );
 public int validarSiTieneVoucherFicticioElAlumno(int id_des_alu);
}
