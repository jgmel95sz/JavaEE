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
public class DrtDepartamentoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pais")
    private int idPais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dpto")
    private int idDpto;

    public DrtDepartamentoPK() {
    }

    public DrtDepartamentoPK(int idPais, int idDpto) {
        this.idPais = idPais;
        this.idDpto = idDpto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPais;
        hash += (int) idDpto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrtDepartamentoPK)) {
            return false;
        }
        DrtDepartamentoPK other = (DrtDepartamentoPK) object;
        if (this.idPais != other.idPais) {
            return false;
        }
        if (this.idDpto != other.idDpto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DrtDepartamentoPK[ idPais=" + idPais + ", idDpto=" + idDpto + " ]";
    }
    
}
