/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.PspUserapp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class PspUserAppDAO extends GenericoJPADAO<PspUserapp>implements PspUserAppDAOLocal {
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
     @Override
    public PspUserapp buscarSiTieneAccesoComoAdministrador(Integer uid){
        //Short estado_user=1;
        Short estadoUser=1;
        Short acceso = 1 ;
        Integer administrador = 169;
        Short sistemaCecomp = 135; 
        Query q = em.createQuery("SELECT object(c) FROM PspUserapp as c WHERE c.acceso=:acceso AND c.pspAplicacion.pspApp=:sistemaCecomp AND c.pspGroupuser.pspGrupo.gid=:administrador AND c.pspGroupuser.pspUsuario.uid=:uid AND c.pspGroupuser.pspUsuario.stdUid=:estadoUser" );
        q.setParameter("estadoUser", estadoUser);
        q.setParameter("acceso", acceso);
        q.setParameter("administrador", administrador);
        q.setParameter("sistemaCecomp", sistemaCecomp);
        q.setParameter("sistemaCecomp", sistemaCecomp);
        q.setParameter("uid", uid);
       // q.setParameter("estado_user", estado_user);

        List<PspUserapp> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados.get(0);
                  // Devuelve el alumno encontrado            
              }
       }
    
    
    
       @Override
       public PspUserapp buscarSiTieneAccesoComoMantenimiento(Integer uid){
        Short estadoUser=1;
        Short acceso = 1 ;
        Integer mantenimiento = 170;
        Short sistemaCecomp = 135; 
        Query q = em.createQuery("SELECT object(c) FROM PspUserapp as c WHERE c.acceso=:acceso AND c.pspAplicacion.pspApp=:sistemaCecomp AND c.pspGroupuser.pspGrupo.gid=:mantenimiento AND c.pspGroupuser.pspUsuario.uid=:uid AND c.pspGroupuser.pspUsuario.stdUid=:estadoUser" );
        q.setParameter("estadoUser", estadoUser);
        q.setParameter("acceso", acceso);
        q.setParameter("mantenimiento", mantenimiento);
        q.setParameter("sistemaCecomp", sistemaCecomp);
        q.setParameter("uid", uid);
        List<PspUserapp> resultados =q.getResultList();  
        if (resultados.size()<=0){
                  return null; // No encontrado
              }else{
                  return resultados.get(0);
                  // Devuelve el alumno encontrado            
              }
       }
    
    
}
