/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.CepHorarioDias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface GestorCepHorarioDiasServiceLocal {
     public List<CepHorarioDias> buscarTodos();
     public CepHorarioDias crearNuevoHorarioDias(CepHorarioDias dias);
     CepHorarioDias recuperarIdDiasdeHorario(int id);
      public String formatoHorarioDias(String[] selectDias);
      public Integer[]DiasAhNumeros(String[] selectDias,Integer [] indice);
       public void burbujaMejorada(Integer arreglo[],String vector[]);
        public Integer ReguladorDeCadena(Integer arreglo[]);
         public Integer buscarRepeticion(String nomDias);
}
