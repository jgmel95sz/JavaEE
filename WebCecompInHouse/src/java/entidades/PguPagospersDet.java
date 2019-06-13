/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
//import java.math.Float;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "pgu_pagospers_det")
@NamedQueries({
    @NamedQuery(name = "PguPagospersDet.findAll", query = "SELECT p FROM PguPagospersDet p")
    , @NamedQuery(name = "PguPagospersDet.findByIdNumpago", query = "SELECT p FROM PguPagospersDet p WHERE p.pguPagospersDetPK.idNumpago = :idNumpago")
    , @NamedQuery(name = "PguPagospersDet.findByIdModltipo", query = "SELECT p FROM PguPagospersDet p WHERE p.pguPagospersDetPK.idModltipo = :idModltipo")
    , @NamedQuery(name = "PguPagospersDet.findByIdEsc", query = "SELECT p FROM PguPagospersDet p WHERE p.idEsc = :idEsc")
    , @NamedQuery(name = "PguPagospersDet.findByIdMesd", query = "SELECT p FROM PguPagospersDet p WHERE p.idMesd = :idMesd")
    , @NamedQuery(name = "PguPagospersDet.findByFechaPago", query = "SELECT p FROM PguPagospersDet p WHERE p.pguPagospersDetPK.fechaPago = :fechaPago")
    , @NamedQuery(name = "PguPagospersDet.findByNroCuota", query = "SELECT p FROM PguPagospersDet p WHERE p.pguPagospersDetPK.nroCuota = :nroCuota")
    , @NamedQuery(name = "PguPagospersDet.findByNroParte", query = "SELECT p FROM PguPagospersDet p WHERE p.pguPagospersDetPK.nroParte = :nroParte")
    , @NamedQuery(name = "PguPagospersDet.findByFechaOper", query = "SELECT p FROM PguPagospersDet p WHERE p.fechaOper = :fechaOper")
    , @NamedQuery(name = "PguPagospersDet.findByNroOperacion", query = "SELECT p FROM PguPagospersDet p WHERE p.nroOperacion = :nroOperacion")
    , @NamedQuery(name = "PguPagospersDet.findByMonto", query = "SELECT p FROM PguPagospersDet p WHERE p.monto = :monto")
    , @NamedQuery(name = "PguPagospersDet.findByObserv", query = "SELECT p FROM PguPagospersDet p WHERE p.observ = :observ")
    , @NamedQuery(name = "PguPagospersDet.findByHoraPago", query = "SELECT p FROM PguPagospersDet p WHERE p.horaPago = :horaPago")
    /*, @NamedQuery(name = "PguPagospersDet.findByEstado", query = "SELECT p FROM PguPagospersDet p WHERE p.pguPagospersDetPK.estado = :estado")*/})
public class PguPagospersDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PguPagospersDetPK pguPagospersDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "id_esc")
    private Integer idEsc;
    @Column(name = "id_mesd")
    private Short idMesd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_oper")
    @Temporal(TemporalType.DATE)
    private Date fechaOper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nro_operacion")
    private String nroOperacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private Float monto;
    @Size(max = 250)
    @Column(name = "observ")
    private String observ;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_pago")
    @Temporal(TemporalType.TIME)
    private Date horaPago;
    @JoinColumn(name = "id_banco", referencedColumnName = "id_banco")
    @ManyToOne(optional = false)
    private PguBancoPago pguBancoPago;
    @JoinColumn(name = "id_modltipo", referencedColumnName = "id_modltipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PguModalidadTipospagos pguModalidadTipospagos;
    @JoinColumn(name = "id_origenpag", referencedColumnName = "id_origenpag")
    @ManyToOne(optional = false)
    private PguOrigenPago pguOrigenPago;
    @JoinColumn(name = "id_numpago", referencedColumnName = "id_numpago", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PguPagospersCab pguPagospersCab;

    public PguPagospersDet() {
    }

    public PguPagospersDet(PguPagospersDetPK pguPagospersDetPK) {
        this.pguPagospersDetPK = pguPagospersDetPK;
    }

    public PguPagospersDet(PguPagospersDetPK pguPagospersDetPK, Date fechaOper, String nroOperacion, Float monto, Date horaPago) {
        this.pguPagospersDetPK = pguPagospersDetPK;
        this.fechaOper = fechaOper;
        this.nroOperacion = nroOperacion;
        this.monto = monto;
        this.horaPago = horaPago;
    }

    public PguPagospersDet(int idNumpago, int idModltipo, Date fechaPago, short nroCuota, short nroParte/*, boolean estado*/) {
        this.pguPagospersDetPK = new PguPagospersDetPK(idNumpago, idModltipo, fechaPago, nroCuota, nroParte/*, estado*/);
    }

    public PguPagospersDetPK getPguPagospersDetPK() {
        return pguPagospersDetPK;
    }

    public void setPguPagospersDetPK(PguPagospersDetPK pguPagospersDetPK) {
        this.pguPagospersDetPK = pguPagospersDetPK;
    }

    public Integer getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(Integer idEsc) {
        this.idEsc = idEsc;
    }

    public Short getIdMesd() {
        return idMesd;
    }

    public void setIdMesd(Short idMesd) {
        this.idMesd = idMesd;
    }

    public Date getFechaOper() {
        return fechaOper;
    }

    public void setFechaOper(Date fechaOper) {
        this.fechaOper = fechaOper;
    }

    public String getNroOperacion() {
        return nroOperacion;
    }

    public void setNroOperacion(String nroOperacion) {
        this.nroOperacion = nroOperacion;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public Date getHoraPago() {
        return horaPago;
    }

    public void setHoraPago(Date horaPago) {
        this.horaPago = horaPago;
    }

    public PguBancoPago getPguBancoPago() {
        return pguBancoPago;
    }

    public void setPguBancoPago(PguBancoPago pguBancoPago) {
        this.pguBancoPago = pguBancoPago;
    }

    public PguModalidadTipospagos getPguModalidadTipospagos() {
        return pguModalidadTipospagos;
    }

    public void setPguModalidadTipospagos(PguModalidadTipospagos pguModalidadTipospagos) {
        this.pguModalidadTipospagos = pguModalidadTipospagos;
    }

    public PguOrigenPago getPguOrigenPago() {
        return pguOrigenPago;
    }

    public void setPguOrigenPago(PguOrigenPago pguOrigenPago) {
        this.pguOrigenPago = pguOrigenPago;
    }

    public PguPagospersCab getPguPagospersCab() {
        return pguPagospersCab;
    }

    public void setPguPagospersCab(PguPagospersCab pguPagospersCab) {
        this.pguPagospersCab = pguPagospersCab;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pguPagospersDetPK != null ? pguPagospersDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PguPagospersDet)) {
            return false;
        }
        PguPagospersDet other = (PguPagospersDet) object;
        if ((this.pguPagospersDetPK == null && other.pguPagospersDetPK != null) || (this.pguPagospersDetPK != null && !this.pguPagospersDetPK.equals(other.pguPagospersDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PguPagospersDet[ pguPagospersDetPK=" + pguPagospersDetPK + " ]";
    }
    
}
