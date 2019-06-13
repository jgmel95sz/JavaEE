/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepEscalaTipomod;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface GestorEscalaModalidadServiceLocal {
     public CepEscalaTipomod crearNuevaDuracionCurso(CepEscalaTipomod duracion);
     CepEscalaTipomod recuperarIdEscala(int id);
     List<CepEscalaTipomod> buscarTodos();
     public CepEscalaTipomod actualizarEscala(CepEscalaTipomod escala) ;
     public Integer buscarRepeticiones(int id_modalidad,String escala, int cantidad);


     
}
