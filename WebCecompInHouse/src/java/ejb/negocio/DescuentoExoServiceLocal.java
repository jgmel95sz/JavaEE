/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepCecDescExonerados;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface DescuentoExoServiceLocal {

public void eliminarEntidad(CepCecDescExonerados entidad);

    public CepCecDescExonerados recuperarIdEntidad(int id);

    public CepCecDescExonerados crearEntidad(CepCecDescExonerados entidad);

    public CepCecDescExonerados actualizarEntidad(CepCecDescExonerados entidad);

    public List<CepCecDescExonerados> buscarMediasBecas(int idinversion,int pageNumber);
 
    public List<CepCecDescExonerados> buscarBecas(int idcursodetsub);
    
    public CepCecDescExonerados validarLaNoRepeticionAlumno(int id_tipoAlumno, int id_inversion_curso, String num_documento);

    public Integer validarSemiBecado (int id_inversion_curso,String num_documento,int tipo_alumno ); 
    
    public int tamanoPaginacionMediaBeca(int idinversion);

}
