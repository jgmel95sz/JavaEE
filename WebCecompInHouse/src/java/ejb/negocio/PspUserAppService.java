/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.PspUserAppDAOLocal;
import entidades.PspUserapp;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class PspUserAppService implements PspUserAppServiceLocal {

    @EJB
    private PspUserAppDAOLocal pspUserAppDAO;

    @Override
    public boolean tieneAccesoComoAdministrador(Integer uid){
        PspUserapp userapp =    pspUserAppDAO.buscarSiTieneAccesoComoAdministrador(uid);
        // si es diferente a null es true
        return userapp!=null;
      }
    
    
     @Override
    public boolean tieneAccesoComoMantenimiento(Integer uid){
        PspUserapp userapp =    pspUserAppDAO.buscarSiTieneAccesoComoMantenimiento(uid);
        // si es diferente a null es true
        return userapp!=null;
      }

}
