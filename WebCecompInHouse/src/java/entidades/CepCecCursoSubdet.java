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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "cep_cec_curso_subdet")
@NamedQueries({
    @NamedQuery(name = "CepCecCursoSubdet.findAll", query = "SELECT c FROM CepCecCursoSubdet c")
    , @NamedQuery(name = "CepCecCursoSubdet.findByIdCursoSubdet", query = "SELECT c FROM CepCecCursoSubdet c WHERE c.idCursoSubdet = :idCursoSubdet")
    , @NamedQuery(name = "CepCecCursoSubdet.findByNumCuotas", query = "SELECT c FROM CepCecCursoSubdet c WHERE c.numCuotas = :numCuotas")
    , @NamedQuery(name = "CepCecCursoSubdet.findByMinAlum", query = "SELECT c FROM CepCecCursoSubdet c WHERE c.minAlum = :minAlum")
    , @NamedQuery(name = "CepCecCursoSubdet.findByMaxAlum", query = "SELECT c FROM CepCecCursoSubdet c WHERE c.maxAlum = :maxAlum")
    , @NamedQuery(name = "CepCecCursoSubdet.findByEstadoDetcur", query = "SELECT c FROM CepCecCursoSubdet c WHERE c.estadoDetcur = :estadoDetcur")
    , @NamedQuery(name = "CepCecCursoSubdet.findByNumClases", query = "SELECT c FROM CepCecCursoSubdet c WHERE c.numClases = :numClases")
    , @NamedQuery(name = "CepCecCursoSubdet.findByFormaPago", query = "SELECT c FROM CepCecCursoSubdet c WHERE c.formaPago = :formaPago")})
public class CepCecCursoSubdet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_curso_subdet")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idCursoSubdet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_cuotas")
    private int numCuotas;
    @Column(name = "min_alum")
    private Integer minAlum;
    @Column(name = "max_alum")
    private Integer maxAlum;
    @Column(name = "estado_detcur")
    private Short estadoDetcur;
    @Column(name = "num_clases")
    private Integer numClases;
    @Column(name = "forma_pago")
    private Integer formaPago;
    @OneToMany(mappedBy = "cepCecCursoSubdet")
    private List<CepCecInversionCurso> cepCecInversionCursoList;
    @JoinColumn(name = "id_curso_det", referencedColumnName = "id_curso_det")
    @ManyToOne(optional = false)
    private CepCecCursoDet cepCecCursoDet;
    @JoinColumn(name = "id_escala", referencedColumnName = "id_escala")
    @ManyToOne
    private CepEscalaTipomod cepEscalaTipomod;
    @JoinColumn(name = "id_tipo_des", referencedColumnName = "id_tipo_des")
    @ManyToOne(optional = false)
    private CepTipoDesarrollo cepTipoDesarrollo;
    @OneToMany( mappedBy = "cepCecCursoSubdet")
    private List<CepCecCurGrup> cepCecCurGrupList;

    public CepCecCursoSubdet() {
    }

    public CepCecCursoSubdet(Integer idCursoSubdet) {
        this.idCursoSubdet = idCursoSubdet;
    }

    public CepCecCursoSubdet(Integer idCursoSubdet, int numCuotas) {
        this.idCursoSubdet = idCursoSubdet;
        this.numCuotas = numCuotas;
    }

    public Integer getIdCursoSubdet() {
        return idCursoSubdet;
    }

    public void setIdCursoSubdet(Integer idCursoSubdet) {
        this.idCursoSubdet = idCursoSubdet;
    }

    public int getNumCuotas() {
        return numCuotas;
    }

    public void setNumCuotas(int numCuotas) {
        this.numCuotas = numCuotas;
    }

    public Integer getMinAlum() {
        return minAlum;
    }

    public void setMinAlum(Integer minAlum) {
        this.minAlum = minAlum;
    }

    public Integer getMaxAlum() {
        return maxAlum;
    }

    public void setMaxAlum(Integer maxAlum) {
        this.maxAlum = maxAlum;
    }

    public Short getEstadoDetcur() {
        return estadoDetcur;
    }

    public void setEstadoDetcur(Short estadoDetcur) {
        this.estadoDetcur = estadoDetcur;
    }

    public Integer getNumClases() {
        return numClases;
    }

    public void setNumClases(Integer numClases) {
        this.numClases = numClases;
    }

    public Integer getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(Integer formaPago) {
        this.formaPago = formaPago;
    }

    public List<CepCecInversionCurso> getCepCecInversionCursoList() {
        return cepCecInversionCursoList;
    }

    public void setCepCecInversionCursoList(List<CepCecInversionCurso> cepCecInversionCursoList) {
        this.cepCecInversionCursoList = cepCecInversionCursoList;
    }

    public CepCecCursoDet getCepCecCursoDet() {
        return cepCecCursoDet;
    }

    public void setCepCecCursoDet(CepCecCursoDet cepCecCursoDet) {
        this.cepCecCursoDet = cepCecCursoDet;
    }

    public CepEscalaTipomod getCepEscalaTipomod() {
        return cepEscalaTipomod;
    }

    public void setCepEscalaTipomod(CepEscalaTipomod cepEscalaTipomod) {
        this.cepEscalaTipomod = cepEscalaTipomod;
    }

    public CepTipoDesarrollo getCepTipoDesarrollo() {
        return cepTipoDesarrollo;
    }

    public void setCepTipoDesarrollo(CepTipoDesarrollo cepTipoDesarrollo) {
        this.cepTipoDesarrollo = cepTipoDesarrollo;
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
        hash += (idCursoSubdet != null ? idCursoSubdet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecCursoSubdet)) {
            return false;
        }
        CepCecCursoSubdet other = (CepCecCursoSubdet) object;
        if ((this.idCursoSubdet == null && other.idCursoSubdet != null) || (this.idCursoSubdet != null && !this.idCursoSubdet.equals(other.idCursoSubdet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecCursoSubdet[ idCursoSubdet=" + idCursoSubdet + " ]";
    }
    
}
