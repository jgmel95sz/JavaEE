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
@Table(name = "cep_tipo_modalidad")
@NamedQueries({
    @NamedQuery(name = "CepTipoModalidad.findAll", query = "SELECT c FROM CepTipoModalidad c")
    , @NamedQuery(name = "CepTipoModalidad.findByIdModalidad", query = "SELECT c FROM CepTipoModalidad c WHERE c.idModalidad = :idModalidad")
    , @NamedQuery(name = "CepTipoModalidad.findByNomModalidad", query = "SELECT c FROM CepTipoModalidad c WHERE c.nomModalidad = :nomModalidad")
    , @NamedQuery(name = "CepTipoModalidad.findByEstadoModalidad", query = "SELECT c FROM CepTipoModalidad c WHERE c.estadoModalidad = :estadoModalidad")
    , @NamedQuery(name = "CepTipoModalidad.findByNumCepModalidad", query = "SELECT c FROM CepTipoModalidad c WHERE c.numCepModalidad = :numCepModalidad")})
public class CepTipoModalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_modalidad")
    private Integer idModalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom_modalidad")
    private String nomModalidad;
    @Column(name = "estado_modalidad")
    private Short estadoModalidad;
    @Column(name = "num_cep_modalidad")
    private Integer numCepModalidad;
    @OneToMany(mappedBy = "cepTipoModalidad")
    private List<CepEscalaTipomod> cepEscalaTipomodList;

    public CepTipoModalidad() {
    }

    public CepTipoModalidad(Integer idModalidad) {
        this.idModalidad = idModalidad;
    }

    public CepTipoModalidad(Integer idModalidad, String nomModalidad) {
        this.idModalidad = idModalidad;
        this.nomModalidad = nomModalidad;
    }

    public Integer getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Integer idModalidad) {
        this.idModalidad = idModalidad;
    }

    public String getNomModalidad() {
        return nomModalidad;
    }

    public void setNomModalidad(String nomModalidad) {
        this.nomModalidad = nomModalidad;
    }

    public Short getEstadoModalidad() {
        return estadoModalidad;
    }

    public void setEstadoModalidad(Short estadoModalidad) {
        this.estadoModalidad = estadoModalidad;
    }

    public Integer getNumCepModalidad() {
        return numCepModalidad;
    }

    public void setNumCepModalidad(Integer numCepModalidad) {
        this.numCepModalidad = numCepModalidad;
    }

    public List<CepEscalaTipomod> getCepEscalaTipomodList() {
        return cepEscalaTipomodList;
    }

    public void setCepEscalaTipomodList(List<CepEscalaTipomod> cepEscalaTipomodList) {
        this.cepEscalaTipomodList = cepEscalaTipomodList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModalidad != null ? idModalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepTipoModalidad)) {
            return false;
        }
        CepTipoModalidad other = (CepTipoModalidad) object;
        if ((this.idModalidad == null && other.idModalidad != null) || (this.idModalidad != null && !this.idModalidad.equals(other.idModalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepTipoModalidad[ idModalidad=" + idModalidad + " ]";
    }
    
}
