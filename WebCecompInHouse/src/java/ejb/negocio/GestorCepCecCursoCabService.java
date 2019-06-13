
package ejb.negocio;

import clases.MetodosExtras;
import ejb.dao.CepCecCursoCabDAOLocal;
import entidades.CepCecCursoCab;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class GestorCepCecCursoCabService implements GestorCepCecCursoCabServiceLocal {

    @EJB
    private CepCecCursoCabDAOLocal cepCecCursoCabDAO;
    // envia un objeto(nombre del curso y descripcion) del cursocab a la funcion crear que esta en GENERICOJPADAO para crear una nueva tupla
    @Override
    public CepCecCursoCab crearNuevoCurso(CepCecCursoCab nombrecurso) {
        return cepCecCursoCabDAO.crear(nombrecurso);
    }
    
      @Override
     public int tamanoPaginacionNombreCab(){
        int finalTamano =0;
         try {
             MetodosExtras obj = new MetodosExtras();
             int countResult= (int)cepCecCursoCabDAO.calculandoTotalRegistrosNombresCab();
             int pageSize = 10 ; // 10 por pagina
              finalTamano =   obj.tamanoPaginacion(pageSize, countResult);
         } catch (Exception e) {
         }
         
         return finalTamano;
     }
    
    @Override
    public CepCecCursoCab actualizarCurso(CepCecCursoCab cursocab) {
        return cepCecCursoCabDAO.actualizar(cursocab);
    }
    
    
   /* // LLama a a la funcion buscar todos en el Dao 
    @Override
    public List<CepCecCursoCab> buscarNombres() {
        return cepCecCursoCabDAO.buscarNombres();
    }*/
    
    @Override
    public CepCecCursoCab recuperarIdCursoCab(int id) {
        return cepCecCursoCabDAO.buscarPorId(id);
    }
    
    @Override
    public int validarRepeticionNombres(String name_curso) {
        return cepCecCursoCabDAO.ValidarRepeticiones(name_curso);
    }
    
     @Override
    public List<CepCecCursoCab> buscarTodos(int pageNumber) {
        return cepCecCursoCabDAO.buscarTodos(pageNumber);
    }
    
      @Override
    public List<CepCecCursoCab> buscarTodosNombres() {
        return cepCecCursoCabDAO.buscarTodosNombres();
    }
    
}