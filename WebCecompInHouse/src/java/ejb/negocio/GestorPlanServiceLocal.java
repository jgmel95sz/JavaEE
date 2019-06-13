/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepCecCursoDet;
import entidades.CepCecPlan;
import entidades.CepTipoDesarrollo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface GestorPlanServiceLocal {

    public List<CepCecPlan> buscarTodos();

    CepCecPlan recuperarIdPlan(int id);

    public CepCecPlan crearNuevoPlan(CepCecPlan plan);

    public List<CepCecPlan> buscarUltimoPeriodo(Integer namecur, Integer anio);

    public CepCecPlan actualizarPlan(CepCecPlan plan);

    boolean validarPlanPorIdCursoDet(int idCursoCab);

    public CepCecPlan buscarPlanActual(int id);

    public List<CepCecPlan> buscarPlanes(int idCursoDet,int pageNumber);
   
    public  String convertirANumerosRomanos(int numero);
    
    public int tamanoPaginacionPlan(int id_curso_det);

}
