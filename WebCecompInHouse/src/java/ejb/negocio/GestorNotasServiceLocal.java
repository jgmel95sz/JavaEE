/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepCecMatriAlu;
import entidades.CepCecNotas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorNotasServiceLocal {

    public List<CepCecNotas> buscarNotasDeAlumnosMatriculados(Integer id_grupo);

    public CepCecNotas crearNuevasNotas(CepCecMatriAlu cepCecMatriAlu);

    public CepCecNotas recuperarIdNotas(int id);

    public CepCecNotas actualizarNotas(CepCecNotas update);

    public Float redondearNota(Float x);

    public Integer verificarRangoNotas(CepCecNotas entidadNotas);

    public CepCecNotas actualizarNotasSubsanacion(CepCecNotas item);
    
    public List<CepCecNotas> buscarNotasDeLosCursosMatriculadosActivos(Integer dir);
    
   public CepCecNotas buscarNotasPorMatricula(Integer id_matri);
   
    public List<CepCecNotas> buscarNotasDeLosCursosMatriculadosInactivos(Integer dir);

}
