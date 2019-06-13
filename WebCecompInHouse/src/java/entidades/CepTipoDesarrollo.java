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
@Table(name = "cep_tipo_desarrollo")
@NamedQueries({
    @NamedQuery(name = "CepTipoDesarrollo.findAll", query = "SELECT c FROM CepTipoDesarrollo c")
    , @NamedQuery(name = "CepTipoDesarrollo.findByIdTipoDes", query = "SELECT c FROM CepTipoDesarrollo c WHERE c.idTipoDes = :idTipoDes")
    , @NamedQuery(name = "CepTipoDesarrollo.findByNomTipoDes", query = "SELECT c FROM CepTipoDesarrollo c WHERE c.nomTipoDes = :nomTipoDes")
    , @NamedQuery(name = "CepTipoDesarrollo.findByEstadoTipoDes", query = "SELECT c FROM CepTipoDesarrollo c WHERE c.estadoTipoDes = :estadoTipoDes")
    , @NamedQuery(name = "CepTipoDesarrollo.findByNumCepTipoDes", query = "SELECT c FROM CepTipoDesarrollo c WHERE c.numCepTipoDes = :numCepTipoDes")})
public class CepTipoDesarrollo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_des")
    private Integer idTipoDes;
    @Size(max = 20)
    @Column(name = "nom_tipo_des")
    private String nomTipoDes;
    @Column(name = "estado_tipo_des")
    private Short estadoTipoDes;
    @Column(name = "num_cep_tipo_des")
    private Integer numCepTipoDes;
    @OneToMany( mappedBy = "cepTipoDesarrollo")
    private List<CepCecCursoSubdet> cepCecCursoSubdetList;

    public CepTipoDesarrollo() {
    }

    public CepTipoDesarrollo(Integer idTipoDes) {
        this.idTipoDes = idTipoDes;
    }

    public Integer getIdTipoDes() {
        return idTipoDes;
    }

    public void setIdTipoDes(Integer idTipoDes) {
        this.idTipoDes = idTipoDes;
    }

    public String getNomTipoDes() {
        return nomTipoDes;
    }

    public void setNomTipoDes(String nomTipoDes) {
        this.nomTipoDes = nomTipoDes;
    }

    public Short getEstadoTipoDes() {
        return estadoTipoDes;
    }

    public void setEstadoTipoDes(Short estadoTipoDes) {
        this.estadoTipoDes = estadoTipoDes;
    }

    public Integer getNumCepTipoDes() {
        return numCepTipoDes;
    }

    public void setNumCepTipoDes(Integer numCepTipoDes) {
        this.numCepTipoDes = numCepTipoDes;
    }

    public List<CepCecCursoSubdet> getCepCecCursoSubdetList() {
        return cepCecCursoSubdetList;
    }

    public void setCepCecCursoSubdetList(List<CepCecCursoSubdet> cepCecCursoSubdetList) {
        this.cepCecCursoSubdetList = cepCecCursoSubdetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDes != null ? idTipoDes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepTipoDesarrollo)) {
            return false;
        }
        CepTipoDesarrollo other = (CepTipoDesarrollo) object;
        if ((this.idTipoDes == null && other.idTipoDes != null) || (this.idTipoDes != null && !this.idTipoDes.equals(other.idTipoDes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepTipoDesarrollo[ idTipoDes=" + idTipoDes + " ]";
    }
    
}
