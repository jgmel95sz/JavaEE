package ejb.negocio;


import entidades.CepCecCursoCab;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GestorCepCecCursoCabServiceLocal {

    public CepCecCursoCab crearNuevoCurso(CepCecCursoCab nombrecurso);

    public CepCecCursoCab actualizarCurso(CepCecCursoCab curso);

    //public List<CepCecCursoCab> buscarNombres();
    CepCecCursoCab recuperarIdCursoCab(int id);

    public int validarRepeticionNombres(String name_curso);

    List<CepCecCursoCab> buscarTodos(int pageNumber);
     List<CepCecCursoCab> buscarTodosNombres();
    
 public int tamanoPaginacionNombreCab();
   

}
