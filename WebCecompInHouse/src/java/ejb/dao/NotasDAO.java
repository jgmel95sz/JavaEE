/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecNotas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class NotasDAO extends GenericoJPADAO<CepCecNotas> implements NotasDAOLocal {

  @Override
    public List<CepCecNotas> buscarNotasDeAlumnosMatriculados(Integer id_grupo){
        Short estado=1;
        Query q = em.createQuery("SELECT object(c) FROM CepCecNotas as c WHERE c.cepCecMatriAlu.cepCecCurGrup.idCurGrup=:id_grupo AND c.cepCecMatriAlu.estadoMatri=:estado" );
        q.setParameter("id_grupo", id_grupo);
        q.setParameter("estado", estado);
        List<CepCecNotas> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados;
                  // Devuelve  encontrado            
              }
       }
    
    
    
       @Override
       public List<CepCecNotas> buscarNotasDeLosCursosMatriculadosActivos(Integer id_dir){
        Short estado=1;
        boolean estado_academico=true;
        Query q = em.createQuery("SELECT object(c) FROM CepCecNotas as c WHERE c.cepCecMatriAlu.cepCecCurGrup.estadoAcademico=:estado_academico AND c.cepCecMatriAlu.estadoMatri=:estado AND c.cepCecMatriAlu.drtPersonanatural.idDir=:id_dir" );
        q.setParameter("estado_academico", estado_academico);
        q.setParameter("estado", estado);
         q.setParameter("id_dir", id_dir);
        List<CepCecNotas> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados;
                  // Devuelve  encontrado            
              }
       }
    
    //historial notas
       @Override
       public List<CepCecNotas> buscarNotasDeLosCursosMatriculadosInactivos(Integer id_dir){
        Short estado=1;
        boolean estado_academico=false;
        Query q = em.createQuery("SELECT object(c) FROM CepCecNotas as c WHERE c.cepCecMatriAlu.cepCecCurGrup.estadoAcademico=:estado_academico AND c.cepCecMatriAlu.estadoMatri=:estado AND c.cepCecMatriAlu.drtPersonanatural.idDir=:id_dir" );
        q.setParameter("estado_academico", estado_academico);
        q.setParameter("estado", estado);
         q.setParameter("id_dir", id_dir);
        List<CepCecNotas> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados;
                  // Devuelve  encontrado            
              }
       }
       
       
       // se usa en el modo administrador
    @Override
    public CepCecNotas buscarNotasPorMatricula(Integer id_matri){
        Short estado=1;
        Query q = em.createQuery("SELECT object(c) FROM CepCecNotas as c WHERE c.cepCecMatriAlu.idMatriAlu=:id_matri AND c.cepCecMatriAlu.estadoMatri=:estado" );
        q.setParameter("id_matri", id_matri);
        q.setParameter("estado", estado);
        List<CepCecNotas> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados.get(0);
                  // Devuelve  encontrado            
              }
       }
    
    
}
