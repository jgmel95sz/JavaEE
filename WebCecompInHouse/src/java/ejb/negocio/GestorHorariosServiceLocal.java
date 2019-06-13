/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepCecHorarios;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GestorHorariosServiceLocal {

    public CepCecHorarios crearNuevoHorarioCurso(CepCecHorarios horarios);

    public List<CepCecHorarios> buscarTodos();

    public CepCecHorarios actualizarTema(CepCecHorarios horarios);

    public List<CepCecHorarios> listarIdHorario(int id);

    public CepCecHorarios capturarIdHorario(Integer id);
}
