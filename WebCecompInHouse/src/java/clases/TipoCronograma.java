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
public class TipoCronograma {
    
    private String id;
    private Integer id_cronogramaDet;
    private  String descripcion;
    private  Date hi;
    private  Date hf;
    private Date fi;
    private Date ff;
    private Integer tipo;
    private Integer numpago;

    public TipoCronograma() {
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Integer getId_cronogramaDet() {
        return id_cronogramaDet;
    }

    public void setId_cronogramaDet(Integer id_cronogramaDet) {
        this.id_cronogramaDet = id_cronogramaDet;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getHi() {
        return hi;
    }

    public void setHi(Date hi) {
        this.hi = hi;
    }

    public Date getHf() {
        return hf;
    }

    public void setHf(Date hf) {
        this.hf = hf;
    }

    public Date getFi() {
        return fi;
    }

    public void setFi(Date fi) {
        this.fi = fi;
    }

    public Date getFf() {
        return ff;
    }

    public void setFf(Date ff) {
        this.ff = ff;
    }

    public Integer getNumpago() {
        return numpago;
    }

    public void setNumpago(Integer numpago) {
        this.numpago = numpago;
    }

 
    
    
}
