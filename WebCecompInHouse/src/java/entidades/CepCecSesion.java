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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cep_cec_sesion")
@NamedQueries({
    @NamedQuery(name = "CepCecSesion.findAll", query = "SELECT c FROM CepCecSesion c")
    , @NamedQuery(name = "CepCecSesion.findByIdSesion", query = "SELECT c FROM CepCecSesion c WHERE c.idSesion = :idSesion")
    , @NamedQuery(name = "CepCecSesion.findByNomSesion", query = "SELECT c FROM CepCecSesion c WHERE c.nomSesion = :nomSesion")
    , @NamedQuery(name = "CepCecSesion.findByEstadoSesion", query = "SELECT c FROM CepCecSesion c WHERE c.estadoSesion = :estadoSesion")})
public class CepCecSesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sesion")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idSesion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_sesion")
    private String nomSesion;
    @Column(name = "estado_sesion")
    private Short estadoSesion;
    @JoinColumn(name = "id_plan", referencedColumnName = "id_plan")
    @ManyToOne(optional = false)
    private CepCecPlan cepCecPlan;
    @OneToMany( fetch = FetchType.EAGER, mappedBy = "cepCecSesion")
    private List<CepCecTema> cepCecTemaList;

    public CepCecSesion() {
    }

    public CepCecSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public CepCecSesion(Integer idSesion, String nomSesion) {
        this.idSesion = idSesion;
        this.nomSesion = nomSesion;
    }

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public String getNomSesion() {
        return nomSesion;
    }

    public void setNomSesion(String nomSesion) {
        this.nomSesion = nomSesion;
    }

    public Short getEstadoSesion() {
        return estadoSesion;
    }

    public void setEstadoSesion(Short estadoSesion) {
        this.estadoSesion = estadoSesion;
    }

    public CepCecPlan getCepCecPlan() {
        return cepCecPlan;
    }

    public void setCepCecPlan(CepCecPlan cepCecPlan) {
        this.cepCecPlan = cepCecPlan;
    }

    public List<CepCecTema> getCepCecTemaList() {
        return cepCecTemaList;
    }

    public void setCepCecTemaList(List<CepCecTema> cepCecTemaList) {
        this.cepCecTemaList = cepCecTemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSesion != null ? idSesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecSesion)) {
            return false;
        }
        CepCecSesion other = (CepCecSesion) object;
        if ((this.idSesion == null && other.idSesion != null) || (this.idSesion != null && !this.idSesion.equals(other.idSesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecSesion[ idSesion=" + idSesion + " ]";
    }
    
}
