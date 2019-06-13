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
@Table(name = "drt_distrito")
@NamedQueries({
    @NamedQuery(name = "DrtDistrito.findAll", query = "SELECT d FROM DrtDistrito d")
    , @NamedQuery(name = "DrtDistrito.findByIdPais", query = "SELECT d FROM DrtDistrito d WHERE d.drtDistritoPK.idPais = :idPais")
    , @NamedQuery(name = "DrtDistrito.findByIdDpto", query = "SELECT d FROM DrtDistrito d WHERE d.drtDistritoPK.idDpto = :idDpto")
    , @NamedQuery(name = "DrtDistrito.findByIdProv", query = "SELECT d FROM DrtDistrito d WHERE d.drtDistritoPK.idProv = :idProv")
    , @NamedQuery(name = "DrtDistrito.findByIdDistrito", query = "SELECT d FROM DrtDistrito d WHERE d.drtDistritoPK.idDistrito = :idDistrito")
    , @NamedQuery(name = "DrtDistrito.findByNombreDist", query = "SELECT d FROM DrtDistrito d WHERE d.nombreDist = :nombreDist")
    , @NamedQuery(name = "DrtDistrito.findByAbreviaturaDist", query = "SELECT d FROM DrtDistrito d WHERE d.abreviaturaDist = :abreviaturaDist")
    , @NamedQuery(name = "DrtDistrito.findByIdUbg", query = "SELECT d FROM DrtDistrito d WHERE d.idUbg = :idUbg")
    , @NamedQuery(name = "DrtDistrito.findByCodigoDist", query = "SELECT d FROM DrtDistrito d WHERE d.codigoDist = :codigoDist")
    , @NamedQuery(name = "DrtDistrito.findByUbigeoActualizado", query = "SELECT d FROM DrtDistrito d WHERE d.ubigeoActualizado = :ubigeoActualizado")})
public class DrtDistrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DrtDistritoPK drtDistritoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_dist")
    private String nombreDist;
    @Size(max = 50)
    @Column(name = "abreviatura_dist")
    private String abreviaturaDist;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ubg")
    private int idUbg;
    @Size(max = 6)
    @Column(name = "codigo_dist")
    private String codigoDist;
    @Size(max = 6)
    @Column(name = "ubigeo_actualizado")
    private String ubigeoActualizado;
    @JoinColumns({
        @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", insertable = false, updatable = false)
        , @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto", insertable = false, updatable = false)
        , @JoinColumn(name = "id_prov", referencedColumnName = "id_prov", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private DrtProvincia drtProvincia;
    @OneToMany(mappedBy = "drtDistrito")
    private List<DrtPersonanatural> drtPersonanaturalList;
    @OneToMany(mappedBy = "drtDistrito1")
    private List<DrtPersonanatural> drtPersonanaturalList1;

    public DrtDistrito() {
    }

    public DrtDistrito(DrtDistritoPK drtDistritoPK) {
        this.drtDistritoPK = drtDistritoPK;
    }

    public DrtDistrito(DrtDistritoPK drtDistritoPK, String nombreDist, int idUbg) {
        this.drtDistritoPK = drtDistritoPK;
        this.nombreDist = nombreDist;
        this.idUbg = idUbg;
    }

    public DrtDistrito(int idPais, int idDpto, int idProv, int idDistrito) {
        this.drtDistritoPK = new DrtDistritoPK(idPais, idDpto, idProv, idDistrito);
    }

    public DrtDistritoPK getDrtDistritoPK() {
        return drtDistritoPK;
    }

    public void setDrtDistritoPK(DrtDistritoPK drtDistritoPK) {
        this.drtDistritoPK = drtDistritoPK;
    }

    public String getNombreDist() {
        return nombreDist;
    }

    public void setNombreDist(String nombreDist) {
        this.nombreDist = nombreDist;
    }

    public String getAbreviaturaDist() {
        return abreviaturaDist;
    }

    public void setAbreviaturaDist(String abreviaturaDist) {
        this.abreviaturaDist = abreviaturaDist;
    }

    public int getIdUbg() {
        return idUbg;
    }

    public void setIdUbg(int idUbg) {
        this.idUbg = idUbg;
    }

    public String getCodigoDist() {
        return codigoDist;
    }

    public void setCodigoDist(String codigoDist) {
        this.codigoDist = codigoDist;
    }

    public String getUbigeoActualizado() {
        return ubigeoActualizado;
    }

    public void setUbigeoActualizado(String ubigeoActualizado) {
        this.ubigeoActualizado = ubigeoActualizado;
    }

    public DrtProvincia getDrtProvincia() {
        return drtProvincia;
    }

    public void setDrtProvincia(DrtProvincia drtProvincia) {
        this.drtProvincia = drtProvincia;
    }

    public List<DrtPersonanatural> getDrtPersonanaturalList() {
        return drtPersonanaturalList;
    }

    public void setDrtPersonanaturalList(List<DrtPersonanatural> drtPersonanaturalList) {
        this.drtPersonanaturalList = drtPersonanaturalList;
    }

    public List<DrtPersonanatural> getDrtPersonanaturalList1() {
        return drtPersonanaturalList1;
    }

    public void setDrtPersonanaturalList1(List<DrtPersonanatural> drtPersonanaturalList1) {
        this.drtPersonanaturalList1 = drtPersonanaturalList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drtDistritoPK != null ? drtDistritoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrtDistrito)) {
            return false;
        }
        DrtDistrito other = (DrtDistrito) object;
        if ((this.drtDistritoPK == null && other.drtDistritoPK != null) || (this.drtDistritoPK != null && !this.drtDistritoPK.equals(other.drtDistritoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DrtDistrito[ drtDistritoPK=" + drtDistritoPK + " ]";
    }
    
}
