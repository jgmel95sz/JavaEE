/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.TipoAlumnoDAOLocal;
import entidades.CepCecTipAlumno;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorTipoAlumnoService implements GestorTipoAlumnoServiceLocal {

    @EJB
    private TipoAlumnoDAOLocal tipoAlumnoDAO;
    
    @Override
    public CepCecTipAlumno recuperarTipoAlumno(int id) {
        return tipoAlumnoDAO.buscarPorId(id);
    }
    
     @Override
    public List<CepCecTipAlumno> buscarTiposInversion() {
        return tipoAlumnoDAO.buscarTiposAlumnos();
    }
    
   
}
