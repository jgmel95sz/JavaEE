/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "drt_docidentidad")
@NamedQueries({
    @NamedQuery(name = "DrtDocidentidad.findAll", query = "SELECT d FROM DrtDocidentidad d")
    , @NamedQuery(name = "DrtDocidentidad.findByIdPdid", query = "SELECT d FROM DrtDocidentidad d WHERE d.idPdid = :idPdid")
    , @NamedQuery(name = "DrtDocidentidad.findByNombre", query = "SELECT d FROM DrtDocidentidad d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DrtDocidentidad.findByAbreviaturaTpdid", query = "SELECT d FROM DrtDocidentidad d WHERE d.abreviaturaTpdid = :abreviaturaTpdid")
    , @NamedQuery(name = "DrtDocidentidad.findByDescripcionTpdid", query = "SELECT d FROM DrtDocidentidad d WHERE d.descripcionTpdid = :descripcionTpdid")
    , @NamedQuery(name = "DrtDocidentidad.findByVigenciaTpdid", query = "SELECT d FROM DrtDocidentidad d WHERE d.vigenciaTpdid = :vigenciaTpdid")})
public class DrtDocidentidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pdid")
    private Short idPdid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "abreviatura_tpdid")
    private String abreviaturaTpdid;
    @Size(max = 200)
    @Column(name = "descripcion_tpdid")
    private String descripcionTpdid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vigencia_tpdid")
    private Character vigenciaTpdid;

    public DrtDocidentidad() {
    }

    public DrtDocidentidad(Short idPdid) {
        this.idPdid = idPdid;
    }

    public DrtDocidentidad(Short idPdid, String nombre, String abreviaturaTpdid, Character vigenciaTpdid) {
        this.idPdid = idPdid;
        this.nombre = nombre;
        this.abreviaturaTpdid = abreviaturaTpdid;
        this.vigenciaTpdid = vigenciaTpdid;
    }

    public Short getIdPdid() {
        return idPdid;
    }

    public void setIdPdid(Short idPdid) {
        this.idPdid = idPdid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviaturaTpdid() {
        return abreviaturaTpdid;
    }

    public void setAbreviaturaTpdid(String abreviaturaTpdid) {
        this.abreviaturaTpdid = abreviaturaTpdid;
    }

    public String getDescripcionTpdid() {
        return descripcionTpdid;
    }

    public void setDescripcionTpdid(String descripcionTpdid) {
        this.descripcionTpdid = descripcionTpdid;
    }

    public Character getVigenciaTpdid() {
        return vigenciaTpdid;
    }

    public void setVigenciaTpdid(Character vigenciaTpdid) {
        this.vigenciaTpdid = vigenciaTpdid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPdid != null ? idPdid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrtDocidentidad)) {
            return false;
        }
        DrtDocidentidad other = (DrtDocidentidad) object;
        if ((this.idPdid == null && other.idPdid != null) || (this.idPdid != null && !this.idPdid.equals(other.idPdid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DrtDocidentidad[ idPdid=" + idPdid + " ]";
    }
    
}
