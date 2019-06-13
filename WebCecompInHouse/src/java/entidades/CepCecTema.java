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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cep_cec_tema")
@NamedQueries({
    @NamedQuery(name = "CepCecTema.findAll", query = "SELECT c FROM CepCecTema c")
    , @NamedQuery(name = "CepCecTema.findByIdTema", query = "SELECT c FROM CepCecTema c WHERE c.idTema = :idTema")
    , @NamedQuery(name = "CepCecTema.findByNomTema", query = "SELECT c FROM CepCecTema c WHERE c.nomTema = :nomTema")
    , @NamedQuery(name = "CepCecTema.findByEstadoTema", query = "SELECT c FROM CepCecTema c WHERE c.estadoTema = :estadoTema")})
public class CepCecTema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tema")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idTema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_tema")
    private String nomTema;
    @Column(name = "estado_tema")
    private Short estadoTema;
    @JoinColumn(name = "id_sesion", referencedColumnName = "id_sesion")
    @ManyToOne(optional = false)
    private CepCecSesion cepCecSesion;

    public CepCecTema() {
    }

    public CepCecTema(Integer idTema) {
        this.idTema = idTema;
    }

    public CepCecTema(Integer idTema, String nomTema) {
        this.idTema = idTema;
        this.nomTema = nomTema;
    }

    public Integer getIdTema() {
        return idTema;
    }

    public void setIdTema(Integer idTema) {
        this.idTema = idTema;
    }

    public String getNomTema() {
        return nomTema;
    }

    public void setNomTema(String nomTema) {
        this.nomTema = nomTema;
    }

    public Short getEstadoTema() {
        return estadoTema;
    }

    public void setEstadoTema(Short estadoTema) {
        this.estadoTema = estadoTema;
    }

    public CepCecSesion getCepCecSesion() {
        return cepCecSesion;
    }

    public void setCepCecSesion(CepCecSesion cepCecSesion) {
        this.cepCecSesion = cepCecSesion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTema != null ? idTema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecTema)) {
            return false;
        }
        CepCecTema other = (CepCecTema) object;
        if ((this.idTema == null && other.idTema != null) || (this.idTema != null && !this.idTema.equals(other.idTema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecTema[ idTema=" + idTema + " ]";
    }
    
}
