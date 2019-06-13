/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "org_dependencia")
@NamedQueries({
    @NamedQuery(name = "OrgDependencia.findAll", query = "SELECT o FROM OrgDependencia o")
    , @NamedQuery(name = "OrgDependencia.findByIdDep", query = "SELECT o FROM OrgDependencia o WHERE o.idDep = :idDep")
    , @NamedQuery(name = "OrgDependencia.findByIdOrg", query = "SELECT o FROM OrgDependencia o WHERE o.idOrg = :idOrg")
    , @NamedQuery(name = "OrgDependencia.findByIdDepTipo", query = "SELECT o FROM OrgDependencia o WHERE o.idDepTipo = :idDepTipo")
    , @NamedQuery(name = "OrgDependencia.findByOrgIdDep", query = "SELECT o FROM OrgDependencia o WHERE o.orgIdDep = :orgIdDep")
    , @NamedQuery(name = "OrgDependencia.findByIdDtra", query = "SELECT o FROM OrgDependencia o WHERE o.idDtra = :idDtra")
    , @NamedQuery(name = "OrgDependencia.findByNombreDep", query = "SELECT o FROM OrgDependencia o WHERE o.nombreDep = :nombreDep")
    , @NamedQuery(name = "OrgDependencia.findByDescDep", query = "SELECT o FROM OrgDependencia o WHERE o.descDep = :descDep")
    , @NamedQuery(name = "OrgDependencia.findByFechaReg", query = "SELECT o FROM OrgDependencia o WHERE o.fechaReg = :fechaReg")
    , @NamedQuery(name = "OrgDependencia.findByDepEstado", query = "SELECT o FROM OrgDependencia o WHERE o.depEstado = :depEstado")
    , @NamedQuery(name = "OrgDependencia.findByAbreviaDep", query = "SELECT o FROM OrgDependencia o WHERE o.abreviaDep = :abreviaDep")
    , @NamedQuery(name = "OrgDependencia.findByTmp", query = "SELECT o FROM OrgDependencia o WHERE o.tmp = :tmp")
    , @NamedQuery(name = "OrgDependencia.findByJerarqDep", query = "SELECT o FROM OrgDependencia o WHERE o.jerarqDep = :jerarqDep")
    , @NamedQuery(name = "OrgDependencia.findByCodigoDep", query = "SELECT o FROM OrgDependencia o WHERE o.codigoDep = :codigoDep")
    , @NamedQuery(name = "OrgDependencia.findByEmail", query = "SELECT o FROM OrgDependencia o WHERE o.email = :email")
    , @NamedQuery(name = "OrgDependencia.findByTelefono1", query = "SELECT o FROM OrgDependencia o WHERE o.telefono1 = :telefono1")
    , @NamedQuery(name = "OrgDependencia.findByTelefono2", query = "SELECT o FROM OrgDependencia o WHERE o.telefono2 = :telefono2")
    , @NamedQuery(name = "OrgDependencia.findByAnexo", query = "SELECT o FROM OrgDependencia o WHERE o.anexo = :anexo")
    , @NamedQuery(name = "OrgDependencia.findByIdUbi", query = "SELECT o FROM OrgDependencia o WHERE o.idUbi = :idUbi")
    , @NamedQuery(name = "OrgDependencia.findBySitioweb", query = "SELECT o FROM OrgDependencia o WHERE o.sitioweb = :sitioweb")
    , @NamedQuery(name = "OrgDependencia.findBySubdep", query = "SELECT o FROM OrgDependencia o WHERE o.subdep = :subdep")})
