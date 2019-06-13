/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
//import java.math.Float;
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
@Table(name = "pgu_modalidad")
@NamedQueries({
    @NamedQuery(name = "PguModalidad.findAll", query = "SELECT p FROM PguModalidad p")
    , @NamedQuery(name = "PguModalidad.findByIdModld", query = "SELECT p FROM PguModalidad p WHERE p.idModld = :idModld")
    , @NamedQuery(name = "PguModalidad.findByIdUnidad", query = "SELECT p FROM PguModalidad p WHERE p.idUnidad = :idUnidad")
    , @NamedQuery(name = "PguModalidad.findByNombre", query = "SELECT p FROM PguModalidad p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PguModalidad.findByNroUnid", query = "SELECT p FROM PguModalidad p WHERE p.nroUnid = :nroUnid")
    , @NamedQuery(name = "PguModalidad.findByActivo", query = "SELECT p FROM PguModalidad p WHERE p.activo = :activo")})
public class PguModalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_modld")
    private Integer idModld;
    @Column(name = "id_unidad")
    private Short idUnidad;
    @Size(max = 70)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nro_unid")
    private Float nroUnid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(mappedBy = "pguModalidad")
    private List<PguModalidadTipospagos> pguModalidadTipospagosList;

    public PguModalidad() {
    }

    public PguModalidad(Integer idModld) {
        this.idModld = idModld;
    }

    public PguModalidad(Integer idModld, boolean activo) {
        this.idModld = idModld;
        this.activo = activo;
    }

    public Integer getIdModld() {
        return idModld;
    }

    public void setIdModld(Integer idModld) {
        this.idModld = idModld;
    }

    public Short getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Short idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getNroUnid() {
        return nroUnid;
    }

    public void setNroUnid(Float nroUnid) {
        this.nroUnid = nroUnid;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<PguModalidadTipospagos> getPguModalidadTipospagosList() {
        return pguModalidadTipospagosList;
    }

    public void setPguModalidadTipospagosList(List<PguModalidadTipospagos> pguModalidadTipospagosList) {
        this.pguModalidadTipospagosList = pguModalidadTipospagosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModld != null ? idModld.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PguModalidad)) {
            return false;
        }
        PguModalidad other = (PguModalidad) object;
        if ((this.idModld == null && other.idModld != null) || (this.idModld != null && !this.idModld.equals(other.idModld))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PguModalidad[ idModld=" + idModld + " ]";
    }
    
}
