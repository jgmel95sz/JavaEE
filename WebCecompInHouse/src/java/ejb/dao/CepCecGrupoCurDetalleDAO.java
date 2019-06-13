/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import clases.CurGrupDetDoc;
import entidades.CepCecCurGrupDet;
import entidades.DrtPersonanatural;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Victor Lluen
 */
@Stateless
public class CepCecGrupoCurDetalleDAO extends GenericoJPADAO<CepCecCurGrupDet> implements CepCecGrupoCurDetalleDAOLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<CurGrupDetDoc> listarDocentesCursoGrupDet() {

        System.out.println("seleccion querys");
        Query q = em.createQuery("SELECT DISTINCT u.idDir FROM CepCecCurGrupDet as u WHERE u.idDir > 0   ");
       // Query q1 = em.createQuery("SELECT DISTINCT u.drtPersonanatural.nombreCompleto FROM CepCecCurGrupDet AS u WHERE u.drtPersonanatural.idDir > 0 ");
        System.out.println("instancio general");
        //lista general
        List<CurGrupDetDoc> resultadosGeneral = new ArrayList<CurGrupDetDoc>();
        //listas hijos
        System.out.println("instancio hijos");

        List<Integer> listDirDocente = new ArrayList<Integer>();
        //List<String> listNombreDocente = new ArrayList<String>();
        //obteniendo lista de resultados
        listDirDocente = q.getResultList();
        //listNombreDocente = q1.getResultList();
        System.out.println("guardo resultados querys en listas");

        if (listDirDocente.size() > 0) {
            System.out.println("es mayor a  0 la lista");

            for (int i = 0; i < listDirDocente.size(); i++) {
                int idir;
                CurGrupDetDoc curDoc = new CurGrupDetDoc();
                curDoc.setIdDir(listDirDocente.get(i));
                System.out.println("dir  " + (i + 1) + ": " + listDirDocente.get(i));
                idir = listDirDocente.get(i);
                Query q1 = em.createQuery("SELECT  object(u)  FROM DrtPersonanatural as u WHERE u.idDir =:idir");
                q1.setParameter("idir",idir );
                List<DrtPersonanatural> persona = q1.getResultList();
                curDoc.setNombreDocente(persona.get(0).getNombreCompleto());
               // System.out.println("nombre  " + (i + 1) + ": " + listNombreDocente.get(i));
                resultadosGeneral.add(curDoc);
            }

            if (resultadosGeneral.size() <= 0) {
                System.out.println("no hay nada en resultado general");
                return null;
            } else {
                System.out.println("si retornó resultado final");
                return resultadosGeneral;

            }

        } else {
            System.out.println("no hay nada en resultado segundo null");

            return null;
        }

    }

    @Override
    public CepCecCurGrupDet capturarDetalle(int curgrupo) {
        Short estado = 1;
        Query q = em.createQuery("SELECT object(p)  FROM CepCecCurGrupDet as p WHERE p.cepCecCurGrup.idCurGrup = :curgrupo AND p.estadoCurGrupDet = :estado");
        q.setParameter("estado", estado);
        q.setParameter("curgrupo", curgrupo);
        List<CepCecCurGrupDet> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            return null; // No encontrado
        } else {
            return resultados.get(0); // Devuelve la entidad         
        }

    }

    @Override
    public Integer buscarDocentes(int curgrup) {
        Short estado = 1;
        
        Query q = em.createQuery("SELECT object(p)  FROM CepCecCurGrupDet as p WHERE p.cepCecCurGrup.idCurGrup=:curgrup AND p.estadoCurGrupDet=:estado AND p.idDir IS NOT NULL ");
        q.setParameter("curgrup", curgrup);
        q.setParameter("estado", estado);
       // q.setParameter("idDir", idDir);

        List<CepCecCurGrupDet> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            return 0; // No encontrado
        } else {
            return 1; //            
        }
    }
    
    
      @Override
      public Integer buscarLaboratoriosAsignados(int curgrup) {
        Short estado = 1;
        
        Query q = em.createQuery("SELECT object(p)  FROM CepCecCurGrupDet as p WHERE p.cepCecCurGrup.idCurGrup=:curgrup AND p.estadoCurGrupDet=:estado AND p.cepAulaClass.idAulClass IS NOT NULL ");
        q.setParameter("curgrup", curgrup);
        q.setParameter("estado", estado);
       // q.setParameter("idDir", idDir);

        List<CepCecCurGrupDet> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            return 0; // No encontrado
        } else {
            return 1; //            
        }
    }

      
    @Override
    public List<CepCecCurGrupDet> buscarGruposPorDocente(Integer dir) {
        Short estado = 1;
        Boolean estadoAcademico = true;
        Query q = em.createQuery("SELECT object(p)  FROM CepCecCurGrupDet as p WHERE p.cepCecCurGrup.estadoAcademico=:estadoAcademico AND p.estadoCurGrupDet = :estado AND p.idDir=:dir");
        q.setParameter("estado", estado);
        q.setParameter("estadoAcademico", estadoAcademico);
        q.setParameter("dir", dir);
        List<CepCecCurGrupDet> resultados = q.getResultList();
        if (resultados.size() <= 0) {
            return null; // No encontrado
        } else {
            return resultados; // Devuelve la entidad         
        }

    }
    
    @Override
    public boolean validarSiEsDocente(int dir){
        Short estado = 1;
        Boolean estadoAcademico = true;
        Query q = em.createQuery("SELECT object(p)  FROM CepCecCurGrupDet as p WHERE p.cepCecCurGrup.estadoAcademico=:estadoAcademico AND p.estadoCurGrupDet = :estado AND p.idDir=:dir AND p.cepCecCurGrup.estadoGrupoCab=:estado");
        q.setParameter("estado", estado);
        q.setParameter("estadoAcademico", estadoAcademico);
        q.setParameter("dir", dir);
        List<CepCecCurGrupDet> resultados = q.getResultList();
        return resultados.size() > 0; // No encontrado
        // Devuelve la entidad
    };
    
    
  
}
