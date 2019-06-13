/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
//import java.math.Float;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "pgu_modalidad_tipospagos")
@NamedQueries({
    @NamedQuery(name = "PguModalidadTipospagos.findAll", query = "SELECT p FROM PguModalidadTipospagos p")
    , @NamedQuery(name = "PguModalidadTipospagos.findByIdModltipo", query = "SELECT p FROM PguModalidadTipospagos p WHERE p.idModltipo = :idModltipo")
    , @NamedQuery(name = "PguModalidadTipospagos.findByDescripcion", query = "SELECT p FROM PguModalidadTipospagos p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "PguModalidadTipospagos.findByNroPartes", query = "SELECT p FROM PguModalidadTipospagos p WHERE p.nroPartes = :nroPartes")
    , @NamedQuery(name = "PguModalidadTipospagos.findByMontoPagar", query = "SELECT p FROM PguModalidadTipospagos p WHERE p.montoPagar = :montoPagar")
    , @NamedQuery(name = "PguModalidadTipospagos.findByNrodiasMora", query = "SELECT p FROM PguModalidadTipospagos p WHERE p.nrodiasMora = :nrodiasMora")
    , @NamedQuery(name = "PguModalidadTipospagos.findByMontoMora", query = "SELECT p FROM PguModalidadTipospagos p WHERE p.montoMora = :montoMora")
    , @NamedQuery(name = "PguModalidadTipospagos.findByInteres", query = "SELECT p FROM PguModalidadTipospagos p WHERE p.interes = :interes")
    , @NamedQuery(name = "PguModalidadTipospagos.findByActivo", query = "SELECT p FROM PguModalidadTipospagos p WHERE p.activo = :activo")})
public class PguModalidadTipospagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_modltipo")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idModltipo;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nro_partes")
    private Float nroPartes;
    @Column(name = "monto_pagar")
    private Float montoPagar;
    @Column(name = "nrodias_mora")
    private Short nrodiasMora;
    @Column(name = "monto_mora")
    private Float montoMora;
    @Column(name = "interes")
    private Float interes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "id_modld", referencedColumnName = "id_modld")
    @ManyToOne
    private PguModalidad pguModalidad;
    @JoinColumn(name = "id_tipopag", referencedColumnName = "id_tipopag")
    @ManyToOne
    private PguTipoPagos pguTipoPagos;
    @OneToMany(mappedBy = "pguModalidadTipospagos")
    private List<PguPagospersDet> pguPagospersDetList;

    public PguModalidadTipospagos() {
    }

    public PguModalidadTipospagos(Integer idModltipo) {
        this.idModltipo = idModltipo;
    }

    public PguModalidadTipospagos(Integer idModltipo, boolean activo) {
        this.idModltipo = idModltipo;
        this.activo = activo;
    }

    public Integer getIdModltipo() {
        return idModltipo;
    }

    public void setIdModltipo(Integer idModltipo) {
        this.idModltipo = idModltipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getNroPartes() {
        return nroPartes;
    }

    public void setNroPartes(Float nroPartes) {
        this.nroPartes = nroPartes;
    }

    public Float getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(Float montoPagar) {
        this.montoPagar = montoPagar;
    }

    public Short getNrodiasMora() {
        return nrodiasMora;
    }

    public void setNrodiasMora(Short nrodiasMora) {
        this.nrodiasMora = nrodiasMora;
    }

    public Float getMontoMora() {
        return montoMora;
    }

    public void setMontoMora(Float montoMora) {
        this.montoMora = montoMora;
    }

    public Float getInteres() {
        return interes;
    }

    public void setInteres(Float interes) {
        this.interes = interes;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public PguModalidad getPguModalidad() {
        return pguModalidad;
    }

    public void setPguModalidad(PguModalidad pguModalidad) {
        this.pguModalidad = pguModalidad;
    }

    public PguTipoPagos getPguTipoPagos() {
        return pguTipoPagos;
    }

    public void setPguTipoPagos(PguTipoPagos pguTipoPagos) {
        this.pguTipoPagos = pguTipoPagos;
    }

    public List<PguPagospersDet> getPguPagospersDetList() {
        return pguPagospersDetList;
    }

    public void setPguPagospersDetList(List<PguPagospersDet> pguPagospersDetList) {
        this.pguPagospersDetList = pguPagospersDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModltipo != null ? idModltipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PguModalidadTipospagos)) {
            return false;
        }
        PguModalidadTipospagos other = (PguModalidadTipospagos) object;
        if ((this.idModltipo == null && other.idModltipo != null) || (this.idModltipo != null && !this.idModltipo.equals(other.idModltipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PguModalidadTipospagos[ idModltipo=" + idModltipo + " ]";
    }
    
}
