/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.EscalaModalidadDAOLocal;
import entidades.CepCecPlan;
import entidades.CepEscalaTipomod;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author MELVN
 */
@Stateless
public class GestorEscalaModalidadService implements GestorEscalaModalidadServiceLocal {

    @EJB
    private EscalaModalidadDAOLocal escalaModalidadDAO;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @Override
    public CepEscalaTipomod crearNuevaDuracionCurso(CepEscalaTipomod duracion) {
        System.out.println("ENTRO A CREAR DURACION");
        return escalaModalidadDAO.crear(duracion);
    }
    
     @Override
    public CepEscalaTipomod recuperarIdEscala(int id) {
        return escalaModalidadDAO.buscarPorId(id);
    }
    
     @Override
    public List<CepEscalaTipomod> buscarTodos() {
        return escalaModalidadDAO.buscarTodos();
    }
    
       @Override
    public CepEscalaTipomod actualizarEscala(CepEscalaTipomod escala) {
        return escalaModalidadDAO.actualizar(escala);
    }
    
     @Override
     public Integer buscarRepeticiones(int id_modalidad,String escala, int cantidad){            
       return escalaModalidadDAO.buscarRepeticion(id_modalidad, escala, cantidad);
     }
    
  
    
}
