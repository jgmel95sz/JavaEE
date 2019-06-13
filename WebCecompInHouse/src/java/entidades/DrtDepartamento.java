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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "drt_departamento")
@NamedQueries({
    @NamedQuery(name = "DrtDepartamento.findAll", query = "SELECT d FROM DrtDepartamento d")
    , @NamedQuery(name = "DrtDepartamento.findByIdPais", query = "SELECT d FROM DrtDepartamento d WHERE d.drtDepartamentoPK.idPais = :idPais")
    , @NamedQuery(name = "DrtDepartamento.findByIdDpto", query = "SELECT d FROM DrtDepartamento d WHERE d.drtDepartamentoPK.idDpto = :idDpto")
    , @NamedQuery(name = "DrtDepartamento.findByNombreDpto", query = "SELECT d FROM DrtDepartamento d WHERE d.nombreDpto = :nombreDpto")
    , @NamedQuery(name = "DrtDepartamento.findByAbreviaturaDpto", query = "SELECT d FROM DrtDepartamento d WHERE d.abreviaturaDpto = :abreviaturaDpto")
    , @NamedQuery(name = "DrtDepartamento.findByCodigoDpto", query = "SELECT d FROM DrtDepartamento d WHERE d.codigoDpto = :codigoDpto")})
public class DrtDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DrtDepartamentoPK drtDepartamentoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_dpto")
    private String nombreDpto;
    @Size(max = 20)
    @Column(name = "abreviatura_dpto")
    private String abreviaturaDpto;
    @Size(max = 2)
    @Column(name = "codigo_dpto")
    private String codigoDpto;
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DrtPais drtPais;
    @OneToMany(mappedBy = "drtDepartamento")
    private List<DrtProvincia> drtProvinciaList;

    public DrtDepartamento() {
    }

    public DrtDepartamento(DrtDepartamentoPK drtDepartamentoPK) {
        this.drtDepartamentoPK = drtDepartamentoPK;
    }

    public DrtDepartamento(DrtDepartamentoPK drtDepartamentoPK, String nombreDpto) {
        this.drtDepartamentoPK = drtDepartamentoPK;
        this.nombreDpto = nombreDpto;
    }

    public DrtDepartamento(int idPais, int idDpto) {
        this.drtDepartamentoPK = new DrtDepartamentoPK(idPais, idDpto);
    }

    public DrtDepartamentoPK getDrtDepartamentoPK() {
        return drtDepartamentoPK;
    }

    public void setDrtDepartamentoPK(DrtDepartamentoPK drtDepartamentoPK) {
        this.drtDepartamentoPK = drtDepartamentoPK;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public void setNombreDpto(String nombreDpto) {
        this.nombreDpto = nombreDpto;
    }

    public String getAbreviaturaDpto() {
        return abreviaturaDpto;
    }

    public void setAbreviaturaDpto(String abreviaturaDpto) {
        this.abreviaturaDpto = abreviaturaDpto;
    }

    public String getCodigoDpto() {
        return codigoDpto;
    }

    public void setCodigoDpto(String codigoDpto) {
        this.codigoDpto = codigoDpto;
    }

    public DrtPais getDrtPais() {
        return drtPais;
    }

    public void setDrtPais(DrtPais drtPais) {
        this.drtPais = drtPais;
    }

    public List<DrtProvincia> getDrtProvinciaList() {
        return drtProvinciaList;
    }

    public void setDrtProvinciaList(List<DrtProvincia> drtProvinciaList) {
        this.drtProvinciaList = drtProvinciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drtDepartamentoPK != null ? drtDepartamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrtDepartamento)) {
            return false;
        }
        DrtDepartamento other = (DrtDepartamento) object;
        if ((this.drtDepartamentoPK == null && other.drtDepartamentoPK != null) || (this.drtDepartamentoPK != null && !this.drtDepartamentoPK.equals(other.drtDepartamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DrtDepartamento[ drtDepartamentoPK=" + drtDepartamentoPK + " ]";
    }
    
}
