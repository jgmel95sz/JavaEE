/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author Melvin
 */
public class PagosMatricula {
    //Clase para unir tablas del pgu_pagosperdet con cep_cec_matri_pagos
    private Integer id; 
    private Integer codigo; //codigo del concepto
    private String concepto; // nombreDelConcepto
    private Float monto; //el monto que pago
    private Date fecha; // la fecha que pago en el banco

    public PagosMatricula() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
    
    
    
}
