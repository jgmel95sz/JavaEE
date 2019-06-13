/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.PspUserapp;
import javax.ejb.Local;

/**
 *
 * @author Melvin
 */
@Local
public interface PspUserAppDAOLocal  extends GenericoJPADAOLocal<PspUserapp>{
    
        public PspUserapp buscarSiTieneAccesoComoAdministrador(Integer uid);
         public PspUserapp buscarSiTieneAccesoComoMantenimiento(Integer uid);

}
