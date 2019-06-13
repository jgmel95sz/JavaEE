/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "cep_cec_tipo_inversion")
@NamedQueries({
    @NamedQuery(name = "CepCecTipoInversion.findAll", query = "SELECT c FROM CepCecTipoInversion c")
    , @NamedQuery(name = "CepCecTipoInversion.findByIdTipoinversion", query = "SELECT c FROM CepCecTipoInversion c WHERE c.idTipoinversion = :idTipoinversion")
    , @NamedQuery(name = "CepCecTipoInversion.findByNomTipoinversion", query = "SELECT c FROM CepCecTipoInversion c WHERE c.nomTipoinversion = :nomTipoinversion")
    , @NamedQuery(name = "CepCecTipoInversion.findByDescripcionTipoinversion", query = "SELECT c FROM CepCecTipoInversion c WHERE c.descripcionTipoinversion = :descripcionTipoinversion")
    , @NamedQuery(name = "CepCecTipoInversion.findByEstadoTipoinversion", query = "SELECT c FROM CepCecTipoInversion c WHERE c.estadoTipoinversion = :estadoTipoinversion")})
public class CepCecTipoInversion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipoinversion")
    private Integer idTipoinversion;
    @Size(max = 100)
    @Column(name = "nom_tipoinversion")
    private String nomTipoinversion;
    @Size(max = 100)
    @Column(name = "descripcion_tipoinversion")
    private String descripcionTipoinversion;
    @Column(name = "estado_tipoinversion")
    private Short estadoTipoinversion;
    @OneToMany( mappedBy = "cepCecTipoInversion")
    private List<CepCecInversionCurso> cepCecInversionCursoList;

    public CepCecTipoInversion() {
    }

    public CepCecTipoInversion(Integer idTipoinversion) {
        this.idTipoinversion = idTipoinversion;
    }

    public Integer getIdTipoinversion() {
        return idTipoinversion;
    }

    public void setIdTipoinversion(Integer idTipoinversion) {
        this.idTipoinversion = idTipoinversion;
    }

    public String getNomTipoinversion() {
        return nomTipoinversion;
    }

    public void setNomTipoinversion(String nomTipoinversion) {
        this.nomTipoinversion = nomTipoinversion;
    }

    public String getDescripcionTipoinversion() {
        return descripcionTipoinversion;
    }

    public void setDescripcionTipoinversion(String descripcionTipoinversion) {
        this.descripcionTipoinversion = descripcionTipoinversion;
    }

    public Short getEstadoTipoinversion() {
        return estadoTipoinversion;
    }

    public void setEstadoTipoinversion(Short estadoTipoinversion) {
        this.estadoTipoinversion = estadoTipoinversion;
    }

    public List<CepCecInversionCurso> getCepCecInversionCursoList() {
        return cepCecInversionCursoList;
    }

    public void setCepCecInversionCursoList(List<CepCecInversionCurso> cepCecInversionCursoList) {
        this.cepCecInversionCursoList = cepCecInversionCursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoinversion != null ? idTipoinversion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecTipoInversion)) {
            return false;
        }
        CepCecTipoInversion other = (CepCecTipoInversion) object;
        if ((this.idTipoinversion == null && other.idTipoinversion != null) || (this.idTipoinversion != null && !this.idTipoinversion.equals(other.idTipoinversion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecTipoInversion[ idTipoinversion=" + idTipoinversion + " ]";
    }
    
}
