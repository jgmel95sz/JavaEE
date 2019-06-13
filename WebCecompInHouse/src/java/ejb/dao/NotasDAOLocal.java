/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecNotas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface NotasDAOLocal extends GenericoJPADAOLocal<CepCecNotas> {

    public List<CepCecNotas> buscarNotasDeAlumnosMatriculados(Integer id_grupo);

    public List<CepCecNotas> buscarNotasDeLosCursosMatriculadosActivos(Integer id_dir);

    public CepCecNotas buscarNotasPorMatricula(Integer id_matri);

    public List<CepCecNotas> buscarNotasDeLosCursosMatriculadosInactivos(Integer id_dir);
}
