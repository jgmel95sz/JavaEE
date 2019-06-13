/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.HorariosDAOLocal;
import entidades.CepCecHorarios;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class GestorHorariosService implements GestorHorariosServiceLocal {

    @EJB
    private HorariosDAOLocal horariosDAO;

    
    
     @Override
    public CepCecHorarios crearNuevoHorarioCurso(CepCecHorarios horarios) {
        return horariosDAO.crear(horarios);}
        
     @Override
    public List<CepCecHorarios> buscarTodos() {
        return horariosDAO.buscarTodos();
    }
    
    @Override
    public List<CepCecHorarios> listarIdHorario(int id) {
        return horariosDAO.listarHorarioPorId(id);
    }
    
    @Override
    public CepCecHorarios capturarIdHorario(Integer id) {
        return horariosDAO.capturarHorarioPorId(id);
    }
    
    @Override
    public CepCecHorarios actualizarTema(CepCecHorarios horarios) {
        return horariosDAO.actualizar(horarios);
    }
    
    
}
