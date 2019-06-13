/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "cep_cec_certificado")
@NamedQueries({
    @NamedQuery(name = "CepCecCertificado.findAll", query = "SELECT c FROM CepCecCertificado c")
    , @NamedQuery(name = "CepCecCertificado.findByIdCertificado", query = "SELECT c FROM CepCecCertificado c WHERE c.idCertificado = :idCertificado")
    , @NamedQuery(name = "CepCecCertificado.findByCodDec", query = "SELECT c FROM CepCecCertificado c WHERE c.codDec = :codDec")
    , @NamedQuery(name = "CepCecCertificado.findByFechaEmision", query = "SELECT c FROM CepCecCertificado c WHERE c.fechaEmision = :fechaEmision")
    , @NamedQuery(name = "CepCecCertificado.findByEstadoCertif", query = "SELECT c FROM CepCecCertificado c WHERE c.estadoCertif = :estadoCertif")
    , @NamedQuery(name = "CepCecCertificado.findByNotaFinalCur", query = "SELECT c FROM CepCecCertificado c WHERE c.notaFinalCur = :notaFinalCur")})
public class CepCecCertificado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_certificado")
    private Integer idCertificado;
    @Size(max = 10)
    @Column(name = "cod_dec")
    private String codDec;
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "estado_certif")
    private Short estadoCertif;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota_final_cur")
    private BigDecimal notaFinalCur;
    @JoinColumn(name = "id_matri_alu", referencedColumnName = "id_matri_alu")
    @ManyToOne(optional = false)
    private CepCecMatriAlu cepCecMatriAlu;

    public CepCecCertificado() {
    }

    public CepCecCertificado(Integer idCertificado) {
        this.idCertificado = idCertificado;
    }

    public Integer getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(Integer idCertificado) {
        this.idCertificado = idCertificado;
    }

    public String getCodDec() {
        return codDec;
    }

    public void setCodDec(String codDec) {
        this.codDec = codDec;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Short getEstadoCertif() {
        return estadoCertif;
    }

    public void setEstadoCertif(Short estadoCertif) {
        this.estadoCertif = estadoCertif;
    }

    public BigDecimal getNotaFinalCur() {
        return notaFinalCur;
    }

    public void setNotaFinalCur(BigDecimal notaFinalCur) {
        this.notaFinalCur = notaFinalCur;
    }

    public CepCecMatriAlu getCepCecMatriAlu() {
        return cepCecMatriAlu;
    }

    public void setCepCecMatriAlu(CepCecMatriAlu cepCecMatriAlu) {
        this.cepCecMatriAlu = cepCecMatriAlu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCertificado != null ? idCertificado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecCertificado)) {
            return false;
        }
        CepCecCertificado other = (CepCecCertificado) object;
        if ((this.idCertificado == null && other.idCertificado != null) || (this.idCertificado != null && !this.idCertificado.equals(other.idCertificado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecCertificado[ idCertificado=" + idCertificado + " ]";
    }
    
}
