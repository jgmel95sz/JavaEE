/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "cep_cec_tipo_matri")
@NamedQueries({
    @NamedQuery(name = "CepCecTipoMatri.findAll", query = "SELECT c FROM CepCecTipoMatri c")
    , @NamedQuery(name = "CepCecTipoMatri.findByIdTipoMatri", query = "SELECT c FROM CepCecTipoMatri c WHERE c.idTipoMatri = :idTipoMatri")
    , @NamedQuery(name = "CepCecTipoMatri.findByNomTipoMatri", query = "SELECT c FROM CepCecTipoMatri c WHERE c.nomTipoMatri = :nomTipoMatri")
    , @NamedQuery(name = "CepCecTipoMatri.findByEstadoTipoMatri", query = "SELECT c FROM CepCecTipoMatri c WHERE c.estadoTipoMatri = :estadoTipoMatri")})
public class CepCecTipoMatri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_matri")
    private Integer idTipoMatri;
    @Size(max = 20)
    @Column(name = "nom_tipo_matri")
    private String nomTipoMatri;
    @Column(name = "estado_tipo_matri")
    private Short estadoTipoMatri;
    @OneToMany(mappedBy = "cepCecTipoMatri")
    private List<CepCecMatriPago> cepCecMatriPagoList;

    public CepCecTipoMatri() {
    }

    public CepCecTipoMatri(Integer idTipoMatri) {
        this.idTipoMatri = idTipoMatri;
    }

    public Integer getIdTipoMatri() {
        return idTipoMatri;
    }

    public void setIdTipoMatri(Integer idTipoMatri) {
        this.idTipoMatri = idTipoMatri;
    }

    public String getNomTipoMatri() {
        return nomTipoMatri;
    }

    public void setNomTipoMatri(String nomTipoMatri) {
        this.nomTipoMatri = nomTipoMatri;
    }

    public Short getEstadoTipoMatri() {
        return estadoTipoMatri;
    }

    public void setEstadoTipoMatri(Short estadoTipoMatri) {
        this.estadoTipoMatri = estadoTipoMatri;
    }

    public List<CepCecMatriPago> getCepCecMatriPagoList() {
        return cepCecMatriPagoList;
    }

    public void setCepCecMatriPagoList(List<CepCecMatriPago> cepCecMatriPagoList) {
        this.cepCecMatriPagoList = cepCecMatriPagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMatri != null ? idTipoMatri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecTipoMatri)) {
            return false;
        }
        CepCecTipoMatri other = (CepCecTipoMatri) object;
        if ((this.idTipoMatri == null && other.idTipoMatri != null) || (this.idTipoMatri != null && !this.idTipoMatri.equals(other.idTipoMatri))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecTipoMatri[ idTipoMatri=" + idTipoMatri + " ]";
    }
    
}
