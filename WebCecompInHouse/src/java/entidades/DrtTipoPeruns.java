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
@Table(name = "drt_tipo_peruns")
@NamedQueries({
    @NamedQuery(name = "DrtTipoPeruns.findAll", query = "SELECT d FROM DrtTipoPeruns d")
    , @NamedQuery(name = "DrtTipoPeruns.findByIdTipoPeruns", query = "SELECT d FROM DrtTipoPeruns d WHERE d.idTipoPeruns = :idTipoPeruns")
    , @NamedQuery(name = "DrtTipoPeruns.findByNombreTipoPeruns", query = "SELECT d FROM DrtTipoPeruns d WHERE d.nombreTipoPeruns = :nombreTipoPeruns")
    , @NamedQuery(name = "DrtTipoPeruns.findByAbreviaturaTipoPeruns", query = "SELECT d FROM DrtTipoPeruns d WHERE d.abreviaturaTipoPeruns = :abreviaturaTipoPeruns")
    , @NamedQuery(name = "DrtTipoPeruns.findByDescripcionTipoPeruns", query = "SELECT d FROM DrtTipoPeruns d WHERE d.descripcionTipoPeruns = :descripcionTipoPeruns")
    , @NamedQuery(name = "DrtTipoPeruns.findByVigenciaTipoPeruns", query = "SELECT d FROM DrtTipoPeruns d WHERE d.vigenciaTipoPeruns = :vigenciaTipoPeruns")})
public class DrtTipoPeruns implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_peruns")
    private Integer idTipoPeruns;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_tipo_peruns")
    private String nombreTipoPeruns;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "abreviatura_tipo_peruns")
    private String abreviaturaTipoPeruns;
    @Size(max = 200)
    @Column(name = "descripcion_tipo_peruns")
    private String descripcionTipoPeruns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vigencia_tipo_peruns")
    private Character vigenciaTipoPeruns;
    @OneToMany(mappedBy = "drtTipoPeruns")
    private List<DrtPernatUns> drtPernatUnsList;

    public DrtTipoPeruns() {
    }

    public DrtTipoPeruns(Integer idTipoPeruns) {
        this.idTipoPeruns = idTipoPeruns;
    }

    public DrtTipoPeruns(Integer idTipoPeruns, String nombreTipoPeruns, String abreviaturaTipoPeruns, Character vigenciaTipoPeruns) {
        this.idTipoPeruns = idTipoPeruns;
        this.nombreTipoPeruns = nombreTipoPeruns;
        this.abreviaturaTipoPeruns = abreviaturaTipoPeruns;
        this.vigenciaTipoPeruns = vigenciaTipoPeruns;
    }

    public Integer getIdTipoPeruns() {
        return idTipoPeruns;
    }

    public void setIdTipoPeruns(Integer idTipoPeruns) {
        this.idTipoPeruns = idTipoPeruns;
    }

    public String getNombreTipoPeruns() {
        return nombreTipoPeruns;
    }

    public void setNombreTipoPeruns(String nombreTipoPeruns) {
        this.nombreTipoPeruns = nombreTipoPeruns;
    }

    public String getAbreviaturaTipoPeruns() {
        return abreviaturaTipoPeruns;
    }

    public void setAbreviaturaTipoPeruns(String abreviaturaTipoPeruns) {
        this.abreviaturaTipoPeruns = abreviaturaTipoPeruns;
    }

    public String getDescripcionTipoPeruns() {
        return descripcionTipoPeruns;
    }

    public void setDescripcionTipoPeruns(String descripcionTipoPeruns) {
        this.descripcionTipoPeruns = descripcionTipoPeruns;
    }

    public Character getVigenciaTipoPeruns() {
        return vigenciaTipoPeruns;
    }

    public void setVigenciaTipoPeruns(Character vigenciaTipoPeruns) {
        this.vigenciaTipoPeruns = vigenciaTipoPeruns;
    }

    public List<DrtPernatUns> getDrtPernatUnsList() {
        return drtPernatUnsList;
    }

    public void setDrtPernatUnsList(List<DrtPernatUns> drtPernatUnsList) {
        this.drtPernatUnsList = drtPernatUnsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPeruns != null ? idTipoPeruns.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrtTipoPeruns)) {
            return false;
        }
        DrtTipoPeruns other = (DrtTipoPeruns) object;
        if ((this.idTipoPeruns == null && other.idTipoPeruns != null) || (this.idTipoPeruns != null && !this.idTipoPeruns.equals(other.idTipoPeruns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DrtTipoPeruns[ idTipoPeruns=" + idTipoPeruns + " ]";
    }
    
}
