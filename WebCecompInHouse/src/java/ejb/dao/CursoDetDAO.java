/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;


import entidades.CepCecCursoDet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author MELVN
 */
@Stateless
public class CursoDetDAO extends GenericoJPADAO<CepCecCursoDet> implements CursoDetDAOLocal {

    
    @Override
    public long calculandoTotalRegistrosCursoDet(String nombre , Integer modensenanza){
         
           ///Calculando el total de registros  
         Short estado = 1;
         Query queryTotal ;
         if (modensenanza==0) {
         queryTotal = em.createQuery("SELECT count(c.idCursoDet) FROM CepCecCursoDet as c WHERE c.estadoCursoDet=:estado");
         queryTotal.setParameter("estado", estado);
       }else{
           if(nombre.compareTo("")==0){
            queryTotal = em.createQuery("SELECT count(c.idCursoDet) FROM CepCecCursoDet as c WHERE c.estadoCursoDet=:estado AND c.modEnsenanza=:modensenanza");
             queryTotal.setParameter("estado", estado);
             queryTotal.setParameter("modensenanza", modensenanza);
           }else{
              queryTotal = em.createQuery("SELECT count(c.idCursoDet) FROM CepCecCursoDet as c WHERE c.estadoCursoDet=:estado AND c.modEnsenanza = :modensenanza AND c.cepCecCursoCab.nomCurso LIKE :name");
              queryTotal.setParameter("estado", estado);
              queryTotal.setParameter("name", "%" + nombre + "%");
              queryTotal.setParameter("modensenanza", modensenanza);
           }
       }
       
         long countResult = (long)queryTotal.getSingleResult();  
         System.out.println("Total de registro de Todos los Grupos = "+countResult);
        ///Fin calculo total de registros
        //int countResult = 56;
         //int pageNumber = 1;
         return countResult;
    }
  
    
   @Override
    public List<CepCecCursoDet> buscarTodos(int pageNumber,String nombre , Integer modensenanza){
    
        //Query query = em.createQuery("From Foo");
        Short estado = 1;
        Query q;
       if (modensenanza==0) {
         q = em.createQuery("SELECT object(c) FROM CepCecCursoDet as c WHERE c.estadoCursoDet=:estado ORDER BY c.idCursoDet DESC");
         q.setParameter("estado", estado);
       }else{
           if(nombre.compareTo("")==0){
            q = em.createQuery("SELECT object(c) FROM CepCecCursoDet as c WHERE c.estadoCursoDet=:estado AND c.modEnsenanza=:modensenanza ORDER BY c.idCursoDet DESC");
             q.setParameter("estado", estado);
             q.setParameter("modensenanza", modensenanza);
           }else{
              q = em.createQuery("SELECT object(c) FROM CepCecCursoDet as c WHERE c.estadoCursoDet=:estado AND c.modEnsenanza = :modensenanza AND c.cepCecCursoCab.nomCurso LIKE :name ORDER BY c.idCursoDet DESC");
              q.setParameter("estado", estado);
              q.setParameter("name", "%" + nombre + "%");
              q.setParameter("modensenanza", modensenanza);
           }
       }
       
        //int pageNumber = 1;
        int pageSize=8;
        q.setFirstResult((pageNumber-1) * pageSize); //El primer registro **considerar que comienza desde 0
        q.setMaxResults(pageSize); //el tamaño maximo de registros a mostrar 
        List<CepCecCursoDet> resultados =q.getResultList();  
        
        if (resultados.size()<=0){
            System.out.println("no encontro");
                  return null; // No encontrado
                  
              }else{
                  System.out.println("ENTRO A DAO");
                  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados;
                  // Devuelve el alumno encontrado            
              }
       }
    
    @Override
    public List<CepCecCursoDet> buscarTodosCurDet(){
    
        //Query query = em.createQuery("From Foo");
        Short estado = 1;
        Query q = em.createQuery("SELECT object(c) FROM CepCecCursoDet as c WHERE c.estadoCursoDet=:estado ORDER BY c.idCursoDet DESC");
        q.setParameter("estado", estado);
       
        List<CepCecCursoDet> resultados =q.getResultList();  
        
        if (resultados.size()<=0){
            System.out.println("no encontro");
                  return null; // No encontrado
                  
              }else{
                  System.out.println("ENTRO A DAO");
                  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                  return resultados;
                  // Devuelve el alumno encontrado            
              }
       }
    
     @Override
    public CepCecCursoDet validarIdCursoCab(int id) {
        Short estado = 1;
        Query q = em.createQuery("SELECT object(u) FROM CepCecCursoDet AS u WHERE u.cepCecCursoCab.idCursoCab=:id AND u.estadoCursoDet=:estado");
        q.setParameter("id", id);
        q.setParameter("estado", estado);
        List<CepCecCursoDet> resultados = q.getResultList();
//        resultados.forEach((re) -> {
//            System.out.println(re.getCepCeiCursoCab2().getIdCursoCab());
//        });
        if (resultados.size() <= 0) {
            return null;
        } else {
            return resultados.get(0);
        }
    }
    
     @Override
    public Integer validarRepeticion(int id_cur_cab,int id_nivel, int mod_ensenanza) {
        Short estado=1;
        Query q = em.createQuery("SELECT object(c) FROM CepCecCursoDet as c WHERE c.cepCecCursoCab.idCursoCab=:id_cur_cab AND  c.estadoCursoDet=:estado AND c.cepNivel.idNivel = :id_nivel AND c.modEnsenanza=:mod_ensenanza");
        q.setParameter("id_nivel", id_nivel); 
        q.setParameter("id_cur_cab", id_cur_cab);
        q.setParameter("estado", estado);
        q.setParameter("mod_ensenanza", mod_ensenanza);

        List<CepCecCursoDet> resultados =q.getResultList();  
            if (resultados.size()<=0){
                  return 0; // No encontrado
              }else{
                  System.out.println("Motivo de atencion: "+resultados.get(resultados.size()-1));
                return 1; // Devuelve si encontro         
             }
    }
}
