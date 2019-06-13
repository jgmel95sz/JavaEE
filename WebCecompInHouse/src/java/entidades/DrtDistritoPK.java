/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Melvin
 */
@Embeddable
public class DrtDistritoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pais")
    private int idPais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dpto")
    private int idDpto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prov")
    private int idProv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_distrito")
    private int idDistrito;

    public DrtDistritoPK() {
    }

    public DrtDistritoPK(int idPais, int idDpto, int idProv, int idDistrito) {
        this.idPais = idPais;
        this.idDpto = idDpto;
        this.idProv = idProv;
        this.idDistrito = idDistrito;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(int idDpto) {
        this.idDpto = idDpto;
    }

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPais;
        hash += (int) idDpto;
        hash += (int) idProv;
        hash += (int) idDistrito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrtDistritoPK)) {
            return false;
        }
        DrtDistritoPK other = (DrtDistritoPK) object;
        if (this.idPais != other.idPais) {
            return false;
        }
        if (this.idDpto != other.idDpto) {
            return false;
        }
        if (this.idProv != other.idProv) {
            return false;
        }
        if (this.idDistrito != other.idDistrito) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DrtDistritoPK[ idPais=" + idPais + ", idDpto=" + idDpto + ", idProv=" + idProv + ", idDistrito=" + idDistrito + " ]";
    }
    
}
