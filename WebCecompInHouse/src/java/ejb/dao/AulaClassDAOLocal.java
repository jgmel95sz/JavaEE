/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.CepAulaClass;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MELVN
 */
@Local
public interface AulaClassDAOLocal extends GenericoJPADAOLocal<CepAulaClass>{
    List<CepAulaClass> buscarTodos();
}
