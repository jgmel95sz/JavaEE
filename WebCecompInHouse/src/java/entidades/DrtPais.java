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
@Table(name = "drt_pais")
@NamedQueries({
    @NamedQuery(name = "DrtPais.findAll", query = "SELECT d FROM DrtPais d")
    , @NamedQuery(name = "DrtPais.findByIdPais", query = "SELECT d FROM DrtPais d WHERE d.idPais = :idPais")
    , @NamedQuery(name = "DrtPais.findByNombrePais", query = "SELECT d FROM DrtPais d WHERE d.nombrePais = :nombrePais")
    , @NamedQuery(name = "DrtPais.findByAbreviaturaPais", query = "SELECT d FROM DrtPais d WHERE d.abreviaturaPais = :abreviaturaPais")
    , @NamedQuery(name = "DrtPais.findByCodigoPostal", query = "SELECT d FROM DrtPais d WHERE d.codigoPostal = :codigoPostal")})
public class DrtPais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pais")
    private Integer idPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_pais")
    private String nombrePais;
    @Size(max = 10)
    @Column(name = "abreviatura_pais")
    private String abreviaturaPais;
    @Size(max = 10)
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @OneToMany( mappedBy = "drtPais")
    private List<DrtDepartamento> drtDepartamentoList;

    public DrtPais() {
    }

    public DrtPais(Integer idPais) {
        this.idPais = idPais;
    }

    public DrtPais(Integer idPais, String nombrePais) {
        this.idPais = idPais;
        this.nombrePais = nombrePais;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getAbreviaturaPais() {
        return abreviaturaPais;
    }

    public void setAbreviaturaPais(String abreviaturaPais) {
        this.abreviaturaPais = abreviaturaPais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public List<DrtDepartamento> getDrtDepartamentoList() {
        return drtDepartamentoList;
    }

    public void setDrtDepartamentoList(List<DrtDepartamento> drtDepartamentoList) {
        this.drtDepartamentoList = drtDepartamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPais != null ? idPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrtPais)) {
            return false;
        }
        DrtPais other = (DrtPais) object;
        if ((this.idPais == null && other.idPais != null) || (this.idPais != null && !this.idPais.equals(other.idPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DrtPais[ idPais=" + idPais + " ]";
    }
    
}
