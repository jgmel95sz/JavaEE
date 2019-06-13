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
@Table(name = "pgu_origen_pago")
@NamedQueries({
    @NamedQuery(name = "PguOrigenPago.findAll", query = "SELECT p FROM PguOrigenPago p")
    , @NamedQuery(name = "PguOrigenPago.findByIdOrigenpag", query = "SELECT p FROM PguOrigenPago p WHERE p.idOrigenpag = :idOrigenpag")
    , @NamedQuery(name = "PguOrigenPago.findByNombre", query = "SELECT p FROM PguOrigenPago p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PguOrigenPago.findByActivo", query = "SELECT p FROM PguOrigenPago p WHERE p.activo = :activo")})
public class PguOrigenPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_origenpag")
    private Integer idOrigenpag;
    @Size(max = 25)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @OneToMany( mappedBy = "pguOrigenPago")
    private List<PguPagospersDet> pguPagospersDetList;

    public PguOrigenPago() {
    }

    public PguOrigenPago(Integer idOrigenpag) {
        this.idOrigenpag = idOrigenpag;
    }

    public PguOrigenPago(Integer idOrigenpag, boolean activo) {
        this.idOrigenpag = idOrigenpag;
        this.activo = activo;
    }

    public Integer getIdOrigenpag() {
        return idOrigenpag;
    }

    public void setIdOrigenpag(Integer idOrigenpag) {
        this.idOrigenpag = idOrigenpag;
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

    public List<PguPagospersDet> getPguPagospersDetList() {
        return pguPagospersDetList;
    }

    public void setPguPagospersDetList(List<PguPagospersDet> pguPagospersDetList) {
        this.pguPagospersDetList = pguPagospersDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrigenpag != null ? idOrigenpag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PguOrigenPago)) {
            return false;
        }
        PguOrigenPago other = (PguOrigenPago) object;
        if ((this.idOrigenpag == null && other.idOrigenpag != null) || (this.idOrigenpag != null && !this.idOrigenpag.equals(other.idOrigenpag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PguOrigenPago[ idOrigenpag=" + idOrigenpag + " ]";
    }
    
}
