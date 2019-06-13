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
@Table(name = "pgu_banco_pago")
@NamedQueries({
    @NamedQuery(name = "PguBancoPago.findAll", query = "SELECT p FROM PguBancoPago p")
    , @NamedQuery(name = "PguBancoPago.findByIdBanco", query = "SELECT p FROM PguBancoPago p WHERE p.idBanco = :idBanco")
    , @NamedQuery(name = "PguBancoPago.findByNombre", query = "SELECT p FROM PguBancoPago p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PguBancoPago.findByAbrev", query = "SELECT p FROM PguBancoPago p WHERE p.abrev = :abrev")
    , @NamedQuery(name = "PguBancoPago.findByActivo", query = "SELECT p FROM PguBancoPago p WHERE p.activo = :activo")})
public class PguBancoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_banco")
    private Integer idBanco;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 6)
    @Column(name = "abrev")
    private String abrev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(mappedBy = "pguBancoPago")
    private List<PguPagospersDet> pguPagospersDetList;

    public PguBancoPago() {
    }

    public PguBancoPago(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public PguBancoPago(Integer idBanco, boolean activo) {
        this.idBanco = idBanco;
        this.activo = activo;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
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
        hash += (idBanco != null ? idBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PguBancoPago)) {
            return false;
        }
        PguBancoPago other = (PguBancoPago) object;
        if ((this.idBanco == null && other.idBanco != null) || (this.idBanco != null && !this.idBanco.equals(other.idBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PguBancoPago[ idBanco=" + idBanco + " ]";
    }
    
}
