/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecMatriPago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface MatriculaPagoDAOLocal extends GenericoJPADAOLocal<CepCecMatriPago> {
    //public List<CepCecMatriPago> buscarCursosEnProcesoPorAlumno(Integer id_dir);
    public Integer buscarSizePagosPorAlumno(int id_matri);
    public CepCecMatriPago buscarPagoMatriculaPorAlumno(Integer id_matri);
        public List<CepCecMatriPago> buscarPagosPorMatricula(Integer id_matri);
        public List<CepCecMatriPago> buscarAlumnosMatriculados(Integer id_grupo);
}
