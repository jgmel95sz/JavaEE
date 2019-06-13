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
@Table(name = "cep_aula_class")
@NamedQueries({
    @NamedQuery(name = "CepAulaClass.findAll", query = "SELECT c FROM CepAulaClass c")
    , @NamedQuery(name = "CepAulaClass.findByIdAulClass", query = "SELECT c FROM CepAulaClass c WHERE c.idAulClass = :idAulClass")
    , @NamedQuery(name = "CepAulaClass.findByPiso", query = "SELECT c FROM CepAulaClass c WHERE c.piso = :piso")
    , @NamedQuery(name = "CepAulaClass.findByLugar", query = "SELECT c FROM CepAulaClass c WHERE c.lugar = :lugar")
    , @NamedQuery(name = "CepAulaClass.findByNomAula", query = "SELECT c FROM CepAulaClass c WHERE c.nomAula = :nomAula")
    , @NamedQuery(name = "CepAulaClass.findByCondicion", query = "SELECT c FROM CepAulaClass c WHERE c.condicion = :condicion")
    , @NamedQuery(name = "CepAulaClass.findByIdDep", query = "SELECT c FROM CepAulaClass c WHERE c.idDep = :idDep")
    , @NamedQuery(name = "CepAulaClass.findByNumAlu", query = "SELECT c FROM CepAulaClass c WHERE c.numAlu = :numAlu")})
public class CepAulaClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_aul_class")
    private Integer idAulClass;
    @Column(name = "piso")
    private Integer piso;
    @Size(max = 50)
    @Column(name = "lugar")
    private String lugar;
    @Size(max = 50)
    @Column(name = "nom_aula")
    private String nomAula;
    @Column(name = "condicion")
    private Character condicion;
    @Column(name = "id_dep")
    private Integer idDep;
    @Column(name = "num_alu")
    private Integer numAlu;
    @OneToMany(mappedBy = "cepAulaClass")
    private List<CepCecCurGrupDet> cepCecCurGrupDetList;

    public CepAulaClass() {
    }

    public CepAulaClass(Integer idAulClass) {
        this.idAulClass = idAulClass;
    }

    public Integer getIdAulClass() {
        return idAulClass;
    }

    public void setIdAulClass(Integer idAulClass) {
        this.idAulClass = idAulClass;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNomAula() {
        return nomAula;
    }

    public void setNomAula(String nomAula) {
        this.nomAula = nomAula;
    }

    public Character getCondicion() {
        return condicion;
    }

    public void setCondicion(Character condicion) {
        this.condicion = condicion;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public Integer getNumAlu() {
        return numAlu;
    }

    public void setNumAlu(Integer numAlu) {
        this.numAlu = numAlu;
    }

    public List<CepCecCurGrupDet> getCepCecCurGrupDetList() {
        return cepCecCurGrupDetList;
    }

    public void setCepCecCurGrupDetList(List<CepCecCurGrupDet> cepCecCurGrupDetList) {
        this.cepCecCurGrupDetList = cepCecCurGrupDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAulClass != null ? idAulClass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepAulaClass)) {
            return false;
        }
        CepAulaClass other = (CepAulaClass) object;
        if ((this.idAulClass == null && other.idAulClass != null) || (this.idAulClass != null && !this.idAulClass.equals(other.idAulClass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepAulaClass[ idAulClass=" + idAulClass + " ]";
    }
    
}
