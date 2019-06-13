/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepCecTema;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface GestorTemaPlanServiceLocal {
    public List<CepCecTema> buscarTodos(int idSesion);
    public CepCecTema crearNuevaTema(CepCecTema tema);
          public CepCecTema actualizarTema(CepCecTema EntityTema);
            public CepCecTema recuperarIdSesion(int id);

}
