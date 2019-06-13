/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecCursoSubdet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class CursoSubDetalleDAO extends GenericoJPADAO<CepCecCursoSubdet> implements CursoSubDetalleDAOLocal  {

   @Override  
     public List<CepCecCursoSubdet> buscarTodos(){
       Short estado = 1;
      Query q = em.createQuery("SELECT object(p) FROM CepCecCursoSubdet as p WHERE p.estadoDetcur = :estado");
      q.setParameter("estado", estado);
      List<CepCecCursoSubdet> resultados =q.getResultList();  
      if (resultados.size()<=0){
                return null; // No encontrado
            }else{
                System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return resultados; // Devuelve el alumno encontrado            
            }
     }
     
     @Override 
     public List<CepCecCursoSubdet> buscarPorFiltro(int id_curso_det){
              Short estado = 1;
                Query q = em.createQuery("SELECT object(p) FROM CepCecCursoSubdet as p WHERE p.estadoDetcur = :estado AND p.cepCecCursoDet.idCursoDet=:id_curso_det");
                q.setParameter("estado", estado);
                q.setParameter("id_curso_det", id_curso_det);
                List<CepCecCursoSubdet> resultados =q.getResultList();  
                if (resultados.size()<=0){
                          return null; // No encontrado
                }else{
                          System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                          return resultados; // Devuelve el alumno encontrado            
                }
         }
   
     
     //verifica si la Escala ya ah sido asignado
    @Override
    public CepCecCursoSubdet validarIdEscala(int id) {
        Query q = em.createQuery("SELECT object(u) FROM CepCecCursoSubdet AS u WHERE u.cepEscalaTipomod.idEscala=:id AND u.cepEscalaTipomod.numCepEstpm=:cep" );
        q.setParameter("id", id);
        q.setParameter("cep", 3); // 2: ceiduns  3:cecomp

        List<CepCecCursoSubdet> resultados = q.getResultList();

        if (resultados.size() <= 0) {
            return null;
        } else {
            return resultados.get(0);
        }
    }
    
    @Override
    public Integer validarRepeticiones(int id_desarrollo,int id_escala,int id_curdet) {
    Short estado = 1;
      Query q = em.createQuery("SELECT object(p) FROM CepCecCursoSubdet as p WHERE  p.cepTipoDesarrollo.idTipoDes = :id_desarrollo AND p.cepEscalaTipomod.idEscala = :id_escala AND p.cepCecCursoDet.idCursoDet = :id_curdet AND p.estadoDetcur=:estado");
      q.setParameter("id_desarrollo", id_desarrollo);
      q.setParameter("id_curdet", id_curdet);
      q.setParameter("id_escala", id_escala);
       q.setParameter("estado", estado);
      List<CepCecCursoSubdet> resultados = q.getResultList();
    
            if (resultados.size()<=0){
                return 0; // No encontrado
            }else{
               
                return 1; // Devuelve el alumno encontrado            
            }
    
    }
     
     
     
}
