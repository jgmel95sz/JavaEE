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
import javax.validation.constraints.Size;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "cep_cec_cronograma_det")
@NamedQueries({
    @NamedQuery(name = "CepCecCronogramaDet.findAll", query = "SELECT c FROM CepCecCronogramaDet c")
    , @NamedQuery(name = "CepCecCronogramaDet.findByIdCronogramaDet", query = "SELECT c FROM CepCecCronogramaDet c WHERE c.idCronogramaDet = :idCronogramaDet")
    , @NamedQuery(name = "CepCecCronogramaDet.findByEstadoCroDet", query = "SELECT c FROM CepCecCronogramaDet c WHERE c.estadoCroDet = :estadoCroDet")
    , @NamedQuery(name = "CepCecCronogramaDet.findByFechaRegCro", query = "SELECT c FROM CepCecCronogramaDet c WHERE c.fechaRegCro = :fechaRegCro")
    , @NamedQuery(name = "CepCecCronogramaDet.findByFechaIniCro", query = "SELECT c FROM CepCecCronogramaDet c WHERE c.fechaIniCro = :fechaIniCro")
    , @NamedQuery(name = "CepCecCronogramaDet.findByFechaFinCro", query = "SELECT c FROM CepCecCronogramaDet c WHERE c.fechaFinCro = :fechaFinCro")
    , @NamedQuery(name = "CepCecCronogramaDet.findByTipoCronograma", query = "SELECT c FROM CepCecCronogramaDet c WHERE c.tipoCronograma = :tipoCronograma")
    , @NamedQuery(name = "CepCecCronogramaDet.findByHoraIniCro", query = "SELECT c FROM CepCecCronogramaDet c WHERE c.horaIniCro = :horaIniCro")
    , @NamedQuery(name = "CepCecCronogramaDet.findByHoraFinCro", query = "SELECT c FROM CepCecCronogramaDet c WHERE c.horaFinCro = :horaFinCro")
    , @NamedQuery(name = "CepCecCronogramaDet.findByFechaModCro", query = "SELECT c FROM CepCecCronogramaDet c WHERE c.fechaModCro = :fechaModCro")
    , @NamedQuery(name = "CepCecCronogramaDet.findByDescripcionCro", query = "SELECT c FROM CepCecCronogramaDet c WHERE c.descripcionCro = :descripcionCro")})
public class CepCecCronogramaDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cronograma_det")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idCronogramaDet;
    @Column(name = "estado_cro_det")
    private Short estadoCroDet;
    @Column(name = "fecha_reg_cro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegCro;
    @Column(name = "fecha_ini_cro")
    @Temporal(TemporalType.DATE)
    private Date fechaIniCro;
    @Column(name = "fecha_fin_cro")
    @Temporal(TemporalType.DATE)
    private Date fechaFinCro;
    @Column(name = "tipo_cronograma")
    private Integer tipoCronograma;
    @Column(name = "hora_ini_cro")
    @Temporal(TemporalType.TIME)
    private Date horaIniCro;
    @Column(name = "hora_fin_cro")
    @Temporal(TemporalType.TIME)
    private Date horaFinCro;
    @Column(name = "fecha_mod_cro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModCro;
    @Size(max = 100)
    @Column(name = "descripcion_cro")
    private String descripcionCro;
    @JoinColumn(name = "id_cronograma_cab", referencedColumnName = "id_cronograma_cab")
    @ManyToOne
    private CepCecCronogramaCab cepCecCronogramaCab;

    public CepCecCronogramaDet() {
    }

    public CepCecCronogramaDet(Integer idCronogramaDet) {
        this.idCronogramaDet = idCronogramaDet;
    }

    public Integer getIdCronogramaDet() {
        return idCronogramaDet;
    }

    public void setIdCronogramaDet(Integer idCronogramaDet) {
        this.idCronogramaDet = idCronogramaDet;
    }

    public Short getEstadoCroDet() {
        return estadoCroDet;
    }

    public void setEstadoCroDet(Short estadoCroDet) {
        this.estadoCroDet = estadoCroDet;
    }

    public Date getFechaRegCro() {
        return fechaRegCro;
    }

    public void setFechaRegCro(Date fechaRegCro) {
        this.fechaRegCro = fechaRegCro;
    }

    public Date getFechaIniCro() {
        return fechaIniCro;
    }

    public void setFechaIniCro(Date fechaIniCro) {
        this.fechaIniCro = fechaIniCro;
    }

    public Date getFechaFinCro() {
        return fechaFinCro;
    }

    public void setFechaFinCro(Date fechaFinCro) {
        this.fechaFinCro = fechaFinCro;
    }

    public Integer getTipoCronograma() {
        return tipoCronograma;
    }

    public void setTipoCronograma(Integer tipoCronograma) {
        this.tipoCronograma = tipoCronograma;
    }

    public Date getHoraIniCro() {
        return horaIniCro;
    }

    public void setHoraIniCro(Date horaIniCro) {
        this.horaIniCro = horaIniCro;
    }

    public Date getHoraFinCro() {
        return horaFinCro;
    }

    public void setHoraFinCro(Date horaFinCro) {
        this.horaFinCro = horaFinCro;
    }

    public Date getFechaModCro() {
        return fechaModCro;
    }

    public void setFechaModCro(Date fechaModCro) {
        this.fechaModCro = fechaModCro;
    }

    public String getDescripcionCro() {
        return descripcionCro;
    }

    public void setDescripcionCro(String descripcionCro) {
        this.descripcionCro = descripcionCro;
    }

    public CepCecCronogramaCab getCepCecCronogramaCab() {
        return cepCecCronogramaCab;
    }

    public void setCepCecCronogramaCab(CepCecCronogramaCab cepCecCronogramaCab) {
        this.cepCecCronogramaCab = cepCecCronogramaCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCronogramaDet != null ? idCronogramaDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecCronogramaDet)) {
            return false;
        }
        CepCecCronogramaDet other = (CepCecCronogramaDet) object;
        if ((this.idCronogramaDet == null && other.idCronogramaDet != null) || (this.idCronogramaDet != null && !this.idCronogramaDet.equals(other.idCronogramaDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecCronogramaDet[ idCronogramaDet=" + idCronogramaDet + " ]";
    }
    
}
