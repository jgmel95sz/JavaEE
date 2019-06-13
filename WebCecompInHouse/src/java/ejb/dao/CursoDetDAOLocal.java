/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecCursoDet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface CursoDetDAOLocal extends GenericoJPADAOLocal<CepCecCursoDet>{
    // List<CepCecCursoDet> buscarPorFiltro(int idcursodet);
    List<CepCecCursoDet> buscarTodos(int pageNumber,String nombre , Integer modensenanza);
    public List<CepCecCursoDet> buscarTodosCurDet();
    //public List<CepCecCursoDet> buscarFiltro();
     public CepCecCursoDet validarIdCursoCab(int id);
     public Integer validarRepeticion(int id_cur_cab,int id_nivel,int mod_ensenanza);
     public long calculandoTotalRegistrosCursoDet(String nombre , Integer modensenanza);
}
