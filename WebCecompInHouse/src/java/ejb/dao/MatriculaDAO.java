/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecMatriAlu;
import entidades.CepCecSesion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class MatriculaDAO extends GenericoJPADAO<CepCecMatriAlu> implements MatriculaDAOLocal {
   
   @Override
    public List<CepCecMatriAlu> buscarCursosEnProcesoPorAlumno(Integer id_dir){
        Short estado=1;
        Boolean estadoAcademico = true;
        Query q = em.createQuery("SELECT object(c) FROM CepCecMatriAlu as c WHERE c.cepCecCurGrup.estadoAcademico=:estadoAcademico AND c.drtPersonanatural.idDir = :id_dir AND c.estadoMatri =:estado " );
        q.setParameter("id_dir", id_dir);
        q.setParameter("estado", estado);
        q.setParameter("estadoAcademico", estadoAcademico);
        List<CepCecMatriAlu> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados;
                  // Devuelve  encontrado            
              }
       }
    
    
     @Override
    public List<CepCecMatriAlu> buscarCursosHistorialPorAlumno(Integer id_dir){
        Short estado=1;
        Boolean estadoAcademico = false;
        Query q = em.createQuery("SELECT object(c) FROM CepCecMatriAlu as c WHERE c.cepCecCurGrup.estadoAcademico=:estadoAcademico AND c.drtPersonanatural.idDir = :id_dir AND c.estadoMatri =:estado " );
        q.setParameter("id_dir", id_dir);
        q.setParameter("estado", estado);
        q.setParameter("estadoAcademico", estadoAcademico);
        List<CepCecMatriAlu> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados;
                  // Devuelve  encontrado            
              }
       }
    
    @Override
    public List<CepCecMatriAlu> buscarAlumnosMatriculados(int id_grupo){
        Short estado=1;
        Query q = em.createQuery("SELECT object(c) FROM CepCecMatriAlu as c WHERE c.cepCecCurGrup.idCurGrup=:id_grupo AND c.estadoMatri=:estado" );
        q.setParameter("id_grupo", id_grupo);
        q.setParameter("estado", estado);
        List<CepCecMatriAlu> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados;
                  // Devuelve  encontrado            
              }
       }

    
}
