package controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import javax.activation.MimetypesFileTypeMap;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
//import net.sf.jasperreports.export.SimpleExporterInput;
//import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

abstract class BaseController implements Serializable{
    //1. Atributos
     /**
      * Tipo:   Variable <br>
      * Descripcion: Nombre del archivo a cargar o descargar. <br>
      * Ejemplo: Manual.pdf
     */
    protected String bs_nombreFile; 
    /**
      * Tipo:   Variable <br>
      * Descripcion: Nombre del archivo a cargar o descargar. <br>
      * Ejemplo: Manual.pdf
     */
    protected String bs_nombreDescarga; 
     /**
      * Tipo:   Variable <br>
      * Descripcion: Ruta del archivo a cargar o descargar. <br>
      * Ejemplo: D:/Unidad1
     */
    protected String bs_rutaFile;
     /**
      * Tipo:   Variable <br>
      * Descripcion: Archivo el cual se va a cargar <br>
      * Ejemplo: 
     */
    protected byte[] bbt_file;
      /**
      * Tipo:   Variable <br>
      * Descripcion: Es el archivo el cual va a ser descargado <br>
      * Ejemplo: 
     */
    private StreamedContent bsc_file;
     /**
      * Tipo:   Variable <br>
      * Descripcion: Texto que se va a enviar o se va a mostrar como mensaje <br>
      * Ejemplo: El archivo fue cargado correctamente
     */
    protected String bs_mensaje;	
     /**
      * Tipo:   Variable <br>
      * Descripcion: Direccion de correo a quien se va a enviar <br>
      * Ejemplo: arkangel@hotmail.com
     */    
    protected String bs_destino; 				
     /**
      * Tipo:   Variable <br>
      * Descripcion: Asunto del correo a enviar <br>
      * Ejemplo: Nueva Contraseña de Acceso
     */        
    protected String bs_asunto;					//Asunto del correo a enviar
    //2. EJBs
    //3. Acciones JSF
    /**
     * Funcion que sirve para cargar un archivo a nuestra pc en una ruta determinada <br>
     * Utiliza las variables: bs_nombreFile, bs_rutaFile y bs_file
     * @throws FileNotFoundException
     * @throws IOException 
     */
    protected void doCargarFile() throws FileNotFoundException, IOException{
        System.out.println("llego a doCargarFile");
        bs_rutaFile = bs_rutaFile + "/" + bs_nombreFile;
        FileOutputStream fos = new FileOutputStream(bs_rutaFile); 
        fos.write(bbt_file); 
        fos.close(); 
    }
     /**
     * Funcion que sirve para descargar archivos de manera generica <br>
     * Utiliza las variables: bs_nombreFile y bs_rutaFile
     * @return Archivo a descargar
     * @throws java.io.FileNotFoundException
     */
    protected StreamedContent doDescargarFile() throws FileNotFoundException{
        System.out.println("llego a doDescargarFile");
        bs_rutaFile = bs_rutaFile + "/" + bs_nombreFile;
        System.out.println("documento: " + bs_rutaFile);
        File tempFile = new File(bs_rutaFile);
        System.out.println("paso 1");
        InputStream stream;
        System.out.println("paso 2");
        stream = new FileInputStream(tempFile);
        System.out.println("paso 3");
        bsc_file = new DefaultStreamedContent(stream, new MimetypesFileTypeMap().getContentType(tempFile),bs_nombreFile);
        try {
            System.out.println("paso 4");
            stream.reset();
        } catch (IOException e) {
            System.out.println("paso 5");
            // TODO Auto-generated catch block
            return null;
        }
        System.out.println("paso 6");
        return bsc_file;
    }
    /**
     * Funcion que permite la generación del reporte según sea el objeto
     * @param dsObjecto: Es el objeto del cual se genera el reporte
     * @param Parametros: Son los parametros que usa el reporte a generar
     */
    protected void doReporteCPDo(Object dsObjecto, Map Parametros){
        System.out.println("llego a doReporteCPDo");
        try{
            JRDataSource dataSource=null;
            if (dsObjecto == null)
		dataSource=null;
            if (dsObjecto instanceof JRDataSource)
                dataSource = (JRDataSource) dsObjecto;
            if (dsObjecto instanceof Collection)
                dataSource = new JRBeanCollectionDataSource((Collection) dsObjecto);
            if (dsObjecto instanceof ResultSet)
		dataSource = new JRResultSetDataSource((ResultSet) dsObjecto);
            if (dsObjecto.getClass().isArray())
		dataSource = new JRBeanArrayDataSource((Object[]) dsObjecto);
            System.out.println("dataSource: " + dataSource);
            String archivoJRXML="/reporte/"+ bs_nombreFile + ".jrxml";
            InputStream fileName = getClass().getResourceAsStream(archivoJRXML);
            JasperReport reporte= JasperCompileManager.compileReport(fileName);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, Parametros, dataSource);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            ServletOutputStream out = response.getOutputStream();
            response.setHeader("Content-Disposition", "attachment;filename=" + this.bs_nombreDescarga + ".pdf");
            FacesContext.getCurrentInstance().responseComplete();
//            JRPdfExporter exporter  = new JRPdfExporter();
//            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
//            exporter.exportReport();
            JRExporter exporter  = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
            exporter.exportReport();
        }catch (JRException ex){
            System.out.println("[tutorial] Error en la generacón del informe " + "(error: " + ex + ")");
        } catch (IOException ex) {
            System.out.println("[tutorial] Error en la generacón del informe " + "(error: " + ex + ")");
        }     
    }
    /**
     * Funcion que permite mandar un mensaje a un correo electronico<br>
     * Utiliza las variables: bs_destino, bs_mensaje y bs_asunto
     * @return TRUE: Si el correo fue enviado 
     * FALSE: Si el correo no fue enviado
     */
    protected boolean doSendMailTLS(){
        System.out.println("llego a doSendMailTLS");
        boolean rpta;
        final String username = "udemsi.uns@gmail.com";
	final String password = "unsUdemsi";
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "25");
            Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                                @Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
                }
            });
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("from-email@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(bs_destino));
                message.setSubject(bs_asunto);
                message.setText(bs_mensaje);
                Transport.send(message);              
                rpta=true;
            } catch (Exception e) {
                /*throw new RuntimeException(e);*/
                System.out.println("Exception " + e);
                rpta=false;
            }
        return rpta;
    } 
    /**
     * Funcion que permite mostrar un mensaje a la derecha de la pagina
     * @param titulo: Es el titulo que tendra el mensaje
     * @param msgbox: Es el mensaje que se desea mostrar
     * @param tipo: 1: Informativo 2: Peligro 3: Fatal  4: Error
     */
    public void doMensajeF(String titulo, String msgbox, Integer tipo){
        FacesMessage message=null;
        switch (tipo) {
            case 1: message = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, msgbox);
                    break;
            case 2: message = new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, msgbox);
                    break;
            case 3: message = new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, msgbox);
                    break;
            case 4: message = new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, msgbox);
                    break;
        }
        FacesContext.getCurrentInstance().addMessage(null, message );
    }
     /**
     * Funcion que permite mostrar un mensaje al medio de la pagina
     * @param titulo: Es el titulo que tendra el mensaje
     * @param msgbox: Es el mensaje que se desea mostrar
     * @param tipo: 1: Informativo 2: Peligro 3: Fatal  4: Error
     */
    protected void doMensajeR(String titulo, String msgbox, Integer tipo){
        FacesMessage message=null;
        switch (tipo) {
            case 1: message = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, msgbox);
                    break;
            case 2: message = new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, msgbox);
                    break;
            case 3: message = new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, msgbox);
                    break;
            case 4: message = new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, msgbox);
                    break;
        }
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    /**
     * Funcion que nos dirige a la ventana que dice en construccion
     * @return El nombre que dirige a la ventana en faces-config
     */
    protected String doIrConstruccion(){
        return "construccion.ver";
    }
    /**
     * Funcion que genera nueva clave de ocho caracteres
     * @return La nueva clave generada
     */
    protected String doNuevaClave(){
        String clave="";
        String letra[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9"};
        for (Integer i=0;i<8;i++){
            clave = clave + letra[(int) (Math.random()*35)];   
        }
        return clave;
    }
    /**
     * Funcion para encriptar una palabra en el formato especifico
     * @param entrada: Valor que se desea encriptar
     * @param metodo: Define el metodo con el cual se va a encriptar
     * @return 
     */
    protected String doEncriptar(String entrada, String metodo) {
        String salida = null;
        try {
            if (entrada != null) {
                MessageDigest algoritmo = MessageDigest.getInstance(metodo);
                algoritmo.reset();
                algoritmo.update(entrada.getBytes());
                byte bytes[] = algoritmo.digest();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    String hex = Integer.toHexString(0xff & bytes[i]);
                    if (hex.length() == 1) {
                        sb.append('0');
                    }
                    sb.append(hex);
                }
                salida = sb.toString();
            }
        } catch (NoSuchAlgorithmException e) {
        }
        return salida;
    }
    /**
     * Funcion que te transforma la fecha actual en literal<br>
     * Ejemplo: 25 de Diciembre del 2017
     * @return Fecha en formato largo 
     */
    public String doFechaSistemaLetras(){
        java.util.Date fechaActual = new java.util.Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        String fechaSistema=formateador.format(fechaActual);
        String dia = fechaSistema.substring(0, 2);
        String mes = fechaSistema.substring(3, 5);
        String meses=null;
        if(mes.equals("01")){
            meses="Enero";
        }else if(mes.equals("02")){
            meses="Febrero";
        }else if(mes.equals("03")){
            meses="Marzo";
        }else if(mes.equals("04")){
            meses="Abril";
        }else if(mes.equals("05")){
            meses="Mayo";
        }else if(mes.equals("06")){
            meses="Junio";
        }else if(mes.equals("07")){
            meses="Julio";
        }else if(mes.equals("08")){
            meses="Agosto";
        }else if(mes.equals("09")){
            meses="Septiembre";
        }else if(mes.equals("10")){
            meses="Octubre";
        }else if(mes.equals("11")){
            meses="Noviembre";
        }else if(mes.equals("12")){
            meses="Diciembre";
        } 
        String anio = fechaSistema.substring(6, 10);
        String formatoLetras =  dia +" de "+meses+" del "+anio;
        return formatoLetras;
    }
    /**
     * Recupera el valor asociado a un parametro de la página JSF
     * @param parametro
     * @return
     */
    protected String doRecuperarParametro(String parametro){
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> map = context.getExternalContext().getRequestParameterMap();
        return map.get(parametro);
    }
    /**
     * Recupera el id de tipo long asociado a un parametro de la página JSF
     * @param parametro
     * @return
     */
    protected long doRecuperarIdParametro(String parametro){
        return Long.parseLong(doRecuperarParametro(parametro));
    }
    
    //4. Metodos Propios
    //5. Metodos Get y Set

    public StreamedContent getBsc_file() {
        return bsc_file;
    }

    public void setBsc_file(StreamedContent bsc_file) {
        this.bsc_file = bsc_file;
    }

}

