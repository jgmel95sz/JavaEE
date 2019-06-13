/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "cep_cec_matri_pago")
@NamedQueries({
    @NamedQuery(name = "CepCecMatriPago.findAll", query = "SELECT c FROM CepCecMatriPago c")
    , @NamedQuery(name = "CepCecMatriPago.findByIdMatriPago", query = "SELECT c FROM CepCecMatriPago c WHERE c.idMatriPago = :idMatriPago")
    , @NamedQuery(name = "CepCecMatriPago.findByEstadoMat", query = "SELECT c FROM CepCecMatriPago c WHERE c.estadoMat = :estadoMat")
    , @NamedQuery(name = "CepCecMatriPago.findByFechaRegMp", query = "SELECT c FROM CepCecMatriPago c WHERE c.fechaRegMp = :fechaRegMp")
    , @NamedQuery(name = "CepCecMatriPago.findByHoraRegMp", query = "SELECT c FROM CepCecMatriPago c WHERE c.horaRegMp = :horaRegMp")
    , @NamedQuery(name = "CepCecMatriPago.findByCondicionAlu", query = "SELECT c FROM CepCecMatriPago c WHERE c.condicionAlu = :condicionAlu")
    , @NamedQuery(name = "CepCecMatriPago.findByIsPagototal", query = "SELECT c FROM CepCecMatriPago c WHERE c.isPagototal = :isPagototal")
    , @NamedQuery(name = "CepCecMatriPago.findByIdVoucherFicticio", query = "SELECT c FROM CepCecMatriPago c WHERE c.idVoucherFicticio = :idVoucherFicticio")
    , @NamedQuery(name = "CepCecMatriPago.findByNumCuota", query = "SELECT c FROM CepCecMatriPago c WHERE c.numCuota = :numCuota")
    , @NamedQuery(name = "CepCecMatriPago.findByCodConcepto", query = "SELECT c FROM CepCecMatriPago c WHERE c.codConcepto = :codConcepto")})
public class CepCecMatriPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_matri_pago")
     @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idMatriPago;
    @Column(name = "estado_mat")
    private Short estadoMat;
    @Column(name = "fecha_reg_mp")
    @Temporal(TemporalType.DATE)
    private Date fechaRegMp;
    @Column(name = "hora_reg_mp")
    @Temporal(TemporalType.TIME)
    private Date horaRegMp;
    @Column(name = "condicion_alu")
    private Integer condicionAlu;
    @Column(name = "is_pagototal")
    private Boolean isPagototal;
    @Column(name = "id_voucher_ficticio")
    private Integer idVoucherFicticio;
    @Column(name = "num_cuota")
    private Integer numCuota;
    @Column(name = "cod_concepto")
    private Integer codConcepto;
    @JoinColumn(name = "id_matri_alu", referencedColumnName = "id_matri_alu")
    @ManyToOne(optional = false)
    private CepCecMatriAlu cepCecMatriAlu;
    @JoinColumn(name = "id_tipo_matri", referencedColumnName = "id_tipo_matri")
    @ManyToOne
    private CepCecTipoMatri cepCecTipoMatri;
    @JoinColumn(name = "id_numpago", referencedColumnName = "id_numpago")
    @ManyToOne
    private PguPagospersCab pguPagospersCab;

    public CepCecMatriPago() {
    }

    public CepCecMatriPago(Integer idMatriPago) {
        this.idMatriPago = idMatriPago;
    }

    public Integer getIdMatriPago() {
        return idMatriPago;
    }

    public void setIdMatriPago(Integer idMatriPago) {
        this.idMatriPago = idMatriPago;
    }

    public Short getEstadoMat() {
        return estadoMat;
    }

    public void setEstadoMat(Short estadoMat) {
        this.estadoMat = estadoMat;
    }

    public Date getFechaRegMp() {
        return fechaRegMp;
    }

    public void setFechaRegMp(Date fechaRegMp) {
        this.fechaRegMp = fechaRegMp;
    }

    public Date getHoraRegMp() {
        return horaRegMp;
    }

    public void setHoraRegMp(Date horaRegMp) {
        this.horaRegMp = horaRegMp;
    }

    public Integer getCondicionAlu() {
        return condicionAlu;
    }

    public void setCondicionAlu(Integer condicionAlu) {
        this.condicionAlu = condicionAlu;
    }

    public Boolean getIsPagototal() {
        return isPagototal;
    }

    public void setIsPagototal(Boolean isPagototal) {
        this.isPagototal = isPagototal;
    }

    public Integer getIdVoucherFicticio() {
        return idVoucherFicticio;
    }

    public void setIdVoucherFicticio(Integer idVoucherFicticio) {
        this.idVoucherFicticio = idVoucherFicticio;
    }

    public Integer getNumCuota() {
        return numCuota;
    }

    public void setNumCuota(Integer numCuota) {
        this.numCuota = numCuota;
    }

    public Integer getCodConcepto() {
        return codConcepto;
    }

    public void setCodConcepto(Integer codConcepto) {
        this.codConcepto = codConcepto;
    }

    public CepCecMatriAlu getCepCecMatriAlu() {
        return cepCecMatriAlu;
    }

    public void setCepCecMatriAlu(CepCecMatriAlu cepCecMatriAlu) {
        this.cepCecMatriAlu = cepCecMatriAlu;
    }

    public CepCecTipoMatri getCepCecTipoMatri() {
        return cepCecTipoMatri;
    }

    public void setCepCecTipoMatri(CepCecTipoMatri cepCecTipoMatri) {
        this.cepCecTipoMatri = cepCecTipoMatri;
    }

    public PguPagospersCab getPguPagospersCab() {
        return pguPagospersCab;
    }

    public void setPguPagospersCab(PguPagospersCab pguPagospersCab) {
        this.pguPagospersCab = pguPagospersCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatriPago != null ? idMatriPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecMatriPago)) {
            return false;
        }
        CepCecMatriPago other = (CepCecMatriPago) object;
        if ((this.idMatriPago == null && other.idMatriPago != null) || (this.idMatriPago != null && !this.idMatriPago.equals(other.idMatriPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecMatriPago[ idMatriPago=" + idMatriPago + " ]";
    }
    
}
