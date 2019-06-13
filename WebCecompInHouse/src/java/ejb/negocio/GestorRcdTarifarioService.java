/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import entidades.RcdTarifario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ejb.dao.RcdTarifarioDAOLocal;
import java.text.Normalizer;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorRcdTarifarioService implements GestorRcdTarifarioServiceLocal {

    @EJB
    private RcdTarifarioDAOLocal rcdTarifarioDAO;

  // @Override
   // public List<RcdTarifario> ListarRcdConceptos(int tipo_inver,int tipo_alumno,String nom_curso) {
      
         // return rcdTarifarioDAO.ListarRcdConceptos();
    //}  
    
  /*  @Override
    public List<RcdTarifario> ListarRcdConceptos(int tipo_inver,int tipo_alumno,String nom_curso) {
        Short typePeople=0; //
        int condicional; // 
        
        
        if (tipo_inver==3 || tipo_inver==4 || tipo_inver==5) {
            condicional = 0 ; // Lista todos los conceptos del cecomp pago otros, examen sufi y examen sub
            
         }else{
                
            condicional = 1;    

        }  
        
              if (tipo_alumno == 1) // alumno uns
              {
              typePeople = 1;
                      // conceptos por pago completo, pago pension y media beca
              } else {
                          if (tipo_alumno == 2 || tipo_alumno == 3) // Pub.General & Trabaj.Uns
                          {
                              typePeople = 4; // es 4 , porque en rcd_tarifario el tipo de persona 4 , es externo y trabajador
                             // conceptos por pago completo, pago pension y media beca
                          }

               }
            
          return rcdTarifarioDAO.ListarRcdConceptos(typePeople, condicional,cadena,cadenaPrimeraPalabra,cadPriPalMay,cadPriPalMin,cadenaPrimeraPalabraSintilde,
        cadPriPalSintilMay,cadPriPalSintilMin,cadPriPalFormal,cadPriPalFormalLimpio);
    }  
       
 * /      
        
      /*  //**********************************
        String cadena=nom_curso;
        String cadenaPrimeraPalabra;
        String cadPriPalMay;
        String cadPriPalMin;
        String cadenaPrimeraPalabraSintilde;
        String cadPriPalSintilMay;
        String cadPriPalSintilMin;
        String cadPriPalFormal;
        String cadPriPalFormalLimpio;
       // System.out.println("EN  NEGOCIO");
        
     //   System.out.println(""+cadena);
       // System.out.println("*******************************************");
        cadenaPrimeraPalabra=CortarPrimeraPalabra(cadena);
       // System.out.println("Primera palabra: "+cadenaPrimeraPalabra);
        cadPriPalMay = cadenaPrimeraPalabra.toUpperCase();
       // System.out.println(""+cadPriPalMay);
        cadPriPalMin = cadenaPrimeraPalabra.toLowerCase();
     //   System.out.println(""+cadPriPalMin);
     //   System.out.println("--------------------");
        cadenaPrimeraPalabraSintilde = limpiarAcentos(cadenaPrimeraPalabra);
      //  System.out.println("Sin Tilde: "+cadenaPrimeraPalabraSintilde);
        cadPriPalSintilMay = cadenaPrimeraPalabraSintilde.toUpperCase();
        //System.out.println(""+cadPriPalSintilMay);
        cadPriPalSintilMin = cadenaPrimeraPalabraSintilde.toLowerCase();
       // System.out.println(""+cadPriPalSintilMin);
      //  System.out.println("--------------------");
        cadPriPalFormal = Formal(cadenaPrimeraPalabra);
     //   System.out.println("Primera Palbra Formal: "+cadPriPalFormal);
        cadPriPalFormalLimpio = limpiarAcentos(cadPriPalFormal);
     //   System.out.println("Sin tilde Formal: "+cadPriPalFormalLimpio);
        
        */
   


}
