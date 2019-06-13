/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.MetodosExtras;
import ejb.dao.PlanDaoLocal;
import entidades.CepCecPlan;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author MELVN
 */
@Stateless
public class GestorPlanService implements GestorPlanServiceLocal {

    @EJB
    private PlanDaoLocal planDao;

    
    
  @Override
    public List<CepCecPlan> buscarTodos() {
        System.out.println("ENTRO A NEGOCIO");
        return planDao.buscarTodos();
    }
    
    @Override
    public CepCecPlan actualizarPlan(CepCecPlan plan) {
        return planDao.actualizar(plan);
    }
    
   @Override
    public CepCecPlan recuperarIdPlan(int id) {
        return planDao.buscarPorId(id);
    }
    
     @Override
    public CepCecPlan crearNuevoPlan(CepCecPlan plan) {
        System.out.println("ENTRO NEGOCIO A CREAR SESION");
        return planDao.crear(plan);
    }
    
    @Override
    public List<CepCecPlan> buscarUltimoPeriodo(Integer namecur,Integer anio) {
        System.out.println("ENTRO A NEGOCIO");
        return planDao.buscarUltimoPeriodo(namecur, anio);
    }
   
    
 
    
    @Override
    public boolean validarPlanPorIdCursoDet(int idCursoDet) {
        return ( planDao.validarIdCursoDet(idCursoDet)) !=null;
    }
    
     @Override
    public CepCecPlan buscarPlanActual(int idCursoDet) {
        return planDao.buscarPlanActual(idCursoDet);
    }
    
     @Override
    public List<CepCecPlan> buscarPlanes(int idCursoDet,int pageNumber) {
        return planDao.buscarPlanes(idCursoDet,pageNumber);
    }
    
    @Override
     public int tamanoPaginacionPlan(int id_curso_det){
        int finalTamano =0;
         try {
             MetodosExtras obj = new MetodosExtras();
             int countResult= (int)planDao.calculandoTotalRegistrosPlanes(id_curso_det);
             int pageSize = 5 ; // 5 por pagina
              finalTamano =   obj.tamanoPaginacion(pageSize, countResult);
         } catch (Exception e) {
         }
         
         return finalTamano;
     }
       

    
 @Override 
 //método para pasar a números romanos
  public  String convertirANumerosRomanos(int numero) {
      int i, miles, centenas, decenas, unidades;
      String romano = "";
     //obtenemos cada cifra del número
      miles = numero / 1000;
      centenas = numero / 100 % 10;
      decenas = numero / 10 % 10;
      unidades = numero % 10;

     //millar
      for (i = 1; i <= miles; i++) {
             romano = romano + "M";
      }

     //centenas
      if (centenas == 9) {
          romano = romano + "CM";
      } else if (centenas >= 5) {
                     romano = romano + "D";
                     for (i = 6; i <= centenas; i++) {
                            romano = romano + "C";
                     }
      } else if (centenas == 4) {
                      romano = romano + "CD";
      } else {
                  for (i = 1; i <= centenas; i++) {
                         romano = romano + "C";
                  }
      }

     //decenas
      if (decenas == 9) {
           romano = romano + "XC";
      } else if (decenas >= 5) {
                      romano = romano + "L";
                      for (i = 6; i <= decenas; i++) {
                            romano = romano + "X";
                      }
      } else if (decenas == 4) {
                      romano = romano + "XL";
      } else {
                    for (i = 1; i <= decenas; i++) {
                           romano = romano + "X";
                    }
      }

     //unidades
      if (unidades == 9) {
           romano = romano + "IX";
      } else if (unidades >= 5) {
                      romano = romano + "V";
                      for (i = 6; i <= unidades; i++) {
                             romano = romano + "I";
                      }
      } else if (unidades == 4) {
                      romano = romano + "IV";
      } else {
                  for (i = 1; i <= unidades; i++) {
                         romano = romano + "I";
                  }
      }
      return romano;
  }
    
}
