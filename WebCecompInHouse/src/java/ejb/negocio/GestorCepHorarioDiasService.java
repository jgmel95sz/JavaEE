/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.CepHorarioDiasDAOLocal;
import entidades.CepHorarioDias;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author MELVN
 */
@Stateless
public class GestorCepHorarioDiasService implements GestorCepHorarioDiasServiceLocal {

    @EJB
    private CepHorarioDiasDAOLocal cepHorarioDiasDAO;

    // LLama a a la funcion buscar todos en el Dao 
    @Override
    public List<CepHorarioDias> buscarTodos() {
        return cepHorarioDiasDAO.buscarTodos();
    }

    @Override
     public Integer buscarRepeticion(String nomDias) {
        return cepHorarioDiasDAO.buscarRepeticion(nomDias);
    }
    
    @Override
    public CepHorarioDias crearNuevoHorarioDias(CepHorarioDias dias) {
        System.out.println("ENTRO A CREAR NEGOCIO DE horario DIAS");
        return cepHorarioDiasDAO.crear(dias);
    }

    @Override
    public CepHorarioDias recuperarIdDiasdeHorario(int id) {
        return cepHorarioDiasDAO.buscarPorId(id);
    }

    @Override
    public String formatoHorarioDias(String[] selectDias) {
        String nameDias = "";
        Integer[] indice;
        Integer[] IndiceResultados;
        String nuevaCadena = "";
        char letra;
        int condicion;  // si es  1 = guarda las cadenas extensas las achica  0= tipo de cadena normales
        // inicializa el array indice con el tamaño de la canitdad de los dias seleccionados
        indice = new Integer[selectDias.length];
        IndiceResultados = new Integer[selectDias.length];
         
       // System.out.println("llego a Dias ah numeros");
        IndiceResultados = DiasAhNumeros(selectDias, indice);
       // System.out.println("llego a burbuja");
        burbujaMejorada(IndiceResultados, selectDias);
      //  System.out.println("llego a regulador");
        condicion = ReguladorDeCadena(IndiceResultados);
      //  System.out.println("llego a if");
        if (condicion == 0) {
               //     System.out.println("entro en if = 0");

            // Guarda en una sola cadena todos los valores del String array osea los dias lo guarda en una sola cadena
                    for (String selectDia : selectDias) {
                       // System.out.println("" + selectDia);
                        nameDias = nameDias + selectDia + " ";
                    }
                    System.out.println(" " + nameDias);
                    
                  // verifica el string buscando espacios para añadirle un guion 
                   for (int i = 0; i < nameDias.length(); i++) {
                       letra = nameDias.charAt(i);
                       if (letra == ' ' && (i != (nameDias.length() - 1))) {
                           nuevaCadena = nuevaCadena + " - ";
                       } else {
                           nuevaCadena = nuevaCadena + letra;
                       }
                   }

        }else{ 
            

                  nuevaCadena = selectDias[0] + " a " + selectDias[selectDias.length-1]; 
        
        }
        
        return nuevaCadena;
    }

    @Override
    public Integer[] DiasAhNumeros(String[] selectDias, Integer[] indice) {
        int ind = 0;
        for (int i = 0; i < selectDias.length; i++) {

            switch (selectDias[i]) {
                case "Lunes":
                    ind = 1;
                    break;
                case "Martes":
                    ind = 2;
                    break;
                case "Miercoles":
                    ind = 3;
                    break;
                case "Jueves":
                    ind = 4;
                    break;
                case "Viernes":
                    ind = 5;
                    break;
                case "Sabado":
                    ind = 6;
                    break;
                case "Domingo":
                    ind = 7;
                    break;
            }
            indice[i] = ind;
        }

        return indice;

    }

    @Override
    public void burbujaMejorada(Integer arreglo[], String vector[]) {

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int aux1 = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux1;

                    String aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;
                }
            }
        }

    }
    
    
    
   @Override
    public Integer ReguladorDeCadena(Integer arreglo[]) { 
       int i = 0;
       int condicion=0;
       int indice = arreglo[i]; 
       int comparador;
       int longitud = 0;
       
      // System.out.println("antes de entrar al while");
         while (i < arreglo.length-1 ) {             
             i++;
             
             indice= indice + 1;
            // System.out.println("indice = "+indice);
             comparador = arreglo[i];
             //System.out.println("comparador = "+comparador);
             if (comparador == indice) {
           //      System.out.println("son iguales");
                 condicion = 1;
                 longitud++;
             }else {
                 condicion = 0;
                 break;
             }
         }
         
         if (longitud <  3   ) {
             condicion = 0;
         }
         
         return condicion;
    }


}
