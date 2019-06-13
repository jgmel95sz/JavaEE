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
@Table(name = "pgu_grupo_tipospagos")
@NamedQueries({
    @NamedQuery(name = "PguGrupoTipospagos.findAll", query = "SELECT p FROM PguGrupoTipospagos p")
    , @NamedQuery(name = "PguGrupoTipospagos.findByIdGrupopag", query = "SELECT p FROM PguGrupoTipospagos p WHERE p.idGrupopag = :idGrupopag")
    , @NamedQuery(name = "PguGrupoTipospagos.findByNombre", query = "SELECT p FROM PguGrupoTipospagos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PguGrupoTipospagos.findByActivo", query = "SELECT p FROM PguGrupoTipospagos p WHERE p.activo = :activo")})
public class PguGrupoTipospagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_grupopag")
    private Integer idGrupopag;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(mappedBy = "pguGrupoTipospagos")
    private List<PguTipoPagos> pguTipoPagosList;

    public PguGrupoTipospagos() {
    }

    public PguGrupoTipospagos(Integer idGrupopag) {
        this.idGrupopag = idGrupopag;
    }

    public PguGrupoTipospagos(Integer idGrupopag, boolean activo) {
        this.idGrupopag = idGrupopag;
        this.activo = activo;
    }

    public Integer getIdGrupopag() {
        return idGrupopag;
    }

    public void setIdGrupopag(Integer idGrupopag) {
        this.idGrupopag = idGrupopag;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<PguTipoPagos> getPguTipoPagosList() {
        return pguTipoPagosList;
    }

    public void setPguTipoPagosList(List<PguTipoPagos> pguTipoPagosList) {
        this.pguTipoPagosList = pguTipoPagosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupopag != null ? idGrupopag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PguGrupoTipospagos)) {
            return false;
        }
        PguGrupoTipospagos other = (PguGrupoTipospagos) object;
        if ((this.idGrupopag == null && other.idGrupopag != null) || (this.idGrupopag != null && !this.idGrupopag.equals(other.idGrupopag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PguGrupoTipospagos[ idGrupopag=" + idGrupopag + " ]";
    }
    
}
