/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecTipAlumno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class TipoAlumnoDAO extends GenericoJPADAO<CepCecTipAlumno> implements TipoAlumnoDAOLocal {

    @Override
    public List<CepCecTipAlumno> buscarTiposAlumnos() {
        Query q = em.createQuery("SELECT object(p) FROM CepCecTipAlumno as p WHERE p.estadoTipAlumno=:estado");
        Short estado = 1;
        q.setParameter("estado", estado);

        List<CepCecTipAlumno> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            return null; // No encontrado
        } else {
            System.out.println("Motivo de atencion: " + resultados.get(resultados.size() - 1));
            return resultados;
            // Devuelve el alumno encontrado            
        }
    }
}