public class OrgDependencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dep")
    private Integer idDep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_org")
    private int idOrg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dep_tipo")
    private int idDepTipo;
    @Column(name = "org_id_dep")
    private Integer orgIdDep;
    @Column(name = "id_dtra")
    private Integer idDtra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_dep")
    private String nombreDep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "desc_dep")
    private String descDep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "dep_estado")
    private String depEstado;
    @Size(max = 50)
    @Column(name = "abrevia_dep")
    private String abreviaDep;
    @Size(max = 2)
    @Column(name = "tmp")
    private String tmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "jerarq_dep")
    private String jerarqDep;
    @Column(name = "codigo_dep")
    private Integer codigoDep;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 8)
    @Column(name = "telefono1")
    private String telefono1;
    @Size(max = 8)
    @Column(name = "telefono2")
    private String telefono2;
    @Size(max = 4)
    @Column(name = "anexo")
    private String anexo;
    @Column(name = "id_ubi")
    private Integer idUbi;
    @Size(max = 100)
    @Column(name = "sitioweb")
    private String sitioweb;
    @Size(max = 3)
    @Column(name = "subdep")
    private String subdep;
    @OneToMany(mappedBy = "orgDependencia")
    private List<PguTipoPagos> pguTipoPagosList;

    public OrgDependencia() {
    }

    public OrgDependencia(Integer idDep) {
        this.idDep = idDep;
    }

    public OrgDependencia(Integer idDep, int idOrg, int idDepTipo, String nombreDep, String descDep, Date fechaReg, String depEstado, String jerarqDep) {
        this.idDep = idDep;
        this.idOrg = idOrg;
        this.idDepTipo = idDepTipo;
        this.nombreDep = nombreDep;
        this.descDep = descDep;
        this.fechaReg = fechaReg;
        this.depEstado = depEstado;
        this.jerarqDep = jerarqDep;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public int getIdOrg() {
        return idOrg;
    }

    public void setIdOrg(int idOrg) {
        this.idOrg = idOrg;
    }

    public int getIdDepTipo() {
        return idDepTipo;
    }

    public void setIdDepTipo(int idDepTipo) {
        this.idDepTipo = idDepTipo;
    }

    public Integer getOrgIdDep() {
        return orgIdDep;
    }

    public void setOrgIdDep(Integer orgIdDep) {
        this.orgIdDep = orgIdDep;
    }

    public Integer getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(Integer idDtra) {
        this.idDtra = idDtra;
    }

    public String getNombreDep() {
        return nombreDep;
    }

    public void setNombreDep(String nombreDep) {
        this.nombreDep = nombreDep;
    }

    public String getDescDep() {
        return descDep;
    }

    public void setDescDep(String descDep) {
        this.descDep = descDep;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getDepEstado() {
        return depEstado;
    }

    public void setDepEstado(String depEstado) {
        this.depEstado = depEstado;
    }

    public String getAbreviaDep() {
        return abreviaDep;
    }

    public void setAbreviaDep(String abreviaDep) {
        this.abreviaDep = abreviaDep;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public String getJerarqDep() {
        return jerarqDep;
    }

    public void setJerarqDep(String jerarqDep) {
        this.jerarqDep = jerarqDep;
    }

    public Integer getCodigoDep() {
        return codigoDep;
    }

    public void setCodigoDep(Integer codigoDep) {
        this.codigoDep = codigoDep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public Integer getIdUbi() {
        return idUbi;
    }

    public void setIdUbi(Integer idUbi) {
        this.idUbi = idUbi;
    }

    public String getSitioweb() {
        return sitioweb;
    }

    public void setSitioweb(String sitioweb) {
        this.sitioweb = sitioweb;
    }

    public String getSubdep() {
        return subdep;
    }

    public void setSubdep(String subdep) {
        this.subdep = subdep;
    }

    public List<PguTipoPagos> getPguTipoPagosList() {
        return pguTipoPagosList;
    }

    public void setPguTipoPagosList(List<PguTipoPagos> pguTipoPagosList) {
        this.pguTipoPagosList = pguTipoPagosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDep != null ? idDep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrgDependencia)) {
            return false;
        }
        OrgDependencia other = (OrgDependencia) object;
        if ((this.idDep == null && other.idDep != null) || (this.idDep != null && !this.idDep.equals(other.idDep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.OrgDependencia[ idDep=" + idDep + " ]";
    }
    
}
