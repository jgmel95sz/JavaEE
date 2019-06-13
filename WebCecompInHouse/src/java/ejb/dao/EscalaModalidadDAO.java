/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepEscalaTipomod;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author MELVN
 */
@Stateless
public class EscalaModalidadDAO extends GenericoJPADAO<CepEscalaTipomod> implements EscalaModalidadDAOLocal {

    // Busca todos los cursos registrados en la bd
    @Override
    public List<CepEscalaTipomod> buscarTodos() {
        Short estado = 1;
        Integer cecomp = 3;
        Query q = em.createQuery("SELECT object(p) FROM CepEscalaTipomod as p WHERE p.estadoEscala=:estado AND p.numCepEstpm=:cecomp");
        q.setParameter("estado", estado);
         q.setParameter("cecomp", cecomp);

        List<CepEscalaTipomod> resultados = q.getResultList();

        if (resultados.size() <= 0) {
            return null; // No encontrado
        } else {
            System.out.println("Motivo de atencion: " + resultados.get(resultados.size() - 1));
            return resultados;
            // Devuelve el alumno encontrado            
        }
    }

    @Override
    public Integer buscarRepeticion(int id_modalidad, String escala, int cantidad) {
        Short estado = 1;
       Integer cecomp = 3; 
        Query q = em.createQuery("SELECT object(p) FROM CepEscalaTipomod as p WHERE p.cepTipoModalidad.idModalidad=:id_modalidad AND p.nombreEscala=:escala AND p.numEscala=:cantidad AND p.estadoEscala=:estado AND p.numCepEstpm=:cecomp");
        q.setParameter("id_modalidad", id_modalidad);
        q.setParameter("escala", escala);
        q.setParameter("cantidad", cantidad);
        q.setParameter("estado", estado);
        q.setParameter("cecomp", cecomp);

        List<CepEscalaTipomod> resultados = q.getResultList();

        if (resultados.size() <= 0) {
            return 0; // No encontrado
        } else {
            System.out.println("Motivo de atencion: " + resultados.get(resultados.size() - 1));
            return 1;
            // Devuelve el alumno encontrado            
        }
    }

}
