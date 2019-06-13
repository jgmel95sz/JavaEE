/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepCecInversionCurso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Melvin
 */
@Stateless
public class InversionDAO extends GenericoJPADAO<CepCecInversionCurso> implements InversionDAOLocal {

    // Add business logic below. (Right-click in editor and choose
    // "metodo para todos")
    @Override
    public List<CepCecInversionCurso> buscarInversion(Integer idCurSubDet,Integer id_tipo_inver) {
        System.out.println("EN DAO");
        Short estado=1;
        //int tipoInverNormal = 1;
       // int tipoInverMediaBeca = 2;
        Query q = em.createQuery("SELECT object(p) FROM CepCecInversionCurso as p WHERE p.cepCecCursoSubdet.idCursoSubdet=:idcursubdet  AND p.estadoInver=:estado AND p.cepCecTipoInversion.idTipoinversion=:id_tipo_inver");
        q.setParameter("idcursubdet", idCurSubDet);
        q.setParameter("id_tipo_inver", id_tipo_inver);
        //q.setParameter("tipoInverMediaBeca", tipoInverMediaBeca);
        q.setParameter("estado", estado);
        List<CepCecInversionCurso> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            return null; // No encontrado
        } else {
            System.out.println("hay lIST EN DAO  " );
            return resultados; // Devuelve el alumno encontrado            
        }
    }
    
     @Override
    public List<CepCecInversionCurso> buscarInversionPorTipoAlmuno(Integer idCurSubDet, Integer tipoAlumno,Integer idconcepto) {
       
        System.out.println("llgo a dao");
        Short estado = 1 ;
        Integer tipoInverPagoPension=2; // menor igual que  2 solo para matricula 
        //cuando se hace la verificacion par apoder registrar ya cuando el alumno esta logeado en su cuenta 
        if (idCurSubDet!=0) {
              Query q = em.createQuery("SELECT object(p) FROM CepCecInversionCurso as p WHERE  p.cepCecCursoSubdet.idCursoSubdet=:idcursubdet AND p.cepCecTipAlumno.idTipAlumno=:tipoAlumno AND p.estadoInver=:estado AND p.cepCecTipoInversion.idTipoinversion <= :tipoInverPagoPension");
                q.setParameter("idcursubdet", idCurSubDet);
                q.setParameter("tipoAlumno", tipoAlumno);
                 q.setParameter("estado", estado);
                 q.setParameter("tipoInverPagoPension", tipoInverPagoPension);

                List<CepCecInversionCurso> resultados = q.getResultList();
                if (resultados.size() <= 0) {
                    System.out.println("no enctorno nada");
                    return null; // No encontrado
                } else {
                                System.out.println("enctorno algo");

                    return resultados; // Devuelve el alumno encontrado            
                }
         }else{
             /// sentnecia para el validar el voucher para el registro de un nuevo alumno general y aun cuando no esta logeado
                 Query q = em.createQuery("SELECT object(p) FROM CepCecInversionCurso as p WHERE   p.cepCecTipAlumno.idTipAlumno=:tipoAlumno AND p.estadoInver=:estado AND p.cepCecTipoInversion.idTipoinversion <= :tipoInverPagoPension AND p.rcdConcepto.idConcepto=:idconcepto");
                  
                   q.setParameter("tipoAlumno", tipoAlumno);
                    q.setParameter("estado", estado);
                    q.setParameter("idconcepto", idconcepto);
                    q.setParameter("tipoInverPagoPension", tipoInverPagoPension);

                   List<CepCecInversionCurso> resultados = q.getResultList();
                   if (resultados.size() <= 0) {
                       System.out.println("no enctorno nada");
                       return null; // No encontrado
                   } else {
                                   System.out.println("enctorno algo");

                       return resultados; // Devuelve el alumno encontrado            
                   }
         }
       
    }
    
