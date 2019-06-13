/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Melvin
 */
public class MetodosExtras {

    public String doAleatorio() {
        int n = 998; // genera un numero hasta 998  
        int numero = (int) (Math.random() * n) + 1;  // +1 para que no genere 0, maximo valor 999 tres diigitos
        String cad = "" + numero;
        return cad;
    }

    public String doFechaConFormatoDMY(Date fecha) {
        String newstring = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
        return newstring;
    }

     public String doFechaHoraConFormato(Date fecha){
        String pattern = "dd-MM-yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String stringDate = simpleDateFormat.format(fecha);
        //String date = simpleDateFormat.format(new Date());
        return stringDate;
      } 
    
     public  Date obtenerFechaActualSinSegundos(){
        //Obtenemos fecha y hora actuales
         Calendar currDtCal = Calendar.getInstance();
        //Eliminamos segundos y milisegundos si no necesitamos esa precisión.
        currDtCal.set(Calendar.SECOND, 0);
        currDtCal.set(Calendar.MILLISECOND, 0);
        //Guardamos la fecha y hora actuales sin segundos ni milisegundos
        Date actual = currDtCal.getTime();
        return actual;
    }
     
    public Date obtenerFechaActualSinTime() {
        //Obtenemos fecha y hora actuales
        Calendar currDtCal = Calendar.getInstance();
        //Eliminamos segundos y milisegundos si no necesitamos esa precisión.
        //También podríamos eliminar hora y minutos si solo nos interesa año, mes y día
        currDtCal.set(Calendar.HOUR_OF_DAY, 0);
        currDtCal.set(Calendar.MINUTE, 0);
        currDtCal.set(Calendar.SECOND, 0);
        currDtCal.set(Calendar.MILLISECOND, 0);
        //Guardamos la fecha y hora actuales sin horas,segundos ni milisegundos
        Date actual = currDtCal.getTime();
        return actual;
    }

    public String obteneAnioActual(){
        Date fecha = new Date();
        String anio ="" +  (fecha.getYear()+1900) ;
        return anio;
    }
            
    public Date obtenerHoraActualSinFecha() {
        //Obtenemos fecha y hora 
        Calendar currDtCal = Calendar.getInstance();
        currDtCal.set(Calendar.DAY_OF_MONTH, 0);
        currDtCal.set(Calendar.MONTH, 0);
        currDtCal.set(Calendar.YEAR, 0);
        //Guardamos la hora actual sin fecha
        Date actual = currDtCal.getTime();
        return actual;
    }

    
    public Date unirFechayHora(Date fecha, Date hora) {
        // convierte date ah calendar
        Calendar currDtCal = this.dateToCalendar(fecha);
        //Ingresamos la hora a la fecha
        currDtCal.set(Calendar.HOUR_OF_DAY, hora.getHours());
        currDtCal.set(Calendar.MINUTE, hora.getMinutes());
        currDtCal.set(Calendar.SECOND, 0);
        currDtCal.set(Calendar.MILLISECOND, 0);
        //Convertimos de Calendar a Date
        Date fechaObtenida = currDtCal.getTime();
        return fechaObtenida;
    }

    //Convertir Date ah Calendar 
    public Calendar dateToCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
    
    
   //calcular el tamaño de paginacion
    
    public int tamanoPaginacion( int pageSize,int countResult){
        // int pageSize= 5; // 5 rows por cada pagina
         //double dividec = (double)countResult / (double)pageSize;
         // System.out.println("divi dec es  "+dividec);
         int tamano = countResult /pageSize;
         System.out.println("Divi es = "+ tamano);
          if (countResult%pageSize==0) {
             System.out.println("Divi Final es = "+ tamano);
         }else{
             tamano++;
             System.out.println("Divi Final es = "+ tamano);
         }
         return tamano;    
    }

    
    
   public String limpiarAcentos(String cadena) {
    String limpio =null;
    if (cadena !=null) {
        String valor = cadena;
        //valor = valor.toUpperCase();
        // Normalizar texto para eliminar acentos, dieresis, cedillas y tildes
        limpio = Normalizer.normalize(valor, Normalizer.Form.NFD);
        // Quitar caracteres no ASCII excepto la enie, interrogacion que abre, exclamacion que abre, grados, U con dieresis.
        limpio = limpio.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
        // Regresar a la forma compuesta, para poder comparar la enie con la tabla de valores
        limpio = Normalizer.normalize(limpio, Normalizer.Form.NFC);
    }
    return limpio;
    }

   
  
  //Primera Letra en Mayuscula de una palabra u oracion
    public String Formal(String cadena){
     char letra ;
     String nuevaCadena="";
     Short condicion = 0;
      //  System.out.println("longitud cadena es "+cadena.length());
        for (int i = 0; i < cadena.length(); i++) {
            letra = cadena.charAt(i);
            letra = Character.toLowerCase(letra);
            if (i == 0) {
                letra = Character.toUpperCase(letra);
            }
            if (letra == ' ' ) {
                     condicion=1;                         
            }
            if (condicion==1 && letra!=' ') {
                 letra = Character.toUpperCase(letra);
                 condicion=0;
            }
            nuevaCadena = nuevaCadena + letra ; 
        }
  
        return nuevaCadena;
    }
    
    
     public String eliminarStringEnBlanco(String cadena){
     char letra ;
     String nuevaCadena="";
        for (int i = 0; i < cadena.length(); i++) {
            letra = cadena.charAt(i);       
            if (letra != ' ' ) {
                nuevaCadena = nuevaCadena + letra ;
            }else{
                nuevaCadena = cadena;
                break;
            }
        }
        return nuevaCadena;
    }
    
     public String CortarPrimeraPalabra(String cadena){
     char letra ;
     String nuevaCadena="";
     Short condicion = 0;
       // System.out.println("longitud cadena es "+cadena.length());
        for (int i = 0; i < cadena.length(); i++) {
            letra = cadena.charAt(i);       
            if (letra == ' ' ) {
                     condicion=1;  
                     break;
            }    
            nuevaCadena = nuevaCadena + letra ; 
        }
  
        return nuevaCadena;
    }
     
     public String doConvertirFechaAhFormatoddMMyyyy(Date fecha){
         String formatoFecha = null;
         
         Calendar fechaSelect;
         fechaSelect = dateToCalendar(fecha);
         formatoFecha = fechaSelect.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.getMonth() + 1) + "/" + (fecha.getYear() - 100);

         return formatoFecha;
     }
 
     public String doGeneradorDeCodigo(Integer id){
         String cod = "" +  id;
         while (cod.length()<10) {             
              cod = "0" + cod;
         }
         //System.out.println("cod "+cod);
         String anio = obteneAnioActual();
        //  System.out.println("chat at 2 : "+anio.charAt(2));
        //  System.out.println("char at 3 : "+anio.charAt(3));
          String numanio= "" + anio.charAt(2) + anio.charAt(3);
         // System.out.println("numanio = "+numanio);
         cod = numanio +cod ;
         return cod;
     }
     

      
  public Integer[] burbujaMejorada(Integer arreglo[], String vector[]) {

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int aux1 = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux1;

                    String aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;
                }
            }
        }
        return arreglo;
    }
}
