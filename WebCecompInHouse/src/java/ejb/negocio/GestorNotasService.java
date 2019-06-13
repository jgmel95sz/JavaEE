/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.NotasDAOLocal;
import entidades.CepCecMatriAlu;
import entidades.CepCecNotas;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Melvin
 */
@Stateless
public class GestorNotasService implements GestorNotasServiceLocal {

    @EJB
    private GestorPguPagosCabServiceLocal gestorPguPagosCabService;

    @EJB
    private NotasDAOLocal notasDAO;
            
            
  
     @Override
     public List<CepCecNotas> buscarNotasDeAlumnosMatriculados(Integer id_grupo){
       return notasDAO.buscarNotasDeAlumnosMatriculados(id_grupo);
     }
    
     @Override
    public CepCecNotas crearNuevasNotas(CepCecMatriAlu cepCecMatriAlu) {
          boolean estado=true;
          CepCecNotas notas= new CepCecNotas();
          notas.setCepCecMatriAlu(cepCecMatriAlu);
          notas.setEstadoNotas(true);
          notas.setFechaRn(gestorPguPagosCabService.obtenerFechaActual());
          System.out.println("ENTRO A CREAR DURACION");
          return notasDAO.crear(notas);
    }
    
    
     @Override
    public CepCecNotas recuperarIdNotas(int id) {
        return notasDAO.buscarPorId(id);
    }
    
    
    @Override
    public CepCecNotas actualizarNotas(CepCecNotas item) {
         Float NotaFinal = (float)0;
         CepCecNotas entidadNotas = new CepCecNotas();
         entidadNotas = item;
         List<Float> notas = new ArrayList<Float>();
         notas.add(entidadNotas.getNota1());
         notas.add(entidadNotas.getNota2());
         notas.add(entidadNotas.getNota3());
         notas.add(entidadNotas.getNota4());
         
         for (Float nota : notas) {
            if (nota!=null) {
               NotaFinal = NotaFinal + nota;      
            }
         }
         
         NotaFinal = NotaFinal/4; 
         NotaFinal = redondearNota(NotaFinal);
         entidadNotas.setNotaFinal(NotaFinal);
        return notasDAO.actualizar(entidadNotas);
    }
    
    
     @Override
    public CepCecNotas actualizarNotasSubsanacion(CepCecNotas item){
         Float NotaFinal = item.getNotaSubsanacion();
         NotaFinal = redondearNota(NotaFinal);
         item.setNotaFinal(NotaFinal);
        return notasDAO.actualizar(item);
    }
    
    
    @Override
    public Integer verificarRangoNotas(CepCecNotas entidadNotas){
        Integer condicional = 0;
        List<Float> notas = new ArrayList<Float>();
         notas.add(entidadNotas.getNota1());
         notas.add(entidadNotas.getNota2());
         notas.add(entidadNotas.getNota3());
         notas.add(entidadNotas.getNota4());
         for (Float nota : notas) {
            if (nota!=null && (nota<0 || nota>20) ) {
                   // no se puede registrar 
                   condicional = 1;
                   break;
            }
         }
      return condicional;    
             
    }
    
    
     @Override
    public Float redondearNota(Float x){
        Float Final;
        System.out.println("x = "+x);
        // se verifica si la suma es entero , si el residuo es 0 es entero
        if (x%1==0) {
           Final=x; 
           System.out.println("es entero" +Final);
        }else{
            System.out.println("no es entero");
            //verificamos si es menor al 0.5
            Float c = (float) Math.floor(x); //Redondeo al entero menor
            // genera un resta para ver los decimales
            c = x-c;
            System.out.println("la resta es "+c);
               if (c >= 0.5) {
                    Final = (float) Math.ceil(x);   //Redondeo al entero mayor   
                    System.out.println("FINAL ES "+Final);
               }else{
                    Final = (float) Math.floor(x); //Redondeo al entero menor 
                   System.out.println("FINAL ES "+Final);
               }
        }
     return Final;
    }
    
   @Override 
    public List<CepCecNotas> buscarNotasDeLosCursosMatriculadosActivos(Integer dir){
      return notasDAO.buscarNotasDeLosCursosMatriculadosActivos(dir);
    }
    
    @Override 
    public List<CepCecNotas> buscarNotasDeLosCursosMatriculadosInactivos(Integer dir){
      return notasDAO.buscarNotasDeLosCursosMatriculadosInactivos(dir);
    }
    
    @Override 
    public CepCecNotas buscarNotasPorMatricula(Integer id_matri){
      return notasDAO.buscarNotasPorMatricula(id_matri);
    }
    
}
