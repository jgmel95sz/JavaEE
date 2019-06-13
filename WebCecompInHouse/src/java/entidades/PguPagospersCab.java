/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
//import java.math.Float;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "pgu_pagospers_cab")
@NamedQueries({
    @NamedQuery(name = "PguPagospersCab.findAll", query = "SELECT p FROM PguPagospersCab p")
    , @NamedQuery(name = "PguPagospersCab.findByIdNumpago", query = "SELECT p FROM PguPagospersCab p WHERE p.idNumpago = :idNumpago")
    , @NamedQuery(name = "PguPagospersCab.findByIdDep", query = "SELECT p FROM PguPagospersCab p WHERE p.idDep = :idDep")
    , @NamedQuery(name = "PguPagospersCab.findByIdDir", query = "SELECT p FROM PguPagospersCab p WHERE p.idDir = :idDir")
    , @NamedQuery(name = "PguPagospersCab.findByFecha", query = "SELECT p FROM PguPagospersCab p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "PguPagospersCab.findBySaldo", query = "SELECT p FROM PguPagospersCab p WHERE p.saldo = :saldo")
    , @NamedQuery(name = "PguPagospersCab.findByMora", query = "SELECT p FROM PguPagospersCab p WHERE p.mora = :mora")
    , @NamedQuery(name = "PguPagospersCab.findByEstado", query = "SELECT p FROM PguPagospersCab p WHERE p.estado = :estado")
    , @NamedQuery(name = "PguPagospersCab.findByObservacion", query = "SELECT p FROM PguPagospersCab p WHERE p.observacion = :observacion")})
public class PguPagospersCab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_numpago")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idNumpago;
    @Column(name = "id_dep")
    private Integer idDep;
    @Column(name = "id_dir")
    private Integer idDir;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Float saldo;
    @Column(name = "mora")
    private Float mora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Size(max = 250)
    @Column(name = "observacion")
    private String observacion;
    @OneToMany(mappedBy = "pguPagospersCab")
    private List<CepCecMatriPago> cepCecMatriPagoList;
    @OneToMany(mappedBy = "pguPagospersCab")
    private List<PguPagospersDet> pguPagospersDetList;
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    @ManyToOne
    private PspUsuario pspUsuario;

    public PguPagospersCab() {
    }

    public PguPagospersCab(Integer idNumpago) {
        this.idNumpago = idNumpago;
    }

    public PguPagospersCab(Integer idNumpago, boolean estado) {
        this.idNumpago = idNumpago;
        this.estado = estado;
    }

    public Integer getIdNumpago() {
        return idNumpago;
    }

    public void setIdNumpago(Integer idNumpago) {
        this.idNumpago = idNumpago;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Float getMora() {
        return mora;
    }

    public void setMora(Float mora) {
        this.mora = mora;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public List<CepCecMatriPago> getCepCecMatriPagoList() {
        return cepCecMatriPagoList;
    }

    public void setCepCecMatriPagoList(List<CepCecMatriPago> cepCecMatriPagoList) {
        this.cepCecMatriPagoList = cepCecMatriPagoList;
    }

    public List<PguPagospersDet> getPguPagospersDetList() {
        return pguPagospersDetList;
    }

    public void setPguPagospersDetList(List<PguPagospersDet> pguPagospersDetList) {
        this.pguPagospersDetList = pguPagospersDetList;
    }

    public PspUsuario getPspUsuario() {
        return pspUsuario;
    }

    public void setPspUsuario(PspUsuario pspUsuario) {
        this.pspUsuario = pspUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNumpago != null ? idNumpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PguPagospersCab)) {
            return false;
        }
        PguPagospersCab other = (PguPagospersCab) object;
        if ((this.idNumpago == null && other.idNumpago != null) || (this.idNumpago != null && !this.idNumpago.equals(other.idNumpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PguPagospersCab[ idNumpago=" + idNumpago + " ]";
    }
    
}