/*
    @Override
    public List<CepCecInversionCurso> buscarInversionPorPubGeneral(Integer idCurSubDet) {
        Query q = em.createQuery("SELECT object(p) FROM CepCecInversionCurso as p WHERE  p.cepCecCursoSubdet.idCursoSubdet=:idcursubdet AND p.cepCecTipAlumno.idTipAlumno=2 AND p.estadoInver=1");
        q.setParameter("idcursubdet", idCurSubDet);
        List<CepCecInversionCurso> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            return null; // No encontrado
        } else {
            System.out.println("Motivo de atencion: " + resultados.get(resultados.size() - 1));
            return resultados; // Devuelve el alumno encontrado            
        }
    }

    @Override
    public List<CepCecInversionCurso> buscarInversionTrabajadorUNS(Integer idCurSubDet) {
        Query q = em.createQuery("SELECT object(p) FROM CepCecInversionCurso as p WHERE  p.cepCecCursoSubdet.idCursoSubdet=:idcursubdet AND p.cepCecTipAlumno.idTipAlumno=2 AND p.estadoInver=1");
        q.setParameter("idcursubdet", idCurSubDet);
        List<CepCecInversionCurso> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            return null; // No encontrado
        } else {
            System.out.println("Motivo de atencion: " + resultados.get(resultados.size() - 1));
            return resultados; // Devuelve el alumno encontrado            
        }
    }
*/
    @Override
    public CepCecInversionCurso validarSiExisteInversionporCurso(int id) {
        Short estado=1;
        Query q = em.createQuery("SELECT object(c) FROM CepCecInversionCurso as c WHERE c.estadoInver=:estado AND c.cepCecCursoSubdet.idCursoSubdet=:id");
        q.setParameter("id", id);
        q.setParameter("estado", estado);
        List<CepCecInversionCurso> resultados = q.getResultList();

        if (resultados.size() <= 0) {
            return null;
        } else {
            return resultados.get(0);
        }

    }
    
     @Override
    public CepCecInversionCurso buscarInversionNulo(Integer idCurSubDet,Float precio,Short estadoConcepto,Integer tipoInver, Integer rcd) {
        Short estado=0;
        
        Query q = em.createQuery("SELECT object(c) FROM CepCecInversionCurso as c WHERE c.estadoInver=:estado AND c.cepCecCursoSubdet.idCursoSubdet=:idCurSubDet AND c.precioPension = :precio AND c.conceptoTotal=:estadoConcepto AND c.cepCecTipoInversion.idTipoinversion=:tipoInver AND c.rcdConcepto.idConcepto=:rcd ");
        q.setParameter("idCurSubDet", idCurSubDet);
        q.setParameter("estado", estado);
        q.setParameter("precio", precio);
        q.setParameter("estadoConcepto", estadoConcepto);
        q.setParameter("tipoInver", tipoInver);
        q.setParameter("rcd", rcd);


        List<CepCecInversionCurso> resultados = q.getResultList();

        if (resultados.size() <= 0 || resultados.size() > 1) {
            return null;
        } else {
            return resultados.get(0);
        }

    }
    
    
       
    @Override
    public List<CepCecInversionCurso> buscarCostoTotal(Integer idCurSubDet, Integer tipoAlumno,Integer tipo_inver) {
       
       // System.out.println("llgo a dao");
        Short estado = 1 ;
        //Integer tipoInverPago=1; // pago normal
        // Integer tipoInverMediBeca=2; // pago mediabeca
        // int tipoInverBeca=7
        Query q = em.createQuery("SELECT object(p) FROM CepCecInversionCurso as p WHERE  p.cepCecCursoSubdet.idCursoSubdet=:idCurSubDet AND p.cepCecTipAlumno.idTipAlumno=:tipoAlumno AND p.estadoInver=:estado AND p.cepCecTipoInversion.idTipoinversion =:tipo_inver");
        q.setParameter("idCurSubDet", idCurSubDet);
        q.setParameter("tipoAlumno", tipoAlumno);
        q.setParameter("estado", estado);
        //q.setParameter("tipoInverPago", tipoInverPago);
        q.setParameter("tipo_inver", tipo_inver);


        List<CepCecInversionCurso> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            System.out.println("no enctorno nada");
            return null; // No encontrado
        } else {
                        System.out.println("enctorno algo");

            return resultados; // Devuelve el alumno encontrado            
        }
    }
    
    
    @Override
    public CepCecInversionCurso buscarInver(Integer idCurSubDet, Integer tipoAlumno,Integer tipo_inver) {
       
       // System.out.println("llgo a dao");
        Short estado = 1 ;
        //Integer tipoInverPago=1; // pago normal
        // Integer tipoInverMediBeca=2; // pago mediabeca
        // int tipoInverBeca=7
        Query q = em.createQuery("SELECT object(p) FROM CepCecInversionCurso as p WHERE  p.cepCecCursoSubdet.idCursoSubdet=:idCurSubDet AND p.cepCecTipAlumno.idTipAlumno=:tipoAlumno AND p.estadoInver=:estado AND p.cepCecTipoInversion.idTipoinversion =:tipo_inver");
        q.setParameter("idCurSubDet", idCurSubDet);
        q.setParameter("tipoAlumno", tipoAlumno);
        q.setParameter("estado", estado);
        //q.setParameter("tipoInverPago", tipoInverPago);
        q.setParameter("tipo_inver", tipo_inver);


        List<CepCecInversionCurso> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            System.out.println("no enctorno nada");
            return null; // No encontrado
        } else {
                        System.out.println("enctorno algo");

            return resultados.get(0); // Devuelve el alumno encontrado            
        }
    }
    
    
    @Override
    public List<CepCecInversionCurso> listaInversion(Integer id_cursosubdet, Integer tipo_alu){
             // System.out.println("llgo a dao");
        Short estado = 1 ;
        //Integer tipoInverPago=1; // pago normal
        // Integer tipoInverMediBeca=2; // pago mediabeca
        // int tipoInverBeca=7
        Query q = em.createQuery("SELECT object(p) FROM CepCecInversionCurso as p WHERE  p.cepCecCursoSubdet.idCursoSubdet=:id_cursosubdet AND p.cepCecTipAlumno.idTipAlumno=:tipo_alu AND p.estadoInver=:estado");
        q.setParameter("id_cursosubdet", id_cursosubdet);
        q.setParameter("tipo_alu", tipo_alu);
        q.setParameter("estado", estado);
        //q.setParameter("tipoInverPago", tipoInverPago);
       // q.setParameter("tipo_inver", tipo_inver);


        List<CepCecInversionCurso> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            System.out.println("no enctorno nada");
            return null; // No encontrado
        } else {
                        System.out.println("enctorno algo");

            return resultados; // Devuelve el alumno encontrado            
        }
        
    }

    
    
    
}
