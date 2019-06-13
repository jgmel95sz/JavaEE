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
import javax.persistence.GeneratedValue;
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
@Table(name = "cep_horario_dias")
@NamedQueries({
    @NamedQuery(name = "CepHorarioDias.findAll", query = "SELECT c FROM CepHorarioDias c")
    , @NamedQuery(name = "CepHorarioDias.findByIdHorarioDias", query = "SELECT c FROM CepHorarioDias c WHERE c.idHorarioDias = :idHorarioDias")
    , @NamedQuery(name = "CepHorarioDias.findByNomHorarioDias", query = "SELECT c FROM CepHorarioDias c WHERE c.nomHorarioDias = :nomHorarioDias")})
public class CepHorarioDias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_horario_dias")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idHorarioDias;
    @Size(max = 300)
    @Column(name = "nom_horario_dias")
    private String nomHorarioDias;
    @OneToMany( mappedBy = "cepHorarioDias")
    private List<CepCecHorarios> cepCecHorariosList;

    public CepHorarioDias() {
    }

    public CepHorarioDias(Integer idHorarioDias) {
        this.idHorarioDias = idHorarioDias;
    }

    public Integer getIdHorarioDias() {
        return idHorarioDias;
    }

    public void setIdHorarioDias(Integer idHorarioDias) {
        this.idHorarioDias = idHorarioDias;
    }

    public String getNomHorarioDias() {
        return nomHorarioDias;
    }

    public void setNomHorarioDias(String nomHorarioDias) {
        this.nomHorarioDias = nomHorarioDias;
    }

    public List<CepCecHorarios> getCepCecHorariosList() {
        return cepCecHorariosList;
    }

    public void setCepCecHorariosList(List<CepCecHorarios> cepCecHorariosList) {
        this.cepCecHorariosList = cepCecHorariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorarioDias != null ? idHorarioDias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepHorarioDias)) {
            return false;
        }
        CepHorarioDias other = (CepHorarioDias) object;
        if ((this.idHorarioDias == null && other.idHorarioDias != null) || (this.idHorarioDias != null && !this.idHorarioDias.equals(other.idHorarioDias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepHorarioDias[ idHorarioDias=" + idHorarioDias + " ]";
    }
    
}
