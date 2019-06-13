/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.RcdTarifario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class RcdTarifarioDAO extends GenericoJPADAO<RcdTarifario> implements RcdTarifarioDAOLocal {

    @Override
    public List<RcdTarifario> ListarRcdConceptos(Short typePeople, int condicional, String cadena, String cadenaPrimeraPalabra, String cadPriPalMay, String cadPriPalMin, String cadenaPrimeraPalabraSintilde,
            String cadPriPalSintilMay, String cadPriPalSintilMin, String cadPriPalFormal, String cadPriPalFormalLimpio) {

        String tipoConcepto = "CECOMP";
        Query q;
        List<RcdTarifario> resultados;
        int contador = 0;
        do {
            if (condicional == 1) {
                // Lista todos los conceptos del cecomp segun el nombre y el tipo de persona

                q = em.createQuery("SELECT object(p) FROM RcdTarifario as p WHERE p.rcdConcepto.tipo=:tipoConcepto AND p.tipoPersona=:typePeople AND (p.rcdConcepto.nombre LIKE concat('%',:cadena,'%') OR p.rcdConcepto.nombre LIKE concat('%',:cadenaPrimeraPalabra,'%') OR p.rcdConcepto.nombre LIKE concat('%',:cadPriPalMay,'%') OR p.rcdConcepto.nombre LIKE concat('%',:cadPriPalMin,'%') OR p.rcdConcepto.nombre LIKE concat('%',:cadenaPrimeraPalabraSintilde,'%') OR p.rcdConcepto.nombre LIKE concat('%',:cadPriPalSintilMay,'%') OR p.rcdConcepto.nombre LIKE concat('%',:cadPriPalSintilMin,'%') OR p.rcdConcepto.nombre LIKE concat('%',:cadPriPalFormal,'%') OR p.rcdConcepto.nombre LIKE concat('%',:cadPriPalFormalLimpio,'%') )");
                q.setParameter("tipoConcepto", tipoConcepto);
                q.setParameter("typePeople", typePeople);
                q.setParameter("cadena", cadena);
                q.setParameter("cadenaPrimeraPalabra", cadenaPrimeraPalabra);
                q.setParameter("cadPriPalMay", cadPriPalMay);
                q.setParameter("cadPriPalMin", cadPriPalMin);
                q.setParameter("cadenaPrimeraPalabraSintilde", cadenaPrimeraPalabraSintilde);
                q.setParameter("cadPriPalSintilMay", cadPriPalSintilMay);
                q.setParameter("cadPriPalSintilMin", cadPriPalSintilMin);
                q.setParameter("cadPriPalFormal", cadPriPalFormal);
                q.setParameter("cadPriPalFormalLimpio", cadPriPalFormalLimpio);

            } else {
               //Lista todos los conceptos del cecomp
                    q = em.createQuery("SELECT object(p) FROM RcdTarifario as p WHERE p.rcdConcepto.tipo=:tipoConcepto AND p.tipoPersona=:typePeople ");
                    q.setParameter("tipoConcepto", tipoConcepto);
                    q.setParameter("typePeople", typePeople);

            }

            resultados = q.getResultList();
            
            if (resultados.size() <= 0) {
                condicional = 0;
            } else {
                break;
            }

            contador++;
        } while (contador < 2);

        if (resultados.size() <= 0) {
            System.out.println("no encontro");
            return null; // No encontrado

        } else {
            System.out.println("ENTRO A DAO");
            System.out.println("Motivo de atencion: " + resultados.get(resultados.size() - 1));
            return resultados;
            // Devuelve el alumno encontrado            
        }
    }

}
