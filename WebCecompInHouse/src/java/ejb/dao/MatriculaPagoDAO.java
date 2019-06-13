/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecMatriPago;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class MatriculaPagoDAO extends GenericoJPADAO<CepCecMatriPago> implements MatriculaPagoDAOLocal {

   @Override
   public Integer buscarSizePagosPorAlumno(int id_matri){
       System.out.println("llego a dao PAGO");
        Short estado=1;
        Integer tipo_matr= 1; // tipo de pago 1 =  matricula 
        Integer tipo_pago = 2; // tipo de pago 2 = pension
        Query q = em.createQuery("SELECT object(c) FROM CepCecMatriPago as c WHERE c.cepCecMatriAlu.idMatriAlu=:id_matri AND c.estadoMat =:estado AND  (c.cepCecTipoMatri.idTipoMatri=:tipo_matr OR c.cepCecTipoMatri.idTipoMatri=:tipo_pago )" );
        q.setParameter("id_matri", id_matri);
        q.setParameter("estado", estado);
        q.setParameter("tipo_matr", tipo_matr);
        q.setParameter("tipo_pago", tipo_pago);
        //q.setParameter("estadoAcademico", estadoAcademico);
        List<CepCecMatriPago> resultados =q.getResultList();  
               System.out.println("va retornal PAGO");

        if (resultados.size()<=0){
            System.out.println("NO ENCONTRO PAGO");
                  return 0; // No encontrado
              }else{
                System.out.println("encontro "+resultados.size()+" pagos");
                  return resultados.size();
                  // Devuelve  encontrado            
              }
       }  
   
   
   @Override
    public CepCecMatriPago buscarPagoMatriculaPorAlumno(Integer id_matri){
        Short estado=1;
        Integer tipo_matr= 1; // tipo de pago 1 =  matricula 
        //Boolean estadoAcademico = true;
        Query q = em.createQuery("SELECT object(c) FROM CepCecMatriPago as c WHERE  c.cepCecMatriAlu.idMatriAlu=:id_matri AND c.estadoMat=:estado AND c.cepCecTipoMatri.idTipoMatri=:tipo_matr" );
        q.setParameter("id_matri", id_matri);
        q.setParameter("estado", estado);
        q.setParameter("tipo_matr", tipo_matr);
        List<CepCecMatriPago> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados.get(0);
                  // Devuelve  encontrado            
              }
       }
    
    @Override
    public List<CepCecMatriPago> buscarPagosPorMatricula(Integer id_matri){
        Short estado=1;
        //Boolean estadoAcademico = true;
        Integer matricula=1;
        Integer pension=2;
        Query q = em.createQuery("SELECT object(c) FROM CepCecMatriPago as c WHERE  c.cepCecMatriAlu.estadoMatri =:estado AND c.cepCecMatriAlu.idMatriAlu =:id_matri AND (c.cepCecTipoMatri.idTipoMatri=:matricula OR c.cepCecTipoMatri.idTipoMatri=:pension)" );
        q.setParameter("id_matri", id_matri);
        q.setParameter("estado", estado);
        q.setParameter("matricula", matricula);
        q.setParameter("pension", pension);
        //q.setParameter("estadoAcademico", estadoAcademico);
        List<CepCecMatriPago> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados;
                  // Devuelve  encontrado            
              }
       }
    
    
    
    
     @Override
    public List<CepCecMatriPago> buscarAlumnosMatriculados(Integer id_grupo){
        Short estado=1;
        int matriculaInscripcion = 1;
        Query q = em.createQuery("SELECT object(c) FROM CepCecMatriPago as c WHERE c.cepCecMatriAlu.cepCecCurGrup.idCurGrup=:id_grupo AND c.estadoMat=:estado AND c.cepCecTipoMatri.idTipoMatri=:matriculaInscripcion" );
        q.setParameter("id_grupo", id_grupo);
        q.setParameter("matriculaInscripcion", matriculaInscripcion);
        q.setParameter("estado", estado);
        List<CepCecMatriPago> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados;
                  // Devuelve  encontrado            
              }
       }
  /*  
    @Override
    public List<CepCecMatriPago> buscarCursosEnProcesoPorAlumno(Integer id_dir){
        Short estado=1;
        Boolean estadoAcademico = true;
        Query q = em.createQuery("SELECT object(c) FROM CepCecMatriPago as c WHERE c.cepCecMatriAlu.cepCecCurGrup.estadoAcademico=:estadoAcademico AND c.cepCecMatriAlu.drtPersonanatural.idDir = :id_dir AND c.cepCecMatriAlu.estadoMatri =:estado " );
        q.setParameter("id_dir", id_dir);
        q.setParameter("estado", estado);
        q.setParameter("estadoAcademico", estadoAcademico);
        List<CepCecMatriPago> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados;
                  // Devuelve  encontrado            
              }
       }
   */
}
