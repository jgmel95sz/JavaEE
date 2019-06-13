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
import javax.persistence.JoinColumns;
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
@Table(name = "drt_provincia")
@NamedQueries({
    @NamedQuery(name = "DrtProvincia.findAll", query = "SELECT d FROM DrtProvincia d")
    , @NamedQuery(name = "DrtProvincia.findByIdPais", query = "SELECT d FROM DrtProvincia d WHERE d.drtProvinciaPK.idPais = :idPais")
    , @NamedQuery(name = "DrtProvincia.findByIdDpto", query = "SELECT d FROM DrtProvincia d WHERE d.drtProvinciaPK.idDpto = :idDpto")
    , @NamedQuery(name = "DrtProvincia.findByIdProv", query = "SELECT d FROM DrtProvincia d WHERE d.drtProvinciaPK.idProv = :idProv")
    , @NamedQuery(name = "DrtProvincia.findByNombreProv", query = "SELECT d FROM DrtProvincia d WHERE d.nombreProv = :nombreProv")
    , @NamedQuery(name = "DrtProvincia.findByAbreviaturaProv", query = "SELECT d FROM DrtProvincia d WHERE d.abreviaturaProv = :abreviaturaProv")
    , @NamedQuery(name = "DrtProvincia.findByCodigoProv", query = "SELECT d FROM DrtProvincia d WHERE d.codigoProv = :codigoProv")
    , @NamedQuery(name = "DrtProvincia.findByIdProvI", query = "SELECT d FROM DrtProvincia d WHERE d.idProvI = :idProvI")})
public class DrtProvincia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DrtProvinciaPK drtProvinciaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_prov")
    private String nombreProv;
    @Size(max = 30)
    @Column(name = "abreviatura_prov")
    private String abreviaturaProv;
    @Size(max = 4)
    @Column(name = "codigo_prov")
    private String codigoProv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prov_i")
    private int idProvI;
    @OneToMany(mappedBy = "drtProvincia")
    private List<DrtDistrito> drtDistritoList;
    @JoinColumns({
        @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", insertable = false, updatable = false)
        , @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private DrtDepartamento drtDepartamento;

    public DrtProvincia() {
    }

    public DrtProvincia(DrtProvinciaPK drtProvinciaPK) {
        this.drtProvinciaPK = drtProvinciaPK;
    }

    public DrtProvincia(DrtProvinciaPK drtProvinciaPK, String nombreProv, int idProvI) {
        this.drtProvinciaPK = drtProvinciaPK;
        this.nombreProv = nombreProv;
        this.idProvI = idProvI;
    }

    public DrtProvincia(int idPais, int idDpto, int idProv) {
        this.drtProvinciaPK = new DrtProvinciaPK(idPais, idDpto, idProv);
    }

    public DrtProvinciaPK getDrtProvinciaPK() {
        return drtProvinciaPK;
    }

    public void setDrtProvinciaPK(DrtProvinciaPK drtProvinciaPK) {
        this.drtProvinciaPK = drtProvinciaPK;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public String getAbreviaturaProv() {
        return abreviaturaProv;
    }

    public void setAbreviaturaProv(String abreviaturaProv) {
        this.abreviaturaProv = abreviaturaProv;
    }

    public String getCodigoProv() {
        return codigoProv;
    }

    public void setCodigoProv(String codigoProv) {
        this.codigoProv = codigoProv;
    }

    public int getIdProvI() {
        return idProvI;
    }

    public void setIdProvI(int idProvI) {
        this.idProvI = idProvI;
    }

    public List<DrtDistrito> getDrtDistritoList() {
        return drtDistritoList;
    }

    public void setDrtDistritoList(List<DrtDistrito> drtDistritoList) {
        this.drtDistritoList = drtDistritoList;
    }

    public DrtDepartamento getDrtDepartamento() {
        return drtDepartamento;
    }

    public void setDrtDepartamento(DrtDepartamento drtDepartamento) {
        this.drtDepartamento = drtDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drtProvinciaPK != null ? drtProvinciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrtProvincia)) {
            return false;
        }
        DrtProvincia other = (DrtProvincia) object;
        if ((this.drtProvinciaPK == null && other.drtProvinciaPK != null) || (this.drtProvinciaPK != null && !this.drtProvinciaPK.equals(other.drtProvinciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DrtProvincia[ drtProvinciaPK=" + drtProvinciaPK + " ]";
    }
    
}
