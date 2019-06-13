/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Melvin
 */
public class InversionCurso {

    private Integer idInversionCurso;
    private Integer inversion; // id de CepCecInversion
    private Float precio;
    private Integer codigo;
    private String descripcion;
    private String nombre;
    private Boolean pagoTotal; // si es true es de pago total
    private Integer condicion_alumno;// variable que se va guardar en cep_cec_matri  y que nos hace saber de que tipo de alumno segun se de el caso de Noraml, Media beca o Beca , primero se guarda con el id_tipo_inver
    private Integer id_rcdVoucher; // guard el id_de rcd voucher cuando ingresa a buscarlo en la tabla de rcd_voucher
    private Integer id_tipo_alumno;
   
    public InversionCurso() {

    }

    public Integer getId_rcdVoucher() {
        return id_rcdVoucher;
    }

    public void setId_rcdVoucher(Integer id_rcdVoucher) {
        this.id_rcdVoucher = id_rcdVoucher;
    }
    

    public Integer getIdInversionCurso() {
        return idInversionCurso;
    }

    public void setIdInversionCurso(Integer idInversionCurso) {
        this.idInversionCurso = idInversionCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getInversion() {
        return inversion;
    }

    public void setInversion(Integer inversion) {
        this.inversion = inversion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(Boolean pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public Integer getCondicion_alumno() {
        return condicion_alumno;
    }

    public void setCondicion_alumno(Integer condicion_alumno) {
        this.condicion_alumno = condicion_alumno;
    }

    public Integer getId_tipo_alumno() {
        return id_tipo_alumno;
    }

    public void setId_tipo_alumno(Integer id_tipo_alumno) {
        this.id_tipo_alumno = id_tipo_alumno;
    }

   
}
