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
@Table(name = "cep_nivel")
@NamedQueries({
    @NamedQuery(name = "CepNivel.findAll", query = "SELECT c FROM CepNivel c")
    , @NamedQuery(name = "CepNivel.findByIdNivel", query = "SELECT c FROM CepNivel c WHERE c.idNivel = :idNivel")
    , @NamedQuery(name = "CepNivel.findByNumCepNivel", query = "SELECT c FROM CepNivel c WHERE c.numCepNivel = :numCepNivel")
    , @NamedQuery(name = "CepNivel.findByNombreNivel", query = "SELECT c FROM CepNivel c WHERE c.nombreNivel = :nombreNivel")
    , @NamedQuery(name = "CepNivel.findByNomAbrevNivel", query = "SELECT c FROM CepNivel c WHERE c.nomAbrevNivel = :nomAbrevNivel")})
public class CepNivel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel")
    private Integer idNivel;
    @Column(name = "num_cep_nivel")
    private Integer numCepNivel;
    @Size(max = 20)
    @Column(name = "nombre_nivel")
    private String nombreNivel;
    @Size(max = 20)
    @Column(name = "nom_abrev_nivel")
    private String nomAbrevNivel;
    @OneToMany(mappedBy = "cepNivel")
    private List<CepCecCursoDet> cepCecCursoDetList;

    public CepNivel() {
    }

    public CepNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Integer getNumCepNivel() {
        return numCepNivel;
    }

    public void setNumCepNivel(Integer numCepNivel) {
        this.numCepNivel = numCepNivel;
    }

    public String getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }

    public String getNomAbrevNivel() {
        return nomAbrevNivel;
    }

    public void setNomAbrevNivel(String nomAbrevNivel) {
        this.nomAbrevNivel = nomAbrevNivel;
    }

    public List<CepCecCursoDet> getCepCecCursoDetList() {
        return cepCecCursoDetList;
    }

    public void setCepCecCursoDetList(List<CepCecCursoDet> cepCecCursoDetList) {
        this.cepCecCursoDetList = cepCecCursoDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepNivel)) {
            return false;
        }
        CepNivel other = (CepNivel) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepNivel[ idNivel=" + idNivel + " ]";
    }
    
}
