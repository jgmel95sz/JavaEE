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
@Table(name = "cep_cec_grupo")
@NamedQueries({
    @NamedQuery(name = "CepCecGrupo.findAll", query = "SELECT c FROM CepCecGrupo c")
    , @NamedQuery(name = "CepCecGrupo.findByIdGrupo", query = "SELECT c FROM CepCecGrupo c WHERE c.idGrupo = :idGrupo")
    , @NamedQuery(name = "CepCecGrupo.findByNomGrupo", query = "SELECT c FROM CepCecGrupo c WHERE c.nomGrupo = :nomGrupo")})
public class CepCecGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_grupo")
    private Integer idGrupo;
    @Size(max = 20)
    @Column(name = "nom_grupo")
    private String nomGrupo;
    @OneToMany( mappedBy = "cepCecGrupo")
    private List<CepCecCurGrup> cepCecCurGrupList;

    public CepCecGrupo() {
    }

    public CepCecGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNomGrupo() {
        return nomGrupo;
    }

    public void setNomGrupo(String nomGrupo) {
        this.nomGrupo = nomGrupo;
    }

    public List<CepCecCurGrup> getCepCecCurGrupList() {
        return cepCecCurGrupList;
    }

    public void setCepCecCurGrupList(List<CepCecCurGrup> cepCecCurGrupList) {
        this.cepCecCurGrupList = cepCecCurGrupList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecGrupo)) {
            return false;
        }
        CepCecGrupo other = (CepCecGrupo) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecGrupo[ idGrupo=" + idGrupo + " ]";
    }
    
}
