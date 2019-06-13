/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
//import java.math.Float;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "cep_cec_inversion_curso")
@NamedQueries({
    @NamedQuery(name = "CepCecInversionCurso.findAll", query = "SELECT c FROM CepCecInversionCurso c")
    , @NamedQuery(name = "CepCecInversionCurso.findByIdInversion", query = "SELECT c FROM CepCecInversionCurso c WHERE c.idInversion = :idInversion")
    , @NamedQuery(name = "CepCecInversionCurso.findByDescripcionInv", query = "SELECT c FROM CepCecInversionCurso c WHERE c.descripcionInv = :descripcionInv")
    , @NamedQuery(name = "CepCecInversionCurso.findByEstadoInver", query = "SELECT c FROM CepCecInversionCurso c WHERE c.estadoInver = :estadoInver")
    , @NamedQuery(name = "CepCecInversionCurso.findByPrecioTotal", query = "SELECT c FROM CepCecInversionCurso c WHERE c.precioTotal = :precioTotal")
    , @NamedQuery(name = "CepCecInversionCurso.findByPrecioPension", query = "SELECT c FROM CepCecInversionCurso c WHERE c.precioPension = :precioPension")
    , @NamedQuery(name = "CepCecInversionCurso.findByNombreConcepto", query = "SELECT c FROM CepCecInversionCurso c WHERE c.nombreConcepto = :nombreConcepto")
    , @NamedQuery(name = "CepCecInversionCurso.findByConceptoTotal", query = "SELECT c FROM CepCecInversionCurso c WHERE c.conceptoTotal = :conceptoTotal")
    , @NamedQuery(name = "CepCecInversionCurso.findByUnicoPagototal", query = "SELECT c FROM CepCecInversionCurso c WHERE c.unicoPagototal = :unicoPagototal")})
public class CepCecInversionCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_inversion")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idInversion;
    @Size(max = 300)
    @Column(name = "descripcion_inv")
    private String descripcionInv;
    @Column(name = "estado_inver")
    private Short estadoInver;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_total")
    private Float precioTotal;
    @Column(name = "precio_pension")
    private Float precioPension;
    @Size(max = 300)
    @Column(name = "nombre_concepto")
    private String nombreConcepto;
    @Column(name = "concepto_total")
    private Short conceptoTotal;
    @Column(name = "unico_pagototal")
    private Boolean unicoPagototal;
    @JoinColumn(name = "id_curso_subdet", referencedColumnName = "id_curso_subdet")
    @ManyToOne(optional = false)
    private CepCecCursoSubdet cepCecCursoSubdet;
    @JoinColumn(name = "id_tip_alumno", referencedColumnName = "id_tip_alumno")
    @ManyToOne(optional = false)
    private CepCecTipAlumno cepCecTipAlumno;
    @JoinColumn(name = "id_tipoinversion", referencedColumnName = "id_tipoinversion")
    @ManyToOne(optional = false)
    private CepCecTipoInversion cepCecTipoInversion;
    @JoinColumn(name = "id_concepto", referencedColumnName = "id_concepto")
    @ManyToOne
    private RcdConcepto rcdConcepto;
    @OneToMany( mappedBy = "cepCecInversionCurso")
    private List<CepCecDescExonerados> cepCecDescExoneradosList;

    public CepCecInversionCurso() {
    }

    public CepCecInversionCurso(Integer idInversion) {
        this.idInversion = idInversion;
    }

    public Integer getIdInversion() {
        return idInversion;
    }

    public void setIdInversion(Integer idInversion) {
        this.idInversion = idInversion;
    }

    public String getDescripcionInv() {
        return descripcionInv;
    }

    public void setDescripcionInv(String descripcionInv) {
        this.descripcionInv = descripcionInv;
    }

    public Short getEstadoInver() {
        return estadoInver;
    }

    public void setEstadoInver(Short estadoInver) {
        this.estadoInver = estadoInver;
    }

    public Float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Float getPrecioPension() {
        return precioPension;
    }

    public void setPrecioPension(Float precioPension) {
        this.precioPension = precioPension;
    }

    public String getNombreConcepto() {
        return nombreConcepto;
    }

    public void setNombreConcepto(String nombreConcepto) {
        this.nombreConcepto = nombreConcepto;
    }

    public Short getConceptoTotal() {
        return conceptoTotal;
    }

    public void setConceptoTotal(Short conceptoTotal) {
        this.conceptoTotal = conceptoTotal;
    }

    public Boolean getUnicoPagototal() {
        return unicoPagototal;
    }

    public void setUnicoPagototal(Boolean unicoPagototal) {
        this.unicoPagototal = unicoPagototal;
    }

    public CepCecCursoSubdet getCepCecCursoSubdet() {
        return cepCecCursoSubdet;
    }

    public void setCepCecCursoSubdet(CepCecCursoSubdet cepCecCursoSubdet) {
        this.cepCecCursoSubdet = cepCecCursoSubdet;
    }

    public CepCecTipAlumno getCepCecTipAlumno() {
        return cepCecTipAlumno;
    }

    public void setCepCecTipAlumno(CepCecTipAlumno cepCecTipAlumno) {
        this.cepCecTipAlumno = cepCecTipAlumno;
    }

    public CepCecTipoInversion getCepCecTipoInversion() {
        return cepCecTipoInversion;
    }

    public void setCepCecTipoInversion(CepCecTipoInversion cepCecTipoInversion) {
        this.cepCecTipoInversion = cepCecTipoInversion;
    }

    public RcdConcepto getRcdConcepto() {
        return rcdConcepto;
    }

    public void setRcdConcepto(RcdConcepto rcdConcepto) {
        this.rcdConcepto = rcdConcepto;
    }

    public List<CepCecDescExonerados> getCepCecDescExoneradosList() {
        return cepCecDescExoneradosList;
    }

    public void setCepCecDescExoneradosList(List<CepCecDescExonerados> cepCecDescExoneradosList) {
        this.cepCecDescExoneradosList = cepCecDescExoneradosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInversion != null ? idInversion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecInversionCurso)) {
            return false;
        }
        CepCecInversionCurso other = (CepCecInversionCurso) object;
        if ((this.idInversion == null && other.idInversion != null) || (this.idInversion != null && !this.idInversion.equals(other.idInversion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecInversionCurso[ idInversion=" + idInversion + " ]";
    }
    
}
