/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.CronogramasCabDAOLocal;
import entidades.CepCecCronogramaCab;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorCronogramasCabService implements GestorCronogramasCabServiceLocal {

    @EJB
    private CronogramasCabDAOLocal cronogramasCabDAO;

    
    @Override
    public CepCecCronogramaCab crearNuevoCronogramaCab(CepCecCronogramaCab nuevo) {
        return cronogramasCabDAO.crear(nuevo);
    }
    
   @Override
    public CepCecCronogramaCab actualizarCronogramaCab(CepCecCronogramaCab entidad) {
        return cronogramasCabDAO.actualizar(entidad);
    }
    
    @Override
    public Integer buscarNumPago(Integer id_cur_grup){
        return (cronogramasCabDAO.buscarNumPago(id_cur_grup) + 1);
    }
   
     @Override
    public CepCecCronogramaCab recuperarId(int id) {
        return cronogramasCabDAO.buscarPorId(id);
    }
    /*
      @Override
    public List<CepCecCronogramaCab> buscarTodos() {
        return cronogramasCabDAO.buscarTodos();
    }
    
    @Override
     public CepCecCronogramaCab capturarDetalleEnCronograma(int curgrupo) {
         return cronogramasCabDAO.capturarDetalleEnCronograma(curgrupo);
    }
     */
    
    
      
    

}
