/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import clases.MetodosExtras;
import ejb.dao.CursoDetDAOLocal;
import entidades.CepCecCursoDet;
import entidades.CepCecCursoSubdet;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author MELVN
 */
@Stateless
public class GestorCursoDetService implements GestorCursoDetServiceLocal {

    @EJB
    private CursoDetDAOLocal cursoDetDAO;

    
   @Override
    public CepCecCursoDet crearNuevoDetCurso(CepCecCursoDet duracion) {
       //System.out.println("ENTRO A CREAR DURACION");
        return cursoDetDAO.crear(duracion);
    }
    
    @Override
    public CepCecCursoDet recuperarIdCurDet(int id) {
        return cursoDetDAO.buscarPorId(id);
    }
    
     @Override
    public CepCecCursoDet actualizarCurso(CepCecCursoDet cursoDet) {
        return cursoDetDAO.actualizar(cursoDet);
    }
    
    
    @Override
    public List<CepCecCursoDet> buscarTodos(int pageNumber) {
       // System.out.println("ENTRO A NEGOCIO CURSO DET");
       String nombre = "";
       Integer modensenanza = 0;
        return cursoDetDAO.buscarTodos(pageNumber,nombre,modensenanza);
    }
    
     @Override
    public List<CepCecCursoDet> buscarTodosFiltro(int pageNumber,String nombre , Integer modensenanza) {
       // System.out.println("ENTRO A NEGOCIO CURSO DET");
        MetodosExtras obj = new MetodosExtras();
        nombre = obj.eliminarStringEnBlanco(nombre);
        return cursoDetDAO.buscarTodos(pageNumber,nombre,modensenanza);
    }
    
    @Override
    public List<CepCecCursoDet> buscarTodosCurDet() {
       // System.out.println("ENTRO A NEGOCIO CURSO DET");
        return cursoDetDAO.buscarTodosCurDet();
    }
     @Override
    public boolean validarIdCursoCab(int idCursoName) {
        return ( cursoDetDAO.validarIdCursoCab(idCursoName)) !=null;
    }
    
    @Override
     public Integer validarRepeticion(int id_cur_cab,int id_nivel,int mod_ensenanza){
         return cursoDetDAO.validarRepeticion(id_cur_cab, id_nivel, mod_ensenanza);
     }
     
     @Override
     public int tamanoPaginacionCursoDetFiltro(String nombre , Integer modensenanza){
        int finalTamano =0;
         try {
             MetodosExtras obj = new MetodosExtras();
             int countResult= (int)cursoDetDAO.calculandoTotalRegistrosCursoDet(nombre,modensenanza);
             int pageSize = 8 ; // 5 por pagina
              finalTamano =   obj.tamanoPaginacion(pageSize, countResult);
         } catch (Exception e) {
         }
         return finalTamano;
     }
     
     @Override
     public int tamanoPaginacionCursoDet(){
          String nombre="";
          Integer modensenanza=0;
        int finalTamano =0;
         try {
             MetodosExtras obj = new MetodosExtras();
             int countResult= (int)cursoDetDAO.calculandoTotalRegistrosCursoDet(nombre,modensenanza);
             int pageSize = 8 ; // 5 por pagina
              finalTamano =   obj.tamanoPaginacion(pageSize, countResult);
         } catch (Exception e) {
         }
         
         return finalTamano;
     }
    
    
}
