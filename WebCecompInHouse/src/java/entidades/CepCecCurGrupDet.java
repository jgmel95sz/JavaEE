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
@Table(name = "cep_cec_cur_grup_det")
@NamedQueries({
    @NamedQuery(name = "CepCecCurGrupDet.findAll", query = "SELECT c FROM CepCecCurGrupDet c")
    , @NamedQuery(name = "CepCecCurGrupDet.findByIdCurGrupDet", query = "SELECT c FROM CepCecCurGrupDet c WHERE c.idCurGrupDet = :idCurGrupDet")
    , @NamedQuery(name = "CepCecCurGrupDet.findByEstadoCurGrupDet", query = "SELECT c FROM CepCecCurGrupDet c WHERE c.estadoCurGrupDet = :estadoCurGrupDet")
    , @NamedQuery(name = "CepCecCurGrupDet.findByFechaI", query = "SELECT c FROM CepCecCurGrupDet c WHERE c.fechaI = :fechaI")
    , @NamedQuery(name = "CepCecCurGrupDet.findByFechaF", query = "SELECT c FROM CepCecCurGrupDet c WHERE c.fechaF = :fechaF")
    , @NamedQuery(name = "CepCecCurGrupDet.findByIdDir", query = "SELECT c FROM CepCecCurGrupDet c WHERE c.idDir = :idDir")})
public class CepCecCurGrupDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cur_grup_det")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idCurGrupDet;
    @Column(name = "estado_cur_grup_det")
    private Short estadoCurGrupDet;
    @Column(name = "fecha_i")
    @Temporal(TemporalType.DATE)
    private Date fechaI;
    @Column(name = "fecha_f")
    @Temporal(TemporalType.DATE)
    private Date fechaF;
    @Column(name = "id_dir")
    private Integer idDir;
    @JoinColumn(name = "id_aul_class", referencedColumnName = "id_aul_class")
    @ManyToOne
    private CepAulaClass cepAulaClass;
    @JoinColumn(name = "id_cur_grup", referencedColumnName = "id_cur_grup")
    @ManyToOne
    private CepCecCurGrup cepCecCurGrup;

    public CepCecCurGrupDet() {
    }

    public CepCecCurGrupDet(Integer idCurGrupDet) {
        this.idCurGrupDet = idCurGrupDet;
    }

    public Integer getIdCurGrupDet() {
        return idCurGrupDet;
    }

    public void setIdCurGrupDet(Integer idCurGrupDet) {
        this.idCurGrupDet = idCurGrupDet;
    }

    public Short getEstadoCurGrupDet() {
        return estadoCurGrupDet;
    }

    public void setEstadoCurGrupDet(Short estadoCurGrupDet) {
        this.estadoCurGrupDet = estadoCurGrupDet;
    }

    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }

    public Date getFechaF() {
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public CepAulaClass getCepAulaClass() {
        return cepAulaClass;
    }

    public void setCepAulaClass(CepAulaClass cepAulaClass) {
        this.cepAulaClass = cepAulaClass;
    }

    public CepCecCurGrup getCepCecCurGrup() {
        return cepCecCurGrup;
    }

    public void setCepCecCurGrup(CepCecCurGrup cepCecCurGrup) {
        this.cepCecCurGrup = cepCecCurGrup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurGrupDet != null ? idCurGrupDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecCurGrupDet)) {
            return false;
        }
        CepCecCurGrupDet other = (CepCecCurGrupDet) object;
        if ((this.idCurGrupDet == null && other.idCurGrupDet != null) || (this.idCurGrupDet != null && !this.idCurGrupDet.equals(other.idCurGrupDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecCurGrupDet[ idCurGrupDet=" + idCurGrupDet + " ]";
    }
    
}
